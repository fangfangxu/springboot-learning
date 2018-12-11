package com.fangfangxu.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JdbcClass {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insert(String name,Integer age){
        jdbcTemplate.update("insert into user(name,age) values (?,?)",name,age);

    }



}
