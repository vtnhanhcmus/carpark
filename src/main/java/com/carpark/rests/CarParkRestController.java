package com.carpark.rests;

import com.carpark.criterias.SearchCriteria;
import com.carpark.models.CarPark;
import com.carpark.services.CarParkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@Controller
@RequestMapping("carparks")
@Validated
public class CarParkRestController {

    @Autowired
    private CarParkService carParkService;

    @GetMapping(value = "/nearest", produces = "application/json")
    @ResponseBody
    public List<CarPark> nearest(
            @Min(value = -90) @Max(value = 90) @RequestParam(value = "latitude") Double latitude,
            @Min(value = -180) @Max(value = 180) @RequestParam("longitude") Double longitude,
            @Min(value = 1) @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            @Min(value = 1) @RequestParam(value = "per_page", required = false, defaultValue = "20") Integer perPage) {

        SearchCriteria searchCriteria = new SearchCriteria(latitude,longitude, perPage, page);
        return carParkService.search(searchCriteria);
    }
}
