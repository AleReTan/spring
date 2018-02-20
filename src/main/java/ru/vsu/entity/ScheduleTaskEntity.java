package ru.vsu.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.vsu.services.serviceImpl.SessionService;

@Component
public class ScheduleTaskEntity {

    @Autowired
    private SessionService sessionService;


    public ScheduleTaskEntity() {
    }
    @Scheduled(cron = "0 * * ? * *")
    //@Scheduled(cron = "0 0 0/24 ? * *")
    public void fixedDelaySchedule() {
        sessionService.deleteAllOutsiding();
    }
}