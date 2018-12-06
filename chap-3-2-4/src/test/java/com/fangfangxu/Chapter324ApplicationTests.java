package com.fangfangxu;


import com.fangfangxu.entity.Message;
import com.fangfangxu.entity.UserACCC;
import com.fangfangxu.repository.p.UserRepository;
import com.fangfangxu.repository.u.MessageRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest

public class Chapter324ApplicationTests {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MessageRepository messageRepository;

    @Test
    public void test() throws Exception {

        userRepository.save(new UserACCC("aaa", 10));
        userRepository.save(new UserACCC("bbb", 20));
        userRepository.save(new UserACCC("ccc", 30));
        userRepository.save(new UserACCC("ddd", 40));
        userRepository.save(new UserACCC("eee", 50));

        Assert.assertEquals(5, userRepository.findAll().size());

        messageRepository.save(new Message("o1", "aaaaaaaaaa"));
        messageRepository.save(new Message("o2", "bbbbbbbbbb"));
        messageRepository.save(new Message("o3", "cccccccccc"));

        Assert.assertEquals(3, messageRepository.findAll().size());

    }

}
