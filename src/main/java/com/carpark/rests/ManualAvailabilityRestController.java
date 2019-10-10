package com.carpark.rests;

import com.carpark.backgroud.ScheduledTasks;
import com.carpark.exceptions.CronJobException;
import com.carpark.models.CarPark;
import com.carpark.request.LocationCriteria;
import com.carpark.request.PagingCriteria;
import com.carpark.services.CarParkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/manual")
public class ManualAvailabilityRestController {

    @Autowired
    private ScheduledTasks scheduledTasks;

    @GetMapping(value = "/availability", produces = "application/json")
    @ResponseBody
    public ResponseEntity availability() throws CronJobException {
        scheduledTasks.scheduleWithCarParkAvailability();
        return ResponseEntity.ok().build();
    }

}
