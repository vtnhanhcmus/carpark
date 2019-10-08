package com.carpark.rests;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("carparks")
public class CarParkRestController {

    @GetMapping(value = "/nearest", produces = "application/json")
    public String nearest() {
        return "Welcome to you";
    }

}
