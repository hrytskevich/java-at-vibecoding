package org.example;

public class TestDictionary {
    public static void main(String[] args) {
        final int testQuantity = 100;
        int flakyTests = 0;
        int bugTests = 0;
        int criticalTests = 0;
        int passedTests = 0;
        String status = "";
        for (int i = 1; i <= testQuantity; i++) {
            if (i%3==0) {
                if(i%5==0) {
                    // делится и на 3, и на 5
                    criticalTests ++;
                    status = "Critical!";
                }
                else {
                    // делится только на 3
                    flakyTests++;
                    status = "Flaky";
                }
            }
            else if (i%5==0) {
                // делится только на 5
                bugTests++;
                status = "Bug";
            }
            else {
                // не делится ни на 3, ни на 5
                passedTests++;
                status = "Pass";
            }
            System.out.printf("Тест #%d: %s\n", i, status);
        }
        System.out.println("\n===== ИТОГИ НОЧНОЙ СМЕНЫ =====");
        System.out.printf("\nВсего тестов: %d", testQuantity);
        System.out.printf("\nPass: %d", passedTests);
        System.out.printf("\nFlaky: %d", flakyTests);
        System.out.printf("\nBug: %d", bugTests);
        System.out.printf("\nCritical: %d", criticalTests);
    }
}