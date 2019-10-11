package com.carpark.response.json;

import java.util.List;

public class ItemInfoJson {

    String timestamp;
    List<CarParkJson> carpark_data;

    public ItemInfoJson() {
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public List<CarParkJson> getCarpark_data() {
        return carpark_data;
    }

    public void setCarpark_data(List<CarParkJson> carpark_data) {
        this.carpark_data = carpark_data;
    }
}
