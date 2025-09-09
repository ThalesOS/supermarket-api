<div align="center">

# 🛒 Supermarket API - Spring Boot & JPA  

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

Uma API RESTful para simular as operações de um supermercado, desenvolvida em **Java** com **Spring Boot**.  
Ideal para demonstrar a construção de um backend robusto com **arquitetura em camadas**, **relacionamentos JPA** e **persistência de dados**.

</div>

---

### ✍🏻 Autor

<div align="center">
  <img src="https://avatars.githubusercontent.com/u/174385896?v=4" width="200" style="border-radius:50%" alt="Foto de Thales Oliveira"/>
</div>

<div align="center">

👋 Olá, sou **Thales Oliveira**  

📍 Campina Grande, Paraíba  
🎓 ADS - UniFacisa (2° Semestre)  
💼 [LinkedIn](https://www.linkedin.com/in/thalesoliveiras)  

</div>

---

### ✨ Funcionalidades

✔️ **Arquitetura em Camadas**: `Controller`, `Service`, `Repository`, `Model`  
✔️ **Produtos**: CRUD completo  
✔️ **Clientes**: CRUD completo  
✔️ **Carrinho de Compras**:  
   - Criação automática ao cadastrar cliente  
   - Adicionar e remover produtos  
   - Visualizar conteúdo por ID  
✔️ **DTOs** para segurança e contrato da API  
✔️ **Relacionamentos JPA**: `@OneToOne`, `@ManyToMany`  

---

### 🛠️ Tecnologias

| Tecnologia        | Finalidade                                             |
| ----------------- | ------------------------------------------------------ |
| **Java 17+**      | Linguagem principal                                    |
| **Spring Boot**   | Framework para criação da API                          |
| **Spring Data JPA** | Persistência de dados e comunicação com o banco       |
| **Hibernate**     | Implementação do JPA                                   |
| **H2 Database**   | Banco em memória para desenvolvimento                  |
| **Maven**         | Gerenciador de dependências e build                    |
| **Lombok**        | Redução de código boilerplate                          |
| **Postman**       | Testes e validação dos endpoints                       |

---

### 🚀 Como Executar

**Pré-requisitos**
- Java JDK 17+
- Maven 3.6+

```bash
# 1. Clone o repositório
git clone https://github.com/ThalesOS/supermarket-api.git

# 2. Acesse a pasta do projeto
cd supermarket-api

# 3. Execute a aplicação com o Maven
mvn spring-boot:run
```
A API estará disponível em:
👉 http://localhost:8080

---

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


## 📄 Licença

Este projeto está sob a licença **MIT** - veja o arquivo [LICENSE](LICENSE) para mais detalhes.

<div align="center">

Feito com 💻 por Thales Oliveira 🚀

</div> 



