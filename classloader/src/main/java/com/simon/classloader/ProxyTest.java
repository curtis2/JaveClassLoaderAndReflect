package com.simon.classloader;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * auther: elliott zhang
 * Emaill:18292967668@163.com
 */

public class ProxyTest {

   interface  Person{
        void walk();
        void sayHello();
    }

    static class PersonImpl implements Person{
         @Override
         public void walk() {

         }

         @Override
         public void sayHello() {

         }
     }

    static class Person2 {
        public void walk() {
        }
        public void sayHello() {

        }
    }

    public static void main(String[] args){

        //方式1. 被代理的对象有实现的接口的时候，通过newProxyInstance这种方式去构建动态代理对象，如没有实现的接口，通过这种方式构建会报错
        //被代理对象
        Person p= new PersonImpl();
        InvocationHandler handler=new MyInvokationHandler();
        //生成代理对象
        Person proxyP= (Person) Proxy.newProxyInstance(p.getClass().getClassLoader(),p.getClass().getInterfaces(),handler);
        //调用walk的时候，会先执行handler的invoke方法
        proxyP.walk();
        proxyP.sayHello();

 /*    try {
            //方式2   报错
           Person2 p2= new Person2();
           //使用Proxy生成一个动态代理类ProxyClass
           Class proxyClass= Proxy.getProxyClass(p2.getClass().getClassLoader(),p2.getClass().getInterfaces());
           //获取ProxyClass类中带一个InvokationHandler参数的构造器
           Constructor constructor= proxyClass.getConstructor(new Class[]{InvocationHandler.class});
           Person2 proxyP2= (Person2) constructor.newInstance(new Object[]{handler});
           System.out.println(proxyP2);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }*/
    }


   static class MyInvokationHandler implements InvocationHandler{
        /**
         * 执行动态代理的所有方法时，都会被替换成执行如下的invoke方法
         *
         * @param proxy   动态代理对象
         * @param method  代表正在执行的方法
         * @param args    调用目标方法是传入的参数
         * @return
         * @throws Throwable
         */
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("---正在执行的方法"+method);
            if(args!=null){
                System.out.println("下面是执行该方法时传入的实参为：");
                for(Object o:args){
                    System.out.println(o);
                }
            }else{
                System.out.println("---调用方法没有传参");
            }
            return null;
        }
    }


}
