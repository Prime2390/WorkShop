package api_tests.tests;

import api_tests.model.FakerRegisterUser;
import api_tests.utils.Endpoints;
import api_tests.utils.RequestSpec;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("API")
@Feature("Authorization and Registration")
public class API_ForgotPassword {

    @Story("User forgot password")
    @Test(description = "Password reminder with correct data")
    @Description("The user has forgotten their password and is requesting a new one.")
    public void ForgotPassword() {
        var dataUser = new FakerRegisterUser().user();

        Response res = RestAssured.given().spec(RequestSpec.json())
                .body(dataUser)
                .post(Endpoints.REGISTER)
                .then()
                .statusCode(201)
                .extract().response();

        String email = res.path("email");

        String requestMail = String.format("""
        {
            "email": "%s"
        }
        """, email);


        Response response = RestAssured.given().spec(RequestSpec.json())
                .body(requestMail)
                .post(Endpoints.ForgotPassword)
                .then()
                .log().all()
                .statusCode(200)
                .extract().response();

        Boolean message = response.path("success");

        Assert.assertTrue(message, "Password reminder was successful");
        Assert.assertEquals(response.statusCode(), 200);
    }

}
