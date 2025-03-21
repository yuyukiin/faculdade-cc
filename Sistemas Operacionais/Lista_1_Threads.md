## 1. Modo Dual e Proteção no Sistema Operacional
O Modo Dual (Modo Usuário e Modo Kernel) funciona como um mecanismo de proteção ao restringir o acesso direto ao hardware e a operações privilegiadas apenas ao Modo Kernel. Aplicações comuns rodam no Modo Usuário, e quando necessitam de recursos do sistema, fazem chamadas ao sistema que são tratadas pelo Kernel, garantindo a integridade e segurança do sistema.

## 2. Diferença entre Interrupção e Exceção
- **Interrupção**: Evento externo ao processador, geralmente originado por hardware, como uma solicitação de I/O.
- **Exceção**: Evento interno ao processador, causado por erros de software ou instruções específicas, como divisão por zero ou falha de página.

## 3. Utilidade das Memórias Cache
Memórias cache são úteis para reduzir o tempo de acesso à memória principal, melhorando o desempenho do sistema. No projeto do SO, deve-se considerar problemas como **coerência de cache** e **invalidação de dados**, especialmente em sistemas multiprocessados.

## 4. Chamadas ao Sistema e Interrupções
Sim, uma chamada ao sistema pode gerar outras interrupções. Exemplo: uma chamada para leitura de um arquivo pode gerar uma interrupção de I/O, que ao ser atendida, pode gerar uma interrupção de fim de operação para sinalizar a conclusão.

## 5. Características dos SOs Modernos Inspiradas em Mainframes
- **Multiprogramação**
- **Time-sharing**
- **Gerenciamento avançado de memória**
- **Escalonamento de processos**
- **Segurança e isolamento de processos**

## 6. Multiprogramação e Utilização do Processador
Falso. A multiprogramação aumenta a utilização do processador, pois permite que, enquanto um processo espera por I/O, outro possa ser executado, reduzindo o tempo ocioso da CPU.

## 7. Justificativa para o Escalonamento de Processos
O escalonamento é necessário para garantir a utilização eficiente do processador, priorizando processos com base em critérios como tempo de execução, prioridade e tipo (I/O bound ou CPU bound).

## 8. Diferença entre SO Monotarefa e Multitarefa
- **Monotarefa**: Executa um único processo por vez, sem alternância.
- **Multitarefa**: Permite a execução concorrente de múltiplos processos, usando escalonamento e compartilhamento do tempo de CPU.

## 9. Caracterização de Processo e Bloco Descritor
Um **processo** é um programa em execução, contendo código, dados, pilha e registradores. O **PCB (Process Control Block)** armazena informações como estado, registradores, prioridade, e ponteiros para memória.

## 10. Estados de um Processo e Transições
- **Novo** → **Pronto** (alocado na fila de prontos)
- **Pronto** → **Executando** (escalonado pela CPU)
- **Executando** → **Espera** (requisição de I/O)
- **Executando** → **Pronto** (interrupção por tempo de CPU)
- **Espera** → **Pronto** (I/O concluído)
- **Executando** → **Finalizado** (término do processo)

Os processos são mantidos em filas distintas conforme seu estado.

## 11. Escalonamento de Processos I/O Bound e CPU Bound
O SO deve equilibrar processos **I/O bound** (que esperam por operações de entrada/saída) e **CPU bound** (que usam muito a CPU) usando estratégias como **Round-Robin** e **Escalonamento por Prioridade**, evitando que processos CPU bound monopolizem a CPU.

## 12. Scheduler e seus Tipos
O **scheduler** é responsável por gerenciar o uso da CPU. Tipos:
- **Escalonador de longo prazo**: Seleciona quais processos entram na fila de prontos.
- **Escalonador de médio prazo**: Remove processos da memória e os traz de volta conforme necessário (swapping).
- **Escalonador de curto prazo**: Escolhe qual processo será executado pela CPU.

## 13. Sistemas Fortemente e Fracamente Acoplados
- **Fortemente Acoplados**: Compartilham memória e um único sistema operacional, comuns em multiprocessadores.
- **Fracamente Acoplados**: Sistemas independentes conectados via rede, como em clusters distribuídos.
