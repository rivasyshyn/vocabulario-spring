package com.irm.vocabulario.controllers;

import java.lang.annotation.Native;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.irm.vocabulario.domain.a.FlightSearchCriteria;
import com.irm.vocabulario.domain.a.SpecialDial;
import com.irm.vocabulario.services.FlightService;

@Controller
@RequestMapping("/flights/**")
public class FlightsController {

    private FlightService flightService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String specialDials(Model model) {
        List<SpecialDial> specialDials = flightService.getSpecialDeals();
        model.addAttribute("specials", specialDials);
        return "deals";
    }

    @RequestMapping(value = "/search/form", method = RequestMethod.GET)
    public String search(Model model) {
        model.addAttribute("searchCriteria", new FlightSearchCriteria());
        return "search";
    }

    @InitBinder()
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat(
                "yyyy-MM-dd"), true));
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String doSearch(@ModelAttribute("searchCriteria") FlightSearchCriteria searchCriteria, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "error";
        } else {
            model.addAttribute("searchCriteria", searchCriteria);
            model.addAttribute("result", flightService.findFlights(searchCriteria));
        }
        return "searchresult";
    }

    @Autowired
    @Qualifier("flightService")
    public void setFlightService(FlightService flightService) {
        this.flightService = flightService;
    }

}
