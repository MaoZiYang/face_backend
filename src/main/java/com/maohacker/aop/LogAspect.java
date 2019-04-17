package com.maohacker.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
/**
 * @Author: mzy
 * @Date: 2019-3-21 10:35
 */
@Aspect
@Component
public class LogAspect {
    @Pointcut("execution(public * com.maohacker.controller.*.*(..))")
    public void webLog(){}

    @Before("webLog()")//前置通知，在切点之前执行；
    public void deBefore(JoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 记录下请求内容
        System.out.println("URL : " + request.getRequestURL().toString());
        System.out.println("HTTP_METHOD : " + request.getMethod());
        System.out.println("IP : " + request.getRemoteAddr());
        System.out.println("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        System.out.println("ARGS : " + Arrays.toString(joinPoint.getArgs()));

    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")//返回通知，在切点之后执行，只有正常返回时才会执行；
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        System.out.println("方法-------------返回值 :" + ret);
    }

    //后置异常通知，发生异常才会执行
    @AfterThrowing("webLog()")
    public void throwss(JoinPoint jp){
        System.out.println("方法异常时执行.....");
    }

    //后置最终通知,final增强，不管是抛出异常或者正常退出都会执行
    @After("webLog()")//后置通知，在切点之后执行，不管是否发生异常都会执行；
    public void after(JoinPoint jp){
        System.out.println("方法最后执行.....");
    }

    //环绕通知,环绕增强，相当于MethodInterceptor，在切点之前以及之后执行
    @Around("webLog()")
    public Object arround(ProceedingJoinPoint pjp) {
        System.out.println("方法环绕start.....");
        try {
            Object o =  pjp.proceed();
            System.out.println("方法环绕proceed，结果是 :" + o);
            return o;
        } catch (Throwable e) {
            e.printStackTrace();
            return null;
        }
    }

}
