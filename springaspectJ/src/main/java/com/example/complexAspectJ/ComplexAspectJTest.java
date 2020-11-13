package com.example.complexAspectJ;

import com.example.Waiter;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ComplexAspectJTest {

    @Test
    public void before() {

        String path="com/example/complexAspectJ/beans.xml";
        ApplicationContext ctx=new ClassPathXmlApplicationContext(path);
        Waiter waiter= (Waiter) ctx.getBean("waiter");
        waiter.greetTo("Jhon");
       /* waiter.serveTo("Jhon");
        waiter.smile("Jhon",2);
        waiter.shell("Jhon",2);*/
    }
}
