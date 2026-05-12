package org.example;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String code = generateAccessCode();
        System.out.println("Код доступа: " + code);
        System.out.println("Валидность кода: " + (isValidCode(code, 8) ? "Да" : "Нет"));
        logEvent("Server protection activated");
        logEvent("Intrusion attempt detected", true);
        String[] agentId = {
                generateAgentId("AGENT", 42),
                generateAgentId("AGENT", 77),
                generateAgentId("AGENT", 13)
        };
        System.out.println("ID агентов:");
        System.out.println(Arrays.toString(agentId));
    }

    public static String generateAccessCode() {
        int currentYear = LocalDate.now().getYear();
        int result = (int) Math.pow(3, 7);
        return (currentYear + "-" + result);
    }

    private static boolean isValidCode(String code, int minLength) {
        if (code != null && code.length() >= minLength && code.contains("-")) {
            return true;
        }
        return false;
    }

    public static void logEvent (String message) {
        System.out.printf("[INFO] %s%n", message);
    }

    public static void logEvent (String message, boolean isCritical) {
        if (isCritical) {
            System.out.printf("[CRITICAL] %s%n", message);
        }
        else {
            logEvent(message);
        }
    }

    public static String generateAgentId(String prefix, int seed) {
        Random rand = new Random(seed);
        int randNumber = rand.nextInt(9000) + 1000;
        return (prefix + "-" + randNumber);
    }
}