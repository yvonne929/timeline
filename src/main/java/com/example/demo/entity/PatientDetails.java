package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PatientDetails {
    private String id;
    private String ic;
    private String name;
    private String gender;
    private String birthday;
    private String department;
    private String time;
    private String descriptions;
}
