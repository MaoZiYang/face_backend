package com.maohacker.controller;

import com.maohacker.service.loginService;
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
import java.util.Map;

/**
 * @Author: mzy
 * @Date: 2019-3-20 14:47
 * 调用接口示例:a
 */
@RestController
@EnableAutoConfiguration
@RequestMapping("/a")
public class loginController {
    private static Logger logger=Logger.getLogger(loginController.class);  //在类的成员变量处声明
    @Autowired//自动把bean里面引用的对象的setter/getter方法省略
    @Qualifier("loginService")//进行自动注入
    private loginService loginService;
    @SuppressWarnings("all")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Map<String, Object> loginInfo(HttpServletRequest request,HttpServletResponse response){
        int CODE=-1;
        String message = null;
        Map<String,Object> reMap = new HashMap<String, Object>();
        try{
            Map param = this.buildParameter(request);
            CODE = loginService.qryloginManagerCode(param);
            if(CODE == 0){//假如,没有在管理表找到信息,在到教师表找
                message = "success";
            }else if(CODE == 1){
                CODE = loginService.qryloginTeacherCode(param);
                if(CODE == 2){
                    message = "success";
                }else if(CODE == -5004){
                    message = "用户名或密码错误!";
                }
            }
            Map data = loginService.qryloginData(param);
            Map manager = loginService.qryloginManager(param);
            Map role = loginService.qryloginRole(param);
            data.put("manager", manager);
            data.put("role", role);
            reMap.put("code", CODE);
            reMap.put("message", message);
            reMap.put("data", data);
        }catch(Exception e){
            logger.error("错误信息:"+e.getMessage());
            reMap.put("total", 0);
            reMap.put("resultMsg", e.getMessage());
            reMap.put("resultFlag", "发生错误!");
        }
        return reMap;
    }

    //退出登录
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public Map<String, Object> logoutInfo(HttpServletResponse response){
        String message = null;
        Map<String,Object> reMap = new HashMap<String, Object>();
        try{
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
