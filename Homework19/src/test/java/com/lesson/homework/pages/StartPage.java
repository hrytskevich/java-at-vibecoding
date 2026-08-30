package com.lesson.homework.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class StartPage {
    String url = "https://the-internet.herokuapp.com/";
    SelenideElement itemFormAuthentication = $x("//a[text()='Form Authentication']");

    public void clickFormAuthentication() {
        itemFormAuthentication.click();
    }

    public void openPage() {
        open(url);
    }
}
