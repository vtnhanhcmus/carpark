package com.carpark.backgroud.json;

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
                itemInfoJson.carpark_data.forEach(carParkJson -> {
                    carParkJson.getCarpark_info().forEach(carParkInfoJson -> {
                        availabilities.add(new Availability(
                            carParkInfoJson.getTotal_lots(),
                            carParkInfoJson.getLots_available(),
                            carParkInfoJson.getLot_type(),
                            carParkJson.getCarpark_number(),
                            DateUtils.convertStringToTime(carParkJson.getUpdate_datetime())
                        ));
                    });
                });
            });

            return availabilities;
        }
        return Collections.EMPTY_LIST;
    }

}
