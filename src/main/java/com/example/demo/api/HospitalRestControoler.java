package com.example.demo.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class HospitalRestControoler {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @PostMapping("/dataUpload")
    public String upload(@RequestBody User user) {
        String sql = "INSERT INTO users(ID,USERID,USERNAME,PASSWORD) VALUES (:id,:userId,:username,:password)";
        Map<String, Object> map = new HashMap<>();
        map.put("id",user.getId());
        map.put("userId",user.getUserId());
        map.put("username",user.getUsername());
        map.put("password",user.getPassword());
        namedParameterJdbcTemplate.update(sql, map);
        return "success";
    }
    
}
