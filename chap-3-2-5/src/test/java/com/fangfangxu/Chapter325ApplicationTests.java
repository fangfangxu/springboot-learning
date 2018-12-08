package com.fangfangxu;


import com.fangfangxu.pojo.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Chapter325Application.class)
public class Chapter325ApplicationTests {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    @Qualifier("redis2")
    private RedisTemplate<String, User> redisTemplate;
    /**
     * 通过编写测试用例，举例说明如何访问Redis
     * @throws Exception
     */
    @Test
    public void getHello() throws Exception {
        // 保存字符串d
        stringRedisTemplate.opsForValue().set("aaa", "3332");
//        Assert.assertEquals("3332", stringRedisTemplate.opsForValue().get("aaa"));
        User user=new User("xufangfang",20);
        redisTemplate.opsForValue().set(user.getUsername(),user);
        redisTemplate.opsForValue().get(user.getUsername());


    }

}





