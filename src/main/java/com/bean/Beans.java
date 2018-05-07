package com.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by yinchao on 2018/4/9.
 */
@Configuration
public class Beans {

    @Bean(name="car")//定义一个bean
    public Car buildCar(){
        Car car = new Car();
        car.setBrand("红旗CA72");
        car.setMaxSpeed(100);
        return car;
    }
}
