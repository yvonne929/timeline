package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entity.Patient;
import com.example.demo.service.TimelineService;

import jakarta.servlet.http.HttpSession;

@Controller
public class TimelineController {
    @Autowired
    TimelineService timelineService;

    @RequestMapping(value = "/timeline", method = RequestMethod.GET)
    public String timeline(HttpSession session, Model model) {
        // 從 session 中取得搜尋到的病人資訊

        Patient patient = (Patient) session.getAttribute("patient");

            // 檢查患者是否存在
            if (patient != null) {
            // 將患者身分證字號放入模型中
            String idnumber = patient.getIdNumber();
            // 將病人資訊放入模型中，以在 timeline.html 中顯示
            model.addAttribute("patient", patient);
            List dataList = timelineService.getListData(idnumber);
            //System.out.println("@@@dataList:" + dataList.size());
            model.addAttribute("dataList", dataList);
            }
        return "timeline";

    }

    @RequestMapping(value = "/details", method = RequestMethod.GET)
	    public String details() {
		
		return "details";
	    }
}