package com.sami.jira.ui.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sami.jira.base.BaseUITest;
import com.sami.jira.config.ConfigReader;
import com.sami.jira.ui.pages.HomePage;
import com.sami.jira.ui.pages.LoginPage;

public class HomePageNavigationTest extends BaseUITest {
    @Test
    public void verifyNavigationToLoginPage() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        homePage.open(ConfigReader.getProp("base.url"));
        
        Thread.sleep(2000);

        homePage.clickLoginButton();

        Thread.sleep(2000);

        Assert.assertTrue(loginPage.isLoginPageDisplayed(), "Login page was not displayed after clicking Log In");
    }
}