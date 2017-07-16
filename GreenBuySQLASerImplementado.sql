-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema bdgreenbuy
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema bdgreenbuy
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bdgreenbuy` DEFAULT CHARACTER SET utf8 ;
USE `bdgreenbuy` ;

-- -----------------------------------------------------
-- Table `bdgreenbuy`.`cargo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdgreenbuy`.`cargo` (
  `carCodigo` INT(11) NOT NULL AUTO_INCREMENT COMMENT 'Código do cargo. Chave primária auto-incrementada',
  `carNome` VARCHAR(30) NOT NULL COMMENT 'Nome do cargo',
  PRIMARY KEY (`carCodigo`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bdgreenbuy`.`classe`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdgreenbuy`.`classe` (
  `claCodigo` INT(11) NOT NULL AUTO_INCREMENT COMMENT 'Código do tipo do produto. Chave primária auto-incrementada',
  `claNome` VARCHAR(60) NOT NULL COMMENT 'Nome do tipo do produto: Suco, refrigerante, Assado, Fritura, etc',
  PRIMARY KEY (`claCodigo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bdgreenbuy`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdgreenbuy`.`cliente` (
  `cliCodigo` INT(11) NOT NULL AUTO_INCREMENT COMMENT 'Código do cliente. Chave primária auto-incrementada',
  `cliNome` VARCHAR(60) NOT NULL COMMENT 'Nome do cliente',
  `cliLogin` VARCHAR(50) NOT NULL COMMENT 'Login de entrada do cliente',
  `cliSenha` VARCHAR(20) NOT NULL COMMENT 'Senha de entrada do cliente',
  `cliEmail` VARCHAR(80) NULL DEFAULT NULL COMMENT 'Email particular de contato do cliente',
  `cliTelefone` TEXT NULL DEFAULT NULL COMMENT 'Telefone de contato do cliente',
  `cliCPF` VARCHAR(40) NOT NULL,
  PRIMARY KEY (`cliCodigo`))
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bdgreenbuy`.`formapagamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdgreenbuy`.`formapagamento` (
  `fpaCodigo` INT(11) NOT NULL AUTO_INCREMENT COMMENT 'Código do tipo da venda. Chave primária auto-incrementada',
  `fpaNome` VARCHAR(20) NOT NULL COMMENT 'Nome do tipo da venda: \"Dinheiro\", \"Cartão\", \"Cheque\" ou \"Prazo\"',
  PRIMARY KEY (`fpaCodigo`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bdgreenbuy`.`fornecedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdgreenbuy`.`fornecedor` (
  `forCodigo` INT(11) NOT NULL AUTO_INCREMENT COMMENT 'Código do fornecedor',
  `forNome` VARCHAR(60) NOT NULL COMMENT 'Nome do fornecedor',
  `forTipo` INT(11) NOT NULL,
  `forCPF` TEXT NULL DEFAULT NULL,
  `forCNPJ` TEXT NULL DEFAULT NULL COMMENT 'CNPJ do fornecedor',
  `forTelefone` TEXT NULL DEFAULT NULL COMMENT 'Telefone de contato do fornecedor',
  PRIMARY KEY (`forCodigo`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bdgreenbuy`.`fornecimento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdgreenbuy`.`fornecimento` (
  `frnCodigo` INT(11) NOT NULL AUTO_INCREMENT COMMENT 'Código do fornecimento (ou compra)',
  `frnData` DATE NOT NULL COMMENT 'Data do fornecimento',
  `frnNNotaFiscal` TEXT NOT NULL COMMENT 'Número da nota fiscal da compra',
  `frnAcrescimo` FLOAT NULL DEFAULT NULL,
  `frnDesconto` FLOAT NULL DEFAULT NULL,
  `frn_forCodigo` INT(11) NOT NULL COMMENT 'Fornecedor desta compra. Chave estrangeira da tabela Fornecedor',
  PRIMARY KEY (`frnCodigo`),
  INDEX `fk_Fornecimento_Fornecedor1_idx` (`frn_forCodigo` ASC),
  CONSTRAINT `fk_Fornecimento_Fornecedor1`
    FOREIGN KEY (`frn_forCodigo`)
    REFERENCES `bdgreenbuy`.`fornecedor` (`forCodigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bdgreenbuy`.`funcionario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdgreenbuy`.`funcionario` (
  `funCodigo` INT(11) NOT NULL AUTO_INCREMENT COMMENT 'Código do funcionário. Chave primária auto-incrementada',
  `funNome` VARCHAR(60) NOT NULL COMMENT 'Nome do funcionário',
  `funSalario` FLOAT NULL DEFAULT NULL COMMENT 'Salário do funcionário',
  `funLogin` VARCHAR(50) NOT NULL COMMENT 'Login de acesso do funcionário',
  `funSenha` VARCHAR(30) NOT NULL COMMENT 'Senha de acesso do funcionário',
  `funTelefone` TEXT NULL DEFAULT NULL COMMENT 'Telefone de contato do funcionário',
  `fun_carCodigo` INT(11) NOT NULL COMMENT 'Cargo do funcionário. Chave estrangeira da tabela Cargo',
  PRIMARY KEY (`funCodigo`),
  INDEX `fk_Funcionario_Cargo1_idx` (`fun_carCodigo` ASC),
  CONSTRAINT `fk_Funcionario_Cargo1`
    FOREIGN KEY (`fun_carCodigo`)
    REFERENCES `bdgreenbuy`.`cargo` (`carCodigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bdgreenbuy`.`subclasse`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdgreenbuy`.`subclasse` (
  `subCodigo` INT(11) NOT NULL AUTO_INCREMENT,
  `subNome` VARCHAR(60) NOT NULL,
  `sub_claCodigo` INT(11) NOT NULL,
  PRIMARY KEY (`subCodigo`),
  INDEX `fk_SubClasse_Classe1_idx` (`sub_claCodigo` ASC),
  CONSTRAINT `fk_SubClasse_Classe1`
    FOREIGN KEY (`sub_claCodigo`)
    REFERENCES `bdgreenbuy`.`classe` (`claCodigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bdgreenbuy`.`objeto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdgreenbuy`.`objeto` (
  `objCodigo` INT(11) NOT NULL AUTO_INCREMENT COMMENT 'Código do produto. Chave primária auto-incrementada',
  `objPseudoCod` INT(11) NOT NULL,
  `objNome` VARCHAR(60) NOT NULL COMMENT 'Nome do produto',
  `objDescricao` VARCHAR(100) NULL DEFAULT NULL COMMENT 'Descrição do produto',
  `objPrecoVendaBase` FLOAT NULL DEFAULT NULL COMMENT 'Preço base de venda do produto em dinheiro(R$)',
  `objPrecoCompraBase` FLOAT NULL DEFAULT NULL,
  `objUnidade` VARCHAR(4) NOT NULL COMMENT 'Unidade do produto: Un,  L, ml, Kg, g',
  `objQtdeEstoque` FLOAT NULL DEFAULT NULL,
  `objTipo` INT(11) NOT NULL,
  `obj_subCodigo` INT(11) NOT NULL,
  PRIMARY KEY (`objCodigo`),
  INDEX `fk_Objeto_SubClasse1_idx` (`obj_subCodigo` ASC),
  CONSTRAINT `fk_Objeto_SubClasse1`
    FOREIGN KEY (`obj_subCodigo`)
    REFERENCES `bdgreenbuy`.`subclasse` (`subCodigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bdgreenbuy`.`objeto_fornecimento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdgreenbuy`.`objeto_fornecimento` (
  `obf_objCodigo` INT(11) NOT NULL,
  `obf_frnCodigo` INT(11) NOT NULL,
  `obfQuantidade` FLOAT NOT NULL,
  `obfPrecoCompraPraticadoUn` FLOAT NOT NULL,
  `obfLote` TEXT NOT NULL,
  INDEX `fk_Objeto_has_Fornecimento_Fornecimento1_idx` (`obf_frnCodigo` ASC),
  INDEX `fk_Objeto_has_Fornecimento_Objeto1_idx` (`obf_objCodigo` ASC),
  CONSTRAINT `fk_Objeto_has_Fornecimento_Fornecimento1`
    FOREIGN KEY (`obf_frnCodigo`)
    REFERENCES `bdgreenbuy`.`fornecimento` (`frnCodigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Objeto_has_Fornecimento_Objeto1`
    FOREIGN KEY (`obf_objCodigo`)
    REFERENCES `bdgreenbuy`.`objeto` (`objCodigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bdgreenbuy`.`venda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdgreenbuy`.`venda` (
  `venCodigo` INT(11) NOT NULL AUTO_INCREMENT COMMENT 'Código da venda. Chave primária autoincrementada',
  `venData` DATE NOT NULL COMMENT 'Data de realização da venda',
  `venHora` TIME NOT NULL COMMENT 'Hora de realização da venda',
  `venDataPagamento` DATE NULL DEFAULT NULL COMMENT 'Data de pagamento da venda',
  `venDesconto` FLOAT NULL DEFAULT NULL COMMENT 'Desconto sobre a venda em dinheiro (R$)',
  `venAcrescimo` FLOAT NULL DEFAULT NULL COMMENT 'Acréscimo sobre a venda em dinheiro (R$)',
  `venSituacao` TINYINT(1) NULL DEFAULT NULL COMMENT 'A situação da venda: Paga(1) ou Deve(0)',
  `ven_cliCodigo` INT(11) NOT NULL COMMENT 'Cliente que fez a venda. Chave estrangeira da tabela Cliente',
  `ven_funCodigo` INT(11) NOT NULL COMMENT 'Funcionário que realizou a venda. Chave estrangeira da tabela Funcionário',
  `ven_fpaCodigo` INT(11) NOT NULL COMMENT 'Tipo de venda. Chave estrangeira da tabela TipoVenda',
  PRIMARY KEY (`venCodigo`),
  INDEX `fk_Venda_Cliente1_idx` (`ven_cliCodigo` ASC),
  INDEX `fk_Venda_Funcionario1_idx` (`ven_funCodigo` ASC),
  INDEX `fk_Venda_TipoVenda1_idx` (`ven_fpaCodigo` ASC),
  CONSTRAINT `fk_Venda_Cliente1`
    FOREIGN KEY (`ven_cliCodigo`)
    REFERENCES `bdgreenbuy`.`cliente` (`cliCodigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Venda_Funcionario1`
    FOREIGN KEY (`ven_funCodigo`)
    REFERENCES `bdgreenbuy`.`funcionario` (`funCodigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Venda_TipoVenda1`
    FOREIGN KEY (`ven_fpaCodigo`)
    REFERENCES `bdgreenbuy`.`formapagamento` (`fpaCodigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bdgreenbuy`.`objeto_venda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdgreenbuy`.`objeto_venda` (
  `obv_venCodigo` INT(11) NOT NULL COMMENT 'Código da venda. Chave estrangeira da tabela Venda',
  `obv_objCodigo` INT(11) NOT NULL COMMENT 'Código do produto. Chave estrangeira da tabela Produto',
  `obvQtdeVendida` FLOAT NOT NULL COMMENT 'Quantidade vendida deste produto nesta venda',
  `obvPrecoVendaPraticadoUnidade` FLOAT NOT NULL COMMENT 'Preço praticado por unidade de produto nesta venda em dinheiro (R$)',
  INDEX `fk_Venda_has_Produto_Produto1_idx` (`obv_objCodigo` ASC),
  INDEX `fk_Venda_has_Produto_Venda1_idx` (`obv_venCodigo` ASC),
  CONSTRAINT `fk_Venda_has_Produto_Produto1`
    FOREIGN KEY (`obv_objCodigo`)
    REFERENCES `bdgreenbuy`.`objeto` (`objCodigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Venda_has_Produto_Venda1`
    FOREIGN KEY (`obv_venCodigo`)
    REFERENCES `bdgreenbuy`.`venda` (`venCodigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bdgreenbuy`.`saida`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdgreenbuy`.`saida` (
  `saiCodigo` INT(11) NOT NULL AUTO_INCREMENT,
  `saiDataHora` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`saiCodigo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bdgreenbuy`.`saida_objeto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdgreenbuy`.`saida_objeto` (
  `sao_saiCodigo` INT(11) NOT NULL,
  `sao_objCodigo` INT(11) NOT NULL,
  `saoQtdeRetirada` FLOAT NOT NULL,
  INDEX `fk_Saida_has_Objeto_Objeto1_idx` (`sao_objCodigo` ASC),
  INDEX `fk_Saida_has_Objeto_Saida1_idx` (`sao_saiCodigo` ASC),
  CONSTRAINT `fk_Saida_has_Objeto_Objeto1`
    FOREIGN KEY (`sao_objCodigo`)
    REFERENCES `bdgreenbuy`.`objeto` (`objCodigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Saida_has_Objeto_Saida1`
    FOREIGN KEY (`sao_saiCodigo`)
    REFERENCES `bdgreenbuy`.`saida` (`saiCodigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
