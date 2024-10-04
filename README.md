# desafio-mobile-t1-m2-august-neto

<a id="tabela-de-conteudo" ></a>
## Tabela de conteúdos🤓  
------------------------------
<!--ts-->
   * [Tabela de Conteudo](#tabela-de-conteudo)
   * [Sobre](#Sobre)
	  * [Funcionalidades](#funcionalidades)
		* [LOGIN](#login)
		* [CADASTRO](#cadastro)
	  * [Banco de dados](#banco-dados)
	  * [Reportes](#reportes)
   * [Status do Projeto](#Status-do-Projeto)
   * [Tecnologias](#tecnologias)
   * [Como usar](#como-usar)
      * [Pre Requisitos](#pre-requisitos)
      * [Baixando o projeto e preparando o ambiente](#baixando-e-preparando)
	  * [Criando o banco de dados](#criando-banco-dados)
      * [Rodando os Testes](#rodando-os-testes)
   * [Autor](#autor)
   * [Licença](#licenca)   
<!--te-->

<a id="Sobre" ></a>
## Sobre o projeto 👩‍🏫
-----------------------
  
O projeto consiste em uma automação de testes de Mobile para a entrega do desafio do módulo 2 do programa de quality engineering da Inmetrics.  
  
Foram implantados testes relacionados a 2 funcionalidades do aplicativo __Alura Esporte__ para Android, aplicativo utilizado no curso __"Appium: compreenda e aplique testes de interfaces"__.

Toda execução gera um arquivo __".log"__ que armazena os dados do que foi feito, é gravado em um banco de dados local os resultados dos testes e são gerados dois reportes um próprio do Cucumber e utilizando a biblioteca ReportBuilder. O log e os arquivos de reportes são substituido em uma nova execução.

<a id="funcionalidades" ></a>
### Funcionalidades 🛠️
-----------------------
  
<a id="login" ></a>
#### LOGIN 👤
--------------------
Funcionalidade responsável por efetuar de fato o login no aplicativo. Para efetuar o login é necessário ter um usuário cadastrado, e preencher com os dados do usuário e senha corretos. Nessa funcionalidade foram implantados os seguintes cenários de testes:  
* Teste positivo logando com usuário e senha corretos, sendo o usuário já cadastrado;  
* Combinação de testes negativos utilizando usuário vazio ou inválido e senha vazia ou inválida.  
  
<a id="cadastro" ></a>
#### CADASTRO 📋
----------------
Funcionalidade responsável por criar um usuário, o usuário não deve existir e a senha deve ser a mesma nos campos "senha" e "confirmar senha". Nessa funcionalidade foram implantado os seguintes cenários de testes:  
* Teste positivo cadastrando um usuário não existente com ambos os campos senha com os mesmos dados;
* Testes positivos visualizando as senhas digitadas;
* Teste negativo utilizando senhas diferentes;
* Testes negativos deixando campos senhas vazios;
* Testes negativo utilizando um usuário já existente. 

<a id="banco-dados"></a>
### Sobre o Banco de Dados 🏦
-------------------------------
  
  Todos os dados de execuções são gravados dentro de três tabelas no banco de dados.
  - __tb_Suite_Execucao__: São gravados horário de inicio, fim da execução e o arquivo de log;
  - __tb_Resultado_Execucao__: São gravados tipo do cenário ("esquema" ou "padrão"), o nome, se for um esquema o detalhe do esquema, horário de inicio do teste, horário do fim do teste e o status da execução ("Passou", "Falhou" ou "Erro");
  - __tb_Massa_Execucao__: São gravados os dados da massa, no caso o tipo e o valor da massa.

<a id="reportes"></a>
### Sobre os Reportes 📊 
-------------------------------
  
  O primeiro reporte gravado é o próprio do cucumber, ele fica gravado dentro da pasta com o nome da funcionalidade no caminho "target" > "Reportes" > "cucumber".  
  ![a](/src/main/resources/img/reportes/cucumber.png)
  
  O Segundo reporte gravado pela biblioteca ReportBuilderJava, ele fica gravado no arquivo __"reporte_execucao_rbuilder.html"__ no caminho "target" > "Reportes" > "ReportBuilder".  
  ![a](/src/main/resources/img/reportes/reportbuilder.png)

<a id="Status-do-Projeto"></a>  
## Status do Projeto🏆
-------------------------------

![Concluído](https://img.shields.io/static/v1?label=Status&message=Concluído&color=important)
  
Concluído a primeira versão. 🚀<br>
O que não foi feito:
  * Captura das evidências dos testes e devida organização, embora o framework esteja pronto para o mesmo;
  * Testes de funcionalidades adicionais.
    
<a id="tecnologias"></a>
## Tecnologias🛰️
-----------------------------
  
As seguintes ferramentas foram usadas na construção do projeto:  
  
- [Eclipse - 4.25](https://www.eclipse.org/downloads/)
- [Maven - 3.8.6](https://maven.apache.org/)
- [JavaSE - 1.8.0](https://www.java.com/pt-BR/)
- [Cucumber - 7.10.1](https://cucumber.io/)
- [Junit - 5.9.1](https://junit.org/junit5/)
- [Appium - 1.22.3](https://appium.io/docs/en/2.0/)
- [Appium Java Client - 8.3.0](https://appium.io/docs/en/2.0/ecosystem/)
- [Node.js - 2.14.1](https://nodejs.org/en)
- [NPM - 1.18.24](https://docs.npmjs.com/) 
- [Android Studio Eletric Eel - 2022.1.1 Patch 2](https://developer.android.com/studio?gclid=EAIaIQobChMI_rq_te7A_gIVSi1MCh2YYwW-EAAYASAAEgIjc_D_BwE&gclsrc=aw.ds)
- [slf4j - 2.0.7](https://www.slf4j.org/)
- [Java Faker - 1.0.2](https://github.com/DiUS/java-faker)
- [SQLite - 3.41.2.1](https://sqlite.org/index.html)
- [Jackson XML- 2.15.0](https://camel.apache.org/components/3.20.x/dataformats/jacksonXml-dataformat.html)
- [me.jvt.Cucumber - 7.0.0](https://central.sonatype.com/artifact/me.jvt.cucumber/reporting-plugin/5.0.0?smo=true)
- [ReportBuilderJava - 1.0.3](https://reportbuilderjava.rajatthareja.com/)
  
<a id="como-usar"></a>
## Como Usar🧐
------------------
  
Para poder rodar os testes não é necessário ter o Appium Server rodando, a própria automação cuida da inicialização e fechamento do mesmo. No entanto é necessário ter um dispositivo conectado seja ele virtual ou físico. No caso de um dispositivo físico, é necessário ter instalado em sua máquina adb e seu dispositivo deve estar no modo desenvolvedor com a depuração ativada via USB.
Nesse exemplo foi utilizado o Virtual Device Manager do Android Studio para simular um dispositivo. 
É também necessário ter preparado o ambiente.  
  
<a id="pre-requisitos"></a>  
### Pré-requisitos⛽
--------------------
Você precisa ter instalado na máquina o [Git](https://git-scm.com), uma IDE (será exemplificado com o [Eclipse](https://www.eclipse.org/downloads/)), o [Maven](https://maven.apache.org/) e o [Android Studio](https://developer.android.com/studio?gclid=EAIaIQobChMI_rq_te7A_gIVSi1MCh2YYwW-EAAYASAAEgIjc_D_BwE&gclsrc=aw.ds).
  
<a id="baixando-e-preparando"></a>
### Baixando o projeto e preparando o ambiente🥘
------------------------------------------------ 
  
#### Direto pelo git💽  
  
```bash
# Clone este repositório
$ git clone https://gitlab.inlabs.app/pfqe/t1m2/desafio-mobile-t1m2-augustbn.git

# Vá para a pasta da aplicação onde o arquivo pom.xml se encontra
$ cd desafio-api-m1-t2-august-neto

# Instale as dependências
$ mvn install

```
  
#### Pelo IDE (Eclipse)🆚  
  
  1. Abre o Eclipse e clique em "File" > "Import";  
  ![a](/src/main/resources/img/import-eclipse/Passo1.PNG)
  
  2. Selecione a pasta "Maven" > "Existing Manven Projects" e clique em "Next";  
  ![a](/src/main/resources/img/import-eclipse/Passo2.PNG)
  
  3. Selecione a pasta que contem o arquivo "pom.xml", marque o projeto e clique em "Finish";  
  ![a](/src/main/resources/img/import-eclipse/Passo3.PNG)
  
  4. Selecione o projeto carregado com o lado esquerdo do mouse, vá para "Maven" > "Update Project";  
  ![a](/src/main/resources/img/import-eclipse/Passo4.PNG)
  
  5. Marque o projeto e as opções "Update project configuration from pom.xml", "Refresh workspace resources from local filesystem", "clean project" e clique em "OK";  
  ![a](/src/main/resources/img/import-eclipse/passo5.PNG)
  
  6. Aguarde o projeto atualizar.  

<a id="criando-banco-dados"></a>
### Criando o banco de dados 🧱
----------------------- 
  
  Antes de iniciar os testes é necessário criar o banco de dados para armazenar, para isso basta seguir os passos abaixo.  
  
  1. Apague o arquivo __"db_Execucao_Teste.bd"__ na pasta __"BancoDados"__ dentro do caminho: "src" > "main" > "resources";  
  ![a](/src/main/resources/img/criar-banco/Passo1.PNG)

  2. Navegue até a pasta __"config"__ dentro do caminho: "src" > "test" > "java" > "br" > "com" > "inm" > "appesporte" > "mobile";
  ![a](/src/main/resources/img/criar-banco/Passo2.PNG)
  
  3. Execute como uma aplicação Java a classe __"CriaEstruturaBanco"__. Esse programa irá criar o banco de dados na pasta correta deixando pronta para registrar as execuções.
  ![a](/src/main/resources/img/criar-banco/Passo3.png)
  
  4. Pasta com o banco criado.
  ![a](/src/main/resources/img/criar-banco/Passo4.png)
 
<a id="rodando-os-testes"></a>
### Rodando os testes🏃‍
----------------------- 
  
  Você pode escolher rodar todos os testes de uma vez, ou rodar apenas os testes de uma determinada funcionalidade. Para os testes é necessário que o Appium server tenha iniciado na porta correta e um dispositivo ou simulador esteja ligado a ele.  
  
  1. Dentro do IDE, expanda o projeto e vá até a pasta (package) __"acceptance"__ dentro do caminho: "src" > "test" > "java" > "br" > "com" > "inm" > "appesporte" > "mobile";  
  ![a](/src/main/resources/img/rodar/Passo1.PNG)
  
  2. Para rodar todos os testes, clique com o lado direito em cima da pasta __"acceptance"__ e selecione a opção "Run As" > "Junit Test";  
  ![a](/src/main/resources/img/rodar/Passo2.PNG)
      1. Se for rodar apenas os testes de uma funcionalidade, expanda a pasta __"acceptance"__, selecione a classe "Run" da funcionalidade desejada e faça o mesmo procedimento anterior;  
      ![a](/src/main/resources/img/rodar/Passo2.1.PNG)
  3. Aguarde rodar os testes, e acesse a aba Junit para visualizar os resultados dos testes;  
  ![a](/src/main/resources/img/rodar/Passo3.PNG)
  
  4. Para vê a execução individual de cada cenário expanda as suites, no caso de falha verifique o "Failure Trace" para verificar o problema acontecido;  
  ![a](/src/main/resources/img/rodar/Passo4.PNG)
  
  5. Para ter informações mais detalhadas da execução acesse o arquivo __"automacao_teste_alura_esporte.log"__ dentro da pasta "logs". Atenção o arquivo é apagado a cada execução, então caso queira manter o histórico não esqueça de copiá-lo para outro local;
  ![a](/src/main/resources/img/rodar/Passo5.PNG)
  
  6. Para avaliar os cenários executados, acesse os arquivos .feature dentro da pasta __"features"__ dentro do caminho: "src" > "main" > "resources".  
  ![a](/src/main/resources/img/rodar/Passo6.PNG)
  
  7. Todos os resultados são armazenados dentro do banco de dados __"db_Execucao_Teste.bd"__ dentro da pasta: "src" > "main" > "resources" > "BancoDados". Mais informações vê a sessão sobre o banco de dados.
  ![a](/src/main/resources/img/rodar/Passo7.PNG)
  <br>
  
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
