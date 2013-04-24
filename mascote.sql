CREATE SCHEMA IF NOT EXISTS `mascote` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `mascote` ;

-- -----------------------------------------------------
-- Table `mascote`.`MASCOTE`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mascote`.`MASCOTE` ;

CREATE  TABLE IF NOT EXISTS `mascote`.`MASCOTE` (
  `ID_MASCOTE` INT NOT NULL ,
  `DS_MASCOTE` VARCHAR(10) NULL ,
  `VR_VOTOS` BIGINT NULL ,
  PRIMARY KEY (`ID_MASCOTE`) )
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `mascote`.`PARAMETRO_CONFIGURACAO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mascote`.`PARAMETRO_CONFIGURACAO` ;

CREATE  TABLE IF NOT EXISTS `mascote`.`PARAMETRO_CONFIGURACAO` (
  `ID_PARAMETRO` INT NOT NULL ,
  `DS_PARAMETRO` VARCHAR(45) NULL ,
  `VR_PARAMETRO` VARCHAR(45) NULL ,
  PRIMARY KEY (`ID_PARAMETRO`) )
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `mascote`.`USUARIOS`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mascote`.`USUARIOS` ;

CREATE  TABLE IF NOT EXISTS `mascote`.`USUARIOS` (
  `ID_USUARIO` INT NOT NULL ,
  `DS_NOME` VARCHAR(45) NULL ,
  `DS_SENHA` VARCHAR(45) NULL ,
  PRIMARY KEY (`ID_USUARIO`) )
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `mascote`.`REGRA_USUARIO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mascote`.`REGRA_USUARIO` ;

CREATE  TABLE IF NOT EXISTS `mascote`.`REGRA_USUARIO` (
  `ID_REGRA_USUARIO` INT NOT NULL ,
  `ID_USUARIO` INT NULL ,
  `DS_REGRA` VARCHAR(45) NULL ,
  PRIMARY KEY (`ID_REGRA_USUARIO`) ,
  INDEX `ID_USUARIO_idx` (`ID_USUARIO` ASC) ,
  CONSTRAINT `FK_ID_USUARIO`
    FOREIGN KEY (`ID_USUARIO` )
    REFERENCES `mascote`.`USUARIOS` (`ID_USUARIO` ))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- INSERTS
-- -----------------------------------------------------

INSERT INTO MASCOTE VALUES (1, 'Amijubi', 0);
INSERT INTO MASCOTE VALUES (2, 'Fuleco', 0);
INSERT INTO MASCOTE VALUES (3, 'Zuzeco', 0);

INSERT INTO PARAMETRO_CONFIGURACAO VALUES (1, 'DATA_LIBERACAO_RESULTADO', '25/04/2013 20:00:00');

INSERT INTO USUARIOS VALUES (1, 'ADMIN', MD5('12345678'));
INSERT INTO USUARIOS VALUES (2, 'USUARIO', MD5('123456'));

INSERT INTO REGRA_USUARIO VALUES (1, 1, 'ROLE_ADMIN');
INSERT INTO REGRA_USUARIO VALUES (2, 2, 'ROLE_USUARIO');
