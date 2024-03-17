package com.example.demo.dao;

import com.example.demo.entity.Patient;

public interface IdNumberDao {
    public Patient findIdNumber(String idNumber);   
}
