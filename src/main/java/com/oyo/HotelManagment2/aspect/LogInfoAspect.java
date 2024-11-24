package com.oyo.HotelManagment2.aspect;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingRequestWrapper;
import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;

@Aspect
@Component
@Slf4j
public class LogInfoAspect {


    @Autowired
    private HttpServletRequest request;


    @Before("@annotation(com.oyo.HotelManagment2.Annotations.Log)")
    public void logMethodInfo(JoinPoint joinPoint) {
        // Log Request Metadata
        String method = request.getMethod();
        String uri = request.getRequestURI();
        log.info("Incoming Request: [Method: {}] [URI: {}] [Controller: {}] [Function: {}]",
                method,
                uri,
                joinPoint.getTarget().getClass().getSimpleName(),
                joinPoint.getSignature().getName()
        );

        // Log Request Parameters (if any)
        if (request.getParameterMap() != null) {
            log.info("Request Parameters: {}", request.getParameterMap());
        }
    }



}
