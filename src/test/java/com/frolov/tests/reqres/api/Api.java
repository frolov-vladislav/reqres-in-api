package com.frolov.tests.reqres.api;

import com.frolov.tests.reqres.lombok.User;
import com.frolov.tests.reqres.lombok.UserData;

import static com.frolov.tests.reqres.specs.Specs.request;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;

public class Api {

    public UserData getUser(Integer userId) {
        return given()
                .spec(request)
                .get(String.format("users/%s", userId))
                .then()
                .extract().as(UserData.class);
    }

    public User createUser(User user) {
        return given()
                .spec(request)
                .body(String.format("{\"first_name\":\"%s\",\"job\":\"%s\"}", user.getFirstName(), user.getJob()))
                .post("users")
                .then()
                .statusCode(201)
                .extract().as(User.class);
    }

    public User update(User user, Integer userId) {
        return given()
                .spec(request)
                .body(String.format("{\"first_name\":\"%s\",\"job\":\"%s\"}", user.getFirstName(), user.getJob()))
                .put(String.format("users/%s", userId))
                .then()
                .statusCode(200)
                .extract().as(User.class);
    }

    public void checkResourceName(String resourceName) {
         given()
                .spec(request)
                .get("unknown")
                .then()
                .body("data.findAll{it.name}.name.flatten()", hasItem(resourceName));
    }
}