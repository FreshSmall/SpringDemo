package com.example;


public class NativeWaiter implements Waiter{

    @Override
    public void greetTo(String name) {
        //throw new RuntimeException("运行异常");
        System.out.println("greet to "+name+"...");
    }

    @Override
    public void serveTo(String name) {
        System.out.println("serving to "+name+"...");
        greetTo(name);
    }
}
