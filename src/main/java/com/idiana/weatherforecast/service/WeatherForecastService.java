package com.idiana.weatherforecast.service;

import com.idiana.weatherforecast.model.WeatherForecast;
import com.idiana.weatherforecast.integration.WeatherForecastExt;
import com.idiana.weatherforecast.utils.WeatherForecastMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

import java.net.URI;
import java.util.Optional;

@Service
public class WeatherForecastService {

    private static final String FORECAST_URL ="http://api.openweathermap.org/data/2.5/forecast?q={city}&units={unit}&APPID={key}";

    private static final Logger logger = LoggerFactory.getLogger(WeatherForecastService.class);
    public static final String UNIT = "metric";
    @Value("${appkey}")
    private String appkey;

    private final RestTemplate restTemplate;
    private final WeatherForecastMapping weatherForecastMapping;

    public WeatherForecastService(RestTemplateBuilder restTemplateBuilder, WeatherForecastMapping weatherForecastMapping) {
        this.restTemplate = restTemplateBuilder.build();
        this.weatherForecastMapping = weatherForecastMapping;
    }

    @Cacheable("weatherForecast")
    public Optional<WeatherForecast> retrieveWeatherForecastByCityName(String city) {
        logger.info("Requesting weather forecast for  city {} ", city);
        URI url = new UriTemplate(FORECAST_URL).expand(city, UNIT, appkey);

        WeatherForecastExt wfExt;
        try {
            wfExt = invoke(url, WeatherForecastExt.class);
        }
        catch(org.springframework.web.client.HttpClientErrorException.NotFound notFoundException) {
            return Optional.empty();
        }

        return Optional.ofNullable(weatherForecastMapping.fromExtToWeatherForecast(wfExt));
    }

    private <T> T invoke(URI url, Class<T> responseType) {
        RequestEntity<?> request = RequestEntity.get(url)
            .accept(MediaType.APPLICATION_JSON).build();
        ResponseEntity<T> exchange = this.restTemplate
            .exchange(request, responseType);
        return exchange.getBody();
    }
}