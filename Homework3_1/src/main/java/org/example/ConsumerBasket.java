package org.example;

import java.util.Arrays;

public class ConsumerBasket {
    public static void main(String[] args) {
        String[] basketPeter = {"курица", "бананы", "творог"};
        String[] basketNick = {"курица", "бананы", "творог"};
        String[] basketTerenty = {"пиво", "пельмени", "ласка магия черного"};

        int lengthBasketPeter = basketPeter.length;
        int lengthBasketNick = basketNick.length;
        int lengthBasketTerenty = basketTerenty.length;

        System.out.println("Сравним количество товаров в корзине Пети (1) и Коли (2):");
        compareLength(lengthBasketPeter, lengthBasketNick);
        System.out.println("Сравним количество товаров в корзине Пети (1) и Терентия (2):");
        compareLength(lengthBasketPeter, lengthBasketTerenty);

        Arrays.sort(basketPeter);
        Arrays.sort(basketNick);
        Arrays.sort(basketTerenty);

        System.out.println("\nСравним состав товаров в корзине Пети (1) и Коли (2):");
        compareContent(basketPeter, basketNick);
        System.out.println("Сравним состав товаров в корзине Пети (1) и Терентия (2):");
        compareContent(basketPeter, basketTerenty);

        String[] allGoods = getAllGoods(basketPeter, basketNick, basketTerenty);
        System.out.println("\nСписок всех товаров: " + Arrays.toString(allGoods));

        lengthResearch(allGoods);
    }

    public static void compareLength(int a, int b) {
        if(a<b) {
            System.out.println("\tв 1-ой корзине меньше товаров, чем во 2-ой.");
        }
        else if(a==b) {
            System.out.println("\tв 1-ой корзине столько же товаров, сколько и во 2-ой.");
        }
        else {
            System.out.println("\tв 1-ой корзине больше товаров, чем во 2-ой.");
        }
    }

    public static void compareContent(String[] a, String[] b) {
        if(Arrays.equals(a, b)) {
            System.out.println("\tсостав товаров в корзинах совпадает.");
        }
        else {
            System.out.println("\tсостав товаров в корзинах отличается.");
        }
    }

    public static String[] getAllGoods(String[] a, String[] b, String[] c) {
        int tempLength = a.length + b.length + c.length;
        String[] tempArray = new String[tempLength];
        for (int i = 0; i < a.length; i++) {
            tempArray[i] = a[i];
        }
        for (int i = 0; i < b.length; i++) {
            tempArray[i + a.length] = b[i];
        }
        for (int i = 0; i < c.length; i++) {
            tempArray[i + a.length + b.length] = c[i];
        }
        Arrays.sort(tempArray);
        String s = tempArray[0];
        for (int i = 1; i < tempLength; i++) {
            if (!tempArray[i].equals(tempArray[i-1])) {
                s += "," + tempArray[i];
            }
        }
        return s.split(",");
    }

    public static void lengthResearch(String[] a) {
        String theLongest = a[0];
        String theShortest = a[0];
        int length = a[0].length();
        for (int i = 1; i < a.length; i++) {
            if (a[i].length() >theLongest.length()) {
                theLongest = a[i];
            }
            if (a[i].length() < theShortest.length()) {
                theShortest = a[i];
            }
            length += a[i].length();
        }
        double averageLength = (double) length / a.length;
        System.out.println("\nТовар с самым длинным названием: " + theLongest);
        System.out.println("Товар с самым коротким названием: " + theShortest);
        System.out.printf("\nСредняя длина названия товара: %.2f", averageLength);
    }

}