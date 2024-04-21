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
        String sql1 = "SELECT department, time FROM patientdetails WHERE idnumber = ? ORDER BY time DESC";
        List<Map<String, Object>> result1 = jdbcTemplate.queryForList(sql1, idNumber);
        dataList.addAll(result1);

        String sql2 = "SELECT department,time FROM opd WHERE idnumber = ? ORDER BY time DESC";
        List<Map<String, Object>> result2 = jdbcTemplate.queryForList(sql2, idNumber);
        dataList.addAll(result2);

        //印出結果
        for (Map<String, Object> row : dataList) {
            System.out.println(row);
        }
            System.out.println(dataList);
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