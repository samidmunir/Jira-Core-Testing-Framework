package com.sami.jira.base;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Hooks {

    private static WebDriver driver;

    @Before("@ui")
    public void setUpUi() {
        System.out.println(">>> Cucumber @Before hook running");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println(">>> Driver initialized: " + driver);
    }

    @After("@ui")
    public void tearDownUi() {
        System.out.println(">>> Cucumber @After hook running");
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public static WebDriver getDriver() {
        System.out.println(">>> Hooks.getDriver() called, driver = " + driver);
        return driver;
    }
}