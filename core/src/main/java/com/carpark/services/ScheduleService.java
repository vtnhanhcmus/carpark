package com.carpark.services;

import com.carpark.logics.ScheduleLogic;
import com.carpark.models.Availability;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleLogic scheduleLogic;

    @Transactional(rollbackFor = Exception.class)
    public void schedule(List<Availability> availabilities){
        scheduleLogic.schedule(availabilities);
    }

}
