package com.fangfangxu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String index() {
        return "Hello World322";
        }
        }
