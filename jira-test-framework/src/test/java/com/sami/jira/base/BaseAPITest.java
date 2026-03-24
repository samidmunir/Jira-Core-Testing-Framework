package com.sami.jira.base;

import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;

public class BaseAPITest {
    @BeforeClass
    public void init() {
        RestAssured.baseURI = "http://localhost:8080";
    }
}