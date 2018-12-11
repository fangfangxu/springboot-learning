package com.fangfangxu;

import com.fangfangxu.mapper.UserMapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Chapter328Application.class)
public class Chapter328ApplicationTests {
@Autowired
private UserMapper userMapper;
    @Test
    public void getHello() throws Exception {
        userMapper.insert("CCC", 20);
    }

}
