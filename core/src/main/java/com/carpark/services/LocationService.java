package com.carpark.services;

import com.carpark.logics.LocationLogic;
import com.carpark.models.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LocationService {

    @Autowired
    LocationLogic locationLogic;

    @Transactional(rollbackFor = Exception.class)
    public void insert(List<Location> locations){
        locationLogic.insert(locations);
    }

}
