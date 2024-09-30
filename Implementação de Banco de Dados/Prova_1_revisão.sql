--08 EX
--EX8 Liste o nome dos alunos e suas respectivas notas na disciplina 'banco de dados'
SELECT A.Nome, D.Nome_disciplina, h.Nota
FROM ALUNO AS A
JOIN HISTORICO_ESCOLAR AS H ON A.Numero_aluno = H.Numero_aluno
JOIN TURMA AS T ON H.Identificacao_turma = T.Identificacao_turma
JOIN DISCIPLINA AS D ON T.Numero_disciplina = D.Numero_disciplina
WHERE D.Nome_disciplina = 'BANCO DE DADOS';

SELECT A.nome, D.Nome_disciplina, H.Nota
FROM ALUNO AS A, HISTORICO_ESCOLAR AS H, TURMA AS T, DISCIPLINA AS D
WHERE A.Numero_aluno = H.Numero_aluno
AND H.Identificacao_turma = T.Identificacao_turma
AND T.Numero_disciplina = D.Numero_disciplina
AND D.Nome_disciplina = 'BANCO DE DADOS';

--EX9 Quais as disciplinas que tem pré requisitos e quais são seus respectivos 
SELECT D.Nome_disciplina AS 'Disciplina', D2.Nome_disciplina AS 'Pre_requisito'
FROM DISCIPLINA AS D
JOIN PRE_REQUISITO AS P ON D.Numero_disciplina = P.Numero_disciplina
JOIN DISCIPLINA AS D2 ON P.Numero_pre_requisito = D2.Numero_disciplina;

--EX10 Liste todas as disciplinas cursadas pelo aluno 'Silva', disciplina, semestre, ano e nota final
SELECT A.Nome, T.Semestre, D.Nome_disciplina, T.Ano, H.Nota
FROM ALUNO AS A
JOIN HISTORICO_ESCOLAR AS H ON A.Numero_aluno = H.Numero_aluno
JOIN TURMA AS T ON H.Identificacao_turma = T.Identificacao_turma
JOIN DISCIPLINA AS D ON T.Numero_disciplina = D.Numero_disciplina 
WHERE A.Nome = 'Silva';

--EX11 Liste o nome dos alunos e suas datas de nascimento, mas fomate sa dastas no estilo DD/MM/YYYY
SELECT A.Nome, CONVERT(VARCHAR, A.Data_Nascimento, 103) AS Data
FROM ALUNO AS A

--EX12 Liste o nome dos alunos e notas no formato numérico
SELECT A.Nome, CASE H.Nota 
					WHEN 'A' THEN '10'
					WHEN 'B' THEN '9'
					WHEN 'C' THEN '8'
					WHEN 'D' THEN '0'
					ELSE NULL
				END AS 'Nota'
FROM ALUNO AS A
JOIN HISTORICO_ESCOLAR AS H ON A.Numero_aluno = H.Numero_aluno

--EX9 Quais as disciplinas que tem pré requisitos e quais são seus respectivos 
SELECT D.Nome_disciplina AS 'Disciplina', D2.Nome_disciplina AS 'Pre_requisito'
FROM DISCIPLINA AS D
JOIN PRE_REQUISITO AS P ON D.Numero_disciplina = P.Numero_disciplina
JOIN DISCIPLINA AS D2 ON P.Numero_pre_requisito = D2.Numero_disciplina;

--EX10 Liste todas as disciplinas cursadas pelo aluno 'Silva', disciplina, semestre, ano e nota final
SELECT A.Nome, T.Semestre, D.Nome_disciplina, T.Ano, H.Nota
FROM ALUNO AS A
JOIN HISTORICO_ESCOLAR AS H ON A.Numero_aluno = H.Numero_aluno
JOIN TURMA AS T ON H.Identificacao_turma = T.Identificacao_turma
JOIN DISCIPLINA AS D ON T.Numero_disciplina = D.Numero_disciplina 
WHERE A.Nome = 'Silva';

--EX11 Liste o nome dos alunos e suas datas de nascimento, mas fomate sa dastas no estilo DD/MM/YYYY
SELECT A.Nome, CONVERT(VARCHAR, A.Data_Nascimento, 103) AS Data
FROM ALUNO AS A

--EX12 Liste o nome dos alunos e notas no formato numérico
SELECT A.Nome, CASE H.Nota 
					WHEN 'A' THEN '10'
					WHEN 'B' THEN '9'
					WHEN 'C' THEN '8'
					WHEN 'D' THEN '0'
					ELSE NULL
				END AS 'Nota'
FROM ALUNO AS A
JOIN HISTORICO_ESCOLAR AS H ON A.Numero_aluno = H.Numero_aluno

--EX13 Consulta, NOTA = A E B = Aprovado, C = Recuperação e D = Reprovado
SELECT A.Nome, D.Nome_disciplina, CASE H.Nota 
					WHEN 'A' THEN 'APROVADO'
					WHEN 'B' THEN 'APROVADO'
					WHEN 'C' THEN 'RECUPERAÇÃO'
					WHEN 'D' THEN 'REPROVADO'
					ELSE NULL
				END AS 'Status'
FROM ALUNO AS A
JOIN HISTORICO_ESCOLAR AS H ON A.Numero_aluno = H.Numero_aluno
JOIN TURMA AS T ON T.Identificacao_turma = H.Identificacao_turma
JOIN DISCIPLINA AS D ON D.Numero_disciplina = T.Numero_disciplina
WHERE A.Nome = 'Silva'

DECLARE @nomeAluno VARCHAR(50) = 'Silva',
		@turma INT = 112,
		@nota VARCHAR(20),
		@resultado VARCHAR(50)

SET @nota = (SELECT A.Nome
			FROM ALUNO AS A
			JOIN HISTORICO_ESCOLAR AS H ON A.Numero_aluno = H.Numero_aluno
			JOIN TURMA AS T ON T.Identificacao_turma = H.Identificacao_turma
			WHERE A.Nome = 'Silva' AND T.Identificacao_turma = 112)
IF (@nota = 'A' OR @nota = 'B')
	PRINT ('Aprovado')
ELSE IF @nota = 'C'	
	PRINT ('Recuperação')
ELSE IF @nota = 'D'
	PRINT ('Reprovado')


--EX14 Consulta para verificar o status de uma turma com base no NR de alunos
SELECT * FROM TURMA AS T;
DECLARE @Identificação_turma INT = 135,
		@Quantidade_alunos INT;

SELECT @Quantidade_alunos = COUNT(H.Numero_aluno)
FROM HISTORICO_ESCOLAR AS H
WHERE H.Identificacao_turma = @Identificação_turma;
PRINT CAST(@Quantidade_alunos AS VARCHAR)

IF @Quantidade_alunos < 3 
	PRINT 'Há vagas'
ELSE IF @Quantidade_alunos BETWEEN 3 AND 4
	PRINT 'Quase cheia'
ELSE
	PRINT 'Lotada'

--EX15 Procedure para inserir aluno
CREATE PROCEDURE InserirAluno
	@nome VARCHAR(50),
	@numero INT,
	@tipoAluno INT,
	@curso VARCHAR(50),
	@dataNascimento DATE
AS

BEGIN
	IF EXISTS (SELECT 1 FROM ALUNO WHERE Nome = @Nome)
		PRINT 'Já existe um aluno com este nome'
	ELSE 
		BEGIN
		INSERT INTO ALUNO (Nome, Numero_aluno, Tipo_aluno, Curso, Data_Nascimento)
		VALUES (@nome, @numero, @tipoAluno, @curso, @dataNascimento)
		PRINT 'Aluno inserido com sucesso'
		END
END

EXEC InserirAluno 'JUUuquinha', 22, 1, 'CC', '1998-10-05';

SELECT * FROM ALUNO


--EX16 Atualizar Nota
ALTER PROCEDURE AtualizarNota
	@numeroAluno INT,
	@identificacaoTurma INT,
	@novaNota VARCHAR(1)
AS

BEGIN
	IF EXISTS (SELECT 1 FROM HISTORICO_ESCOLAR WHERE Numero_aluno = @numeroAluno 
												AND Identificacao_turma = @identificacaoTurma)
	BEGIN
		UPDATE HISTORICO_ESCOLAR
		SET Nota = @novaNota 
		WHERE Numero_aluno = @numeroAluno 
		AND Identificacao_turma = @identificacaoTurma
		PRINT 'Nota atualizada com sucesso'
		SELECT * FROM HISTORICO_ESCOLAR
	END

	ELSE
		PRINT 'Nota nao atualizada'
END

EXEC AtualizarNota 1, 85, 'F';

--EX17 CalcularIdade

ALTER PROCEDURE CalcularIdade
	@numero_aluno INT

AS
BEGIN
	DECLARE @Data_nascimento DATE,
			@idade INT;

	SELECT @Data_nascimento = Data_Nascimento
	FROM ALUNO AS A
	WHERE Numero_aluno = @numero_aluno;

	SET @idade = DATEDIFF(YEAR, @Data_nascimento, GETDATE());

	IF (MONTH(GETDATE()) < MONTH(@Data_nascimento)) OR 
	(MONTH(GETDATE()) = MONTH(@Data_nascimento) AND
	DAY(GETDATE()) < DAY(@Data_nascimento))

	SET @Idade = @idade -1;

	PRINT 'A idade: ' + CAST(@idade AS VARCHAR(50))
END


EXEC CalcularIdade 6;
