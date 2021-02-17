package inmetrics.POST;

import static io.restassured.RestAssured.given;

import org.junit.Test;

import inmetrics.resources.VarsNovoUsuario;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostUsuario {
	public static String URI = "https://inm-test-api.herokuapp.com/acesso";
	public static String message;
	public static String email;
	public static String acessoId;

	@Test
	public static void adicionaEmpregado(String e_mail, String empregadoId, String password) {

		VarsNovoUsuario novoUsuario = new VarsNovoUsuario();

		novoUsuario.setEmail(e_mail);
		novoUsuario.setEmpregadoId(empregadoId);
		novoUsuario.setPassword(password);
		

		RestAssured.defaultParser = Parser.JSON;

		Response response = 
				given().auth().basic("inmetrics", "automacao")
				.accept(ContentType.JSON).contentType(ContentType.JSON).relaxedHTTPSValidation()
				.body(novoUsuario)
				.when().post(URI + "/cadastrar")
				.then()
				.contentType(ContentType.JSON)
				.extract()
				.response();
		JsonPath jsonPathEvaluator = response.jsonPath();
		int statusCode = response.getStatusCode();
		String code = String.valueOf(statusCode);
		if (code.equals("400")) {
			message = jsonPathEvaluator.get("[0]");
			System.out.println("Status code: " + statusCode);
		}else if (code.equals("500")) {
			System.out.println("Foi encontrada mais de uma linha com o identificador empregadoId: " + empregadoId);
		}else {
			message = code;
			acessoId = jsonPathEvaluator.get("acessoId");
			System.out.println(acessoId);
			System.out.println("Status code: " + statusCode);
		}
//		

	}
}