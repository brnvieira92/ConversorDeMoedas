# 🪙 Conversor de Moeda - Challenge ONE Back-End Java

Este projeto foi desenvolvido como parte do **Challenge ONE Back-End Java** da Alura em parceria com a Oracle. O objetivo é criar um conversor de moedas utilizando Java, consumo de API e boas práticas de programação orientada a objetos.

## 📌 Funcionalidades

- Consulta de taxas de câmbio em tempo real via [ExchangeRate API](https://www.exchangerate-api.com/)
- Conversão entre moedas: ARS, BOB, BRL, CLP, COP, USD
- Interface via terminal para entrada de dados
- Estrutura modular com classes separadas por responsabilidade
- Loop interativo para múltiplas conversões
- Tratamento de erros de conexão e entrada inválida

## 🧱 Estrutura do Projeto

src/ ├── ApiClient.java # Requisição HTTP para obter dados da API
├── JsonParser.java # Interpretação do JSON e extração das taxas
├── ConversorDeMoeda.java # Lógica de conversão entre moedas
├── InterfaceUsuario.java # Entrada e saída via terminal
└── Principal.java # Classe principal que orquestra o fluxo


## 🚀 Como executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/conversor-moeda-java.git
   cd conversor-moeda-java
## 2. Compile e execute com Java 17+:
   
javac src/*.java
java src.Principal

## 3. Siga as instruções no terminal para realizar conversões.

## 🛠️ Tecnologias utilizadas
Java 17

Gson (para manipulação de JSON)

ExchangeRate API

IntelliJ IDEA (recomendado)

## 📚 Aprendizados
Consumo de APIs REST com HttpClient

Manipulação de JSON com Gson

Modularização

Interação com o usuário via terminal

Tratamento de exceções
