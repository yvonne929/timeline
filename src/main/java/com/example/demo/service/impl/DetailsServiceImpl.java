package com.example.demo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.demo.dao.DetailsDao;
import com.example.demo.entity.PatientDetails;
import com.example.demo.service.DetailsService;

@Service
public class DetailsServiceImpl implements DetailsService{
    @Autowired
    private DetailsDao detailsDao;

    //寫入病患資料
    @Override
    public void uploadLabData(PatientDetails labDetails) {
        detailsDao.uploadLabData(labDetails);
    }

    @Override
    public void uploadOpdData(PatientDetails opdDetails) {
        detailsDao.uploadOpdData(opdDetails);
    }


    //詳細病歷
    @Override
    public List<Map<String, Object>> getLabDetails(String id){
        return detailsDao.findLabById(id);
    }
    
    @Override
    public List<Map<String, Object>> getOpdDetails(String id){
        return detailsDao.findOpdById(id);
    }

    @Override
    public List<Map<String, Object>> getErDetails(String id){
        return detailsDao.findErById(id);
    }
}
