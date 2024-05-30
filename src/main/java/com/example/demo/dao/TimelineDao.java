package com.example.demo.dao;

import java.util.List;
import java.util.Map;

public interface TimelineDao {
    public List getListData(String idNumber);

    public List<Map<String, Object>> findLabById(String id);
    public List<Map<String, Object>> findOpdById(String id);
}
