package com.fangfangxu.web;

import com.fangfangxu.dto.User;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;




@RestController
public class HelloController {

    @RequestMapping(value = "/hello" ,
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE,
            method = RequestMethod.POST)
    public User index(@RequestBody User user) {
        user.setName("aaa");
        return user;
        }
        }
