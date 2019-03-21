package com.maohacker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

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

    public Map PermissionsInfo(Map param) throws Exception {
        Map result =  roleRankDao.qryPermissionsInfo(param);
        return result;
    }
}
