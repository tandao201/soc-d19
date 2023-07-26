CREATE DATABASE  IF NOT EXISTS `soc` ;
USE `soc`;
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` int NOT NULL AUTO_INCREMENT,
  `total_price` int DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `id_user` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `orders` WRITE;
INSERT INTO `orders` VALUES (1,1500,'ordered',1),(2,500,'ordered',1),(3,500,'paid',2);
UNLOCK TABLES;
