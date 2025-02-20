### Data 20/02/2025

# Teoria - Linguagens Formais

## Um Autômato é 
  <p> Uma Máquina de Estados finitos </p>
  <p> Por exemplo a lâmpada, caso ela esteja no seu estado desligado, se ocorrer um determinado evento ela troca de estado, que seria o estado ligado. </p>
  
## 1936 - Allan Turing - Década de 50
  <p> Desenvolvimento de teorias relacionadas com linguaguens naturais, um dos principais pilares para linguagens artificiais</p>
  <p> <a href="[https://example.com](https://brasilescola.uol.com.br/biografia/noam-chomsky.htm)">Chomsky</a>: Gramáticas Formais, o tutor de Allan Turing. </p>

### Principais Aplicações
<ul>
  <li> Análise léxica de sintática -> Tradutores de linguagens de programação </li>
  <li> Protocolos de comunicação (modelos) </li>
  <li> Modelos de sistemas biológicos </li>
  <li> Procura em corpo de texto, ocorrências de palavras, frases... </li>
  <li> Desenho de hardware (circuitos digitais) </li>
</ul>

### Terminologia 
<p> Informações gerias: </p>

#### Léxico
<ul>
  <li> Termos de um idioma </li>
  <li> Dicionario </li>
</ul>

#### Sintaxe
<ul>
  <li> Forma de escrita </li>
  <li> Forma da linguagem </li>
  <li> Gramática </li>
</ul>

#### Semântica
<ul>
  <li> Sentido </li>
  <li> Significado </li>
</ul>

---

## Formalismos usados
<ul> 
  <li> Formalismo Operacional ou Reconhecedor
    <ul>
      <li> Autômatos = Máquina abstrata</li>
    </ul>
  </li>
  <li> Formalismo Axiomático ou Gerador
    <ul>
      <li> Gramática = regras associadas ao comportamento da linguagem</li>
    </ul>
  </li>
  <li> Formalismo Denotacional
    <ul>
      <li> Expressão Regular</li>
    </ul>
  </li>
</ul>

---

# Alfabeto, palavras, linguagens - Linguagens Formais

## Definicação 1: 
<p> Σ¹ = {a,b,c,d} </p>
<p> Σ² = {0,1} </p>

## Definição 2: Palavras
<p> Σ Representa o alfabeto </p>
<p> Σ* Representa todas palavras possíveis sobre um Σ </p>
<p> Σ⁺ Representa todas as palavras possíveis sobre Σ excetuando-se </p>

## Definição 3: Tamanho ou Comprimento
<p> O tamanho ou comprimento de uma palavra W é o número de símbolos que está palavra é representa por W </p>

## Definicão 4: Prefixo, Sufixo, Subpalavra
<ul>
  <li> Prefixo de uma palavra é qualquer sequência inicial de símbolos da palavra. [1,10,101] </li>
  <li> Sufixo de uma palavra é qualquer sequência final de símbolos da palavra. [1,01,101] </li>
  <li> Subpalavra de uma palavra é qualquer sequência de símbolos contígua da palavra. [prefixos, sufixos, 0]</li>
</ul>

## Definição 5: Linguagem Formal
<p> Uma linguagem formal é um conjunto de palavras sobre um alfabeto </p>
