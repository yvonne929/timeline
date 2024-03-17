package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.util.DigestUtils;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.service.ex.UserNotFoundException;
import com.example.demo.service.ex.PasswordNotMatchException;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	
	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		// 檢查帳號是否存在
		User data = userDao.findUserByUserId(user.getUserId());
		if(data == null) throw new UserNotFoundException("帳號或密碼錯誤");

		// 比對密碼是否相等
		if(!user.getPassword().equals(data.getPassword())) throw new PasswordNotMatchException("帳號或密碼錯誤");
		
		// 將密碼設為null 後回傳
		data.setPassword(null);
		return data;
	}



	@Override
	public User findUserByUserId(String userId) {
		// TODO Auto-generated method stub
		return userDao.findUserByUserId(userId);
	}

}
