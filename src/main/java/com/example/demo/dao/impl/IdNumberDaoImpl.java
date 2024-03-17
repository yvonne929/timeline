package com.example.demo.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.IdNumberDao;
import com.example.demo.entity.Patient;

@Repository
public class IdNumberDaoImpl implements IdNumberDao{
    @Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private NamedParameterJdbcTemplate jdbcNameTemplate;

    @Override
	public Patient findIdNumber(String idNumber) {
		// TODO Auto-generated method stub
		String sql = " SELECT "
				   + "		* "
				   + " FROM "
				   + "		demo.patients "
				   + " WHERE "
				   + "		idNumber = ? ";

		List<Patient> result = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Patient>(Patient.class), new Object[] { idNumber });
		if(result != null && result.size() > 0) {
			return result.get(0);
		}
		return null;
	}
}
