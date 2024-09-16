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

--teste
CREATE PROCEDURE teste
	@par1 as INT OUTPUT
AS
BEGIN
	SELECT @par1*2
	RETURN
END
DECLARE @valor AS INT = 15;
PRINT CAST(@valor AS VARCHAR(50));

DECLARE @valor

SET @valor = 5

EXEC teste @valor OUTPUT;
PRINT CAST(@valor AS VARCHAR(50));

--Declarer
ALTER PROCEDURE ObterNomeCompletoFunconario
	@Cpf VARCHAR(11),
	@NomeCompleto VARCHAR(255) OUTPUT
AS
BEGIN
	-- Concatenar e star o nome completo
	SELECT @NomeCompleto = F.Pnome + ' ' + F.Minicial + '. ' + F.Unome
	FROM FUNCIONARIO AS F
	WHERE @Cpf = Cpf

	IF @NomeCompleto IS NULL
		SET @NomeCompleto = 'Funcionario nao encontrado'
END

DECLARE @NomeFuncionario VARCHAR(100);
EXEC ObterNomeCompletoFunconario '2123321321', @NomeFuncionario OUTPUT;
PRINT @NomeFuncionario;

--cALCULAR Slario total
CREATE PROCEDURE CalcularValorTotal
	@DepartamentoID INT,
	@SalarioTotal decimal(18,2) OUTPUT

AS 
BEGIN
	--Calcula salario total
	SELECT @SalarioTotal = SUM(Salario) 
	FROM FUNCIONARIO AS F
	WHERE F.Dnr = @DepartamentoID

	--Verifica se depertamento existe

	IF @SalarioTotal IS NULL
	BEGIN
		SET @SalarioTotal = 0;
		PRINT 'Departamento não existe'
	END
END

DECLARE @TotalSalario DECIMAL(18,2)
EXEC CalcularValorTotal 1, @TotalSalario OUTPUT;
PRINT CAST(@TotalSalario AS VARCHAR(100));

--Data Nasc funcionario a aprti de cpf

ALTER PROCEDURE CpfTeste
	@Cpf VARCHAR(11),
	@Idade INT OUTPUT

AS
BEGIN
	SELECT @Idade = DATEDIFF(YEAR, Datanasc, GETDATE())
	FROM FUNCIONARIO AS F
	WHERE F.Cpf = @Cpf

	IF @Cpf IS NULL
	BEGIN
		PRINT 'Funcionario Inexistente'
		RETURN
	END
END

DECLARE @IdadeFim INT
EXEC CpfTeste '88866555576', @IdadeFim OUTPUT;
PRINT ('Idade do funcionario: ' + CAST(@IdadeFim AS VARCHAR(100)));
	

