-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.6.45-log - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping structure for table my_pro.product
CREATE TABLE IF NOT EXISTS `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(150) NOT NULL,
  `category_id` int(11) DEFAULT NULL,
  `price` double NOT NULL,
  `img` varchar(150) DEFAULT NULL,
  `description` text,
  `unit` varchar(50) NOT NULL,
  `status` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `category_id` (`category_id`),
  CONSTRAINT `product_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `categories` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- Dumping data for table my_pro.product: ~7 rows (approximately)
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` (`id`, `name`, `category_id`, `price`, `img`, `description`, `unit`, `status`) VALUES
	(1, 'Chả cá', 1, 130000, 'chaca.jpg\r\n', NULL, '1kg', 1),
	(2, 'Mắm ruốt', 2, 50000, 'mamruot.jpg', NULL, '1 hủ', 2),
	(3, 'Cá nục phơi khô', 3, 25000, 'canuckho.jpg', NULL, '1 bịch', 1),
	(4, 'Nước mắm nguyên chất', 2, 20000, 'mamman.jpg', NULL, '1 lít', 1),
	(5, 'Mắm cơm', 3, 25000, 'abc.jpg', NULL, '1 hủ', 1),
	(6, 'Cá trích tẩm gia vị', 1, 40000, 'ddd.png', NULL, '1 bịch', 1),
	(7, 'Cá cơm tẩm gia vị', 1, 50000, 'cacom.jog', NULL, '1 hủ', 1);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
