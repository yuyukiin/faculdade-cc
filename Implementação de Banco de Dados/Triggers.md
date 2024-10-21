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
