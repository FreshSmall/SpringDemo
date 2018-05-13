package com.example.introduceaspectJ;

import com.example.SmartSeller;
import com.example.Waiter;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IntroduceAdviceTest {

    @Test
    public void before() {

        String path="com/example/introduceaspectJ/beans.xml";
        ApplicationContext ctx=new ClassPathXmlApplicationContext(path);
        Waiter waiter= (Waiter) ctx.getBean("waiter");
        waiter.greetTo("Jhon");
        waiter.serveTo("Jhon");
        ((SmartSeller)waiter).sell("Beer","Jhon");
      /*  SmartSeller seller=(SmartSeller) waiter;
        seller.sell("Beer","Jhon");*/
    }


}
