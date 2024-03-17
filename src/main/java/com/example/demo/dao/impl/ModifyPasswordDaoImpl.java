package com.example.demo.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.ModifyPasswordDao;

@Repository
public class ModifyPasswordDaoImpl implements ModifyPasswordDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void updatePassword(String userId, String newPassword) {
        String sql = "UPDATE users SET password = ? WHERE userId = ?";
        jdbcTemplate.update(sql, newPassword, userId);
    }
}
