package cn.com.composablePointcut;

import cn.com.flowPoint.WaiterDelegate;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.ComposablePointcut;
import org.springframework.aop.support.ControlFlowPointcut;
import org.springframework.aop.support.NameMatchMethodPointcut;

public class GreetingComposablePointcut {

    public Pointcut getInTersectionPointcut(){
        ComposablePointcut cp=new ComposablePointcut();//创建一个复合切点
        Pointcut pt1=new ControlFlowPointcut(WaiterDelegate.class,"service");//创建一个流程切点
        NameMatchMethodPointcut pt2=new NameMatchMethodPointcut();//创建方法名切点
        pt2.addMethodName("greetTo");
        return cp.intersection(pt1).intersection((Pointcut) pt2);
    }
}
