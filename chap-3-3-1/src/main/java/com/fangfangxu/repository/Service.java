package com.fangfangxu.repository;

import com.fangfangxu.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class Service {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void getHello() throws Exception {
        userRepository.save(new User("AAA", 10));
        userRepository.save(new User("BBB", 20));
        userRepository.save(new User("CCC", 30));
        userRepository.save(new User("DDD", 40));
        userRepository.save(new User("EEE", 50));
        userRepository.save(new User("FFF", 60));
        userRepository.save(new User("GGG", 70));
        userRepository.save(new User("HHHHHHHH", 80));
        userRepository.save(new User("III", 90));
        userRepository.save(new User("JJJ", 100));
    }
}
