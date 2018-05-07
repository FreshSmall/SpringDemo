package com.example;

import com.bean.Beans;
import com.bean.Car;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by yinchao on 2018/4/9.
 */
public class AnnotationApplicationContextTest {

    @Test
    public void getBean() {
        ApplicationContext ctx=new AnnotationConfigApplicationContext(Beans.class);
        Car car= ctx.getBean("car",Car.class);
        System.out.println(car.getBrand());
    }
}
