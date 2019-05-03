package com.maohacker.service;

        import com.maohacker.dao.universityDao;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.beans.factory.annotation.Qualifier;
        import org.springframework.stereotype.Service;

        import java.util.HashMap;
        import java.util.List;
        import java.util.Map;

@Service
public class universityService {
    @Autowired
    @Qualifier("universityDao")
    private universityDao universityDao;

    @SuppressWarnings("all")

    //查询高校的页面数据
    public Map qryUniversityInfo(Map param) {
        Map<String, Object> reMap = new HashMap<String, Object>();

        int size = universityDao.qryUniversitySize(param);
        int total = universityDao.qryUniversityTotal(param);
        List<Map> data = universityDao.qryUniversityInfo(param);
        reMap.put("data",data);
        reMap.put("size",size);
        reMap.put("total",total);
        reMap.put("code",0);
        reMap.put("message","success");
        return reMap;

    }
}
