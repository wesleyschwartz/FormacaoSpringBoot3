# [Spring Boot 3: desenvolva uma API Rest em Java](https://cursos.alura.com.br/course/spring-boot-3-desenvolva-api-rest-java)

* Projeto de uma clínica médica fictícia. Onde uma empresa chamada Voll Med, possui uma clínica que precisa de um
  aplicativo para monitorar o cadastro de médicos, pacientes e agendamento de consultas.
* Será um aplicativo com algumas opções, em que a pessoa que for usar pode fazer o CRUD, tanto de médicos quanto de
  pacientes, o agendamento e cancelamento das consultas.

* [Trello](https://trello.com/b/O0lGCsKb/api-voll-med)
* [Figma](https://www.figma.com/file/N4CgpJqsg7gjbKuDmra3EV/Voll.med?node-id=2-1007)

## Sobre [record](https://docs.oracle.com/en/java/javase/16/language/records.html), lançado oficialmente no Java 16:

* Record é um recurso que permite representar uma classe imutável, contendo **apenas atributos, construtor e métodos de
  leitura**, de uma maneira muito simples e enxuta.
* Esse tipo de classe se encaixa perfeitamente para representar classes DTO, já que seu objetivo é apenas representar
  dados que serão recebidos ou devolvidos pela API

## Sobre [Migrations](https://orango.dev/o-que-sao-migrations-e-porque-usa-las/)

* Uma forma de versionar o banco de dados
* Nesse projeto usamos o flyway que pode:
    * Sincronizar o banco de dados com a versão da aplicação;
    * Saber quais scripts SQL foram executados ou não;
    * Automatizar a execução dos scripts;
    * Criar um banco de dados do zero;
    * Permite criar um rollback de mudanças no banco de dados (útil em casos rar