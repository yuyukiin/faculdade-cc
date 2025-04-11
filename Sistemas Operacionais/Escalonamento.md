
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

# Detalhamento de Tempos por Algoritmo de Escalonamento

---

## FIFO (First-In, First-Out)

### Tabela

| Processo | Ciclos de CPU | Término | Tempo de Retorno | Tempo de Espera |
|----------|----------------|---------|------------------|-----------------|
| P1       | 10             | 10      | 10               | 0               |
| P2       | 1              | 11      | 11               | 10              |
| P3       | 2              | 13      | 13               | 11              |
| P4       | 1              | 14      | 14               | 13              |
| P5       | 5              | 15      | 15               | 10              |

**Tempo Médio de Espera**: (0 + 10 + 11 + 13 + 10) / 5 = **8.8**  
**Tempo Médio de Retorno**: (10 + 11 + 13 + 14 + 15) / 5 = **12.6**

---

## SJF (Shortest Job First)

### Tabela

| Processo | Ciclos de CPU | Término | Tempo de Retorno | Tempo de Espera |
|----------|----------------|---------|------------------|-----------------|
| P2       | 1              | 1       | 1                | 0               |
| P4       | 1              | 2       | 2                | 1               |
| P3       | 2              | 4       | 4                | 2               |
| P5       | 5              | 9       | 9                | 4               |
| P1       | 10             | 19      | 19               | 9               |

**Tempo Médio de Espera**: (0 + 1 + 2 + 4 + 9) / 5 = **3.2**  
**Tempo Médio de Retorno**: (1 + 2 + 4 + 9 + 19) / 5 = **7.0**

---

## Prioridade (Não-preemptivo)

### Tabela

| Processo | Prioridade | Ciclos de CPU | Término | Tempo de Retorno | Tempo de Espera |
|----------|-------------|----------------|---------|------------------|-----------------|
| P2       | 1           | 1              | 1       | 1                | 0               |
| P5       | 2           | 5              | 6       | 6                | 1               |
| P1       | 3           | 10             | 16      | 16               | 6               |
| P3       | 3           | 2              | 18      | 18               | 16              |
| P4       | 4           | 1              | 19      | 19               | 18              |

**Tempo Médio de Espera**: (0 + 1 + 6 + 16 + 18) / 5 = **8.2**  
**Tempo Médio de Retorno**: (1 + 6 + 16 + 18 + 19) / 5 = **12.0**

---

## Round Robin (Quantum = 3)

### Ordem de Execução

- P1 (3 unidades, restam 7)
- P2 (termina em 1)
- P3 (termina em 2)
- P4 (termina em 1)
- P5 (3 unidades, restam 2)
- P1 (3 unidades, restam 4)
- P5 (2 unidades, termina)
- P1 (4 unidades, termina)

### Tabela

| Processo | Ciclos de CPU | Término | Tempo de Retorno | Tempo de Espera |
|----------|----------------|---------|------------------|-----------------|
| P1       | 10             | 19      | 19               | 9               |
| P2       | 1              | 4       | 4                | 3               |
| P3       | 2              | 6       | 6                | 4               |
| P4       | 1              | 7       | 7                | 6               |
| P5       | 5              | 15      | 15               | 10              |

**Tempo Médio de Espera**: (9 + 3 + 4 + 6 + 10) / 5 = **6.4**  
**Tempo Médio de Retorno**: (19 + 4 + 6 + 7 + 15) / 5 = **10.2**
