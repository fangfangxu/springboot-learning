package com.fangfangxu.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
@Slf4j
public class HelloController {

    @RequestMapping("/hello")
    public String index() {
        log.debug("测试");
        return "Hello World421";
        }
        }
