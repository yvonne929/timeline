package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.PatientDetails;

public interface DetailsDao {
    public void uploadData(PatientDetails patientDetails);

    //未完成
    public List getPatientDetailsByIdnumber(String id);
}