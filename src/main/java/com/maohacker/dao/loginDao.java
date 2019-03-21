package com.maohacker.dao;

import java.util.List;
import java.util.Map;

/**
 * @Author: mzy
 * @Date: 2019-3-20 14:47
 */
public interface loginDao {
    int qryloginManagerCode(Map param)throws Exception;
    int qryloginTeacherCode(Map param)throws Exception;
    Map qryloginData(Map param)throws Exception;
    Map qryloginManager(Map param)throws Exception;
    Map qryloginRole(Map param)throws Exception;
}
