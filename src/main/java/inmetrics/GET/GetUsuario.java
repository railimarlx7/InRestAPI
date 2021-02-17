package inmetrics.GET;

import static io.restassured.RestAssured.given;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetUsuario {

	public static String URI = "https://inm-test-api.herokuapp.com/acesso";
	public static String acessoID;
	public static String email;
	public static String message;

	@Test
	public static void listarUsuario(String acessoID) {

		RestAssured.defaultParser = Parser.JSON;

		Response response = given().auth().basic("inmetrics", "automacao").accept(ContentType.JSON)
				.contentType(ContentType.JSON).relaxedHTTPSValidation().when().get(URI + "/list/" + acessoID).then()
				.contentType(ContentType.JSON)
				.extract().response();
		JsonPath jsonPathEvaluator = response.jsonPath();
		int statusCode = response.getStatusCode();
		String code = String.valueOf(statusCode);
		if (code.equals("400")) {
			message = response.asString();
			System.out.println("\n"+message);
			System.out.println("Status code: " + statusCode);
		} else {
			message = jsonPathEvaluator.get("email").toString();
			System.out.println(message);
		}

	}
}
