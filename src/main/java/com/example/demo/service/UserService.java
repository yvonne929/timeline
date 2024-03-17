package com.example.demo.service;

import com.example.demo.entity.User;

public interface UserService {

	// 業務邏輯
	public User login(User memberAccount);
	
	// 資料庫操作
	public User findUserByUserId(String userId);	

}
