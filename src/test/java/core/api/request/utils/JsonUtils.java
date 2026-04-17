package core.api.request.utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonUtils {

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