package org.example.domain;

public enum Country {
    EGYPT("30.0444","31.2357"),
    USA("37.0902", "95.7129");


    private final String lat;
    private final String lon;
    Country(String lat, String lon){
        this.lat = lat;
        this.lon = lon;
    }
    public String getLat() {
        return lat;
    }

    public String getLon() {
        return lon;
    }


}
