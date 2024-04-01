package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Patient;
import com.example.demo.service.IdNumberService;
import com.example.demo.service.ModifyPasswordService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;


@Controller
public class IdNumberController{
    @Autowired
	    private IdNumberService idNumberService;
    @Autowired
        private ModifyPasswordService modifyPasswordService;

        //@GetMapping("/search")是下面那一行的縮寫
        @RequestMapping(value = "/search", method = RequestMethod.GET)
        public String information(
                @ModelAttribute Patient idNumber,
                @ModelAttribute(value = "MESSAGE") String message,
                    Model model,HttpSession session) {
                        
                        // 檢查使用者是否已登入
                        if (session.getAttribute("member") == null) {
                        // 未登入，導向登入頁面
                        return "redirect:login";
        }

        model.addAttribute("idNumber", idNumber);
        return "search";
        }

        @RequestMapping(value = "/search", method = RequestMethod.POST)
        public String doSearch(
                @Valid @ModelAttribute Patient idNumber,
                HttpSession session) {
            
            idNumber = idNumberService.search(idNumber);
            session.setAttribute("patient", idNumber);

            
            return "redirect:timeline";
        }

        @RequestMapping(value = "/modifyPassword", method = RequestMethod.GET)
	    public String modifyPassword() {
		
		return "modifyPassword";
	    }

        @RequestMapping(value = "modifyPassword", method = RequestMethod.POST)
        public String successModify(@RequestParam String userId, @RequestParam String newPassword) {
            modifyPasswordService.modifyPassword(userId, newPassword);
        return "redirect:login";
        }
    }


