package com.carpark.models;


public class Location {

    private String carParkNo;
    private Double latitude;
    private Double longitude;

    public Location() {
    }

    public Location(String carParkNo, Double latitude, Double longitude) {
        this.carParkNo = carParkNo;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getCarParkNo() {
        return carParkNo;
    }

    public void setCarParkNo(String carParkNo) {
        this.carParkNo = carParkNo;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
