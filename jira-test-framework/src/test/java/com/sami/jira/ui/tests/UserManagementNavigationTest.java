package com.sami.jira.ui.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sami.jira.base.BaseUITest;
import com.sami.jira.config.ConfigReader;
import com.sami.jira.ui.pages.AdminReAuthenticationPage;
import com.sami.jira.ui.pages.DashboardPage;
import com.sami.jira.ui.pages.HomePage;
import com.sami.jira.ui.pages.LoginPage;
import com.sami.jira.ui.pages.UserManagementPage;

public class UserManagementNavigationTest extends BaseUITest {
    @Test
    public void verifyNavigationToUserManagementPage() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashboardPage = new DashboardPage(driver);
        UserManagementPage userManagementPage = new UserManagementPage(driver);
        AdminReAuthenticationPage authenticationPage = new AdminReAuthenticationPage(driver);

        homePage.open(ConfigReader.getProp("base.url"));

        homePage.clickLoginButton();

        loginPage.isLoginPageDisplayed();

        Thread.sleep(2000);

        loginPage.login("admin", "Admin123");

        Thread.sleep(2000);

        dashboardPage.goToUserManagementPage();

        Thread.sleep(2000);

        Assert.assertTrue(authenticationPage.isDisplayed(), "Admin Reauthentication Page was not displayed or reached");

        Thread.sleep(2000);

        authenticationPage.confirmPassword("Admin123");

        Thread.sleep(2000);

        Assert.assertTrue(userManagementPage.isUserManagementPageDisplayed(), "User Management page was not displayed or reached");

    }
}