package com.maohacker.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * @Author: mzy
 * @Date: 2019-3-20 14:47
 */
@Mapper
public interface loginDao {
    int qryloginManagerCode(Map param);
    int qryloginTeacherCode(Map param);
    Map qryloginData(Map param);
    Map qryloginManager(Map param);
    Map qryloginRole(Map param);
}
