package com.zaurtregulov.spring.mvc_hibernate_aop.aspect;

import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyLoggingAspect {
    @Around("execution(* com.zaurtregulov.spring.mvc_hibernate_aop.dao.*.*(..))")
    public Object aroundAllRepositoryMethodsAdvice(MethodInvocationProceedingJoinPoint methodInvocationProceedingJoinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature)methodInvocationProceedingJoinPoint.getSignature();
        String methodName = methodSignature.getName();

        System.out.println("Begin of " + methodName);
        Object targetMethodResult = methodInvocationProceedingJoinPoint.proceed();

        System.out.println("End of " + methodName);

        return targetMethodResult;
    }
}
