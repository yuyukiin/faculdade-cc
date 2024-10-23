# Problema de Busca de Substrings

Procurar uma palavra num texto é uma atividade corriqueira. No contexto computacional, esse problema é conhecido como substring searching ou string matching e pode ser formulado assim: encontrar todas as ocorrências de um dado vetor `a` em um dado vetor `b`.

## Algoritmo Inocente / Exercício 1

1. Quantas vezes a palavra `AAA` ocorre no texto `AAAAA`?
2. Quais são os bytes que representam os caracteres `A`, `C`, `G`, e `T`?
3. Faça uma figura semelhante às exibidas acima para mostrar uma ocorrência do vetor `ação` no vetor `notação binária`. Cada pequena caixa da figura deve representar um byte, não um caractere.
4. Discuta (vagamente, em termos gerais) a seguinte afirmação: qualquer algoritmo para a versão simplificada do problema pode ser modificado de modo a resolver a versão mais geral.

## Resolução do Exercício 1 

```c
typedef unsigned char byte;

// Recebe vetores a[1..m] e b[1..n],
// com m >= 1 e n >= 0, e devolve
// o número de ocorrências de a em b.
int inocente(byte a[], int m, byte b[], int n) {
    int ocorrs = 0;
    for (int k = m; k <= n; ++k) {
        // a[1..m] casa com b[k-m+1..k]?
        int i = m, j = k;
        while (i >= 1 && a[i] == b[j]) 
            --i, --j;   
        if (i < 1) ++ocorrs;
    }
    return ocorrs;
}
