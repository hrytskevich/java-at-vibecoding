package org.example;

import java.io.IOException;
import java.util.Random;

import com.github.lalyos.jfiglet.FigletFont;
import net.datafaker.Faker;

public class Company {
    public String companyName;
    public String companyLogo;
    private String firstPartName;
    private String secondPartName;
    private final String[] surnames = {"Black", "Grant", "Shaw", "Turing", "Swift"};
    private final String splitter = " & ";
    Faker faker = new Faker();

    public Company() throws IOException {
        this.companyName = createCompanyName();
        this.companyLogo = createCompanyLogo();
    }

    private String getRandomSurname () {
        Random rand = new Random();
        int randNumber = rand.nextInt(surnames.length);
        return surnames[randNumber];
    }

    private String createCompanyName() {
        firstPartName = getRandomSurname();
        secondPartName = faker.name().lastName();
        return firstPartName + splitter + secondPartName;
    }

    private String createCompanyLogo() throws IOException {
        return FigletFont.convertOneLine(firstPartName) + FigletFont.convertOneLine(splitter) + FigletFont.convertOneLine(secondPartName);
    }

    public void printContactInfo() {
        System.out.println(faker.name().fullName());
        System.out.println(faker.phoneNumber().phoneNumberNational());
        System.out.println(faker.address().fullAddress());
    }
}
