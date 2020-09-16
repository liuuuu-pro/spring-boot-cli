package com.liu.cli.common.support.polling.config;

import com.liu.cli.common.support.polling.domain.DelayedRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liujiazhong
 * @date 2020/1/10 10:25
 */
@Configuration
@ComponentScan("com.liu.cli.common.support.polling.core")
public class DelayedConfig {

    @Bean
    public DelayedRule commonDelayedRule() {
        Map<Integer, Integer> delayedRules = new HashMap<>(5);
        delayedRules.put(1, 1000);
        delayedRules.put(2, 2000);
        delayedRules.put(3, 3000);
        delayedRules.put(4, 4000);
        delayedRules.put(5, 5000);
        return DelayedRule.builder().delayedRules(delayedRules).build();
    }

    @Bean
    public DelayedRule ytPayResultRule() {
        Map<Integer, Integer> delayedRules = new HashMap<>(20);
        delayedRules.put(1, 10000);
        delayedRules.put(2, 5000);
        delayedRules.put(3, 5000);
        delayedRules.put(4, 5000);
        delayedRules.put(5, 5000);
        delayedRules.put(6, 5000);
        delayedRules.put(7, 5000);
        delayedRules.put(8, 5000);
        delayedRules.put(9, 5000);
        delayedRules.put(10, 5000);
        delayedRules.put(11, 5000);
        delayedRules.put(12, 5000);
        delayedRules.put(13, 5000);
        delayedRules.put(14, 5000);
        delayedRules.put(15, 5000);
        delayedRules.put(16, 5000);
        delayedRules.put(17, 5000);
        delayedRules.put(18, 10000);
        delayedRules.put(19, 10000);
        delayedRules.put(20, 10000);
        return DelayedRule.builder().delayedRules(delayedRules).build();
    }

}
