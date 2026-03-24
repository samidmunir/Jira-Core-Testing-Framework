package com.sami.jira.ui.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sami.jira.base.BaseUITest;
import com.sami.jira.config.ConfigReader;
import com.sami.jira.ui.pages.DashboardPage;
import com.sami.jira.ui.pages.HomePage;
import com.sami.jira.ui.pages.LoginPage;

public class DashboardNavigationTest extends BaseUITest {
    @Test
    public void verifyNavigationToDashboardPage() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashboardPage = new DashboardPage(driver);

        homePage.open(ConfigReader.getProp("base.url"));

        homePage.clickLoginButton();

        loginPage.isLoginPageDisplayed();

        Thread.sleep(2000);

        loginPage.login("admin", "Admin123");

        Thread.sleep(2000);

        Assert.assertTrue(dashboardPage.isDashboardPageDisplayed(), "Dashboard page was not displayed or reached");
    }
}