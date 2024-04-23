package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.dao.DetailsDao;
import com.example.demo.entity.PatientDetails;
import com.example.demo.service.DetailsService;

@Service
public class DetailsServiceImpl implements DetailsService{
    @Autowired
    private DetailsDao detailsDao;

    @Override
    public void uploadData(PatientDetails patientDetails) {
        detailsDao.uploadData(patientDetails);
    }

    //未完成
    @Override
    public List getPatientDetailsByIdnumber(String id){
            List dataList = new ArrayList<>();
            try {
                dataList = detailsDao.getPatientDetailsByIdnumber(id);
            } catch (Exception e) {
                System.out.println(e.toString());
            }
            return dataList;
    }
}
