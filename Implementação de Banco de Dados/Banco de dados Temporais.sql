-- Criação do banco de dados DB_Temporal
CREATE DATABASE DB_Temporal;

-- Seleção do banco de dados recém-criado
USE DB_Temporal;

-- Verifica se a tabela InventarioCarros existe. Se existir, desabilita o versionamento e apaga as tabelas
IF OBJECT_ID('dbo.InventarioCarros', 'U') IS NOT NULL 
BEGIN
    -- Desabilita o versionamento de sistema para que possamos manipular a tabela
    ALTER TABLE [dbo].[InventarioCarros] SET ( SYSTEM_VERSIONING = OFF );
    
    -- Apaga a tabela InventarioCarros (caso exista) e a tabela histórica
    DROP TABLE dbo.InventarioCarros;
    DROP TABLE dbo.HistoricoInventarioCarros;
END

-- Criação da tabela InventarioCarros com versionamento de sistema
CREATE TABLE InventarioCarros  
(    
    CarroId INT IDENTITY PRIMARY KEY,  -- Identificador único e auto-incrementado para cada carro
    Ano INT,                           -- Ano de fabricação do carro
    Marca VARCHAR(40),                 -- Marca do carro
    Modelo VARCHAR(40),                -- Modelo do carro
    Cor VARCHAR(10),                   -- Cor do carro
    Quilometragem INT,                 -- Quilometragem do carro
    Disponivel BIT NOT NULL DEFAULT 1,  -- Disponibilidade do carro (0 = indisponível, 1 = disponível)
    
    -- Colunas de controle de tempo para versionamento automático
    SysStartTime DATETIME2 GENERATED ALWAYS AS ROW START NOT NULL,  -- Hora de início da versão do registro
    SysEndTime DATETIME2 GENERATED ALWAYS AS ROW END NOT NULL,     -- Hora de término da versão do registro
    
    -- Define o período para a versão do sistema (quando o registro é válido)
    PERIOD FOR SYSTEM_TIME (SysStartTime, SysEndTime)     
)   
WITH 
( 
    -- Habilita o versionamento de sistema, criando a tabela histórica automaticamente
    SYSTEM_VERSIONING = ON (HISTORY_TABLE = dbo.HistoricoInventarioCarros)   
);

-- Exibe o conteúdo atual da tabela InventarioCarros
SELECT * FROM dbo.InventarioCarros;

-- Exibe o conteúdo da tabela histórica, onde são armazenadas as versões anteriores dos dados
SELECT * FROM dbo.HistoricoInventarioCarros;

-- Inserção de novos carros na tabela InventarioCarros
INSERT INTO dbo.InventarioCarros (Ano, Marca, Modelo, Cor, Quilometragem, Disponivel) 
VALUES (2004, 'Fiat', 'Uno', 'Branco', 150000, 1);

INSERT INTO dbo.InventarioCarros (Ano, Marca, Modelo, Cor, Quilometragem, Disponivel) 
VALUES (2015, 'Ford', 'Ka', 'Preto', 30000, 1);

INSERT INTO dbo.InventarioCarros (Ano, Marca, Modelo, Cor, Quilometragem, Disponivel) 
VALUES (2022, 'Hyundai', 'HB20', 'Prata', 0, 1);

INSERT INTO dbo.InventarioCarros (Ano, Marca, Modelo, Cor, Quilometragem, Disponivel) 
VALUES (2022, 'Hyundai', 'HB20', 'Branco', 0, 1);

-- Atualização do status de disponibilidade do carro com CarroId = 1 para "indisponível" (Disponivel = 0)
UPDATE dbo.InventarioCarros SET Disponivel = 0 WHERE CarroId = 1;

-- Atualização do status de disponibilidade do carro com CarroId = 4 para "indisponível" (Disponivel = 0)
UPDATE dbo.InventarioCarros SET Disponivel = 0 WHERE CarroId = 4;

-- Atualização da quilometragem e do status de disponibilidade do carro com CarroId = 1 para "disponível" (Disponivel = 1)
UPDATE dbo.InventarioCarros SET Disponivel = 1, Quilometragem = 160000 WHERE CarroId = 1;

-- Atualização da quilometragem e do status de disponibilidade do carro com CarroId = 4 para "disponível" (Disponivel = 1)
UPDATE dbo.InventarioCarros SET Disponivel = 1, Quilometragem = 3000 WHERE CarroId = 4;

-- Exclusão do carro com CarroId = 1 da tabela InventarioCarros (registro removido)
DELETE FROM InventarioCarros WHERE CarroId = 1;

-- Consulta na tabela InventarioCarros no momento exato '2024-11-11 13:46:20' usando o versionamento de sistema
-- Isso retorna os dados que estavam válidos nesse momento, considerando as atualizações e exclusões feitas.
SELECT * FROM InventarioCarros
FOR SYSTEM_TIME AS OF '2024-11-11 13:46:20'
ORDER BY CarroId;

--Consulta carro que foi deletado que está no histórico
SELECT DISTINCT 
H.CarroId
FROM InventariosCarros AS I
RIGHT JOIN HistoricoInventarioCarros AS H 
ON I.CarroId = H.CarroId
WHERE I.CarroId IS NULL;
