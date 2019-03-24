package com.maohacker.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @Author: mzy
 * @Date: 2019-3-21 16:06
 */
@Mapper
public interface roleRankDao {
    Map qryRankInfo(Map param);
    Map qrymoduleListInfo(Map param);
    void upManagerPwdInfo(Map param);
    void upTeacherPwdInfo(Map param);
    List<Map> qryModuleManagr(Map param);
    int qryModuleManagrTotal(Map param);
    void insertModuleManagr(Map param);
}
