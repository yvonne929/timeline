package com.example.demo.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.demo.dao.DetailsDao;
import com.example.demo.entity.Patient;
import com.example.demo.entity.Lab;

@Component
public class DetailsDaoImpl implements DetailsDao{
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public void uploadData(Lab patientDetails){
        String sql = "INSERT INTO patientdetails(CAMPUS,DEPARTMENT,IDNUMBER,TIME,SPECIMEN,ORDERS,WARNING,TESTVALUE,UNIT,REFERENCEVALUE) VALUES (:campus,:department,:idnumber,:time,:specimen,:orders,:warning,:testvalue,:unit,:referencevalue)";
        Map<String, Object> map = new HashMap<>();
        map.put("campus",patientDetails.getCampus());
        map.put("department",patientDetails.getDepartment());
        map.put("idnumber",patientDetails.getIdnumber());
        map.put("name",patientDetails.getName());
        map.put("gender",patientDetails.getGender());
        map.put("birthday",patientDetails.getBirthday());
        map.put("time",patientDetails.getTime());
        map.put("specimen",patientDetails.getSpecimen());
        map.put("orders",patientDetails.getOrders());
        map.put("warning",patientDetails.getWarning());
        map.put("testvalue",patientDetails.getTestvalue());
        map.put("unit",patientDetails.getUnit());
        map.put("referencevalue",patientDetails.getReferencevalue());
        namedParameterJdbcTemplate.update(sql, map);
    }

    //未完成
    @Override
    public List getPatientDetailsByIdnumber(String id) {
        List<Map<String, Object>> dataList = new ArrayList<>();
        try {
            String sql1 = "SELECT * FROM patientdetails WHERE department = ? AND id = ? ";
            List<Map<String, Object>> result1 = jdbcTemplate.queryForList(sql1, id);
            dataList.addAll(result1);

            String sql2 = "SELECT * FROM opd WHERE department = ? AND id = ? ";
            List<Map<String, Object>> result2 = jdbcTemplate.queryForList(sql2, id);
            dataList.addAll(result2);

            for (Map<String, Object> row : dataList) {
            System.out.println(row);
            }

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return dataList;
    }
}

