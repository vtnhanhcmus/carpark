package com.carpark.rest.externalapis;

import com.carpark.exceptions.ApiCarParkException;
import com.carpark.models.Availability;
import com.carpark.models.Coordinates;
import com.carpark.models.Location;
import com.carpark.rest.response.json.AvailabilityJson;
import com.carpark.rest.response.json.LocationJson;
import com.carpark.services.CarParkService;
import com.carpark.services.LocationService;
import com.carpark.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataSetCarParkApi {

    private static final String headerName = "Accept";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private Environment env;

    @Autowired
    private DataSetCarParkApi dataSetCarParkApi;

    @Autowired
    private CarParkService carParkService;

    @Autowired
    private LocationService locationService;

    /**
     * convert location 3857to4326
     */
    public void convertLocation(){
        List<Coordinates> coordinates = carParkService.findCoordinates();

        List<Location> locations = new ArrayList<>();
        if (!CollectionUtils.isEmpty(coordinates)){
            for (Coordinates coordinate : coordinates){
                LocationJson locationJson = apiConvert(coordinate);
                locations.add(new Location(coordinate.getCarParkNo(),locationJson.getLatitude(), locationJson.getLongitude()));
            }
        }

        locationService.insert(locations);

    }


    /**
     * api convert coordinates to location
     * @param coordinate
     * @return
     */
    public LocationJson apiConvert(Coordinates coordinate){

        HttpHeaders request = new HttpHeaders();
        request.add(headerName, MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<String> requestEntity = new HttpEntity<>(request);

        ResponseEntity<LocationJson> responseEntity = restTemplate.exchange(
                String.format(env.getProperty("api.carpark.convert.location"), coordinate.getyCoord(),coordinate.getxCoord()),
                HttpMethod.GET,
                requestEntity,
                LocationJson.class
        );

        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            return responseEntity.getBody();
        }

        throw new ApiCarParkException(messageSource.getMessage("api.carpark.convert.location.error", null, null));

    }

    /**
     * api get all car park availability
     * @return
     */
    public List<Availability> apiAvailability() throws ApiCarParkException{

        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add(headerName, MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<String> requestEntity = new HttpEntity<>(requestHeaders);

        ResponseEntity<AvailabilityJson> responseEntity = restTemplate.exchange(
                String.format(env.getProperty("api.carpark.availability"), DateUtils.convertToSGTTime(LocalDateTime.now())),
                HttpMethod.GET,
                requestEntity,
                AvailabilityJson.class
        );

        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            AvailabilityJson availabilityJson = responseEntity.getBody();
            return availabilityJson.buildAvailability();
        }

        throw new ApiCarParkException(messageSource.getMessage("api.carpark.availability.error", null, null));
    }


}
