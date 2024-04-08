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
import com.example.demo.entity.PatientDetails;

@Component
public class DetailsDaoImpl implements DetailsDao{
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public void uploadData(PatientDetails patientDetails){
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

    @Override
    public PatientDetails getPatientDetailsByIdnumber(String idnumber) {
        PatientDetails patientDetails = null;
        try {
            String sql = "SELECT * FROM patientdetails WHERE idnumber = ?";
            List<PatientDetails> resultList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<PatientDetails>(PatientDetails.class), new Object[] { idnumber });
            PatientDetails result = null;
            if (!resultList.isEmpty()) {
                result = resultList.get(0);
            }} catch (Exception e) {
            System.out.println(e.toString());
        }
        return patientDetails;
    }
}

