package com.fangfangxu;

import com.fangfangxu.pojo.User;
import com.fangfangxu.respository.UserRepository;
import com.fangfangxu.web.HelloController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Chapter441Application.class)
public class Chapter441ApplicationTests {
    @Autowired
    private UserRepository userRepository;

    @Before
    public void before() {
        userRepository.save(new User("xu112",26));
    }
    @Test
    public void getHello() throws Exception {
        User u1 = userRepository.findByName("xu112");
        System.out.println("第一次查询：" + u1.getAge());

        User u2 = userRepository.findByName("xu112");
        System.out.println("第二次查询：" + u2.getAge());
        u2.setAge(9);
        userRepository.save(u2);
        User u3 = userRepository.findByName("xu112");
        System.out.println("第二次查询：" + u3.getAge());
    }

}
