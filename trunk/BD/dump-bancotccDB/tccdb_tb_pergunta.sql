CREATE DATABASE  IF NOT EXISTS `tccdb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `tccdb`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: tccdb
-- ------------------------------------------------------
-- Server version	5.6.20

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
-- Table structure for table `tb_pergunta`
--

DROP TABLE IF EXISTS `tb_pergunta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_pergunta` (
  `ID_PERGUNTA` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Identificador unico',
  `DE_PERGUNTA` varchar(1500) NOT NULL,
  PRIMARY KEY (`ID_PERGUNTA`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COMMENT='Tabela que armazenara as perguntas';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_pergunta`
--

LOCK TABLES `tb_pergunta` WRITE;
/*!40000 ALTER TABLE `tb_pergunta` DISABLE KEYS */;
INSERT INTO `tb_pergunta` VALUES (15,'Um requisito de software expressa as necessidades e restrições colocadas em um produto de software que contribuem para a solução de algum problema do mundo real. Acerca desse assunto, assinale a opção correta.'),(16,'Para evitar descrever o mesmo fluxo de eventos diversas vezes quando se tratar de um comportamento comum a vários casos de uso, é recomendado escrever esse comportamento em um único caso de uso e relacioná-lo aos demais por meio de um relacionamento de:'),(17,'(FGV - 2010 - CODESP-SP) No emprego da UML utilizam-se diversos diagramas. Nos Casos de Uso, analise a situação abaixo:\r\n\r\nSejam ALFA e BETA dois casos de uso. \r\nQuando BETA herda de ALFA, as sequências de comportamento de ALFA valem também para BETA. \r\nQuando for necessário, BETA pode redefinir as sequências de comportamento de ALFA. \r\nAlém disso, BETA, na condição de caso de uso herdeiro, participa em qualquer relacionamento no qual ALFA participa.\r\n\r\nA situação descrita caracteriza um relacionamento denominado: \r\n'),(18,'(CESGRANRIO - 2011 - TRANSPETRO) O Processo Unificado divide a realização de um projeto para desenvolvimento de um sistema de software em fases. Em cada uma dessas fases, são executadas atividades de diversas disciplinas em diferentes proporções. No desenvolvimento de um sistema de software complexo, esse processo recomenda:'),(19,'(FGV - 2009 - MEC) Na modelagem de Caso de Uso, <<include>> e <<extend>> são relacionamentos de:'),(20,'Sejam as seguintes assertivas sobre o Modelo de Casos de Uso naUML2.0: \r\n\r\nI. O único tipo de relação possível entre um ator e um caso de uso é uma associação. Ele representa a comunicação entreumator eumcaso de uso.  V\r\n\r\nII. A relação de generalização entre casos de uso não é permitida. Ela deve ser substituída pela relação  . F\r\nIII. Atores podem se relacionar através de uma generalização ou de uma associação. F\r\n\r\nIV. Os componentes mais importantes do modelo de casos de uso são os diagramas de caso de uso. V\r\n\r\nV. O modo pelo qual os casos de uso devem ser textualmente descritos está formalmente definido no documento OMG Unified Modeling Language (OMG UML) Superstructure. F\r\n\r\nDentre as assertivas acima, quantas são verdadeiras? \r\n');
/*!40000 ALTER TABLE `tb_pergunta` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-11-22 15:58:20
