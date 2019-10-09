package com.carpark.logics;

import com.carpark.mappers.CarParkMapper;
import com.carpark.models.CarPark;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class CarParkLogic {

    @Autowired
    private CarParkMapper carParkMapper;

    public List<CarPark> findBy(Double latitude, Double longitude){
        return carParkMapper.findBy(latitude,longitude);
    }

}
