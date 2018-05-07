package com.aop.util;

public class MethodPerformance {

    private long begin;
    private long end;
    private String serviceMethod;

    public MethodPerformance(String serviceMethod) {
        this.serviceMethod = serviceMethod;
        this.begin = System.currentTimeMillis();//记录目标类方法开始执行点的开始时间

    }

    public void printPerformance() {
        end = System.currentTimeMillis();//获取目标类方法执行完成后的系统时间，进而计算出目标类方法的执行时间
        long elapse = end - begin;
        System.out.println(serviceMethod+"花费"+elapse+"毫秒");
    }

}
