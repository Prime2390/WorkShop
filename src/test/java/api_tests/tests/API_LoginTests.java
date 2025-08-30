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
public class API_LoginTests {


    @Story("Login into application")
    @Test(description = "Login with valid data")
    @Description("The administrator logs in with the correct email address and password.")
    public void Login() {

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

}
