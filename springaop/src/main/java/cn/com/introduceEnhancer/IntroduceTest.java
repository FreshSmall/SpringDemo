package cn.com.introduceEnhancer;

import cn.com.Waiter;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IntroduceTest {

    @Test
    public void introduce() {
        String path = "beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(path);
        ForumService forumService = (ForumService) ctx.getBean("forumService");

       /* //默认情况下未开启性能监控功能
        forumService.removeForum(10);
        forumService.removeTopic(1024);

        //开启性能监控功能
        Monitorable monitorable = (Monitorable) forumService;
        monitorable.setMonitorActive(true);

        //在性能监控功能开启的情况下再次调用业务方法
        forumService.removeForum(10);
        forumService.removeTopic(1024);*/


        Waiter waiter = (Waiter) ctx.getBean("waiter1");

        waiter.greetTo("Jhon");
        waiter.serveTo("Jhon");

    }
}
