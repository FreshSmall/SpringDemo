package com.example.complexAspectJ;

import com.example.annotationAspectJ.NeedTest;
import com.example.Waiter;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class TestAspectJ {

    public void greetTo(){
        System.out.println("--greetToFun() executed!--");
    }

    @Before("target(com.example.NativeWaiter)&&execution(* serveTo(..))")
    public void notServeInNaiveWaiter(){
        System.out.println("----配置Before方法一，配置的切点方法是target----");
    }

    @Before("TestNamePointcut.inPkgGreetTo()")
    public void pkgGreetTo(){//引用TestNamePointcut.inPkgGreetTo()切点
        System.out.println("----配置Before方法二、inPkgGreetTo() executed----");
    }

    @Before("target(com.example.NativeWaiter)&&TestNamePointcut.inPkgGreetTo()")
    public void pkgGreetToNoNaiveWaiter(){//在复合运算中使用了命名切点
        System.out.println("----配置Before方法三、配置方法是target&&-TestNamePointcut-----");
    }

    /**
     * 绑定连接点参数，首先args(name,num,..)根据增强方法入参找到
     * name和num对应的类型以得到真实的切点表达式，其次，在该增强方
     * 法织入目标连接点时，增强方法可以通过num和name访问到连接点的方法入参
     * @param num
     * @param name
     */
    @Before("target(com.example.NativeWaiter)&&args(name,num,..)")
    public void bindJoinPointParams(String name,int num){//增强方法接受连接点的参数
        System.out.println("----配置Before方法四、配置方法是target&&args----");
        System.out.println("name："+name);
        System.out.println("num："+num);
    }

    /**
     * 通过2处查找出waiter对应的Waiter，因而切点表达式为this(Waiter)
     * 当增强方法织入目标连接点时，增强方法通过waiter入参绑定目标对象
     * @param waiter
     */
    @Before("this(waiter)")
    public void bindProxyObj(Waiter waiter){//2
        System.out.println("----配置Before方法五、配置方法是this----");
        System.out.println(waiter.getClass().getName());
    }

    /**
     * 通过2处查找出n对应NeedTest注解，因而真实的切点表达式为@within(NeedTest)。
     * 当增强方法织入目标连接点时，增强方法通过n入参可以引用到连接点
     * @param n
     */
    @Before("@within(n)")
    public void bindTypeAnnoObject(NeedTest n){//2
        System.out.println("----配置Before方法六、配置方法是@within----");
        System.out.println(n.getClass().getName());
    }

    @Around("execution(* greetTo(..))&&target(com.example.NativeWaiter)")//环绕增强
    public void joinPointAccess(ProceedingJoinPoint joinPoint) throws Throwable {//声明连接点入参
        System.out.println("----配置Around方法，配置方法是execution&&target----");
        System.out.println("args[0]："+joinPoint.getArgs()[0]);
        System.out.println("signature："+joinPoint.getTarget().getClass());
        joinPoint.proceed();

    }
    @AfterReturning("target(com.example.Waiter)||target(com.example.SmartSeller)")
    public void waiterOrSeller(){
        System.out.println("----配置AfterReturning方法一，配置方法是target||target----");
    }

    @AfterReturning(value = "target(com.example.Waiter))",returning = "retVal")
    public void bindReturnValue(int retVal){
        System.out.println("----配置AfterReturning方法二，配置方法是target----");
        System.out.println("returnValue："+retVal);
    }

    @AfterThrowing(value = "target(com.example.Waiter))",throwing = "iae")
    public void bindException(IllegalArgumentException iae){
        System.out.println("----配置AfterThrowing方法，配置方法是target----");
        System.out.println("exception:"+iae.getMessage());
    }
}
