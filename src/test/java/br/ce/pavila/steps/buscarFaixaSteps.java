package br.ce.pavila.steps;

import io.cucumber.java.pt.*;

import br.ce.pavila.pages.buscarFaixaPage;
import io.cucumber.java.After;

public class buscarFaixaSteps {
	
	buscarFaixaPage _faixasPage = new buscarFaixaPage();
	
	@Dado("^acesso Url$")
	public void acessoUrl() throws Throwable {
		_faixasPage.acessarUrl();
	}

	@Dado("^busco pela faixa (.*)")
	public void buscarFaixa(String faixa){
		_faixasPage.buscarFaixa(faixa);
	}

	@E("^fecho modal de premium")
	public void fechoModal(){
		_faixasPage.fecharModal();
	}

	@Quando("^desejo logar um usuário com email: (.*) e senha: (.*)$")
	public void queDesejoAdicionarUmaConta(String email, String senha) throws Throwable {
		_faixasPage.logarConta(email,senha);
	}

	@Então("^valido que o user (.*) está logado")
	public void receboAMensagem(String usuario) throws Throwable {
		_faixasPage.validarUsuarioLogado(usuario);
	}

	@Então("^valido que a faixa está (.*)")
	public void validaFaixaTocando(String Status) throws Throwable {
		_faixasPage.validaFaixaTocando(Status);
	}

	@After(order = 0, value = "@funcionais")
	public void fecharBrowser() {
		_faixasPage.fecharBrowser();
	}
}
