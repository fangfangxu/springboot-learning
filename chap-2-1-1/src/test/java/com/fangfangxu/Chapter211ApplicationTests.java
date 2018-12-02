package com.fangfangxu;

import com.fangfangxu.bean.BlogProperties;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Chapter211ApplicationTests {
    @Autowired
    private BlogProperties blogProperties;

    @Test
    public void getHello()  throws Exception{
        Assert.assertEquals(blogProperties.getUsername(), "徐方方");
        Assert.assertEquals(blogProperties.getTitle(), "SpringBoot练习");
//        Assert.assertEquals(blogProperties.getDesc(), "SpringBoot练习");

    }

}
