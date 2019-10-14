package com.carpark.rest;

import com.carpark.rest.response.json.SuccessJson;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeRestController {

    @GetMapping({"/", ""})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public SuccessJson home(){
        return new SuccessJson(true);
    }

}
