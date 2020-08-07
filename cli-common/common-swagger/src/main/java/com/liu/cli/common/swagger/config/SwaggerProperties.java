package com.liu.cli.common.swagger.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author liujiazhong
 * @date 2020/8/3 16:26
 */
@Data
@ConfigurationProperties("swagger")
public class SwaggerProperties {

    private String title;

    private String description;

    private String version;

    private String contactName;

    private String contactUrl;

    private String contactEmail;

}
