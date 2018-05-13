package com.example.annotationAspectJ;

import com.example.Waiter;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PointcutFunTest {

    @Test
    public void pointcut(){
        String path="com/example/annotationAspectJ/beans.xml";
        ApplicationContext ctx=new ClassPathXmlApplicationContext(path);
        Waiter naiveWaiter= (Waiter) ctx.getBean("nativeWaiter");
        Waiter naughtyWaiter= (Waiter) ctx.getBean("naughtyWaiter");
        naiveWaiter.greetTo("Jhon");
        naiveWaiter.serveTo("Jhon");
        naughtyWaiter.greetTo("Tom");
        naughtyWaiter.serveTo("Tom");

    }
}
