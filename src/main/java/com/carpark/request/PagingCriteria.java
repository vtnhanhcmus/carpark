package com.carpark.request;

import java.util.Objects;

public class PagingCriteria {

    private static final int DEFAULT_SIZE = 20;
    private static final int DEFAULT_PAGE = 1;
    private Integer offset;
    private Integer size;
    private Integer page;

    public PagingCriteria(Integer size, Integer page) {
        this.size = size;
        this.page = page;
    }

    public Integer getOffset() {
        return (this.page - 1) * this.size;
    }

    public Integer getSize() {
        return Objects.isNull(size) ? DEFAULT_SIZE : size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getPage() {
        return Objects.isNull(page) ? DEFAULT_PAGE : page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Boolean isValidOffset(Integer totalElements){
        return offset >= totalElements;
    }
}
