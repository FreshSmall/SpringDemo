package com.example.annotationAspectJ;

import com.example.Waiter;

public class NaughtyWaiter implements Waiter {

    @NeedTest
    public void greetTo(String name) {
        System.out.println("已经开始完成了方法greetTo"+name);

    }

    @Override
    public void serveTo(String name) {
        System.out.println("已经开始完成了方法serveTo"+name);
    }

    @Override
    public void smile(String name, int num) {

    }

    @Override
    public int shell(String name, int num) {
        return 0;
    }
}
