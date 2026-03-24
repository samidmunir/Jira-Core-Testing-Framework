package com.sami.jira.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private By loginButtonBy = By.xpath("//a[contains(text(), 'Log In')]");

    public void open(String baseURL) {
        driver.get(baseURL);
    }

    public void clickLoginButton() {
        driver.findElement(loginButtonBy).click();
    }
}