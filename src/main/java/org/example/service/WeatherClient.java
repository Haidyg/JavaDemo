package org.example.service;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.config.properties.WeatherApiProperties;
import org.example.domain.Country;
import org.example.domain.WeatherResponse;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

import static java.lang.String.format;

public class WeatherClient implements WeatherService {
    private final HttpClient httpClient;
    private final WeatherApiProperties properties;
    private final ObjectMapper objectMapper;
    public WeatherClient(WeatherApiProperties properties){
        this.httpClient = HttpClient.newHttpClient();
        this.properties = properties;
        this.objectMapper = new ObjectMapper();
        this.objectMapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
        this.objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }


    @Override
    public CompletableFuture<WeatherResponse> getForecast(Country country, Integer days) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(format(
                        "%s/%s?longitude=%s&latitude=%s&daily=%s&forecast_days=%d",
                        properties.getBaseUrl(),
                        properties.getUri(),
                        country.getLon(),
                        country.getLat(),
                        properties.getDaily(),
                        days
                        )))
                .build();

        return httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenApply(response -> {
                    try {
                        return objectMapper.readValue(response, WeatherResponse.class);
                    } catch (Exception e) {
                        throw new RuntimeException("Failed to parse JSON response", e);
                    }
                });

    }

    @Override
    public WeatherResponse getTodayForecast(Country country) {
        return null;
    }

    @Override
    public WeatherResponse getForecastByCity(String lat, String lon, Integer days) {
        return null;
    }
}