package com.maohacker.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * @Author: mzy
 * @Date: 2019-3-31 21:00
 */
@Mapper
public interface faceTrackingDao {
    Map qryStudentSignInfo(Map param);
}
