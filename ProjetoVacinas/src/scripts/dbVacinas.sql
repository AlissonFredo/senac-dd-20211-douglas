CREATE SCHEMA `db_vacinas` ;

USE `db_vacinas` ;

CREATE TABLE `db_vacinas`.`pessoa` (
	`id_pessoa` INT NOT NULL AUTO_INCREMENT,
	`nome` VARCHAR(250) NOT NULL,
	`sexo` ENUM('masculino', 'feminino') NOT NULL,
	`cpf` VARCHAR(11) NOT NULL,
	`tipo` INT NOT NULL,
	PRIMARY KEY (`id_pessoa`),
	UNIQUE INDEX `id_pessoa_UNIQUE` (`id_pessoa` ASC) VISIBLE,
	UNIQUE INDEX `cpf_UNIQUE` (`cpf` ASC) VISIBLE);
  
CREATE TABLE `db_vacinas`.`vacina` (
	`id_vacina` INT NOT NULL AUTO_INCREMENT,
	`nome` VARCHAR(250) NOT NULL,
	`pais_origem` VARCHAR(70) NOT NULL,
	`estagio_vacina` ENUM('inicial', 'testes', 'populacao') NOT NULL,
	`data_inicio_pesquisa` DATE NOT NULL,
	`id_pesquisador_responsavel` INT NOT NULL,
	`fase` INT NOT NULL,
	`quantidade_doses` INT NOT NULL,
	PRIMARY KEY (`id_vacina`),
	UNIQUE INDEX `id_vacina_UNIQUE` (`id_vacina` ASC) VISIBLE);
  
ALTER TABLE `db_vacinas`.`vacina` 
	ADD CONSTRAINT `fk_vacina`
	FOREIGN KEY (`id_vacina`) REFERENCES `db_vacinas`.`pessoa` (`id_pessoa`)
	ON DELETE NO ACTION ON UPDATE NO ACTION;
  
CREATE TABLE `db_vacinas`.`aplicacao_vacina` (
	`id_aplicacao_vacina` INT NOT NULL AUTO_INCREMENT,
	`data_aplicacao` DATE NOT NULL,
	`nota` INT NOT NULL,
	PRIMARY KEY (`id_aplicacao_vacina`),
	UNIQUE INDEX `id_aplicacao_vacina_UNIQUE` (`id_aplicacao_vacina` ASC) VISIBLE,
	CONSTRAINT `fk_aplicacao_vacina_1` FOREIGN KEY (`id_aplicacao_vacina`) REFERENCES `db_vacinas`.`pessoa` (`id_pessoa`)
		ON DELETE NO ACTION ON UPDATE NO ACTION,
  	CONSTRAINT `fk_aplicacao_vacina_2` FOREIGN KEY (`id_aplicacao_vacina`) REFERENCES `db_vacinas`.`vacina` (`id_vacina`)
    	ON DELETE NO ACTION ON UPDATE NO ACTION);
    	
    	