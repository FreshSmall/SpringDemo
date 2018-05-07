package com.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

/**
 * Created by yinchao on 2018/4/9.
 */
//@Scope("prototype")

public class Car implements BeanFactoryAware,BeanNameAware,InitializingBean,DisposableBean{

    public String brand;
    public int maxSpeed;

    private BeanFactory beanFactory;
    private String beanName;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }


    public void introduce(){
        System.out.println("brand:"+brand+";maxSpeed:"+maxSpeed);
    }
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("调用BeanFactoryAware.setBeanFactory()");
        this.beanFactory=beanFactory;
    }

    @Override
    public void setBeanName(String beanName) {
        System.out.println("调用BeanNameAware.setBeanName()");
        this.beanName=beanName;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("调用InitializingBean.afterPropertiesSet()");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("调用DisposableBean.destory()");

    }

    public void myInit(){
        System.out.println("调用myInit,将maxSpeed设置为240");
        this.maxSpeed=240;
    }

    public void myDestory(){
        System.out.println("调用myDestory");
    }
}
