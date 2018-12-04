package com.fangfangxu.web;

import com.fangfangxu.exception.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;




@RestController
public class HelloController {

    @RequestMapping(value = "/hello" , method = RequestMethod.POST)
    public String index() throws Exception {
        throw new Exception("发生错误");
        }
    @RequestMapping("/hello2")
    public String json() throws Exception {
        throw new MyException("MyException自定义异常");
    }
}
