# desafio-mobile-t1-m2-august-neto

<a id="Sobre" ></a>
## Sobre o projeto📊
-----------------------
  
O projeto consisti em uma automação de testes de Mobile para a entrega do desafio do módulo 2 do programa de quality engineering da Inmetrics.  
  
Foram implantados testes relacionados a 4 API disponibilizadas pelo site [REQRES](https://reqres.in), todos os testes validaram o corpo da resposta e o status code.
  
<a id="list-users" ></a>
### LIST USERS📜
--------------------
Api responsável por trazer a lista total de usuários cadastrada, você pode enviar o parâmetro de caminho (path parameter) __"page"__ contendo o numero da página para trazer, ele irá retornar um json contendo a quantidade total de usuários e todos os usuários da página. Nessa API foram implantados os seguintes cenários de testes:  
* Chamada do método sem utilizar parâmetro de caminho (path parameter);  
* Chamada do método utilizando o parâmetro de caminho (path parameter) em 3 situações distintas: página 1 (com usuários), página 2 (com usuários) e página 3 (sem usuários).  
  
<a id="create" ></a>
### CREATE👶
----------------
Api responsável por criar um usuário, na chamada deve ser enviado um json contendo o nome e o cargo, e api deve retornar o usuário criado com os mesmos dados um id e uma data de criação. Nessa API foram implantado apenas o seguinte cenário de testes:  
* Chamada do método padrão informando o body.  
  
<a id="update" ></a>
### UPDATE🦿
----------------  
Api responsável por atualizar dados de um usuário cadastrado. Deve ser informado no parâmetro de caminho (path parameter) o usuario a ser alterado, e na chamada deve ser enviado um json contendo ou nome a ser alterado ou o cargo ou ambas as informações. A resposta dessa api deve ser um json com os dados atualizados do nome e cargo e data de alteração. Nessa API foram implantados os seguintes cenários de testes:  
* Chamada do método utilizando __"put"__ utilizando parâmetro de caminho (path parameter) e alterando apenas um dos dados de cada vez (nome e cargo);  
* Chamada do método utilizando __"put"__ utilizando parâmetro de caminho (path parameter) e alterando os dois dados ao mesmo tempo (nome e cargo);  
* Chamada do método utilizando __"patch"__ utilizando parâmetro de caminho (path parameter) e alterando apenas um dos dados de cada vez (nome e cargo);   
* Chamada do método utilizando __"patch"__ utilizando parâmetro de caminho (path parameter) e alterando os dois dados ao mesmo tempo (nome e cargo).  
  
<a id="delete" ></a>
### DELETE👻
----------------
Api responsável por apagar um usuário, deve ser informado no parâmetro de caminho (path parameter) o usuario a ser excluido. Nessa API foram implantado apenas o seguinte cenário de testes:  
* Chamada do método padrão informando parâmetro de caminho (path parameter) em 4 situações, apagando 1 usuário por cada teste.  
  
#### Status🏆  
Concluído a primeira versão. 🚀
O que não foi feito:
  * Readme.md com links internos funcionais e para o arquivo de licença;
  * Captura das requesições e resposta de cada requisição e organização em evidências;
  * Uso de determinados métodos do Rest Assured;
  * Manipulações para construção de bodys parciais
  * Reportes configurados no cucumber;
  * API e Funcionalidades adicionais.
  
<a id="tabela-de-conteudo" ></a>
## Tabela de conteúdos🤓  
------------------------------
<!--ts-->
   * [Sobre](#Sobre)
      * [LIST USERS](#list-users)
	  * [CREATE](#create)
	  * [UPDATE](#update)
	  * [DELETE](#delete)
   * [Tabela de Conteudo](#tabela-de-conteudo)
   * [Tecnologias](#tecnologias)
   * [Instalação](#instalacao)
   * [Como usar](#como-usar)
      * [Pre Requisitos](#pre-requisitos)
      * [Baixando o projeto e preparando o ambiente](#baixando-e-preparando)
      * [Rodando os Testes](#rodando-os-testes)
      * [Alterando a massa de teste](#alterando-massa)
   * [Autor](#autor)
   * [Licença](#licenca)   
<!--te-->
  
<a id="tecnologias"></a>
## Tecnologias🛰️
-----------------------------
  
As seguintes ferramentas foram usadas na construção do projeto:  
  
- [Eclipse - 4.25](https://www.eclipse.org/downloads/)
- [Maven - 3.10.1](https://maven.apache.org/)
- [JavaSE - 1.8](https://www.java.com/pt-BR/)
- [Cucumber - 7.10.1](https://cucumber.io/)
- [Junit - 5.9.1](https://junit.org/junit5/)
- [Rest Assured - 5.3.0](https://rest-assured.io/)
- [Jackson - 2.14.1](https://github.com/FasterXML/jackson)
- [Lombok - 1.18.24](https://projectlombok.org/) 
  
<a id="como-usar"></a>
## Como Usar🧐
------------------
  
Não é necessário rodar nenhuma aplicação a parte para rodar os scripts de automação, basta seguir os passos e preparar o ambiente.  
  
<a id="pre-requisitos"></a>  
### Pré-requisitos⛽
--------------------
Você precisa ter instalado na máquina o [Git](https://git-scm.com), uma IDE (será exemplificado com o [Eclipse](https://www.eclipse.org/downloads/)) e o [Maven](https://maven.apache.org/).
  
<a id="baixando-e-preparando"></a>
### Baixando o projeto e preparando o ambiente🥘
------------------------------------------------ 
  
#### Direto pelo git💽  
  
```bash
# Clone este repositório
$ git clone https://gitlab.inlabs.app/augustbn/desafio-api-m1-t1-august-neto.git

# Vá para a pasta da aplicação onde o arquivo pom.xml se encontra
$ cd desafio-api-m1-t1-august-neto-versao

# Instale as dependências
$ mvn install

```
  
#### Pelo IDE (Eclipse)🆚  
  
  1. Abre o Eclipse e clique em "File" > "Import";  
  ![a](/src/test/resources/img/import-eclipse/Passo1.png)
  
  2. Selecione a pasta "Maven" > "Existing Manven Projects" e clique em "Next";  
  ![](/src/test/resources/img/import-eclipse/Passo2.png)
  
  3. Selecione a pasta que contem o arquivo "pom.xml", marque o projeto e clique em "Finish";  
  ![](/src/test/resources/img/import-eclipse/Passo3.png)
  
  4. Selecione o projeto carregado com o lado esquerdo do mouse, vá para "Maven" > "Update Project";  
  ![](/src/test/resources/img/import-eclipse/Passo4.png)
  
  5. Marque o projeto e as opções "Update project configuration from pom.xml", "Refresh workspace resources from local filesystem", "clean project" e clique em "OK";  
  ![](/src/test/resources/img/import-eclipse/Passo5.png)
  
  6. Aguarde o projeto atualizar.  
  
<a id="rodando-os-testes"></a>
### Rodando os testes🏃‍
----------------------- 
  
  Você pode escolher rodar todos os testes de uma vez, ou rodar apenas os testes de uma determinada API.  
  
  1. Dentro do IDE, expanda o projeto e vá até a pasta (package) __"acceptance"__ dentro do caminho: "src" > "test" > "java" > "br" > "com" > "inm" > "reqresin" > "api";  
  ![a](/src/test/resources/img/rodar/Passo1.png)
  
  2. Para rodar todos os testes, clique com o lado diretio em cima da pasta __"acceptance"__ e selecione a opção "Run As" > "Junit Test";  
  ![](/src/test/resources/img/rodar/Passo2.png)
      1. Se for rodar apenas os testes de uma API, expanda a pasta __"acceptance"__, selecione a classe "Run" da api desejada, e faço o mesmo procedimento anterior;  
      ![](/src/test/resources/img/rodar/Passo2.1.png)
  3. Aguarde rodar os testes, e acesse a aba Junit para visualizar os resultados dos testes;  
  ![](/src/test/resources/img/rodar/Passo3.png)
  
  4. Para vê a execução individual de cada cenário expanda as suites, no caso de falha verifique o "Faluire Trace" para verificar o problema acontecido;  
  ![](/src/test/resources/img/rodar/Passo4.png)
  
  5. Para ter informações sobre as Requests enviadas e as Responses recebidas, veja o log dentro do "Console";
  ![](/src/test/resources/img/rodar/Passo5.png)
  
  6. Para avaliar os cenários executados, acesse os arquivos .feature dentro da pasta __"features"__ dentro do caminho: "src" > "test" > "resources".  
  ![](/src/test/resources/img/rodar/Passo6.png)
  
<a id="alterando-massa"></a>
### Alterando a massa de teste🥯
-------------------------------
  
  1. Dentro do IDE, acesse a pasta (package) __"massatestes"__ dentro do caminho: "src" > "test" > "java" > "br" > "com" > "inm" > "reqresin" > "api";  
  ![](/src/test/resources/img/alterar-massa/Passo1.png)
  
  2. Abra a classe da API que deseja alterar a massa. Se for api __DELETE__ a massa deve ser alterado direto no cenário de teste dentro do arquivo .feature;  
  ![](/src/test/resources/img/alterar-massa/Passo2.png)
  
  3. Altere a constante desejada, salve o arquivo e rode novamente.  
  ![](/src/test/resources/img/alterar-massa/Passo3.png)
  
<a id="autor"></a>
## Autor😉
------------------
  
Feito por August Baumgartner  
[![Linkedin Badge](https://img.shields.io/badge/-August-blue?style=flat-square&logo=Linkedin&logoColor=white&link=https://br.linkedin.com/in/august-baumgartner-neto-98512720)](https://br.linkedin.com/in/august-baumgartner-neto-98512720) 
[![Gmail Badge](https://img.shields.io/badge/-augustbn@inmetrics.com.br-c14438?style=flat-square&logo=Gmail&logoColor=white&link=mailto:augustbn@inmetrics.com.br)](mailto:augustbn@inmetrics.com.br)

  
<a id="licenca"></a>
## Licença⚠️
------------------
  
Este projeto esta sobe a licença [MIT](/LICENSE.md).
