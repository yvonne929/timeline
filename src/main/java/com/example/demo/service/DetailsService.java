package com.example.demo.service;

import com.example.demo.entity.PatientDetails;

public interface DetailsService {
    public void uploadData(PatientDetails patientDetails);
    public void getPatientDetailsByIdnumber(String idnumber);
}