package com.fangfangxu.controller;

import com.fangfangxu.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    private HelloService helloService;

    @RequestMapping("/hello")
    @Transactional(value = "oneTransactionManager")
    public void getInfo() {
        helloService.getInfo();
    }

    @RequestMapping("/hello2")
    @Transactional(value = "twoTransactionManager" ,isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)

    public void getInfo2() {
        helloService.getInfo2();
    }

}
