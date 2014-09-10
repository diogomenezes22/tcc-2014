-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema tccdb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema tccdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `tccdb` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `tccdb` ;

-- -----------------------------------------------------
-- Table `tccdb`.`tabuleiro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tccdb`.`tabuleiro` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `inicio` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tccdb`.`jogo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tccdb`.`jogo` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `data_inicio` DATETIME NULL,
  `data_fim` DATETIME NULL,
  `tabuleiro_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_jogo_tabuleiro1_idx` (`tabuleiro_id` ASC),
  CONSTRAINT `fk_jogo_tabuleiro1`
    FOREIGN KEY (`tabuleiro_id`)
    REFERENCES `tccdb`.`tabuleiro` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tccdb`.`prenda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tccdb`.`prenda` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(500) NULL,
  `repetida` TINYINT(1) NULL,
  `jogo_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_prenda_jogo1_idx` (`jogo_id` ASC),
  CONSTRAINT `fk_prenda_jogo1`
    FOREIGN KEY (`jogo_id`)
    REFERENCES `tccdb`.`jogo` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tccdb`.`pergunta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tccdb`.`pergunta` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(500) NULL,
  `repetida` TINYINT(1) NULL,
  `jogo_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_pergunta_jogo1_idx` (`jogo_id` ASC),
  CONSTRAINT `fk_pergunta_jogo1`
    FOREIGN KEY (`jogo_id`)
    REFERENCES `tccdb`.`jogo` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tccdb`.`resposta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tccdb`.`resposta` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(500) NULL,
  `correta` TINYINT(1) NULL,
  `alternativa` CHAR NULL,
  `pergunta_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_resposta_pergunta_idx` (`pergunta_id` ASC),
  CONSTRAINT `fk_resposta_pergunta`
    FOREIGN KEY (`pergunta_id`)
    REFERENCES `tccdb`.`pergunta` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tccdb`.`Peao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tccdb`.`Peao` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `idPeao` VARCHAR(45) NOT NULL,
  `posicaoAtual` INT NULL,
  `podeAndar` TINYINT(1) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tccdb`.`jogador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tccdb`.`jogador` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(70) NULL,
  `vez` TINYINT(1) NULL,
  `jogo_id` INT NOT NULL,
  `Peao_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Jogador_jogo1_idx` (`jogo_id` ASC),
  INDEX `fk_jogador_Peao1_idx` (`Peao_id` ASC),
  CONSTRAINT `fk_Jogador_jogo1`
    FOREIGN KEY (`jogo_id`)
    REFERENCES `tccdb`.`jogo` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_jogador_Peao1`
    FOREIGN KEY (`Peao_id`)
    REFERENCES `tccdb`.`Peao` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tccdb`.`casa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tccdb`.`casa` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `tipo` VARCHAR(45) NULL,
  `tabuleiro_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_casa_tabuleiro1_idx` (`tabuleiro_id` ASC),
  CONSTRAINT `fk_casa_tabuleiro1`
    FOREIGN KEY (`tabuleiro_id`)
    REFERENCES `tccdb`.`tabuleiro` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
