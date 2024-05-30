package com.example.demo.dao;

import java.util.List;
import java.util.Map;

import com.example.demo.entity.PatientDetails;

public interface DetailsDao {
    //寫入病患資料
    public void uploadLabData(PatientDetails labDetails);
    public void uploadOpdData(PatientDetails opdDetails);

    
    //詳細病歷
    public List<Map<String, Object>> findLabById(String id);
    public List<Map<String, Object>> findOpdById(String id);
    public List<Map<String, Object>> findErById(String id);
}