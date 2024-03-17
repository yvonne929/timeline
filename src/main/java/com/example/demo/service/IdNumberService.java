package com.example.demo.service;

import com.example.demo.entity.Patient;

public interface IdNumberService {

    public Patient search(Patient idNumber);
    public Patient findIdNumber(String idNumber);
}