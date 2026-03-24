package com.sami.jira.ui.stepdefs;

import java.util.concurrent.TimeoutException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.sami.jira.base.Hooks;
import com.sami.jira.config.ConfigReader;
import com.sami.jira.ui.pages.AdminReAuthenticationPage;
import com.sami.jira.ui.pages.DashboardPage;
import com.sami.jira.ui.pages.EditUserProfilePage;
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
    private EditUserProfilePage editUserProfilePage;

    private String createdUsername;

    private void initPages() {
        driver = Hooks.getDriver();

        if (driver == null) {
            throw new RuntimeException("WebDriver is null. Cucumber Hooks may not have run.");
        }

        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        reAuthenticationPage = new AdminReAuthenticationPage(driver);
        userManagementPage = new UserManagementPage(driver);
        editUserProfilePage = new EditUserProfilePage(driver);
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

    @Given("the admin is on the User Management page")
    public void adminIsOnUserManagementPage() throws TimeoutException {
        initPages();

        driver.get(ConfigReader.getProp("login.url"));

        loginPage.loginAs(
                ConfigReader.getProp("admin.username"),
                ConfigReader.getProp("admin.password")
        );

        dashboardPage.goToUserManagement();

        reAuthenticationPage.confirmPassword(
                ConfigReader.getProp("admin.password")
        );

        Assert.assertTrue(userManagementPage.isDisplayed());
        System.out.println("\n*** PASS (1) ***\n");
    }

    @When("the admin creates a new user")
    public void adminCreatesNewUser() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        int randID =  (int) System.nanoTime();
        String email = "testuser" + randID + "@email.com";
        String fullName = "Test User " + randID;
        String username = "testuser" + randID;
        createdUsername = username;
        String password = "Test123";

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        userManagementPage.createUser(email, fullName, createdUsername, password);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("the new user should appear in the user list")
    public void verifyUserCreated() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        Assert.assertTrue(userManagementPage.isUserPresent(createdUsername), "User was not found in the filtered users table");
        
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @When("the admin searches for the user by username")
    public void theAdminSearchesForTheUserByUsername() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        userManagementPage.searchForUser(createdUsername);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @When("the admin opens the Edit User page for that user")
    public void theAdminOpensTheEditUserPageForThatUser() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        userManagementPage.clickEditForUser(createdUsername);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @When("the admin deactivates the user")
    public void theAdminDeactivatesTheUser() throws TimeoutException {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Assert.assertTrue(
                editUserProfilePage.isDisplayed(),
                "Edit User Profile page was not displayed"
        );

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        editUserProfilePage.deactivateUser();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("the user should appear in the inactive users filter")
    public void theUserShouldAppearInTheInactiveUsersFilter() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        userManagementPage.filterInactiveUsers();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Assert.assertTrue(
                userManagementPage.isUserPresent(createdUsername),
                "User was not found in the inactive users filter"
        );

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Given("a new user exists")
    public void aNewUserExists() {
        int randID = (int) System.nanoTime();
        String email = "testuser" + randID + "@email.com";
        String fullName = "Test User " + randID;
        String username = "testuser" + randID;
        createdUsername = username;
        String password = "Test123";
        
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        userManagementPage.createUser(email, fullName, createdUsername, password);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Assert.assertTrue(userManagementPage.isUserPresent(username), "Newly created user was not found in the user list");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}