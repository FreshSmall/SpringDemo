package cn.com.flowPoint;

import cn.com.Waiter;

public class WaiterDelegate {

    private Waiter waiter;

    public void service(String clientName){//waiter的方法通过该方法发起调用
        waiter.serveTo(clientName);
        waiter.greetTo(clientName);
    }

    public void setWaiter(Waiter waiter) {
        this.waiter = waiter;
    }
}
