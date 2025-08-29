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
public class User {


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
    @Story("User create account")
    @Test(description = "Register with valid data")
    @Description("The user creates an account by filling in the fields correctly.")
    public void Register() {
      String User = """
              {
                                 "first_name": "John",
                                 "last_name": "Doe",
                                 "address": {
                                   "street": "Street 1",
                                   "city": "City",
                                   "state": "State",
                                   "country": "Country",
                                   "postal_code": "1234AA"
                                 },
                                 "phone": "0987654321",
                                 "dob": "1970-01-01",
                                 "password": "Super-secret1",
                                 "email": "john@doe.example"
                               }
              """;

      Response res = RestAssured.given().spec(RequestSpec.json())
              .body(User)
              .post(Endpoints.REGISTER)
              .then()
              .log().all()
              .extract().response();

      Assert.assertEquals(res.statusCode(), 201);

    }


}
