# Principais Elementos HTML

Abaixo estão listados os principais elementos HTML, com uma breve explicação de cada um para facilitar os estudos.

---

## Estrutura Básica de um Documento HTML

```html
<!DOCTYPE html>
<html>
  <head>
    <!-- Cabeçalho do documento: metadados, título, links para CSS, scripts, etc. -->
  </head>
  <body>
    <!-- Corpo do documento: conteúdo visível da página -->
  </body>
</html>
```

---

## Elementos de Estrutura e Conteúdo

- **`<div>`**  
  Usado como um contêiner genérico para agrupar outros elementos.  
  Exemplo:  
  ```html
  <div class="container">
    <p>Texto dentro de um div.</p>
  </div>
  ```

- **`<p>`**  
  Define um parágrafo de texto.  
  Exemplo:  
  ```html
  <p>Este é um parágrafo.</p>
  ```

- **`<h1>` a `<h6>`**  
  Títulos, com `<h1>` sendo o mais importante e `<h6>` o menos.  
  Exemplo:  
  ```html
  <h1>Título Principal</h1>
  <h2>Subtítulo</h2>
  ```

- **`<br>`**  
  Insere uma quebra de linha no texto.  
  Exemplo:  
  ```html
  Linha 1<br>Linha 2
  ```

---

## Elementos Especiais

- **`&shy;`**  
  Inserção de um caractere de hífen suave, permitindo quebra de palavras.  
  Exemplo:  
  ```html
  Palav&shy;ra
  ```

- **`<hgroup>`**  
  Agrupa múltiplos títulos (`<h1>` a `<h6>`) e subtítulos relacionados.  
  Exemplo:  
  ```html
  <hgroup>
    <h1>Título Principal</h1>
    <h2>Subtítulo</h2>
  </hgroup>
  ```

- **`<header>`**  
  Representa o cabeçalho de uma página ou seção.  
  Exemplo:  
  ```html
  <header>
    <h1>Bem-vindo ao Meu Site</h1>
  </header>
  ```

- **`<img src="">`**  
  Insere uma imagem. O atributo `src` especifica o caminho para o arquivo da imagem.  
  Exemplo:  
  ```html
  <img src="caminho-da-imagem.jpg" alt="Descrição da imagem">
  ```

- **`<meta>`**  
  Define metadados sobre o documento, como charset, autor, ou viewport.  
  Exemplo:  
  ```html
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  ```

- **`<title>`**  
  Define o título da página exibido na aba do navegador.  
  Exemplo:  
  ```html
  <title>Meu Primeiro Site</title>
  ```

---

## Observação
Esses são apenas alguns dos principais elementos. Há muitos outros que podem ser explorados conforme você avança nos estudos de HTML.
