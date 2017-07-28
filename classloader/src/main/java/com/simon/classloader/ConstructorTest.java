package com.simon.classloader;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * auther: elliott zhang
 * Emaill:18292967668@163.com
 */

public class ConstructorTest {
    public static void main(String[] args){
     //通过构造构建对象
        try {
            //方式1,通过默认构造方式构建
            Class<?> aClass = Class.forName("javax.swing.JFrame");
            Object obj = aClass.newInstance();
            System.out.println(obj);

            //方式1,通过指定构造方式构建
            Class<?> aClass2 = Class.forName("javax.swing.JFrame");
            Constructor<?> constructor = aClass2.getConstructor(String.class);
            Object obj2 = constructor.newInstance("测试窗口");
            System.out.println(obj2);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
