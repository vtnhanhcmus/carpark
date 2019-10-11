package com.carpark.api;

import com.carpark.response.json.AvailabilityJson;
import com.carpark.response.json.LocationJson;
import com.carpark.exceptions.ApiCarParkException;
import com.carpark.models.Availability;
import com.carpark.models.Coordinates;
import com.carpark.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.time.LocalDateTime;
import java.util.List;

@Component
public class ApiCarParkLogic {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${api.carpark.convert.location}")
    private String urlCoordinate;

    @Value("${api.carpark.availability}")
    private String urlAvailability;

    @Autowired
    private MessageSource messageSource;

    private static final String headerName = "Accept";


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
                String.format(urlCoordinate, coordinate.getyCoord(),coordinate.getxCoord()),
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
    public List<Availability> apiGetCarParkAvailability() throws ApiCarParkException{

        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add(headerName, MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<String> requestEntity = new HttpEntity<>(requestHeaders);

        ResponseEntity<AvailabilityJson> responseEntity = restTemplate.exchange(
                String.format(urlAvailability, DateUtils.convertToSGTTime(LocalDateTime.now())),
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
