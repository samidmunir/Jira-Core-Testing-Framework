package com.sami.jira.ui.tests;

import java.util.concurrent.TimeoutException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sami.jira.base.BaseUITest;
import com.sami.jira.config.ConfigReader;
import com.sami.jira.ui.pages.HomePage;
import com.sami.jira.ui.pages.LoginPage;

public class HomePageNavigationTest extends BaseUITest {
    @Test
    public void userCanNavigateFromHomePageToLoginPage() throws TimeoutException {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        homePage.open(ConfigReader.getProp("base.url"));
        homePage.clickLoginButton();

        Assert.assertTrue(loginPage.isDisplayed(), "Login Page was not displayed or reached after clicking 'Log In'");
    }
}