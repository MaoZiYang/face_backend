package com.maohacker.common;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**描述：参数处理工具类
 * @JDK version used : JDK1.8
 * @Author: mzy
 * @Date: 2019-4-16 9:58
 */
public class ParamUtil {

    /**
     * 内部方法：获取前台参数
     * @return Map<String,Object>
     */
    public static Map<String,Object> buildParameter(HttpServletRequest request){
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
