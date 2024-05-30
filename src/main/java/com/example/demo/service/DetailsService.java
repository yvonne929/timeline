package com.example.demo.service;

import java.util.List;
import java.util.Map;

import com.example.demo.entity.PatientDetails;

public interface DetailsService {
    //寫入病患資料
    public void uploadLabData(PatientDetails labDetails);
    public void uploadOpdData(PatientDetails opdDetails);

    
    //詳細病歷
    public List<Map<String, Object>> getLabDetails(String id);
    public List<Map<String, Object>> getOpdDetails(String id);
    public List<Map<String, Object>> getErDetails(String id);
}