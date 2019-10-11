package com.carpark.services;

import com.carpark.criterias.SearchCriteria;
import com.carpark.logics.CarParkLogic;
import com.carpark.models.CarPark;
import com.carpark.models.Coordinates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarParkService {

    @Autowired
    private CarParkLogic carParkLogic;

    public List<CarPark> search(SearchCriteria searchCriteria){
        return carParkLogic.search(searchCriteria);
    }

    public List<Coordinates> findCoordinates(){
        return carParkLogic.findCoordinates();
    }

}
