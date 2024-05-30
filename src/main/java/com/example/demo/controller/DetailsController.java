package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

		@GetMapping("/details/{department}/{id}")
    	public String getDepartmentDetails(@PathVariable("department") String department, @PathVariable("id") String id, Model model,HttpSession session) {
        
            Patient patient = (Patient) session.getAttribute("patient");

         // 檢查患者是否存在
            if (patient != null) {
            	model.addAttribute("patient", patient);
            }
            System.out.println(department);
            List<Map<String, Object>> entity; // 根據科別使用對應的Service
            if (department.equals("檢驗")) {
                entity = detailsService.getLabDetails(id);
            } else if (department.equals("門診")) {
                entity = detailsService.getOpdDetails(id);
            } else if (department.equals("急診")) {
                entity = detailsService.getErDetails(id);
            }else {
                // 處理其他科別的情況
                entity = null;
            }
            System.out.println(entity);
            model.addAttribute("entity", entity);
            return "details";
        }
}
