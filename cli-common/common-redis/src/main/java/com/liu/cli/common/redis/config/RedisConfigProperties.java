package com.liu.cli.common.redis.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author liujiazhong
 * @date 2020/4/9 9:41
 */
@Data
@ConfigurationProperties("redis")
public class RedisConfigProperties {

    private String host;
    private Integer port;
    private String password;
    private Integer database;
    private Integer maxTotal;
    private Integer maxIdle;
    private Integer timeBetweenEvictionRunsMillis;
    private Integer minEvictableIdleTimeMillis;
    private Boolean testOnBorrow;
    private Integer maxWaitMillis;
    private Integer socketTimeout;
    
}
