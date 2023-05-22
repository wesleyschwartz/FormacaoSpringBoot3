# [Formação Spring Boot 3](https://cursos.alura.com.br/formacao-spring-boot-3)

Sobre este repósitorio:

* Este repósitorio foi criado para fins de estudos e registro

***

# [Spring Boot 3: desenvolva uma API Rest em Java](https://cursos.alura.com.br/course/spring-boot-3-desenvolva-api-rest-java)

* Projeto de uma clínica médica fictícia. Onde uma empresa chamada Voll Med, possui uma clínica que precisa de um
  aplicativo para monitorar o cadastro de médicos, pacientes e agendamento de consultas.
* Será um aplicativo com algumas opções, em que a pessoa que for usar pode fazer o CRUD, tanto de médicos quanto de
  pacientes, o agendamento e cancelamento das consultas.

* [Trello](https://trello.com/b/O0lGCsKb/api-voll-med)
* [Figma](https://www.figma.com/file/N4CgpJqsg7gjbKuDmra3EV/Voll.med?node-id=2-1007)

### Sobre [record](https://docs.oracle.com/en/java/javase/16/language/records.html), lançado oficialmente no Java 16:

* Record é um recurso que permite representar uma classe imutável, contendo **apenas atributos, construtor e métodos de
  leitura**, de uma maneira muito simples e enxuta.
* Esse tipo de classe se encaixa perfeitamente para representar classes DTO, já que seu objetivo é apenas representar
  dados que serão recebidos ou devolvidos pela API

### Sobre [Migrations](https://orango.dev/o-que-sao-migrations-e-porque-usa-las/)

* Uma forma de versionar o banco de dados
* Nesse projeto usamos o flyway que pode:
    * Sincronizar o banco de dados com a versão da aplicação;
    * Saber quais scripts SQL foram executados ou não;
    * Automatizar a execução dos scripts;
    * Criar um banco de dados do zero;
    * Permite criar um rollback de mudanças no banco de dados

## [Certicado](https://cursos.alura.com.br/certificate/wesleyschwartz/spring-boot-3-desenvolva-api-rest-java)

***

# [Spring Boot 3: aplique boas práticas e proteja uma API Rest](https://cursos.alura.com.br/course/spring-boot-aplique-boas-praticas-proteja-api-rest)

* Documentação de properties do
  spring [aqui](https://docs.spring.io/spring-boot/docs/current/reference/html/application-properties.html)
* Spring Security:
    * é um módulo dedicado para tratarmos das questões relacionadas com segurança em aplicações.
    * Principais objetivos: autenticação e autorização de usuários, a proteção contra-ataques, a integração com outros
      frameworks e a
      personalização da lógica de segurança. Ele fornece diferentes mecanismos de autenticação e autorização, além
      de recursos de proteção contra diversos tipos de ataques.
* Stateless vs Statefull
    * Stateless é um sistema sem estado não mantém informações sobre interações anteriores, são usados em serviços web
      simples, como rest API
    * Statefull é um sistema que mantém informações sobre essas interações, são usados em aplicativos mais complexos,
      como comércio eletrônico ou sistemas bancários.
* JSON Web Token, [JWT](https://jwt.io/), é um meio compacto e seguro de representar declarações a serem transferidas
  entre duas partes
* Filters é um dos recursos que fazem parte da especificação de Servlets, a qual padroniza o tratamento de
  requisições e respostas em aplicações Web no Java.

## [Certificado](https://cursos.alura.com.br/certificate/wesleyschwartz/spring-boot-aplique-boas-praticas-proteja-api-rest)

# [Spring Boot 3: documente, teste e prepare uma API para o deploy](https://cursos.alura.com.br/course/spring-boot-3-documente-teste-prepare-api-deploy)

* @JsonAlias
    * é uma anotação da biblioteca Jackson para mapear diferentes nomes de propriedades JSON para um único nome de
      propriedade Java.
    * Exemplo tenham uma propriedade "first_name" em uma fonte e uma propriedade "firstName" em outra fonte.
        * @JsonAlias({"first_name", "firstName"})
          private String nome;
* [Spring doc](https://springdoc.org/v2/)
  * http://localhost:8080/swagger-ui.html
  * http://localhost:8080/v3/api-docs