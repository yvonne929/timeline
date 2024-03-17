package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ModifyPasswordDao;
import com.example.demo.service.ModifyPasswordService;

@Service
public class ModifyPasswordServiceImpl implements ModifyPasswordService{
    @Autowired
    private ModifyPasswordDao modifyPasswordDao;

    @Override
    public void modifyPassword(String userId, String newPassword) {
        // 此處可以添加一些業務邏輯，例如檢查密碼複雜性等
        modifyPasswordDao.updatePassword(userId, newPassword);
    }
}
