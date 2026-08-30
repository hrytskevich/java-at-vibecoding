package com.lesson.homework.steps;

import com.lesson.homework.pages.LoginPage;
import com.lesson.homework.pages.ResultPage;
import com.lesson.homework.pages.StartPage;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.То;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginLogoutSteps {

    private static final Logger log = LoggerFactory.getLogger(LoginLogoutSteps.class);
    StartPage startPage = new StartPage();
    LoginPage loginPage = new LoginPage();
    ResultPage resultPage = new ResultPage();

    @Дано("открываю стартовую страницу")
    public void openStartPage() {
        startPage.openPage();
    }

    @Когда("кликаю на стартовой странице на элемент \"Form Authentication\"")
    public void clickFormAuthentication() {
        startPage.clickFormAuthentication();
    }

    @Когда("^ввожу в поле (Username|Password) значение \"([^\"]*)\"$")
    public void makeInput(String inputName, String inputValue) {
        switch(inputName) {
            case ("Username"): {
                loginPage.setUsername(inputValue);
                break;
            }
            case ("Password"): {
                loginPage.setPassword(inputValue);
                break;
            }
        }
    }

    @Когда("^кликаю на кнопку (Login|Logout)$")
    public void clickButtonLogInOut(String buttonName) {
        switch(buttonName) {
            case ("Login"): {
                loginPage.clickLoginButton();
                break;
            }
            case ("Logout"): {
                resultPage.clickLogoutButton();
                break;
            }
        }
    }

    @То("заголовок страницы содержит текст {string}")
    public void headerHasText(String text) {
        assertTrue(loginPage.getPageHeader().getText().contains(text));
    }

    @То("проверяю, что сообщение с результатом содержит текст {string}")
    public void checkResultMessage(String textMessage) {
        assertTrue(resultPage.getResultMessage().contains(textMessage));
    }

    @То("проверяю, что на экране есть кнопка Logout")
    public void isLogoutButtonVisible() {
        resultPage.getLogoutButton().shouldBe(visible);
    }

    @То("проверяю, что на экране есть ссылка с текстом {string}")
    public void checkLink(String linkText) {
        loginPage.getFooterLink().shouldBe(visible);
        assertTrue(loginPage.getFooterLink().getText().contains(linkText));
    }



}
