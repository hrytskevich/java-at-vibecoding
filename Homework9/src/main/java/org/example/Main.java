package org.example;

import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        Company myCompany = new Company();
        System.out.println("Название компании: " + myCompany.companyName);
        System.out.println("Логотип компании: \n" + myCompany.companyLogo);
        myCompany.printContactInfo();
    }
}