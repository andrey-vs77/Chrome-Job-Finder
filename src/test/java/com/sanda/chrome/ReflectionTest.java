package com.sanda.chrome;

import org.junit.Test;

import java.lang.reflect.Field;
import java.util.List;

/**
 * Created by cdc89 on 07.02.2017.
 */
public class ReflectionTest {
    @Test
    public void test1() throws IllegalAccessException {
        TestReflectionClass testClass = new TestReflectionClass();
        Class<?> clazz = testClass.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            System.out.println("=====field.getName() - " + field.getName());
            System.out.println("field.getAnnotatedType().toString() - " + field.getAnnotatedType().toString());
            System.out.println("field.getClass().getName() - " + field.getClass().getName());
            System.out.println("field.getClass().getSimpleName() - " + field.getClass().getSimpleName());
            System.out.println("field.getClass().getCanonicalName() - " + field.getClass().getCanonicalName());
            System.out.println("field.getType().getSimpleName() - " + field.getType().getName());
            if (field.getType().isAssignableFrom(String.class)) {
                System.out.println("!!!!!!!!!!!!!!!!! - "+field.getName() + " have a String value");
                field.setAccessible(true);
                String value = field.get(testClass).toString();
                System.out.println("!!!!!!!!!!!!!!!!! VALUE - "+value);
                field.set(testClass,value.toLowerCase());
                value = field.get(testClass).toString();
                System.out.println("!!!!!!!!!!!!!!!!! value - "+value);
            }
        }
    }
}
