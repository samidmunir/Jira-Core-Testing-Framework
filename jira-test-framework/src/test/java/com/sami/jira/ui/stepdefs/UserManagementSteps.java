package com.sami.jira.ui.stepdefs;

import java.util.concurrent.TimeoutException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.sami.jira.base.Hooks;
import com.sami.jira.config.ConfigReader;
import com.sami.jira.ui.pages.AdminReAuthenticationPage;
import com.sami.jira.ui.pages.DashboardPage;
import com.sami.jira.ui.pages.LoginPage;
import com.sami.jira.ui.pages.UserManagementPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserManagementSteps {
    private WebDriver driver;

    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private AdminReAuthenticationPage reAuthenticationPage;
    private UserManagementPage userManagementPage;

    private void initPages() {
        driver = Hooks.getDriver();

        if (driver == null) {
            throw new RuntimeException("WebDriver is null. Cucumber Hooks may not have run.");
        }

        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        reAuthenticationPage = new AdminReAuthenticationPage(driver);
        userManagementPage = new UserManagementPage(driver);
    }

    @Given("the admin is on the login page")
    public void theAdminIsOnTheLoginPage() {
        initPages();
        driver.get(ConfigReader.getProp("login.url"));
    }

    @When("the admin logs in with valid credentials")
    public void theAdminLogsInWithValidCredentials() {
        loginPage.loginAs(ConfigReader.getProp("admin.username"), ConfigReader.getProp("admin.password"));
    }

    @Then("the System Dashboard should be displayed")
    public void theSystemDashboardShouldBeDisplayed() throws TimeoutException {
        Assert.assertTrue(dashboardPage.isDisplayed(), "System Dashboard was not displayed after login");
    }

    @When("the admin navigates to User Management")
    public void theAdminNavigatesToUserManagement() {
        dashboardPage.goToUserManagement();
    }

    @Then("the admin re-authentication page should be displayed")
    public void theAdminReAuthenticationPageShouldBeDisplayed() throws TimeoutException {
        Assert.assertTrue(reAuthenticationPage.isDisplayed(), "Admin re-authentication page was not displayed");
    }

    @When("the admin re-authenticates with the admin password")
    public void theAdminReAuthenticatesWithTheAdminPassword() {
        reAuthenticationPage.confirmPassword(ConfigReader.getProp("admin.password"));
    }

    @Then("the User Management page should be displayed")
    public void theUserManagementPageShouldBeDisplayed() throws TimeoutException {
        Assert.assertTrue(userManagementPage.isDisplayed(), "User Management page was not displayed");
    }
}