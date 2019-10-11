package com.carpark.services;

import com.carpark.backgroud.ScheduledTasks;
import com.carpark.exceptions.CronJobException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AvailabilityService {

    @Autowired
    private ScheduledTasks scheduledTasks;

    public void availability() throws CronJobException {
        scheduledTasks.scheduleWithCarParkAvailability();
    }

}
