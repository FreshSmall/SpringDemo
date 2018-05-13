package com.example.schemaAspectJ;

public class AdviceMethods {

    public void preGreeting(){//该方法通过配置被用作增强的方法
        System.out.println("--how are you!--");
    }
}
