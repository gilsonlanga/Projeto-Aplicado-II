-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: treinamento
-- ------------------------------------------------------
-- Server version	8.0.34

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `treinamento`
--

DROP TABLE IF EXISTS `treinamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `treinamento` (
  `idTreinamento` int NOT NULL AUTO_INCREMENT,
  `nomeCurso` varchar(45) NOT NULL,
  `dataInicio` varchar(45) NOT NULL,
  `dataTermino` varchar(45) NOT NULL,
  `cargaHoraria` varchar(45) NOT NULL,
  `funcionario_id` int NOT NULL,
  `notaFuncionario` int NOT NULL,
  `vigencia` varchar(45) NOT NULL,
  `treinamentoConcluido` tinyint NOT NULL,
  `areaAbrangencia_id` int NOT NULL,
  `custo` varchar(45) DEFAULT NULL,
  `curso_id` int NOT NULL,
  PRIMARY KEY (`idTreinamento`),
  KEY `fk_treinamento_areaAbrangencia1_idx` (`areaAbrangencia_id`),
  KEY `fk_treinamento_funcionario1_idx` (`funcionario_id`),
  CONSTRAINT `fk_treinamento_areaAbrangencia1` FOREIGN KEY (`areaAbrangencia_id`) REFERENCES `areaabrangencia` (`id`),
  CONSTRAINT `fk_treinamento_funcionario1` FOREIGN KEY (`funcionario_id`) REFERENCES `funcionario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `treinamento`
--

LOCK TABLES `treinamento` WRITE;
/*!40000 ALTER TABLE `treinamento` DISABLE KEYS */;
INSERT INTO `treinamento` VALUES (1,'Informática','17/11/1983','17/11/1984','1.000 horas',1,10,'05/02/2024',1,3,'50.00',3),(2,'Gastronomia','17/11/1983','17/11/1985','1.000 horas',3,10,'17/11/2023',1,3,'50.00',3),(3,'Nutrição','17/11/1983','17/11/1984','1.000 horas',4,10,'17/11/2023',1,3,'50.00',3),(4,'Informática','17/11/1983','17/11/1984','1.000 horas',1,10,'05/02/2024',1,3,'50.00',3),(5,'BD','17/11/1983','05/02/2023','1.000 horas',3,10,'17/11/2023',1,3,'50.00',3),(6,'Piloto F1','01/04/2000','17/11/1984','1.000 horas',4,10,'17/11/2023',1,3,'50.00',3),(8,'Informática','17/11/1983','05/02/2023','1.000 horas',1,10,'05/02/2024',1,3,'50.00',3),(9,'BD','17/11/1983','17/11/1984','1.000 horas',1,10,'17/11/2023',1,3,'50.00',3),(10,'Formação Condutores','03/05/2015','15/07/2015','200 horas',3,8,'05/02/2024',1,4,'1500.0',6),(11,'Teste de Motor','07/03/2023','08/04/2023','30 horas',4,9,'05/02/2024',1,1,'200.00',2),(12,'Informática','17/11/1983','17/11/1984','1.000 horas',3,10,'17/11/2023',1,3,'50.00',3),(13,'Violão','17/11/1983','17/11/1984','1.000 horas',1,10,'17/11/2023',1,3,'50.00',3),(14,'Eletrônica','01/04/2020','25/08/2022','1320 horas',3,9,'17/11/2023',0,1,'1520.15',1),(15,'Liderança','01/11/2022','05/02/2024','100 horas',1,10,'05/02/2024',0,1,'100.01',1);
/*!40000 ALTER TABLE `treinamento` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-27  8:12:29
