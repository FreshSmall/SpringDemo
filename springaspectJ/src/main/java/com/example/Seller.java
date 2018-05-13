package com.example;

public class Seller implements SmartSeller{


    public void greetTo(String name) {
        System.out.println("greet to "+name+"...");
    }

    @Override
    public void sell(String beer, String jhon) {
        System.out.println(beer+"向"+jhon+"卖东西！");
    }
}
