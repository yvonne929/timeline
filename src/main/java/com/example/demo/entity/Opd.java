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
}
