package com.carpark.mappers;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AvailabilityMapper {

    void insert();
    void delete();

}
