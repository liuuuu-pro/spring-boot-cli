package com.liu.cli.example.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author liujiazhong
 * @date 2020/9/1 16:15
 */
@SpringBootApplication
public class LogExampleApplication {

    private static final Logger log = LoggerFactory.getLogger(LogExampleApplication.class);

    public static void main(String[] args) {
        log.error("--------------begin - application--------------");
        SpringApplication.run(LogExampleApplication.class, args);
    }

}
