package stepdefinition;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import inmetrics.GET.GetUsuario;
import inmetrics.test.validations.ValidacaoMensagens;

public class ConsultaSteps {

	@Dado("^que consulto um empregado cadastrado com acessoID \"([^\"]*)\"\\.$")
	public void queConsultoUmEmpregadoCadastradoComAcessoID(String acessoID) throws Throwable {
		GetUsuario.listarUsuario(acessoID);
	}

	@Entao("^valido as mensagens de retorno de consulta: \"([^\"]*)\"\\.$")
	public void validoAsMensagensDeRetornoDeConsulta(String mensagensConsulta) throws Throwable {
		ValidacaoMensagens.mensagemConsultaUsuario(mensagensConsulta);
	}

}
