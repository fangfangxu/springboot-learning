package com.fangfangxu;


import com.fangfangxu.dao.UserRepository;
import com.fangfangxu.pojo.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;




@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Chapter326Application.class)
public class Chapter326ApplicationTests {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void getHello() throws Exception {
        userRepository.deleteAll();
       // 创建三个User，并验证User总数
        userRepository.save(new User(1L, "ceshi1", 30));
        userRepository.save(new User(2L, "ceshi2", 40));
        userRepository.save(new User(3L, "ceshi3", 50));
        userRepository.save(new User(4L, "ceshi4", 50));
        userRepository.save(new User(5L, "ceshi5", 50));
        userRepository.save(new User(6L, "ceshi6", 50));
//        Assert.assertEquals(3, userRepository.findAll().size());

        // 删除一个User，再验证User总数
        User u = userRepository.findOne(1L);
        userRepository.delete(u);
//        Assert.assertEquals(2, userRepository.findAll().size());

        // 删除一个User，再验证User总数
        u = userRepository.findByUsername("ceshi3");
        userRepository.delete(u);
//        Assert.assertEquals(1, userRepository.findAll().size());


    }

}
