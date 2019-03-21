package com.maohacker.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: mzy
 * @Date: 2019-3-21 16:04
 * 调用接口示例:http://localhost:8080/a/u/role/1
 * 请求方式:GET
 */
@RestController
@EnableAutoConfiguration
@RequestMapping("/a/u/role")
public class roleRankController {
    private static Logger logger=Logger.getLogger(testController.class);
    @Autowired
    @Qualifier("roleRankService")
    private com.maohacker.service.roleRankService roleRankService;
    @SuppressWarnings("all")
    //权限等级为一级的接口
    @RequestMapping(value = "/1", method = RequestMethod.GET)
    public Map<String, Object> oneRankInfo(
                                    HttpServletResponse response){
        Map<String,Object> reMap = new HashMap<String, Object>();
        Map<String,Object> data = new HashMap<String, Object>();
        Map<String,Object> rankID = new HashMap<String, Object>();
        try{
            rankID.put("rank",1);
            Map role = roleRankService.qryRankInfo(rankID);
            Map permissionsSet= roleRankService.PermissionsInfo(rankID);
            role.put("permissionsSet",permissionsSet);
            data.put("rid",1);
            data.put("role",role);
            reMap.put("data", data);
            reMap.put("code", 0);
            reMap.put("message", "success");
        }catch(Exception e){
            logger.error("错误信息:"+e.getMessage());
            reMap.put("total", 0);
            reMap.put("rows", null);
            reMap.put("resultMsg", e.getMessage());
            reMap.put("resultFlag", "F");
        }
        return reMap;
    }
    //权限等级为二级的接口
    @RequestMapping(value = "/2", method = RequestMethod.GET)
    public Map<String, Object> twoRankInfo(
            HttpServletResponse response){
        Map<String,Object> reMap = new HashMap<String, Object>();
        Map<String,Object> data = new HashMap<String, Object>();
        try{

        }catch(Exception e){
            logger.error("错误信息:"+e.getMessage());
            reMap.put("total", 0);
            reMap.put("rows", null);
            reMap.put("resultMsg", e.getMessage());
            reMap.put("resultFlag", "F");
        }
        return reMap;
    }
    //权限等级为三级的接口
    @RequestMapping(value = "/3", method = RequestMethod.GET)
    public Map<String, Object> threeRankInfo(
            HttpServletResponse response){
        Map<String,Object> reMap = new HashMap<String, Object>();
        Map<String,Object> data = new HashMap<String, Object>();
        try{

        }catch(Exception e){
            logger.error("错误信息:"+e.getMessage());
            reMap.put("total", 0);
            reMap.put("rows", null);
            reMap.put("resultMsg", e.getMessage());
            reMap.put("resultFlag", "F");
        }
        return reMap;
    }

//    /**
//     * 内部方法：获取前台参数
//     * @return Map<String,Object>z
//     */
//    @SuppressWarnings("all")
//    private Map<String,Object> buildParameter(HttpServletRequest request){
//        Map<String, Object> parameter = new HashMap<String, Object>();
//        java.util.Enumeration<String> paremEnu = null;
//        paremEnu = request.getParameterNames();
//        while (paremEnu.hasMoreElements()) {
//            String paramName = paremEnu.nextElement();
//            parameter.put(paramName, request.getParameter(paramName));
//        }
//        return parameter;
//    }
}
