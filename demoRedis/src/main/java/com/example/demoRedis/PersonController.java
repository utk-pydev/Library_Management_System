package com.example.demoRedis;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.usertype.LoggableUserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
public class PersonController {

    private static final String PERSON_KEY_PREFIX = "per::";
    private static final String PERSON_LIST_KEY = "per_list";
    private static final String PERSON_HASH_KEY_PREFIX = "per_hash::";

    @Autowired
    RedisTemplate<String, Object>redisTemplate;

    @Autowired
    ObjectMapper objectMapper;
    @PostMapping("/string/person")
    public void savePerson(@RequestBody Person person) {
        if (person.getId() == 0) {
            return;
        }
        String key = getKey(person.getId());
        redisTemplate.opsForValue().set(key, person);
    }

    @GetMapping("/string/person")
    public ResponseEntity<Object> getPerson(@RequestBody Person person, @RequestParam("id") long id){
        String key = getKey(id);
        Object p =  redisTemplate.opsForValue().get(key);
        System.out.println(person.getName());
        if(p != null){
           return ResponseEntity.ok(p);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    private String getKey(long id){
        return PERSON_KEY_PREFIX+id;
    }


    @PostMapping("/lpush/person")
    public void lpush(@RequestBody Person person){
        redisTemplate.opsForList().leftPush(PERSON_LIST_KEY, person);
    }
    @PostMapping("/rpush/person")
    public void rpush(@RequestBody Person person){
        redisTemplate.opsForList().rightPush(PERSON_LIST_KEY, person);
    }
    @DeleteMapping("/lpop/person")
    public List<Person> lpop(@RequestParam(value = "count", required = false, defaultValue = "1")int count){
       return Objects.requireNonNull(redisTemplate.opsForList()
                       .leftPop(PERSON_LIST_KEY, count))
               .stream()
               .map(x->(Person)x)
               .collect(Collectors.toList());
    }
    @DeleteMapping("/rpop/person")
    public List<Object> rpop(@RequestParam(value = "count", required = false, defaultValue = "1")int count){
        return new ArrayList<>(Objects.requireNonNull(redisTemplate.opsForList()
                .rightPop(PERSON_LIST_KEY, count)));
    }

    @GetMapping("/lrange/person")
    public List<Object> lrange(@RequestParam(value = "start", required = false, defaultValue = "0")int start,
                               @RequestParam(value = "end", required = false, defaultValue = "-1")int end){

        System.out.println(start+" "+end);
        return new ArrayList<>(Objects.requireNonNull(redisTemplate.opsForList()
                .range(PERSON_LIST_KEY, start, end)));
    }

    private String getHashKey(long id){
        return PERSON_HASH_KEY_PREFIX+id;
    }

    @PostMapping("/hash/person")
    public void savePersonInHash(@RequestBody List<Person>people){
        people.stream()
                .filter(person -> person.getId() != 0)
                .forEach(person -> {
                    Map map = objectMapper.convertValue(person, Map.class);
                    redisTemplate.opsForHash().putAll(getHashKey(person.getId()), map);
                    redisTemplate.expire(getHashKey(person.getId()), Duration.ofHours(24))
                });
    }

    @GetMapping("/hash/person/all")
public List<Person> getPeople(@RequestParam("ids") List<Long> peopleIds){
        return peopleIds.stream()
                .map(i->redisTemplate.opsForHash().entries(getHashKey(i)))
                .map(entryMap->objectMapper.convertValue(entryMap, Person.class))
                .collect(Collectors.toList());
    }

}
