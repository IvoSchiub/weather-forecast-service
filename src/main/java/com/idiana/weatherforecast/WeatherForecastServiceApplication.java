package com.idiana.weatherforecast;

import com.idiana.weatherforecast.resources.WeatherForecastResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@EnableCaching
public class WeatherForecastServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherForecastServiceApplication.class, args);
	}
}


@Configuration
class JerseyConfiguration {

	@Bean
	ResourceConfig config(WeatherForecastResource resource) {
		ResourceConfig rConfig = new ResourceConfig();
		rConfig.register(resource);
		return rConfig;
	}

	@Bean
	public CacheManager cacheManager() {
		return new ConcurrentMapCacheManager("weatherForecast");
	}
}