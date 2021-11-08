package com.codegym.ungdung_muonsach.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Aspect
public class AllLogAspect {
    int count = 0;

    @Pointcut("within(com.codegym.ungdung_muonsach.controller..*)")
    public void allMethodPC() {
    }

    @Around("allMethodPC()")
    public Object aroundMethods(ProceedingJoinPoint proceedingJoinPoint) {
        count++;
        System.out.println("Before method time: " + LocalDateTime.now());

        Object time = null;

        try {
            time = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            System.out.println("Throwing method time: " + LocalDateTime.now());
            throwable.printStackTrace();
        }

        System.out.println("After method time: " + LocalDateTime.now() + " , Return time: " + time +
                " , Number of visits: " + count);

        return time;
    }
}
