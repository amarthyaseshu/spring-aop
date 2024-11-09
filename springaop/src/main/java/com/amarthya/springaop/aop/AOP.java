package com.amarthya.springaop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AOP {

    @Before(value = "execution(* com.amarthya.springaop.controller.SpringAOPController.*(..))")
    public void beforeAdvice(JoinPoint joinPoint){
      System.out.println("BEFORE "+joinPoint.getSignature());
    }

    @After(value = "execution(* com.amarthya.springaop.controller.*.*(..))")
    public void afterAdvice(JoinPoint joinPoint){
        System.out.println("AFTER "+joinPoint.getSignature());
    }

    @AfterReturning(value = "execution(* com.amarthya.springaop.controller.SpringAOPController.getData1(..))",returning = "ret")
    public void afterReturningAdvice(JoinPoint joinPoint,String ret){
        System.out.println("AFTER RETURNING"+joinPoint.getSignature());
    }

    @AfterThrowing(value = "execution(* com.amarthya.springaop.controller.SpringAOPController.getData2(..))",throwing = "e")
    public void afterThrowingAdvice(JoinPoint joinPoint,Exception e){
        System.out.println("AFTER THROWING"+joinPoint.getSignature());
    }

    @Around(value = "execution(* com.amarthya.springaop.controller.SpringAOPController.getData1(..))")
    public String afterThrowingAdvice(ProceedingJoinPoint proceedingJoinPoint) {
        String res = null;
        try {
            res = (String) proceedingJoinPoint.proceed();
            System.out.println("AROUND " + proceedingJoinPoint.getSignature());
            return res;
        } catch (Throwable e) {
            return res;
        }

    }
}
