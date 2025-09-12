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

import java.util.List;

@Epic("API")
@Feature("Authorization and Registration")
@Story("Check registration function")
public class API_RegisterTests {

    @Test(description = "Check system behavior with valid registration data")
    public void Register() {
        var dataUser = new FakerRegisterUser().user();

        Response res = RestAssured.given().spec(RequestSpec.json())
                .body(dataUser)
                .post(Endpoints.REGISTER)
                .then()
                .log().all()
                .extract().response();

        String id = res.path("id");

        Assert.assertEquals(res.statusCode(), 201);
        Assert.assertNotNull(id);
    }
    @Test(description = "Check registration with existing email")
    public void userwithExistingEmail() {
        var dataUser = new FakerRegisterUser().user();

       RestAssured.given().spec(RequestSpec.json())
                .body(dataUser)
                .post(Endpoints.REGISTER)
                .then()
                .extract().response();

       Response res = RestAssured.given().spec(RequestSpec.json())
               .body(dataUser)
               .post(Endpoints.REGISTER)
               .then()
               .log().all()
               .statusCode(422)
               .extract().response();

        List<String> emailErrors = res.jsonPath().getList("email");
        String error = emailErrors.get(0);

       Assert.assertEquals(res.statusCode(), 422);
       Assert.assertEquals(error, "A customer with this email address already exists.");
    }
    @Test(description = "Check registration with invalid email format")
    public void registerWithInvalidEmailFormat() {
        var dataUser = new FakerRegisterUser().userwithUncorrectEmail();

        Response res = RestAssured.given().spec(RequestSpec.json())
                .body(dataUser)
                .post(Endpoints.REGISTER)
                .then()
                .log().all()
                .extract().response();

    }

}
