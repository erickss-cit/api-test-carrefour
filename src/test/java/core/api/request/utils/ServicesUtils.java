package core.api.request.utils;

import core.api.base.BaseApi;
import core.api.request.serverest.login.UsuariosRequest;
import integrations.serverest.login.LoginTest;
import integrations.serverest.usuarios.UsuariosTest;
import io.restassured.response.Response;
import org.json.JSONException;
import org.json.JSONObject;

import static integrations.serverest.login.LoginTest.token;

public class ServicesUtils extends BaseApi {

    private final LoginTest login = new LoginTest();
//    private final UsuariosTest usuarios = new UsuariosTest();

    public String getToken() {
        login.postLoginAuth();
        return token;
    }

    public static String convertJsonToString(JSONObject jsonResponse) {
        return jsonResponse.toString();
    }

    public static void retornaResponseEmString(Response response) {
        String jsonBody = response.body().asString();

        if (jsonBody != null && !jsonBody.isEmpty()) {
            try {
                JSONObject jsonResponse = new JSONObject(jsonBody);
                String jsonString = convertJsonToString(jsonResponse);
                System.out.println(jsonString);
            } catch (JSONException e) {
                System.err.println("Falha em converter para JSON: " + e.getMessage());
            }

        } else {
            System.err.println("Response body não é nullo ou vazio");
        }
    }


}
