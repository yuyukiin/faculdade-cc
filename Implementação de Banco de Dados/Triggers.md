# Teste AFTER INSERT

```sql
CREATE TRIGGER trg_teste
ON FUNCIONARIO
AFTER INSERT
AS
BEGIN
    PRINT 'Olá Mundo';
END

INSERT INTO FUNCIONARIO (Pnome, Minicial, Unome, Cpf, Endereco, Salario)
VALUES ('Jorge', 'E', 'Brito', '88866555575', 'Rua do Horto, 35, São Paulo, SP', 55000);

CREATE TRIGGER trg_repitido
ON FUNCIONARIO
INSTEAD OF INSERT
AS
BEGIN
    PRINT 'Olá de novo! Não inserir registro';
END

INSERT INTO FUNCIONARIO (Pnome, Minicial, Unome, Cpf, Endereco, Salario)
VALUES ('Jorge', 'E', 'Brito', '88866555575', 'Rua do Horto, 35, São Paulo, SP', 55000);

-- Comandos para alteração do trigger
-- DISABLE TRIGGER nome_trigger
-- ENABLE TRIGGER nome_trigger
EXEC sp_helptrigger @tabname = 'FUNCIONARIO';
SELECT * FROM sys.triggers WHERE is_disabled = 0 OR is_disabled = 1;

ALTER TRIGGER trg_after_autores
ON FUNCIONARIO
FOR INSERT, UPDATE
AS
BEGIN
    DECLARE @NomeAntigo VARCHAR(50),
            @NomeNovo VARCHAR(50);
    
    IF UPDATE (Pnome)
    BEGIN
        SELECT @NomeNovo = I.Pnome 
        FROM inserted AS I; -- 'inserted' pega o nome atual
        SELECT @NomeAntigo = D.Pnome 
        FROM deleted AS D; -- 'deleted' pega o último nome

        PRINT 'O nome foi alterado';
        PRINT 'Antigo: ' + @NomeAntigo;
        PRINT 'Novo: ' + @NomeNovo;
    END
    ELSE
    BEGIN
        PRINT 'Nome não foi modificado';
    END
END

INSERT INTO FUNCIONARIO (Pnome, Minicial, Unome, Cpf, Endereco, Salario)
VALUES ('yuRA', 'E', 'BriAAto', '83866555575', 'Rua do Horto, 35, São Paulo, SP', 55000);

UPDATE FUNCIONARIO
SET Pnome = 'yurAAS'
WHERE Cpf = '83866555575';

SELECT * FROM FUNCIONARIO;


---

# Script SQL para a Empresa

```sql
USE EMPRESA;

-- Trigger para log de inserções em FUNCIONARIO
ALTER TRIGGER trg_funcio
ON FUNCIONARIO
AFTER INSERT
AS
BEGIN
    INSERT INTO log_funcionario (Cpf, Operacao)
    SELECT Cpf, 'INSERT'
    FROM inserted;
END;

-- Selecionar todos os registros do log
SELECT * FROM log_funcionario;

-- Inserir um novo funcionário
INSERT INTO FUNCIONARIO (Pnome, Minicial, Unome, Cpf, Endereco, Salario)
VALUES ('yuyuyaaaYUUUUu', 'E', 'BriAAto', '81862155570', 'Rua do Horto, 35, São Paulo, SP', 55000);

-- Trigger para verificar duplicidade antes da inserção
ALTER TRIGGER trg_inserir
ON FUNCIONARIO 
INSTEAD OF INSERT 
AS
BEGIN
    DECLARE @nome VARCHAR(50),
            @minicial VARCHAR(50),
            @sobrenome VARCHAR(50);

    SELECT @minicial = i.Minical, 
           @sobrenome = i.Unome, 
           @nome = i.Pnome 
    FROM inserted i;

    IF EXISTS (
        SELECT 1 FROM FUNCIONARIO AS F
        WHERE Pnome = @nome AND Unome = @sobrenome AND Minicial = @minicial
    )
    BEGIN
        PRINT 'Não inserido';
        ROLLBACK TRANSACTION;
    END
    ELSE
    BEGIN
        PRINT 'Inserido';
        INSERT INTO FUNCIONARIO (Pnome, Minicial, Unome, Cpf)
        SELECT Pnome, Minicial, Unome, Cpf
        FROM inserted;
        COMMIT TRANSACTION;
    END
END;

-- Inserir um novo funcionário
INSERT INTO FUNCIONARIO (Pnome, Minicial, Unome, Cpf)
VALUES ('yuyuyaaaYUUUUu', 'E', 'BriAAto', '81862155574');

---


CREATE TRIGGER trg_salll
ON FUNCIONARIO
INSTEAD OF INSERT
AS
BEGIN
	DECLARE @cpf CHAR(8),
			@salario DECIMAL (10,2)

	SELECT @cpf = i.cpf, @salario = i.salario FROM inserted AS I

	IF @salario >= 50000.00
	BEGIN
		INSERT INTO FUNCIONARIO (Pnome, Minicial, Unome, Cpf, Datanasc, Endereco, Sexo, Salario, Cpf_supervisor, Dnr)
        SELECT Pnome, Minicial, Unome, Cpf, Datanasc, Endereco, Sexo, Salario, Cpf_supervisor, Dnr FROM inserted;
		PRINT 'Funcionario inserido com sucesso'
	END
	ELSE 
		BEGIN
		RAISERROR('Salário inválido. Não foi possível inserir o funcionário.', 16, 1);
		END
END
