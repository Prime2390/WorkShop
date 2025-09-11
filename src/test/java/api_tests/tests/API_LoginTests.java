package api_tests.tests;

import api_tests.utils.Endpoints;
import api_tests.utils.RequestSpec;
import io.qameta.allure.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("API")
@Feature("Authorization and Registration")
@Story("Checking login function")
public class API_LoginTests {


    @Test(description = "Check system behavior with valid email and password")
    public void LoginWithValidEmailAndPassword() {

       String requestBody = """
                {
                "email": "admin@practicesoftwaretesting.com",
                "password": "welcome01"
                }
                """;
        Allure.step("Log in as administrator");
        Response res = RestAssured.given().spec(RequestSpec.json())
                .body(requestBody)
                .post(Endpoints.LOGIN)
                .then()
                .statusCode(200)
                .extract().response();

        Allure.addAttachment("Response body", "application/json", res.asPrettyString(), ".json");
        String token = res.path("access_token");
        System.out.println(token);
        Assert.assertEquals(res.statusCode(), 200);
        Assert.assertNotNull(token);

    }
    @Test(description = "Check system behavior with invalid password")
    public void LoginWithInvalidPassword() {

        String requestBody = """
                {
                "email": "admin@practicesoftwaretesting.com",
                "password": "wrongPass123"
                }
                """;
        Allure.step("Log in as administrator");
        Response res = RestAssured.given().spec(RequestSpec.json())
                .body(requestBody)
                .post(Endpoints.LOGIN)
                .then()
                .statusCode(401)
                .extract().response();

        Allure.addAttachment("Response body", "application/json", res.asPrettyString(), ".json");
        System.out.println(res.asPrettyString());

        String error = res.path("error");

        Assert.assertEquals(res.statusCode(), 401);
        Assert.assertEquals(error, "Unauthorized");
    }

    @Test(description = "Check system behavior with invalid email")
    public void LoginWithInvalidEmail() {

        String requestBody = """
                {
                "email": " fakeuser@test.com",
                "password": "welcome01"
                }
                """;
        Allure.step("Log in as administrator");
        Response res = RestAssured.given().spec(RequestSpec.json())
                .body(requestBody)
                .post(Endpoints.LOGIN)
                .then()
                .statusCode(401)
                .extract().response();

        Allure.addAttachment("Response body", "application/json", res.asPrettyString(), ".json");
        System.out.println(res.asPrettyString());

        String error = res.path("error");

        Assert.assertEquals(res.statusCode(), 401);
        Assert.assertEquals(error, "Unauthorized");
    }
    @Test(description = "Check system behavior with empty email and password")
    public void LoginWithEmptyEmailAndPassword() {
        String requestBody = """
                {
                "email": "",
                "password": ""
                }
                """;
        Allure.step("Log in as administrator");
        Response res = RestAssured.given().spec(RequestSpec.json())
                .body(requestBody)
                .post(Endpoints.LOGIN)
                .then()
                .statusCode(401)
                .extract().response();

        Allure.addAttachment("Response body", "application/json", res.asPrettyString(), ".json");
        System.out.println(res.asPrettyString());

        String error = res.path("error");

        Assert.assertEquals(res.statusCode(), 401);
        Assert.assertEquals(error, "Invalid login request");
    }
    @Test(description = "Check system behavior with SQL injection attempt")
    public void LoginWithSQLInjection() {
        String requestBody = """
                {
                "email": "' OR '1'='1",
                "password": "' OR '1'='1"
                }
                """;
        Allure.step("Log in as administrator");
        Response res = RestAssured.given().spec(RequestSpec.json())
                .body(requestBody)
                .post(Endpoints.LOGIN)
                .then()
                .statusCode(401)
                .extract().response();

        Allure.addAttachment("Response body", "application/json", res.asPrettyString(), ".json");
        System.out.println(res.asPrettyString());

        String error = res.path("error");

        Assert.assertEquals(res.statusCode(), 401);
        Assert.assertEquals(error, "Unauthorized");
    }
    }


