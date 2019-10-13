package com.carpark.logics;

import com.carpark.mappers.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

import java.io.IOException;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.Silent.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class DummyLogicTest {

    @InjectMocks
    DummyLogic dummyLogic;

    @Mock
    private CarParkDataMapper carParkDataMapper;

    @Mock
    private AvailabilityMapper availabilityMapper;

    @Mock
    private LocationMapper locationMapper;

    @Mock
    private CarParkMapper carParkMapper;

    @Mock
    private DummyMapper dummyMapper;

    @Mock
    private Environment env;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        when(env.getRequiredProperty("path.csv.cark.park")).thenReturn("data/hdb-carpark-information.csv");
    }

    @Test
    public void test01() throws IOException {

        String filePath = "data/hdb-carpark-information.csv";
        dummyLogic.dummy(filePath);
        verify(carParkDataMapper, times(1)).delete();
        verify(availabilityMapper, times(1)).delete();
        verify(locationMapper, times(1)).delete();
        verify(carParkMapper, times(1)).delete();
        verify(dummyMapper, times(1)).dummyFromCsv(anyString());

    }

}
