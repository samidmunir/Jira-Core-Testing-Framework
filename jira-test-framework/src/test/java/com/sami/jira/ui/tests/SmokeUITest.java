package com.sami.jira.ui.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sami.jira.base.BaseUITest;

public class SmokeUITest extends BaseUITest {
    @Test
    public void verifyJiraHomePageLoads() {
        String currentURL = driver.getCurrentUrl();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        Assert.assertTrue(currentURL.contains("localhost:8080"), "Jira did not load correctly");
    }
}