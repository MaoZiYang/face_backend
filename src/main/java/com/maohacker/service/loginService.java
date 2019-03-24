package com.maohacker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.maohacker.dao.loginDao;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author: mzy
 * @Date: 2019-3-20 14:48
 */
@Service
public class loginService {
    @Autowired
    @Qualifier("loginDao")
    private loginDao loginDao;
    @SuppressWarnings("all")
    //查询Manager表的Code值,用于登录
    public int qryloginManagerCode(Map param){
        int result =  loginDao.qryloginManagerCode(param);
        return result;
    }
    //查询Teacher表的Code值,用于登录
    public int qryloginTeacherCode(Map param){
        int result =  loginDao.qryloginTeacherCode(param);
        return result;
    }

    //查询登录的页面数据
    public Map qryloginData(Map param){
        Map result =  loginDao.qryloginData(param);
        return result;
    }

    //查询登录的用户信息
    public Map qryloginManager(Map param){
        Map result =  loginDao.qryloginManager(param);
        return result;
    }


    //查询登录的角色信息
    public Map qryloginRole(Map param){
        Map result =  loginDao.qryloginRole(param);
        return result;
    }



}
