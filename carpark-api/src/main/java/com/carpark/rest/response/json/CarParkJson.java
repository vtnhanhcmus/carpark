package com.carpark.rest.response.json;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CarParkJson {

    @JsonProperty("carpark_info")
    private List<CarParkInfoJson> carParkInfos;
    @JsonProperty("carpark_number")
    private String carParkNumber;
    @JsonProperty("update_datetime")
    private String updateDatetime;

    public CarParkJson() {
    }

    public List<CarParkInfoJson> getCarParkInfos() {
        return carParkInfos;
    }

    public void setCarParkInfos(List<CarParkInfoJson> carParkInfos) {
        this.carParkInfos = carParkInfos;
    }

    public String getCarParkNumber() {
        return carParkNumber;
    }

    public void setCarParkNumber(String carParkNumber) {
        this.carParkNumber = carParkNumber;
    }

    public String getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(String updateDatetime) {
        this.updateDatetime = updateDatetime;
    }
}
