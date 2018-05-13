package com.example;


public class NativeWaiter implements Waiter{

    @Override
    public void greetTo(String name) {
        System.out.println("greet to "+name+"...");
    }

    public void sell(String beer, String jhon) {
        System.out.println(beer+"向"+jhon+"卖东西！");
    }

    public void serveTo(String name) {
        System.out.println("serving to "+name+"...");
    }

    public void smile(String name,int num){
        System.out.println("smile to "+name+"he is "+num+" years old");
    }

    @Override
    public int shell(String name, int num) {
        if(num==1){
            throw new IllegalArgumentException("idea Exception");
        }
        System.out.println("shell to "+name+"he is "+num+" years old");
        return num*10;
    }
}
