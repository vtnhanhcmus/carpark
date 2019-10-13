package com.carpark.rest.response.json;

import java.io.Serializable;

public class CarParkInfoJson implements Serializable {

    private Integer total_lots;
    private String lot_type;
    private Integer lots_available;

    public CarParkInfoJson() {
    }

    public Integer getTotal_lots() {
        return total_lots;
    }

    public void setTotal_lots(int total_lots) {
        this.total_lots = total_lots;
    }

    public String getLot_type() {
        return lot_type;
    }

    public void setLot_type(String lot_type) {
        this.lot_type = lot_type;
    }

    public Integer getLots_available() {
        return lots_available;
    }

    public void setLots_available(Integer lots_available) {
        this.lots_available = lots_available;
    }
}
