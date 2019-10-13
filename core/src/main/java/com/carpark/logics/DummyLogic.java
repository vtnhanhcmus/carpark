package com.carpark.logics;

import com.carpark.mappers.DummyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Component
public class DummyLogic {

    @Autowired
    private DummyMapper dummyMapper;

    @Transactional(rollbackFor = Exception.class)
    public void dummyFromCsv(String path) throws IOException {
        Resource resource = new ClassPathResource(path);
        dummyMapper.dummyFromCsv(resource.getFile().getAbsolutePath());
    }

}
