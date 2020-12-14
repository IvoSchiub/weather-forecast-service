package com.idiana.weatherforecast.utils;

import com.idiana.weatherforecast.model.DailyWeatherForecast;
import com.idiana.weatherforecast.model.WeatherForecast;
import com.idiana.weatherforecast.enums.TemperatureScale;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;

public class WeatherForecastPopulateUtils {

    public static WeatherForecast populateWeatherForecastDTO(String city, LocalDate fromDate) {
        WeatherForecast weatherForecast = new WeatherForecast();
        weatherForecast.setCity(city).setDailyWeatherForecasts(Arrays.asList(
                populateDailyWeatherForecastDTO(LocalDate.of(fromDate.getYear(), fromDate.getMonthValue(), fromDate.getDayOfMonth()), TemperatureScale.CELSIUS, 10, 5, 12),
                populateDailyWeatherForecastDTO(LocalDate.of(fromDate.getYear(), fromDate.getMonthValue(), fromDate.getDayOfMonth() + 1), TemperatureScale.CELSIUS, 11, 6, 13),
                populateDailyWeatherForecastDTO(LocalDate.of(fromDate.getYear(), fromDate.getMonthValue(), fromDate.getDayOfMonth() + 2), TemperatureScale.CELSIUS, 12, 7, 14)
        ));

        return weatherForecast;
    }

    public static DailyWeatherForecast populateDailyWeatherForecastDTO(LocalDate date, TemperatureScale scale, double duringWorkingHoursMaxTemp, double outsideWorkingHoursMaxTemp, double humidity) {
        DailyWeatherForecast dailyWeatherF = new DailyWeatherForecast();
		dailyWeatherF.setDate(date).setScale(scale).setAvgMaxTempDuringWorkingHours(duringWorkingHoursMaxTemp).setAvgMaxTempOutsideWorkingHours(outsideWorkingHoursMaxTemp).setAvgHumidityDuringWorkingHours(humidity);
		return dailyWeatherF;
    }

    public static Date toDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }
}