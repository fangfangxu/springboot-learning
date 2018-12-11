package com.fangfangxu;


import com.fangfangxu.jdbc.JdbcClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Chapter329Application.class)
public class Chapter329ApplicationTests {
    @Autowired
    private JdbcClass jdbcClass;

    @Test
    public void getHello() throws Exception {
        jdbcClass.insert("fangfang",10);
    }

}
