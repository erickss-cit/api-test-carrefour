package integrations.serverest.login;

import core.api.base.BaseApi;
import core.api.request.serverest.login.LoginRequest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static core.api.request.utils.HandlerProperties.getValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


@Epic("Login")
@Feature("Login realizado com sucesso para gerar token authorization")
public class LoginTest extends BaseApi {

    private final LoginRequest request = new LoginRequest();
    public String token;

    @Test
    @DisplayName("CT01 - Validar login e geração de token pela aplicação")
    @Description("Validar login status 200 e geração de token pela aplicação")
    public void postLoginAuth(){
        Response response =
                request.postLoginRequest("/login", getValue("EMAIL"), getValue("PASSWORD"));
        assertEquals(HttpStatus.SC_OK, response.statusCode());
        token = response.getBody().jsonPath().get("authorization").toString();
        System.out.println(token);
    }

    @Test
    @DisplayName("CT02 - Validar login e senha incorretos")
    @Description("Validar login status 401 e mensagem de erro")
    public void postLoginAuthIncorreto(){
        Response response =
                request.postLoginRequest("/login", getValue("EMAIL_INCORRETO"), getValue("PASSWORD_INCORRETO"));
        assertEquals(HttpStatus.SC_UNAUTHORIZED, response.statusCode());
        String message = response.getBody().jsonPath().get("message").toString();
        assertEquals("Email e/ou senha inválidos", message);
        System.out.println(message);
    }

    public String getToken(){
        return token;
    }
}
