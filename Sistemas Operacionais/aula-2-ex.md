# Caracterização de um Sistema de Computação

## 1. Caracterize um sistema de computação moderno
Consiste em um grupo de dispotivios eletrônicos com finalidades especificas que realizam processos de informações.

## 2. Quais as etapas de inicialização do computador?
1. POST (Power-On Self Test)
Assim que o botão de ligar é pressionado, o computador realiza o POST, que é um teste automático de diagnóstico. O POST verifica se todos os componentes do hardware estão funcionando corretamente. Ele verifica a memória RAM, o processador, os dispositivos de armazenamento, entre outros. Caso algum problema seja detectado, o computador emitirá um código de erro ou uma mensagem indicando o problema.

2. BIOS (Basic Input/Output System)
Após o POST, o computador passa para a próxima etapa, que é a inicialização da BIOS. A BIOS é um software de baixo nível que está presente em todos os computadores. Ela é responsável por configurar e controlar o hardware do sistema. Durante a inicialização, a BIOS verifica os dispositivos de armazenamento em busca do sistema operacional e carrega as informações necessárias para o próximo passo.

3. MBR (Master Boot Record)
O MBR é uma pequena porção de dados localizada no primeiro setor do disco rígido. Ele contém as informações necessárias para o sistema operacional ser carregado. O MBR contém o código de inicialização do sistema operacional, conhecido como bootloader. Quando o computador encontra o MBR, ele carrega o bootloader na memória RAM e transfere o controle para ele.

4. Bootloader
O bootloader é um programa responsável por carregar o sistema operacional na memória RAM. Ele é capaz de localizar o sistema operacional no disco rígido e iniciar o processo de carregamento. O bootloader também permite que o usuário escolha qual sistema operacional deseja iniciar, caso haja mais de um instalado no computador.

5. Kernel
Após o bootloader carregar o sistema operacional na memória RAM, o controle é transferido para o kernel. O kernel é a parte central do sistema operacional e é responsável por gerenciar os recursos do computador, como a memória, os dispositivos de entrada e saída, entre outros. Ele é o responsável por iniciar os processos e permitir que o usuário utilize o sistema operacional.

6. Inicialização do Sistema Operacional
Após o kernel assumir o controle, o sistema operacional inicia sua inicialização. Nesse momento, são carregados os drivers dos dispositivos, os serviços de rede, os aplicativos em segundo plano e todas as demais configurações necessárias para o funcionamento do sistema operacional. O tempo de inicialização pode variar de acordo com a quantidade de programas e serviços que estão configurados para iniciar automaticamente.

## 3. O que é interrupção? Como os Sistemas Operacionais tratam as interrupções?
Uma interrupção é quando retira temporariamente um processo para deixar outro entrar em execucação. 

## 4. Defina I/O síncrona e I/O assíncrona. Qual permite melhor uso da CPU?
- I/O Síncrona: O processo espera a operação de I/O terminar antes de continuar. A CPU pode ficar ociosa enquanto espera.

- I/O Assíncrona: O processo não espera a operação de I/O terminar e pode continuar executando outras tarefas. A CPU é melhor aproveitada.

Qual permite melhor uso da CPU?
A I/O assíncrona permite melhor uso da CPU, pois a CPU não fica esperando pela operação de I/O.

## 5. Qual a finalidade da DMA – Direct Memory Access?
Permite que outros componentes possam acessar a memória RAM diretamente.

## 6. Como funciona a RAM? Qual o ciclo básico de execução de uma instrução?
A RAM permite que o computador execute diversas tarefas ao mesmo tempo. O processo de instrução é dividido em 2 ciclos, 1) cliclo de busca, a instrução é lida da memória. 2)clico de execução: uma vez lida da memória, a instrução é executada.

## 7. Caracterize a estrutura de armazenamento de um sistema de computação.
Volatilidade · Mutabilidade · Acessibilidade · Endereçabilidade · Capacidade · Desempenho · Uso de energia · Segurança.

## 8. Em que consiste o uso de cache?
Um cache é uma camada de armazenamento físico de dados.

## 9. Caracterize os diferentes tipos de proteção de hardware suportados em um sistema de computação.
1. Firewalls. ...
2. Segurança de e-mails. ...
3. Software antivírus e antimalware. ...
4. Segmentação de rede. ...
5. Controle de acesso. ...
6. Segurança de aplicações. ...
7. Análise do comportamento. ...
8. Prevenção contra perda de dados.

