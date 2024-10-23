# Problema de Busca de Substrings

Procurar uma palavra num texto é uma atividade corriqueira. No contexto computacional, esse problema é conhecido como substring searching ou string matching e pode ser formulado assim: encontrar todas as ocorrências de um dado vetor `a` em um dado vetor `b`.

> Todos códigos em linguagem C

## Terminologia e decisões de projeto / Exercício 1

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
```

## Algoritmo inocente / Exercícios 2
1. A função inocente está correta quando m > n?  Que acontece se tentarmos executar a função com argumento m igual a 0?
2. Dê um exemplo em que o algoritmo inocente faz o maior número possível de comparações entre elementos de a e b. Qual é esse número exatamente?
3. Solução do problema original.  Modifique a função inocente de modo que ela resolva a versão original do problema da busca: para cada ocorrência de a em b, imprima o índice j para o qual a[1..m] casa com b[j..m+j-1].
4. Familiarize-se com a função strstr da biblioteca string que localiza a primeira ocorrência de uma string em outra. Procure descobrir o algoritmo que strstr implementa.
5. Espaços consecutivos [Sedgewick 3.62]  Escreva uma função que receba um vetor de bytes b[1..n] e um inteiro m e devolva a posição da primeira ocorrência de m espaços (bytes 32) consecutivos em b.  (Você pode imaginar que os elementos de b representam caracteres ASCII, embora isso seja irrelevante.) Procure examinar o menor número possível de elementos de b. Escreva um programa para testar sua função.

## Resolução do Exercício 2

```c
typedef unsigned char byte;

// Recebe vetores a[1..m] e b[1..n] de bytes, 
// com m >= 1 e n >= 0, e devolve o número
// de ocorrências de a em b.

int 
boyermoore1 (byte a[], int m,
             byte b[], int n) 
{
   int ult[256]; // o alfabeto é 0..255

   // pré-processamento da palavra a
   for (int f = 0; f < 256; ++f) ult[f] = 0;
   for (int i = 1; i <=  m; ++i) ult[a[i]] = i;

   // busca da palavra a no texto b
   int ocorrs = 0;
   int k = m;
   while (k <= n) {
      // a[1..m] casa com b[k-m+1..k]?
      int i = m, j = k;
      while (i >= 1 && a[i] == b[j]) 
         --i, --j;   
      if (i < 1) ++ocorrs;
      if (k == n) k += 1;
      else k += m - ult[b[k+1]] + 1;
   }
   return ocorrs;
}
```

## Algorotimos de Boyer-Moore 

### Primeiro algoritmo de Boyter-Moore
```c
typedef unsigned char byte;

// Recebe vetores a[1..m] e b[1..n] de bytes, 
// com m >= 1 e n >= 0, e devolve o número
// de ocorrências de a em b.

int 
boyermoore1 (byte a[], int m,
             byte b[], int n) 
{
   int ult[256]; // o alfabeto é 0..255

   // pré-processamento da palavra a
   for (int f = 0; f < 256; ++f) ult[f] = 0;
   for (int i = 1; i <=  m; ++i) ult[a[i]] = i;

   // busca da palavra a no texto b
   int ocorrs = 0;
   int k = m;
   while (k <= n) {
      // a[1..m] casa com b[k-m+1..k]?
      int i = m, j = k;
      while (i >= 1 && a[i] == b[j]) 
         --i, --j;   
      if (i < 1) ++ocorrs;
      if (k == n) k += 1;
      else k += m - ult[b[k+1]] + 1;
   }
   return ocorrs;
}
```

### Segundo algoritmo de Boyer-Moore 
```c
typedef unsigned char byte;

// Recebe uma palavra a[1..m] com 1 <= m e
// um texto b[1..n]. Devolve o número de
// ocorrências de a em b.

int 
boyermoore2 (byte a[], int m,
             byte b[], int n) 
{
   int *jump = malloc ((m+1) * sizeof (int));
   // usaremos jump[1..m]

   // pré-processamento da palavra a
   int h = m, k = m-1;
   while (h >= 1 && k >= 1) {
      int i = m, j = k; 
      while (i >= h && j >= 1)
         if (a[i] == a[j]) --i, --j;
         else i = m, j = --k;
      jump[h--] = k;
   }
   while (h >= 1)
      jump[h--] = k;

   // busca da palavra a no texto b
   int ocorrs = 0;
   k = m;
   while (k <= n) {
      int i = m, j = k;
      while (i >= 1 && a[i] == b[j]) 
         --i, --j;   
      if (i < 1) ++ocorrs;
      if (i == m) k += 1;
      else k += m - jump[i+1];
   }
   return ocorrs;
}  
```

### Terceiro algoritmo de Boyer-Moore 
```c
typedef unsigned char byte;

// Recebe uma palavra a[1..m] com 1 <= m e
// um texto b[1..n]. Devolve o número de
// ocorrências de a em b.

int 
boyermoore2 (byte a[], int m,
             byte b[], int n) 
{
   int *jump = malloc ((m+1) * sizeof (int));
   // usaremos jump[1..m]

   // pré-processamento da palavra a
   int h = m, k = m-1;
   while (h >= 1 && k >= 1) {
      int i = m, j = k; 
      while (i >= h && j >= 1)
         if (a[i] == a[j]) --i, --j;
         else i = m, j = --k;
      jump[h--] = k;
   }
   while (h >= 1)
      jump[h--] = k;

   // busca da palavra a no texto b
   int ocorrs = 0;
   k = m;
   while (k <= n) {
      int i = m, j = k;
      while (i >= 1 && a[i] == b[j]) 
         --i, --j;   
      if (i < 1) ++ocorrs;
      if (i == m) k += 1;
      else k += m - jump[i+1];
   }
   return ocorrs;
}
```



<h2 align="center">Sites Utilizados</h2>

<div align="center">

| Nome     | Link                                               |
|----------|----------------------------------------------------|
| **Projeto de Algoritmos (em C)** | [Algorotimos de Paulo Feofiloff](https://www.ime.usp.br/~pf/algoritmos/) |
| **Busca de palavras em um texto** | [Busca de palavras de Paulo Feofiloff](https://www.ime.usp.br/~pf/algoritmos/aulas/strma.html) |

</div>
