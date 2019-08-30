package com.project.movie.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@EnableScheduling
@Slf4j
public class ScheduledTasks {
    private final SimpleDateFormat dataFormat = new SimpleDateFormat(
            "HH:mm:ss"
    );

    @Scheduled(cron = "0 * * ? * *")
    public void reportCurrentTime() {
        log.info("Current time = " + dataFormat.format(new Date()));
    }
}
