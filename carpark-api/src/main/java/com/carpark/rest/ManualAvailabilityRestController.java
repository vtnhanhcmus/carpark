package com.carpark.rest;

import com.carpark.cron.ConvertLocationLogic;
import com.carpark.cron.ScheduledTasks;
import com.carpark.exceptions.CronJobException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("api/manual")
public class ManualAvailabilityRestController {

    @Autowired
    private ScheduledTasks scheduledTasks;

    @Autowired
    private ConvertLocationLogic convertLocationLogic;

    @GetMapping(value = "/availability", produces = "application/json")
    @ResponseBody
    public ResponseEntity availability() throws CronJobException {
        scheduledTasks.scheduleWithCarParkAvailability();
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/convert/location", produces = "application/json")
    @ResponseBody
    public ResponseEntity convertLocation() throws IOException {
        convertLocationLogic.convertLocation();
        return ResponseEntity.ok().build();
    }

}
