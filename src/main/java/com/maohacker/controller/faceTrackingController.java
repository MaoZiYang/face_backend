package com.maohacker.controller;

import com.google.gson.Gson;
import com.maohacker.common.sameAPI;
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
import java.util.List;
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
    private static Logger logger = Logger.getLogger(faceTrackingController.class);
    @Autowired
    @Qualifier("faceTrackingService")
    private faceTrackingService faceTrackingService;

    /**
     * 人脸匹配--接口
     * 调用接口示例:http://localhost:8080/face/faceTracking.json&base64=.........
     * 请求方式:POST
     *
     * @param response
     * @return Map
     */
    @SuppressWarnings("all")
    @RequestMapping(value = "/faceTracking.json", method = RequestMethod.POST)
    public Map<String, Object> StudentSignInfo(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> face_tokenMap = new HashMap<String, Object>();
        Map<String, Object> nameMap = new HashMap<String, Object>();//签到返回的学生姓名nameMap
        String NAME=null;
        String value = null;
        String face_token = null;//对应图库的face_token值
        Gson gson = new Gson();
        List<Map> listData = null;
        Map<String, Object> searchResultMap = new HashMap<String, Object>();
        Map<String, Object> reMap = new HashMap<String, Object>();
        HashMap<String, String> map = new HashMap<>();
        HashMap<String, byte[]> byteMap = new HashMap<>();
        byte[] buff = new byte[0];
        try {
            Map image_base64 = this.buildParameter(request);//获取前台传来的base64格式的图片
            for (Object key : image_base64.keySet()) {//获取前台传来的map的value,即:base6    4格式
                value = (String) image_base64.get(key);
            }
            String url = "https://api-cn.faceplusplus.com/facepp/v3/search";
            map.put("api_key", sameAPI.api_key);
            map.put("api_secret", sameAPI.api_secret);
            map.put("image_base64", value);
            map.put("outer_id", sameAPI.outer_id);
            byte[] bacd = sameAPI.post(url, map, byteMap);
            String str = new String(bacd);
            System.out.println(str);
            searchResultMap = gson.fromJson(str, searchResultMap.getClass());//将API传回来的String类型json转到searchResultMap中
            if (searchResultMap.get("results") != null) {
                listData = (List<Map>) searchResultMap.get("results");
                Map<String, Object> resultsMap = listData.get(0);
                Double confidence = (Double) resultsMap.get("confidence");
                if (confidence > 70) {//置信度,大于70,代表极有可能同一个人
                    face_token = (String) resultsMap.get("face_token");
                    face_tokenMap.put("face_token",face_token);
                    nameMap = faceTrackingService.qryStudentSignInfo(face_tokenMap);
                    NAME = (String) nameMap.get("name");
                    reMap.put("code", 0);
                    reMap.put("message", NAME+"同学,签到成功!");
                }else {
                    reMap.put("code", 0);
                    reMap.put("message","该学生不在班级名单内!");
                }
            }else{
                reMap.put("code", 0);
                reMap.put("message", "未检测到人脸,请重新调整!");
            }
        } catch (Exception e) {
            logger.error("错误信息:" + e.getMessage());
            reMap.put("total", 0);
            reMap.put("resultMsg", e.getMessage());
            reMap.put("resultFlag", "发生错误!");
        }
        return reMap;
    }


    /**
     * 内部方法：获取前台参数
     *
     * @return Map<String,Object>
     */
    @SuppressWarnings("all")
    private Map<String, Object> buildParameter(HttpServletRequest request) {
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
