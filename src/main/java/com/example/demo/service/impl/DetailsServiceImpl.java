package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.dao.DetailsDao;
import com.example.demo.entity.User;
import com.example.demo.service.DetailsService;

@Component
public class DetailsServiceImpl implements DetailsService{
    @Autowired
    private DetailsDao detailsDao;

    @Override
    public void uploadData(User user) {
        detailsDao.uploadData(user);
    }
}
