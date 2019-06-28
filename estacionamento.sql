-- MySQL dump 10.13  Distrib 8.0.11, for Win64 (x86_64)
--
-- Host: localhost    Database: db_estacionamento
-- ------------------------------------------------------
-- Server version	8.0.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8mb4 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tbl_movimentacao`
--

DROP TABLE IF EXISTS `tbl_movimentacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tbl_movimentacao` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `placa` varchar(7) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `modelo` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `data_entrada` datetime NOT NULL,
  `data_saida` datetime DEFAULT NULL,
  `tempo` int(11) NOT NULL,
  `valor_pago` decimal(6,2) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_movimentacao`
--

LOCK TABLES `tbl_movimentacao` WRITE;
/*!40000 ALTER TABLE `tbl_movimentacao` DISABLE KEYS */;
INSERT INTO `tbl_movimentacao` VALUES (1,'ADR4951','Fusion','2019-04-15 08:52:00','2019-04-15 10:19:00',3,14.00),(2,'KLD9851','Porche Sport','2019-04-26 16:23:37','2019-04-26 16:24:27',0,0.00),(3,'SEF7845','Hyundai HB20','2019-04-22 09:02:00',NULL,0,0.00),(5,'DPL0594','Honda Civic','2019-04-23 09:02:00','2019-04-26 16:59:46',80,322.00),(6,'BDC1548','Honda Fit','2019-04-25 11:24:19',NULL,0,0.00),(7,'DEJ4516','Audi A3','2019-04-25 11:26:37',NULL,0,0.00),(8,'DLW4577','Volks Gol','2019-04-26 14:02:32',NULL,0,0.00),(9,'DDU6596','Fiat Pálio','2019-04-26 14:14:48','2019-04-29 07:58:19',66,266.00),(10,'HAR7824','Fiat Linea','2019-04-26 15:02:18',NULL,0,0.00);
/*!40000 ALTER TABLE `tbl_movimentacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_usuario`
--

DROP TABLE IF EXISTS `tbl_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tbl_usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(30) NOT NULL,
  `usuario` varchar(20) NOT NULL,
  `senha` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_usuario`
--

LOCK TABLES `tbl_usuario` WRITE;
/*!40000 ALTER TABLE `tbl_usuario` DISABLE KEYS */;
INSERT INTO `tbl_usuario` VALUES (1,'Jean Cigoli de Almeida','JeanCigoli','12345');
/*!40000 ALTER TABLE `tbl_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_valor`
--

DROP TABLE IF EXISTS `tbl_valor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tbl_valor` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `valor_primeira_hora` decimal(6,2) NOT NULL,
  `valor_demais_horas` decimal(6,2) NOT NULL,
  `data_fim` date DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_valor`
--

LOCK TABLES `tbl_valor` WRITE;
/*!40000 ALTER TABLE `tbl_valor` DISABLE KEYS */;
INSERT INTO `tbl_valor` VALUES (1,3.00,1.00,'2019-04-13'),(2,6.00,4.00,NULL);
/*!40000 ALTER TABLE `tbl_valor` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-04-29 11:30:00
