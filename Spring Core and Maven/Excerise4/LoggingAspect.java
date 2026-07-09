package com.library.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LoggingAspect {

    // Wraps every method execution in the service package and logs how long it took
    @Around("execution(* com.library.service.*.*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        System.out.println("[AOP] Entering method: " + joinPoint.getSignature());

        Object result = joinPoint.proceed(); // actually invoke the target method

        long endTime = System.currentTimeMillis();
        System.out.println("[AOP] " + joinPoint.getSignature() +
                " executed in " + (endTime - startTime) + " ms");

        return result;
    }
}
