package cn.com.composablePointcut;

import cn.com.Waiter;
import cn.com.flowPoint.WaiterDelegate;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ComposablePointTest {
    @Test
    public void test(){

        String path = "cn/com/composablePointcut/beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(path);

        WaiterDelegate wd=new WaiterDelegate();

        Waiter waiter = (Waiter) ctx.getBean("waiter4");
        wd.setWaiter(waiter);

        waiter.greetTo("Jhon");
        waiter.serveTo("Jhon");

        wd.service("Jhon");
    }
}
