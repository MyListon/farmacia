# 💊 Farmácia do Campo - Gestão CRUD com Java POO

## 📄 Descrição do Projeto

Este projeto é uma **Atividade Prática (Recap Review)** focada na aplicação dos pilares da **Programação Orientada a Objetos (POO)** em Java. O objetivo foi construir um sistema simples de gestão (**CRUD** - Create, Read, Update, Delete) para o estoque de uma farmácia, utilizando classes abstratas, herança e interfaces.

O Menu principal fornece operações completas de cadastro, consulta, atualização e exclusão de produtos, que são armazenados em uma coleção em memória (`ArrayList`).

## 🛠️ Tecnologias e Ferramentas

* **Linguagem:** Java (versão 17+)
* **Estrutura de Dados:** `java.util.ArrayList` para armazenamento dinâmico.
* **Paradigma:** Programação Orientada a Objetos (POO).

## 🧠 Conceitos de POO Aplicados

A arquitetura do sistema foi desenvolvida seguindo o Diagrama de Classes e as Boas Práticas, enfatizando os seguintes pilares:

| Conceito | Aplicação no Projeto |
| :--- | :--- |
| **Classe Abstrata** | A classe **`Produto`** é definida como **`abstract`** e serve como Super Classe, definindo atributos e métodos comuns a todos os produtos. |
| **Herança** | As classes **`Medicamento`** e **`Cosmetico`** **herdam** de `Produto`, reutilizando sua estrutura e adicionando atributos específicos. |
| **Interface** | A interface **`ProdutoRepository`** define o contrato (assinaturas) para os métodos do **CRUD** que a classe Controller deve implementar. |
| **Polimorfismo** | O método **`visualizar()`** é sobrescrito (`@Override`) nas subclasses para exibir os detalhes exclusivos (`generico` ou `fragancia`), além dos dados básicos do `Produto`. |
| **Coleção** | A classe `ProdutoController` utiliza um **`ArrayList`** (`listaProdutos`) para gerenciar todos os objetos. |

---

## 📂 Estrutura de Pacotes

| Pacote | Função |
| :--- | :--- |
| `farmacia.model` | Contém as classes modelo (`Produto`, `Medicamento`, `Cosmetico`) responsáveis pela definição dos dados e comportamento. |
| `farmacia.repository` | Contém a interface **`ProdutoRepository`** (o contrato do CRUD). |
| `farmacia.controller` | Contém a classe **`ProdutoController`**, que implementa a interface e contém a lógica de negócio e o armazenamento dos dados. |
| `farmacia` | Contém a classe principal **`Menu`** com o método `main`. |

---

## ⚙️ Funcionalidades (CRUD)

O sistema oferece as seguintes operações, que são implementadas nos métodos da interface `ProdutoRepository`:

1.  **Cadastrar Produto** (`criarProduto`)
2.  **Listar todos os Produtos** (`listarTodos`)
3.  **Buscar por ID Produto** (`consultarPorId`)
4.  **Atualizar Dados do Produto** (`atualizarProduto`)
5.  **Apagar Produto** (`deletarProduto`)

---

## 🚀 Como Executar o Projeto

1.  **Clone o Repositório:**
    ```bash
    git clone [link-do-seu-repositorio]
    ```
2.  **Importe para o IDE:**
    * Abra seu IDE (Eclipse, VSCode, etc.).
    * Importe o projeto como um projeto Java existente.
3.  **Execute a Classe Principal:**
    * Execute a classe `farmacia.Menu` para iniciar a aplicação e interagir com o Menu principal.

  ------------------------------------------

## 📈 Diagrama de Caso de Uso (Mermaid)

Este diagrama ilustra as funcionalidades principais do sistema e a interação do usuário.

```mermaid
%% Diagrama de Caso de Uso para Farmácia
graph TD
    %% Definindo Ator
    subgraph Ator
        A1[Usuário]
    end

    %% Definindo o Limite do Sistema (Sistema de Gestão)
    subgraph Sistema de Gestão da Farmácia
        U1(1. Cadastrar Produto)
        U2(2. Listar Todos)
        U3(3. Consultar por ID)
        U4(4. Atualizar Dados)
        U5(5. Apagar Produto)
    end
    
    %% Relacionamentos de Uso
    A1 --> U1
    A1 --> U2
    A1 --> U3
    A1 --> U4
    A1 --> U5

    %% Relacionamentos Extend (Tipos de Produto)
    U1 --> |<<extends>>| M[Cadastrar Medicamento]
    U1 --> |<<extends>>| C[Cadastrar Cosmético]
