# Golden Raspberry Awards API
Indicados e vencedores da categoria Pior Filme do Golden Raspberry Awards.

## Sobre o projeto
API RESTful para possibilitar a leitura da lista de indicados e vencedores
da categoria Pior Filme.

### Recurso disponível
**URL:** /producers/intervals - **Method:** GET
**Exemplo resposta:**
```javascript
{
	"min": [{
		"producer": "Joel Silver",
		"interval": 1,
		"previousWin": 1990,
		"followingWin": 1991
	}],
	"max": [{
		"producer": "Matthew Vaughn",
		"interval": 13,
		"previousWin": 2002,
		"followingWin": 2015
	}]
}
```

## Iniciando

### Requisitos
O projeto foi construído com a versão do Java 17, exigindo o mesmo para execução. A IDE pode
ser definida a critério do usuário, contanto que a mesma ofereça suporte ao controle de 
pacotes Maven.

Outro ponto relevante é a lista inicial de filmes, que esta sendo carregada através do arquivo
**movielist.csv**. O arquivo encontra-se na pasta src/main/resources/static. Os valores podem
ser modificados a critério do usuário, mantendo apenas a formatação, sendo o cabeçalho e a 
ordem dos campos mantidas.

Cada alteração do arquivo exige o reinicio da aplicação para carregar novamente a lista atualizada.


### Execução
A versão disponível do fonte, não contém um pacote prebuild. Para execução, deve ser aberto o projeto
através de uma IDE. Existem várias formas para execução:
* Executar o build e posteriormente o arquivo jar que esta na pasta "target".
* Executar (Run) a classe **MoviesApplication**
* Executar (Debug) a classe **MoviesApplication**

Uma vez iniciado a execução, utilizar uma ferramenta de preferência, como Postman, Insomnia ou
outra para acessar o recurso:
```
curl --request GET \
  --url http://localhost:5000/producers/intervals
```
Também pode ser executada a Api através do [SWAGGER](http://localhost:5000/swagger-ui/index.html)

### Execução de testes
As regras de validação consideram a inserção dos filmes iniciais listados através do CSV.
Executar o teste da classe **MoviesApplicationTests**.

## Construção
* [IntelliJ IDEA](https://www.jetbrains.com/pt-br/idea/) - IDE
* [Maven](https://maven.apache.org/) - Gerenciador de pacotes
* [Java 17](https://www.java.com/pt-BR/) - Plataforma de execução
* [Spring Boot - 2.6.2](https://spring.io/projects/spring-boot) - Framework para construção
* [H2](https://www.h2database.com/html/main.html) - Database de memória
* [JUnit](https://junit.org/junit5/) - Framework de testes
* [Project Lombok](https://projectlombok.org/) - Remoção de código repetitivo
