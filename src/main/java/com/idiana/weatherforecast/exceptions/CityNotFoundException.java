package com.idiana.weatherforecast.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "city not found")
public class CityNotFoundException extends RuntimeException {
}