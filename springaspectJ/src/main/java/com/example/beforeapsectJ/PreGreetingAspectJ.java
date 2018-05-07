package com.example.beforeapsectJ;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;


@Aspect//通过该注解将PreGreetingAspectJ标识为一个切面
public class PreGreetingAspectJ {

    @Before("execution( * *To(..))")//定义切点和增强类型
    public void before() throws Throwable {//增强的横切逻辑
        System.out.println("How are you! Mr");

    }
}
