package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Lab;

public interface DetailsService {
    public void uploadData(Lab patientDetails);

    //未完成
    public List getPatientDetailsByIdnumber(String id);
}