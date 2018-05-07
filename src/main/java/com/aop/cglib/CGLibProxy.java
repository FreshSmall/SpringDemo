package com.aop.cglib;

import com.aop.util.PerformanceMonitor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CGLibProxy implements MethodInterceptor {

    private Enhancer enhancer = new Enhancer();

    public Object getProxy(Class clazz) {
        enhancer.setSuperclass(clazz);//设置需要创建子类的类
        enhancer.setCallback(this);
        return enhancer.create();//通过字节码技术动态创建子类实例
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {//拦截父类所有方法
        PerformanceMonitor.begin(obj.getClass().getName()+"."+method.getName());
        Object result=methodProxy.invokeSuper(obj,objects);//通过反射调用业务类的目标方法
        PerformanceMonitor.end();
        return result;
    }
}
