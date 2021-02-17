#language: pt
#utf-8
@all @post
Funcionalidade: Cadastrar de empregado.
  
  Objetivo: 
  		Cadastrar novo empregado

  @post
  Esquema do Cenário: Incluir Empregado utilizando metodo POST
    Dado que informo: email:"<e_mail>", empregadoId:"<empregadoId>", password: "<password>".
    Entao valido as mensagens de retorno: "<mensagensRetorno>".

    Exemplos: 
      | e_mail            | empregadoId | password | mensagensRetorno                           |
      | api@inmetrics.com |          17 |          | password: must not be blaank                |
      | api@inmetrics.com |             | senha17  | empregadoId: must not be null              |
      | api@              |          17 | senha17  | email: must be a well-formed email address |
