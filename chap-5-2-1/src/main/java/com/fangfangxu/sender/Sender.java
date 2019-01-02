package com.fangfangxu.sender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 创建消息生产者
 */
@Component
public class Sender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(){
        String context="xufangfang"+new Date()+"happyEveryDay";
        System.out.print(context);
        this.rabbitTemplate.convertAndSend("xufangfang",context);
    }



}
