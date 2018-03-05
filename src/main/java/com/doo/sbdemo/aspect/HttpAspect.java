package com.doo.sbdemo.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 切面
 * @author doo at 2018/03/05
 */
@Aspect
@Component
public class HttpAspect {
    /*@Before("execution(public * com.doo.sbdemo.controller.GirlController.*(..))")
    //@Before("execution(public * com.doo.sbdemo.controller.GirlController.getAll(..))")
    public void log(){
        System.out.println("before");
    }
    @After("execution(public * com.doo.sbdemo.controller.GirlController.*(..))")
    public void doAfter(){
        System.out.println("after");
    }*/
    //重构,定义切面，使用log打印信息
    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.doo.sbdemo.controller.GirlController.*(..))")
    public void log(){
    }
    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        //logger.info("before");
        //记录请求信息
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //url
        logger.info("url={}", request.getRequestURL());
        //method
        logger.info("method={}", request.getMethod());
        //ip
        logger.info("ip={}", request.getRemoteAddr());
        //类方法
        logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        //参数
        logger.info("args={}",joinPoint.getArgs());
    }
    @After("log()")
    public void doAfter(){
        logger.info("after");
    }
    //获取返回值
    @AfterReturning(returning = "object",pointcut = "log()")
    public void doAfterReturning(Object object){
        logger.info("response={}",object.toString());
    }
}
