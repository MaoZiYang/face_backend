package com.maohacker.common;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: mzy
 * @Date: 2019-3-21 19:04
 */
//权限配置表
public class permissionsSet {
    public static Map rank_Map1(){//等级一范围
        Map<String,Object> Map1 = new HashMap<String, Object>();
        Map1.put("1", new String[]{});//一级菜单:后台管理
        Map1.put("2", new String[]{"create","update","delete","sort"});
        Map1.put("3", new String[]{"create","update","delete","sort"});
        Map1.put("6", new String[]{"create","update","delete","sort"});
        Map1.put("7", new String[]{"create","update","delete","sort"});
        Map1.put("8", new String[]{"create","update","delete","sort"});
        Map1.put("20", new String[]{});//一级菜单:高校考勤管理
        Map1.put("21", new String[]{"create","update","delete","sort"});
        Map1.put("22", new String[]{"create","update","delete","sort"});
        Map1.put("23", new String[]{"create","update","delete","sort"});
        Map1.put("24", new String[]{"create","update","delete","sort"});
        Map1.put("25", new String[]{"create","update","delete","sort"});
        Map1.put("26", new String[]{"create","update","delete","sort"});
        Map1.put("30", new String[]{});//一级菜单:教师功能
        Map1.put("31", new String[]{"create","update","delete","sort"});
        Map1.put("32", new String[]{"create","update","delete","sort"});
        Map1.put("33", new String[]{"create","update","delete","sort"});
        return Map1;
    }

    public static Map rank_Map10(){//等级10范围
        Map<String,Object> Map1 = new HashMap<String, Object>();
        Map1.put("30", new String[]{});//一级菜单:教师功能
        Map1.put("31", new String[]{"create","update","delete","sort"});
        Map1.put("32", new String[]{"create","update","delete","sort"});
        Map1.put("33", new String[]{"create","update","delete","sort"});
        return Map1;
    }
}
