package com.carpark.mappers;

import com.carpark.criterias.SearchCriteria;
import com.carpark.models.CarPark;
import com.carpark.models.Coordinates;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CarParkMapper {
    List<CarPark> search(@Param("search") SearchCriteria searchCriteria);
    Integer count(@Param("search") SearchCriteria searchCriteria);
    List<Coordinates> findCoordinates();
}
