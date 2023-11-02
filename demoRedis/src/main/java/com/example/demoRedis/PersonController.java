package com.example.demoRedis;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
public class PersonController {

    private static final String PERSON_KEY_PREFIX = "per::";
    private static final String PERSON_LIST_KEY = "per_list";
    private static final String PERSON_HASH_KEY_PREFIX = "per_hash::";

    @Autowired
    RedisTemplate<String, Object>redisTemplate;

    @PostMapping("/string/person")
    public void savePerson(@RequestBody Person person) {
        if (person.getId() == 0) {
            return;
        }
        String key = getKey(person.getId());
        redisTemplate.opsForValue().set(key, person);
    }

    @GetMapping("/string/person")
    public ResponseEntity<Object> getPerson(@RequestBody Person person,  @RequestParam("id") long id){
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
    @DeleteMapping("/lpush/person")
    public List<Person> rpop(@RequestParam(value = "count", required = false, defaultValue = "1")int count){
        return Objects.requireNonNull(redisTemplate.opsForList()
                        .rightPop(PERSON_LIST_KEY, count))
                .stream()
                .map(x->(Person)x)
                .collect(Collectors.toList());
    }

    @GetMapping("/lrange/person")
    public List<Person> lrange(@RequestParam(value = "count", required = false, defaultValue = "0")int start,
                               @RequestParam(value = "count", required = false, defaultValue = "-1")int end){
        return Objects.requireNonNull(Objects.requireNonNull(redisTemplate.opsForList()))
                        .range(PERSON_LIST_KEY, start, end)
                .stream()
                .map(x->(Person)x)
                .collect(Collectors.toList());
    }

    private String getHashKey(long id){
        return PERSON_HASH_KEY_PREFIX+id;
    }

}
