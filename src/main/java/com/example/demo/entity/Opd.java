package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class Opd {
        private String id;
        private String idnumber;
        private String name;
        private String gender;
        private String birthday;
        private String campus;
        private String department;
        @JsonFormat(pattern = "MM/dd/yyyy HH:mm",timezone = "GMT+8")
        private java.util.Date time;
        private String department_name;
        private String icd10_1;
        private String icd10_n1;
        private String icd10_2;
        private String icd10_n2;
        private String icd10_3;
        private String icd10_n3;
        private String icd10_4;
        private String icd10_n4;
        private String icd10_5;
        private String icd10_n5;
        private String icd10_6;
        private String icd10_n6;
}
