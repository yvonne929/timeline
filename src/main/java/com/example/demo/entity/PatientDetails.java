package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PatientDetails {
    private String id;
    private String idnumber;
    private String name;
    private String gender;
    private String birthday;
    private String campus;
    private String department;
    @JsonFormat(pattern = "MM/dd/yyyy HH:mm",timezone = "GMT+8")
    private java.sql.Timestamp time;
    private String specimen;
    private String orders;
    private String warning;
    private String testvalue;
    private String unit;
    private String referencevalue;
}
