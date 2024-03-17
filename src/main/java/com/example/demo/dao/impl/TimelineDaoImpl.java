package com.example.demo.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.example.demo.dao.TimelineDao;


@Repository
public class TimelineDaoImpl implements TimelineDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List getListData(String idNumber) {
        List dataList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM patients WHERE idNumber = ?";
            dataList = jdbcTemplate.queryForList(sql, idNumber);

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return dataList;
    }
}

