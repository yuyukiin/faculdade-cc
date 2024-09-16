--Utilizando o banco FUNCIONARIO

--cRIE UM PRO
CREATE PROCEDURE ListarFuncionarioDepartamento
	@Departamento INT = NULL
AS
BEGIN
	IF @Departamento IS NULL
		SELECT * FROM FUNCIONARIO;
	ELSE
		SELECT * FROM FUNCIONARIO WHERE Dnr = @Departamento;
END

EXEC ListarFuncionarioDepartamento
	@departamento = 1


-- Listar funcionas entre o saldo
ALTER PROCEDURE ListagemSalario
	@salario1 decimal (10,2),
	@salario2 decimal(10,2)
AS
BEGIN
	SELECT *
	FROM FUNCIONARIO 
	WHERE Salario BETWEEN @salario1 AND @salario2
END;

EXEC ListagemSalario
	@salario1 = 25000,
	@salario2 = 35000

--Verifica e enserir funcinario
CREATE PROCEDURE VerificarEInserirFuncionario
	@Pnome VARCHAR(45),
	@Minicipal CHAR(1),
	@Unome VARCHAR(45),
	@Cpf CHAR(11)
AS
BEGIN
	IF EXISTS (SELECT 1 FROM FUNCIONARIO AS F WHERE @Pnome = F.Pnome AND @Minicipal = F.Minicial AND @Unome = F.Unome)
	BEGIN
		PRINT 'Nome igual';
		RETURN
	END
	INSERT INTO FUNCIONARIO(Pnome, Minicial, Unome, Cpf)
	VALUES (@Pnome, @Minicipal, @Unome, @Cpf);
	PRINT 'Funcionario inserido com sucesso'
END;	

EXEC VerificarEInserirFuncionario 'Juca', 'S', 'Da Silveira', '0000000002'
