package integrations.serverest.usuarios;

import core.api.base.BaseApi;
import core.api.request.serverest.login.UsuariosRequest;
import core.api.request.utils.JsonUtils;
import integrations.serverest.login.LoginTest;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static core.api.request.utils.HandlerProperties.getValue;
import static org.junit.Assert.assertEquals;

public class UsuariosTest extends BaseApi {

    private final UsuariosRequest request = new UsuariosRequest();
    private final LoginTest login = new LoginTest();

    public String token;
    public String tokenExpirado;

    @Test
    @DisplayName("CT03 - Validar retorno de lista de todos os usuários cadastrados")
    @Description("Validar login status 200 e retorno de lista com todos os usuários cadastrados")
    public void getListaUsuariosCadastrados(){
        login.getToken();
        Response response =
                request.getUserRequest("/usuarios");
        assertEquals(HttpStatus.SC_OK, response.statusCode());
        JsonUtils.retornaResponseEmString(response);
    }

    @Test
    @DisplayName("CT04 - Validar cadastro de usuario criado com sucesso")
    @Description("Validar login status 200 e retorno de lista com todos os usuários cadastrados")
    public void postCadastrarUsuarios(){
        login.getToken();
        Response response =
                request.postUserRequest("/usuarios", getValue("NOME_CADASTRO"), getValue("EMAIL_CADASTRO"), getValue("PASSWORD_CADASTRO"), getValue("ADMINISTRADOR"));
        assertEquals(HttpStatus.SC_CREATED, response.statusCode());
        assertEquals("Cadastro realizado com sucesso", response.getBody().jsonPath().get("message"));
        JsonUtils.retornaResponseEmString(response);
    }

}
