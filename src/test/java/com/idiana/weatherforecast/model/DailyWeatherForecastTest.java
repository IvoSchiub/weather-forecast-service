package com.idiana.weatherforecast.model;

import com.idiana.weatherforecast.enums.TemperatureScale;
import com.idiana.weatherforecast.utils.WeatherForecastPopulateUtils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class DailyWeatherForecastTest {

	@Test
	public void dailyWeatherForecastDTOConstruction() {
		DailyWeatherForecast weatherF = WeatherForecastPopulateUtils.populateDailyWeatherForecastDTO(LocalDate.of(2018, 10, 1), TemperatureScale.CELSIUS, 10, 5, 12);
		Assertions.assertThat(weatherF).isNotNull();
		Assertions.assertThat(weatherF.getScale()).isNotNull().isEqualTo(TemperatureScale.CELSIUS);
		Assertions.assertThat(weatherF.getAvgHumidityDuringWorkingHours()).isNotNull().isEqualTo(12);
		Assertions.assertThat(weatherF.getDate()).isNotNull().isEqualTo("2018-10-01");
		Assertions.assertThat(weatherF.getAvgMaxTempDuringWorkingHours()).isNotNull().isEqualTo(10);
		Assertions.assertThat(weatherF.getAvgMaxTempOutsideWorkingHours()).isNotNull().isEqualTo(5);
	}
}