package com.example.beforeapsectJ;

import com.example.NativeWaiter;
import com.example.Waiter;
import org.junit.Test;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

public class BeforeAdviceTest {

    @Test
    public void before() {
        System.out.println("测试代码");
        Waiter target = new NativeWaiter();
        PreGreetingAspectJ advice = new PreGreetingAspectJ();

        //spring提供代理工厂
        AspectJProxyFactory factory = new AspectJProxyFactory();
        //设置代理目标
        factory.setTarget(target);
        //为代理目标添加增强
        factory.addAspect(advice);
        //生成代理实例
        Waiter proxy = (Waiter) factory.getProxy();
        proxy.greetTo("John");
        proxy.serveTo("Tom");
    }

}
