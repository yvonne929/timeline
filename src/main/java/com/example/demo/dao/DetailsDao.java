package com.example.demo.dao;

import com.example.demo.entity.PatientDetails;

public interface DetailsDao {
    public void uploadData(PatientDetails patientDetails);
    public PatientDetails getPatientDetailsByIdnumber(String idnumber);
}