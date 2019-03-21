package com.maohacker.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.maohacker.service.testService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: mzy
 * @Date: 2019-3-18 15:42
 * 调用接口示例:http://localhost:8080/testboot/1.json?id=1
 * 请求方式:POST
 */
@RestController
@EnableAutoConfiguration
@RequestMapping("/testboot")
public class testController {
    private static Logger logger=Logger.getLogger(testController.class);  //在类的成员变量处声明
    @Autowired//自动把bean里面引用的对象的setter/getter方法省略
    @Qualifier("testService")//进行自动注入
    private testService testService;
    @SuppressWarnings("all")
    @RequestMapping(value = "/1.json", method = RequestMethod.POST)
    public Map<String, Object> Info(HttpServletRequest request,
                                                HttpServletResponse response){
        Map<String,Object> reMap = new HashMap<String, Object>();
        try{
            Map param = this.buildParameter(request);
            List data = testService.testInfo(param);
            reMap.put("data", data);
            reMap.put("resultFlag", "T");
        }catch(Exception e){
            logger.error("错误信息:"+e.getMessage());
            reMap.put("total", 0);
            reMap.put("rows", null);
            reMap.put("resultMsg", e.getMessage());
            reMap.put("resultFlag", "F");
        }
        return reMap;
    }

    /**
     * 内部方法：获取前台参数
     * @return Map<String,Object>z
     */
    @SuppressWarnings("all")
    private Map<String,Object> buildParameter(HttpServletRequest request){
        Map<String, Object> parameter = new HashMap<String, Object>();
        java.util.Enumeration<String> paremEnu = null;
        paremEnu = request.getParameterNames();
        while (paremEnu.hasMoreElements()) {
            String paramName = paremEnu.nextElement();
            parameter.put(paramName, request.getParameter(paramName));
        }
        return parameter;
    }
}
