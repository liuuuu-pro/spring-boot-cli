package com.liu.cli.example.demo;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author liujiazhong
 * @date 2020/8/26 17:37
 */
@Slf4j
public class OrderInvocationHandler implements InvocationHandler {

    private final Object target;

    public OrderInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object result = method.invoke(target, args);

        return result;
    }
}
