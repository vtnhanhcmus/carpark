package com.carpark.logics;

import com.carpark.mappers.LocationMapper;
import com.carpark.models.Location;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class LocationLogicTest {

    @InjectMocks
    private LocationLogic locationLogic;

    @Mock
    LocationMapper locationMapper;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test01(){
        List<Location> locations = new ArrayList<>();
        locationLogic.insert(locations);
        verify(locationMapper, times(1)).insert(locations);

    }


}
