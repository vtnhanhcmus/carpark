package com.carpark.logics;

import com.carpark.criterias.SearchCriteria;
import com.carpark.exceptions.PagingException;
import com.carpark.mappers.CarParkMapper;
import com.carpark.models.Coordinates;
import com.carpark.models.Nearest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
public class CarParkLogic {

    @Autowired
    private CarParkMapper carParkMapper;

    @Autowired
    private MessageSource messageSource;

    public List<Nearest> search(SearchCriteria searchCriteria) throws PagingException{

        Integer totalRecords = carParkMapper.count(searchCriteria);

        if (searchCriteria.getOffset() > totalRecords){
            throw new PagingException(messageSource.getMessage("page.range.error", null, null));
        }

        List<Nearest> carParks = carParkMapper.search(searchCriteria);
        return carParks;
    }

    public List<Coordinates> findCoordinates(){
        return carParkMapper.findCoordinates();
    }

}
