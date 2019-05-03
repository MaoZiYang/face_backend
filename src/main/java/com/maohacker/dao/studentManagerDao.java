package com.maohacker.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface studentManagerDao {
    List<Map> qrystudentManagerInfo(Map param);
    int qrystudentManagerSize(Map param);
    int qrystudentManagerTotal(Map param);
}