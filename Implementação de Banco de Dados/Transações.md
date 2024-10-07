# Transações

Uma transação é uma sequência de operações realizadas em um banco de dados que deve ser tratada como uma única unidade lógica. Essas operações podem incluir inserções, atualizações ou exclusões de dados. As transações seguem os princípios ACID para garantir a integridade e a confiabilidade dos dados.

### Principais Comandos Relacionados a Transações

- **BEGIN TRANSACTION**: Inicia uma nova transação.
- **COMMIT TRANSACTION**: Confirma a transação, aplicando permanentemente todas as operações feitas no banco de dados.
- **ROLLBACK TRANSACTION**: Desfaz todas as operações realizadas desde o início da transação.
- **SAVEPOINT**: Define um ponto dentro de uma transação para permitir um rollback parcial, até esse ponto.

Imagine que estamos inserindo dados em duas tabelas, `FUNCIONARIO` e `DEPARTAMENTO`, e queremos garantir que ambas as operações sejam bem-sucedidas. Se a inserção em uma das tabelas falhar, todas as operações precisam ser revertidas.

```sql
BEGIN TRANSACTION;

-- Tentativa de inserir um novo funcionário
INSERT INTO FUNCIONARIO (Pnome, Minicial, Unome, Cpf, Datanasc, Endereco, Sexo, Salario, Cpf_supervisor, Dnr)
VALUES ('João', 'A', 'Silva', '12345678901', '1990-01-01', 'Rua das Flores, 123', 'M', 5000, NULL, 1);

-- Tentativa de inserir um novo departamento
INSERT INTO DEPARTAMENTO (Dnumero, Dnome, Cpf_gerente, Data_inicio_gerente)
VALUES (3, 'Recursos Humanos', '12345678901', '2023-09-29');

-- Verifica se houve erro em alguma das inserções
IF @@ERROR <> 0 
BEGIN
    ROLLBACK TRANSACTION;
    PRINT 'Erro detectado. Transação revertida.';
END
ELSE
BEGIN
    COMMIT TRANSACTION;
    PRINT 'Transação concluída com sucesso.';
END
```

### Crie uma transação para realizar duas inserções dentro de uma transação. Uma na tabela FUNCIONARIO e outra na tabela DEPARTAMENTO. 
```sql
BEGIN TRANSACTION;
DECLARE @Erro INT;
INSERT INTO FUNCIONARIO (Pnome, Unome, Cpf)
VALUES ('Yuri', 'Alex', '02064068007')
SET @Erro = @@ERROR

INSERT INTO DEPARTAMENTO (Dnome, Dnumero)
VALUES ('Firma', '22')
SET @Erro = @Erro + @@ERROR


SELECT * FROM FUNCIONARIO;

IF @Erro <> 0
	BEGIN
	ROLLBACK TRANSACTION;
	PRINT 'Erro, Transação revertida.';
	END
ELSE
	BEGIN
	COMMIT TRANSACTION;
	PRINT 'Transação concluída com sucesso.';
	END
```

### Implementar uma transação... Usar tabela produtos para registrar no estoque
```sql
UPDATE PRODUTO SET Quantidade = 10

INSERT INTO PRODUTO (Id, Nome, Preco, Quantidade)
VALUES ('1', 'Notebook', '25', '5');
DECLARE @Quantidade INT;
SELECT @Quantidade = Quantidade FROM PRODUTO WHERE Id = '1';

IF @Quantidade > 0
BEGIN
    UPDATE PRODUTO SET Quantidade = Quantidade - 1 WHERE Id = '1';
    
    COMMIT TRANSACTION;
    PRINT 'Transação concluída com sucesso. Quantidade restante: ' + CAST(@Quantidade - 1 AS VARCHAR);
END
ELSE
BEGIN
    ROLLBACK TRANSACTION;
    PRINT 'Erro: Produto fora de estoque. Transação revertida.';
END
```

### Princípios ACID

- **Atomicidade**: Garante que todas as operações de uma transação sejam completadas; se uma falha ocorrer, nenhuma mudança é aplicada.

- **Consistência**: Assegura que uma transação leve o banco de dados de um estado válido a outro, respeitando todas as regras de integridade, como chaves primárias e integridade referencial.

- **Isolamento**: Assegura que transações concorrentes não interfiram umas nas outras, mantendo a integridade dos dados.

- **Durabilidade**: Garante que, uma vez confirmada, a transação permanece registrada, mesmo em caso de falhas.
