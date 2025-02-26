# Inteligência Artificial

## Técnica de Resolução de Problemas

- **Que tipo de problema?**
  - **(A) Diagnóstico ou reconhecimento de padrões**
    - Área médica
    - Processamento de imagens
  - **(B) Definição de passos até o estado final (empacotamento)**
    - Área de jogos

## Sistemas de Comportamento Inteligente

- **Base de Conhecimento (gigantesca)**
  - Fatos
- **Raciocínio automatizado (dedução e indução)**
- **Aprendizagem**
  - Reconhecimento de padrões por treino

## Áreas

- **(A) Métodos de Busca (solução de problemas)**
  - Profundidade, amplitude, subida de encosta, gulosa, A*
  - Algoritmos genéticos
- **(A) (B) Representação de Conhecimento**
  - Prolog
  - Ontologia
- **(B) Sistemas Multiagentes**
- **(A) Redes Neurais**
- **(A) Processamento da Linguagem Natural (PLN)**

### Exemplos de Problemas

1. Resolver o jogo da velha - **B**
2. Resolver problema de mal funcionamento no computador - **A**
3. Resolver o problema do puzzle - **B**
4. Fazer a entrega de n pizzas por um moto boy em um tempo mínimo - **B**
5. Montar a grade de horários em um curso de graduação - **B**
6. Identificar os instrumentos musicais em uma música - **A**

## Modelar a Solução com Alguma Técnica de IA

1. **Mapear os estados possíveis do problema**
   - Definir classe e seus atributos
   - Definir o estado inicial e o(s) estado(s) final(is)
2. **Mapear os métodos das classes** - Regras de transição
3. **Mapear as restrições**
4. **Forma de mapear os visitados** - `HashSet` ou árvore
   - Gerar uma string dos atributos daquele estado/objeto
5. **Definir o método meta ou objetivo**

### Observações

- Toda vez que um estado/objeto é gerado, é preciso realizar 3 testes:
  1. **É válido?**
  2. **Já visitei?**
  3. **É a meta?**
