package com.carpark.rests;

import com.carpark.backgroud.ScheduledTasks;
import com.carpark.exceptions.CronJobException;
import com.carpark.services.ConvertLocationService;
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
    private ConvertLocationService convertLocationService;

    @GetMapping(value = "/availability", produces = "application/json")
    @ResponseBody
    public ResponseEntity availability() throws CronJobException {
        scheduledTasks.scheduleWithCarParkAvailability();
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/convert/location", produces = "application/json")
    @ResponseBody
    public ResponseEntity convertLocation() throws IOException {
        convertLocationService.convertLocation();
        return ResponseEntity.ok().build();
    }

}
