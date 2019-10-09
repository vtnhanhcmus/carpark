package com.carpark.services;

import com.carpark.logics.CarParkLogic;
import com.carpark.models.CarPark;
import com.carpark.request.LocationCriteria;
import com.carpark.request.PagingCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarParkService {

    @Autowired
    private CarParkLogic carParkLogic;

    public List<CarPark> search(LocationCriteria location,
                                PagingCriteria paging){
        return carParkLogic.search(location,paging);
    }

}
