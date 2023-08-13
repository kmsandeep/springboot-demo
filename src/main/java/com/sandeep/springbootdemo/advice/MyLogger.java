package com.sandeep.springbootdemo.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class MyLogger {
    private Logger log = null;

    @Pointcut("@annotation(com.sandeep.springbootdemo.annotation.Log)")
    public void logPointcut() {
    }

    @Before("logPointcut()")
    public void logMethodWithLogAnnotation(JoinPoint jp) {
        log = LoggerFactory.getLogger(jp.getClass());
        log.info("logPointcut");
        log.info("kind: {}", jp.getKind());
        log.info("target: {}", jp.getTarget());
        log.info("args: {}", jp.getArgs());
        log.info("args: {}", jp.getSourceLocation());
    }


    @After("execution(* *.service.getUser(..)))")
    void logGetUser(JoinPoint jp) {
        log = LoggerFactory.getLogger(jp.getClass());
        log.info("logGetUser");
        log.info("kind: {}", jp.getKind());
        log.info("target: {}", jp.getTarget());
        log.info("args: {}", jp.getArgs());
        log.info("args: {}", jp.getSourceLocation());
    }

    @AfterReturning("execution(* *.service.getAdmin(..)))")
    void logGetAdmin(JoinPoint jp) {
        log = LoggerFactory.getLogger(jp.getClass());
        log.info("logGetAdmin");

        log.info("kind: {}", jp.getKind());
        log.info("target: {}", jp.getTarget());
        log.info("args: {}", jp.getArgs());
        log.info("args: {}", jp.getSourceLocation());
    }

    @Around("execution(* *.controller.getAdmin())")
    void logAroundGetAdmin(ProceedingJoinPoint pjp) throws Throwable {
        log = LoggerFactory.getLogger(pjp.getClass());
        log.info("logAroundGetAdmin");

        log.info("kind: {}", pjp.getKind());
        pjp.proceed();
        log.info("target: {}", pjp.getTarget());
        log.info("args: {}", pjp.getArgs());
        log.info("args: {}", pjp.getSourceLocation());
    }
}
