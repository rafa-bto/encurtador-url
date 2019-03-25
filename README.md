# Encurtador-url

Este projeto recebe uma URL via POST e devolve uma URL menor que redireciona pra URL enviada.

## Começo

Clone o projeto em qualquer diretório de sua preferência e em seguinda edite o arquivo application.properties de forma que o mesmo aponte para o database do Mongo correspondente na sua maquina. neste database deverá haver uma collection de nome endereco (caso não haja a aplicação criara uma assim que a primeira URL for salva). 
Para subir a aplicação basta ir no pasta do projeto e executar o comando "mvn package". este comando irá gerar um arquivo .jar dentro da pasta "target", localizada na raiz do projeto. Em seguinda, estando na pasta raiz do projeto execute o comando "mvn spring-boot:run". Isto irá subir a aplicação que por padrão subirá na porta 8080.

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

Para obter dados sobre a URL enviada deve-se fazer um GET no endereço da aplicação, conforme exemplo abaixo:
```
http://localhost:8080/url
```

### Docker

Para subir a aplicação via Docker é necessario possuir uma maquina com acesso root que tenha o Docker e o Docker-Compose instalados. Clonar o projeto e dentro da pasta raiz do projeto executar os seguintes comandos:

```
mvn clean install
```
```
sudo docker-compose build
```
```
sudo docker-compose up
```

### Pré-requisitos

- JAVA 8+
- Maven
- MongoDB server
- Docker

## Softwares utilizados


* [SpringBoot](https://spring.io/projects/spring-boot/)
* [Maven](https://maven.apache.org/)
* [MongoDB](https://docs.mongodb.com/manual/introduction/)


## Autor

* **Rafael Brito** 

