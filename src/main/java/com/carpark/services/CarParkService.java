package com.carpark.services;

import com.carpark.logics.CarParkLogic;
import com.carpark.models.CarPark;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CarParkService {

    @Autowired
    private CarParkLogic carParkLogic;

    public List<CarPark> findBy(Double latitude, Double longitude){
        return carParkLogic.findBy(latitude,longitude);
    }

}
