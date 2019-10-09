package com.carpark.services;

import com.carpark.logics.CarParkLogic;
import com.carpark.logics.DummyLogic;
import com.carpark.models.CarPark;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class DummyService {

    @Autowired
    private DummyLogic dummyLogic;

    public void dummyFromCsv() throws IOException {
        dummyLogic.dummyFromCsv();
    }

}
