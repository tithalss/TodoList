# ToDo List

Este projeto é uma aplicação de TODO List implementada em Java, como parte do desafio ZG-Hero. A aplicação consiste em um backend simples que permite a criação, listagem e exclusão de tarefas, com funcionalidades de filtragem e ordenação de acordo com critérios como prioridade, status e categoria.

## Modelo e funcionalidades
- **Tarefa:** Cada tarefa possui os seguintes parâmetros:
    - Nome
    - Descrição
    - Data de término
    - Nível de prioridade (1 a 5)
    - Categoria
    - Status (ToDo, Doing, Done)


- **CRUD de Tarefas:**
    - Criar Tarefas
    - Listar Tarefas por:
        - Categoria
        - Prioridade
        - Status
    - Excluir Tarefas

### Requisitos Opcionais (ainda a serem implementados)
- Consultar o número de atividades por status (Done, ToDo, Doing)
- Atualizar Tarefas
- Filtragem de Tarefas por data
- Persistência de dados em arquivo (.csv, .txt, .xml, .json, etc.)

## Tecnologias Utilizadas
- Java 21
- Intellij

## Como Executar

1. Clone o repositório:
    ```bash
    git clone https://github.com/tithalss/java-todolist.git
    ```
2. Navegue até o diretório do projeto:
    ```bash
    cd "<caminho-para-a-pasta>"
    ```
3. Compile e execute o projeto:
    ```bash
    javac Main.java
    java Main
    ```
---
**Nota:** Este projeto faz parte de um desafio de programação e foi desenvolvido apenas como uma aplicação backend. O frontend, assim como outras funcionalidades, serão implementados posteriormente.