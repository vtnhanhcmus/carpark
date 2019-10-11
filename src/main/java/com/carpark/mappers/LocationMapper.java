package com.carpark.mappers;

import com.carpark.models.Location;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LocationMapper {

    void insert(@Param("locations") List<Location> locations);
}
