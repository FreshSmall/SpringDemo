package cn.com.aroundEnhancer;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class GreetingInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {//截获目标类方法的执行，并在前后添加横切逻辑
        Object[] args = methodInvocation.getArguments();
        String clientName = (String) args[0];
        System.out.println("How are you !Mr."+clientName+".");//在目标方法前执行
        Object obj=methodInvocation.proceed();//通过反射机制调用目标方法
        System.out.println("Please enjoy yourself！");
        return obj;
    }
}
