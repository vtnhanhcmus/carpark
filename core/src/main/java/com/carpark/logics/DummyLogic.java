package com.carpark.logics;

import com.carpark.mappers.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Component
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
public class DummyLogic {

    @Autowired
    private DummyMapper dummyMapper;
    @Autowired
    private CarParkMapper carParkMapper;
    @Autowired
    private CarParkDataMapper carParkDataMapper;
    @Autowired
    private LocationMapper locationMapper;
    @Autowired
    private AvailabilityMapper availabilityMapper;

    @Transactional(rollbackFor = Exception.class)
    public void dummy(String path) throws IOException {
        carParkDataMapper.delete();
        availabilityMapper.delete();
        locationMapper.delete();
        carParkMapper.delete();
        Resource resource = new ClassPathResource(path);
        dummyMapper.dummyFromCsv(resource.getFile().getAbsolutePath());
    }

}
