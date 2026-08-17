package org.hw_14;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyTests {
    public void main() throws InvocationTargetException, IllegalAccessException {
        MyTests myTests = new MyTests();
        Method[] methods = MyTests.class.getMethods();
        for (Method method : methods) {
            Annotation[] annotations = method.getDeclaredAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation instanceof MyTest) {
                    method.invoke(myTests);
                }
            }
        }
    }

    @MyTest
    public void test1() {
        String result = XMLUtils.createEmptyElement("user");
        String expectedResult = "<user></user>";
        if (result.equals(expectedResult))
            System.out.println("Тест прошёл");
        else System.out.printf("Тест не прошёл!!! Ожидалось: %s. Получено фактически: %s%n", expectedResult, result);
    }

    @MyTest
    public void test2() {
        String result = XMLUtils.createEmptyElement("");
        String expectedResult = "<invalid/>";
        if (result.equals(expectedResult))
            System.out.println("Тест прошёл");
        else System.out.printf("Тест не прошёл!!! Ожидалось: %s. Получено фактически: %s", expectedResult, result);
    }

    @MyTest
    public void test3() {
        String result = XMLUtils.createEmptyElement(null);
        String expectedResult = "<invalid/>";
        if (result.equals(expectedResult))
            System.out.println("Тест прошёл");
        else System.out.printf("Тест не прошёл!!! Ожидалось: %s. Получено фактически: %s", expectedResult, result);
    }
}
