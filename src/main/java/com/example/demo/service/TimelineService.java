package com.example.demo.service;

import java.util.List;
import java.util.Map;

public interface TimelineService {
    public List getListData(String idNumber);
   
    public List<Map<String, Object>> getLabSummary(String id);
    public List<Map<String, Object>> getOpdSummary(String id);
    // public List<Map<String, Object>> getErSummary(String id);
} 