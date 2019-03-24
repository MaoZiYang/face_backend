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
        Map1.put("1", new String[]{});//一级菜单
        Map1.put("2", new String[]{"create","update","delete","sort"});
        Map1.put("3", new String[]{"create","update","delete","sort"});
        Map1.put("6", new String[]{"create","update","delete","sort"});
        Map1.put("7", new String[]{"create","update","delete","sort"});
        Map1.put("64", new String[]{});//一级菜单
        Map1.put("65", new String[]{"create","update","delete","sort"});
        Map1.put("66", new String[]{"create","update","delete","sort"});
        Map1.put("67", new String[]{});//一级菜单
        Map1.put("68", new String[]{"create","update","delete","sort"});
        return Map1;
    }
}
