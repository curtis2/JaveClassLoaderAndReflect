package com.simon.classloader;

import java.lang.reflect.Field;

/**
 * auther: elliott zhang
 * Emaill:18292967668@163.com
 */

public class FieldTest {
    public static void main(String[] args){
        Person p=new Person();
        Class<Person> personClass = Person.class;
        try {
           //访问私有基本类型属性，并设值
            Field name = personClass.getDeclaredField("name");
            name.setAccessible(true);
            name.set(p,"aa");
            System.out.println(p);

            //访问私有引用类型属性，并使用
            Field yellField = personClass.getDeclaredField("yell");
            yellField.setAccessible(true);
            //通过Field的get方法获取p对象的引用类型yell
            Object obj = yellField.get(p);
            //进行强制转换
            if(obj instanceof  Yell){
                Yell yell= (Yell) obj;
                yell.yell();
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }


    static class Person{
       private String name;
       private int age ;
       private Yell yell=new Yell();
        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    static class Yell{
        public void yell(){
            System.out.println("yell.............");
        }
    }


}
