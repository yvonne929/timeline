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
    public void uploadLabData(PatientDetails labDetails){
        String sql = "INSERT INTO lab(CAMPUS,DEPARTMENT,IDNUMBER,TIME,SPECIMEN,ORDERS,WARNING,TESTVALUE,UNIT,REFERENCEVALUE) VALUES (:campus,:department,:idnumber,:time,:specimen,:orders,:warning,:testvalue,:unit,:referencevalue)";
        Map<String, Object> map = new HashMap<>();
        map.put("campus",labDetails.getCampus());
        map.put("department",labDetails.getDepartment());
        map.put("idnumber",labDetails.getIdnumber());
        map.put("time",labDetails.getTime());
        map.put("specimen",labDetails.getSpecimen());
        map.put("orders",labDetails.getOrders());
        map.put("warning",labDetails.getWarning());
        map.put("testvalue",labDetails.getTestvalue());
        map.put("unit",labDetails.getUnit());
        map.put("referencevalue",labDetails.getReferencevalue());
        namedParameterJdbcTemplate.update(sql, map);
    }

    @Override
    public void uploadOpdData(PatientDetails opdDetails){
        String sql = "INSERT INTO opd(CAMPUS,DEPARTMENT,DEPARTMENT_NAME,IDNUMBER,TIME,ICD10_1,ICD10_N1,ICD10_2,ICD10_N2,ICD10_3,ICD10_N3,ICD10_4,ICD10_N4,ICD10_5,ICD10_N5,ICD10_6,ICD10_N6)" + 
        "VALUES (:campus,:department,:department_name,:idnumber,:time,:icd10_1,:icd10_n1,:icd10_2,:icd10_n2,:icd10_3,:icd10_n3,:icd10_4,:icd10_n4,:icd10_5,:icd10_n5,:icd10_6,:icd10_n6)";
        Map<String, Object> map = new HashMap<>();
        map.put("campus",opdDetails.getCampus());
        map.put("department",opdDetails.getDepartment());
        map.put("department_name",opdDetails.getDepartment_name());
        map.put("idnumber",opdDetails.getIdnumber());
        map.put("time",opdDetails.getTime());
        map.put("icd10_1",opdDetails.getIcd10_1());
        map.put("icd10_n1",opdDetails.getIcd10_n1());
        map.put("icd10_2",opdDetails.getIcd10_2());
        map.put("icd10_n2",opdDetails.getIcd10_n2());
        map.put("icd10_3",opdDetails.getIcd10_3());
        map.put("icd10_n3",opdDetails.getIcd10_n3());
        map.put("icd10_4",opdDetails.getIcd10_4());
        map.put("icd10_n4",opdDetails.getIcd10_n4());
        map.put("icd10_5",opdDetails.getIcd10_5());
        map.put("icd10_n5",opdDetails.getIcd10_n5());
        map.put("icd10_6",opdDetails.getIcd10_6());
        map.put("icd10_n6",opdDetails.getIcd10_n6());
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

