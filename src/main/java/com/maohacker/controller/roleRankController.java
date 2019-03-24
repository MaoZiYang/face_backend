package com.maohacker.controller;

import com.maohacker.service.loginService;
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
 * 说明:角色控制入口(含:左侧菜单栏,密码修改模块,模块管理模板)
 */
@RestController
@EnableAutoConfiguration
@RequestMapping("/a/u")
public class roleRankController {
    private static Logger logger=Logger.getLogger(roleRankController.class);
    @Autowired
    @Qualifier("roleRankService")
    private com.maohacker.service.roleRankService roleRankService;
    private com.maohacker.service.loginService loginService;


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
     * 密码修改接口
     * 调用接口示例:http://localhost:8080/a/u/pwd?name=admin&pwd=123456&newPwd=123456&newPwdAgain=123456
     * 请求方式:PUT
     * @param response
     * @return Map
     */
    @SuppressWarnings("all")
    @RequestMapping(value = "/pwd", method = RequestMethod.PUT)
    public Map upPwdInfo(HttpServletRequest request,HttpServletResponse response){
        int CODE=-1;
        String message = null;
        Map<String,Object> reMap = new HashMap<String, Object>();
        try {
            Map param = this.buildParameter(request);
            CODE = loginService.qryloginManagerCode(param);
            if(CODE == 0){//假如,没有在管理表找到信息,在到教师表找
                 roleRankService.upManagerPwdInfo(param);
                message = "success";
            }else if(CODE == 1){
                CODE = loginService.qryloginTeacherCode(param);
                if(CODE == 0){
                    roleRankService.upTeacherPwdInfo(param);
                    message = "success";
                }else if(CODE == -5004){
                    CODE = -5006;
                    message = "您输入的用户名或旧密码有误!";
                }
            }
            reMap.put("code", CODE);
            reMap.put("message", message);
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
     * 模块管理接口
     * 调用接口示例:http://localhost:8080/a/u/module/?page=1&size=10
     * 请求方式:GET
     * @param response
     * @return Map
     */
    @SuppressWarnings("all")
    @RequestMapping(value = "/module/", method = RequestMethod.GET)
    public Map<String, Object> qryModuleManagrInfo(HttpServletRequest request,HttpServletResponse response){
        int CODE=-1;
        String message = null;
        Map<String,Object> reMap = new HashMap<String, Object>();
        Map<String,Object> data = new HashMap<String, Object>();
        Map<String,Object> param = new HashMap<String, Object>();
        try{
            int page = Integer.parseInt(request.getParameterValues("page")[0]);
            int size = Integer.parseInt(request.getParameterValues("size")[0]);
            param.put("start", (page-1)*size);
            param.put("end", (page-1)*size+size);
            int total = roleRankService.qryModuleManagrTotal(param);
            List ORDER_NUM = roleRankService.qryModuleManagr(param);
            int ids[] = new int[ORDER_NUM.size()];//定义一个数组用于响应前端的模块管理请求
            for(int i = 0;i<ORDER_NUM.size();i++){//将List<Map>中的每个value值取出来
                Map map = (Map)ORDER_NUM.get(i);
                int str = (int)map.get("id");
                ids[i]=str;
            }
            if(page*size<total){
                data.put("next",true);
            }else {
                data.put("next",false);
            }
            data.put("page", page);
            data.put("size", size);
            data.put("total",total);
            data.put("ids", ids);
            reMap.put("data", data);
            reMap.put("code", 0);
            reMap.put("message", "success");
        }catch(Exception e){
            logger.error("错误信息:"+e.getMessage());
            reMap.put("total", 0);
            reMap.put("resultMsg", e.getMessage());
            reMap.put("resultFlag", "发生错误!");
        }
        return reMap;
    }

    /**
     * 模块管理--新增模块--接口
     * 调用接口示例:http://localhost:8080/a/u/module?name=1&menuID=2&url=3&parentID=4&type=5&level=0
     * 请求方式:POST
     * @param response
     * @return Map
     */
    @SuppressWarnings("all")
    @RequestMapping(value = "/module", method = RequestMethod.POST)
    public Map<String, Object> insertModuleManagrInfo(HttpServletRequest request,HttpServletResponse response){
        Map<String,Object> reMap = new HashMap<String, Object>();
        try{
            Map param = this.buildParameter(request);
            roleRankService.insertModuleManagr(param);
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




    public roleRankController(loginService loginService) {
            this.loginService = loginService;
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
