package com.idiana.weatherforecast.utils;

import com.idiana.weatherforecast.model.DailyWeatherForecast;
import com.idiana.weatherforecast.model.WeatherForecast;
import com.idiana.weatherforecast.integration.List;
import com.idiana.weatherforecast.integration.WeatherForecastExt;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class WeatherForecastMapping {

    public WeatherForecast fromExtToWeatherForecast(WeatherForecastExt weatherForecastExt) {

        if(weatherForecastExt != null) {
            WeatherForecast weatherForecast = new WeatherForecast();
            weatherForecast.setCity(weatherForecastExt.getCity().getName());

            weatherForecast.setDailyWeatherForecasts(buildDailyWeatherForecasts(weatherForecastExt.getList()));

            return weatherForecast;
        }

        return null;
    }

    private Collection<DailyWeatherForecast> buildDailyWeatherForecasts(java.util.List<List> forecasts) {
        Map<String, DailyWeatherForecast> dailyForecastMap = new HashMap<>();
        forecasts.forEach(x -> mapDailyWeatherForecast(x, dailyForecastMap));

        computeAverages(dailyForecastMap);

        return dailyForecastMap.values().stream().sorted(Comparator.comparing(DailyWeatherForecast::getDate, Comparator.nullsLast(Comparator.naturalOrder()))).filter(x -> x.getDate().isBefore(LocalDate.now().plusDays(3))).collect(Collectors.toList());
    }

    private void computeAverages(Map<String, DailyWeatherForecast> dailyForecastMap) {
        for (Map.Entry<String, DailyWeatherForecast> entry : dailyForecastMap.entrySet())
        {
            DailyWeatherForecast currentDay = entry.getValue();

            currentDay.setAvgMaxTempDuringWorkingHours(currentDay.getAvgMaxTempDuringWorkingHours() / currentDay.getMaxTempSurveysDuringWorkingHours());
            currentDay.setAvgMaxTempOutsideWorkingHours(currentDay.getAvgMaxTempOutsideWorkingHours() / currentDay.getMaxTempSurveysOutsideWorkingHours());
            currentDay.setAvgHumidityDuringWorkingHours(currentDay.getAvgHumidityDuringWorkingHours() / (currentDay.getMaxTempSurveysDuringWorkingHours() + currentDay.getMaxTempSurveysOutsideWorkingHours()));
        }
    }

    private void mapDailyWeatherForecast(List currentForecast, Map<String, DailyWeatherForecast> dailyForecastMap) {
        DailyWeatherForecast currentSurvey;
        String dateStr = transformToDateWithoutTimeStr(currentForecast.getDtTxt());
        if(!dailyForecastMap.containsKey(dateStr)) {
            dailyForecastMap.put(dateStr, currentSurvey = new DailyWeatherForecast());
            currentSurvey.setDate(fromStrToDate(currentForecast.getDtTxt()));
        } else {
            currentSurvey = dailyForecastMap.get(dateStr);
        }

        sumUpSurveys(currentSurvey, currentForecast);
    }

    private String transformToDateWithoutTimeStr(String dateTimeStr) {
        return fromStrToDate(dateTimeStr).toString();
    }

    private void sumUpSurveys(DailyWeatherForecast currentSurvey, List currentForecast) {
        if(isForecastDuringWorkingHours(currentForecast.getDtTxt())) {
            sumUpMaxTempSurveyDuringWorkingHours(currentSurvey, currentForecast);
            sumUpMinTempSurveyDuringWorkingHours(currentSurvey, currentForecast);
            sumUpHumiditySurveyDuringWorkingHours(currentSurvey, currentForecast);
        } else {
            sumUpMaxTempSurveyOutsideWorkingHours(currentSurvey, currentForecast);
            sumUpMinTempSurveyOutsideWorkingHours(currentSurvey, currentForecast);
            sumUpHumiditySurveyOutsideWorkingHours(currentSurvey, currentForecast);
        }
    }

    private void sumUpMaxTempSurveyDuringWorkingHours(DailyWeatherForecast currentSurvey, List currentForecast) {
        currentSurvey.setAvgMaxTempDuringWorkingHours(currentSurvey.getAvgMaxTempDuringWorkingHours() + currentForecast.getMain().getTempMax());
        currentSurvey.setMaxTempSurveysDuringWorkingHours(currentSurvey.getMaxTempSurveysDuringWorkingHours() + 1);
    }

    private void sumUpMinTempSurveyDuringWorkingHours(DailyWeatherForecast currentSurvey, List currentForecast) {
        currentSurvey.setAvgMinTempDuringWorkingHours(currentSurvey.getAvgMinTempDuringWorkingHours() + currentForecast.getMain().getTempMin());
        currentSurvey.setMinTempSurveysDuringWorkingHours(currentSurvey.getMinTempSurveysDuringWorkingHours() + 1);
    }

    private void sumUpHumiditySurveyDuringWorkingHours(DailyWeatherForecast currentSurvey, List currentForecast) {
        currentSurvey.setAvgHumidityDuringWorkingHours(currentSurvey.getAvgHumidityDuringWorkingHours() + currentForecast.getMain().getHumidity());
    }

    private void sumUpMaxTempSurveyOutsideWorkingHours(DailyWeatherForecast currentSurvey, List currentForecast) {
        currentSurvey.setAvgMaxTempOutsideWorkingHours(currentSurvey.getAvgMaxTempOutsideWorkingHours() + currentForecast.getMain().getTempMax());
        currentSurvey.setMaxTempSurveysOutsideWorkingHours(currentSurvey.getMaxTempSurveysOutsideWorkingHours() + 1);
    }

    private void sumUpMinTempSurveyOutsideWorkingHours(DailyWeatherForecast currentSurvey, List currentForecast) {
        currentSurvey.setAvgMinTempOutsideWorkingHours(currentSurvey.getAvgMinTempOutsideWorkingHours() + currentForecast.getMain().getTempMin());
        currentSurvey.setMinTempSurveysOutsideWorkingHours(currentSurvey.getMinTempSurveysOutsideWorkingHours() + 1);
    }

    private void sumUpHumiditySurveyOutsideWorkingHours(DailyWeatherForecast currentSurvey, List currentForecast) {
        currentSurvey.setAvgHumidityDuringWorkingHours(currentSurvey.getAvgHumidityDuringWorkingHours() + currentForecast.getMain().getHumidity());
    }

    private boolean isForecastDuringWorkingHours(String dtStr) {
        LocalDateTime dateTime = fromStrToDateTime(dtStr);

        return dateTime.getHour() > 9 && dateTime.getHour() < 18;
    }

    private LocalDateTime fromStrToDateTime(String dtStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.parse(dtStr, formatter);
    }

    private LocalDate fromStrToDate(String dtStr) {
        LocalDate localDate = LocalDate.parse(dtStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        return localDate;
    }
}