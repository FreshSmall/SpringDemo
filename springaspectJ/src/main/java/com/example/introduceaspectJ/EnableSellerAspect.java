package com.example.introduceaspectJ;

import com.example.Seller;
import com.example.SmartSeller;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

@Aspect
public class EnableSellerAspect {

    @DeclareParents(value="com.example.NativeWaiter",//为NativeWaiter添加接口实现
     defaultImpl = Seller.class)//默认的接口实现类
    public static SmartSeller seller;//要实现的目标接口
}
