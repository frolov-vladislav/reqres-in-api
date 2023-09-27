package com.frolov.tests.reqres;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static com.frolov.tests.reqres.TestData.*;
import static io.restassured.RestAssured.given;
import static java.lang.String.format;
import static org.hamcrest.Matchers.is;

public class ReqresApiTests extends TestBase {

    @Test
    public void getSingleUser() {
        given()
                .get("/api/users/2")
                .then()
                .statusCode(200)
                .body("data.first_name", is("Janet"));
    }

    @Test
    public void negativeSingleUser() {
        given()
                .get("api/users/5473")
                .then()
                .statusCode(404)
                .body(is("{}"));
    }

    @Test
    public void create() {
        String data = format("{\"name\":\"%s\",\"job\":\"%s\"}", name, job);

        given()
                .contentType(ContentType.JSON)
                .body(data)
                .when()
                .post("/api/users")
                .then()
                .statusCode(201)
                .body("job", is(job))
                .body("name", is(name));
    }

    @Test
    public void update() {
        String data = format("{\"name\":\"%s\",\"job\":\"%s\"}", name, anotherJob);
        given()
                .contentType(ContentType.JSON)
                .body(data)
                .when()
                .put("/api/users/2")
                .then()
                .statusCode(200)
                .body("job", is(anotherJob))
                .body("name", is(name));
    }

    @Test
    public void register() {
        String data = format("{\"email\":\"%s\",\"password\":\"%s\"}", email, password);
        given()
                .contentType(ContentType.JSON)
                .body(data)
                .when()
                .post("/api/register")
                .then()
                .statusCode(200)
                .body("id", is(4))
                .body("token", is("QpwL5tke4Pnpja7X4"));
    }
}