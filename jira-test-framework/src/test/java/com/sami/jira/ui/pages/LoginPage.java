package com.sami.jira.ui.pages;

import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.sami.jira.base.BasePage;

public class LoginPage extends BasePage {
    private By loginForm = By.id("login-form");
    private By usernameInput = By.id("username-field");
    private By passwordInput = By.id("password-field");
    private By loginButton = By.id("login-button");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean isDisplayed() throws TimeoutException {
        return isDisplayed(loginForm);
    }

    public void loginAs(String username, String password) {
        type(usernameInput, username);
        type(passwordInput, password);
        click(loginButton);
    }
}