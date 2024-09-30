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

--09 EX

--10 EX

--11 EX

--12 EX

--13 EX

--14 EX

--15 EX

--16 EX

--17 EX
