# Avaliação 

1) No seu github pessoal, criar um repositório de banco de dados (caso ainda não exista) e dentro dele um arquivo chamado vocabulario.md. Nele preencher o significado das expressões abaixo, mantendo o texto ordenado:

	1. sistema gerenciador de banco de dados
	Um Sistema Gerenciador de Banco de Dados (SGBD) é um software que permite a criação, manutenção e o uso de bancos de dados. Ele fornece ferramentas para a definição de estrutura de dados, armazenamento, manipulação e segurança dos dados.

	2. restrições em banco de dados
	Restrições em banco de dados são regras aplicadas às tabelas e colunas para garantir a integridade dos dados. Exemplos de restrições incluem chave primária, chave estrangeira, unicidade, verificação e não nulo.

	3. modelo relacional
	O modelo relacional é um modelo de dados baseado em tabelas (ou relações), onde os dados são organizados em linhas e colunas. Cada tabela representa uma entidade e suas colunas representam atributos da entidade.

	4. modelagem conceitual
	A modelagem conceitual é a fase de design de banco de dados onde um modelo abstrato do que o banco de dados deve conter é criado, normalmente utilizando diagramas ER (Entidade-Relacionamento) para representar entidades e seus relacionamentos.

	5. modelagem lógica
	A modelagem lógica é a transformação do modelo conceitual em um modelo lógico, que inclui tabelas, colunas, chaves primárias e estrangeiras, mas ainda é independente de um SGBD específico.	

	6. modelagem física
	A modelagem física é a fase onde o modelo lógico é implementado em um SGBD específico, levando em consideração detalhes de armazenamento, índices, partições, etc.

	7. linguagem SQL
	SQL (Structured Query Language) é uma linguagem padrão para gerenciamento de bancos de dados relacionais, que permite realizar consultas, inserções, atualizações e exclusões de dados, bem como definir e manipular a estrutura de banco de dados.

	8. Data Definition Language (DDL)
	DDL (Data Definition Language) é um subconjunto da SQL utilizado para definir e gerenciar estruturas de banco de dados, como tabelas, índices e esquemas. Comandos DDL incluem CREATE, ALTER e DROP.

	9. Data Manipulation Language (DML)
	DML (Data Manipulation Language) é um subconjunto da SQL utilizado para manipular dados dentro de estruturas de banco de dados. Comandos DML incluem SELECT, INSERT, UPDATE e DELETE.

	10. Boas práticas em modelagem de banco de dados
	Boas práticas em modelagem de banco de dados envolvem normalização para evitar redundâncias, uso adequado de chaves primárias e estrangeiras, criação de índices para melhorar a performance, documentação clara, e considerações de segurança e backup.
	Simplifcando e sendo direto, fazendo o feijão com arroz.


2) Por meio do MySQL Workbench OU MS Studio Managament faça o seguinte esquema de banco e responda as questões.

create database locadora; 
use locadora;

create table escritorio(
	id_escritorio int primary key not null auto_increment,
    nome varchar(255) default null,
    endereco varchar(255) default null
);

INSERT INTO escritorio (endereco,nome)
VALUES ('Endereco_escritorio1','escritorio1'),
('Endereco_escritorio2','escritorio2'),
('Endereco_escritorio3','escritorio3'),
('Endereco_escritorio4','escritorio4'),
('Endereco_escritorio5','escritorio5'),
('Endereco_escritorio6','escritorio6');

create table cliente(
	id_cliente int primary key not null auto_increment,
	telefone varchar(20) default null,
    endereco varchar(100) default null,
    nome varchar(100) default null,
    uf_cnh varchar(3) default null,
    cnh varchar (30) default null
);

INSERT INTO cliente (telefone,endereco,nome,uf_cnh,cnh)
VALUES (null,'Endereco_cliente1','Juca da Silva','RS','255698563256'),
('55985632589','Endereco_cliente2','Juca da Silva','RS','265698563259'),
('55935632555','Endereco_cliente3','Gabriel Almeida','SC','295698563258'),
('55995632533','Endereco_cliente4','Paulo José','PR','305698563256'),
('55995632522','Endereco_cliente5','Alexandre Zamberlan','SP','315698563257'),
(null,'Endereco_cliente6','Jose','RS','255698563256');

create table tipo_veiculo(
	id_tipo_veiculo int primary key not null auto_increment,
    nome varchar(100) default null
);

INSERT INTO tipo_veiculo (nome)
VALUES ('sedan'),
('hat'),
('caminhonete'),
('caminhao'),
('onibus');

create table veiculo(
	id_veiculo int primary key not null auto_increment,
    id_tipo_veiculo int not null,
	placa varchar(10) default null,
    data_proxima_manutencao date default null,
    foreign key (id_tipo_veiculo) references tipo_veiculo(id_tipo_veiculo)
);

INSERT INTO veiculo (id_tipo_veiculo,placa,data_proxima_manutencao)
VALUES (1,'IXT7853','2024-12-12'),
(1,'IXT7877','2023-12-12'),
(2,'JXT2323','2025-12-12'),
(2,'IXT6987','2024-12-12'),
(3,'IXT6969','2025-9-12'),
(4,'IXT4242','2023-12-12'),
(1,'IXT0003','2023-10-12'),
(1,'IXT7853','2024-12-12');

create table contrato_aluguel(
	id_contrato_aluguel int primary key not null auto_increment,
    id_cliente int not null,
    id_escritorio int not null,
    id_veiculo int not null,
    data_contrato date default null,
    duracao int default null,
    
    foreign key (id_cliente) references cliente(id_cliente),
    foreign key (id_escritorio) references escritorio(id_escritorio),
    foreign key (id_veiculo) references veiculo(id_veiculo)
);

INSERT INTO contrato_aluguel (id_cliente,id_escritorio,id_veiculo,data_contrato,duracao)
VALUES (1,2,1,'2023-06-07',3),
(2,1,3,'2023-06-07',2),
(3,3,2,'2023-06-07',24),
(4,2,4,'2023-06-07',1),
(5,4,7,'2023-06-07',12);

	1. Todos os clientes armazenados no sistema:
	SELECT * FROM cliente;

	2. Exiba os veículos que tenham final 3 no número da placa
	SELECT * FROM veiculo
	WHERE placa LIKE '%3';


	3. Mostre os clientes que residem no RS e que não possuam telefone
	SELECT * FROM cliente
	WHERE uf_cnh = 'RS' AND telefone IS NULL;


	4. Exiba o código dos clientes que alugaram veículos por mais de 90 dias.
	SELECT id_cliente FROM contrato_aluguel
	WHERE duracao > 90;

	5. Quantos veículos há cadastrados no sistema
	SELECT COUNT(*) AS total_veiculos FROM veiculo;

	6. Mostre o veículo alugado por Alexandre Zamberlan.
	SELECT veiculo.* FROM veiculo
	JOIN contrato_aluguel ON veiculo.id_veiculo = contrato_aluguel.id_veiculo
	JOIN cliente ON contrato_aluguel.id_cliente = cliente.id_cliente
	WHERE cliente.nome = 'Alexandre Zamberlan';

	7. Mostre os clientes e os escritórios associados no contrato de aluguel.
	SELECT cliente.nome AS nome_cliente, escritorio.nome AS nome_escritorio
	FROM contrato_aluguel
	JOIN cliente ON contrato_aluguel.id_cliente = cliente.id_cliente
	JOIN escritorio ON contrato_aluguel.id_escritorio = escritorio.id_escritorio;
