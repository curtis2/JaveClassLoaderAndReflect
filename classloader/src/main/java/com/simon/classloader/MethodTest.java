package com.simon.classloader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * auther: elliott zhang
 * Emaill:18292967668@163.com
 */

public class MethodTest {

    private void info(String name){
        System.out.println("执行有参数方法"+name);
    }

    public static void main(String[] args){
        try {
            Class<?> aClass = MethodTest.class;
            Object obj = aClass.newInstance();
            Method info = aClass.getDeclaredMethod("info", String.class);
            //执行invoke的时候，obj要调用的对象，test method为参数
            info.invoke(obj,"test method");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}
