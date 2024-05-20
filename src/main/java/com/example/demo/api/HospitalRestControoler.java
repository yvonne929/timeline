package com.example.demo.api;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.PatientDetails;
import com.example.demo.service.DetailsService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class HospitalRestControoler {
    @Autowired
    private DetailsService detailsService;

    @PostMapping("/labDataUpload")
    public String uploadLab(@RequestBody List<PatientDetails> labDetails) {
        for (PatientDetails patientdetails : labDetails) {
            detailsService.uploadLabData(patientdetails);
        }
        return "Lab data uploaded successfully";
    }

    @PostMapping("/opdDataUpload")
    public String uploadOpd(@RequestBody List<PatientDetails> opdDetails) {
        for (PatientDetails patientdetails : opdDetails) {
            detailsService.uploadOpdData(patientdetails);
        }
        return "Opd data uploaded successfully";
    }
}
