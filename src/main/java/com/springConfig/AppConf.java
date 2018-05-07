package com.springConfig;

import com.bean.Car;
import com.processor.MyBeanPostProcessor;
import com.processor.MyInstantiationAwareBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by yinchao on 2018/4/11.
 */
@Configuration
public class AppConf {


    @Bean
    public Car car(){
        return new Car();
    }

    @Bean
    public MyBeanPostProcessor myBeanPostProcessor(){
        return new MyBeanPostProcessor();
    }

    @Bean
    public MyInstantiationAwareBeanPostProcessor myInstantiationAwareBeanPostProcessor(){
        return new MyInstantiationAwareBeanPostProcessor();
    }
}
