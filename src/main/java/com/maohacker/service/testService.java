package com.maohacker.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.maohacker.dao.testDao;
import java.util.List;
import java.util.Map;
/**
 * @Author: mzy
 * @Date: 2019-3-19 15:13
 */
@Service
public class testService {
    @Autowired
    @Qualifier("testDao")
    private testDao testDao;
    @SuppressWarnings("all")
    public List<Map> testInfo(Map param)  {
        Map a=param;
        List<Map> result =  testDao.selectPerson(param);
        return result;
    }
}
