package integrations.serverest.usuarios;

import core.api.base.BaseApi;
import core.api.request.serverest.login.UsuariosRequest;
import core.api.request.utils.ServicesUtils;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

import static core.api.request.utils.HandlerProperties.getValue;

public class UsuariosTest extends BaseApi {

    private final UsuariosRequest request = new UsuariosRequest();
    private final ServicesUtils utils = new ServicesUtils();
    public static String userId;

    @Test
    @DisplayName("CT03 - Validar retorno de lista de todos os usuários cadastrados")
    @Description("Validar login status 200 e retorno de lista com todos os usuários cadastrados")
    public void getListaUsuariosCadastrados(){
        Response response =
                request.getUserRequest("/usuarios");
        Assertions.assertEquals(HttpStatus.SC_OK, response.statusCode());
    }

    @Test
    @DisplayName("CT04 - Validar cadastro de usuario criado com sucesso")
    @Description("Validar login status 200 e retorno de lista com todos os usuários cadastrados")
    public void postCadastrarUsuarios(){
        utils.getToken();
        Response response =
                request.postUserRequest("/usuarios", getValue("NOME_CADASTRO"), getValue("EMAIL_CADASTRO"), getValue("PASSWORD_CADASTRO"), getValue("ADMINISTRADOR"));
        Assertions.assertEquals(HttpStatus.SC_CREATED, response.statusCode());
        Assertions.assertEquals("Cadastro realizado com sucesso", response.getBody().jsonPath().get("message"));
        userId = response.getBody().jsonPath().get("_id").toString();
        getLogger().info(userId);
    }

    @Test
    @DisplayName("CT05 - Validar busca de usuario com sucesso por ID")
    @Description("Validar busca de usuario cadastrado status 200 e busca usuario por ID")
    public void getBuscaUsuarioCadastradoPorID(){
        Response response =
                request.getUserRequest("/usuarios/" + getValue("ID"));
        Assertions.assertEquals(HttpStatus.SC_OK, response.statusCode());
    }

}
