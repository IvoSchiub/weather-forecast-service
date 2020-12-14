package com.idiana.weatherforecast.resources;

import com.idiana.weatherforecast.model.WeatherForecast;
import com.idiana.weatherforecast.service.WeatherForecastService;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Collections;
import java.util.Optional;

@Path("/weather")
@Produces(MediaType.APPLICATION_JSON)
@RestController
public class WeatherForecastResource {

    private WeatherForecastService weatherForecastService;

    public WeatherForecastResource(WeatherForecastService weatherForecastService) {
        this.weatherForecastService = weatherForecastService;
    }

    @GET
    @Path("/{city}")
    public WeatherForecast weatherForecastByCity(@PathParam("city") String city) {
        Optional<WeatherForecast> maybeWeatherForecast = weatherForecastService.retrieveWeatherForecastByCityName(city);

        return maybeWeatherForecast.orElse(new WeatherForecast().setCity(city).setDailyWeatherForecasts(Collections.emptyList()));
    }
}