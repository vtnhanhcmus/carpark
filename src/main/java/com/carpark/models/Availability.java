package com.carpark.models;

public class Availability {

    private Integer id;
    private String carParkNo;
    private String address;
    private Double xCoord;
    private Double yCoord;
    private String carParkType;
    private String typeOfParkingSystem;
    private String shortTermParking;
    private String freeParking;
    private String nightParking;
    private Integer carParkDecks;
    private Double gantryHeight;
    private String carParkBasement;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCarParkNo() {
        return carParkNo;
    }

    public void setCarParkNo(String carParkNo) {
        this.carParkNo = carParkNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getxCoord() {
        return xCoord;
    }

    public void setxCoord(Double xCoord) {
        this.xCoord = xCoord;
    }

    public Double getyCoord() {
        return yCoord;
    }

    public void setyCoord(Double yCoord) {
        this.yCoord = yCoord;
    }

    public String getCarParkType() {
        return carParkType;
    }

    public void setCarParkType(String carParkType) {
        this.carParkType = carParkType;
    }

    public String getTypeOfParkingSystem() {
        return typeOfParkingSystem;
    }

    public void setTypeOfParkingSystem(String typeOfParkingSystem) {
        this.typeOfParkingSystem = typeOfParkingSystem;
    }

    public String getShortTermParking() {
        return shortTermParking;
    }

    public void setShortTermParking(String shortTermParking) {
        this.shortTermParking = shortTermParking;
    }

    public String getFreeParking() {
        return freeParking;
    }

    public void setFreeParking(String freeParking) {
        this.freeParking = freeParking;
    }

    public String getNightParking() {
        return nightParking;
    }

    public void setNightParking(String nightParking) {
        this.nightParking = nightParking;
    }

    public Integer getCarParkDecks() {
        return carParkDecks;
    }

    public void setCarParkDecks(Integer carParkDecks) {
        this.carParkDecks = carParkDecks;
    }

    public Double getGantryHeight() {
        return gantryHeight;
    }

    public void setGantryHeight(Double gantryHeight) {
        this.gantryHeight = gantryHeight;
    }

    public String getCarParkBasement() {
        return carParkBasement;
    }

    public void setCarParkBasement(String carParkBasement) {
        this.carParkBasement = carParkBasement;
    }
}
