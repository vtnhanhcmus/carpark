package com.carpark.logics;

import com.carpark.criterias.SearchCriteria;
import com.carpark.exceptions.PagingException;
import com.carpark.mappers.CarParkMapper;
import com.carpark.models.CarPark;
import com.carpark.models.Coordinates;
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

    public List<CarPark> search(SearchCriteria searchCriteria) throws PagingException{

        Integer totalRecords = carParkMapper.count(searchCriteria);

        if (searchCriteria.getOffset() > totalRecords){
            throw new PagingException(messageSource.getMessage("page.range.error", null, null));
        }

        List<CarPark> carParks = carParkMapper.search(searchCriteria);
        return carParks;
    }

    public List<Coordinates> findCoordinates(){
        return carParkMapper.findCoordinates();
    }

}
