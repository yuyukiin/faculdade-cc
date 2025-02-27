# Linguagens Regulares 
- Reconhcer, automatos finitos
- Denotacional, expressoa regular
- Gerador, gramatica regular

  
## Linguagens regulares ou tipo 3, são consideradas as classes mais simples, e são abordadas por 3 formalismos:
- Operacional ou Reconhecedor
  - Autômatos Finitos
- Axiomático ou Gerador
  - Gramática Regular
- Denotacional
  - Expressão Regular   

## Autômato Finito Determinístico (AFD)
- É um Sistema de Estados Finitos
  - Um modelo matemático de sistemas com entradas e saídas discretas.
  - Pode assumir um número finito e conhecido de estados.
  - Cada estado mantém somente as informações passadas necessárias para determinar a ação para a próxima entrada.
 
- Exemplo
  - Lâmpada: Seus possíveis estados pode ser representado por um sistema de Estados Finitos
- Os estados representados por elipses ou círculos
  - São nomeados: 1, 2, 3, ... ou A, B, C ... ou q0, q1, q2 ...
  - As transisções entre os estados são representados por arcos

- Fita de Entrada
  - Dispotivo de entrada que contém o dado a ser processado
  - A fita é finita a esquerda e infinita a direita
  - Cada célula da fita armazena um símbolo pertencente a um alfabeto de entrada
  - Não é possível gravar sobre a fita, acontece somenta a leitra de um símbolo de cada vez
  - Inicialmente, a palavra ocupa toda fita
- Unidade de controle
  - Reflete o estado corrente da maquina (há um número finito e prédefinido de estados.)
  - Possui uma unidade de leitura (cabeça da fita) que acessa uma célula da fita de cada vez e movimenta-se exclusivamente para a direita (uma célula).
  - A unidade de leitura inicia sempre à esquerda da fita.
- Programa ou função de transiçã
  - comanda as leituras e define o estado da máquina.
  − É uma função parcial (cada elemento do domínio está relacionado com no máximo um elemento do contradomínio - estado e símbolo).
  − Determina o novo estado do autômato.
  - Um Autômato Finito não possui memória de trabalho.
  -Para armazenar informações, o AFD usa o conceito de estados.


 # Linguagens Livres de Contexto
 - Reconhecer, automato pilha
 - Gerador, gramatica livre de contexto

# Linguagens Sensíveis ao Contexto
- Máquina de Turing / com fita limitada
- Gramática sensível ao contexto

# Linguagens Enumeráveis Recursivamente
- Máquina de Turing
- Gramática Irrestrita



