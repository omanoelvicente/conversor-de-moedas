# Conversor de Moedas
## Resoluçao do challenge do Programa NEXT ONE, Alura Oracle
Este sistema é uma aplicação de linha de comando para realizar conversões de moedas utilizando a API ExchangeRate-API. Ele permite ao usuário converter valores entre diferentes moedas, visualizar os resultados das conversões e registrar as operações realizadas em um arquivo JSON para   posterior.

## Funcionalidades

### 1. Conversão de Moedas
- Permite a conversão entre as seguintes moedas:
    - **Dólar (USD)** e **Peso Argentino (ARS)**
    - **Dólar (USD)** e **Real Brasileiro (BRL)**
    - **Euro (EUR)** e **Real Brasileiro (BRL)**
- A taxa de conversão é obtida em tempo real por meio da API ExchangeRate-API.

### 2. Registro de Conversões
- Todas as operações de conversão são registradas em um arquivo JSON (`log.json`).
- Cada registro inclui:
    - Data e hora da conversão.
    - Código da moeda base e da moeda alvo.
    - Valor inicial a ser convertido.
    - Taxa de conversão utilizada.
    - Valor convertido.

### 3. Sistema de Menu
- Um menu interativo é exibido ao usuário, oferecendo as opções de conversão disponíveis e permitindo o encerramento do programa.

## Estrutura do Sistema

### Classes Principais

#### 1. `MoedaDTO`
- Representa os dados de uma conversão de moeda obtida da API.
- Atributos:
    - `base_code`: Código da moeda base.
    - `target_code`: Código da moeda alvo.
    - `conversion_rate`: Taxa de conversão entre as moedas.
    - `conversion_result`: Resultado da conversão.

#### 2. `Moeda`
- Modela uma operação de conversão de moeda.
- Atributos:
    - `dataDeCriacao`: Data e hora da conversão.
    - `codigoMoedaBase`: Código da moeda base.
    - `codigoMoedaAlvo`: Código da moeda alvo.
    - `valorAConverter`: Valor inicial para conversão.
    - `taxaDeConversao`: Taxa de conversão aplicada.
    - `valorConvertido`: Valor resultante da conversão.

#### 3. `ConverteMoeda`
- Responsável por realizar a integração com a API ExchangeRate-API.
- Método principal:
    - `ProcuraMoeda(String codigoMoeda1, String codigoMoeda2, BigDecimal valor)`:
        - Recebe os códigos das moedas e o valor a ser convertido.
        - Faz a requisição para a API e retorna um objeto `MoedaDTO` com os resultados da conversão.

#### 4. `Log`
- Gerencia o registro das operações de conversão no arquivo JSON.
- Funcionalidades principais:
    - Leitura do arquivo JSON existente.
    - Adição de novos registros de conversão.
    - Escrita dos dados atualizados no arquivo.

#### 5. `SerealizaLocalDateTime`
- Serializa objetos do tipo `LocalDateTime` para o formato `dd-MMM-yyyy HH:mm:ss`.
- Utilizado pelo `Gson` para manter um formato legível nos registros do arquivo JSON.

#### 6. `Principal`
- Classe principal que executa o programa.
- Funcionalidades:
    - Exibe o menu de opções ao usuário.
    - Realiza as conversões de moeda com base na escolha do usuário.
    - Registra as conversões realizadas em memória e no arquivo JSON ao final da execução.

## Requisitos

### Dependências
- Biblioteca `Gson` para serialização e deserialização de objetos JSON.
- Biblioteca `Dotenv` para gerenciar a chave de API.

### Configuração
1. Adicione a chave da API ExchangeRate-API em um arquivo `.env` no seguinte formato:
   ```env
   API_KEY=SuaChaveDaAPI
   ```

2. Certifique-se de que o arquivo `.jar` ou a aplicação pode acessar o arquivo `.env` corretamente.

## Exemplo de Registro no Arquivo `log.json`

```json
[
  {
    "dataDeCriacao": "10-Dec-2024 18:23:54",
    "codigoMoedaBase": "EUR",
    "codigoMoedaAlvo": "BRL",
    "valorAConverter": 200.0,
    "taxaDeConversao": 6.42,
    "valorConvertido": 1284.16
  },
  {
    "dataDeCriacao": "10-Dec-2024 18:24:20",
    "codigoMoedaBase": "USD",
    "codigoMoedaAlvo": "ARS",
    "valorAConverter": 100.0,
    "taxaDeConversao": 1016.75,
    "valorConvertido": 101675.0
  }
]
```

## Como Executar
1. Compile as classes Java utilizando `javac`.
2. Execute o programa a partir da classe `Principal`.
3. Siga as instruções do menu interativo.

## Contribuição
Sinta-se à vontade para melhorar o sistema. Para sugerir alterações, abra uma *issue* ou envie um *pull request* no repositório correspondente.

---
**Autor:** Manoel Vicente

