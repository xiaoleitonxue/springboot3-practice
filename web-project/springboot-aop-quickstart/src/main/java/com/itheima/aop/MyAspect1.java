package com.itheima.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
@Component
//@Aspect
public class MyAspect1 {

    @Pointcut("execution(* com.itheima.service.impl.*.*(..))")
    private void pt() {
    }

    @Before("pt()")
    public void before() {
        log.info("MyAspect1...before...");
    }

    @Around("pt()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        log.info("MyAspect1...around...before...");
        Object result = pjp.proceed();
        log.info("MyAspect1...around...after...");
        return result;
    }

    @After("pt()")
    public void after() {
        log.info("MyAspect1...after...");
    }

    @AfterReturning("pt()")
    public void afterReturning() {
        log.info("MyAspect1...afterReturning...");
    }

    @AfterThrowing("pt()")
    public void afterThrowing() {
        log.info("MyAspect1...afterThrowing...");
    }

}
