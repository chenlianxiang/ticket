package com.heheda.ticket.framework.aspect;

import com.heheda.ticket.framework.anno.SysLog;
import com.heheda.ticket.framework.utils.CommUtils;
import com.heheda.ticket.framework.utils.StreamUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import sun.rmi.runtime.Log;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @program: ticket
 * @description: 切面收集日志
 * @author: clx
 * @create: 2019-09-14 23:38
 */

@Aspect
@Component
@Slf4j
public class SysLogAspect {

    @Pointcut("@annotation(com.heheda.ticket.framework.anno.SysLog)")
    public void log(){}

    private ThreadLocal<Long> threadLocal=new ThreadLocal<>();;

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){

        long start = System.currentTimeMillis();
        threadLocal.set(start);
    }

    @After("log()")
    public void after(JoinPoint joinPoint) throws IOException {

        long end = System.currentTimeMillis();
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        saveLog(attributes,threadLocal.get(),end,joinPoint);

        threadLocal.remove();
    }

    private void saveLog(ServletRequestAttributes requestAttributes,long start,long end,JoinPoint joinPoint) throws IOException {
        HttpServletRequest request = requestAttributes.getRequest();

        // 记录下请求内容

        log.info("start_time : " +CommUtils.getTimeStr(start));
        log.info("end_time : " +CommUtils.getTimeStr(end));
        log.info("ip : " + request.getRemoteAddr());
        log.info("url : " + request.getRequestURL().toString());
        log.info("method : " + request.getMethod());
        log.info("class_method : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature
                ().getName());

        log.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
        //参数
        log.info("args={}",joinPoint.getArgs());
        String body = StreamUtil.getStringBody(request.getInputStream());


        log.info("参数 : "+body);


        log.info("方法运行时长:"+(end-start)+"ms");
    }
}
