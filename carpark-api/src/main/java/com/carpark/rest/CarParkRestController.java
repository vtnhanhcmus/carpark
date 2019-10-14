package com.carpark.rest;

import com.carpark.criterias.SearchCriteria;
import com.carpark.models.Nearest;
import com.carpark.services.CarParkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Controller
@RequestMapping("carparks")
@Validated
public class CarParkRestController {

    @Autowired
    private CarParkService carParkService;

    @GetMapping(value = "/nearest", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Nearest> nearest(
            @NotNull @Min(value = -90) @Max(value = 90) @RequestParam(value = "latitude") Double latitude,
            @NotNull @Min(value = -180) @Max(value = 180) @RequestParam("longitude") Double longitude,
            @Min(value = 1) @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            @Min(value = 1) @RequestParam(value = "per_page", required = false, defaultValue = "20") Integer perPage) {

        SearchCriteria searchCriteria = new SearchCriteria(latitude,longitude, perPage, page);
        return carParkService.search(searchCriteria);
    }
}
