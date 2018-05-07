package cn.com.beforeEnhancer;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;


public class GreetingBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object o) throws Throwable {//在目标方法调用前使用
        String clientName= (String) args[0];
        System.out.println("How are you! Mr."+clientName);

    }
}
