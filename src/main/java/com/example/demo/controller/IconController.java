package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Patient;
import com.example.demo.service.TimelineService;


import jakarta.servlet.http.HttpSession;


@Controller
public class IconController {
    @Autowired
    TimelineService timelineService;

    @RequestMapping(value = "/icon", method = RequestMethod.GET)
    public String timeline(HttpSession session, Model model) {
        // 從 session 中取得搜尋到的病人資訊
        Patient patient = (Patient) session.getAttribute("patient");

        // 檢查患者是否存在
        if (patient != null) {
            // 將患者身分證字號放入模型中
            String idnumber = patient.getIdNumber();
            // 將病人資訊放入模型中，以在 icon.html 中顯示
            model.addAttribute("patient", patient);
            List<Map<String, Object>> dataList = timelineService.getListData(idnumber);
            model.addAttribute("testValues", dataList);
        }
        return "icon";
    }
     @GetMapping("/getListData")
    @ResponseBody
    public List<Map<String, Object>> getListData(@RequestParam String idNumber) {
        // 根據idNumber從服務層獲取數據
        List<Map<String, Object>> dataList = timelineService.getListData(idNumber);
        return dataList;
    }
}
