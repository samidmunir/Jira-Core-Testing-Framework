package com.sami.jira.ui.pages;

import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.sami.jira.base.BasePage;

public class DashboardPage extends BasePage {
    private By dashboardHeader = By.xpath("//h1[text()='System Dashboard']");
    private By adminSettingsDropdown = By.id("admin_menu");
    private By userManagementOption = By.id("admin_users_menu");

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public boolean isDisplayed() throws TimeoutException {
        return isDisplayed(dashboardHeader);
    }

    public void goToUserManagement() {
        clickWithFallback(adminSettingsDropdown);
        clickWithFallback(userManagementOption);
    }
}