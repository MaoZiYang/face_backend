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
    public Map qryRankInfo(Map param) throws Exception {
        Map result =  roleRankDao.qryRankInfo(param);
        return result;
    }

    @SuppressWarnings("all")
    public Map qrymoduleListInfo(Map param) throws Exception {
        Map result =  roleRankDao.qrymoduleListInfo(param);
        return result;
    }

    @SuppressWarnings("all")
    public void upManagerPwdInfo(Map param) throws Exception {
        roleRankDao.upManagerPwdInfo(param);
    }

    @SuppressWarnings("all")
    public void upTeacherPwdInfo(Map param) throws Exception {
        roleRankDao.upTeacherPwdInfo(param);
    }
}
