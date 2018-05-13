package cn.com.beforeEnhancer;

import cn.com.Seller;
import cn.com.Waiter;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeforeAdviceTest {

    @Test
    public void before() {
        /*System.out.println("测试代码");
        Waiter target = new NativeWaiter();
        GreetingBeforeAdvice advice=new GreetingBeforeAdvice();

        //spring提供代理工厂
        ProxyFactory pf=new ProxyFactory();
        //设置代理目标
        pf.setTarget(target);
        //为代理目标添加增强
        pf.addAdvice(advice);
        //生成代理实例
        Waiter proxy= (Waiter) pf.getProxy();
        proxy.greetTo("John");
        proxy.serveTo("Tom");*/

        String path="cn/com/beforeEnhancer/beans.xml";
        ApplicationContext ctx=new ClassPathXmlApplicationContext(path);
//        Waiter waiter= (Waiter) ctx.getBean("waiter");
        Waiter waiter= (Waiter) ctx.getBean("waiterTarget");
//        Seller seller= (Seller) ctx.getBean("seller");
        Seller seller= (Seller) ctx.getBean("sellTarget");
        waiter.greetTo("Jhon");
        waiter.serveTo("Jhon");
        seller.greetTo("Jhon");
    }

}
