package com.carpark.logics;

import com.carpark.mappers.AvailabilityMapper;
import com.carpark.mappers.CarParkDataMapper;
import com.carpark.models.Availability;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
public class ScheduleLogic {

    @Autowired
    private CarParkDataMapper carParkDataMapper;
    @Autowired
    private AvailabilityMapper availabilityMapper;

    public void schedule(List<Availability> availabilities){
        carParkDataMapper.delete();
        carParkDataMapper.insert(availabilities);
        availabilityMapper.insert();
    }

}
