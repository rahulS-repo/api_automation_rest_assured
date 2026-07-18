package specs;

import configs.ConfigReader;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.RestAssured;
import io.restassured.specification.ResponseSpecification;

public class SpecificationFactory {
    public static RequestSpecification requestSpecification(){
        System.out.println("Base URL: " + ConfigReader.getProperty("BASE_URL"));
        return new RequestSpecBuilder()
                .setBaseUri(ConfigReader.getProperty("BASE_URL"))
                .setContentType(ContentType.JSON)
                .build();
    }

    public static ResponseSpecification responseSpecification(){

        return new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .build();
    }
}
