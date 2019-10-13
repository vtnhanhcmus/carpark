package com.carpark.rest.response.json;

import com.carpark.models.Availability;
import com.carpark.utils.DateUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AvailabilityJson {

    List<ItemInfoJson> items;

    public AvailabilityJson() {
    }

    public List<ItemInfoJson> getItems() {
        return items;
    }

    public void setItems(List<ItemInfoJson> items) {
        this.items = items;
    }


    public List<Availability> buildAvailability(){
        if (!CollectionUtils.isEmpty(items)){
            List<Availability> availabilities = new ArrayList<>();

            items.forEach(itemInfoJson -> {
                itemInfoJson.carParkData.forEach(carParkJson -> {
                    carParkJson.getCarParkInfos().forEach(carParkInfoJson -> {
                        availabilities.add(new Availability(
                            carParkInfoJson.getTotalLots(),
                            carParkInfoJson.getLotsAvailable(),
                            carParkInfoJson.getLotType(),
                            carParkJson.getCarParkNumber(),
                            DateUtils.convertStringToTime(carParkJson.getUpdateDatetime())
                        ));
                    });
                });
            });

            return availabilities;
        }
        return Collections.EMPTY_LIST;
    }

}
