package com.example.annotationAspectJ;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class TestAspectJ {

    @Before("@annotation(com.example.annotationAspectJ.NeedTest)")//后置增强切面
//    @Before("execution(com.example.annotationAspectJ.* *(..))")//后置增强切面
    public void needTestFun(){
        System.out.println("needTestFun() executed!");
    }
}
