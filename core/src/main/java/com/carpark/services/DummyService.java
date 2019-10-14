package com.carpark.services;

import com.carpark.logics.DummyLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Service
public class DummyService {

    @Autowired
    private DummyLogic dummyLogic;

    @Transactional(rollbackFor = Exception.class)
    public void dummy(String path) throws IOException {
        dummyLogic.dummy(path);
    }

}
