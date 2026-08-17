package org.hw_14;

import java.util.Arrays;

public class ClassScanner {
    public static void printClassInfo(Object object) {
        System.out.println("Поля (getFields())");
        System.out.println(Arrays.toString(object.getClass().getFields()));
        System.out.println("Поля (getDeclaredFields())");
        System.out.println(Arrays.toString(object.getClass().getDeclaredFields()));
        System.out.println("Методы (getMethods())");
        System.out.println(Arrays.toString(object.getClass().getMethods()));
        System.out.println("Методы (getDeclaredMethods())");
        System.out.println(Arrays.toString(object.getClass().getDeclaredMethods()));
        System.out.println("Конструкторы (getConstructors())");
        System.out.println(Arrays.toString(object.getClass().getConstructors()));
        System.out.println("Конструкторы (getDeclaredConstructors())");
        System.out.println(Arrays.toString(object.getClass().getDeclaredConstructors()));
    }
}
