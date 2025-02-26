# Inteligência Artificial

## Técnica de Resolução de Problemas:
  - Que tipo de problema? 
    - (A) Diagnóstico ou reconhecimento de padrões
      - área médica
      - processamento de imagens  
    - (B) Definição de passos até o estado final (empacotamento)
      - área de jogos  

## Sistemas de Comportamento Inteligente
  - Base de conhecimento (gigantesca)
    - Fatos
  - Raciocínio automatizado (dedução e indução)
  - Aprendizagem -> reconhecimento de padrões por treino

## Áreas 
  - (A) Métodos de busca (solução de problemas)
    - Profundidade, amplitude, subida de encosta, gulosa, A*
    - Algoritmos genéticos
  - (A) (B) Representação de conhecimento
    - prolog
    - ontologia
  - (B) Sistemas Multiagentes
  - (A) Redes Neurais
  - (A) Processamento da lingua natural - PLN

### Problemas
  1. Resolver o jogo da velha - B
  2. Resolver problema de mal funcionamento no computador - A
  3. Resolver o problema do puzzle - B
  4. Fazer a entrega de n pizzas por um moto boy em um tempo mínimo - B
  5. Montar a grade de horários em um curso de graduação - B
  6. Identificar os instrumentos musicais em uma música - A

## Modelar a solução com alguma técnica de IA
  1. Mapear os estados possíveis do problema
     - Definir classe e seus atributos
     - Definir o estado inicial e o estado(s) final (is)
  2. Mapear os métodos das classes - regras de sansição
  3. Mapear as restrições
  4. Forma de mapear os visitados - hashSet ou árvore
    - gerar uma string dos atributos daquele estado/objeto
  5. Definir o método meta ou objetivo

### Observação
- Toda vez que um estado/objeto é gerado é preciso fazer 3 testes:
  1. é valido?
  2. já visitei?
  3. é a meta?
