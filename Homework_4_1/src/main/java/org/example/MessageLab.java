package org.example;

import java.util.Scanner;

public class MessageLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        String message = "";
        System.out.println("Введите сообщение по частям:");
        for(int i=0; i<5; i++) {
            String partMessage = scanner.nextLine();
            if (partMessage.equalsIgnoreCase("null")) {
                System.out.println("Часть сообщения повреждена! Используем резервный фрагмент...");
                partMessage = "XX";
            }
            if (i!=0) {
                message = sb.append("#").toString();
            }
            message = sb.append(partMessage).toString();
        }
        System.out.printf("Расшифрованное послание: %s", message);
    }
}