package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dao.DetailsDao;
import com.example.demo.entity.PatientDetails;
import com.example.demo.service.DetailsService;

@Component
public class DetailsServiceImpl implements DetailsService{
    @Autowired
    private DetailsDao detailsDao;

    @Override
    public void uploadData(PatientDetails patientDetails) {
        detailsDao.uploadData(patientDetails);
    }

    @Override
    public void getPatientDetailsByIdnubmer(String idnumber){
        detailsDao.getPatientDetailsByIdnumber(idnumber);
    }
}
