package com.liu.cli.example.demo.demo;

import com.liu.cli.example.demo.holder.ObjectHolder;
import lombok.extern.slf4j.Slf4j;

/**
 * @author liujiazhong
 * @date 2020/9/2 9:19
 */
@Slf4j
public class HolderDemo {

    public static void main(String[] args) {
        String abc = "abc";
        String bcd = "bcd";
        ObjectHolder.INSTANCE.setObject("abc", abc);
        ObjectHolder.INSTANCE.setObject("bcd", bcd);

        String object = ObjectHolder.INSTANCE.getObject(String.class);
        log.info("object:{}", object);
    }

}
