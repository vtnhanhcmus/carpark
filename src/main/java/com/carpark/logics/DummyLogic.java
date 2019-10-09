package com.carpark.logics;

import com.carpark.mappers.DummyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

@Component
public class DummyLogic {

    @Autowired
    private DummyMapper dummyMapper;

    @Transactional(rollbackFor = Exception.class)
    public void dummyFromCsv() throws IOException {
        Resource resource = new ClassPathResource("data/hdb-carpark-information.csv");
        dummyMapper.dummyFromCsv(resource.getFile().getAbsolutePath());
    }

}
