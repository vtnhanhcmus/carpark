package com.carpark.rest;

import com.carpark.cron.ScheduledTasks;
import com.carpark.rest.externalapis.DataSetCarParkApi;
import com.carpark.services.DummyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("api/migrate")
public class MigrateRestController {

    @Autowired
    private DummyService dummyService;

    @Autowired
    private ScheduledTasks scheduledTasks;

    @Autowired
    private DataSetCarParkApi dataSetCarParkApi;

    @Autowired
    private Environment env;

    @GetMapping(value = "/dummy", produces = "application/json")
    public ResponseEntity dummyCsv() throws IOException {
        dummyService.dummyFromCsv(env.getProperty("path.csv.cark.park"));
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/dataset/carpark-availability", produces = "application/json")
    @ResponseBody
    public ResponseEntity availability(){
        scheduledTasks.schedule();
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/convert/3857to4326", produces = "application/json")
    @ResponseBody
    public ResponseEntity convertLocation(){
        dataSetCarParkApi.convertLocation();
        return ResponseEntity.ok().build();
    }

}
