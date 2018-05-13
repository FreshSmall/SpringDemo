package com.example.schemaAspectJ;

import com.example.Waiter;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SchemaAspectJTest {

    @Test
    public void before() {

        String path="com/example/schemaAspectJ/beans.xml";
        ApplicationContext ctx=new ClassPathXmlApplicationContext(path);
        Waiter waiter= (Waiter) ctx.getBean("naiveWaiter");
        waiter.greetTo("Jhon");
        waiter.serveTo("Jhon");
        waiter.smile("Jhon",2);
        waiter.shell("Jhon",2);
    }
}
