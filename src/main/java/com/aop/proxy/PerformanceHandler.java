package com.aop.proxy;

import com.aop.util.PerformanceMonitor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class PerformanceHandler implements InvocationHandler {

    private Object target;



    public  PerformanceHandler(Object target) {//target为目标业务类
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        PerformanceMonitor.begin(target.getClass().getName()+"."+method.getName());
        Object obj=method.invoke(target,args);//通过反射调用业务类的目标方法
        PerformanceMonitor.end();
        return obj;
    }

}
