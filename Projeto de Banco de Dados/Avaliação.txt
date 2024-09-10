-- Nomes 
-- Yuri Alexander e Eduardo Ceretta 

-- Numero 1
-- O papel é organizar, armazenar e gerenciar os dados em formato de tabelas. É também uma linguagem de consulta utilizada para pesquisar os dados armazenados do banco.

-- Numero 2
-- As principais são chaves primarias, integridade referêncial (chaves estrangeiras), triggers, restrições exclusivas, restrições de verificação e restrição nulo.

-- Numero 3

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `prova_db` DEFAULT CHARACTER SET utf8 ;
USE `prova_db` ;

CREATE TABLE IF NOT EXISTS `prova_db`.`professores` (
  `idProfessor` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `idCurso` INT NOT NULL,
  `areaAtuacao` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idProfessor`) ,
  CONSTRAINT `fk_Professor_Curso`
    FOREIGN KEY (`idCurso`)
    REFERENCES `prova_db`.`Curso` (`idCurso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `prova_db`.`curso` (
  `idCurso` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `area` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idCurso`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `prova_db`.`instituição` (
  `idInstituição` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `sigla` VARCHAR(45) NOT NULL, 	
  PRIMARY KEY (`idInstituição`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `prova_db`.`projeto` (
  `idProjeto` INT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(45) NOT NULL,
  `resumo` VARCHAR(45) NOT NULL,
  `idProfessor` INT NOT NULL,
  `idColaborador` INT,
  `idInstituição` INT NOT NULL,
  PRIMARY KEY (`idProjeto`) ,
  CONSTRAINT `fk_Responsavel`
    FOREIGN KEY (`idProfessor`)
    REFERENCES `prova_db`.`Professor` (`idProfessor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Instituição`
    FOREIGN KEY (`idInstituição`)
    REFERENCES `prova_db`.`Instituição` (`idInstituição`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Colaborador`
    FOREIGN KEY (`idColaborador`)
    REFERENCES `prova_db`.`Professor` (`idProfessor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


select *  from professores;
insert into professores values (1,"Alexandre Zamberlan","alexz@ufn.edu.br",1,"Tecnologia");
insert into professores values (2,"Ana Paula","apc@ufn.edu.b",1,"Tecnologia");
insert into professores values (3,"Sylvio Garcia","sylvio@ufn.edu.br",2,"Tecnologia");
insert into professores values (4,"Mirkos Martins","mirkos@ufn.edu.br",1,"Tecnologia");

select *  from curso;
insert into curso values (1,"Ciência da Computação","Tecnologia");
insert into curso values (2,"Sistemas de Informação","Tecnologia");
insert into curso values (3,"Filosofia","Sociais");

select *  from instituição;
insert into instituição values (10,"Universidad Franciscana","UFN");
insert into instituição values (20,"Universidade Federal de Santa Maria","UFSM");

select *  from projeto;
insert into projeto values (1,"Web Crawler","Trabalho do Zamba",1,NULL,10);
insert into projeto values (2,"SirPerf","Sistema de perfusão",1,3,10);
insert into projeto values (3,"OdontoTren","Sistema de gestão de atendimento",2,3,20);
insert into projeto values (4,"Avida","Sistema de acompanhamento psiquiátrico",1,NULL,10);


-- Numero 4
select titulo
from projeto
inner join instituição
on projeto.idInstituição = instituição.idInstituição
where instituição.idInstituição = 10;

-- Numero 5
select distinct(professores.nome)
from professores, projeto
where professores.idProfessor not in(select projeto.IdProfessor
								   from projeto);

-- Numero 6
select titulo
from projeto
inner join professores
on projeto.idProfessor = professores.idProfessor
where professores.idProfessor = 1;

-- Numero 7
select count(*)
from projeto;

-- Numero 8
select projeto.titulo
from projeto
where projeto.idColaborador is null;

-- Numero 9
select titulo
from projeto
inner join professores
on projeto.idProfessor = professores.idProfessor
inner join curso
on professores.idCurso = curso.idCurso
where professores.idCurso = 1 or professores.idCurso = 2;

-- Numero 10
select projeto.titulo, curso.nome
from projeto
inner join professores
on projeto.idProfessor = professores.idProfessor
inner join curso
on professores.idCurso = curso.idCurso
