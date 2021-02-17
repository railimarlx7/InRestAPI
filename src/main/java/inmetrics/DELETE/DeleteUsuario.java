package inmetrics.DELETE;

import static io.restassured.RestAssured.given;

import org.junit.Test;

import inmetrics.GET.GetUsuario;
import inmetrics.POST.PostUsuario;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeleteUsuario {
	public static String URI = "https://inm-test-api.herokuapp.com/acesso/";
	public static String message;
	public static String acessoID;

	@Test
	public static void excluirUsuario(String acessoID) {

		RestAssured.defaultParser = Parser.JSON;

		Response response = given().auth().basic("inmetrics", "automacao").accept(ContentType.JSON)
				.contentType(ContentType.JSON).relaxedHTTPSValidation().when().delete(URI + "deletar/" + acessoID)
				.then().contentType(ContentType.JSON).extract().response();

		message = response.asString();

	}
}