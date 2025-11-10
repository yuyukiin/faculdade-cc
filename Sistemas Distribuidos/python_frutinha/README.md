# Jogo de Coleta com Sockets (Python)

Este é um projeto de exemplo para a disciplina de Sistemas Distribuídos, implementando um jogo multiplayer simples de cliente-servidor usando sockets.

A implementação é feita 100% em Python e roda inteiramente no terminal, sem necessidade de bibliotecas gráficas.

## Conceito

* **Servidor (`server.py`):** Gerencia o estado do jogo, incluindo a posição de todos os jogadores e da "recompensa" (o item a ser coletado). Ele recebe os comandos de movimento dos clientes e distribui o estado atualizado do jogo para todos.
* **Cliente (`client.py`):** Conecta-se ao servidor, envia os comandos de teclado do usuário (W, A, S, D) e renderiza o estado do jogo recebido no terminal.

## Como Executar

1.  **Clone o repositório:**
    ```bash
    git clone [URL_DO_SEU_REPOSITORIO]
    cd jogo-frutinha-python
    ```

2.  **Inicie o Servidor:**
    Abra um terminal e execute:
    ```bash
    python server.py
    ```
    (No Windows, pode ser necessário usar `python` em vez de `python3`)

3.  **Inicie os Clientes:**
    Abra *outro* terminal (ou vários) e execute:
    ```bash
    python client.py
    ```
    Execute este comando em quantos terminais quiser. Cada um será um novo jogador.

4.  **Para Jogar:**
    No terminal do cliente, use as teclas `W`, `A`, `S`, `D` e pressione `Enter` para se mover.

## Autor

* Yuri [Seu Sobrenome] - (@yuyukiin)
