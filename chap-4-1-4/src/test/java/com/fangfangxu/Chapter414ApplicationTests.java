package com.fangfangxu;


import lombok.SneakyThrows;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Chapter414Application.class)
public class Chapter414ApplicationTests {
    @Autowired
    private Task task;

    @Test
    @SneakyThrows
    public void getHello() throws Exception {
        for (int i = 0; i < 1000000; i++) {
            task.doTaskOne();
            task.doTaskTwo();
            task.doTaskThree();

            if (i == 9999) {
                System.exit(0);
            }
        }
    }

}
