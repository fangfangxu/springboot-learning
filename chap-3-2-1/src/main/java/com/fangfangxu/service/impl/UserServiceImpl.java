package com.fangfangxu.service.impl;

import com.fangfangxu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(String username, Integer age) {
        jdbcTemplate.update("insert into useraccs(username,address) values (?,?)",username,age);
    }

    @Override
    public void deleteByName(String username) {
        jdbcTemplate.update("delete from useraccs where username=?",username);
    }

    @Override
    public Integer getAllUsers() {
        return jdbcTemplate.queryForObject("select count(1) from useraccs",Integer.class);

    }

    @Override
    public void deleteAllUsers() {
        jdbcTemplate.update("delete from useraccs ");
    }
}
