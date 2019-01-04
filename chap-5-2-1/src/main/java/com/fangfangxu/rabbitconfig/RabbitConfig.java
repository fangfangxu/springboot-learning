package com.fangfangxu.rabbitconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Queue;

/**
 * 创建RabbitMQ的配置类RabbitConfig、用来配置队列、交换器、路由等高级信息
 */
@Configuration
public class RabbitConfig {

   @Bean
    public Queue helloQueue(){
        return new Queue("d");
    }

}
