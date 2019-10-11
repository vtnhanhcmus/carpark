package com.carpark.cron;

import com.carpark.api.ApiCarParkLogic;
import com.carpark.response.json.LocationJson;
import com.carpark.models.Coordinates;
import com.carpark.models.Location;
import com.carpark.services.CarParkService;
import com.carpark.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Component
public class ConvertLocationLogic {


    @Autowired
    private ApiCarParkLogic apiCarParkLogic;

    @Autowired
    private CarParkService carParkService;

    @Autowired
    private LocationService locationService;

    public void convertLocation(){
        List<Coordinates> coordinates = carParkService.findCoordinates();

        List<Location> locations = new ArrayList<>();
        if (!CollectionUtils.isEmpty(coordinates)){
            for (Coordinates coordinate : coordinates){
                LocationJson locationJson = apiCarParkLogic.apiConvert(coordinate);
                locations.add(new Location(coordinate.getCarParkNo(),locationJson.getLatitude(), locationJson.getLongitude()));
            }
        }

        locationService.insert(locations);

    }

}
