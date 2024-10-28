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
