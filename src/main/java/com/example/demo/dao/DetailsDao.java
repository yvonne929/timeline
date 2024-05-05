package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.Lab;

public interface DetailsDao {
    public void uploadData(Lab patientDetails);

    //未完成
    public List getPatientDetailsByIdnumber(String id);
}