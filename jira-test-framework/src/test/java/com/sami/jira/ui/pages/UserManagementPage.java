package com.sami.jira.ui.pages;

import java.util.List;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.sami.jira.base.BasePage;

import groovyjarjarantlr4.v4.parse.ANTLRParser.labeledAlt_return;

public class UserManagementPage extends BasePage {
    private By userManagementSidePanel = By.id("user_browser");

    private By createUserButton = By.id("create_user");
    private By emailInput = By.id("user-create-email");
    private By fullNameInput = By.id("user-create-fullname");
    private By usernameInput = By.id("user-create-username");
    private By passwordInput = By.id("password");
    private By createUserButtonFinal = By.id("user-create-submit");

    private By filterUsersInput = By.id("user-filter-userSearchFilter");
    private By filterButton = By.id("user-filter-submit");
    private By userTableRows = By.cssSelector("table tbody tr");

    public UserManagementPage(WebDriver driver) {
        super(driver);
    }

    public boolean isDisplayed() throws TimeoutException {
        return isDisplayed(userManagementSidePanel);
    }

    public void createUser(String email, String fullName, String username, String password) {
        click(createUserButton);
        type(emailInput, email);
        type(fullNameInput, fullName);
        type(usernameInput, username);
        type(passwordInput, password);
        click(createUserButtonFinal);
    }

    public boolean isUserPresent(String username) {
        type(filterUsersInput, username);
        click(filterButton);

        waitForVisibility(userTableRows);

        List<WebElement> rows = driver.findElements(userTableRows);

        for (WebElement row : rows) {
            String rowText = row.getText().trim();
            if (rowText.contains(username)) {
                return true;
            }
        }

        return false;
    }
}