package cn.com.dynamicPoint;

import cn.com.Waiter;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DynamicPointTest {

    @Test
    public void introduce() {
        long starttime=System.currentTimeMillis();
        String path = "cn/com/dynamicPoint/beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(path);
        Waiter waiter = (Waiter) ctx.getBean("waiter2");


        waiter.greetTo("Jhon");
        waiter.serveTo("Jhon");
        waiter.greetTo("Peter");
        waiter.serveTo("Peter");

        System.out.println((System.currentTimeMillis()-starttime)+"ms");

    }
}
