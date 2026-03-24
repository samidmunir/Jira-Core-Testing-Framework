package com.sami.jira.ui.pages;

import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.sami.jira.base.BasePage;

public class EditUserProfilePage extends BasePage {
    private By editUserProfileHeader = By.id("jira-dialog2__heading");
    private By userActiveCheckbox = By.id("user-edit-active");
    private By userActiveCheckboxLabel = By.xpath("//label[@for='user-edit-active']");
    private By userUpdateButton = By.id("user-edit-submit");

    public EditUserProfilePage(WebDriver driver) {
        super(driver);
    }

    public boolean isDisplayed() throws TimeoutException {
        return isDisplayed(editUserProfileHeader);
    }

    public boolean isActiveChecked() {
        return driver.findElement(userActiveCheckbox).isSelected();
    }

    public void deactivateUser() {
        WebElement checkbox = driver.findElement(userActiveCheckbox);

        System.out.println("\nBefore click checked: " + checkbox.isSelected() + "\n");

        if (checkbox.isSelected()) {
            try {
                clickWithFallback(userActiveCheckboxLabel);
            } catch (Exception e) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(userActiveCheckboxLabel));
            }
        }

        System.out.println("\nAfter click checked: " + driver.findElement(userActiveCheckbox).isSelected() + "\n");

        clickWithFallback(userUpdateButton);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}