package com.carpark.logics;

import com.carpark.exceptions.PagingException;
import com.carpark.mappers.AvailabilityMapper;
import com.carpark.models.Availability;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AvailabilityLogic {

    @Autowired
    private AvailabilityMapper availabilityMapper;

    public void insert(){
        availabilityMapper.insert();
    }

}
