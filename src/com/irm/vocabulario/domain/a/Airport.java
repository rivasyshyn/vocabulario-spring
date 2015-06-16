package com.irm.vocabulario.domain.a;

public class Airport {

    private String name;
    private String airportCode;

    public Airport(String name, String airportCode) {
        this.name = name;
        this.airportCode = airportCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAirportCode() {
        return airportCode;
    }

    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }

}
