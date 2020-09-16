package com.liu.cli.example.demo.holder;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * The enum object holder
 * Copied from seata.jar
 * @author liujiazhong
 * @date 2020/9/2 9:17
 */
public enum ObjectHolder {

    /**
     * singleton instance
     */
    INSTANCE;

    private static final int MAP_SIZE = 8;

    private static final Map<String, Object> OBJECT_MAP = new ConcurrentHashMap<>(MAP_SIZE);

    public Object getObject(String objectKey) {
        return OBJECT_MAP.get(objectKey);
    }

    public <T> T getObject(Class<T> clazz) {
        return clazz.cast(OBJECT_MAP.values().stream().filter(clazz::isInstance).findAny().orElseThrow(() -> new RuntimeException("Can't find any object of class " + clazz.getName())));
    }

    public Object setObject(String objectKey, Object object) {
        return OBJECT_MAP.putIfAbsent(objectKey, object);
    }

}
