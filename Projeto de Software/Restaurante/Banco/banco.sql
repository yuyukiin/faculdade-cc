CREATE DATABASE SistemaPedidos;
USE SistemaPedidos;

CREATE TABLE Produto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    preco DECIMAL(10,2) NOT NULL,
    quantidade INT NOT NULL,
    categoria VARCHAR(100) NOT NULL
);

CREATE TABLE Pedido (
    id INT AUTO_INCREMENT PRIMARY KEY,
    valorTotal DECIMAL(10,2) NOT NULL
);
