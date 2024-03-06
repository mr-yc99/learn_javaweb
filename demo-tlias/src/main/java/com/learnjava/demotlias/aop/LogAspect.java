package com.learnjava.demotlias.aop;


import com.alibaba.fastjson.JSONObject;
import com.learnjava.demotlias.pojo.OperateLog;
import com.learnjava.demotlias.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class LogAspect {
    @Autowired
    HttpServletRequest httpServletRequest;

//OperateLogMapper 还没定义
    @Autowired
    private OperateLogMapper operateLogMapper;

    @Around("@annotation(com.learnjava.demotlias.anno.Log)")
    public Object recordLog(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {





        //获取登入id
        String jwt = httpServletRequest.getHeader("token");
        Claims claims = JwtUtils.parseJWT(jwt);
        Integer operateUser = (Integer) claims.get("id");

        //操作时间
        LocalDateTime operateTime = LocalDateTime.now();
        //操作类名
        String className = proceedingJoinPoint.getTarget().getClass().getName();
        //操作方法名
        String methodName = proceedingJoinPoint.getSignature().getName();
        //操作方法的形参
        Object[] args = proceedingJoinPoint.getArgs();
        String methodParams = Arrays.toString(args);
        //操作方法返回值

        long start = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        long end = System.currentTimeMillis();

        String returnValue = JSONObject.toJSONString(result);


        OperateLog operateLog = new OperateLog(null, operateUser, operateTime, className,
                methodName, methodParams, returnValue, end - start);
        operateLogMapper.insert(operateLog);//记入日志

        log.info("aop:{}", operateLog);


        return result;


    }
}
