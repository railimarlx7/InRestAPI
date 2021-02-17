package stepdefinition;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import inmetrics.DELETE.DeleteUsuario;
import inmetrics.test.validations.ValidacaoMensagens;

public class ExclusaoSteps {

	@Dado("^que excluo um empregado cadastrado com acessoID \"([^\"]*)\"\\.$")
	public void queExcluoUmEmpregadoCadastradoComAcessoID(String acessoID)  throws Throwable {
		DeleteUsuario.excluirUsuario(acessoID);
	}

	@Entao("^valido as mensagens de retorno de exclusao: \"([^\"]*)\"\\.$")
	public void validoAsMensagensDeRetornoDeExclusao(String mensagensExclusao) throws Throwable {
		ValidacaoMensagens.mensagemExclusaoUsuario(mensagensExclusao);
	 
	}
}
