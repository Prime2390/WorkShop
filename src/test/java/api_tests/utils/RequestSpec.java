package api_tests.utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import utils.PropertyReader;

public class RequestSpec {
    public static RequestSpecification json() {
        return new RequestSpecBuilder()
                .setBaseUri(PropertyReader.get("api.url"))
                .setAccept("application/json")
                .setContentType("application/json")
                .log(LogDetail.ALL)
                .build();
    }
}
