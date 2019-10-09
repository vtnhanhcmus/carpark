package com.carpark.logics;

import com.carpark.exceptions.PagingException;
import com.carpark.mappers.CarParkMapper;
import com.carpark.models.CarPark;
import com.carpark.request.LocationCriteria;
import com.carpark.request.PagingCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CarParkLogic {

    @Autowired
    private CarParkMapper carParkMapper;

    @Autowired
    MessageSource messageSource;

    public List<CarPark> search(LocationCriteria location,
                                        PagingCriteria pagingCriteria) throws PagingException{

        Integer totalRecords = carParkMapper.count(location);
        if (pagingCriteria.isValidOffset(totalRecords)){
            throw new PagingException(messageSource.getMessage("page.range.error", null, null));
        }

        List<CarPark> carParks = carParkMapper.search(location,pagingCriteria);
        return carParks;
    }

}
