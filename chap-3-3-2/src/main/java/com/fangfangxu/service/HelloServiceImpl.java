package com.fangfangxu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {
    @Autowired
    @Qualifier("oneJdbcTemplate")
    private JdbcTemplate jdbcone;
    @Autowired
    @Qualifier("twoJdbcTemplate")
    private JdbcTemplate jdbctwo;

    @Override
    public void getInfo() {
        jdbcone.update("insert into user(id,age,name) values (?,?,?)",1,1,"one");
    }

    @Override
    public void getInfo2() {
        jdbctwo.update("insert into user(id,age,name) values (?,?,?)",2,2,"two");
    }
}
