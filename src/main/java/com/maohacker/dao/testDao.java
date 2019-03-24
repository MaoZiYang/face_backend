package com.maohacker.dao;

import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import java.util.Map;

/**
 * @Author: mzy
 * @Date: 2019-3-19 15:16
 */
@Mapper
public interface  testDao{
    List<Map> selectPerson(Map param);
}


