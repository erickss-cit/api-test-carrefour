package core.api.base;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.restassured.RestAssured.*;

public class BaseApi {

    private static final Logger logger = LoggerFactory.getLogger(BaseApi.class);

    @BeforeClass
    public static void setup() {
        enableLoggingOfRequestAndResponseIfValidationFails();
        logger.info("Iniciando testes: ");
        RestAssured.baseURI = "https://serverest.dev/";
    }

    public static Response get(String path) {
        logger.info("Executando GET para o caminho: {}", path);
        Response response = given()
                .when()
                .get(path);
        logResponse(response);
        return response;
    }

    public static Response post(String path, Object body) {
        logger.info("Executando POST para o caminho: {}", path);
        Response response = given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post(path);
        logResponse(response);
        return response;
    }

    public static Response put(String path, Object body) {
        logger.info("Executando PUT para o caminho: {}", path);
        Response response = given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .put(path);
        logResponse(response);
        return response;
    }

    public static Response delete(String path) {
        logger.info("Executando DELETE para o caminho: {}", path);
        Response response = given()
                .when()
                .delete(path);
        logResponse(response);
        return response;
    }

    protected static Logger getLogger() {
        return logger;
    }

    private static void logResponse(Response response) {
        int statusCode = response.getStatusCode();
        String responseBody = response.getBody().asString();
        long responseTime = response.getTime();

        if (statusCode >= 200 && statusCode < 300) {
            logger.info("Resposta recebida: Status: {}, Tempo: {} ms, Corpo: {}", statusCode, responseTime, responseBody);
        } else {
            logger.error("Erro na resposta: Status: {}, Tempo: {} ms, Corpo: {}", statusCode, responseTime, responseBody);
        }
    }
}