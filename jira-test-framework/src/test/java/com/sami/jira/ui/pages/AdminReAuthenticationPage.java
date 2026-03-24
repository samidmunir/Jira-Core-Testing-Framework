package com.sami.jira.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminReAuthenticationPage {
    private WebDriver driver;
    
    public AdminReAuthenticationPage(WebDriver driver) {
        this.driver = driver;
    }

    private By passwordInputBy = By.id("login-form-authenticatePassword");
    private By confirmAuthButtonBy = By.id("login-form-submit");

    public boolean isDisplayed() {
        return !driver.findElements(passwordInputBy).isEmpty() && driver.findElement(passwordInputBy).isDisplayed();
    }

    public void confirmPassword(String password) {
        driver.findElement(passwordInputBy).clear();
        driver.findElement(passwordInputBy).sendKeys(password);
        driver.findElement(confirmAuthButtonBy).click();
    }
}