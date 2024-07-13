package org.example;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class WeatherClient {
    public static void main(String[] args) {
        // Create an HttpClient instances
        HttpClient client = HttpClient.newHttpClient();

        // Create an HttpRequest
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.open-meteo.com/v1/forecast?latitude=&current52.52&longitude=13.41=temperature_2m,relative_humidity_2m,wind_speed_10m"))
                .build();

        // Send the request and handle the response
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println)
               ;
        } //how to convert from json to class in java

}