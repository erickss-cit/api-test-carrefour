# API-TEST-CARREFOUR
- Projeto de teste Carrefour

## Download

- [Java JDK 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [IntellijIdea Community](https://www.jetbrains.com/idea/download/#section=windows)
- [Git](https://git-scm.com/downloads)
- [Allure](https://github.com/allure-framework/allure2/releases/tag/2.39.0)


## Configurações de Ambiente

- Configure as variavel de ambiente no seu computador:
- JAVA_HOME - "CAMINHO_INSTALADO_DO_JAVA"\jdk-17.0.12
- ALLURE_PATH - "CAMINHO_DA_PASTA"\allure-2.39.0

- Em PATH:
- %JAVA_HOME%\bin
- %ALLURE_PATH%\bin


## Como Executar os cenários

O projeto foi criado no intuito de estar o mais diversificado possível para execução dos cenários, abaixo as formas de execução via IntellijIdea:

- IntellijIdea
Você pode executar via linha de comando:

mvn clean
mvn install
mvn -Dtest=NomeDaClasseTeste test

- Você pode executar via classe do projeto, com o JUnit instalado, pode rodar um unico teste ou todos os testes da classe;
- Você pode executar via classe RunnerIT do projeto, configurando a suite de teste, executando as classes configuradas.

# Plano e Cenários de teste levantado

 - Para planejar os cenários de teste abaixo e suas validações internas, foi levado os seguintes pontos:


1. Parameter Coverage (input)
2. Operation Flow (input)
3. Status Code Coverage (Output)
4. Teste de Aceite
5. Teste Negativo

Login
- POST /
  - Login
  - CT01 - Validar login e geração de token pela aplicação
  - CT02 - Validar login e senha incorretos

Usuarios
- GET /usuarios
  - Buscar usuário para autenticação
    - CT03 - Validar retorno de lista de todos os usuários cadastrados

- POST /usuarios
    - CT04 - Validar cadastro de usuario criado com sucesso

- GET /usuarios/
    - CT05 - Validar busca de usuario com sucesso por ID


## Como gerar relatório automatizado do projeto

- Após a execução do cenário de teste, para que esteja atualizado, use os comandos do maven para limpar e compilar o projeto da seguinte forma:

  mvn clean
  e;
  mvn install

- Após a execução do comando, abra a pasta do projeto, abra o terminal do windows e digite o comando "allure serve target/allure-results", dessa forma, irá carregar o reporte atualizado com os cenários desenvolvidos.
