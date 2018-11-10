# pruebajava
prueba de java de todouno

La prueba esta en una aplicacion web JSF co primefaces para ejecutar en un Glassfish.

El script para mysql es:
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema pruebas
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema pruebas
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `pruebas` DEFAULT CHARACTER SET utf8 ;
USE `pruebas` ;

-- -----------------------------------------------------
-- Table `pruebas`.`tipoarticulo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pruebas`.`tipoarticulo` (
  `id` INT(11) NOT NULL,
  `nombre` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `pruebas`.`articulo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pruebas`.`articulo` (
  `id` INT(11) NOT NULL,
  `nombre` VARCHAR(200) NULL DEFAULT NULL,
  `descripcion` VARCHAR(500) NULL DEFAULT NULL,
  `cantidad` INT(11) NOT NULL DEFAULT '0',
  `idtipoarticulo` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `idtipoarticulo` (`idtipoarticulo` ASC),
  CONSTRAINT `articulo_ibfk_1`
    FOREIGN KEY (`idtipoarticulo`)
    REFERENCES `pruebas`.`tipoarticulo` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;




SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
