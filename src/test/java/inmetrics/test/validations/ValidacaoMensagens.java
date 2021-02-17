package inmetrics.test.validations;

import static org.junit.Assert.assertEquals;

import inmetrics.DELETE.DeleteUsuario;
import inmetrics.GET.GetUsuario;
import inmetrics.POST.PostUsuario;

public class ValidacaoMensagens {
	
	public static void mensagemCadastroUsuario(String mensagensRetorno) {
		
		assertEquals(mensagensRetorno, PostUsuario.message);
		
	}
	
	public static void mensagemConsultaUsuario(String mensagensConsulta) {
		
		assertEquals(mensagensConsulta, GetUsuario.message);

	}
	
	public static void mensagemExclusaoUsuario(String mensagensExclusao) {
		
		assertEquals(mensagensExclusao, DeleteUsuario.message);
		
	}
	


}
