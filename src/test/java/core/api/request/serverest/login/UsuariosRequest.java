package core.api.request.serverest.login;

import core.api.base.BaseApi;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

@Epic("Usuarios")
@Feature("Gerencie os usuários, consulte dados para login e cadastre administrador")
public class UsuariosRequest {

    private static final LoginRequest request = new LoginRequest();

    public Response getUserRequest(String path) {
        return BaseApi.get(path);
    }

    public Response postUserRequest(String path, final String nome, final String email, final String password, final String administrador) {
        Map<String, Object> json = new HashMap<>() {
            {
                put("nome", nome);
                put("email", email);
                put("password", password);
                put("administrador", administrador);
            }
        };
        return BaseApi.post(path, json);
    }

    public Response getUserRequestByEmail(String path) {
        return BaseApi.get(path);
    }
}