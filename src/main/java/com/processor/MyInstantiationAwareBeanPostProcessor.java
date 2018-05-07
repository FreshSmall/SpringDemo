package com.processor;

import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;

import java.beans.PropertyDescriptor;

/**
 * Created by yinchao on 2018/4/9.
 */
public class MyInstantiationAwareBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter{

    //1、接口方法：在实例化Bean前调用
    public Object postProcessBeforeInstantiation(Class beanClass,String beanName){
        System.out.println("初始化bean前的处理工作");
        //仅对容器中的Car Bean进行处理
        if("car".equals(beanName)){
            System.out.println("初始化bean前的处理工作");
        }
        return null;
    }

    public boolean postProcessAfterInstantiation(Object bean,String beanName){
        System.out.println("实例化bean后调用");
        //仅对容器中的Car进行处理
        if("car".equals(beanName)){
            System.out.println("实例化bean后调用");
        }
        return true;
    }

    public PropertyValue postProcessPropertyValue(PropertyValue pvs, PropertyDescriptor[] pds,Object bean,String beanName){
        //仅对容器中的Car Bean进行处理，还可以通过pdst入参进行过滤
        if("car".equals(beanName)){
            System.out.println("当设置属性值时调用该方法！");
        }
        return pvs;
    }
}
