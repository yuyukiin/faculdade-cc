# Aula 01 - Atividade em Grupo: Sistemas Operacionais

## 1. O que é um Sistema Operacional?

Um Sistema Operacional (SO) é um conjunto de programas que gerencia os recursos de hardware e software de um computador, fornecendo uma interface entre o usuário e o hardware, além de gerenciar processos, memória, dispositivos e arquivos.

## 2. Como acontece a execução dos vários programas "simultaneamente"?

Em sistemas de múltiplos processos, o SO alterna entre os programas de forma rápida (multiprogramação e multitarefa), criando a ilusão de execução simultânea. Em sistemas com múltiplos núcleos, a execução pode ser realmente paralela.

## 3. Há necessidade dos diferentes programas trocarem dados entre si? Como isso acontece?

Sim, a troca de dados é frequentemente necessária. Isso pode ocorrer por meio de **comunicação interprocessos** (IPC), como **pipes**, **sockets**, **mensagens** e **memória compartilhada**, além do uso de **arquivos**.

## 4. Como está organizada a hierarquia de memória em sistemas modernos?

A hierarquia de memória é organizada da seguinte forma:
- **Registradores** (mais rápidos, dentro da CPU)
- **Cache** (L1, L2, L3)
- **RAM** (memória principal)
- **Armazenamento secundário** (HDD, SSD)
- **Memória Virtual** (simula RAM usando o disco)

## 5. Para que é utilizada a Memória Virtual?

A memória virtual expande a capacidade de memória do sistema, permitindo que o SO use espaço no disco rígido como uma extensão da RAM. Isso ajuda a executar programas maiores que a memória física disponível.

## 6. Como acontece o uso de dispositivos de armazenamento e de entrada/saída pelos programas?

Os dispositivos de armazenamento e entrada/saída são gerenciados pelo SO através de **drivers** e **interrupções**. O SO coordena o acesso a esses dispositivos, utilizando chamadas de sistema para os programas interagirem com o hardware.

## 7. Qual a finalidade de um Sistema de Arquivos?

O Sistema de Arquivos organiza e gerencia os dados no armazenamento, fornecendo uma estrutura hierárquica de diretórios e arquivos. Ele facilita o acesso, controle e armazenamento de dados, e também define permissões de acesso.


