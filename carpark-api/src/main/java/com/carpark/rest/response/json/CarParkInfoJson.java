package com.carpark.rest.response.json;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class CarParkInfoJson implements Serializable {

    @JsonProperty("total_lots")
    private Integer totalLots;
    @JsonProperty("lot_type")
    private String lotType;
    @JsonProperty("lots_available")
    private Integer lotsAvailable;

    public CarParkInfoJson() {
    }

    public Integer getTotalLots() {
        return totalLots;
    }

    public void setTotalLots(int totalLots) {
        this.totalLots = totalLots;
    }

    public String getLotType() {
        return lotType;
    }

    public void setLotType(String lotType) {
        this.lotType = lotType;
    }

    public Integer getLotsAvailable() {
        return lotsAvailable;
    }

    public void setLotsAvailable(Integer lotsAvailable) {
        this.lotsAvailable = lotsAvailable;
    }
}
