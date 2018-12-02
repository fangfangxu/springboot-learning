package com.fangfangxu.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationListener;
@Slf4j
//Slf4j注解方式实现日志
//log4j是具体的日志系统。通过slf4j-log4j12初始化Log4j，达到最终日志的输出。
// lombok：一个插件，封装了log的get和set，可以直接使用log来输出日志信息。
public class ApplicationPreparedEventListener  implements ApplicationListener<ApplicationPreparedEvent> {
    @Override
    public void onApplicationEvent(ApplicationPreparedEvent applicationPreparedEvent) {
        log.info("......ApplicationPreparedEvent......");
    }
}
