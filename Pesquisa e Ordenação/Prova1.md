# Avaliação Semestral de Pesquisa e Ordenação
- Data: 18/09/2024

- Nome: Yuri Alexander Costa Machado

> Enviar o arquivo da avaliação para alexz@ufn.edu.br. Assunto deve ser: Prova Pesquisa e ordenação.

---

### 1) O que é ordenação e qual o seu papel nos sistemas de informação
Ordenação é a forma de organização feita nas estruturas de dados, que tem como papel otimizar o algoritmo o tornando melhor para busca de informações.

### 2) Na construção de algoritmos, por exemplo. algoritmos de ordenação, há o conceito de complexidade. Assim, em ordenação como se calcula ou se mede a complexidade.
A complexidade é o esforço computacional, todos algoritmos tem uma complexidade. É medida pela contagem de comparações e trocas que o algoritmo faz, e então se utiliza a notação Big-Oh para obter uma estimativa de eficiência do algoritmo.

### 3) Novamente no conteto de algoritmos de ordenação, há algoritmos estáveis e instáveis. Explique o que sso signfiica.
Estáveis são algoritmos que seguem ordenandos a partir do primeiro momento, não fazendo uma desordem geral. Instáveis desorganizam todos para após organizar.
Algoritmos de ordenação estáveis mantêm a ordem relativa de elementos iguais após a ordenação. 
Algoritmos instáveis não garantem a mesma ordem, pegando um atributo e o comparando com todos, e se repetindo isso até o fim.

### 4) Dos algoritmos estudados (bolha, seleção, inserção e pente), há um desses que tem um desempenho muito bom. Qual é? E qual o recurso computaiconal que ele utiliza para ser melhor que os outros? Explique a resposta.
O metodo é o pente, e o seu recurso computacional é a analise a distância.

### 5) Observe a sequecia de números no vetor: 0 1 2 3 4 5 6 - indices / 7 3 5 1 8 2 5 - valores

  **a) quantas comparações e trocas vão ocorrer usando o bolha?**
  21 comprações e 9 trocas
  
  **b) quantas comparações e trocas vão ocorrer usando o pente?**
  16 comprações e 8 trocas


### 6) Dos métodos estudados (bolha, seleção, inserção e pente)

Estáveis: Bolha e seleção 

Instáveis: Inserção e pente

### 7) No processo de ordenação de listas contendo objetos, com pessoas que derivam da classe Pessoa(nome, email, telfone, curso), para usar o método sort() em java ou C Sharp é preciso realizar alterações na classe Pessoa para que a ordenação ocorra corretamente. Exemplifique e explique qual(is) é(são) essa(s) alterações? Assuma que o atributo chave de ordenação da classe pessoa é nome seguido de curso.
O motivo principal é o método compareTo. O compareTo tem a finalidade de definir uma ordem para os objetos em Java. Caso não fosse utilizado, a ordenação teria que ser feita manualmente pelo programador. No entanto, como existe o compareTo, podemos utilizá-lo para definir a ordem.
Seguindo uma regra mais direta, é preciso implementar a interface Comparable para que possamos modificar o método compareTo, adicionando o atributo nome para comparação. Se os nomes forem iguais, devemos comparar o curso. Na classe Pessoa, precisamos implementar a interface Comparable para modificar o método compareTo, utilizando o atributo nome como critério de comparação. Na classe main, é necessário importar a classe Collections para poder utilizar o método sort.


