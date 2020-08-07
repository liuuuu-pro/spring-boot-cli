package com.liu.cli.example.redis.controller;

import com.liu.cli.common.redis.core.RedisCache;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author liujiazhong
 * @date 2020/8/3 14:01
 */
@Slf4j
@RestController
public class DemoRedisController {

    private static final String HELLO_KEY = "cli:example:redis:hello";

    private final RedisCache redisCache;

    public DemoRedisController(RedisCache redisCache) {
        this.redisCache = redisCache;
    }

    /**
     * http://localhost:9091/hello/abc
     * @param word abc
     * @return abc
     */
    @GetMapping("hello/{word}")
    public String hello(@PathVariable("word") String word) {
        redisCache.setCacheObject(HELLO_KEY, word, 10, TimeUnit.SECONDS);
        return word;
    }

    /**
     * http://localhost:9091/say_hello
     * @return abc
     */
    @GetMapping("say_hello")
    public String sayHello() {
        Object hello = redisCache.getCacheObject(HELLO_KEY);
        return Objects.nonNull(hello) ? (String) hello : "unknown";
    }

}
