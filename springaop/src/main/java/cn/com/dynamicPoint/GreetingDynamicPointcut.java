package cn.com.dynamicPoint;

import org.springframework.aop.support.DynamicMethodMatcherPointcut;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class GreetingDynamicPointcut extends DynamicMethodMatcherPointcut {

    private static List<String> specialClientList=new ArrayList<>();

    static{
        specialClientList.add("Jhon");
        specialClientList.add("Tom");
    }


    /*public ClassFilter getClassFilter(){
        return new ClassFilter() {
            @Override
            public boolean matches(Class<?> clazz) {
                System.out.println("调用getClassFilter()对"+clazz.getName()+"静态检查.");

                return Waiter.class.isAssignableFrom(clazz);
            }
        };
    }*/

    @Override
    public boolean matches(Method method, Class<?> clazz, Object... objects) {//对方法进行动态切点检查
        System.out.println("调用动态检查方法对"+clazz.getName()+"类的"+method+"动态检查.");
        String clientName= (String) objects[0];
        return specialClientList.contains(clientName);
    }

    /*@Override
    public boolean matches(Method method, Class<?> clazz) {//对方法进行静态切点检查
        System.out.println("调用静态检查方法对"+clazz.getName()+"类的"+method+"静态检查.");
        return "greetTo".equals(method.getName());
    }*/
}
