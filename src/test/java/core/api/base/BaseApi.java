package core.api.base;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import static io.restassured.RestAssured.*;

public class BaseApi {

    @BeforeAll
    public static void setup(){
        enableLoggingOfRequestAndResponseIfValidationFails();
        RestAssured.baseURI = "https://serverest.dev/";
    }

    public static Response get(String path) {
        return given()
                .when()
                .get(path);
    }

    public static Response post(String path, Object body) {
        return given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post(path);
    }

    public static Response put(String path, Object body) {
        return given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .put(path);
    }

    public static Response delete(String path) {
        return given()
                .when()
                .delete(path);
    }
}