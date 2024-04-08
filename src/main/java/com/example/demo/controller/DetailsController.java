package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.service.DetailsService;

@Controller
public class DetailsController {
    @Autowired
	    private DetailsService detailsService;

    @RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
	    public String showDetails(@PathVariable("id") String idnumber) {
            detailsService.getPatientDetailsByIdnubmer(idnumber);
		return "details";
	    }
}
