package com.irm.vocabulario.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.irm.vocabulario.domain.a.FlightSearchCriteria;
import com.irm.vocabulario.domain.a.SpecialDial;
import com.irm.vocabulario.services.FlightService;

@Controller
@RequestMapping("flights")
public class FlightsController {

    private FlightService flightService;
    
    @RequestMapping(method = RequestMethod.GET)
    public String specialDials(Model model) {
        List<SpecialDial> specialDials = flightService.getSpecialDeals();
        model.addAttribute("specials", specialDials);
        return "deals";
    }

    @RequestMapping(value = "search", method = RequestMethod.GET)
    public String search(Model model) {

        return "search";
    }

    @RequestMapping(value = "search", method = RequestMethod.POST)
    public String doSearch(FlightSearchCriteria searchCriteria, BindingResult result, Model model) {

        return "search";
    }

    @Qualifier("flightService")
    public void setFlightService(FlightService flightService) {
        this.flightService = flightService;
    }

    
    
}
