package com.example.introduceaspectJ;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class TestAspect {
    //后期增强，织入任何运行期对象为Seller类型的Bean中
    @AfterReturning("this(com.example.SmartSeller)")
    public void thisTest(){
        System.out.println("thisTest() executed()");
    }
}
