package cn.com.afterEnhancer;

import cn.com.NativeWaiter;
import cn.com.Waiter;
import org.junit.Test;
import org.springframework.aop.AfterAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AfterAdviceTest {

    @Test
    public void before() {
        System.out.println("测试代码");
        Waiter target = new NativeWaiter();
        AfterAdvice advice=new GreetingAfterAdvice();

        //spring提供代理工厂
        ProxyFactory pf=new ProxyFactory();
        //设置代理目标
        pf.setTarget(target);
        //为代理目标添加增强
        pf.addAdvice(advice);
        //生成代理实例
        Waiter proxy= (Waiter) pf.getProxy();
        proxy.greetTo("John");
        proxy.serveTo("Tom");

        String path="beans.xml";
        ApplicationContext ctx=new ClassPathXmlApplicationContext(path);
        Waiter waiter= (Waiter) ctx.getBean("waiterAfter");
        waiter.greetTo("Jhon");
    }

}
