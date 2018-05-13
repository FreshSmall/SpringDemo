package com.example.complexAspectJ;


import org.aspectj.lang.annotation.Pointcut;

public class TestNamePointcut {

    @Pointcut("within(com.example.*)")
    public void inPackage(){}//通过注解方法inPackage()对该切点进行命名，方法可视域修饰符为private，表明该命名切点只能在本切面类中使用

    @Pointcut("execution(* greetTo(..))")
    protected void greetTo(){}//通过注解该方法greetTo()对该切点进行命名，方法可视域修饰符protected，表明该命名切点可以在当前包中的切面类，子切面类中使用

    @Pointcut("inPackage()  greetTo()")
    public void inPkgGreetTo(){}//引用命名切点定义的切点，本切点也是命名切点，它对应的可视域为public
}
