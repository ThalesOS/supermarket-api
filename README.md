# 🛒 Supermarket API - Spring Boot & JPA

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

Uma API RESTful para simular as operações de um supermercado, desenvolvida com Java e Spring Boot.  
Projeto ideal para demonstrar a construção de um backend robusto com **arquitetura em camadas**, **relacionamentos JPA** e **persistência de dados**.

---

### ✍🏻 Autor

<img src="https://avatars.githubusercontent.com/u/174385896?v=4" width="150" alt="Foto de Thales Oliveira"/>

Olá, Sou **Thales Oliveira** 👋

* 📍 **Localidade:** Campina Grande, Paraíba  
* 🎓 **Formação:** Análise e Desenvolvimento de Sistemas - UniFacisa, 2° Semestre  
* 💼 [LinkedIn](https://www.linkedin.com/in/thalesoliveiras)

---

### ✨ Funcionalidades

- **Arquitetura em Camadas:** `Controller`, `Service`, `Repository` e `Model`.
- **Produtos:** CRUD completo (Criar, Ler, Atualizar, Deletar).
- **Clientes:** CRUD completo (Criar, Ler, Atualizar, Deletar).
- **Carrinho de Compras:**
  - Criação automática de um carrinho ao cadastrar um novo cliente.
  - Adicionar e remover produtos de um carrinho.
  - Visualizar o conteúdo de um carrinho por ID.
- **Padrão DTO:** Contrato claro e seguro para a API.
- **Relacionamentos JPA:** (`@OneToOne`, `@ManyToMany`).

---

### 🛠️ Tecnologias

| Tecnologia        | Finalidade                                             |
| ----------------- | ------------------------------------------------------ |
| **Java 17+**      | Linguagem principal                                    |
| **Spring Boot**   | Framework para criação da API                          |
| **Spring Data JPA** | Persistência de dados e comunicação com o banco       |
| **Hibernate**     | Implementação do JPA                                   |
| **H2 Database**   | Banco de dados em memória para desenvolvimento         |
| **Maven**         | Gerenciador de dependências e build                    |
| **Lombok**        | Redução de código boilerplate                          |
| **Postman**       | Testes e validação dos endpoints                       |

---

### 🚀 Como Executar

**Pré-requisitos:**
- Java JDK 17+
- Maven 3.6+

```bash
# 1. Clone o repositório
git clone https://github.com/ThalesOS/supermarket-api.git

# 2. Navegue até a pasta do projeto
cd supermarket-api

# 3. Execute a aplicação com o Maven
mvn spring-boot:run
```
### 📡 Documentação da API

📦 Produtos (/products)

| Método | Endpoint         | Descrição               | Body (JSON) Exemplo                            |
| ------ | ---------------- | ----------------------- | ---------------------------------------------- |
| POST   | `/products`      | Adiciona um produto     | `{ "name": "Leite", "price": 4.50 }`           |
| GET    | `/products`      | Lista todos os produtos | -                                              |
| PUT    | `/products/{id}` | Atualiza um produto     | `{ "name": "Leite Desnatado", "price": 4.75 }` |
| DELETE | `/products/{id}` | Deleta um produto       | -                                              |


👤 Clientes (/clients)

| Método | Endpoint        | Descrição               | Body (JSON) Exemplo         |
| ------ | --------------- | ----------------------- | --------------------------- |
| POST   | `/clients`      | Adiciona um cliente     | `{ "name": "Maria Silva" }` |
| GET    | `/clients`      | Lista todos os clientes | -                           |
| PUT    | `/clients/{id}` | Atualiza um cliente     | `{ "name": "Maria Souza" }` |
| DELETE | `/clients/{id}` | Deleta um cliente       | -                           |


🛒 Carrinho de Compras (/carts)

| Método | Endpoint                               | Descrição                        |
| ------ | -------------------------------------- | -------------------------------- |
| GET    | `/carts/{id}`                          | Busca um carrinho e seu conteúdo |
| POST   | `/carts/{cartId}/products/{productId}` | Adiciona um produto ao carrinho  |
| DELETE | `/carts/{cartId}/products/{productId}` | Remove um produto do carrinho    |

📄 Licença

Este projeto está sob a Licença MIT
.
