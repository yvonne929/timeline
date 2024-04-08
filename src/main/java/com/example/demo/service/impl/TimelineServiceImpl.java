package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.TimelineDao;
import com.example.demo.service.TimelineService;


@Service
public class TimelineServiceImpl implements TimelineService {
    @Autowired
        private TimelineDao timelineDao;
    public List getListData(String idNumber) {
        List dataList = new ArrayList<>();
        try {
            dataList = timelineDao.getListData(idNumber);
            // 按照時間排序
            Collections.sort(dataList);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return dataList;
    }
}
