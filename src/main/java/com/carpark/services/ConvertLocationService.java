package com.carpark.services;

import com.carpark.logics.ConvertLocationLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConvertLocationService {

    @Autowired
    private ConvertLocationLogic convertLocationLogic;

    public void convertLocation(){
        convertLocationLogic.convertLocation();
    }

}
