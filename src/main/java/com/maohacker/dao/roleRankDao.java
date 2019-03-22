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
    Map qryRankInfo(Map param)throws Exception;
    Map qrymoduleListInfo(Map param)throws Exception;
}
