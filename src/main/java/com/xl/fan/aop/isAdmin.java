package com.xl.fan.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class isAdmin {
    @Around("@annotation(ZhuJie)")
    public Object doInterceptor(ProceedingJoinPoint joinPoint) throws Throwable {
        //逻辑
        return joinPoint.proceed();
    }
}
