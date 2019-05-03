package com.maohacker.controller;

import com.maohacker.common.ParamUtil;
import com.maohacker.service.universityService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述;高校信息入口
 *
 * @Author: mzy
 * @Date: 2019-4-16 9:55
 */
@RestController
@EnableAutoConfiguration
@RequestMapping("/a/company")
public class universityController {
    private static Logger logger = Logger.getLogger(universityController.class);  //在类的成员变量处声明
    @Autowired//自动把bean里面引用的对象的setter/getter方法省略
    @Qualifier("universityService")//进行自动注入
    private universityService universityService;

    @SuppressWarnings("all")
    /**
     * 返回高校信息接口
     * 调用接口示例:http://localhost/face-admin-ajax/a/company/search?page=1&size=10
     * 请求方式:GET
     * @param response
     * @return Map
     */
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public Map<String, Object> qryUniversityInfo(HttpServletRequest request, HttpServletResponse response) {
        String message = null;
        Map<String, Object> reMap = new HashMap<String, Object>();
        Map<String, Object> paramMap = new HashMap<String, Object>();
//        Map<String, Object> data = new HashMap<String, Object>();
        try {
            Map param = ParamUtil.buildParameter(request);
            paramMap.put("page",Integer.parseInt(String.valueOf(param.get("page"))));
            paramMap.put("size",Integer.parseInt(String.valueOf(param.get("size"))));
            reMap = universityService.qryUniversityInfo(paramMap);
        } catch (Exception e) {
            logger.error("错误信息:" + e.getMessage());
            reMap.put("total", 0);
            reMap.put("resultMsg", e.getMessage());
            reMap.put("resultFlag", "发生错误!");
        }
        return reMap;
    }
}
