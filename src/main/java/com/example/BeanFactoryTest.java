package com.example;

import com.event.MailSender;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;

/**
 * Created by yinchao on 2018/4/9.
 */
public class BeanFactoryTest {

    public static void main(String[] args) throws IOException {
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource res=resolver.getResource("classpath:META-INF/spring/bean.xml");

        System.out.println(res.getFile());
        ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
        MailSender sender= (MailSender) ctx.getBean("mailSender");
        sender.sendMail("aaaa@bb.com");

    }
}
