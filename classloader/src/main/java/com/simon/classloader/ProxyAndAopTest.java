package com.simon.classloader;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * auther: elliott zhang
 * Emaill:18292967668@163.com
 *
 * 用Jdk生成动态代理，是基于接口的。所以一定要先有一个接口对象
 * 动态代理调用的方法也只能是接口的方法.
 * 还需要进一步验证和学习
 */

public class ProxyAndAopTest {

    public interface  Dog{
        void info();
        void run();
    }


    public static class GunDog implements Dog{
        @Override
        public void info() {
            System.out.println("i am dog");
        }

        @Override
        public void run() {
            System.out.println("i can move fast");
        }

        public void runMove() {
            System.out.println("i can runMove");
        }
    }



    public static class DogUtil{
      //第一个拦截器
        public void method1(){
            System.out.println("execute mehtod1....");
        }

      //第二个拦截器
        public  void method2(){
            System.out.println("execute mehtod2....");
        }
    }

    static class MyInvokationHandler implements InvocationHandler {
        //被代理的对象
        private Object target;

        public void setTarget(Object object){
          this.target=object;
        }
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
            DogUtil du=new DogUtil();
            du.method1();
            //执行被代理对象的方法
            Object result = method.invoke(target, args);
            du.method2();
            return result;
        }
    }


    public static class MyProxyFactory{
        //为指定对象生成代理对象
        public static Object getProxy(Object obj){
            MyInvokationHandler myInvokationHandler = new MyInvokationHandler();
            //为handlers设置被代理对象
            myInvokationHandler.setTarget(obj);
            //创建并生成代理对象
            return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),myInvokationHandler);
        }

    }

    /**
     *  目标:
     *  程序要在执行 Dog info和run的时候，自动先执行DogUtil的 method1和method2
     *  不需要在info和run中硬编码调用
     */
    public static void main(String[] args){
        //构建dog对象
        Dog dog=new GunDog();
        //调用dog对象的时候不直接调用，而是通过代理对象调用
        Dog proxyDog = (Dog)MyProxyFactory.getProxy(dog);
        proxyDog.info();
        proxyDog.run();
    }

}
