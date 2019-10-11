package com.carpark.criterias;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class SearchCriteria {

    @NotNull
    @Min(value = -90, message = "must be above or equal -90")
    @Max(value = 90, message = "must be less or equal 90")
    private Double latitude;

    @NotNull
    @Min(value = -180, message = "must be above or equal -180")
    @Max(value = 180, message = "must be less or equal 180")
    private Double longitude;

    @NotNull
    @Min(value = 1, message = "must be above or equal 1")
    private Integer perPage;
    @NotNull
    @Min(value = 1, message = "must be above or equal 1")
    private Integer page;

    public SearchCriteria() {
    }

    public SearchCriteria(Double latitude, Double longitude, Integer perPage, Integer page) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.perPage = perPage;
        this.page = page;
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

    public Integer getOffset() {
        return  (page - 1) * perPage;
    }

    public Integer getPerPage() {
        return perPage;
    }

    public void setPerPage(Integer perPage) {
        this.perPage = perPage;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }



}
