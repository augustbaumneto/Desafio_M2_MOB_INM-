# language: pt

### Criado por August Baumgartner Neto
## Feature de cadastro no app do Alura Esporte

@cadastrar
Funcionalidade: Cadastrar Usuário
  Eu quero cadastrar usuário válido no aplicativo.

Cenário: Cadastro com dados válidos
Dado que estou na tela de cadastro
Quando eu tento realizar o cadastro com usuário válido e senha iguais
Então devo ser direcionado para a tela de login 
E meu cadastro deve ser realizado com sucesso

Cenário: Cadastro com senhas diferentes
Dado que estou na tela de cadastro
Quando eu tento realizar o cadastro com usuário válido e senhas diferentes
Então devo ver a mensagem de erro informando que as senhas não conferem
E devo permanecer na tela de cadastro

Esquema do Cenário: Visualizar senha digitada
Dado que estou na tela de cadastro
E com o campo '<nomecampo>' preenchido
Quando clico no botão visualizar senha ao lado do campo '<nomecampo>'
Então devo ver a senha digitada no campo '<nomecampo>' em formato legível
E devo permanecer na tela de cadastro

Exemplos:
    |  nomecampo      |
    |  senha  				|
    |  confirmarsenha  |

@CT1
Esquema do Cenário: Tentativa de cadastro com campo vazio
Dado que estou na tela de cadastro
Quando eu tento realizar o cadastro com campo '<campo>' vazio e demais dados válidos
Então devo ver a mensagem de erro informando que as senhas não conferem
E devo permanecer na tela de cadastro

Exemplos:
    |  campo      		|
    |  senha  				|
    |  confirmarsenha  | 

Cenário: Tentativa de cadastro com usuário já existente
Dado que estou na tela de cadastro
E possua um usuário já cadastrado
Quando eu tento realizar o cadastro com mesmo usuário
Então devo ver a mensagem de erro "As senhas não correspondem"
E devo permanecer na tela de cadastro