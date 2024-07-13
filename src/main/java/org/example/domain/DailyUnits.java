package org.example.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DailyUnits {
    private String time;
    @JsonProperty("temperature_2m_max")
    private String temperature2mMax;

    // Getters and setters
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTemperature2mMax() {
        return temperature2mMax;
    }

    public void setTemperature2mMax(String temperature_2m_max) {
        this.temperature2mMax = temperature_2m_max;
    }
}
