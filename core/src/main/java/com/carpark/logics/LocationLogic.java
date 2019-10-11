package com.carpark.logics;

import com.carpark.mappers.LocationMapper;
import com.carpark.models.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LocationLogic {

    @Autowired
    LocationMapper locationMapper;

    public void insert(List<Location> locations){
        locationMapper.insert(locations);
    }

}
