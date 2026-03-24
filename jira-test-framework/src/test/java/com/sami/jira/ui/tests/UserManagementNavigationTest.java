package com.sami.jira.ui.tests;

import java.util.concurrent.TimeoutException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sami.jira.base.BaseUITest;
import com.sami.jira.config.ConfigReader;
import com.sami.jira.ui.pages.AdminReAuthenticationPage;
import com.sami.jira.ui.pages.DashboardPage;
import com.sami.jira.ui.pages.LoginPage;
import com.sami.jira.ui.pages.UserManagementPage;

public class UserManagementNavigationTest extends BaseUITest {
    @Test
    public void adminCanNavigateToUserManagementPage() throws TimeoutException {
        LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashboardPage = new DashboardPage(driver);
        AdminReAuthenticationPage reAuthPage = new AdminReAuthenticationPage(driver);
        UserManagementPage userManagementPage = new UserManagementPage(driver);

        driver.get(ConfigReader.getProp("login.url"));

        loginPage.loginAs(ConfigReader.getProp("admin.username"), ConfigReader.getProp("admin.password"));

        Assert.assertTrue(dashboardPage.isDisplayed(), "System Dashboard was not displayed or reached after login");

        dashboardPage.goToUserManagement();

        Assert.assertTrue(reAuthPage.isDisplayed(), "Admin Re-Authentication page was not displayed or reached");

        reAuthPage.confirmPassword(ConfigReader.getProp("admin.password"));

        Assert.assertTrue(userManagementPage.isDisplayed(), "User Management page was not displayed or reached after re-authentication");
    }
}