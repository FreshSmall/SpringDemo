package com.aop.util;

import com.aop.ForumService;
import com.aop.impl.ForumServiceImpl;

public class TestForumService {
    public static void main(String[] args) {
        ForumService forumService=new ForumServiceImpl();
        forumService.removeForum(10);
        forumService.removeTopic(20);
    }
}
