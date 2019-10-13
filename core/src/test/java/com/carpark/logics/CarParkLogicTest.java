package com.carpark.logics;

import com.carpark.criterias.SearchCriteria;
import com.carpark.exceptions.PagingException;
import com.carpark.mappers.CarParkMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;

import java.util.Collections;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.Silent.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class CarParkLogicTest {

    @InjectMocks
    private CarParkLogic carParkLogic;

    @Mock
    private MessageSource messageSource;

    @Mock
    private CarParkMapper carParkMapper;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        when(messageSource.getMessage("page.range.error", null, null)).
                thenReturn("offset can not bigger than total records");
    }


    /**
     * test function find all coordinates
     */
    @Test
    public void test00(){
        when(carParkLogic.findCoordinates()).thenReturn(Collections.EMPTY_LIST);
    }

    /**
     * Test search exception with offset > totalRecords
     */
    @Test
    public void test01(){

        Double latitude = 0.3480936981054125;
        Double longitude = 0.25992014061340224;
        Integer perPage = 20;
        Integer page = 10;
        SearchCriteria searchCriteria = new SearchCriteria(latitude, longitude, perPage, page);

        when(carParkMapper.count(searchCriteria)).thenReturn(10);

        try {
            carParkLogic.search(searchCriteria);
            fail("Method should throw exception");
        } catch (Exception e) {
            assertTrue(e instanceof PagingException);
            assertTrue(e.getMessage().startsWith("offset can not bigger than total records"));
        }

    }

    /**
     * Test search success
     */
    /*@Test
    public void test02(){
        Double latitude = 0.3480936981054125;
        Double longitude = 0.25992014061340224;
        Integer perPage = 20;
        Integer page = 1;
        SearchCriteria searchCriteria = new SearchCriteria(latitude, longitude, perPage, page);

        Nearest nearest = new Nearest("A1", "BLK 215 ANG MO KIO STREET 22", 28934.1777, 38749.8516);

        when(carParkMapper.count(searchCriteria)).thenReturn(1);
        when(carParkMapper.search(searchCriteria)).thenReturn(Lists.list(nearest));
        List<Nearest> carParks = carParkLogic.search(searchCriteria);
        assertEquals(1, carParks.size());
    }*/
}
