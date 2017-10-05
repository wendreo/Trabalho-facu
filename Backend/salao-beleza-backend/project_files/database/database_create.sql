-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema salao
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema salao
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `salao` DEFAULT CHARACTER SET utf8 ;
USE `salao` ;

-- -----------------------------------------------------
-- Table `salao`.`tb_user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `salao`.`tb_user` (
  `pk_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(255) NOT NULL,
  `name` VARCHAR(120) NOT NULL,
  `password` VARCHAR(128) NOT NULL,
  `telefone` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`pk_id`),
  UNIQUE INDEX `UK_4vih17mube9j7cqyjlfbcrk4m` (`email` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `salao`.`tb_agendamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `salao`.`tb_agendamento` (
  `pk_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `agenda_data` VARCHAR(20) NOT NULL,
  `agenda_dia_semana` VARCHAR(20) NOT NULL,
  `agenda_horario` VARCHAR(20) NOT NULL,
  `id_user` BIGINT(20) NULL DEFAULT NULL,
  PRIMARY KEY (`pk_id`),
  INDEX `FK_ijn5ss76ffyx7633agh4qd12i` (`id_user` ASC),
  CONSTRAINT `FK_ijn5ss76ffyx7633agh4qd12i`
    FOREIGN KEY (`id_user`)
    REFERENCES `salao`.`tb_user` (`pk_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `salao`.`tb_funcionario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `salao`.`tb_funcionario` (
  `id_funcionario` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `cpf_funcionario` VARCHAR(255) NOT NULL,
  `email_funcionario` VARCHAR(255) NOT NULL,
  `empresa_funcionario` VARCHAR(120) NOT NULL,
  `fone_funcionario` VARCHAR(120) NOT NULL,
  `funcao_funcionario` VARCHAR(120) NOT NULL,
  `nome_funcionario` VARCHAR(120) NOT NULL,
  `rg_funcionario` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id_funcionario`),
  UNIQUE INDEX `UK_41rxtr6e6xvseala25hb5ar2g` (`cpf_funcionario` ASC),
  UNIQUE INDEX `UK_2xnc86xn3kky30p0ufd36x68t` (`email_funcionario` ASC),
  UNIQUE INDEX `UK_1wmpgqe5rboe4sq7ip2i771x0` (`rg_funcionario` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `salao`.`tb_permission`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `salao`.`tb_permission` (
  `pk_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`pk_id`),
  UNIQUE INDEX `UK_rwvnf9dhenmknvljgery79idd` (`role` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `salao`.`tb_user_permission`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `salao`.`tb_user_permission` (
  `permission_id` BIGINT(20) NOT NULL,
  `user_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`permission_id`, `user_id`),
  INDEX `FK_l6cvhr5w2r9ff429fa5eqxmyo` (`user_id` ASC),
  CONSTRAINT `FK_44w3gaqxmtfvn2xslng1a5pi0`
    FOREIGN KEY (`permission_id`)
    REFERENCES `salao`.`tb_permission` (`pk_id`),
  CONSTRAINT `FK_l6cvhr5w2r9ff429fa5eqxmyo`
    FOREIGN KEY (`user_id`)
    REFERENCES `salao`.`tb_user` (`pk_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
