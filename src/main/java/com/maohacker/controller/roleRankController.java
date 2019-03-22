package com.maohacker.controller;

import com.maohacker.common.permissionsSet;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: mzy
 * @Date: 2019-3-21 16:04
 * 说明:角色权限范围控制入口(含:菜单栏)
 */
@RestController
@EnableAutoConfiguration
@RequestMapping("/a/u")
public class roleRankController {
    private static Logger logger=Logger.getLogger(roleRankController.class);
    @Autowired
    @Qualifier("roleRankService")
    private com.maohacker.service.roleRankService roleRankService;


        /**
         * 返回权限等级为一级的菜单编辑接口
         * 调用接口示例:http://localhost:8080/a/u/role/1
         * 请求方式:GET
         * @param response
         * @return Map
         */
        @SuppressWarnings("all")
        @RequestMapping(value = "/role/1", method = RequestMethod.GET)
        public Map<String, Object> oneRankInfo(
                HttpServletResponse response){
            Map<String,Object> reMap = new HashMap<String, Object>();
            Map<String,Object> data = new HashMap<String, Object>();
            Map<String,Object> rankID = new HashMap<String, Object>();
            try{
                rankID.put("rank",1);
                Map role = roleRankService.qryRankInfo(rankID);
                Map permissionsSet1=permissionsSet.rank_Map1();
                role.put("permissionsSet",permissionsSet1);
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

        /**
         * 返回权限等级为二级的菜单编辑接口
         * 调用接口示例:http://localhost:8080/a/u/role/2
         * 请求方式:GET
         * @param response
         * @return Map
         */
        @SuppressWarnings("all")
        @RequestMapping(value = "/role/2", method = RequestMethod.GET)
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

        /**
         * 返回权限等级为三级的菜单编辑接口
         * 调用接口示例:http://localhost:8080/a/u/role/3
         * 请求方式:GET
         * @param response
         * @return Map
         */
        @SuppressWarnings("all")
        @RequestMapping(value = "/role/3", method = RequestMethod.GET)
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

    /**
     * 返回相关等级权限的菜单列表内容接口
     * 调用接口示例:http://localhost:8080/a/u/multi/module?ids=1&ids=2&ids=3&ids=6&ids=7&ids=64&ids=65&ids=66&ids=67&ids=68
     * 请求方式:GET
     * @param response
     * @return Map
     */
    @SuppressWarnings("all")
    @RequestMapping(value = "/multi/module", method = RequestMethod.GET)
    public Map<String, Object> moduleListInfo(HttpServletRequest request,
            HttpServletResponse response){
        Map<String,Object> reMap = new HashMap<String, Object>();
        Map<String,Object> data = new HashMap<String, Object>();
        Map<String,Object> param = new HashMap<String, Object>();
        List<Map<String, Object>> listModuleList = new ArrayList<Map<String, Object>>();
        try {
            int total = request.getParameterValues("ids").length;
            for (int i = 0; i < total; i++) {
                param.put("ids", request.getParameterValues("ids")[i]);
                Map moduleList = roleRankService.qrymoduleListInfo(param);
                listModuleList.add(moduleList);
        }
            data.put("moduleList", listModuleList);
            data.put("total", total);
            data.put("page",null);
            data.put("size", null);
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
