package com.carpark.rests;

import com.carpark.services.CarParkService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("carparks")
public class CarParkRestController {

    @Autowired
    private CarParkService carParkService;

    @GetMapping(value = "/nearest", produces = "application/json")
    public String nearest(@RequestParam("latitude") Double latitude, @RequestParam("longitude") Double longitude) throws IOException {
        return new Gson().toJson(carParkService.findBy(latitude, longitude));
    }

}
