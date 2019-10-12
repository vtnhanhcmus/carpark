package com.carpark.criterias;

public class SearchCriteria {

    private Double latitude;
    private Double longitude;
    private Integer perPage;
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
