package com.carpark.logics;

import com.carpark.mappers.AvailabilityMapper;
import com.carpark.mappers.CarParkDataMapper;
import com.carpark.models.Availability;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class ScheduleLogicTest {

    @Mock
    private CarParkDataMapper carParkDataMapper;
    @Mock
    private AvailabilityMapper availabilityMapper;
    @InjectMocks
    private ScheduleLogic scheduleLogic;


    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test01(){

        Integer totalLots = 100;
        Integer availableLots = 5;
        String lotType = "C";
        String carParkNo = "A1";
        LocalDateTime updateDatetime = LocalDateTime.now();

        Availability availability = new Availability(totalLots, availableLots, lotType, carParkNo, updateDatetime);
        List<Availability> availabilities = Lists.list(availability);

        scheduleLogic.schedule(availabilities);

        verify(carParkDataMapper, times(1)).delete();
        verify(carParkDataMapper, times(1)).insert(availabilities);
        verify(availabilityMapper, times(1)).insert();
    }


}
