package com.aop.cglib;

import com.aop.impl.ForumServiceImpl;

public class TestForumService {

    public static void main(String[] args) {
        CGLibProxy proxy=new CGLibProxy();
        ForumServiceImpl forumService= (ForumServiceImpl) proxy.getProxy(ForumServiceImpl.class);//通过动态生成子类的方式创建代理类
        forumService.removeTopic(10);
        forumService.removeForum(1024);

    }
}
