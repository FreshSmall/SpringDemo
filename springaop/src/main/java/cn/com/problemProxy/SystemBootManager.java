package cn.com.problemProxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.OrderComparator;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class SystemBootManager implements ApplicationListener<ContextRefreshedEvent> {

    private List<SystemBootAddon> systemBootAddons = Collections.EMPTY_LIST;
    private boolean hasRunOnce = false;

    //注入所有SystemBootAddon插件
    @Autowired(required = false)
    public void setSystemBootAddons(List<SystemBootAddon> systemBootAddons){
        OrderComparator.sort(systemBootAddons);
        this.systemBootAddons=systemBootAddons;
    }

    //触发所有插件
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if(!hasRunOnce){
            for (SystemBootAddon systemBootAddon:systemBootAddons) {
                systemBootAddon.onReady();
                System.out.println("执行插件："+systemBootAddon.getClass().getCanonicalName());
            }
            hasRunOnce=true;
        }else {
            System.out.println("已经执行过容器启动插件集，本次忽略之");
        }
    }
}
