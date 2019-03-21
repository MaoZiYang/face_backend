package com.maohacker.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: mzy
 * @Date: 2019-3-21 10:18
 * 调用示例1.:模拟正常执行的情况，访问http://localhost:8080/first，看控制台结果
 *调用示例2.:模拟出现异常时的情况，访问http://localhost:8080/doError，看控制台结果
 * 说明来自:https://www.cnblogs.com/bigben0123/p/7779357.html
 */
@RestController
public class testAopController {
    @RequestMapping("/first")
    public Object first() {
        return "first Aop controller";
    }

    @RequestMapping("/doError")
    public Object error() {
        return 1 / 0;
    }

}
