package com.example.demo.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private NamedParameterJdbcTemplate jdbcNameTemplate;

	

	@Override
	public User findUserByUserId(String userId) {
		// TODO Auto-generated method stub
		String sql = " SELECT "
				   + "		ID, USERID, PASSWORD "
				   + " FROM "
				   + "		demo.users "
				   + " WHERE "
				   + "		USERID = ? ";

		List<User> result = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class), new Object[] { userId });
		if(result != null && result.size() > 0) {
			return result.get(0);
		}
		return null;
	}
}
