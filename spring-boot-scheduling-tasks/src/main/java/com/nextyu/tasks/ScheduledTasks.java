package com.nextyu.tasks;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * created on 2017-05-05 13:56
 *
 * @author nextyu
 */
@Component
public class ScheduledTasks {

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        System.out.println("现在时间：" + System.currentTimeMillis());
    }

}
