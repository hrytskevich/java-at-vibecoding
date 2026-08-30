package com.lesson.homework.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ResultPage {
    SelenideElement resultMessageArea = $x("//div[@id='flash-messages']/div");
    SelenideElement logoutButton = $x("//i[contains(text(),'Logout')]/..");

    public String getResultMessage() {
        return resultMessageArea.getText();
    }

    public void clickLogoutButton() {
        logoutButton.click();
    }

    public SelenideElement getLogoutButton() {
        return logoutButton;
    }
}
