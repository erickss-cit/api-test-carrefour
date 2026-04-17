package core.api.request.utils;

import core.api.request.serverest.login.LoginRequest;
import integrations.serverest.login.LoginTest;
import io.restassured.response.Response;

import static integrations.serverest.login.LoginTest.token;

public class TokenRequest {

    private final LoginRequest requests = new LoginRequest();
    public String token;

    public String getToken(String path, String email, String password) {
        Response response = requests.postLoginRequest(path, email, password);
        token = response.getBody().jsonPath().get("authorization").toString();
        return token;
    }

    public String getToken(){
        return token;
    }
}
