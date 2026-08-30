package com.lesson.homework;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HerokuappTests {

    @Test
    public void testLoginLogout() {
        open("https://the-internet.herokuapp.com/");
        $x("//a[text()='Form Authentication']").click();
        sleep(1000);
        assertEquals("Login Page",Selenide.$x("//div[@class='example']/h2").getText());
        $x("//input[@name='username']").setValue("tomsmith");
        $x("//input[@name='password']").setValue("SuperSecretPassword!");
        $x("//i[contains(text(),'Login')]/..").click();
        sleep(1000);
        assertTrue(Selenide.$x("//div[@id='flash-messages']/div").text().contains("You logged into a secure area!"));
        $x("//i[contains(text(),'Logout')]/..").shouldBe(visible);
        $x("//i[contains(text(),'Logout')]/..").click();
        sleep(1000);
        assertEquals("Login Page",Selenide.$x("//div[@class='example']/h2").getText());
    }

    @Test
    public void testLoginNegative() {
        open("https://the-internet.herokuapp.com/");
        $x("//a[text()='Form Authentication']").click();
        sleep(1000);
        $x("//a[contains(text(),'Elemental Selenium')]").shouldBe(visible);
        $x("//input[@name='username']").setValue("admin");
        $x("//input[@name='password']").setValue("1234");
        $x("//i[contains(text(),'Login')]/..").click();
        sleep(1000);
        assertTrue(Selenide.$x("//div[@id='flash-messages']/div").text().contains("Your username is invalid!"));
    }


}
