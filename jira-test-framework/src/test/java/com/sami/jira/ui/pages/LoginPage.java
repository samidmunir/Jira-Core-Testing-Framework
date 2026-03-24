package com.sami.jira.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By loginFormBy = By.id("login-form");

    public boolean isLoginPageDisplayed() {
        return driver.findElement(loginFormBy).isDisplayed();
    }
}