package com.project.movie.schedule;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@EnableScheduling
public class ScheduledTasks {
    private static final SimpleDateFormat dataFormat = new SimpleDateFormat(
            "HH:mm:ss"
    );

    @Scheduled(cron = "0 * * ? * *")
    public void reportCurrentTime() {
        System.out.println("Current time = " + dataFormat.format(new Date()));
    }
}
