package com.carpark.cron;

import com.carpark.models.Availability;
import com.carpark.rest.externalapis.DataSetCarParkApi;
import com.carpark.services.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ScheduledTasks {

    @Autowired
    private DataSetCarParkApi dataSetCarParkApi;

    @Autowired
    private ScheduleService scheduleService;

    @Scheduled(cron = "${api.carpark.scheduler.pattern}")
    public void schedule(){
        List<Availability> availabilities = dataSetCarParkApi.apiAvailability();
        scheduleService.schedule(availabilities);
    }

}
