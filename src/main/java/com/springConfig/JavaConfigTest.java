package com.springConfig;

import com.bean.Car;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by yinchao on 2018/4/11.
 */
public class JavaConfigTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConf.class);
        ctx.refresh();
        Car car1 = (Car) ctx.getBean("car");
        car1.introduce();
        car1.setBrand("宝马");

        //第二次从容器中获取car，直接从缓冲池中获取
        Car car2 = (Car) ctx.getBean("car");

        //查看car1和car2是否指向同一引用
        System.out.println("car1==car2:"+(car1==car2));

        System.out.println(car1.getBrand());


    }
}
