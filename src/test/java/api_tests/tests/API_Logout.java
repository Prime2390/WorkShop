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
public class API_Logout {



    @Story("Log out of the application")
    @Test(description = "Successful logout")
    @Description("The administrator logs out of the application.")
    public void logout() {

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

        String token = res.path("access_token");

        Allure.step("Log out as administrator");
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

}
