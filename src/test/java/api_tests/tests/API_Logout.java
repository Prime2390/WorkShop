package api_tests.tests;

import api_tests.utils.Endpoints;
import api_tests.utils.RequestSpec;
import io.qameta.allure.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertyReader;

@Epic("API")
@Feature("Authorization and Registration")
@Story("Checking logout function ")
public class API_Logout {


    @Test(description = "Check system behavior with valid token")
    public void logoutWithValidToken() {

        String requestBody = """
                {
                "email": "admin@practicesoftwaretesting.com",
                "password": "welcome01"
                }
                """;

        Response res = RestAssured.given().spec(RequestSpec.json())
                .body(requestBody)
                .post(Endpoints.LOGIN)
                .then()
                .statusCode(200)
                .extract().response();

        String token = res.path("access_token");


       Response resBody = RestAssured.given().spec(RequestSpec.json())
               .header("Authorization", "Bearer " + token)
               .get(Endpoints.LOGOUT)
               .then()
               .log().all()
               .statusCode(200)
               .extract().response();



       Allure.addAttachment("Response body", "application/json", resBody.asPrettyString(), ".json");

       String message = resBody.path("message");
       Assert.assertEquals(message, "Successfully logged out");
       Assert.assertEquals(resBody.statusCode(), 200);


    }

    @Test(description = "Check system behavior without token")
    public void logoutWithoutToken() {
        String token = "";

        Response resBody = RestAssured.given().spec(RequestSpec.json())
                .header("Authorization", "Bearer " + token)
                .get(Endpoints.LOGOUT)
                .then()
                .log().all()
                .statusCode(401)
                .extract().response();

        String message = resBody.path("message");

        Assert.assertEquals(resBody.statusCode(), 401);
        Assert.assertEquals(message, "Unauthorized");
    }

    @Test(description = "Check system behavior after logout (token reuse)")
    public void logoutAfterTokenReuse() {

        String requestBody = """
                {
                "email": "admin@practicesoftwaretesting.com",
                "password": "welcome01"
                }
                """;


        Response res = RestAssured.given().spec(RequestSpec.json())
                .body(requestBody)
                .post(Endpoints.LOGIN)
                .then()
                .extract().response();

        String token = res.path("access_token");


                RestAssured.given().spec(RequestSpec.json())
                .header("Authorization", "Bearer " + token)
                .get(Endpoints.LOGOUT)
                .then()
                .extract().response();


        Response responsBody = RestAssured.given().spec(RequestSpec.json())
                .header("Authorization", "Bearer " + token)
                .get(Endpoints.LOGOUT)
                .then()
                .log().all()
                .statusCode(401)
                .extract().response();

        String message = responsBody.path("message");

        Assert.assertEquals(message, "Unauthorized");
        Assert.assertEquals(responsBody.statusCode(), 401);






    }

}
