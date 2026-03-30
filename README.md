GUILHERME OLIVEIRA SANTANA DE ALMEIDA - RM555180

# 🧾 Projeto Consumer SOAP de Estoque em Java

Este projeto é um **cliente (consumer) SOAP** responsável por consumir o Web Service de estoque. Ele permite interagir com o serviço remoto para listar, adicionar e remover produtos via requisições SOAP construídas manualmente.

---

## 🚀 Tecnologias Utilizadas

* Java
* HTTPURLConnection (requisições HTTP)
* SOAP (XML)
* Regex (para parsing da resposta)

---

## 📁 Estrutura do Projeto

```plaintext
org.example
├── model
│   └── Produto.java
├── service
│   └── EstoqueServiceClient.java
├── util
│   └── SoapClient.java
└── Main.java
```

---

## 🧠 Conceitos Aplicados

* Consumo de Web Services SOAP sem frameworks externos
* Construção manual de envelopes SOAP (XML)
* Comunicação via HTTP (POST)
* Parsing de XML com expressões regulares
* Aplicação em camadas (Model, Service, Util, Main)

---

## 📌 Funcionalidades

O cliente consome as seguintes operações do serviço SOAP:

### 📋 Listar Produtos

Realiza uma chamada SOAP para obter todos os produtos cadastrados.

---

### ➕ Adicionar Produto

Envia uma requisição SOAP com nome e preço para cadastrar um novo produto.

---

### ➖ Remover Produto

Remove um produto com base no ID informado.

---

## ▶️ Como Executar

### 1. Pré-requisito

Certifique-se de que o **Web Service SOAP de Estoque** esteja rodando:

```plaintext
http://localhost:8080/estoque
```

---

### 2. Execute a aplicação

Rode a classe:

```plaintext
Main.java
```

---

### 3. Utilize o menu interativo

O sistema exibirá um menu no terminal:

```plaintext
=== MENU ESTOQUE ===
1 - Listar Produtos
2 - Adicionar Produto
3 - Remover Produto
0 - Sair
```

---

## 🔄 Exemplo de Uso

### Listando produtos:

```plaintext
Produtos:
Notebook - ID: 1 - Preço: 3500.0
Mouse - ID: 2 - Preço: 150.0
```

---

### Adicionando produto:

```plaintext
Nome do produto: Teclado
Preço do produto: 200
Produto adicionado com sucesso!
```

---

### Removendo produto:

```plaintext
ID do produto: 1
Produto Removido com sucesso!
```

---

## 🔧 Funcionamento Interno

### 🔹 EstoqueServiceClient

Responsável por montar as requisições SOAP (XML) para cada operação:

* `listarProdutos()`
* `adicionarProduto(nome, preco)`
* `removerProduto(id)`

---

### 🔹 SoapClient

Responsável por:

* Abrir conexão HTTP com o serviço
* Enviar requisição SOAP via POST
* Ler a resposta XML
* Extrair os dados relevantes da tag `<return>`

---

### 🔹 Parsing da Resposta

A resposta SOAP é tratada usando **Regex**, extraindo:

* `id`
* `nome`
* `preco`

E convertendo em uma saída amigável no console.

---

## ⚠️ Observações

* O parsing via Regex funciona, mas **não é o ideal para XML em produção**
* Não há tratamento robusto de erros SOAP (faults)
* O endpoint está fixo em:

  ```java
  http://localhost:8080/estoque
  ```
* O sistema depende do serviço estar ativo

---

## 💡 Melhorias Futuras

* Utilizar bibliotecas como JAX-WS Client ou Apache CXF
* Fazer parsing com XML Parser (DOM / SAX / JAXB)
* Tratar erros SOAP (Faults)
* Externalizar a URL do serviço (configuração)
* Implementar interface gráfica (GUI)

---

## 👨‍💻 Autor

Projeto desenvolvido para fins educacionais com foco em aprendizado de consumo de Web Services SOAP em Java.
