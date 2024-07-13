package org.example.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Daily {
    private List<String> time;
    @JsonProperty("temperature_2m_max")
    private List<Double> temperature2mMax;

    // Getters and setters
    public List<String> getTime() {
        return time;
    }

    public void setTime(List<String> time) {
        this.time = time;
    }

    public List<Double> getTemperature2mMax() {
        return temperature2mMax;
    }

    public void setTemperature2mMax(List<Double> temperature_2m_max) {
        this.temperature2mMax = temperature_2m_max;
    }
}
