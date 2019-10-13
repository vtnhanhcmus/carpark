package com.carpark.services;

import com.carpark.logics.DummyLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class DummyService {

    @Autowired
    private DummyLogic dummyLogic;

    public void dummyFromCsv(String path) throws IOException {
        dummyLogic.dummyFromCsv(path);
    }

}
