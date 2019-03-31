package com.maohacker.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.maohacker.service.faceTrackingService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: mzy
 * @Date: 2019-3-20 14:47
 * 说明:人脸识别签到入口(含:检测人脸)
 */
@RestController
@EnableAutoConfiguration
@RequestMapping("/face")
public class faceTrackingController {
    private static Logger logger=Logger.getLogger(faceTrackingController.class);
    @Autowired
    @Qualifier("faceTrackingService")
    private faceTrackingService faceTrackingService;
    /**
     * 人脸匹配--接口
     * 调用接口示例:http://localhost:8080/face/faceTracking.json&base64=.........
     * 请求方式:POST
     * @param response
     * @return Map
     */
    @SuppressWarnings("all")
    @RequestMapping(value = "/faceTracking.json", method = RequestMethod.POST)
    public Map<String, Object> insertModuleManagrInfo(HttpServletRequest request, HttpServletResponse response){
        Map<String,Object> reMap = new HashMap<String, Object>();
        try{
            Map param = this.buildParameter(request);
            System.out.println("param......................"+param);
//            faceTrackingService.insertModuleManagr(param);
            reMap.put("code", 0);
            reMap.put("message", "新增成功!");
        }catch(Exception e){
            logger.error("错误信息:"+e.getMessage());
            reMap.put("total", 0);
            reMap.put("resultMsg", e.getMessage());
            reMap.put("resultFlag", "发生错误!");
        }
        return reMap;
    }

    /**
     * 内部方法：获取前台参数
     * @return Map<String,Object>
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
