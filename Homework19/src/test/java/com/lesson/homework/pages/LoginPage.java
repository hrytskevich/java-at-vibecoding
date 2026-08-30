package com.lesson.homework.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {
    SelenideElement pageHeader = $x("//div[@class='example']/h2");
    SelenideElement usernameInput = $x("//input[@name='username']");
    SelenideElement passwordInput = $x("//input[@name='password']");
    SelenideElement loginButton = $x("//i[contains(text(),'Login')]/..");
    SelenideElement footerLink = $x("//a[contains(text(),'Elemental Selenium')]");


    public SelenideElement getPageHeader() {
        return pageHeader;
    }

    public SelenideElement getFooterLink() {
        return footerLink;
    }

    public void setUsername(String username) {
        usernameInput.setValue(username);
    }

    public void setPassword(String password) {
        passwordInput.setValue(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }


}
