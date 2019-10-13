package com.carpark.rest.response.json;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ItemInfoJson {

    @JsonProperty("timestamp")
    String timestamp;
    @JsonProperty("carpark_data")
    List<CarParkJson> carParkData;

    public ItemInfoJson() {
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public List<CarParkJson> getCarParkData() {
        return carParkData;
    }

    public void setCarParkData(List<CarParkJson> carParkData) {
        this.carParkData = carParkData;
    }
}
