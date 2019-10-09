package com.carpark.mappers;

import com.carpark.models.CarPark;
import com.carpark.request.LocationCriteria;
import com.carpark.request.PagingCriteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CarParkMapper {
    List<CarPark> search(@Param("location") LocationCriteria location,
                         @Param("page")PagingCriteria pagingCriteria);
    Integer count(@Param("location") LocationCriteria location);
}
