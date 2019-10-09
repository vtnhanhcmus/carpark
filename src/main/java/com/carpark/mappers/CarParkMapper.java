package com.carpark.mappers;

import com.carpark.models.CarPark;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CarParkMapper {
    List<CarPark> findBy(@Param("latitude") Double latitude, @Param("longitude") Double longitude);
}
