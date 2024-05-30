package com.example.demo.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.example.demo.dao.TimelineDao;



@Repository
public class TimelineDaoImpl implements TimelineDao{
@Autowired
private JdbcTemplate jdbcTemplate;

    @Override
    public List<Map<String, Object>> getListData(String idNumber) {
    List<Map<String, Object>> dataList = new ArrayList<>();
        try {
            String sqlPatientDetails = "SELECT id, campus, department, idnumber, time, specimen, orders, warning, testvalue, unit, referencevalue FROM lab WHERE idnumber = ? " +
            "UNION ALL " +
            "SELECT id, campus, department, idnumber, time, null as specimen, null as orders, null as warning, null as testvalue, null as unit, null as referencevalue FROM opd WHERE idnumber = ? " +
            "UNION ALL " +
            "SELECT id, campus, department, idnumber, time, null as specimen, null as orders, null as warning, null as testvalue, null as unit, null as referencevalue FROM er WHERE idnumber = ? " +
            "ORDER BY time DESC";
                    

            List<Map<String, Object>> result = jdbcTemplate.queryForList(sqlPatientDetails, idNumber, idNumber, idNumber);
            dataList.addAll(result);
                        
                for (Map<String, Object> row : dataList) {
                    System.out.println(row);
                }
                        
            } catch (Exception e) {
                System.out.println(e.toString());
            }
                            
                return dataList;
    }

    @Override
    public List<Map<String, Object>> findLabById(String id){
        String sql = "SELECT * FROM lab WHERE id = ?";
        return jdbcTemplate.queryForList(sql, id);
    }

    @Override
    public List<Map<String, Object>> findOpdById(String id) {
        String sql = "SELECT * FROM opd WHERE id = ?";
        return jdbcTemplate.queryForList(sql, id);
    }
}

