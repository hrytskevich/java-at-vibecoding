package org.example;

import java.util.Random;

public class CashEnergy {
    public static void main(String[] args) {
        int visitorAge;
        double accountBalance;
        boolean isInvited;
        boolean isBlackList;
        boolean isOver18;
        boolean isInvitedOrHighBalance;
        boolean hasAccess;

        Random random = new Random();
        visitorAge = random.nextInt(80);
        accountBalance = Math.round(random.nextDouble(1_000_000) * 100.0) / 100.0;
        isInvited = false;
        isBlackList = false;
        isOver18 = visitorAge >= 18;
        isInvitedOrHighBalance = isInvited || (accountBalance > 50_000);
        hasAccess = isOver18 && isInvitedOrHighBalance && !isBlackList;

        System.out.println("Возраст посетителя: " + visitorAge +
                ";\nБаланс счёта: " + accountBalance +
                ";\nНаличие приглашения: " + (isInvited ? "Да" : "Нет") +
                ";\nВ чёрном списке: " + (isBlackList ? "Да" : "Нет") +
                (hasAccess ? ".\nПОЛУЧЕН ДОПУСК НА БИЗНЕС-ВСТРЕЧУ" : ".\n!!! НЕТ ДОПУСКА НА БИЗНЕС-ВСТРЕЧУ"));
    }
}