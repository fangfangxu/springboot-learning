package com.fangfangxu.web;

import com.fangfangxu.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {

    @PostMapping("/user")
    public UserDto index(@RequestBody UserDto userDto) throws Exception{
        return userDto;
    }
}
