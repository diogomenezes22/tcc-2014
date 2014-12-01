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
-- Table structure for table `tb_resposta`
--

DROP TABLE IF EXISTS `tb_resposta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_resposta` (
  `ID_RESPOSTA` int(11) NOT NULL AUTO_INCREMENT,
  `ID_PERGUNTA` int(11) NOT NULL,
  `DE_RESPOSTA` varchar(500) NOT NULL,
  `IC_CORRETA` char(1) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT 'E' COMMENT 'Indica se esta resposta é correta(C) ou não(E)',
  PRIMARY KEY (`ID_RESPOSTA`,`ID_PERGUNTA`),
  KEY `FK_TB_PERGUNTA_idx` (`ID_PERGUNTA`),
  CONSTRAINT `FK_TB_PERGUNTA` FOREIGN KEY (`ID_PERGUNTA`) REFERENCES `tb_pergunta` (`ID_PERGUNTA`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8 COMMENT='Tabela que armazena as respostas para uma pergunta';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_resposta`
--

LOCK TABLES `tb_resposta` WRITE;
/*!40000 ALTER TABLE `tb_resposta` DISABLE KEYS */;
INSERT INTO `tb_resposta` VALUES (45,15,'Os contratantes ou clientes são os principais colaboradores envolvidos no fornecimento de informações para o processo de levantamento ou elicitação de requisitos de software, os demais grupos de pessoas que podem fornecer informações são considerados de importância secundária. ','E'),(46,15,'As necessidades dos usuários a serem atendidas por um produto de software constituem a classe de requisitos funcionais, e as restrições mencionadas na definição de requisitos constituem a classe de requisitos não funcionais. ','E'),(47,15,'Entre as fontes de informação para a elicitação de requisitos, destacam-se, além dos colaboradores, o conhecimento do domínio de aplicação em que o software funcionará, o ambiente operacional do software e o ambiente organizacional. ','C'),(48,15,'A negociação de requisitos, de forma similar à observação do ambiente organizacional, é uma atividade típica da fase de elicitação de requisitos. ','E'),(49,16,'Agregação por composição. ','E'),(50,16,'Agregação simples. ','E'),(51,16,'Generalização. ','E'),(52,16,'Inclusão. ','C'),(53,17,'Agregação','E'),(54,17,'Generalização','C'),(55,17,'Associação','E'),(56,17,'Inclusão','E'),(57,18,'Usar a abordagem de desenvolvimento iterativa e incremental, para dividir as atividades em iterações em que cada iteração gera um incremento do software. ','C'),(58,18,'Construir uma arquitetura executável ao final da fase de construção, para validar as regras do negócio e os requisitos funcionais do sistema. ','E'),(59,18,'Ordenar os riscos envolvidos no projeto, para que os riscos menos críticos sejam considerados logo na fase de iniciação e os mais críticos nas fases finais. ','E'),(60,18,'Entregar a primeira versão do sistema logo após a fase de transição, para evitar os problemas existentes no modelo de ciclo de vida em cascata tradicional.','E'),(61,19,'Atores entre si','E'),(62,19,'Agregação','E'),(63,19,'Dependência','C'),(64,19,'Especialização','E'),(65,20,'1','E'),(66,20,'2','C'),(67,20,'3','E'),(68,20,'4','E');
/*!40000 ALTER TABLE `tb_resposta` ENABLE KEYS */;
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
