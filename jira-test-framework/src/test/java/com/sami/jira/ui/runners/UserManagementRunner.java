package com.sami.jira.ui.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features",
    glue = {
        "com.sami.jira.base",
        "com.sami.jira.ui.stepdefs"
    },
    tags = "@user-management",
    plugin = {
        "pretty",
        "html:target/cucumber-reports/user-management.html"
    }
)

public class UserManagementRunner extends AbstractTestNGCucumberTests {
}