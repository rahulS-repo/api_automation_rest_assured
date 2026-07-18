package endpoints;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;

import io.restassured.response.Response;
import org.testng.annotations.Optional;
import specs.SpecificationFactory;

public class ApiClient {
    protected ApiClient(){

    }
    protected Response post(String path, Object body){
        return given(SpecificationFactory.requestSpecification())
                .body(body)
                .when()
                .post(path)
                .then()
                .spec(SpecificationFactory.responseSpecification())
                .extract()
                .response();
    }
    protected Response get(String path){
        return given(SpecificationFactory.requestSpecification())
                .when()
                .get(path)
                .then()
                .spec(SpecificationFactory.responseSpecification())
                .extract().response();
    }
}
