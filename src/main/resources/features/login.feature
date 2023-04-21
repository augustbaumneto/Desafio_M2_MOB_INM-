# language: pt

### Criado por August Baumgartner Neto
## Feature de login no app do Alura Esporte

@login
Funcionalidade: Login no aplicativo
    Eu quero efetuar login no aplicativo apenas com dados válidos de usuários já cadastros no aplicativo
  
  Esquema do Cenário: Login com usuário e/ou senha inválidos e/ou vazios
    Dado que eu estou na tela de login
    E tenha um usuário já cadastrado
    Quando eu tento realizar o login com usuário '<condicaousuario>' e com senha '<condicaosenha>'
    Então eu vejo uma mensagem de erro informando que o usuário ou senha estão incorretos
  
  Exemplos:
    |  condicaousuario  |  condicaosenha  |
    |  inválido  				|  inválido       |
    |  inválido  				|  válido         |
    |  válido  				  |  inválido       |
    |  válido  					|  vazio	        |
    |  vazio   				  |  válido       	|
    |  vazio  					|  vazio       		|
        
  @CT1
  Cenário: Login com usuário e senha válidos
    Dado que eu estou na tela de login
    E tenha um usuário já cadastrado
		Quando eu tento realizar o login com usuário 'válido' e com senha 'válido'
		Então é efetuado o login redirecionando para a tela lista de produtos

