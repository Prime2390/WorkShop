package api_tests.tests;

import api_tests.model.ApiRegisterFaker.FakerRegisterUser;
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
public class API_RegisterTests {
    @Story("User create account")
    @Test(description = "Register with valid data")
    @Description("The user creates an account by filling in the fields correctly.")
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
}
