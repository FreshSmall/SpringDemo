package com.processor;

import com.bean.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Created by yinchao on 2018/4/9.
 */
public class BeanLifeCycle {

    public  void LifeCycleInBeanFactory() throws IOException {
        //String filePath = "I:/网络资源/Idea--space/SpringDemo/src/main/resources/beans.xml";
        //使用系统文件路径方式加载文件
        //WritableResource res = new PathResource(filePath);
        //下面两句装载配置文件并启动容器
       // Resource res= new ClassPathResource("beans.xml");
        //System.out.println(res.getInputStream());
       // BeanFactory bf = new DefaultListableBeanFactory();

        //XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader((BeanDefinitionRegistry) bf);
        //reader.loadBeanDefinitions(res);

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        //向容器中注册MyBeanPostProcessor后处理器
       // ((ConfigurableBeanFactory)bf).addBeanPostProcessor(new MyBeanPostProcessor());

        //向容器中注册MyInstantiationAwareBeanPostProcessor后处理器
       // ((ConfigurableBeanFactory)bf).addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessor());

        //第一次从容器中获取car，将触发容器实例化该Bean，这将引发Bean生命周期方法的调用

        Car car1 = (Car) context.getBean("car");
        car1.introduce();
        car1.setBrand("宝马");

        //第二次从容器中获取car，直接从缓冲池中获取
        Car car2 = (Car) context.getBean("car");

        //查看car1和car2是否指向同一引用
        System.out.println("car1==car2:"+(car1==car2));

        //关闭容器
        //((ConfigurableBeanFactory)context).destroySingletons();

    }
    public static void main(String[] args) throws IOException {
        BeanLifeCycle b=new BeanLifeCycle();
        b.LifeCycleInBeanFactory();
    }
}
