package com.carpark.logics;

import com.carpark.backgroud.json.LocationJson;
import com.carpark.mappers.CarParkMapper;
import com.carpark.mappers.LocationMapper;
import com.carpark.models.Coordinates;
import com.carpark.models.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import java.util.ArrayList;
import java.util.List;

@Component
public class ConvertLocationLogic {

    @Autowired
    private LocationMapper locationMapper;
    @Autowired
    private CarParkMapper carParkMapper;
    @Autowired
    private ApiCarParkLogic apiCarParkLogic;

    @Transactional(rollbackFor = Exception.class)
    public void convertLocation(){
        List<Coordinates> coordinates = carParkMapper.findCoordinates();

        List<Location> locations = new ArrayList<>();
        if (!CollectionUtils.isEmpty(coordinates)){
            for (Coordinates coordinate : coordinates){
                LocationJson locationJson = apiCarParkLogic.apiConvert(coordinate);
                locations.add(new Location(coordinate.getCarParkNo(),locationJson.getLatitude(), locationJson.getLongitude()));
            }
        }

        locationMapper.insert(locations);

    }

}
