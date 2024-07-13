package org.example.service;

import org.example.domain.Country;
import org.example.domain.WeatherResponse;

import java.util.concurrent.CompletableFuture;

public interface WeatherService {
    CompletableFuture<WeatherResponse> getForecast(Country country, Integer days);
    WeatherResponse getTodayForecast(Country country);
    WeatherResponse getForecastByCity(String lat, String lon, Integer days);
}
