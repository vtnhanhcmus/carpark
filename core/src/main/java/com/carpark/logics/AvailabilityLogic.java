package com.carpark.logics;

import com.carpark.mappers.AvailabilityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AvailabilityLogic {

    @Autowired
    private AvailabilityMapper availabilityMapper;

    public void insert(){
        availabilityMapper.insert();
    }

}
