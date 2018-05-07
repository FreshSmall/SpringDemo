package cn.com.autoProxyCreator;

import cn.com.Waiter;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutoProxyTest {

    @Test
    public void test() {
        String path="bean2.xml";
        ApplicationContext ctx=new ClassPathXmlApplicationContext(path);
        Waiter waiter= (Waiter) ctx.getBean("waiter");
        waiter.serveTo("Jhon");
//        waiter.greetTo("Jhon");
       // seller.greetTo("Jhon");
    }

}
