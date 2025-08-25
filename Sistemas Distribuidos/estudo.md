##  Sincronização Distribuída -- Relógios Físicos e Lógicos. Exclusão Mútua e Eleição.

-   Teoria básica de sistemas distribuídos

    -   o que é e para que serve -\> compartilhar recurso (cpu, ram,
        memória secundária)
    -   diferenças entre grid (computação concomitante) e cluster
        (computação paralela)
    -   comunicação entre computadores ou equipamentos em sistemas
        distribuídos
        -   model TCP/IP: endereço, porta, máscara de rede, socket,
            camada de transporte (UDP e TCP)
    -   comunicação é leitura (consumidor) ou é escrita (produtor) - É
        BLOQUEANTE
        -   THREADS: mini processos concomitantes -\> desbloquear a
            comunicação
            -   sem memória compartilhada
            -   com memória compartilhada
            -   delegar uma rotina para thread; passar parâmetros;
                identificação
        -   SINCRONISMO -\> acesso a seção crítica -\> memória
            compartilhada
            -   java: sincronized
            -   c# e python: lock
            -   via relógio: físico e lógico
            -   exclusão mútua - lock ou relógio ou eleição

-   Poll de Threads - 

## Threads
-   Revisão
    -   passagem de parâmetro Java (construtor), C# (construtor) e
        Python (args)
    -   quando threads NÃO DEVEM ser utilizadas
        -   baixa complexidade das rotinas ou tarefas envolvidas
        -   seção crítica:
            -   não há possibilidade de gerenciar via sincronismo (java)
                e lock (C# e Python)
-   Threads com memória compartilhada

## Aula 3 - Threads

-   O que são?
    -   mini processos dentro de processos para realizar tarefas ou
        rotinas de forma concomitante
-   Para que servem?
    -   circundam rotinas ou tarefas para essas possam executar
        concomitantemente
-   Em quais tarefas as threads são mais adequadas?
    -   mineração (tratamento e análise de dados)
    -   rotinas que não possuam seção crítica
-   Em quais tarefas ou situações threads NÃO SÃO adequadas?
    -   de interação com o usuário
-   Tipos de threads
    -   sem memória compartilhada - sem seção crítica
    -   com memória compartilhada - com seção crítica

### Exercícios:

-   Para os códigos Threads em Java, C# e Python, adicionar rotinas que
    identifiquem as threads em execução ou finalizadas

### Desafio:

Fazer um programa que: 1. distribua n números em m listas de inteiros
(valores entre 1000 a 100000) 2. faça a média dos valores gerados em
todas as listas 3. circundar as rotinas com threads, desde que possível

Dica Java:

``` java
List<List> listaDeListas = new ArrayList<>();
int totalListas = 1000;
for (int i = 0; i < totalListas; i++) {
    listaDeListas.add( new ArrayList<Integer>());
}

for (int i = 0; i < totalListas; i++) {
    new PopulaLista(listaDeListas.get(i), tamanhoLista).start();
}
```

## Aula 2

-   Threads nas 3 linguagens: ideia geral
-   Desafio 1: Jogo da cobrinha

## Aula 1

-   Apresentação e discussão do plano de ensino
-   Conceitos básicos de SD: comunicação, arquitetura
