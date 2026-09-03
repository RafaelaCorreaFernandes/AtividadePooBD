# Sistema de Vendas CRUD

Sistema de vendas desenvolvido em **Java**, executado localmente via terminal/console, com persistência de dados em **MySQL**. O projeto foi construído aplicando o padrão **DAO (Data Access Object)** para separar a lógica de acesso ao banco de dados das regras de negócio, seguindo uma arquitetura em camadas.

## 📋 Funcionalidades

- Cadastro, listagem, atualização e remoção (CRUD) de **clientes**
- Cadastro, listagem, atualização e remoção (CRUD) de **produtos**
- Registro e consulta de **pedidos**
- Interface de menu interativo via terminal para navegação entre as operações

## 🏗️ Arquitetura

O projeto é organizado em camadas para manter o código desacoplado e de fácil manutenção:

```
src/
├── model/       # Classes que representam as entidades (Cliente, Produto, Pedido)
├── dao/         # Classes responsáveis pelo acesso e manipulação dos dados no banco
├── interface/   # Camada de interação com o usuário (menus via console)
└── Main.java    # Ponto de entrada da aplicação
```

- **Model**: representa as entidades do domínio (Cliente, Produto, Pedido) e seus atributos.
- **DAO**: concentra as operações de CRUD e a comunicação direta com o banco de dados MySQL, isolando o SQL do restante da aplicação.
- **Interface**: camada responsável por exibir os menus e capturar as escolhas do usuário via `Scanner`.

## 🛠️ Tecnologias utilizadas

- Java (JDK)
- MySQL
- JDBC (conexão Java–MySQL)
- Eclipse IDE

## ▶️ Como executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/RafaelaCorreaFernandes/SistemaDeVendasCRUD.git
   ```
2. Crie o banco de dados MySQL e as tabelas necessárias (cliente, produto, pedido).
3. Configure as credenciais de conexão com o banco no arquivo de conexão do projeto.
4. Importe o projeto no Eclipse (ou outra IDE de sua preferência).
5. Execute a classe `Main` para iniciar o sistema.

## 📚 O que aprendi com este projeto

- Aplicação prática do padrão DAO para separar regras de negócio de acesso a dados
- Modelagem de entidades e relacionamento entre clientes, produtos e pedidos
- Uso de JDBC para conectar uma aplicação Java a um banco de dados relacional
- Organização de código em camadas (model, dao, interface) visando manutenibilidade

## 🔜 Possíveis melhorias futuras

- Adicionar validações mais robustas nos cadastros
- Implementar relatórios de vendas
- Migrar para uma versão web (JSP/Servlet)

---

Desenvolvido por [Rafaela Correa Fernandes](https://github.com/RafaelaCorreaFernandes)
