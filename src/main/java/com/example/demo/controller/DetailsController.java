package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.example.demo.entity.Patient;
import com.example.demo.service.DetailsService;

import jakarta.servlet.http.HttpSession;

@Controller
public class DetailsController {
    @Autowired
	    private DetailsService detailsService;

		@RequestMapping(value = "/details", method = RequestMethod.GET)
	    public String showDetails(HttpSession session,Model model) {
			Patient patient = (Patient) session.getAttribute("patient");

            // 檢查患者是否存在
            if (patient != null) {
            	model.addAttribute("patient", patient);
			}

			//未完成
			// List details = detailsService.getPatientDetailsByIdnumber(id);
			// model.addAttribute("details", details);
			return "details";
		}
		// @RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
	    // public String showDetails(@PathVariable("id") String idnumber ,Model model) {
        //     //List record = detailsService.getPatientDetailsByIdnubmer(idnumber);
		// 	//model.addAttribute("record", record);
		// return "details";
	    // }
}
