package org.example;

public class Password {
    public static void main(String[] args) {
        String[] passwords = {"1gmvblkl!", "cfhgQA12356", "asdfgh"};
        for (int i = 0; i < passwords.length; i++) {
            boolean hasEnoughLength = passwords[i].length() >= 8;
            boolean isNotStartedWith1 = passwords[i].charAt(0) != '1';
            boolean isNotEndedWithZ = passwords[i].charAt(passwords[i].length()-1) != 'z';
            boolean notContain1234 = !passwords[i].contains("1234");
            boolean notContainQwerty = !passwords[i].contains("qwerty");

            boolean hasPass = hasEnoughLength && isNotStartedWith1 && isNotEndedWithZ && notContain1234 && notContainQwerty;
            System.out.printf("Пароль %s прошёл проверку: %b\n", passwords[i], hasPass);
        }
    }
}