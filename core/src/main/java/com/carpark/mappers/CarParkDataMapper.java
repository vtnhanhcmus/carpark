package com.carpark.mappers;

import com.carpark.models.Availability;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CarParkDataMapper {
    void insert(@Param("data") List<Availability> availabilities);
    void delete();
}
