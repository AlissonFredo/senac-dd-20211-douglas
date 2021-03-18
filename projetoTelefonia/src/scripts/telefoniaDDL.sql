create database telefonia;
use telefonia;

CREATE TABLE telefone (
	id_telefone integer auto_increment NOT NULL,
	codigo_internacional VARCHAR(2) NOT NULL,
	ddd VARCHAR(2) NOT NULL,
	numero VARCHAR(9) NOT NULL,
	id_cliente integer NULL,
	movel BOOL NULL,
	ativo BOOL NULL,
	CONSTRAINT telefone_pk PRIMARY KEY (id_telefone)
);

CREATE TABLE endereco (
	id_endereco integer auto_increment NOT NULL,
	cep VARCHAR(8) NOT NULL,
	logradouro VARCHAR(500) NOT NULL,
	cidade VARCHAR(100) NOT NULL,
	uf VARCHAR(2) NOT NULL,
	numero VARCHAR(5) NOT NULL,
	CONSTRAINT endereco_pk PRIMARY KEY (id_endereco)
);

CREATE TABLE cliente (
	id_cliente integer auto_increment NOT NULL,
	cpf VARCHAR(11) NOT NULL,
	nome VARCHAR(200) NOT NULL,
	ativo BOOL NOT NULL,
	id_endereco integer NOT NULL,
	CONSTRAINT cliente_pk PRIMARY KEY (id_cliente),
	CONSTRAINT cliente_fk FOREIGN KEY (id_endereco) REFERENCES endereco(id_endereco)
);
