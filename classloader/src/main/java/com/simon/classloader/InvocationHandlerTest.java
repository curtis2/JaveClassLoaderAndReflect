package com.simon.classloader;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * auther: elliott zhang
 * Emaill:18292967668@163.com
 */
public class InvocationHandlerTest {
    public static void main(String[] args){
      //先创建动态代理类，然后通过动态代理类来创建代理对象
        try {

    /*     //方式1     错误
            InvocationHandler handler=new MyInvokationHandler();
            //使用Proxy生成一个动态代理类ProxyClass
            Class proxyClass= Proxy.getProxyClass(Foo.class.getClassLoader(),Foo.class.getInterfaces());
            //获取ProxyClass类中带一个InvokationHandler参数的构造器
            Constructor constructor=proxyClass.getConstructor(new Class[]{InvocationHandler.class});
            //调用ctor的newInstance方法来创建动态实例
            Foo f= (Foo) constructor.newInstance(new Object[]{handler});
            System.out.println(f);*/

            //方式2        错误
            InvocationHandler handler1=new MyInvokationHandler();
            Foo f1= (Foo) Proxy.newProxyInstance(Foo.class.getClassLoader(),Foo.class.getInterfaces(),handler1);
            System.out.println(f1);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    static class Foo{

    }

    static class MyInvokationHandler implements java.lang.reflect.InvocationHandler{
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            return null;
        }
    }
}
