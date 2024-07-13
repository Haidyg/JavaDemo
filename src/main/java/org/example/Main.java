package org.example;

import org.example.config.properties.WeatherApiProperties;
import org.example.domain.Country;
import org.example.service.WeatherClient;
import org.example.service.WeatherService;

public class Main {
    public static void main(String[] args) {
        WeatherApiProperties properties =  new WeatherApiProperties();
        properties.setBaseUrl("https://api.open-meteo.com");
        properties.setUri("v1/forecast");
        properties.setDaily("temperature_2m_max");

        WeatherService service = new WeatherClient(properties);
        var response = service.getForecast(Country.EGYPT, 5)
                .join();
        System.out.println(response.getDaily().getTemperature2mMax());

    }
}
