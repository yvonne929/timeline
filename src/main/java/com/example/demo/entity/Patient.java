package com.example.demo.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Patient {
    private String id;

    @NotBlank(message = "請輸入患者身分證")
	@Pattern(regexp = "^[A-Z]\\d{9}$", 
	 		 message = "英文為大寫且數字為9碼")
    private String idNumber;
    
    private String name;
    private String gender;
    private java.sql.Date birthday;
    private String department;
    private java.sql.Date time;
}
