# Transações

Uma transação é uma sequência de operações realizadas em um banco de dados que deve ser tratada como uma única unidade lógica. Essas operações podem incluir inserções, atualizações ou exclusões de dados. As transações seguem os princípios ACID para garantir a integridade e a confiabilidade dos dados.

### Principais Comandos Relacionados a Transações

- **BEGIN TRANSACTION**: Inicia uma nova transação.
- **COMMIT TRANSACTION**: Confirma a transação, aplicando permanentemente todas as operações feitas no banco de dados.
- **ROLLBACK TRANSACTION**: Desfaz todas as operações realizadas desde o início da transação.
- **SAVEPOINT**: Define um ponto dentro de uma transação para permitir um rollback parcial, até esse ponto.

### Princípios ACID

- **Atomicidade**: Garante que todas as operações de uma transação sejam completadas; se uma falha ocorrer, nenhuma mudança é aplicada.

- **Consistência**: Assegura que uma transação leve o banco de dados de um estado válido a outro, respeitando todas as regras de integridade, como chaves primárias e integridade referencial.

- **Isolamento**: Assegura que transações concorrentes não interfiram umas nas outras, mantendo a integridade dos dados.

- **Durabilidade**: Garante que, uma vez confirmada, a transação permanece registrada, mesmo em caso de falhas.
