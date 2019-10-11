package com.carpark.cron;

import com.carpark.api.ApiCarParkLogic;
import com.carpark.exceptions.ApiCarParkException;
import com.carpark.models.Availability;
import com.carpark.services.CarParkService;
import com.carpark.services.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ScheduledTasks {

    @Autowired
    private ApiCarParkLogic apiCarParkLogic;

    @Autowired
    private CarParkService carParkService;

    @Autowired
    private ScheduleService scheduleService;

    @Scheduled(cron = "${api.carpark.scheduler.pattern}")
    public void scheduleWithCarParkAvailability() throws ApiCarParkException {
        List<Availability> availabilities = apiCarParkLogic.apiGetCarParkAvailability();
        scheduleService.schedule(availabilities);
    }


}
