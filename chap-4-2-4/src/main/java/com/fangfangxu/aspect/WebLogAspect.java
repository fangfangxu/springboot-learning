package com.fangfangxu.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.logging.Logger;

/**
 * 定义一个切面类
 */
@Aspect
@Order(5)
@Component
@Slf4j
public class WebLogAspect {
    //1、定义切入点
    //2、定义通知：Before、After、Around、AfterReturning、AfterThrowing

    @Pointcut("execution(public * com.fangfangxu.web..*.*(..))")
    public void webLog(){}

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        log.info("---Before1---");
        // 接收到请求，记录请求内容
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = attributes.getRequest();
       // 记录下请求内容
//        log.info("URL : " + request.getRequestURL().toString());
//        log.info("HTTP_METHOD : " + request.getMethod());
//        log.info("IP : " + request.getRemoteAddr());
//        log.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
//        log.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));

    }

    @After("webLog()")
    public void doAfter(){
        log.info("---After1---");
    }

    @Around("webLog()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable{
        log.info("---Around1---");
       Object ret=   pjp.proceed();//执行业务方法
        log.info("---Around1---");
        return ret;
    }

    @AfterReturning( returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        log.info("---AfterReturning1---"+ ret);
    }

    @AfterThrowing("webLog()")
    public void doAfterThrowing(){
        log.info("---AfterThrowing1---");
    }

}



