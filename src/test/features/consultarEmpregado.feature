#language: pt
#utf-8
@all
@get
Funcionalidade: Consulta de empregado.
  
  Objetivo: 
  		CONSULTAR empregado

  @get
  Esquema do Cenário: Consultar empregado utilizando metodo GET
    Dado que consulto um empregado cadastrado com acessoID "<acessoID>".
    Entao valido as mensagens de retorno de consulta: "<mensagensConsulta>".

    Exemplos: 
      | acessoID | mensagensConsulta      |
      |        1 | teste@inmetrics.com.br |
      |       88 | Acesso não cadastrado  |
