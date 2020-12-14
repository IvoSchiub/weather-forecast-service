package com.idiana.weatherforecast.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.idiana.weatherforecast.enums.TemperatureScale;

import java.time.LocalDate;

public final class DailyWeatherForecast {
    private LocalDate date;
    private Double avgMaxTempDuringWorkingHours = Double.valueOf(0);
    @JsonIgnore
    private Integer maxTempSurveysDuringWorkingHours = Integer.valueOf(0);

    private Double avgMinTempDuringWorkingHours = Double.valueOf(0);
    @JsonIgnore
    private Integer minTempSurveysDuringWorkingHours = Integer.valueOf(0);

    private Double avgHumidityDuringWorkingHours = Double.valueOf(0);
    @JsonIgnore
    private Integer humiditySurveysDuringWorkingHours = Integer.valueOf(0);



    private Double avgMaxTempOutsideWorkingHours = Double.valueOf(0);
    @JsonIgnore
    private Integer maxTempSurveysOutsideWorkingHours = Integer.valueOf(0);

    private Double avgMinTempOutsideWorkingHours = Double.valueOf(0);
    @JsonIgnore
    private Integer minTempSurveysOutsideWorkingHours = Integer.valueOf(0);

    private Double avgHumidityOutsideWorkingHours = Double.valueOf(0);
    @JsonIgnore
    private Integer humiditySurveysOutsideWorkingHours = Integer.valueOf(0);

    private TemperatureScale scale = TemperatureScale.CELSIUS;

    public DailyWeatherForecast() {
    }

    public LocalDate getDate() {
        return date;
    }

    public DailyWeatherForecast setDate(LocalDate date) {
        this.date = date;
        return this;
    }

    public Double getAvgMaxTempDuringWorkingHours() {
        return avgMaxTempDuringWorkingHours;
    }

    public DailyWeatherForecast setAvgMaxTempDuringWorkingHours(Double avgMaxTempDuringWorkingHours) {
        this.avgMaxTempDuringWorkingHours = avgMaxTempDuringWorkingHours;
        return this;
    }

    public Integer getMaxTempSurveysDuringWorkingHours() {
        return maxTempSurveysDuringWorkingHours;
    }

    public void setMaxTempSurveysDuringWorkingHours(Integer maxTempSurveysDuringWorkingHours) {
        this.maxTempSurveysDuringWorkingHours = maxTempSurveysDuringWorkingHours;
    }

    public Double getAvgMinTempDuringWorkingHours() {
        return avgMinTempDuringWorkingHours;
    }

    public DailyWeatherForecast setAvgMinTempDuringWorkingHours(Double avgMinTempDuringWorkingHours) {
        this.avgMinTempDuringWorkingHours = avgMinTempDuringWorkingHours;
        return this;
    }

    public Integer getMinTempSurveysDuringWorkingHours() {
        return minTempSurveysDuringWorkingHours;
    }

    public DailyWeatherForecast setMinTempSurveysDuringWorkingHours(Integer minTempSurveysDuringWorkingHours) {
        this.minTempSurveysDuringWorkingHours = minTempSurveysDuringWorkingHours;
        return this;
    }

    public Double getAvgHumidityDuringWorkingHours() {
        return avgHumidityDuringWorkingHours;
    }

    public DailyWeatherForecast setAvgHumidityDuringWorkingHours(Double avgHumidityDuringWorkingHours) {
        this.avgHumidityDuringWorkingHours = avgHumidityDuringWorkingHours;
        return this;
    }

    public Integer getHumiditySurveysDuringWorkingHours() {
        return humiditySurveysDuringWorkingHours;
    }

    public DailyWeatherForecast setHumiditySurveysDuringWorkingHours(Integer humiditySurveysDuringWorkingHours) {
        this.humiditySurveysDuringWorkingHours = humiditySurveysDuringWorkingHours;
        return this;
    }

    public Double getAvgMaxTempOutsideWorkingHours() {
        return avgMaxTempOutsideWorkingHours;
    }

    public DailyWeatherForecast setAvgMaxTempOutsideWorkingHours(Double avgMaxTempOutsideWorkingHours) {
        this.avgMaxTempOutsideWorkingHours = avgMaxTempOutsideWorkingHours;
        return this;
    }

    public Integer getMaxTempSurveysOutsideWorkingHours() {
        return maxTempSurveysOutsideWorkingHours;
    }

    public void setMaxTempSurveysOutsideWorkingHours(Integer maxTempSurveysOutsideWorkingHours) {
        this.maxTempSurveysOutsideWorkingHours = maxTempSurveysOutsideWorkingHours;
    }

    public Double getAvgMinTempOutsideWorkingHours() {
        return avgMinTempOutsideWorkingHours;
    }

    public DailyWeatherForecast setAvgMinTempOutsideWorkingHours(Double avgMinTempOutsideWorkingHours) {
        this.avgMinTempOutsideWorkingHours = avgMinTempOutsideWorkingHours;
        return this;
    }

    public Integer getMinTempSurveysOutsideWorkingHours() {
        return minTempSurveysOutsideWorkingHours;
    }

    public DailyWeatherForecast setMinTempSurveysOutsideWorkingHours(Integer minTempSurveysOutsideWorkingHours) {
        this.minTempSurveysOutsideWorkingHours = minTempSurveysOutsideWorkingHours;
        return this;
    }

    public Double getAvgHumidityOutsideWorkingHours() {
        return avgHumidityOutsideWorkingHours;
    }

    public DailyWeatherForecast setAvgHumidityOutsideWorkingHours(Double avgHumidityOutsideWorkingHours) {
        this.avgHumidityOutsideWorkingHours = avgHumidityOutsideWorkingHours;
        return this;
    }

    public Integer getHumiditySurveysOutsideWorkingHours() {
        return humiditySurveysOutsideWorkingHours;
    }

    public DailyWeatherForecast setHumiditySurveysOutsideWorkingHours(Integer humiditySurveysOutsideWorkingHours) {
        this.humiditySurveysOutsideWorkingHours = humiditySurveysOutsideWorkingHours;
        return this;
    }

    public TemperatureScale getScale() {
        return scale;
    }

    public DailyWeatherForecast setScale(TemperatureScale scale) {
        this.scale = scale;
        return this;
    }
}