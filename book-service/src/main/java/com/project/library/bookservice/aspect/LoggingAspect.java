package com.project.library.bookservice.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@EnableAspectJAutoProxy
@Component
public class LoggingAspect {
    private final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut("@annotation(com.project.library.bookservice.aspect.Logger)")
    public void executeLoggable() {
    }

    @Before("executeLoggable()")
    public void getLogs(JoinPoint joinPoint) {
        LOGGER.info("A call was made to : " + joinPoint.getSignature().getName());
    }

}
