CREATE DATABASE  IF NOT EXISTS `soc` ;
USE `soc`;
-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: soc
-- ------------------------------------------------------
-- Server version	8.0.32

DROP TABLE IF EXISTS `orders_products`;
CREATE TABLE `orders_products` (
  `id` int NOT NULL AUTO_INCREMENT,
  `order_id` int DEFAULT NULL,
  `products_id` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


LOCK TABLES `orders_products` WRITE;
INSERT INTO `orders_products` VALUES (1,1,2),(2,1,1),(3,2,2),(4,3,2);
UNLOCK TABLES;

