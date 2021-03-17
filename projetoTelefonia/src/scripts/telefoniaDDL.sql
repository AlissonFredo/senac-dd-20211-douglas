CREATE DATABASE telefonia;
USE telefonia;

CREATE TABLE endereco (
	idEndereco INT NOT NULL AUTO_INCREMENT,
	logradouro VARCHAR(500) NOT NULL,
	numero VARCHAR(10) CHARACTER SET 'utf8' NOT NULL,
	cidade VARCHAR(100) NOT NULL,
	uf VARCHAR(2) NOT NULL,
	cep VARCHAR(8) NOT NULL,
	PRIMARY KEY (idEndereco));
  
CREATE TABLE telefone (
	idTelefone INT NOT NULL AUTO_INCREMENT,
	codigoInternacional VARCHAR(2) NOT NULL,
	ddd VARCHAR(2) NOT NULL,
	numero VARCHAR(9) NOT NULL,
	movel TINYINT NOT NULL,
	ativo TINYINT NOT NULL,
	PRIMARY KEY (idTelefone));
  
CREATE TABLE cliente (
	idcliente INT NOT NULL AUTO_INCREMENT,
	cpf VARCHAR(11) NOT NULL,
	ativo TINYINT NOT NULL,
	PRIMARY KEY (idcliente),
	CONSTRAINT clienteFK FOREIGN KEY (idcliente) REFERENCES endereco (idEndereco));
	
ALTER SCHEMA telefonia  DEFAULT CHARACTER SET utf8  DEFAULT COLLATE utf8_general_ci ;

ALTER TABLE telefone ADD COLUMN idCliente INT NOT NULL AFTER ativo;
