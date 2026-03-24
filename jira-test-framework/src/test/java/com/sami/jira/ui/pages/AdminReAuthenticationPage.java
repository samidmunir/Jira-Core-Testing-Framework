package com.sami.jira.ui.pages;

import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.sami.jira.base.BasePage;

public class AdminReAuthenticationPage extends BasePage {
    private By passwordInput = By.id("login-form-authenticatePassword");
    private By confirmButton = By.id("login-form-submit");

    public AdminReAuthenticationPage(WebDriver driver) {
        super(driver);
    }

    public boolean isDisplayed() throws TimeoutException {
        return isDisplayed(passwordInput);
    }

    public void confirmPassword(String password) {
        type(passwordInput, password);
        click(confirmButton);
    }
}