package com.sami.jira.ui.pages;

import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.sami.jira.base.BasePage;

public class UserManagementPage extends BasePage {
    private By userManagementSidePanel = By.id("user_browser");

    public UserManagementPage(WebDriver driver) {
        super(driver);
    }

    public boolean isDisplayed() throws TimeoutException {
        return isDisplayed(userManagementSidePanel);
    }
}