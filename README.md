# Projeto Spring BootThymeleaf CRUD Database Real-Time JPA

## Descrição do projeto

Projeto Java 11 + Thymeleaf um aplicativo CRUD de funcionários:

- Listar | GET | `http://localhost:8080/` | Status Code (200 (OK)) | Busca todos os funcionários
- Criar | POST | `http://localhost:8080/salvarFuncionario` | Status Code (201 (OK)) | criar um novo funcionário
- Buscar | GET | `http://localhost:8080/buscarFuncionario/{id}` | Status Code (200 (OK)) | Buscar funcionário
- Editar | PUT | `http://localhost:8080/showFormForUpdate/{id}` | Status Code (200 (OK)) | Atualizar funcionário
- Excluir | DELETE | `http://localhost:8080/deleteFuncionario/{id}` | Status Code (204 (No Content)) | Deletar funcionário
- Paginar/Ordenar | `http://localhost:8080/page/1?sortField=Nome&sortDir=desc` | Status Code (200 (OK)) | Busca todos os funcionários paginados ordenados

## Antes de iniciar

Verifique o ambiente com os seguintes parâmetros:

- Instalação Java 11+;
- Eclipse IDE / Intellij Idea ou Spring Tool Suite [STS];
- Verifique o os parâmetros de projeto backend - script de criação do banco de dados;
- MySSQL ou MariaDB;

## Ferramentas e tecnologias do lado do servidor usadas

- Spring Boot 2 +
- SpringData JPA (Hibernate)
- Maven 3.2 +
- Java 11
- Banco de dados MySQL

Clone o projeto em um local com permissões, abra-o no eclipse e aguarde 
as dependências serem baixadas, qualquer dúvida só enviar mensagem.
