# Caracterização de um Sistema de Computação

## 1. Caracterize um sistema de computação moderno

Um sistema de computação moderno é composto por um conjunto de dispositivos eletrônicos interconectados, com finalidades específicas, que realizam processos de informação. Esses sistemas são compostos por hardware (dispositivos físicos) e software (programas e sistemas operacionais), permitindo a execução de tarefas complexas.

## 2. Quais as etapas de inicialização do computador?

### POST (Power-On Self Test)

Assim que o botão de ligar é pressionado, o computador realiza o POST, um teste automático de diagnóstico. O POST verifica se todos os componentes de hardware estão funcionando corretamente, como a memória RAM, o processador, os dispositivos de armazenamento, entre outros. Caso algum problema seja detectado, o computador emitirá um código de erro ou uma mensagem indicando o problema.

### BIOS (Basic Input/Output System)

Após o POST, o computador inicia a BIOS, um software de baixo nível presente em todos os computadores. Ela é responsável por configurar e controlar o hardware do sistema. Durante a inicialização, a BIOS verifica os dispositivos de armazenamento em busca do sistema operacional e carrega as informações necessárias para o próximo passo.

### MBR (Master Boot Record)

O MBR é uma pequena porção de dados localizada no primeiro setor do disco rígido. Ele contém as informações necessárias para o sistema operacional ser carregado. O MBR contém o código de inicialização do sistema operacional, conhecido como bootloader. Quando o computador encontra o MBR, ele carrega o bootloader na memória RAM e transfere o controle para ele.

### Bootloader

O bootloader é um programa responsável por carregar o sistema operacional na memória RAM. Ele localiza o sistema operacional no disco rígido e inicia o processo de carregamento. O bootloader também permite que o usuário escolha qual sistema operacional deseja iniciar, caso haja mais de um instalado.

### Kernel

Após o bootloader carregar o sistema operacional na memória RAM, o controle é transferido para o kernel. O kernel é a parte central do sistema operacional e é responsável por gerenciar os recursos do computador, como a memória, os dispositivos de entrada e saída, entre outros. Ele também gerencia a execução de processos e permite que o usuário utilize o sistema operacional.

### Inicialização do Sistema Operacional

Após o kernel assumir o controle, o sistema operacional inicia sua inicialização. Nesse momento, são carregados os drivers dos dispositivos, os serviços de rede, os aplicativos em segundo plano e todas as demais configurações necessárias para o funcionamento do sistema. O tempo de inicialização pode variar de acordo com a quantidade de programas e serviços configurados para iniciar automaticamente.

## 3. O que é interrupção? Como os sistemas operacionais tratam as interrupções?

Uma interrupção é um sinal enviado ao processador para interromper temporariamente a execução de um processo, a fim de dar prioridade a outro processo. O sistema operacional trata as interrupções por meio de um mecanismo chamado "controle de interrupções", onde ele interrompe a execução de um processo para executar uma tarefa de maior prioridade (como um dispositivo de entrada ou saída) e, depois, retoma o processo interrompido.

## 4. Defina I/O síncrona e I/O assíncrona. Qual permite melhor uso da CPU?

- **I/O Síncrona:** O processo espera a operação de I/O terminar antes de continuar a execução. A CPU pode ficar ociosa enquanto aguarda o término da operação de I/O.
  
- **I/O Assíncrona:** O processo não espera a operação de I/O terminar e pode continuar executando outras tarefas enquanto a operação de I/O está em andamento. 

**Qual permite melhor uso da CPU?**  
A I/O assíncrona permite melhor aproveitamento da CPU, pois a CPU não fica ociosa enquanto espera a operação de I/O ser concluída.

## 5. Qual a finalidade da DMA – Direct Memory Access?

A DMA permite que dispositivos periféricos (como discos rígidos, placas de rede, etc.) acessem diretamente a memória RAM, sem a intervenção do processador, melhorando a eficiência e o desempenho do sistema.

## 6. Como funciona a RAM? Qual o ciclo básico de execução de uma instrução?

A RAM (memória de acesso aleatório) permite que o computador execute diversas tarefas simultaneamente, armazenando dados temporários e instruções. O ciclo básico de execução de uma instrução é dividido em dois passos:

1. **Ciclo de busca:** A instrução é lida da memória RAM.
2. **Ciclo de execução:** Após ser lida, a instrução é executada pelo processador.

## 7. Caracterize a estrutura de armazenamento de um sistema de computação.

A estrutura de armazenamento de um sistema de computação pode ser caracterizada por diferentes fatores:

- **Volatilidade**: Se os dados são perdidos quando o sistema é desligado.
- **Mutabilidade**: Se os dados podem ser modificados.
- **Acessibilidade**: Facilidade de acesso aos dados.
- **Endereçabilidade**: Capacidade de localizar dados específicos.
- **Capacidade**: Quantidade de dados que podem ser armazenados.
- **Desempenho**: Velocidade de acesso e transferência dos dados.
- **Uso de energia**: Eficiência energética do armazenamento.
- **Segurança**: Proteção contra perda, roubo ou modificação de dados.

## 8. Em que consiste o uso de cache?

O cache é uma memória de acesso rápido que armazena dados frequentemente usados, permitindo que o processador acesse informações rapidamente, sem precisar buscar na memória principal. Isso melhora o desempenho do sistema, reduzindo o tempo de acesso a dados e instruções.

## 9. Caracterize os diferentes tipos de proteção de hardware suportados em um sistema de computação.

Os sistemas de computação utilizam diferentes tipos de proteção de hardware para garantir a segurança e integridade dos dados e recursos do sistema. Entre as proteções incluem-se:

- **Firewalls**: Protegem contra acesso não autorizado à rede.
- **Segurança de e-mails**: Protege os sistemas contra e-mails maliciosos.
- **Software antivírus e antimalware**: Detecta e remove vírus e malwares do sistema.
- **Segmentação de rede**: Divide a rede em segmentos para limitar o acesso entre diferentes partes do sistema.
- **Controle de acesso**: Define quem pode acessar quais recursos do sistema.
- **Segurança de aplicações**: Garante que as aplicações estejam protegidas contra vulnerabilidades.
- **Análise do comportamento**: Monitora o comportamento do sistema em busca de atividades suspeitas.
- **Prevenção contra perda de dados**: Garante que os dados críticos sejam protegidos contra perdas acidentais.

