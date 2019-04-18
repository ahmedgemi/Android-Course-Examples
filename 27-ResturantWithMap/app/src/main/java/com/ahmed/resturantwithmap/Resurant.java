package com.ahmed.resturantwithmap;

import com.google.android.gms.maps.model.LatLng;

public class Resurant {

    private String name;
    private String url;
    private LatLng location;

    public Resurant(String name, String url, LatLng location) {
        this.name = name;
        this.url = url;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public LatLng getLocation() {
        return location;
    }

    public void setLocation(LatLng location) {
        this.location = location;
    }
}
