package com.fangfangxu;


import com.fangfangxu.repository.u.Message;
import com.fangfangxu.repository.p.UserACCC;
import com.fangfangxu.repository.p.UserRepository;
import com.fangfangxu.repository.u.MessageRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Chapter324Application.class)
public class Chapter324ApplicationTests {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MessageRepository messageRepository;

    @Test
    public void test() throws Exception {

        userRepository.save(new UserACCC("ceshi1", 1000));
        userRepository.save(new UserACCC("ceshi2", 2000));


        messageRepository.save(new Message("o1", "ceshi1000"));
        messageRepository.save(new Message("o2", "ceshi2000"));


    }

}
