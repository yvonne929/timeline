package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.PatientDetails;

public interface DetailsService {
    public void uploadData(PatientDetails patientDetails);

    //未完成
    public List getPatientDetailsByIdnumber(String id);
}