package stepdefinition;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import inmetrics.POST.PostUsuario;
import inmetrics.test.validations.ValidacaoMensagens;

public class CadastroSteps {
	
	


	@Dado("^que informo: email:\"([^\"]*)\", empregadoId:\"([^\"]*)\", password: \"([^\"]*)\"\\.$")
	public void queInformoEmailEmpregadoIdPassword(String e_mail, String empregadoId, String password) throws Throwable {
		PostUsuario.adicionaEmpregado(e_mail, empregadoId, password);
	}

	@Entao("^valido as mensagens de retorno: \"([^\"]*)\"\\.$")
	public void validoAsMensagensDeRetorno(String mensagensRetorno) throws Throwable {
		ValidacaoMensagens.mensagemCadastroUsuario(mensagensRetorno);

	}

}
