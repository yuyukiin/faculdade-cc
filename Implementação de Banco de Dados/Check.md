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


## Utilizando Cascade

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



--CASCADE

CREATE TABLE Pais
(
	id INT PRIMARY KEY,
	nome_pais VARCHAR(50),
	cod_pais VARCHAR(3)
)

CREATE TABLE Estado
(
	id INT PRIMARY KEY,
	nome VARCHAR(50),
	cod VARCHAR (3),
	id_pais INT
)

ALTER TABLE Estado 
	ADD CONSTRAINT fk_estado_pais
	FOREIGN KEY (id_pais) REFERENCES Pais(id)
	ON DELETE CASCADE



--Inserindo informações no banco nas tabelas criadas acima
INSERT INTO [dbo].[Pais] VALUES (1,'Estados Unidos','EUA');
INSERT INTO [dbo].[Pais] VALUES (2,'Brasil','BR');
INSERT INTO [dbo].[Pais] VALUES (3,'Canada','CA');

INSERT INTO [dbo].[Estado] VALUES (1,'Califórnia','CA', 1);
INSERT INTO [dbo].[Estado] VALUES (2,'Alasca','AK', 1);
INSERT INTO [dbo].[Estado] VALUES (3,'Florida','FL', 1);
INSERT INTO [dbo].[Estado] VALUES (4,'Arizona','AZ', 1);

INSERT INTO [dbo].[Estado] VALUES (5,'Rio Grande do Sul','RS', 2);
INSERT INTO [dbo].[Estado] VALUES (6,'Acre','AC', 2);
INSERT INTO [dbo].[Estado] VALUES (7,'São Paulo','SP', 2);
INSERT INTO [dbo].[Estado] VALUES (8,'Sergipe','SE', 2);

INSERT INTO [dbo].[Estado] VALUES (9,'Ontario','ON', 3);
INSERT INTO [dbo].[Estado] VALUES (10,'Quebec','QC', 3);
INSERT INTO [dbo].[Estado] VALUES (11,'Toronto','TR', 3);
INSERT INTO [dbo].[Estado] VALUES (12,'Nova Escócia','NS', 3);

SELECT * FROM Estado
SELECT * FROM Pais
SELECT P.nome_pais, P.cod_pais, E.cod, E.nome FROM Pais AS P
JOIN Estado AS E ON E.id_pais = P.id
ORDER BY P.nome_pais;

DELETE FROM Pais WHERE nome_pais = 'Brasil'


--Outra forma de criação de restrições CONSTRAINT
CREATE TABLE tbl_produtos
(	
	id_produto INT PRIMARY KEY,
	nome_produto VARCHAR(50),
	categoria VARCHAR(25)
);
CREATE TABLE tbl_inventario
(
	id_inventario INT PRIMARY KEY,
	fk_id_produto INT,
	quantidade INT,
	min_level INT,
	max_level INT,
	CONSTRAINT fk_inv_produto
		FOREIGN KEY (fk_id_produto)
		REFERENCES tbl_produtos (id_produto)
		ON DELETE CASCADE
);

--Inserindo registroro nas tabelas acima (Distribuidora de bebidas)
INSERT INTO  [dbo].[tbl_produtos] VALUES (1, 'Refrigerante','Bebidas');
INSERT INTO  [dbo].[tbl_produtos] VALUES (2, 'Cerveja','Bebidas');
INSERT INTO  [dbo].[tbl_produtos] VALUES (3, 'Tequila','Bebidas');
INSERT INTO  [dbo].[tbl_produtos] VALUES (4, 'Energético','Bebidas');

INSERT INTO [dbo].[tbl_inventario] VALUES (1,1,500,10,1000);
INSERT INTO [dbo].[tbl_inventario] VALUES (2,4,50,5,50);
INSERT INTO [dbo].[tbl_inventario] VALUES (3,2,1000,5,5000);
INSERT INTO [dbo].[tbl_inventario] VALUES (4,3,5,5,15);

SELECT * FROM tbl_inventario

SELECT * FROM tbl_produtos


SELECT P.nome_produto, P.categoria, I.quantidade, I.min_level, I.max_level
FROM tbl_produtos AS P
JOIN tbl_inventario AS I
ON I.fk_id_produto = P.id_produto
ORDER BY P.nome_produto;

DELETE FROM tbl_produtos WHERE id_produto = 1

ALTER TABLE tbl_inventario DROP CONSTRAINT fk_inv_produto

UPDATE tbl_produtos 
SET id_produto = 99
WHERE id_produto = 3

ALTER TABLE tbl_inventario WITH CHECK ADD CONSTRAINT fk_inv_produto
FOREIGN KEY (fk_id_produto)
REFERENCES tbl_produtos(id_produto)
ON UPDATE CASCADE
ON DELETE SET NULL


ON DELETE DEFAUT;
```
