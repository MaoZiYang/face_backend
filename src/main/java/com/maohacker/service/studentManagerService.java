package com.maohacker.service;

import com.maohacker.dao.studentManagerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class studentManagerService {
    @Autowired
    @Qualifier("studentManagerDao")
    private studentManagerDao studentManagerDao;

    @SuppressWarnings("all")

    //查询高校的页面数据
    public Map qryUniversityInfo(Map param) {
        Map<String, Object> reMap = new HashMap<String, Object>();

        int size = studentManagerDao.qrystudentManagerSize(param);
        int total = studentManagerDao.qrystudentManagerTotal(param);
        List<Map> data = studentManagerDao.qrystudentManagerInfo(param);
        reMap.put("data", data);
        reMap.put("size", size);
        reMap.put("total", total);
        reMap.put("code", 0);
        reMap.put("message", "success");
        return reMap;

    }
}