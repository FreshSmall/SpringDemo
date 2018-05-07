package com.processor;

import com.bean.Car;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Created by yinchao on 2018/4/9.
 */
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object object, String beanName) throws BeansException {
        if("car".equals(beanName)){
            Car car = (Car) object;
            if(car.getBrand()==null){
                System.out.println("调用BeanPostProcessor.postProcessBeforeInitialization");
                car.setBrand("奔驰");
            }
        }
        return object;
    }

    @Override
    public Object postProcessAfterInitialization(Object object, String beanName) throws BeansException {
        if("car".equals(beanName)){
            Car car = (Car) object;
            if(car.getMaxSpeed()>=200){
                System.out.println("调用BeanPostProcessor.postProcessAfterInitialization");
                car.setMaxSpeed(200);
            }
        }
        return object;
    }
}
