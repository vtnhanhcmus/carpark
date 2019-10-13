package com.carpark.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DummyMapper {

    void dummyFromCsv(@Param("path") String path);

}
