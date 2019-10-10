package com.carpark.backgroud;

import com.carpark.exceptions.CronJobException;
import com.carpark.mappers.AvailabilityMapper;
import com.carpark.mappers.CarParkDataMapper;
import com.carpark.models.Availability;
import com.carpark.backgroud.json.AvailabilityJson;
import com.carpark.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import java.time.LocalDateTime;
import java.util.List;

@Component
public class ScheduledTasks {

    @Value("${api.carpark.availability}")
    private String url;

    @Autowired
    private AvailabilityMapper availabilityMapper;

    @Autowired
    private CarParkDataMapper carParkDataMapper;

    @Scheduled(cron = "${api.carpark.scheduler.pattern}")
    @Transactional(rollbackFor = Exception.class)
    public void scheduleWithCarParkAvailability() throws CronJobException {

        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders requestHeaders = new HttpHeaders();
            requestHeaders.add("Accept", MediaType.APPLICATION_JSON_VALUE);
            HttpEntity<String> requestEntity = new HttpEntity<>(requestHeaders);

            ResponseEntity<AvailabilityJson> responseEntity = restTemplate.exchange(
                    String.format(url, DateUtils.convertToSGTTime(LocalDateTime.now())),
                    HttpMethod.GET,
                    requestEntity,
                    AvailabilityJson.class
            );

            if (responseEntity.getStatusCode() == HttpStatus.OK) {
                AvailabilityJson availabilityJson = responseEntity.getBody();
                List<Availability> availabilities = availabilityJson.buildAvailability();
                carParkDataMapper.delete();
                carParkDataMapper.insert(availabilities);
                availabilityMapper.insert();
            } else {
                throw new CronJobException("Not success");
            }
        }catch (CronJobException ex){
            //add error in here
            throw ex;
        }
    }


}
