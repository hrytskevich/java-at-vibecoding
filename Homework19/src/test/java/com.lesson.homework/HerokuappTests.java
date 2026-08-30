package com.lesson.homework;

import com.codeborne.selenide.Selenide;
import com.lesson.homework.pages.LoginPage;
import com.lesson.homework.pages.ResultPage;
import com.lesson.homework.pages.StartPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HerokuappTests {

    StartPage startPage = new StartPage();
    LoginPage loginPage = new LoginPage();
    ResultPage resultPage = new ResultPage();

    @BeforeEach
    public void openStartPage() {
        startPage.openPage();
    }

    @Test
    public void testLoginLogout() {

        startPage.clickFormAuthentication();

        assertEquals("Login Page",loginPage.getPageHeader().getText());
        loginPage.setUsername("tomsmith");
        loginPage.setPassword("SuperSecretPassword!");
        loginPage.clickLoginButton();

        assertTrue(resultPage.getResultMessage().contains("You logged into a secure area!"));

        resultPage.getLogoutButton().shouldBe(visible);
        resultPage.clickLogoutButton();

        assertEquals("Login Page",loginPage.getPageHeader().getText());
    }

    @Test
    public void testLoginNegative() {

        startPage.clickFormAuthentication();

        loginPage.getFooterLink().shouldBe(visible);
        loginPage.setUsername("admin");
        loginPage.setPassword("1234");
        loginPage.clickLoginButton();

        assertTrue(resultPage.getResultMessage().contains("Your username is invalid!"));
    }


}
