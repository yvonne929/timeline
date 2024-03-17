package com.example.demo.controller;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@Controller
public class UserController{
	@Autowired
	private UserService userService;
	
	//主畫面(首頁)
	@RequestMapping(value = {"/", "/login"}, method = RequestMethod.GET)
	public String login(
			@ModelAttribute User user,
			@ModelAttribute(value = "MESSAGE") String message) {
		
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String doLogin(
			@Valid @ModelAttribute User user,
			HttpSession session, 
			RedirectAttributes redirectAttributes) {
		
		user  = userService.login(user);
		session.setAttribute("member", user);
		return "redirect:search";
	}
	
	
	//按下「登出」會重新導向login畫面
	@RequestMapping(value = "/logout")
	public String logout(
			HttpSession session, 
			SessionStatus sessionStatus) {

		if(session.getAttribute("member") != null){
			session.removeAttribute("member");
			sessionStatus.setComplete();
		}		
		return "redirect:login";
	}
	
}
