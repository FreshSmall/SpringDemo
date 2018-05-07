package com.aop.proxy;

import com.aop.ForumService;
import com.aop.impl.ForumServiceImpl;

import java.lang.reflect.Proxy;

public class TestForumService {
    public static void main(String[] args) {
        ForumService target = new ForumServiceImpl();

        PerformanceHandler handler = new PerformanceHandler(target);

        ForumService proxy= (ForumService) Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),handler);

        proxy.removeForum(10);
        proxy.removeTopic(1020);
    }
}
