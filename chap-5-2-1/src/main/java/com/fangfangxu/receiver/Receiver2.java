package com.fangfangxu.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 创建消费者2
 */
@Component
@RabbitListener(queues = "b")
public class Receiver2 {

    @RabbitHandler
//    该消费者实现了对hello队列的消费，消费操作为输出消息的字符串内容。
    public void process(String param){
        System.out.print("|||________Receiver2________|||:*********"+param);
    }

}
