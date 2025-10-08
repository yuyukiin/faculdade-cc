# Relatório de Sistemas Digitais: ADC, DAC, PWM e Filtro RC

## Objetivo

Compreender os conceitos fundamentais de Conversor Analógico-Digital (ADC), Conversor Digital-Analógico (DAC), Modulação por Largura de Pulso (PWM) e Filtro RC, reconhecendo como se relacionam em sistemas do mundo real.

---

### 1. Conceitos-base

O **Conversor Analógico-Digital (ADC)** é um dispositivo eletrônico que converte um sinal analógico, como uma tensão elétrica, em uma representação digital. Essa conversão é fundamental porque os sistemas digitais, como microcontroladores, processam informações em formato digital. Portanto, para que um computador possa interpretar dados do mundo real, que são inerentemente analógicos, é necessário primeiro convertê-los. Exemplos práticos incluem a digitalização da voz captada por um microfone, permitindo sua gravação e processamento, ou a leitura de um sensor de temperatura, cujo valor de tensão analógico é convertido para um número que o sistema pode entender e exibir.

Por outro lado, o **Conversor Digital-Analógico (DAC)** realiza a função inversa: ele transforma uma grandeza digital, como um código binário, em uma grandeza analógica, geralmente uma tensão ou corrente. O DAC é essencial quando um sistema digital precisa interagir com o mundo analógico. Por exemplo, para um alto-falante produzir som a partir de um arquivo de áudio digital, os dados digitais precisam ser convertidos em um sinal elétrico analógico que possa movimentar o cone do alto-falante. Outras aplicações incluem o controle do brilho de um LED ou a variação da velocidade de um motor, onde um valor digital controla uma tensão analógica para modular a intensidade ou a potência.

### 2. PWM (Pulse Width Modulation)

A **Modulação por Largura de Pulso (PWM)** é uma técnica que permite obter resultados analógicos por meios digitais. A ideia central é a criação de uma onda quadrada, um sinal digital que alterna rapidamente entre um nível alto (ligado) e um nível baixo (desligado). A fração de tempo em que o sinal permanece em nível alto dentro de um ciclo completo é chamada de *duty cycle*. Ao variar essa largura do pulso, ou seja, o *duty cycle*, é possível controlar o valor médio da tensão do sinal. Se o pulso fica em nível alto por 50% do tempo, a tensão média na saída será metade da tensão máxima do pulso.

Aplicações comuns incluem o controle de brilho de LEDs, a regulação da velocidade de motores e a geração de tons simples em áudio. O PWM atua como uma "ponte" eficaz para a conversão digital-analógica, pois, em muitas situações, pode substituir um DAC quando combinado com um filtro em sua saída.

### 3. Filtro RC (Resistor + Capacitor) aplicado ao PWM

Um **filtro RC**, composto por um resistor (R) e um capacitor (C), é utilizado para transformar o sinal pulsado de um PWM em uma tensão analógica mais estável. A intuição por trás de seu funcionamento é que o resistor limita a corrente que flui para o capacitor, enquanto o capacitor age como um pequeno reservatório de carga, armazenando energia quando o pulso PWM está em nível alto e liberando-a lentamente quando o pulso vai para o nível baixo.

Esse processo de carga e descarga **suaviza os pulsos rápidos**, atenuando as altas frequências e permitindo a passagem das baixas frequências. O resultado é a redução da **ondulação (*ripple*)**, que é a variação residual na tensão de saída. Frequências de PWM mais altas facilitam a obtenção de um resultado mais "liso" ou com menor *ripple*, pois o capacitor tem menos tempo para descarregar entre os pulsos, mantendo a tensão de saída mais constante. Esse princípio é amplamente utilizado em microcontroladores como o Arduino para gerar uma tensão média e controlar a potência de atuadores.

### 4. Integração dos Conceitos

A integração desses conceitos pode ser visualizada em um fluxo de sistema completo: um sensor captura uma informação analógica do ambiente e a envia para um **ADC**. O ADC converte esse sinal contínuo em dados digitais que podem ser lidos por um microcontrolador. Após o processamento digital, o sistema precisa atuar no mundo analógico.

Nesse ponto, entra o **DAC** ou a combinação **PWM + RC**. O microcontrolador gera um sinal PWM com um *duty cycle* correspondente à ação desejada. Esse sinal passa por um filtro RC, que o converte em uma tensão analógica estável. Finalmente, essa tensão analógica alimenta o atuador (como um motor ou LED), controlando sua operação. Nessa cadeia, o ADC funciona como a porta de entrada dos dados do mundo analógico para o sistema digital, enquanto o DAC, ou o PWM com um filtro RC, atua como a porta de saída, traduzindo as decisões digitais em ações analógicas.
