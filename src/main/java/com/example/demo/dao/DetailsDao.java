package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.PatientDetails;

public interface DetailsDao {
    public void uploadLabData(PatientDetails labDetails);
    public void uploadOpdData(PatientDetails opdDetails);

    //未完成
    public List getPatientDetailsByIdnumber(String id);
}