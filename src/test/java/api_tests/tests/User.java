package api_tests.tests;

import api_tests.utils.Endpoints;
import api_tests.utils.RequestSpec;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertyReader;

public class User {
    @Test
    public void Login() {

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
        System.out.println(token);
        Assert.assertEquals(res.statusCode(), 200);
        Assert.assertNotNull(token);



    }
    @Test
    public void getUsers() {
        String token = PropertyReader.get("token");
        Response res = RestAssured.given().spec(RequestSpec.json())
                .header("Authorization", "Bearer " + token)
                .queryParam("page", "1")
                .get(Endpoints.USERS)
                .then()
                .log().all()
                .statusCode(200)
                .extract().response();
    }
}
