## Utilizando Check

```sql
CREATE DATABASE AULA10;
USE AULA10;

CREATE TABLE tbl_pessoa
(
	id INT PRIMARY KEY IDENTITY (100,10),
	nome_pessoa VARCHAR(50),
	nome_pet VARCHAR(50),
	num_pet INT CHECK(num_pet > 0),
	idade INT CHECK(idade BETWEEN 18 AND 95),
	sexo_pet CHAR CHECK (sexo_pet IN ('M','F','N'))
)

INSERT INTO tbl_pessoa VALUES ('Yuri', 'Loki', 2, 22, 'M')

SELECT * FROM tbl_pessoa

INSERT INTO tbl_pessoa VALUES ('Juras', 'gargamel', 1, 30, 'M')

```

## Utilizando View

```sql
ALTER VIEW View1 AS 
SELECT L.isbn, L.titulo, L.ano, E.nome, CONCAT(A.nome, A.nacionalidade ) AS 'Nome/Nacionalidade', C.tipo_categoria
FROM Livro AS L 
JOIN Editora AS E ON l.fk_editora = E.id
JOIN Categoria AS C ON l.fk_editora = c.id
JOIN LivroAutor AS LA ON L.isbn = LA.fk_livro
JOIN Autor AS A ON LA.fk_autor = A.id


SELECT * FROM View1 WHERE nome LIKE '%da%'
--%

```
