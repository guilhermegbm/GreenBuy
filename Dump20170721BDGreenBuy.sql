CREATE DATABASE  IF NOT EXISTS `bdgreenbuy` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `bdgreenbuy`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: bdgreenbuy
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.19-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cargo`
--

DROP TABLE IF EXISTS `cargo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cargo` (
  `carCodigo` int(11) NOT NULL AUTO_INCREMENT,
  `carNome` varchar(30) NOT NULL,
  PRIMARY KEY (`carCodigo`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cargo`
--

LOCK TABLES `cargo` WRITE;
/*!40000 ALTER TABLE `cargo` DISABLE KEYS */;
INSERT INTO `cargo` VALUES (1,'Gerente'),(2,'Atendente'),(3,'Faxineiro');
/*!40000 ALTER TABLE `cargo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `cliCodigo` int(11) NOT NULL AUTO_INCREMENT,
  `cliCPF` varchar(30) NOT NULL,
  `cliEmail` varchar(80) DEFAULT NULL,
  `cliLogin` varchar(50) NOT NULL,
  `cliNome` varchar(80) NOT NULL,
  `cliSenha` varchar(20) NOT NULL,
  `cliSituacao` varchar(255) NOT NULL,
  `cliTelefone` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`cliCodigo`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'252','eduardo@gmail.com','eduardoLogin','Eduardo','odraude','ATIVO','(37)12345-6789'),(2,'456','fernanda@gmail.com','fernandaLogin','Fernanda','adnanref','ATIVO','(37)12345-6789'),(3,'222','gustavo@gmail.com','gustavoLogin','Gustavo','ovatsug','DESLIGADO','(37)12345-6789');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fornecedor`
--

DROP TABLE IF EXISTS `fornecedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fornecedor` (
  `forCodigo` int(11) NOT NULL AUTO_INCREMENT,
  `forCNPJ` varchar(40) DEFAULT NULL,
  `forCPF` varchar(40) DEFAULT NULL,
  `forNome` varchar(80) NOT NULL,
  `forSituacao` varchar(255) NOT NULL,
  `forTelefone` varchar(20) DEFAULT NULL,
  `forTipo` int(11) NOT NULL,
  PRIMARY KEY (`forCodigo`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fornecedor`
--

LOCK TABLES `fornecedor` WRITE;
/*!40000 ALTER TABLE `fornecedor` DISABLE KEYS */;
INSERT INTO `fornecedor` VALUES (1,'987456',NULL,'Hortaliças da Tia','INATIVO','(37)12345-6789',0),(2,NULL,'547','Igor','ATIVO','(37)12345-6789',1),(3,'123654',NULL,'Janta do povão','ATIVO','(37)12345-6789',0);
/*!40000 ALTER TABLE `fornecedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fornecimento`
--

DROP TABLE IF EXISTS `fornecimento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fornecimento` (
  `frnCodigo` int(11) NOT NULL AUTO_INCREMENT,
  `frnAcrescimo` float DEFAULT NULL,
  `frnData` date NOT NULL,
  `frnDesconto` float DEFAULT NULL,
  `frnNNotaFiscal` varchar(40) NOT NULL,
  `frn_forCodigo` int(11) NOT NULL,
  PRIMARY KEY (`frnCodigo`),
  KEY `FK_7lfktnd5kukmn4iqh7jttml2j` (`frn_forCodigo`),
  CONSTRAINT `FK_7lfktnd5kukmn4iqh7jttml2j` FOREIGN KEY (`frn_forCodigo`) REFERENCES `fornecedor` (`forCodigo`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fornecimento`
--

LOCK TABLES `fornecimento` WRITE;
/*!40000 ALTER TABLE `fornecimento` DISABLE KEYS */;
INSERT INTO `fornecimento` VALUES (1,10,'2017-07-21',0,'9875',1),(2,0,'2017-07-21',0.5,'3697',1),(3,0,'2017-07-21',0,'5258',2),(4,0,'2017-07-21',0,'3579',3),(5,50,'2017-07-21',20,'1597',3);
/*!40000 ALTER TABLE `fornecimento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `funcionario` (
  `funCodigo` int(11) NOT NULL AUTO_INCREMENT,
  `funAdministrador` bit(1) NOT NULL,
  `funCPF` varchar(30) NOT NULL,
  `funLogin` varchar(50) NOT NULL,
  `funNome` varchar(80) NOT NULL,
  `funSalario` float DEFAULT NULL,
  `funSenha` varchar(20) NOT NULL,
  `funSituacao` int(11) NOT NULL,
  `funTelefone` varchar(20) DEFAULT NULL,
  `fun_carCodigo` int(11) NOT NULL,
  PRIMARY KEY (`funCodigo`),
  KEY `FK_lprqfaq3guhac02g2de5rc8jl` (`fun_carCodigo`),
  CONSTRAINT `FK_lprqfaq3guhac02g2de5rc8jl` FOREIGN KEY (`fun_carCodigo`) REFERENCES `cargo` (`carCodigo`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario`
--

LOCK TABLES `funcionario` WRITE;
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
INSERT INTO `funcionario` VALUES (1,'\0','123','andreLogin','André',1180,'erdna',0,'(37)12345-6789',1),(2,'\0','321','barbaraLogin','Bárbara',980,'arabrab',1,'(37)12345-6789',2),(3,'\0','111','carlosLogin','Carlos',850,'solrac',0,'',3),(4,'\0','879','danielaLogin','Daniela',1390,'aleinad',1,'(37)12345-6789',1);
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grupo`
--

DROP TABLE IF EXISTS `grupo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `grupo` (
  `gruCodigo` int(11) NOT NULL AUTO_INCREMENT,
  `gruNome` varchar(40) NOT NULL,
  PRIMARY KEY (`gruCodigo`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grupo`
--

LOCK TABLES `grupo` WRITE;
/*!40000 ALTER TABLE `grupo` DISABLE KEYS */;
INSERT INTO `grupo` VALUES (1,'Doces'),(2,'Carnes'),(3,'Frios');
/*!40000 ALTER TABLE `grupo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `objeto`
--

DROP TABLE IF EXISTS `objeto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `objeto` (
  `objCodigo` int(11) NOT NULL AUTO_INCREMENT,
  `objDescricao` varchar(255) DEFAULT NULL,
  `objNome` varchar(60) NOT NULL,
  `objPrecoCompraBase` float DEFAULT NULL,
  `objPrecoVendaBase` float DEFAULT NULL,
  `objQtdeEstoque` float DEFAULT NULL,
  `objSituacao` varchar(255) NOT NULL,
  `objTipoObjeto` int(11) NOT NULL,
  `objUnidade` varchar(255) NOT NULL,
  `obj_subCodigo` int(11) NOT NULL,
  PRIMARY KEY (`objCodigo`),
  KEY `FK_has6gwq03p6qqxiw948xi86pc` (`obj_subCodigo`),
  CONSTRAINT `FK_has6gwq03p6qqxiw948xi86pc` FOREIGN KEY (`obj_subCodigo`) REFERENCES `subgrupo` (`subCodigo`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `objeto`
--

LOCK TABLES `objeto` WRITE;
/*!40000 ALTER TABLE `objeto` DISABLE KEYS */;
INSERT INTO `objeto` VALUES (1,'Chiclete bão','Chiclete Big Big',0.5,1,40,'VENDENDO',1,'UNIDADE',2),(2,'É um picolé muito bão','Tablito',2.5,3.25,8,'VENDENDO',1,'UNIDADE',1),(3,'É uma bala muito boa','Halls',1,1.5,0,'NAOVENDENDO',1,'UNIDADE',3),(4,'É um rango bão','Prato Feito',0,12,0,'VENDENDO',0,'UNIDADE',4),(5,'É outro rango bão','Prato Self Service',0,17.5,0,'VENDENDO',0,'GRAMA',4),(6,'É uma carne nobre e boa','Chã de dentro bovino',26.9,0,5,'NAOVENDENDO',1,'KILOGRAMA',5);
/*!40000 ALTER TABLE `objeto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `objeto_fornecimento`
--

DROP TABLE IF EXISTS `objeto_fornecimento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `objeto_fornecimento` (
  `obfLote` varchar(50) DEFAULT NULL,
  `obfPrecoCompraPraticadoUnidade` float NOT NULL,
  `obfQtdeFornecida` float NOT NULL,
  `obf_objCodigo` int(11) NOT NULL,
  `obf_frnCodigo` int(11) NOT NULL,
  PRIMARY KEY (`obf_frnCodigo`,`obf_objCodigo`),
  KEY `FK_h97u5bdl5j9tajcjhd9kns5id` (`obf_objCodigo`),
  CONSTRAINT `FK_2vdup5ofcn1tp6ssf4cqdqt2h` FOREIGN KEY (`obf_frnCodigo`) REFERENCES `fornecimento` (`frnCodigo`),
  CONSTRAINT `FK_h97u5bdl5j9tajcjhd9kns5id` FOREIGN KEY (`obf_objCodigo`) REFERENCES `objeto` (`objCodigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `objeto_fornecimento`
--

LOCK TABLES `objeto_fornecimento` WRITE;
/*!40000 ALTER TABLE `objeto_fornecimento` DISABLE KEYS */;
/*!40000 ALTER TABLE `objeto_fornecimento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `objeto_saida`
--

DROP TABLE IF EXISTS `objeto_saida`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `objeto_saida` (
  `saoPrecoNaSaida` float NOT NULL,
  `saoQtdeRetirada` float NOT NULL,
  `sao_saiCodigo` int(11) NOT NULL,
  `sao_objCodigo` int(11) NOT NULL,
  PRIMARY KEY (`sao_objCodigo`,`sao_saiCodigo`),
  KEY `FK_p2plwus3tse0qg2fneqtm8bkx` (`sao_saiCodigo`),
  CONSTRAINT `FK_59jycudmho2vqyw81mjh3v3k9` FOREIGN KEY (`sao_objCodigo`) REFERENCES `objeto` (`objCodigo`),
  CONSTRAINT `FK_p2plwus3tse0qg2fneqtm8bkx` FOREIGN KEY (`sao_saiCodigo`) REFERENCES `saida` (`saiCodigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `objeto_saida`
--

LOCK TABLES `objeto_saida` WRITE;
/*!40000 ALTER TABLE `objeto_saida` DISABLE KEYS */;
/*!40000 ALTER TABLE `objeto_saida` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `objeto_venda`
--

DROP TABLE IF EXISTS `objeto_venda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `objeto_venda` (
  `obvPrecoVendaPraticadoUnidade` float NOT NULL,
  `obvQtdeVendida` float NOT NULL,
  `obv_objCodigo` int(11) NOT NULL,
  `obv_venCodigo` int(11) NOT NULL,
  PRIMARY KEY (`obv_objCodigo`,`obv_venCodigo`),
  KEY `FK_aqbwp2lvcx8ikovbku0gwo1mu` (`obv_venCodigo`),
  CONSTRAINT `FK_aqbwp2lvcx8ikovbku0gwo1mu` FOREIGN KEY (`obv_venCodigo`) REFERENCES `venda` (`venCodigo`),
  CONSTRAINT `FK_iu75ym1j2nqofwctpsvx8anst` FOREIGN KEY (`obv_objCodigo`) REFERENCES `objeto` (`objCodigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `objeto_venda`
--

LOCK TABLES `objeto_venda` WRITE;
/*!40000 ALTER TABLE `objeto_venda` DISABLE KEYS */;
INSERT INTO `objeto_venda` VALUES (1,2,1,1),(1,2,1,3),(1,1,1,4),(3.5,1,2,2),(3.25,1,2,3),(1,3,3,1),(12,1,4,3),(12,1,5,2),(17.5,1,5,4);
/*!40000 ALTER TABLE `objeto_venda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `saida`
--

DROP TABLE IF EXISTS `saida`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `saida` (
  `saiCodigo` int(11) NOT NULL AUTO_INCREMENT,
  `saiAcrescimoAdicional` float DEFAULT NULL,
  `saiDataHora` datetime NOT NULL,
  `saiDebitoAdicional` float DEFAULT NULL,
  `saiTipoSaida` int(11) NOT NULL,
  PRIMARY KEY (`saiCodigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `saida`
--

LOCK TABLES `saida` WRITE;
/*!40000 ALTER TABLE `saida` DISABLE KEYS */;
/*!40000 ALTER TABLE `saida` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subgrupo`
--

DROP TABLE IF EXISTS `subgrupo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subgrupo` (
  `subCodigo` int(11) NOT NULL AUTO_INCREMENT,
  `subNome` varchar(60) NOT NULL,
  `sub_gruCodigo` int(11) DEFAULT NULL,
  PRIMARY KEY (`subCodigo`),
  KEY `FK_ebqe8a0h4d5pssb3m1mgru2ru` (`sub_gruCodigo`),
  CONSTRAINT `FK_ebqe8a0h4d5pssb3m1mgru2ru` FOREIGN KEY (`sub_gruCodigo`) REFERENCES `grupo` (`gruCodigo`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subgrupo`
--

LOCK TABLES `subgrupo` WRITE;
/*!40000 ALTER TABLE `subgrupo` DISABLE KEYS */;
INSERT INTO `subgrupo` VALUES (1,'Picolés',3),(2,'Chicletes',1),(3,'Balas',1),(4,'Pratos',NULL),(5,'Bovinos',2);
/*!40000 ALTER TABLE `subgrupo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venda`
--

DROP TABLE IF EXISTS `venda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `venda` (
  `venCodigo` int(11) NOT NULL AUTO_INCREMENT,
  `venAcrescimo` float DEFAULT NULL,
  `venDataHora` datetime NOT NULL,
  `venDataPagamento` date DEFAULT NULL,
  `venDesconto` float DEFAULT NULL,
  `venFormaPagamento` varchar(255) DEFAULT NULL,
  `venSituacao` int(11) NOT NULL,
  `ven_cliCodigo` int(11) NOT NULL,
  `ven_funCodigo` int(11) NOT NULL,
  PRIMARY KEY (`venCodigo`),
  KEY `FK_sexo1rj08jqejyacxj3k3d1v3` (`ven_cliCodigo`),
  KEY `FK_5u03g3j7bf1xv9m3cp88katkl` (`ven_funCodigo`),
  CONSTRAINT `FK_5u03g3j7bf1xv9m3cp88katkl` FOREIGN KEY (`ven_funCodigo`) REFERENCES `funcionario` (`funCodigo`),
  CONSTRAINT `FK_sexo1rj08jqejyacxj3k3d1v3` FOREIGN KEY (`ven_cliCodigo`) REFERENCES `cliente` (`cliCodigo`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venda`
--

LOCK TABLES `venda` WRITE;
/*!40000 ALTER TABLE `venda` DISABLE KEYS */;
INSERT INTO `venda` VALUES (1,2,'2017-07-21 13:12:15',NULL,0,'NAOPAGO',0,1,1),(2,0,'2017-07-21 13:12:15','2017-07-21',1.5,'CHEQUE',1,2,2),(3,0,'2017-07-21 13:12:15','2017-07-21',0,'DINHEIRO',1,3,4),(4,2.5,'2017-07-21 13:12:15',NULL,0,'NAOPAGO',0,3,2);
/*!40000 ALTER TABLE `venda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'bdgreenbuy'
--

--
-- Dumping routines for database 'bdgreenbuy'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-07-21 13:47:19
