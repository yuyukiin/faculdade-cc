
# Estudo de Algoritmos de Escalonamento

## Conjunto de Processos

| Processo | Ciclos de CPU | Prioridade |
|----------|----------------|------------|
| P1       | 10             | 3          |
| P2       | 1              | 1          |
| P3       | 2              | 3          |
| P4       | 1              | 4          |
| P5       | 5              | 2          |

> Todos os processos chegam no instante 0.  
> Menor valor de prioridade indica maior prioridade.

---

## a) Diagramas de Gantt e Regras de Funcionamento

### FIFO (First-In, First-Out)

> **Regra:**  
> Executa os processos na **ordem de chegada**.  
> Não há preempção (interrupção).  
> Se houver empate (todos chegam ao mesmo tempo), a ordem original é mantida (P1, P2, P3, ...).

```
| P1 | P2 | P3 | P4 | P5 |
|----|----|----|----|----|
0    10   11   13   14   15
```

---

### SJF (Shortest Job First - Não Preemptivo)

> **Regra:**  
> Sempre executa o processo com **menor tempo de CPU restante** entre os disponíveis no momento.  
> Em caso de empate no tempo de CPU, desempata pela **ordem de chegada** (FIFO).  
> Não preemptivo: o processo não pode ser interrompido até terminar.

```
| P2 | P4 | P3 | P5 | P1 |
|----|----|----|----|----|
0    1    2    4    9    19
```

---

### Prioridade (Não-preemptivo)

> **Regra:**  
> Executa o processo com a **maior prioridade** (menor número) entre os disponíveis.  
> Em caso de empate de prioridade, desempata pela **ordem de chegada**.  
> Não há preempção: quem começa, termina.

```
| P2 | P5 | P1 | P3 | P4 |
|----|----|----|----|----|
0    1    6   16   18   19
```

---

### Round Robin (Quantum = 3)

> **Regra:**  
> Cada processo recebe no máximo **3 unidades de tempo (quantum)** por vez.  
> Se o processo não terminar no quantum, ele volta para o final da fila.  
> A fila é circular (cíclica).  
> Todos os processos são tratados igualmente, na **ordem de chegada**.

```
| P1 | P2 | P3 | P4 | P5 | P1 | P5 | P1 |
|----|----|----|----|----|----|----|----|
0    3    4    6    7    10   13   15   19
```

---

## b) Tempo de Retorno (Turnaround Time)

> Tempo de Retorno = Tempo de Término - Tempo de Chegada (todos chegaram no tempo 0)

| Processo | FIFO | SJF | Prioridade | RR |
|----------|------|-----|------------|----|
| P1       | 10   | 19  | 16         | 19 |
| P2       | 11   | 1   | 1          | 4  |
| P3       | 13   | 4   | 18         | 6  |
| P4       | 14   | 2   | 19         | 7  |
| P5       | 15   | 9   | 6          | 15 |

---

## c) Tempo de Espera

> Tempo de Espera = Tempo de Retorno - Tempo de CPU

| Processo | FIFO | SJF | Prioridade | RR |
|----------|------|-----|------------|----|
| P1       | 0    | 9   | 6          | 9  |
| P2       | 10   | 0   | 0          | 3  |
| P3       | 11   | 2   | 16         | 4  |
| P4       | 13   | 1   | 18         | 6  |
| P5       | 10   | 4   | 1          | 10 |

---

## d) Tempo Médio de Espera

| Algoritmo   | Tempo Médio de Espera |
|-------------|------------------------|
| FIFO        | (0 + 10 + 11 + 13 + 10) / 5 = 8.8 |
| SJF         | (9 + 0 + 2 + 1 + 4) / 5 = 3.2     |
| Prioridade  | (6 + 0 + 16 + 18 + 1) / 5 = 8.2   |
| Round Robin | (9 + 3 + 4 + 6 + 10) / 5 = 6.4    |

---
```
