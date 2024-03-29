package com.example.demo.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.demo.dao.DetailsDao;
import com.example.demo.entity.PatientDetails;
import com.example.demo.entity.User;

@Component
public class DetailsDaoImpl implements DetailsDao{
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public void uploadData(PatientDetails patientDetails){
        String sql = "INSERT INTO patientdetails(CAMPUS,IDNUMBER,TIME,SPECIMEN,ORDERS,WARNING,TESTVALUE,UNIT,REFERENCEVALUE) VALUES (:campus,:idnumber,:time,:specimen,:orders,:warning,:testvalue,:unit,:referencevalue)";
        Map<String, Object> map = new HashMap<>();
        map.put("campus",patientDetails.getCampus());
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
}

