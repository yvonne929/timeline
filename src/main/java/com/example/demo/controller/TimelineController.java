package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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
public class TimelineController {
    @Autowired
    TimelineService timelineService;
    @Autowired
    private JdbcTemplate jdbcTemplate;

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


    @GetMapping("/timeline/getDateDetails")
    @ResponseBody
    public String getDateDetails(@RequestParam String id, @RequestParam String department) {
        // 根據ID和Department查找對應的資料
        String sql;
        List<Map<String, Object>> results;
        
        switch (department) {
            case "檢驗":
                sql = "SELECT * FROM lab WHERE id = ?";
                results = jdbcTemplate.queryForList(sql, id);
                break;
            case "門診":
                sql = "SELECT * FROM opd WHERE id = ?";
                results = jdbcTemplate.queryForList(sql, id);
                break;
            case "急診":
                sql = "SELECT * FROM er WHERE id = ?";
                results = jdbcTemplate.queryForList(sql, id);
                break;
            default:
                return "<p>沒有找到對應的資料。</p>";
        }

        if (results.isEmpty()) {
            return "<p>沒有找到對應的資料。</p>";
        }

        // 根據不同的department構建不同的HTML
        StringBuilder details = new StringBuilder();
         details.append("<div style=\"font-size: 28px; color: black;\">");
        if (results.isEmpty()) {
            // 如果結果為空，建構一個空的HTML框
            details.append("<p>沒有相關資料。</p>");
        } 
        else {

            switch (department) {
                case "檢驗":
                    for (Map<String, Object> row : results) {
                        details.append("<span>campus: ").append(row.get("campus")).append("<br>");
                        details.append("<span>time: ").append(row.get("time")).append("<br>");
                        details.append("<span>specimen: ").append(row.get("specimen")).append("<br>");
                        details.append("<span>orders: ").append(row.get("orders")).append("<br>");
                    }
                    break;
                case "門診":
                    for (Map<String, Object> row : results) {
                        details.append("<span>campus: ").append(row.get("campus")).append("<br>");
                        details.append("<span>time: ").append(row.get("time")).append("<br>");
                        details.append("<span>department_name: ").append(row.get("department_name")).append("<br>");
                    }
                    break;
                case "急診":
                    for (Map<String, Object> row : results) {
                        details.append("<span>campus: ").append(row.get("campus")).append("<br>");
                        details.append("<span>time: ").append(row.get("time")).append("<br>");
                        details.append("<span>department_name: ").append(row.get("department_name")).append("<br>");
                    }
                    break;
        }
        }
        details.append("</div>");
        return details.toString();
    }
}