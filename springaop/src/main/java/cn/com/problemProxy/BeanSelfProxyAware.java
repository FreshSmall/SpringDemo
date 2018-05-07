package cn.com.problemProxy;

public interface BeanSelfProxyAware {

    public void setSelfProxy(Object object);//织入自身代理类接口
}
