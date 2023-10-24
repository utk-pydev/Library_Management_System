package com.example.demoRedis;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Object> getPerson(@RequestParam("id") long id){
        String key = getKey(id);
        Object p =  redisTemplate.opsForValue().get(key);
        if(p != null){
           return ResponseEntity.ok(p);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    private String getKey(long id){
        return PERSON_KEY_PREFIX+id;
    }

}
