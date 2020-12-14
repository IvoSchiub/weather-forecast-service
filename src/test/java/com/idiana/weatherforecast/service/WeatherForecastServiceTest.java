package com.idiana.weatherforecast.service;

import com.idiana.weatherforecast.utils.WeatherForecastMapping;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.client.MockRestServiceServer;

@ExtendWith(SpringExtension.class)
@RestClientTest({WeatherForecastService.class})
public class WeatherForecastServiceTest {

    @MockBean
    private WeatherForecastMapping weatherForecastMapping;

    @Autowired
    private WeatherForecastService weatherForecastService;

    @Autowired
    private MockRestServiceServer server;

    @Value("${appkey}")
    private String appkey;

    @Test
    public void shouldRetrieveWeatherForecastByCityName() {
    }
}