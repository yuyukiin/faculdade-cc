### Data: 20/02/2025

# Teoria - Linguagens Formais

## Um Autômato é
Uma Máquina de Estados finitos. 

Por exemplo, a lâmpada: caso ela esteja no seu estado desligado, se ocorrer um determinado evento, ela troca de estado, que seria o estado ligado.

---

## 1936 - Allan Turing - Década de 50
Desenvolvimento de teorias relacionadas com linguagens naturais, um dos principais pilares para linguagens artificiais.

- **Chomsky**: Gramáticas Formais, o tutor de Allan Turing.  
  [Chomsky - Biografia](https://brasilescola.uol.com.br/biografia/noam-chomsky.htm)

---

### Principais Aplicações
- Análise léxica e sintática → Tradutores de linguagens de programação
- Protocolos de comunicação (modelos)
- Modelos de sistemas biológicos
- Procura em corpo de texto, ocorrências de palavras, frases...
- Desenho de hardware (circuitos digitais)

---

### Terminologia

#### Léxico
- Termos de um idioma
- Dicionário

#### Sintaxe
- Forma de escrita
- Forma da linguagem
- Gramática

#### Semântica
- Sentido
- Significado

---

## Formalismos usados
- **Formalismo Operacional ou Reconhecedor**  
  - Autômatos = Máquina abstrata
- **Formalismo Axiomático ou Gerador**  
  - Gramática = Regras associadas ao comportamento da linguagem
- **Formalismo Denotacional**  
  - Expressão Regular

---

# Alfabeto, palavras, linguagens - Linguagens Formais

## Definição 1:
- Σ¹ = {a, b, c, d}
- Σ² = {0, 1}

---

## Definição 2: Palavras
- **Σ**: Representa o alfabeto
- **Σ***: Representa todas as palavras possíveis sobre um Σ
- **Σ⁺**: Representa todas as palavras possíveis sobre Σ, exceto a palavra vazia (ε)

---

## Definição 3: Tamanho ou Comprimento
O tamanho ou comprimento de uma palavra **W** é o número de símbolos que ela contém. A palavra **W** é representada por **|W|**.

---

## Definição 4: Prefixo, Sufixo, Subpalavra
Seja **W = 101**, então:

- **Prefixo** de uma palavra é qualquer sequência inicial de símbolos da palavra.  
  Exemplos: [1, 10, 101]
- **Sufixo** de uma palavra é qualquer sequência final de símbolos da palavra.  
  Exemplos: [1, 01, 101]
- **Subpalavra** de uma palavra é qualquer sequência de símbolos contíguos da palavra.  
  Exemplos: [prefixos, sufixos, 0]

---

## Definição 5: Linguagem Formal
Uma linguagem formal é um conjunto de palavras sobre um alfabeto. Exemplos de linguagens formais:

- **L¹ = {W ∈ Σ⁺ | Σ = {0,1} e W tem sufixo 0}**  
  Representação por compreensão: L¹ = {0, 10, 000, 010, 110, ...}  
  Representação por extensão: {0, 10, 000, 010, 110, ...}

- **L² = {W ∈ {0,1}* | W tem prefixo 11}**

---

## Definição 6: Concatenação

A concatenação é uma operação binária que associa a cada par de palavras uma terceira palavra formada pela justaposição da primeira com a segunda. Essa operação satisfaz as propriedades descritas a seguir, considerando **v**, **w**, **t** como palavras.

- **a. Associatividade**:  
  v(wt) = (vw)t

- **b. Elemento Neutro à esquerda e à direita**:  
  εw = w = wε

---

## Definição 7: Concatenação Sucessiva

A concatenação sucessiva de uma palavra (com ela mesma), **wᵃ**, é definida da seguinte forma:

- **a)** Se **w ≠ ε**:  
  - w⁰ = ε  
  - wⁿ = wⁿ⁻¹ w, para n > 0

- **b)** Se **w = ε**:  
  - w⁰ é indefinido  
  - wⁿ = ε, para n > 0
