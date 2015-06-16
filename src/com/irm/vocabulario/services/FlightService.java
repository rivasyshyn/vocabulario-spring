package com.irm.vocabulario.services;

import java.util.List;

import com.irm.vocabulario.domain.a.Flight;
import com.irm.vocabulario.domain.a.FlightSearchCriteria;
import com.irm.vocabulario.domain.a.SpecialDial;

public interface FlightService {

    List<SpecialDial> getSpecialDeals();
    
    List<Flight> findFlights(FlightSearchCriteria searchCriteria);
    
}
