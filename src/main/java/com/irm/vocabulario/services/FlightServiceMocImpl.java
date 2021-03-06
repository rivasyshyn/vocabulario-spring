package com.irm.vocabulario.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.irm.vocabulario.domain.a.Airport;
import com.irm.vocabulario.domain.a.Flight;
import com.irm.vocabulario.domain.a.FlightLeg;
import com.irm.vocabulario.domain.a.FlightSearchCriteria;
import com.irm.vocabulario.domain.a.SpecialDial;

@Service("flightService")
public class FlightServiceMocImpl implements FlightService {
    
    @Override
    public List<SpecialDial> getSpecialDeals() {
        List<SpecialDial> specialDials = new ArrayList<SpecialDial>(3);
        specialDials.add(new SpecialDial(
                new Airport("Beijing Capital International Airport", "PEK"), new Airport(
                        "Chicago O'Hare International", "ORD"), new BigDecimal("45.8"), new Date(),
                new Date()));
        specialDials.add(new SpecialDial(new Airport("Los Angeles International", "LAX"),
                new Airport("Soekarno-Hatta International", "CGK"), new BigDecimal("66.0"),
                new Date(), new Date()));
        specialDials.add(new SpecialDial(new Airport("Frankfurt am Main International", "FRA"),
                new Airport("George Bush Intercontinental Houston", "IAH"), new BigDecimal("89.9"),
                new Date(), new Date()));
        return specialDials;
    }

    @Override
    public List<Flight> findFlights(FlightSearchCriteria searchCriteria) {
        List<Flight> flights = new ArrayList<Flight>();

        List<FlightLeg> flightLegs = new ArrayList<FlightLeg>();
        flightLegs.add(new FlightLeg(new Airport("Beijing Capital International Airport", "PEK"),
                new Date(), new Airport("Soekarno-Hatta International", "CGK"), new Date()));
        flightLegs.add(new FlightLeg(new Airport("Chicago O'Hare International", "ORD"),
                new Date(), new Airport("Soekarno-Hatta International", "CGK"), new Date()));
        flightLegs.add(new FlightLeg(new Airport("Soekarno-Hatta International", "CGK"),
                new Date(), new Airport("Los Angeles International", "LAX"), new Date()));

        flights.add(new Flight(flightLegs, new BigDecimal("150.6")));

        flightLegs = new ArrayList<FlightLeg>();
        flightLegs.add(new FlightLeg(new Airport("Frankfurt am Main International", "FRA"),
                new Date(), new Airport("Soekarno-Hatta International", "CGK"), new Date()));

        flights.add(new Flight(flightLegs, new BigDecimal("59.9")));

        flightLegs = new ArrayList<FlightLeg>();
        flightLegs.add(new FlightLeg(new Airport("Chicago O'Hare International", "ORD"),
                new Date(), new Airport("Soekarno-Hatta International", "CGK"), new Date()));
        flightLegs.add(new FlightLeg(new Airport("Frankfurt am Main International", "FRA"),
                new Date(), new Airport("Soekarno-Hatta International", "CGK"), new Date()));

        flights.add(new Flight(flightLegs, new BigDecimal("64.0")));

        return flights;
    }
}
