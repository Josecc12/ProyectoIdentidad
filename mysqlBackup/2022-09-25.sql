-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: identidad
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `identidad`
--

/*!40000 DROP DATABASE IF EXISTS `identidad`*/;

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `identidad` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `identidad`;

--
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clientes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(45) DEFAULT NULL,
  `Direccion` varchar(45) DEFAULT NULL,
  `Nit` varchar(45) DEFAULT NULL,
  `Telefono` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (1,'KEVIN','XELA','22','451718'),(3,'EMPRESA X S.A','XELA','223','402123'),(4,'DAS','DAS','45G','DAS'),(5,'ASDADSA','ASDASDA','76S','DAS'),(6,'','','51-3','QQQ'),(7,'AASDSD','ASDA','1AS','ASD'),(8,'ASDSD','ASDAD','123456789','ASDASDA');
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compra`
--

DROP TABLE IF EXISTS `compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `compra` (
  `id` int NOT NULL AUTO_INCREMENT,
  `Proveedores_id` int NOT NULL,
  `Total_Neto` double DEFAULT NULL,
  `Total_Bruto` double DEFAULT NULL,
  `Fecha` date DEFAULT NULL,
  `IVA` double DEFAULT NULL,
  `Serie` varchar(45) DEFAULT NULL,
  `Factura` varchar(45) DEFAULT NULL,
  `Usuario_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Compra_Proveedores1_idx` (`Proveedores_id`),
  KEY `fk_Compra_Usuario1_idx` (`Usuario_id`),
  CONSTRAINT `fk_Compra_Proveedores1` FOREIGN KEY (`Proveedores_id`) REFERENCES `proveedores` (`id`),
  CONSTRAINT `fk_Compra_Usuario1` FOREIGN KEY (`Usuario_id`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compra`
--

LOCK TABLES `compra` WRITE;
/*!40000 ALTER TABLE `compra` DISABLE KEYS */;
INSERT INTO `compra` VALUES (3,3,15000,13392.857142857141,'2022-05-01',1607.1428571428569,'10','10',2),(4,4,1500,1339.2857142857142,'2022-04-22',160.7142857142857,'10','11000',2),(5,5,2500,2232.142857142857,'2022-05-05',267.85714285714283,'10','150',2),(12,3,200,178.57142857142856,'2022-09-24',21.428571428571427,'100','10',2),(13,3,300,267.85714285714283,'2022-09-24',32.14285714285714,'1','1',2);
/*!40000 ALTER TABLE `compra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalle_venta`
--

DROP TABLE IF EXISTS `detalle_venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detalle_venta` (
  `id` int NOT NULL AUTO_INCREMENT,
  `Venta_id` int NOT NULL,
  `Producto_id` int NOT NULL,
  `Cantidad` int DEFAULT NULL,
  `Precio` double DEFAULT NULL,
  `IVA` double DEFAULT NULL,
  `SubTotal` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Venta_has_Producto_Producto1_idx` (`Producto_id`),
  KEY `fk_Venta_has_Producto_Venta1_idx` (`Venta_id`),
  CONSTRAINT `fk_Venta_has_Producto_Producto1` FOREIGN KEY (`Producto_id`) REFERENCES `producto` (`id`),
  CONSTRAINT `fk_Venta_has_Producto_Venta1` FOREIGN KEY (`Venta_id`) REFERENCES `venta` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_venta`
--

LOCK TABLES `detalle_venta` WRITE;
/*!40000 ALTER TABLE `detalle_venta` DISABLE KEYS */;
INSERT INTO `detalle_venta` VALUES (1,1,1,11,10,11.785714285714285,110),(2,1,1,11,10.5,12.374999999999998,115.5),(3,1,1,11,10.33,12.174642857142855,113.63),(4,2,1,11,10.25,12.08035714285714,112.75),(5,2,1,11,10.25,12.08035714285714,112.75),(6,2,1,11,10.25,12.08035714285714,112.75),(7,2,1,11,10.25,12.08035714285714,112.75),(8,2,1,11,10.25,12.08035714285714,112.75),(9,2,1,11,10.25,12.08035714285714,112.75),(10,2,1,11,10.25,12.08035714285714,112.75),(11,2,1,11,10.25,12.08035714285714,112.75),(12,3,1,10,12,12.857142857142856,120),(13,3,1,10,12,12.857142857142856,120),(14,3,1,10,12,12.857142857142856,120),(15,3,1,10,12,12.857142857142856,120),(16,3,1,10,12,12.857142857142856,120),(17,3,1,10,12,12.857142857142856,120),(18,3,1,10,12,12.857142857142856,120),(19,3,1,10,12,12.857142857142856,120),(20,4,1,11,10,11.785714285714285,110),(21,4,1,11,10,11.785714285714285,110),(22,4,1,11,10,11.785714285714285,110),(23,4,1,11,10,11.785714285714285,110),(24,4,1,11,10,11.785714285714285,110),(25,4,1,11,10,11.785714285714285,110),(27,6,1,100,22,235.71428571428567,2200),(28,6,1,100,22,235.71428571428567,2200),(29,6,1,100,22,235.71428571428567,2200),(30,6,1,100,22,235.71428571428567,2200),(31,7,1,5,10,5.357142857142857,50),(32,8,1,10,10,10.714285714285714,100),(33,8,1,10,10,10.714285714285714,100),(34,9,1,10,10,10.714285714285714,100),(37,11,1,55,100,589.2857142857142,5500),(38,11,1,8,15,12.857142857142856,120),(39,12,2,5,60,32.14285714285714,300),(40,12,2,3,55,17.678571428571427,165),(41,12,2,11,10,11.785714285714285,110),(42,12,2,1,11,1.1785714285714286,11),(43,12,2,1,1,0.10714285714285714,1),(44,12,2,11,11,12.964285714285714,121),(45,12,2,1,1,0.10714285714285714,1),(46,12,2,1,1,0.10714285714285714,1),(47,12,2,12,11,14.14285714285714,132),(48,20,2,1,1,0.10714285714285714,1),(49,21,2,1,1,0.10714285714285714,1),(50,22,2,1,11,1.1785714285714286,11),(51,23,2,1,1,0.10714285714285714,1),(53,25,9,1,10,1.0714285714285712,10),(54,25,9,2,10,2.1428571428571423,20),(55,26,9,1,1,0.10714285714285714,1),(56,26,9,1,1,0.10714285714285714,1),(57,27,9,10,1,1.0714285714285712,10),(58,27,9,2,11,2.357142857142857,22),(59,28,9,10,1,1.0714285714285712,10),(60,28,9,2,5,1.0714285714285712,10),(61,29,9,1,1,0.10714285714285714,1),(62,29,9,10,10,10.714285714285714,100),(63,30,9,5,1,0.5357142857142856,5),(64,30,8,2,200,42.857142857142854,400);
/*!40000 ALTER TABLE `detalle_venta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producto` (
  `id` int NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(45) DEFAULT NULL,
  `Existencia` int DEFAULT NULL,
  `Produccion` int DEFAULT NULL,
  `Descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES (1,'01',100,10,'GORRA'),(2,'02',100,0,'GORRA BLANCA'),(8,'G1',10,0,'GORRA1'),(9,'V1',10,1,'GORRA2'),(10,'G22',100,10,'GORRA22');
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedores`
--

DROP TABLE IF EXISTS `proveedores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proveedores` (
  `id` int NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(45) DEFAULT NULL,
  `Direccion` varchar(45) DEFAULT NULL,
  `Nit` varchar(45) DEFAULT NULL,
  `Telefono` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedores`
--

LOCK TABLES `proveedores` WRITE;
/*!40000 ALTER TABLE `proveedores` DISABLE KEYS */;
INSERT INTO `proveedores` VALUES (1,'DANIEL','XELA','111A','5932211SDA'),(3,'ADRIAN','XELA','25','40200343'),(4,'EMPRESA 2','NULL','583A','12323132'),(5,'EMPRESA 3','NULL','781','NULL'),(6,'ASD','ASD','11AS','ASD'),(8,'DANIEL',NULL,'111A',NULL),(9,'ADRIAN',NULL,'25',NULL),(10,'ADRIAN',NULL,'25',NULL),(11,'ADRIAN',NULL,'25',NULL),(12,'ADRIAN',NULL,'25',NULL),(13,'FACSA.SA',NULL,'11',NULL),(14,'FACSA.SA',NULL,'11',NULL),(15,'FACSA.SA',NULL,'11',NULL),(16,'SA',NULL,'22',NULL),(17,'SA',NULL,'22',NULL);
/*!40000 ALTER TABLE `proveedores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id` int NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(45) DEFAULT NULL,
  `Apellido` varchar(45) DEFAULT NULL,
  `Usuario` varchar(45) DEFAULT NULL,
  `Contrasena` varchar(45) DEFAULT NULL,
  `Tipo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'EMILIO','MEDINA','MEDINA','123',NULL),(2,'JOSE','CHOCOY','JCHOCOY','123','ADMINISTRADOR'),(3,'JEREZ2','MARTNIEZ','MJEREZ','123','EMPLEADO'),(6,'DSADSA','ASDSD','ASDDAS','ASD','ADMINISTRADOR');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venta`
--

DROP TABLE IF EXISTS `venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `venta` (
  `id` int NOT NULL AUTO_INCREMENT,
  `Clientes_id` int NOT NULL,
  `Usuario_id` int NOT NULL,
  `Total` double DEFAULT NULL,
  `Fecha` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Venta_Clientes1_idx` (`Clientes_id`),
  KEY `fk_Venta_Usuario1_idx` (`Usuario_id`),
  CONSTRAINT `fk_Venta_Clientes1` FOREIGN KEY (`Clientes_id`) REFERENCES `clientes` (`id`),
  CONSTRAINT `fk_Venta_Usuario1` FOREIGN KEY (`Usuario_id`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venta`
--

LOCK TABLES `venta` WRITE;
/*!40000 ALTER TABLE `venta` DISABLE KEYS */;
INSERT INTO `venta` VALUES (1,1,1,339.13,'2022-04-27'),(2,1,1,902,'2022-04-27'),(3,1,1,960,'2022-04-27'),(4,1,1,660,'2022-05-04'),(6,1,1,8800,'2022-05-05'),(7,1,1,50,'2022-05-05'),(8,1,1,200,'2022-05-05'),(9,1,1,100,'2022-05-05'),(11,1,2,5620,'2022-05-06'),(12,3,2,465,'2022-05-06'),(20,4,3,1,'2022-05-12'),(21,5,3,1,'2022-05-12'),(22,6,3,11,'2022-05-12'),(23,7,3,1,'2022-05-12'),(25,1,2,30,'2022-06-28'),(26,1,2,2,'2022-06-28'),(27,1,2,32,'2022-06-28'),(28,1,2,20,'2022-06-28'),(29,1,2,101,'2022-06-28'),(30,1,2,405,'2022-06-28');
/*!40000 ALTER TABLE `venta` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-09-25 18:18:53
