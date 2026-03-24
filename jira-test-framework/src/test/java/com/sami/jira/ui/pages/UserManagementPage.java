package com.sami.jira.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserManagementPage {
    private WebDriver driver;

    public UserManagementPage(WebDriver driver) {
        this.driver = driver;
    }

    private By userManagementSidePanelBy = By.id("user_browser");

    public boolean isUserManagementPageDisplayed() {
        return driver.findElement(userManagementSidePanelBy).isDisplayed();
    }
}