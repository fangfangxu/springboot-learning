package com.fangfangxu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private Integer id;
    private String name;
    private Integer age;

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public User(String  name, Integer age) {
        this.name = name;
        this.age = age;
    }

}
