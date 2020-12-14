package com.idiana.weatherforecast.model;

import java.util.Collection;

public class WeatherForecast {
    String city;
    Collection<DailyWeatherForecast> dailyWeatherForecasts;

    public WeatherForecast() {
    }

    public String getCity() {
        return city;
    }

    public WeatherForecast setCity(String city) {
        this.city = city;
        return this;
    }

    public Collection<DailyWeatherForecast> getDailyWeatherForecasts() {
        return dailyWeatherForecasts;
    }

    public WeatherForecast setDailyWeatherForecasts(Collection<DailyWeatherForecast> dailyWeatherForecasts) {
        this.dailyWeatherForecasts = dailyWeatherForecasts;
        return this;
    }
}