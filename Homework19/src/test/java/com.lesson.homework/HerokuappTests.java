package com.lesson.homework;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;

public class HerokuappTests {

    @Test
    public void testLoginLogout() {
        Selenide.open("https://the-internet.herokuapp.com/");
        Selenide.$x("//a[text()='Form Authentication']").click();
        Selenide.sleep(1000);
        Assertions.assertEquals("Login Page",Selenide.$x("//div[@class='example']/h2").getText());
        Selenide.$x("//input[@name='username']").setValue("tomsmith");
        Selenide.$x("//input[@name='password']").setValue("SuperSecretPassword!");
        Selenide.$x("//i[contains(text(),'Login')]/..").click();
        Selenide.sleep(1000);
        Assertions.assertTrue(Selenide.$x("//div[@id='flash-messages']/div").text().contains("You logged into a secure area!"));
        Selenide.$x("//i[contains(text(),'Logout')]/..").shouldBe(visible);
        Selenide.$x("//i[contains(text(),'Logout')]/..").click();
        Selenide.sleep(1000);
        Assertions.assertEquals("Login Page",Selenide.$x("//div[@class='example']/h2").getText());
    }

    @Test
    public void testLoginNegative() {
        Selenide.open("https://the-internet.herokuapp.com/");
        Selenide.$x("//a[text()='Form Authentication']").click();
        Selenide.sleep(1000);
        Selenide.$x("//a[contains(text(),'Elemental Selenium')]").shouldBe(visible);
        Selenide.$x("//input[@name='username']").setValue("admin");
        Selenide.$x("//input[@name='password']").setValue("1234");
        Selenide.$x("//i[contains(text(),'Login')]/..").click();
        Selenide.sleep(1000);
        Assertions.assertTrue(Selenide.$x("//div[@id='flash-messages']/div").text().contains("Your username is invalid!"));
    }


}
