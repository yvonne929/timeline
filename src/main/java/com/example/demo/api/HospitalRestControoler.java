package com.example.demo.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.PatientDetails;
import com.example.demo.entity.User;
import com.example.demo.service.DetailsService;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class HospitalRestControoler {
    @Autowired
    private DetailsService detailsService;

    @PostMapping("/dataUpload")
    public String upload(@RequestBody PatientDetails patientDetails) {
        detailsService.uploadData(patientDetails);
        return "success";
    }
}
