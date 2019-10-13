package com.carpark.mappers;

import com.carpark.criterias.SearchCriteria;
import com.carpark.models.Coordinates;
import com.carpark.models.Nearest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CarParkMapper {
    List<Nearest> search(@Param("search") SearchCriteria searchCriteria);
    Integer count(@Param("search") SearchCriteria searchCriteria);
    List<Coordinates> findCoordinates();
    void delete();
}
