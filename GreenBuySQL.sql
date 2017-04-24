-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema bdgreenbuynaooficial
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema bdgreenbuynaooficial
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bdgreenbuynaooficial` DEFAULT CHARACTER SET utf8 ;
USE `bdgreenbuynaooficial` ;

-- -----------------------------------------------------
-- Table `bdgreenbuynaooficial`.`cargo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdgreenbuynaooficial`.`cargo` (
  `carCodigo` INT(11) NOT NULL AUTO_INCREMENT COMMENT 'Código do cargo. Chave primária auto-incrementada',
  `carNome` VARCHAR(30) NOT NULL COMMENT 'Nome do cargo',
  PRIMARY KEY (`carCodigo`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bdgreenbuynaooficial`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdgreenbuynaooficial`.`cliente` (
  `cliCodigo` INT(11) NOT NULL AUTO_INCREMENT COMMENT 'Código do cliente. Chave primária auto-incrementada',
  `cliNome` VARCHAR(60) NOT NULL COMMENT 'Nome do cliente',
  `cliLogin` VARCHAR(50) NOT NULL COMMENT 'Login de entrada do cliente',
  `cliSenha` VARCHAR(20) NOT NULL COMMENT 'Senha de entrada do cliente',
  `cliEmail` VARCHAR(80) NULL DEFAULT NULL COMMENT 'Email particular de contato do cliente',
  `cliTelefone` TEXT NULL DEFAULT NULL COMMENT 'Telefone de contato do cliente',
  PRIMARY KEY (`cliCodigo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bdgreenbuynaooficial`.`formapagamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdgreenbuynaooficial`.`formapagamento` (
  `fpaCodigo` INT(11) NOT NULL AUTO_INCREMENT COMMENT 'Código do tipo da venda. Chave primária auto-incrementada',
  `fpaNome` VARCHAR(20) NOT NULL COMMENT 'Nome do tipo da venda: \"Dinheiro\", \"Cartão\", \"Cheque\" ou \"Prazo\"',
  PRIMARY KEY (`fpaCodigo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bdgreenbuynaooficial`.`fornecedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdgreenbuynaooficial`.`fornecedor` (
  `forCodigo` INT(11) NOT NULL AUTO_INCREMENT COMMENT 'Código do fornecedor',
  `forNome` VARCHAR(60) NOT NULL COMMENT 'Nome do fornecedor',
  `forTipo` INT(11) NOT NULL COMMENT 'Tipo de fornecedor: 1 - Empresa(com CNPJ), 2 - Pessoa física(com CPF)',
  `forCPF` TEXT NULL DEFAULT NULL COMMENT 'CPF do fornecedor (para pessoas)',
  `forCNPJ` TEXT NULL DEFAULT NULL COMMENT 'CNPJ do fornecedor (para empresas)',
  `forTelefone` TEXT NULL DEFAULT NULL COMMENT 'Telefone de contato do fornecedor',
  PRIMARY KEY (`forCodigo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bdgreenbuynaooficial`.`fornecimento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdgreenbuynaooficial`.`fornecimento` (
  `frnCodigo` INT(11) NOT NULL AUTO_INCREMENT COMMENT 'Código do fornecimento (ou compra)',
  `frnData` DATE NOT NULL COMMENT 'Data do fornecimento',
  `frnNNotaFiscal` TEXT NOT NULL COMMENT 'Número da nota fiscal da compra',
  `frnAcrescimo` FLOAT NULL DEFAULT NULL COMMENT 'Acrescimo sobre a compra em dinheiro (R$)',
  `frnDesconto` FLOAT NULL DEFAULT NULL COMMENT 'Desconto sobre a compra em dinheiro (R$)',
  `frn_forCodigo` INT(11) NOT NULL COMMENT 'Código do Fornecedor desta compra. Chave estrangeira da tabela Fornecedor',
  PRIMARY KEY (`frnCodigo`),
  INDEX `fk_Fornecimento_Fornecedor1_idx` (`frn_forCodigo` ASC),
  CONSTRAINT `fk_Fornecimento_Fornecedor1`
    FOREIGN KEY (`frn_forCodigo`)
    REFERENCES `bdgreenbuynaooficial`.`fornecedor` (`forCodigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bdgreenbuynaooficial`.`funcionario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdgreenbuynaooficial`.`funcionario` (
  `funCodigo` INT(11) NOT NULL AUTO_INCREMENT COMMENT 'Código do funcionário. Chave primária auto-incrementada',
  `funNome` VARCHAR(60) NOT NULL COMMENT 'Nome do funcionário',
  `funCPF` TEXT NOT NULL COMMENT 'CPF do funcionário',
  `funSalario` FLOAT NULL DEFAULT NULL COMMENT 'Salário do funcionário',
  `funLogin` VARCHAR(50) NOT NULL COMMENT 'Login de acesso do funcionário',
  `funSenha` VARCHAR(30) NOT NULL COMMENT 'Senha de acesso do funcionário',
  `funTelefone` TEXT NULL DEFAULT NULL COMMENT 'Telefone de contato do funcionário',
  `fun_carCodigo` INT(11) NOT NULL COMMENT 'Cargo do funcionário. Chave estrangeira da tabela Cargo',
  PRIMARY KEY (`funCodigo`),
  INDEX `fk_Funcionario_Cargo1_idx` (`fun_carCodigo` ASC),
  CONSTRAINT `fk_Funcionario_Cargo1`
    FOREIGN KEY (`fun_carCodigo`)
    REFERENCES `bdgreenbuynaooficial`.`cargo` (`carCodigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bdgreenbuynaooficial`.`objeto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdgreenbuynaooficial`.`objeto` (
  `objCodigo` INT(11) NOT NULL AUTO_INCREMENT COMMENT 'Código do objeto. Chave primária auto-incrementada',
  `objNome` VARCHAR(60) NOT NULL COMMENT 'Nome do objeto',
  `objDescricao` VARCHAR(100) NULL DEFAULT NULL COMMENT 'Descrição do objeto',
  `objPrecoVendaBase` FLOAT NULL DEFAULT NULL COMMENT 'Preço base de venda do objeto em dinheiro(R$)',
  `objPrecoCompraBase` FLOAT NULL DEFAULT NULL COMMENT 'Preço base de compra do objeto em dinheiro(R$)',
  `objUnidade` VARCHAR(4) NOT NULL COMMENT 'Unidade do objeto: Un,  L, ml, Kg, g',
  `objQtdeEstoque` FLOAT NULL DEFAULT NULL COMMENT 'Quantidade em estoque deste objeto. Não usada caso este objeto for um produto',
  `objTipo` INT(11) NOT NULL COMMENT 'Tipo do objeto: 1 - Produto, 2 - Mercadoria',
  `obj_clsCodigo` INT(11) NOT NULL COMMENT 'Classe a qual o objeto pertence. Chave estrangeira da tabela Classe',
  PRIMARY KEY (`objCodigo`),
  INDEX `fk_Produto_TipoProduto1_idx` (`obj_clsCodigo` ASC),
  CONSTRAINT `fk_Produto_TipoProduto1`
    FOREIGN KEY (`obj_clsCodigo`)
    REFERENCES `bdgreenbuynaooficial`.`classe` (`clsCodigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bdgreenbuynaooficial`.`objeto_fornecimento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdgreenbuynaooficial`.`objeto_fornecimento` (
  `obf_objCodigo` INT(11) NOT NULL COMMENT 'Código do objeto. Chave estrangeira da tabela Objeto',
  `obf_frnCodigo` INT(11) NOT NULL COMMENT 'Código do fornecimento. Chave estrangeira da tabela Fornecimento',
  `obfQuantidade` FLOAT NOT NULL COMMENT 'Quantidade fornecida deste objeto',
  `obfPrecoCompraPraticadoUn` FLOAT NOT NULL COMMENT 'Preço praticado por unidade de objeto neste fornecimento em dinheiro (R$)',
  `obfLote` TEXT NOT NULL COMMENT 'Lote ao qual este(s) objeto(s) pertence(m)',
  INDEX `fk_Objeto_has_Fornecimento_Fornecimento1_idx` (`obf_frnCodigo` ASC),
  INDEX `fk_Objeto_has_Fornecimento_Objeto1_idx` (`obf_objCodigo` ASC),
  CONSTRAINT `fk_Objeto_has_Fornecimento_Fornecimento1`
    FOREIGN KEY (`obf_frnCodigo`)
    REFERENCES `bdgreenbuynaooficial`.`fornecimento` (`frnCodigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Objeto_has_Fornecimento_Objeto1`
    FOREIGN KEY (`obf_objCodigo`)
    REFERENCES `bdgreenbuynaooficial`.`objeto` (`objCodigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bdgreenbuynaooficial`.`venda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdgreenbuynaooficial`.`venda` (
  `venCodigo` INT(11) NOT NULL AUTO_INCREMENT COMMENT 'Código da venda. Chave primária autoincrementada',
  `venData` DATE NOT NULL COMMENT 'Data de realização da venda',
  `venHora` TIME NOT NULL COMMENT 'Hora de realização da venda',
  `venDataPagamento` DATE NULL DEFAULT NULL COMMENT 'Data de pagamento da venda',
  `venDesconto` FLOAT NULL DEFAULT NULL COMMENT 'Desconto sobre a venda em dinheiro (R$)',
  `venAcrescimo` FLOAT NULL DEFAULT NULL COMMENT 'Acréscimo sobre a venda em dinheiro (R$)',
  `venSituacao` TINYINT(1) NULL DEFAULT NULL COMMENT 'A situação da venda: Paga(1) ou Deve(0)',
  `ven_cliCodigo` INT(11) NOT NULL COMMENT 'Cliente que fez a venda. Chave estrangeira da tabela Cliente',
  `ven_funCodigo` INT(11) NOT NULL COMMENT 'Funcionário que realizou a venda. Chave estrangeira da tabela Funcionário',
  `ven_fpaCodigo` INT(11) NOT NULL COMMENT 'Forma de pagamento. Chave estrangeira da tabela FormaPagamento',
  PRIMARY KEY (`venCodigo`),
  INDEX `fk_Venda_Cliente1_idx` (`ven_cliCodigo` ASC),
  INDEX `fk_Venda_Funcionario1_idx` (`ven_funCodigo` ASC),
  INDEX `fk_Venda_TipoVenda1_idx` (`ven_fpaCodigo` ASC),
  CONSTRAINT `fk_Venda_Cliente1`
    FOREIGN KEY (`ven_cliCodigo`)
    REFERENCES `bdgreenbuynaooficial`.`cliente` (`cliCodigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Venda_Funcionario1`
    FOREIGN KEY (`ven_funCodigo`)
    REFERENCES `bdgreenbuynaooficial`.`funcionario` (`funCodigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Venda_TipoVenda1`
    FOREIGN KEY (`ven_fpaCodigo`)
    REFERENCES `bdgreenbuynaooficial`.`formapagamento` (`fpaCodigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bdgreenbuynaooficial`.`objeto_venda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdgreenbuynaooficial`.`objeto_venda` (
  `obv_venCodigo` INT(11) NOT NULL COMMENT 'Código da venda. Chave estrangeira da tabela Venda',
  `obv_objCodigo` INT(11) NOT NULL COMMENT 'Código do objeto. Chave estrangeira da tabela Objeto',
  `obvQtdeVendida` FLOAT NOT NULL COMMENT 'Quantidade vendida deste objeto nesta venda',
  `obvPrecoVendaPraticadoUnidade` FLOAT NOT NULL COMMENT 'Preço praticado por unidade de objeto nesta venda em dinheiro (R$)',
  INDEX `fk_Venda_has_Produto_Produto1_idx` (`obv_objCodigo` ASC),
  INDEX `fk_Venda_has_Produto_Venda1_idx` (`obv_venCodigo` ASC),
  CONSTRAINT `fk_Venda_has_Produto_Produto1`
    FOREIGN KEY (`obv_objCodigo`)
    REFERENCES `bdgreenbuynaooficial`.`objeto` (`objCodigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Venda_has_Produto_Venda1`
    FOREIGN KEY (`obv_venCodigo`)
    REFERENCES `bdgreenbuynaooficial`.`venda` (`venCodigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bdgreenbuynaooficial`.`Classe`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdgreenbuynaooficial`.`Classe` (
  `clsCodigo` INT NOT NULL AUTO_INCREMENT COMMENT 'Código da classe. Chave primária auto-incrementada',
  `clsNome` VARCHAR(50) NOT NULL COMMENT 'Nome da classe',
  PRIMARY KEY (`clsCodigo`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
