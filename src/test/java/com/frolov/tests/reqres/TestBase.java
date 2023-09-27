package com.frolov.tests.reqres;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    @BeforeAll
    static  void up() {
        RestAssured.baseURI = "https://reqres.in/";
    }
}
