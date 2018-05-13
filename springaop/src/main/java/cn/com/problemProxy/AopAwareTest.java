package cn.com.problemProxy;

import cn.com.Waiter;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopAwareTest {

    @Test
    public void autoProxy(){
        String path="cn/com/problemProxy/beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(path);
        Waiter waiter= (Waiter) ctx.getBean("waiterTarget");
        waiter.serveTo("Jhon");
       // waiter.greetTo("Jhon");
    }
}
