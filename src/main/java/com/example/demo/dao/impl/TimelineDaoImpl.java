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
    public List getListData(String idNumber) {
        List<Map<String, Object>> dataList = new ArrayList<>();
    try {
         // 查询
         String sqlPatientDetails = 
         "SELECT id, campus, department, idnumber, time, specimen, orders, warning, testvalue, unit, referencevalue FROM patientdetails WHERE idnumber = ? " +
         "UNION ALL " +
         "SELECT id, campus, department, idnumber, time, null as specimen, null as orders, null as warning, null as testvalue, null as unit, null as referencevalue FROM opd WHERE idnumber = ? " +
        //  "UNION ALL " +
        //  "SELECT id, campus, department, idnumber, time, null as specimen, null as orders, null as warning, null as testvalue, null as unit, null as referencevalue FROM er WHERE idnumber = ? " +
         "ORDER BY time DESC";
            List<Map<String, Object>> result = jdbcTemplate.queryForList(sqlPatientDetails, idNumber, idNumber);
            dataList.addAll(result);

        //印出結果
        for (Map<String, Object> row : dataList) {
            System.out.println(row);
        }

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return dataList;
    }
}

// String sql = "SELECT idnumber, department, time FROM patientdetails " +
//             "UNION ALL " +
//             "SELECT idnumber, department, time FROM opd" + 
//             "WHERE idnumber = ?";


//             dataList = jdbcTemplate.queryForList(sql);