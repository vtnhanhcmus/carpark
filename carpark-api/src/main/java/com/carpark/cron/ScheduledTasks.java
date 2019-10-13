package com.carpark.cron;

import com.carpark.exceptions.ApiCarParkException;
import com.carpark.externalapis.ExternalCarParkApi;
import com.carpark.models.Availability;
import com.carpark.services.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ScheduledTasks {

    @Autowired
    private ExternalCarParkApi externalCarParkApi;

    @Autowired
    private ScheduleService scheduleService;

    //@Scheduled(cron = "${api.carpark.scheduler.pattern}")
    public void schedule() throws ApiCarParkException {
        List<Availability> availabilities = externalCarParkApi.apiAvailability();
        scheduleService.schedule(availabilities);
    }


}
