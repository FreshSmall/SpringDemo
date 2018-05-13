package cn.com;

import cn.com.problemProxy.BeanSelfProxyAware;

public class NativeWaiter implements Waiter,BeanSelfProxyAware {
    private Waiter waiter;

    @Override
    public void setSelfProxy(Object object) {
        waiter= (Waiter) object;
    }

    @Override
    public void greetTo(String name) {
        System.out.println("greet to "+name+"...");
    }

    @Override
    public void serveTo(String name) {
        System.out.println("serving to "+name+"...");
        greetTo(name);
    }
}
