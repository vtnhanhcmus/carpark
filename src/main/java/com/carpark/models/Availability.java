package com.carpark.models;

import java.time.LocalDateTime;

public class Availability {

    private Integer totalLots;
    private Integer availableLots;
    private String lotType;
    private String carParkNo;
    private LocalDateTime updateDatetime;

    public Availability() {
    }

    public Availability(Integer totalLots, Integer availableLots, String lotType, String carParkNo, LocalDateTime updateDatetime) {
        this.totalLots = totalLots;
        this.availableLots = availableLots;
        this.lotType = lotType;
        this.carParkNo = carParkNo;
        this.updateDatetime = updateDatetime;
    }

    public Integer getTotalLots() {
        return totalLots;
    }

    public void setTotalLots(Integer totalLots) {
        this.totalLots = totalLots;
    }

    public Integer getAvailableLots() {
        return availableLots;
    }

    public void setAvailableLots(Integer availableLots) {
        this.availableLots = availableLots;
    }

    public String getLotType() {
        return lotType;
    }

    public void setLotType(String lotType) {
        this.lotType = lotType;
    }

    public String getCarParkNo() {
        return carParkNo;
    }

    public void setCarParkNo(String carParkNo) {
        this.carParkNo = carParkNo;
    }

    public LocalDateTime getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(LocalDateTime updateDatetime) {
        this.updateDatetime = updateDatetime;
    }
}
