package core.api.request.serverest.login;


import core.api.base.BaseApi;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

@Epic("Login")
@Feature("Login realizado com sucesso para gerar token authorization")
public class LoginRequest {

    @SuppressWarnings("serial")
    public Response postLoginRequest(String path, final String email, final String password){
        Map<String, Object> json = new HashMap<>() {
            {
                put("email", email);
                put("password", password);
            }
        };

        return BaseApi.post(path, json);
    }
}
