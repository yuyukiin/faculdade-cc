# Avaliação Semestral de Pesquisa e Ordenação
18/09/2024
Nome: Yuri Alexander Costa Machado

Enviar o arquivo da avaliação para alexz@ufn.edu.br. Assunto deve ser:
Prova Pesquisa e ordenação.

### 1) O que é ordenação e qual o seu papel nos sistemas de informação
Ordenação é a forma de organização feita nas estruturas de dados, que tem como papel otimizar a estrutura de dados a deixando organizada para busca de informações por exemplo.

### 2) Na construção de algoritmos, por exemplo. algoritmos de ordenação, há o conceito de complexidade. Assim, em ordenação como se calcula ou se mede a complexidade.
A complexidade é o esforço computacional, todos algoritmos tem. Os faotres que definem aumentando ou diminuindo, são a simplicidade no código, caso sejam simplificados a complexidade será maior e a otimização também.

### 3) Novamente no conteto de algoritmos de ordenação, há algoritmos estáveis e instáveis. Explique o que sso signfiica.
Estáveis são algoritmos que seguem ordenando a partir do primeiro momento, não fazendo uma desordem geral. Instáveis desorganizam todos para após organizar.

### 4) Dos algoritmos estudados (bolha, seleção, inserção e pente), há um desses que tem um desempenho muito bom. Qual é? E qual o recurso computaiconal que ele utiliza para ser melhor que os outros? Explique a resposta.

### 5) Observe a sequecia de números no vetor: 0 1 2 3 4 5 6 - indices / 7 3 5 1 8 2 5 - valores
  > a) quantas comparações e trocas vão ocorrer usando o bolha?
  
  > b) quantas comparações e trocas vão ocorrer usando o pente?

### 6) Dos métodos estudados (bolha, seleção, inserção e pente)
Estáveis: Bolha e seleção 
Instáveis: Inserção e pente

### 7) No processo de ordenação de listas contendo objetos, com pessoas que derivam da classe Pessoa(nome, email, telfone, curso), para usar o método sort() em java ou C Sharp é preciso realizar alterações na classe Pessoa
para que a ordenação ocorra corretamente. Exemplifique e explique qual(is) é(são) essa(s) alterações? Assuma que o atributo chave de ordenação da classe pessoa é nome seguido de curso.
O motivo principal é por conta do método compareTo. CompareTo tem a finalidade de definir uma ordem dos objetos em Java. Caso não utilizasse, a ordenação teria que ser feita a "mão" pelo programador, mas já que
existe o compareTo, podemos utilizar o método para definir a ordem.
