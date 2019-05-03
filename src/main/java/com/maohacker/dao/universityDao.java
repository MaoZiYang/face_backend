package com.maohacker.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface universityDao {
    List<Map> qryUniversityInfo(Map param);
    int qryUniversitySize(Map param);
    int qryUniversityTotal(Map param);
}
