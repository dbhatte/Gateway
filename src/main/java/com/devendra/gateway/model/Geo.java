package com.devendra.gateway.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by devendra on 26/01/2017.
 */
public class Geo {
    @JsonProperty("lat")
    private String latitude;

    @JsonProperty("lng")
    private String longitude;


    public String getLatitude() {
        return latitude;
    }


    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }


    public String getLongitude() {
        return longitude;
    }


    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }


    @Override
    public String toString() {
        return "Geo{" +
                "latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                '}';
    }
}
