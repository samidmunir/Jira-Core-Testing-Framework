package com.sami.jira.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By loginFormBy = By.id("login-form");
    private By usernameInputBy = By.id("username-field");
    private By passwordInputBy = By.id("password-field");
    private By loginButtonBy = By.id("login-button");

    public boolean isLoginPageDisplayed() {
        return driver.findElement(loginFormBy).isDisplayed();
    }

    public void login(String username, String password) {
        driver.findElement(usernameInputBy).sendKeys(username);
        driver.findElement(passwordInputBy).sendKeys(password);
        driver.findElement(loginButtonBy).click();
    }
}