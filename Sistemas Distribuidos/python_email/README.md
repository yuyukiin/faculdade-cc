
# Sistema Cliente-Servidor de Cadastro

Este projeto é uma simples aplicação cliente-servidor desenvolvida em Python com uma interface gráfica usando a biblioteca Tkinter.

A aplicação permite que múltiplos clientes se conectem a um servidor para se cadastrarem. Ao receber o nome completo de um cliente, o servidor gera um e-mail institucional fictício, armazena o nome em uma lista de clientes conectados e devolve os dados para o cliente. O servidor impede o cadastro de nomes duplicados.

## Funcionalidades

* **Servidor:**
    * Inicia a escuta em uma porta TCP especificada.
    * Aceita múltiplas conexões de clientes simultaneamente usando threads.
    * Recebe um nome do cliente, o converte para maiúsculas e gera um e-mail no formato `primeironome.ultimonome@ufn.edu.br`.
    * Mantém uma lista de clientes conectados e a exibe em sua interface.
    * Registra logs de conexões.

* **Cliente:**
    * Permite que o usuário insira seu nome completo e a porta do servidor.
    * Envia o nome para o servidor.
    * Recebe e exibe os dados da pessoa (nome e e-mail gerado) ou uma mensagem de erro se o nome já estiver cadastrado.
    * Registra logs da comunicação.

## Pré-requisitos

Antes de começar, garanta que você tenha os seguintes softwares instalados:

* **Python 3.x:** A aplicação foi desenvolvida em Python e utiliza bibliotecas padrão.
* **Visual Studio Code (Recomendado):** Um editor de código com um terminal integrado que facilita a execução do servidor e do cliente ao mesmo tempo.
* **Extensão Python para VS Code:** Se for usar o VS Code, instale a extensão oficial da Microsoft para Python.

## Como Rodar a Aplicação

Siga os passos abaixo para executar o projeto.

### 1. Estrutura dos Arquivos

Primeiro, certifique-se de que todos os três arquivos estejam na mesma pasta. A estrutura deve ser a seguinte:

```
/seu_projeto/
├── servidor.py
├── cliente.py
└── pessoa.py
```

### 2. Abra o Projeto no VS Code

Abra a pasta `seu_projeto` diretamente no Visual Studio Code.

### 3. Inicie o Servidor

O servidor **deve** ser iniciado antes de qualquer cliente.

1.  Abra um novo terminal no VS Code (`Terminal > New Terminal` ou `Ctrl+` \`).
2.  Execute o script do servidor com o seguinte comando:
    ```bash
    python servidor.py
    ```
3.  Uma janela com o título **"Servidor"** irá aparecer.
4.  No campo **"Porta"**, digite um número de porta para o servidor (ex: `9999`).
5.  Clique no botão **"Iniciar"**. O log na janela mostrará que o servidor está escutando.

> **Atenção:** Mantenha a janela do servidor e seu terminal abertos durante toda a execução.

### 4. Inicie o Cliente

1.  No VS Code, abra um **segundo terminal**. A maneira mais fácil é dividir o terminal existente clicando no ícone de "Split".
2.  No novo terminal, execute o script do cliente:
    ```bash
    python cliente.py
    ```
3.  Uma nova janela com o título **"Cliente"** irá aparecer.
4.  Preencha os campos:
    * **Nome:** Seu nome completo (ex: "Ada Lovelace").
    * **Porta:** O **mesmo** número de porta que você usou no servidor (ex: `9999`).
5.  Clique no botão **"Conectar"**.

### 5. Verifique o Resultado

* A janela do **Cliente** mostrará no log a confirmação da conexão e os dados da pessoa com o e-mail gerado.
* A janela do **Servidor** mostrará no log uma nova conexão e o nome "ADA LOVELACE" aparecerá na lista de clientes à direita.

Você pode repetir o Passo 4 em novos terminais para simular múltiplos clientes se conectando ao mesmo servidor.
