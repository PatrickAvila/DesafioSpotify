#language: pt
@faixas
Funcionalidade: Buscar Faixas

	EU COMO usuário do sistema.
	DESEJO realizar meu login.
	PARA QUE seja possível buscar faixas musicais.

Contexto: 
	Dado acesso Url
	Quando desejo logar um usuário com email: testeishtecnologia@outlook.com e senha: testeishtec123
	E fecho modal de premium
	Entao valido que o user Teste Ish Tecnologia está logado

Cenário: Pegar uma faixa
	Dado busco pela faixa Hino do Brasil
	Entao valido que a faixa está Tocando
