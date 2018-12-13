package com.fangfangxu.controller;


import com.fangfangxu.repository.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
  @Autowired
    private Service service;



     @RequestMapping(value = "/hello")
     public void getInfo() throws Exception {
         service.getHello();
     }

}
