package com.fangfangxu.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

//@Data : 注解在类上, 为类提供读写属性, 此外还提供了 equals()、hashCode()、toString() 方法
@Data
@ConfigurationProperties(prefix = "com.didispace")
public class FooProperties {

    private String foo;
    private List<String> post;
    private List<Map<String,String>> posts;
}
