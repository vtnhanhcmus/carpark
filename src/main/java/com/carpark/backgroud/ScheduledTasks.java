package com.carpark.backgroud;

import com.carpark.exceptions.CronJobException;
import com.carpark.logics.ApiCarParkLogic;
import com.carpark.mappers.AvailabilityMapper;
import com.carpark.mappers.CarParkDataMapper;
import com.carpark.models.Availability;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class ScheduledTasks {

    @Autowired
    private AvailabilityMapper availabilityMapper;

    @Autowired
    private CarParkDataMapper carParkDataMapper;

    @Autowired
    private ApiCarParkLogic apiCarParkLogic;

    @Scheduled(cron = "${api.carpark.scheduler.pattern}")
    @Transactional(rollbackFor = Exception.class)
    public void scheduleWithCarParkAvailability() throws CronJobException {

        List<Availability> availabilities = apiCarParkLogic.apiGetCarParkAvailability();
        carParkDataMapper.delete();
        carParkDataMapper.insert(availabilities);
        availabilityMapper.insert();

    }


}
