package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.PatientDetails;

public interface DetailsService {
    public void uploadLabData(PatientDetails labDetails);
    public void uploadOpdData(PatientDetails opdDetails);

    //未完成
    public List getPatientDetailsByIdnumber(String id);
}