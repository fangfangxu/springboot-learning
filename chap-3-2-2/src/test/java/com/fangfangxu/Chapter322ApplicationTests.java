package com.fangfangxu;

import com.fangfangxu.controller.HelloController;
import com.fangfangxu.jpaeccess.UserRepository;
import com.fangfangxu.pojo.JpaEntity;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


@RunWith(SpringRunner.class)
@SpringBootTest

public class Chapter322ApplicationTests {
@Autowired
private UserRepository userRepository;
    @Test
    public void getHello() throws Exception {
        // 创建10条记录
        userRepository.save(new JpaEntity("AAA", 9999));
        userRepository.save(new JpaEntity("BBB", 30));
        userRepository.save(new JpaEntity("CCC", 30));
        userRepository.save(new JpaEntity("DDD", 40));
        userRepository.save(new JpaEntity("EEE", 50));
        userRepository.save(new JpaEntity("FFF", 60));
        userRepository.save(new JpaEntity("GGG", 70));
        userRepository.save(new JpaEntity("HHH", 80));
        userRepository.save(new JpaEntity("III", 90));
        userRepository.save(new JpaEntity("JJJ", 100));
// 测试findAll, 查询所有记录
        Assert.assertEquals(10, userRepository.findAll().size());

        // 测试findByName, 查询姓名为FFF的User
        Assert.assertEquals(60, userRepository.findByUsername("FFF").getAge().longValue());

        // 测试findUser, 查询姓名为FFF的User
        Assert.assertEquals(60, userRepository.findJpaEntity("FFF").getAge().longValue());

        // 测试findByNameAndAge, 查询姓名为FFF并且年龄为60的User
        Assert.assertEquals("FFF", userRepository.findByUsernameAndAge("FFF", 60).getUsername());

        // 测试删除姓名为AAA的User
        userRepository.delete(userRepository.findByUsername("AAA"));

        // 测试findAll, 查询所有记录, 验证上面的删除是否成功
        Assert.assertEquals(9, userRepository.findAll().size());







    }

}
