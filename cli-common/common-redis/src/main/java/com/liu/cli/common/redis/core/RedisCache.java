package com.liu.cli.common.redis.core;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * spring redis 工具类
 *
 * @author liujiazhong
 * @date 2020/3/31 9:32
 */
@Component
public class RedisCache {

    private final RedisTemplate<String, Object> redisTemplate;

    public RedisCache(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void setCacheObject(String key, Object value) {
        ValueOperations<String, Object> operation = redisTemplate.opsForValue();
        operation.set(key, value);
    }

    public void setCacheObject(String key, Object value, Integer timeout, TimeUnit timeUnit) {
        ValueOperations<String, Object> operation = redisTemplate.opsForValue();
        operation.set(key, value, timeout, timeUnit);
    }

    public Object getCacheObject(String key) {
        ValueOperations<String, Object> operation = redisTemplate.opsForValue();
        return operation.get(key);
    }

    public void deleteObject(String key) {
        redisTemplate.delete(key);
    }

    public void deleteObject(Collection<String> collection) {
        redisTemplate.delete(collection);
    }

    public <T> void setCacheList(String key, List<T> dataList) {
        ListOperations<String, Object> listOperation = redisTemplate.opsForList();
        if (CollectionUtils.isNotEmpty(dataList)) {
            for (T t : dataList) {
                listOperation.leftPush(key, t);
            }
        }
    }

    public List<Object> getCacheList(String key) {
        ListOperations<String, Object> listOperation = redisTemplate.opsForList();
        return listOperation.range(key, 0, -1);
    }

    public void setCacheSet(String key, Set<Object> dataSet) {
        BoundSetOperations<String, Object> setOperation = redisTemplate.boundSetOps(key);
        for (Object t : dataSet) {
            setOperation.add(t);
        }
    }

    public Set<Object> getCacheSet(String key) {
        BoundSetOperations<String, Object> operation = redisTemplate.boundSetOps(key);
        return operation.members();
    }

    public void setCacheMap(String key, Map<String, Object> dataMap) {
        HashOperations<String, String, Object> hashOperations = redisTemplate.opsForHash();
        if (MapUtils.isNotEmpty(dataMap)) {
            dataMap.forEach((k, v) -> hashOperations.put(key, k, v));
        }
    }

    public Map<String, Object> getCacheMap(String key) {
        HashOperations<String, String, Object> hashOperations = redisTemplate.opsForHash();
        return hashOperations.entries(key);
    }

    public Collection<String> keys(String pattern) {
        return redisTemplate.keys(pattern);
    }

    public Long increment(String key, Long delta) {
        ValueOperations<String, Object> operation = redisTemplate.opsForValue();
        return operation.increment(key, delta);
    }

}
