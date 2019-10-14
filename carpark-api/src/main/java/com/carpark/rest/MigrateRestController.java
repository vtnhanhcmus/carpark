package com.carpark.rest;

import com.carpark.rest.externalapis.DataSetCarParkApi;
import com.carpark.rest.response.json.SuccessJson;
import com.carpark.services.DummyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("api/migrate")
public class MigrateRestController {

    @Autowired
    private DummyService dummyService;

    @Autowired
    private DataSetCarParkApi dataSetCarParkApi;

    @Autowired
    private Environment env;

    @GetMapping(value = "/dummy", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity dummy() throws IOException {
        dummyService.dummy(env.getProperty("path.csv.cark.park"));
        dataSetCarParkApi.convertLocation();
        return ResponseEntity.ok().body(new SuccessJson(true));
    }

}
