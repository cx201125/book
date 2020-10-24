package com.chenxin.blog.aspect;

import com.chenxin.blog.entity.RequestLog;
import com.chenxin.blog.mapper.LogMapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 *用来记录日志（用切面的方式）
 */
@Aspect
@Component
public class LogAspect {
    @Autowired
    private LogMapper logMapper;
    private RequestLog  reqeustLog;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * 定义切面
     */
    @Pointcut("execution(* com.chenxin.blog.controller.* .*(..))")
    public void log(){}

    /**
     * 在执行controller方法之前条用
     * @param joinPoint
     */
    @Before("log()")
    public void doBefore(JoinPoint joinPoint) throws InterruptedException {
        
        //获取request
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //获取包名和方法
        String classMethod = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
       reqeustLog= new RequestLog(
                request.getRequestURL().toString(),
                request.getRemoteAddr(),
                classMethod,
                joinPoint.getArgs()
        );
        logger.info("Rquest  ----- {}",reqeustLog);
    }

    /**
     * 在执行controller方法之后调用
     */
    @After("log()")
    public void doAfter() {
        //logger.info("---------- doAfter 2 ----------");
    }

    /**
     * 程序执行完毕之后在调用
     * @param result
     */
    @AfterReturning(returning = "result",pointcut = "log()")
    public void doAtfertRturning(Object result) {
        logger.info("Return ------ {}",result .toString());
        reqeustLog.setReturn(result.toString());
        //设置参数
        reqeustLog.setParam(reqeustLog.ObjToStr(reqeustLog.getArgs()));
        logMapper.insertLog(reqeustLog);
    }

}
