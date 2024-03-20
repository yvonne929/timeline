package com.example.demo.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.demo.dao.DetailsDao;
import com.example.demo.entity.User;

@Component
public class DetailsDaoImpl implements DetailsDao{
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public void uploadData(User user){
        String sql = "INSERT INTO users(ID,USERID,USERNAME,PASSWORD) VALUES (:id,:userId,:username,:password)";
        Map<String, Object> map = new HashMap<>();
        map.put("id",user.getId());
        map.put("userId",user.getUserId());
        map.put("username",user.getUsername());
        map.put("password",user.getPassword());
        namedParameterJdbcTemplate.update(sql, map);
    }
}
