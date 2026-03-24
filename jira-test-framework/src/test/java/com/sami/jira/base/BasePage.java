package com.sami.jira.base;

import java.util.List;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriver driver;
    private WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    protected WebElement waitForVisibility(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement waitForClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected void click(By locator) {
        waitForClickable(locator).click();
    }

    protected void type(By locator, String text) {
        WebElement element = waitForVisibility(locator);
        element.clear();
        element.sendKeys(text);
    }

    protected boolean isDisplayed(By locator) throws TimeoutException {
        return waitForVisibility(locator).isDisplayed();
    }

    protected String getText(By locator) {
        return waitForVisibility(locator).getText();
    }

    protected void clickWithFallback(By locator) {
        WebElement element = waitForVisibility(locator);

        try {
            wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
        } catch (Exception e1) {
            try {
                new Actions(driver).moveToElement(element).click().perform();
            } catch (Exception e2) {
                ((JavascriptExecutor) driver).executeAsyncScript("arguments[0].click();", element);
            }
        }
    }

    protected List<WebElement> getElements(By locator) {
        return driver.findElements(locator);
    }

    protected boolean isElementPresent(By locator) {
        return !driver.findElements(locator).isEmpty();
    }
}