package com.carpark.rests;

import com.carpark.services.CarParkService;
import com.carpark.services.DummyService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("api/migrate")
public class MigrateRestController {

    @Autowired
    private DummyService dummyService;

    @GetMapping(value = "/dummy", produces = "application/json")
    public void nearest() throws IOException {
        dummyService.dummyFromCsv();
    }

}
