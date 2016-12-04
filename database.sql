CREATE TABLE IF NOT EXISTS `solicitante` (
  `idSolicitante` INT NOT NULL AUTO_INCREMENT,
  `cpf` VARCHAR(14) NOT NULL,
  `email`VARCHAR(50) NOT NULL,
  `senha` VARCHAR(20) NOT NULL,
  `nome` VARCHAR(50) NOT NULL,
  `sexo` VARCHAR(10) NOT NULL,
  `dataNascimento` DATE NOT NULL,
  `numeroCelular` VARCHAR(14) NOT NULL,
  `numeroCelular` VARCHAR(14) NOT NULL,
  PRIMARY KEY (`idSolicitante`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

/*/
CREATE TABLE IF NOT EXISTS `projetos_equipe` (
  `idProjetos_equipe` INT NOT NULL AUTO_INCREMENT,
  `projeto_id` INT NOT NULL,
  `associado_id`INT NOT NULL,
  `ocupacao` VARCHAR(20) NOT NULL,
  `valor` INT NOT NULL,
  PRIMARY KEY (`idProjetos_equipe`),
  INDEX `fk_projetos_equipe_projeto1` (`projeto_id` ASC),
  INDEX `fk_projetos_equipe_associado1` (`associado_id` ASC),
  CONSTRAINT `fk_projetos_equipe_projeto1`
    FOREIGN KEY (`projeto_id`)
    REFERENCES `projetos` (`idProjetos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_projetos_equipe_associado1`
    FOREIGN KEY (`associado_id`)
    REFERENCES `associados` (`idAssociados`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;
/**/