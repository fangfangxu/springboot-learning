package com.fangfangxu;

import com.fangfangxu.mapper.UserMapper;

import com.fangfangxu.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;

import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Chapter328Application.class)
@Transactional
public class Chapter328ApplicationTests {
@Autowired
private UserMapper userMapper;
    @Test
    public void getHello() throws Exception {
//        userMapper.insert("CCC", 20);
//        Map<String, Object> map = new HashMap<>();
//        map.put("name", "DDD");
//        map.put("age", 40);
//        userMapper.insertInfo(map);
//        userMapper.insertUser (new User(10,"xufangfang"));

        // insert一条数据，并select出来验证
        userMapper.insert("AAA", 20);
        User u = userMapper.findByName("AAA");

        // update一条数据，并select出来验证
        u.setAge(30);
        userMapper.update(u);
        u = userMapper.findByName("AAA");

        // 删除这条数据，并select验证
        userMapper.delete(u.getId());
        u = userMapper.findByName("AAA");

    }

    @Test
    @Rollback
    public void testUserMapper() throws Exception {
        List<User> userList = userMapper.findAll();
        for(User user : userList) {
            System.out.print(user);
        }
    }



}
