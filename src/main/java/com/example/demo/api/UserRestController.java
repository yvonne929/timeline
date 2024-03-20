package com.example.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.enums.HttpState;
import com.example.demo.service.UserService;
import com.example.demo.utils.JsonResult;

//檢查使用者名稱是否已經被使用
@RestController
@RequestMapping(value = "/api/user")
public class UserRestController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
	public JsonResult<Boolean> checkUsernameDuplicate(@RequestParam(value = "userId") String userId) {
		
		User result = userService.findUserByUserId(userId);
		return new JsonResult<Boolean>(HttpState.SUCCESS.getState(), result != null ? true : false);
	}
	
}
