package com.idiana.weatherforecast.model;

import com.idiana.weatherforecast.enums.TemperatureScale;
import com.idiana.weatherforecast.utils.WeatherForecastPopulateUtils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Iterator;

public class WeatherForecastTest {

	@Test
	public void weatherForecastDTOConstruction() {
		WeatherForecast weatherF = WeatherForecastPopulateUtils.populateWeatherForecastDTO("Milan", LocalDate.of(2018, 10, 1));
		Assertions.assertThat(weatherF).isNotNull();
		Assertions.assertThat(weatherF.getCity()).isNotNull().isEqualTo("Milan");
		Assertions.assertThat(weatherF.getDailyWeatherForecasts()).isNotNull();
		Assertions.assertThat(weatherF.getDailyWeatherForecasts().size()).isEqualTo(3);

		Iterator<DailyWeatherForecast> iterator = weatherF.getDailyWeatherForecasts().iterator();
		DailyWeatherForecast first = iterator.next();
		Assertions.assertThat(first.getDate()).isNotNull().isEqualTo("2018-10-01");
		Assertions.assertThat(first.getAvgHumidityDuringWorkingHours()).isNotNull().isEqualTo(12);
		Assertions.assertThat(first.getAvgMaxTempDuringWorkingHours()).isNotNull().isEqualTo(10);
		Assertions.assertThat(first.getAvgMaxTempOutsideWorkingHours()).isNotNull().isEqualTo(5);
		Assertions.assertThat(first.getScale()).isNotNull().isEqualTo(TemperatureScale.CELSIUS);

		DailyWeatherForecast second = iterator.next();
		Assertions.assertThat(second.getDate()).isNotNull().isEqualTo("2018-10-02");
		Assertions.assertThat(second.getAvgHumidityDuringWorkingHours()).isNotNull().isEqualTo(13);
		Assertions.assertThat(second.getAvgMaxTempDuringWorkingHours()).isNotNull().isEqualTo(11);
		Assertions.assertThat(second.getAvgMaxTempOutsideWorkingHours()).isNotNull().isEqualTo(6);
		Assertions.assertThat(second.getScale()).isNotNull().isEqualTo(TemperatureScale.CELSIUS);

		DailyWeatherForecast third = iterator.next();
		Assertions.assertThat(third.getDate()).isNotNull().isEqualTo("2018-10-03");
		Assertions.assertThat(third.getAvgHumidityDuringWorkingHours()).isNotNull().isEqualTo(14);
		Assertions.assertThat(third.getAvgMaxTempDuringWorkingHours()).isNotNull().isEqualTo(12);
		Assertions.assertThat(third.getAvgMaxTempOutsideWorkingHours()).isNotNull().isEqualTo(7);
		Assertions.assertThat(third.getScale()).isNotNull().isEqualTo(TemperatureScale.CELSIUS);
	}
}