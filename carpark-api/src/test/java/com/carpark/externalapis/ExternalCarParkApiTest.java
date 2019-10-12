package com.carpark.externalapis;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.Silent.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class ExternalCarParkApiTest {

    @InjectMocks
    private ExternalCarParkApi externalCarParkApi;

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private Environment env;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        when(env.getProperty("api.carpark.availability")).thenReturn("https://api.data.gov.sg/v1/transport/carpark-availability?date_time=%s");
        when(env.getProperty("api.carpark.convert.location")).thenReturn("https://developers.onemap.sg/commonapi/convert/3857to4326?Y=%s&X=%s");
    }


    /**
     * test api availability
     */
    @Test
    public void test01(){

        externalCarParkApi.apiAvailability();
        ArgumentCaptor<RequestEntity> requestEntityArgumentCaptor = ArgumentCaptor.forClass(RequestEntity.class);
        verify(restTemplate, times(1)).exchange(requestEntityArgumentCaptor.capture(), eq(String.class));
        RequestEntity requestEntity = requestEntityArgumentCaptor.getValue();
        assertEquals(HttpMethod.GET, requestEntity.getMethod());
        HttpHeaders headers = requestEntity.getHeaders();
        assertEquals(MediaType.APPLICATION_JSON, headers.getContentType());
    }



}
