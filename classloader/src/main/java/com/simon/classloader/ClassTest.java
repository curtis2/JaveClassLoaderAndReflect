package com.simon.classloader;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * auther: elliott zhang
 * Emaill:18292967668@163.com
 */

@SuppressWarnings(value ="unchecked")
public class ClassTest  implements Serializable{
    private String info;
    //无参构造方法
    private ClassTest(){
    }

    private ClassTest(String name){
        System.out.println("执行有参数构造方法");
    }

    private void info(){
        System.out.println("执行无参数方法");
    }

    private void info(String name){
        System.out.println("执行有参数方法");
    }

    public static void main(String[] args){
        //获取Class对象的3种方式
        try {
            //方式1
            Class<?> aClass1 = Class.forName("com.simon.classloader.ClassTest");
            //方式2
            Class<?> aClass2 = ClassTest.class;
            //方式3
            Class<?> aClass3 = new ClassTest().getClass();
            //比较：第一种方式和第二种方式都是直接根据类来取得该类的Clas对象，相比之下第二种方式有两种优势
            // 1.代码更安全，程序在编译阶段就可以检查需要访问的Class对象是否存在
            // 2.程序性能更好，因为这种方式无需调用方法，所以性能更好


           /***** 构造器相关*********/
            //获取指定public构造器
        /*    Constructor<?> constructor = aClass2.getConstructor(String.class);
            System.out.println("getConstructor="+constructor);*/

            //获取所有public构造器
            Constructor<?>[] constructors = aClass2.getConstructors();
            for(Constructor c:constructors){
                System.out.println("getConstructors="+c);
            }

            //获取指定构造器，与构造器的访问权限无关
            Constructor declaredConstructor = aClass2.getDeclaredConstructor(String.class);
            System.out.println("declaredConstructors="+declaredConstructor);

            //获取所有构造器，与构造器的访问权限无关
            Constructor[] declaredConstructors = aClass2.getDeclaredConstructors();
            for(Constructor c:constructors){
                System.out.println("declaredConstructors="+ c);
            }

            /***** 方法相关*********/
            //获取指定public方法
/*
            Method method = aClass2.getMethod("info", String.class);
            System.out.println("getMethod="+ method);
*/

            //获取所有public方法
            Method[] methods = aClass2.getMethods();
            for(Method m:methods){
                System.out.println("getMethods="+ m);
            }

            //获取指定方法,与方法访问权限无关
            Method declaredMethod = aClass2.getDeclaredMethod("info", String.class);
            System.out.println("getDeclaredMethod="+ declaredMethod);

            //获取所有方法,与方法访问权限无关
            Method[] declaredMethods = aClass2.getDeclaredMethods();
            for(Method m:declaredMethods){
                System.out.println("getDeclaredMethods="+ m);
            }

            /***** Field相关*********/
            //获取指定public Field
/*            Field field= aClass2.getField("info");
            System.out.println("getField="+ field);*/

            //获取所有public Field
            Field[] fields = aClass2.getFields();
            for(Field f:fields){
                System.out.println("getFields="+ f);
            }

            //获取指定Field, 与方法访问权限无关
            Field declaredField= aClass2.getDeclaredField("info");
            System.out.println("getDeclaredField="+ declaredField);

            //获取所有Field,与方法访问权限无关
            Field[] declaredFields = aClass2.getDeclaredFields();
            for(Field f:declaredFields){
                System.out.println("getDeclaredFields="+ f);
            }

            /***** 其他*********/
            //获取该类实现的所有接口
            Class<?>[] interfaces = aClass2.getInterfaces();
            for(Class c:interfaces){
                System.out.println("getInterfaces="+  c);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
