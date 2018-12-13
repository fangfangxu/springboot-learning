package com.fangfangxu;


import com.fangfangxu.pojo.User;
import com.fangfangxu.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.springframework.transaction.annotation.Transactional;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Chapter331Application.class)

public class Chapter331ApplicationTests {
 @Autowired
 private UserRepository userRepository;

    @Test
    @Rollback(value = false)
    @Transactional(rollbackFor = Exception.class)
    public void getHello() throws Exception {
        userRepository.save(new User("AAA", 10));
        userRepository.save(new User("BBB", 20));
        userRepository.save(new User("CCC", 30));
        userRepository.save(new User("DDD", 40));
        userRepository.save(new User("EEE", 50));
        userRepository.save(new User("FFF", 60));
        userRepository.save(new User("GGG", 70));
        userRepository.save(new User("HHHHHHHHHH", 80));
        userRepository.save(new User("III", 90));
        userRepository.save(new User("JJJ", 100));
    }

}
