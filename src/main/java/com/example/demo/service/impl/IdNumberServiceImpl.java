package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IdNumberDao;
import com.example.demo.entity.Patient;
import com.example.demo.service.IdNumberService;
import com.example.demo.service.ex.UserNotFoundException;

@Service
public class IdNumberServiceImpl implements IdNumberService{
    @Autowired
        private IdNumberDao idNumberDao;

	@Override
	public Patient search(Patient idNumber) {
		// TODO Auto-generated method stub
		// 檢查患者身分證是否存在
		Patient data = idNumberDao.findIdNumber(idNumber.getIdNumber());
		if(data == null) throw new UserNotFoundException("找不到患者");
		return data;
	}

	@Override
	public Patient findIdNumber(String idNumber) {
		// TODO Auto-generated method stub
		return idNumberDao.findIdNumber(idNumber);
	}
}
