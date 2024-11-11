CREATE DATABASE DB_Temporal;
USE DB_Temporal;
IF OBJECT_ID('dbo.InventarioCarros', 'U') IS NOT NULL 
BEGIN
	-- Ao excluir uma tabela temporal, precisamos primeiro desativar o controle de versão
    ALTER TABLE [dbo].[InventarioCarros] SET ( SYSTEM_VERSIONING = OFF  ) 
    DROP TABLE dbo.InventarioCarros
    DROP TABLE dbo.HistoricoInventarioCarros
END
CREATE TABLE InventarioCarros  
(    
    CarroId INT IDENTITY PRIMARY KEY,
    Ano INT,
    Marca VARCHAR(40),
    Modelo VARCHAR(40),
    Cor varchar(10),
    Quilometragem INT,
    Disponivel BIT NOT NULL DEFAULT 1,
    SysStartTime datetime2 GENERATED ALWAYS AS ROW START NOT NULL,
    SysEndTime datetime2 GENERATED ALWAYS AS ROW END NOT NULL,
    PERIOD FOR SYSTEM_TIME (SysStartTime, SysEndTime)     
)   
WITH 
( 
	--provividencia um nome para a tabela de históricos
    SYSTEM_VERSIONING = ON (HISTORY_TABLE = dbo.HistoricoInventarioCarros)   
)

	SELECT * FROM dbo.InventarioCarros;
SELECT * FROM dbo.HistoricoInventarioCarros;

--Vamos preenchê-lo com os carros mais escolhidos das agências de locação de carros em todo o Brasil
Insert into dbo.InventarioCarros (Ano,Marca,Modelo,Cor,Quilometragem,Disponivel) 
values (2004, 'Fiat', 'Uno', 'Branco', 150000, 1);
Insert into dbo.InventarioCarros (Ano,Marca,Modelo,Cor,Quilometragem,Disponivel) 
values (2015, 'Ford', 'Ka', 'Preto', 30000, 1);
Insert into dbo.InventarioCarros (Ano,Marca,Modelo,Cor,Quilometragem,Disponivel) 
values (2022, 'Hyundai', 'HB20', 'Prata', 0, 1);
Insert into dbo.InventarioCarros (Ano,Marca,Modelo,Cor,Quilometragem,Disponivel) 
values (2022, 'Hyundai', 'HB20', 'Branco', 0, 1);



UPDATE dbo.InventarioCarros SET Disponivel = 0 WHERE CarroId = 1;
UPDATE dbo.InventarioCarros SET Disponivel = 0 WHERE CarroId = 4;

UPDATE dbo.InventarioCarros SET Disponivel = 1, Quilometragem = 160000 WHERE CarroId = 1;
UPDATE dbo.InventarioCarros SET Disponivel = 1, Quilometragem = 3000 WHERE CarroId = 4;
