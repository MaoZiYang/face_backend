package com.maohacker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author: mzy
 * @Date: 2019-3-21 16:05
 */
@Service
public class roleRankService {
    @Autowired
    @Qualifier("roleRankDao")
    private com.maohacker.dao.roleRankDao roleRankDao;
    @SuppressWarnings("all")
    public Map qryRankInfo(Map param){
        Map result =  roleRankDao.qryRankInfo(param);
        return result;
    }

    @SuppressWarnings("all")
    public Map qrymoduleListInfo(Map param){
        Map result =  roleRankDao.qrymoduleListInfo(param);
        return result;
    }

    @SuppressWarnings("all")
    public void upManagerPwdInfo(Map param){
        roleRankDao.upManagerPwdInfo(param);
    }

    @SuppressWarnings("all")
    public void upTeacherPwdInfo(Map param){
        roleRankDao.upTeacherPwdInfo(param);
    }

    @SuppressWarnings("all")
    public List qryModuleManagr(Map param){
        List result = roleRankDao.qryModuleManagr(param);
        return result;
    }

    @SuppressWarnings("all")
    public int qryModuleManagrTotal(Map param){
        int result = roleRankDao.qryModuleManagrTotal(param);
        return result;
    }

    @SuppressWarnings("all")
    public void insertModuleManagr(Map param)  {
        roleRankDao.insertModuleManagr(param);
    }

    @SuppressWarnings("all")
    public List qryManagr(Map param)  {
        List result = roleRankDao.qryManagr(param);
        return result;
    }

    @SuppressWarnings("all")
    public int qryManagrTotal(Map param)  {
        int result = roleRankDao.qryManagrTotal(param);
        return result;
    }

    @SuppressWarnings("all")
    public Map roleInfo(Map param)  {
        Map result =  roleRankDao.roleInfo(param);
        return result;
    }

    @SuppressWarnings("all")
    public Map qryManagerListInfo(Map param)  {
        Map result =  roleRankDao.qryManagerListInfo(param);
        return result;
    }

    @SuppressWarnings("all")
    public List qryRole(Map param)  {
        List result = roleRankDao.qryRole(param);
        return result;
    }

    @SuppressWarnings("all")
    public int qryRoleTotal(Map param)  {
        int result = roleRankDao.qryRoleTotal(param);
        return result;
    }
}
