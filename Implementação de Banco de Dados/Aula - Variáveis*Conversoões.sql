--Declarando variáveis
DECLARE @valor INT,
		@texto VARCHAR(50),
		@data DATE,
		@nada MONEY
--Setando os valores das variáveis
SET @valor = 50
SET @texto = 'Yu'
SET @data = GETDATE()
SET @nada = 50.50
--Exibir os valores (consulta)
SELECT @valor AS 'Idade', 
	   @texto AS 'Nome', 
	   @data AS 'U. Acesso',
	   @nada AS 'Dinheiro';

USE Biblioteca;

--Declarando variáveis
DECLARE @valor INT,
		@texto VARCHAR(50),
		@data DATE,
		@nada MONEY

--Setando os valores das variáveis
SET @valor = 22
SET @texto = 'Yu'
SET @data = GETDATE()
SET @nada = 50.50

--Exibir os valores (consulta)
SELECT @valor AS 'Idade', 
	   @texto AS 'Nome', 
	   @data AS 'U. Acesso',
	   @nada AS 'Dinheiro';

--Exibir valores utilizando PRINT
PRINT 'O valor da variavel nome é: ' + @texto + CAST(@data AS VARCHAR(15))

--SELECT pra colocar valor em uma variável
DECLARE @nome_Livro VARCHAR(100)

SELECT @Nome_Livro = L.titulo
FROM Livro as L
WHERE isbn = '9788581742458'

SELECT @Nome_Livro AS 'Nome do Livro'

--Calculando a idade de um livro
DECLARE @ano_publicacao INT,
		@ano_atual INT,
		@nome VARCHAR(100);
SET @ano_atual = 2024

-- Atribui os valores
SELECT @ano_publicacao = ano,
       @nome = titulo
FROM Livro 
WHERE isbn = '9788581742458'

--Mostrar informações na tela
SELECT @nome AS 'Nome Livro',
	   @ano_atual - @ano_publicacao AS 'Idade do livro'


CREATE TABLE ALUNO (
	Id INT IDENTITY,
	Nome VARCHAR (50),
	Data_Nasc DATE
);

INSERT INTO ALUNO VALUES ('Yu', '2002-07-14');

SELECT * FROM ALUNO;

--Idade
DECLARE @idade INT;

SELECT @idade = (YEAR(GETDATE()) - YEAR (Data_Nasc))
FROM ALUNO
WHERE id = 1;

PRINT 'Idade: ' + CAST(@Idade AS VARCHAR(10));

--Declaração de tabelas
DECLARE @TabelaAlunos TABLE(
	id INT PRIMARY KEY IDENTITY,
	nome VARCHAR (50),
	tipo_aluno INT,
	curso VARCHAR(2)
);

--Inserir valores na tabela
INSERT INTO @TabelaAlunos
VALUES ('Yu', 1, 'CC'),
	   ('Dudu', 2, 'CC');
--Recuperar os valores
SELECT * FROM @TabelaAlunos;
--CAST
SELECT 'O livro ' + titulo + 
	   ' e do ano: ' + CAST(ano AS VARCHAR(10)) AS 'Informacoes Livro'
FROM LIVRO;
--CONVERT
SELECT 'O livro ' + titulo +
	   ' e do ano: ' + CONVERT(VARCHAR, ano) AS 'Informacoes Livro'
FROM LIVRO;
--CONVERT com estilo
SELECT 'O aluno '
	   + Nome
	   + ' Nasceu em: '
	   + CONVERT (VARCHAR(10), Data_Nasc, 103)
FROM ALUNO;

--Declarando variavel
DECLARE @numero INT, 
		@texto VARCHAR(10)
--Setando os valores
SET @numero = 20
SET @texto = 'Juca'
--Condição IF
IF (@numero >= 18)  
	PRINT 'O Usuario '
	+ @texto	
	+ ', esta liberado para dirigir'
ELSE
	PRINT 'O Usuario '
	+ @texto
	+ ', nao tem idade permitida'

--Condição IF/ELSE com mais de uma declaração
IF @texto = 'Juca'
	BEGIN
		SET @numero = 500
		PRINT @numero 
	END
ELSE
	BEGIN
		SET @numero = -25
		PRINT 'NUMERO INCORRETO: '
		+ CONVERT (VARCHAR(10), @numero)
	END


IF NOT EXISTS (SELECT * FROM sys.databases where name = 'BIBLIOTECA')
	CREATE DATABASE BIBLIOTECA;
ELSE
	PRINT 'O  banco ja existe'

IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'Faculdade')
				and type in (N'U'))
	BEGIN
		CREATE TABLE FACULDADE(
			id INT PRIMARY KEY,
			nome VARCHAR(20),
			total1 float,
			total2 float, 
			total3 float
		);
	END
ELSE
	print('Tabela ja existe');

INSERT INTO FACULDADE VALUES('Yuri', 9, 10, 5),
							('Dudu', 7, 10, 8),
							('Jose', 3, 7, 2),
							('skks', 4, 7, 5),
							('ana', 7, 6, 8),
							('ricardo', 1, 7, 2),
