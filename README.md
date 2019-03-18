# Encurtador-url

Este projeto recebe uma URL via POST e devolve uma URL menor que redireciona pra URL enviada.

## Começo

Clone o projeto em qualquer diretório de sua preferência e em seguinda edite o arquivo application.properties de forma que o mesmo aponte para o database do Mongo correspondente na sua maquina. neste database deverá haver uma collection de nome endereco (caso não haja a aplicação criara uma assim que a primeira URL for salva). 
Para subir a aplicação basta ir no pasta do projeto e executar o comando "mvn package". este comando irá gerar um arquivo .war dentro da pasta "target", localizada na raiz do projeto. Em seguinda, estando na pasta raiz do projeto execute o comando "mvn spring-boot:run". Isto irá subir a aplicação que por padrão subirá na porta 8080.

Para criar uma URL encurtada, deve-se fazer um POST no endereço da aplicação, conforme exemplo abaixo: 
```
http://localhost:8080/url
```
sendo que o objeto a ser enviado via POST deve possuir a seguinte estrutura:
```
{
    "url":"www.url-a-ser-encurtada.com"
}
```
Caso a URL seja válida, a aplicação deverá retornar a nova URL para direcionamento.
para validar a URL basta acessa-lá, que a aplicação efetuará o redirecionamento.

### Pré-requisitos

- JAVA 8+
- Maven
- MongoDB server

## Softwares utilizados


* [SpringBoot](hhttps://spring.io/projects/spring-boot/)
* [Maven](https://maven.apache.org/)
* [MongoDB](https://docs.mongodb.com/manual/introduction/)


## Authors

* **Rafael Brito** 

