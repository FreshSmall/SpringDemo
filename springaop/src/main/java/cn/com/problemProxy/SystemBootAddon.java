package cn.com.problemProxy;

import org.apache.camel.Ordered;

public interface SystemBootAddon extends Ordered {

    //在系统就绪后调用的方法
    public void onReady();
}
