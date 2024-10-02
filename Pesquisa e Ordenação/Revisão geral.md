# Ordenação - Organização ou Classificação por Chave(s)

## Algoritmos de Ordenação Simples

### 1. Ordenação por Bolhas (Bubble Sort)
- **Descrição:** Compara pares adjacentes e troca se necessário. Repete até a lista estar ordenada.
- **Estabilidade:** Estável.
- **Complexidade:** Tempo \(O(N^2)\) no pior e médio caso; \(O(N)\) no melhor caso. Espaço \(O(1)\).

### 2. Ordenação por Seleção (Selection Sort)
- **Descrição:** Encontra o menor (ou maior) elemento e o coloca na posição correta, repetindo o processo para o restante da lista.
- **Estabilidade:** Instável.
- **Complexidade:** Tempo \(O(N^2)\) em todos os casos. Espaço \(O(1)\).

### 3. Ordenação por Inserção (Insertion Sort)
- **Descrição:** Constrói a lista ordenada um elemento de cada vez, inserindo elementos da lista não ordenada na posição correta.
- **Estabilidade:** Estável.
- **Complexidade:** Tempo \(O(N^2)\) no pior caso; \(O(N)\) no melhor caso. Espaço \(O(1)\).

## Distância
- Pré-organizar vetores: maiores para o final e os menores para o começo.

## Comparação de Complexidades
- **Tempo:** Todos os algoritmos têm complexidade \(O(N^2)\) no pior caso. Bubble Sort e Insertion Sort podem ser mais eficientes com listas quase ordenadas.
- **Espaço:** Todos utilizam \(O(1)\) de espaço adicional.

## Complexidade = Esforço Computacional
Medido pela quantidade de comparações e trocas necessárias:
- **Comparações:** Quantas vezes os elementos são comparados.
- **Trocas:** Quantas vezes os elementos são trocados de posição.

## Considerações Adicionais
- **Estabilidade:** Algoritmos estáveis preservam a ordem relativa de elementos iguais.
- **Eficiência para Listas Grandes:** Algoritmos como Merge Sort e Quick Sort (\(O(N \log N)\)) são mais adequados. Heap Sort é eficiente, mas menos estável.

---

# Método `compareTo`

O método `compareTo` é usado para definir a ordem natural dos objetos de uma classe em Java. Sua assinatura é `int compareTo(T o)`, onde `T` é o tipo da classe que implementa a interface `Comparable`. O método deve retornar um número negativo se o objeto atual for menor que o objeto passado, zero se forem iguais e um número positivo se for maior.

Exemplo de implementação:

```java
@Override
public int compareTo(Aluno o) {
    throw new UnsupportedOperationException("Not supported yet.");
}
```
---
### Melhor metodo para ordenação?
Depende, se a estrutura estará previamente ordenada ou não, e do seu tamanho de estrutura.

### Métodos de ordenação
Por simplificade de código:
  1. bolha
  2. agitação
  3. pente
  4. seleção
  5. inserção
  6. shell -> distância

### Não simplificado de código:
1. Merge
    - Composto por 2 métodos, sendo um deles recursivo
2. Quick
    - Comporto por 2 métodos, sendo um deles recursivo
3. Heap
    - Totalmente baseado em árvore
4. Bucket
    - Ordenação por dígito, radix           
