CREATE DATABASE  IF NOT EXISTS `soc` ;
USE `soc`;
-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: soc
-- ------------------------------------------------------
-- Server version	8.0.32

DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int NOT NULL AUTO_INCREMENT,
  `product_name` varchar(45) DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `price` int DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `image` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
INSERT INTO `product` VALUES (1,'iphone',30,1000,'iPhone 14 sở hữu màn hình Retina XDR OLED kích thước 6.1 inch cùng độ sáng vượt trội lên đến 1200 nits.','https://cdn.tgdd.vn/Products/Images/42/247508/iphone-14-pro-vang-thumb-600x600.jpg'),(2,'samsung',15,500,'Samsung là một trong những hãng điện tử, điện thoại nổi tiếng trên thế giới về độ bền, hãng là đối thủ cạnh tranh trực tiếp với Apple ở nhiều dòng sản phẩm.','https://images.samsung.com/is/image/samsung/p6pim/vn/2302/gallery/vn-galaxy-s23-s918-sm-s918bliqxxv-534859209?$650_519_PNG$'),(3,'Quạt điện',100,100,'Thiết kế gọn nhẹ, dễ di chuyển vị trí của quạt khi sử dụng','https://cdn.nguyenkimmall.com/images/detailed/693/10047739-quat-dien-hawonkoo-fah-010-7wings-1.jpg'),(5,'Loa Marshall',10,3000,'Nghe nhạc Pin lâu 20 tiếng, công suất 60W, kết nối với điện thoại dễ, mang đi du lịch rất tiện, hoặc để Deco cho nhà hàng…','https://dinhtoan.vn/wp-content/uploads/2023/07/81r6kn6bual-_ac_sl1500_-600x600-1.jpg');
UNLOCK TABLES;

