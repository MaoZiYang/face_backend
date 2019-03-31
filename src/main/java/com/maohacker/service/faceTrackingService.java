package com.maohacker.service;

import com.maohacker.dao.faceTrackingDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Author: mzy
 * @Date: 2019-3-31 13:36
 */
@Service
public class faceTrackingService {
    @Autowired
    @Qualifier("faceTrackingDao")
    private faceTrackingDao faceTrackingDao;
    @SuppressWarnings("all")
    //查询登录的页面数据
    public Map qryStudentSignInfo(Map param){
        Map result =  faceTrackingDao.qryStudentSignInfo(param);
        return result;
    }
}
