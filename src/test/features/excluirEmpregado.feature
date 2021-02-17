#language: pt
#utf-8
@all
@delete
Funcionalidade: Exclusao de empregado.
  
  Objetivo: 
  		EXCLUIR empregado

  @delete
  Esquema do Cenário: Excluir empregado utilizando metodo DELETE
    Dado que excluo um empregado cadastrado com acessoID "<acessoID>".
    Entao valido as mensagens de retorno de exclusao: "<mensagensExclusao>".

    Exemplos: 
      | acessoID | mensagensExclusao     |
      |      500 | Acesso não cadastrado |
      |        1 | Deletado              |
