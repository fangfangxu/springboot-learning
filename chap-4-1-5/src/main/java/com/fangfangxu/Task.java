package com.fangfangxu;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

@Slf4j
@Component
public class Task {



    @Async
    public Future<String> run() throws Exception {
        log.info("开始任务，需耗时：" + 1000 + "毫秒");
        Thread.sleep(6000);
        log.info("完成任务");
        return new AsyncResult<>("test");
    }


}
