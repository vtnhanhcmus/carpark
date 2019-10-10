package com.carpark.rests;

import com.carpark.models.CarPark;
import com.carpark.request.LocationCriteria;
import com.carpark.request.PagingCriteria;
import com.carpark.services.CarParkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/carparks")
public class CarParkRestController {

    @Autowired
    private CarParkService carParkService;


    @GetMapping(value = "/nearest", produces = "application/json")
    @ResponseBody
    public List<CarPark> nearest(@RequestParam("latitude") Double latitude,
                                 @RequestParam("longitude") Double longitude,
                                 @RequestParam("page") Integer page,
                                 @RequestParam("per_page") Integer perPage){

        return carParkService.search(new LocationCriteria(latitude,longitude), new PagingCriteria(page,perPage));
    }

}
