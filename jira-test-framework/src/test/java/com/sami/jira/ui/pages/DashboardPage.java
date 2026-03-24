package com.sami.jira.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
    private WebDriver driver;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    private By dashboardHeaderBy = By.xpath("//h1[text()='System Dashboard']");
    private By adminSettingsBy = By.id("admin_menu");
    private By userManagementOptionBy = By.id("admin_users_menu");

    public boolean isDashboardPageDisplayed() {
        return driver.findElement(dashboardHeaderBy).isDisplayed();
    }

    public void goToUserManagementPage() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(adminSettingsBy).click();
        
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(userManagementOptionBy).click();
    }
}