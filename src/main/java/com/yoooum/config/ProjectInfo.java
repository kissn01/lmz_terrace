package com.yoooum.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ClassName ProjectInfo
 * @Description TODO
 * @Author kiss
 * @Date 2020/11/23 10:50
 * @Version 1.0
 */
@Data
@Component
@ConfigurationProperties(prefix = "project")
public class ProjectInfo
{
    private String projectName;
    private String abbreviationName;
}
