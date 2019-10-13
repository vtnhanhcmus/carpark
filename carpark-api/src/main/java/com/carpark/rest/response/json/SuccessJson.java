package com.carpark.rest.response.json;

public class SuccessJson {

    private Boolean result;

    public SuccessJson(Boolean result) {
        this.result = result;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }
}
