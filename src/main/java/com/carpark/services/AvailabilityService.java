package com.carpark.services;

import com.carpark.backgroud.ScheduledTasks;
import com.carpark.request.LocationCriteria;
import com.carpark.request.PagingCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AvailabilityService {

    @Autowired
    private ScheduledTasks scheduledTasks;

    public void availability(LocationCriteria location,
                                PagingCriteria paging){
        scheduledTasks.scheduleWithCarParkAvailability();
    }

}
