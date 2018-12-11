package com.fangfangxu;



import com.fangfangxu.mapper.UserMapper;
import com.fangfangxu.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;




@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Chapter327Application.class)
public class Chapter327ApplicationTests {
    @Autowired
    private UserMapper userMapper;
    @Test
    @Rollback
    public void getHello() throws Exception {
        userMapper.insert("BBB", 20);
        User u = userMapper.findByName("AAA");
//        Assert.assertEquals(20, u.getAge().intValue());
    }

}
