package cn.com.flowPoint;

import cn.com.Waiter;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FlowPointTest {
    @Test
    public void test(){

        String path = "beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(path);

        WaiterDelegate wd=new WaiterDelegate();

        Waiter waiter = (Waiter) ctx.getBean("waiter3");
        wd.setWaiter(waiter);

        waiter.greetTo("Jhon");
        waiter.serveTo("Jhon");

        wd.service("Jhon");
    }
}
