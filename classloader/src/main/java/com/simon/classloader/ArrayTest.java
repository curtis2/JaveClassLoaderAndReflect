package com.simon.classloader;

import java.lang.reflect.Array;

/**
 * auther: elliott zhang
 * Emaill:18292967668@163.com
 */

public class ArrayTest {

    public static void main(String[] args){
        try{
            //创建一个元素类型为String,长度为10的数组
            Object arr= Array.newInstance(String.class,10);
            Array.set(arr,5,"疯狂java");
            Array.set(arr,6,"疯狂java_xx");

            Object o1 = Array.get(arr, 5);
            Object o2 = Array.get(arr, 5);
            System.out.println(o1);
            System.out.println(o2);
        }catch (Exception e){
           e.printStackTrace();
        }
    }
}
