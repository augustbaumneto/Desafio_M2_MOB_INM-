# language: pt

### Criado por August Baumgartner Neto
## Feature de login no app do Alura Esporte

@login
Funcionalidade: Login no aplicativo
    Eu quero efetuar login no aplicativo apenas com dados válidos de usuários já cadastros no aplicativo

  Cenário: Login com usuário e senha inválidos
    Dado que eu estou na tela de login
    E tenha um usuário já cadastrado
    Quando eu preencho o campo usuário com um usuário inválido
    E preencho o campo senha com uma senha inválida
    E clico no botão logar
    Então eu vejo uma mensagem de erro informando que o usuário ou senha estão incorretos

  Cenário: Login com usuário válido e senha inválida
    Dado que eu estou na tela de login
    E tenha um usuário já cadastrado
    Quando eu preencho o campo usuário com um usuário válido
    E preencho o campo senha com uma senha inválida
    E clico no botão logar
    Então eu vejo uma mensagem de erro informando que a senha está incorreta

  Cenário: Login com usuário inválido e senha válida
    Dado que eu estou na tela de login
    E tenha um usuário já cadastrado
    Quando eu preencho o campo usuário com um usuário inválido
    E preencho o campo senha com uma senha válida
    E clico no botão logar
    Então eu vejo uma mensagem de erro informando que o usuário está incorreto

  Cenário: Login com usuário e senha válidos
    Dado que eu estou na tela de login
    E tenha um usuário já cadastrado
    Quando eu preencho o campo usuário com um usuário válido
    E preencho o campo senha com uma senha válida
    E clico no botão logar
    Então eu sou redirecionado para a tela lista de produtos

