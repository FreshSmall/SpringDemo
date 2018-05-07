package cn.com.problemProxy;

import org.apache.camel.Ordered;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class BeanSelfProxyAwareMounter implements SystemBootAddon, ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void onReady() {//实现系统启动器接口中的装配就绪方法
        //从容器中获取所有注入的自动代理Bean
        Map<String,BeanSelfProxyAware> proxyAwareMap=applicationContext.getBeansOfType(BeanSelfProxyAware.class);

        if(proxyAwareMap!=null){
            for (BeanSelfProxyAware beanSelfProxyAware:proxyAwareMap.values()){
                beanSelfProxyAware.setSelfProxy(beanSelfProxyAware);
                System.out.println("注册自身被代理的实例。"+beanSelfProxyAware);
            }
        }
    }

    @Override
    public int getOrder() {

        return Ordered.HIGHEST;
    }

    //注入Spring容器
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
