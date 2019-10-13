CREATE TABLE `categories`(
   `category_id` INT NOT NULL AUTO_INCREMENT,
   `name` VARCHAR(100) NOT NULL,
   `description` TEXT,
   `status` TINYINT,
   PRIMARY KEY (`category_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO my_pro.categories (category_id, name, description, status) VALUES (1, 'Các loại chả', 'Chả ngon Phú Yên', 1);
INSERT INTO my_pro.categories (category_id, name, description, status) VALUES (2, 'Các loại mắm', 'Mắm chất lượng', 1);
INSERT INTO my_pro.categories (category_id, name, description, status) VALUES (3, 'Các loại khô', 'Khô 1 nắng', 1);

# product
CREATE TABLE IF NOT EXISTS `product` (
 `id` INT AUTO_INCREMENT PRIMARY KEY ,
 `name` VARCHAR(150) NOT NULL,
 `category_id` INT ,
 `price` DOUBLE NOT NULL,
 `img` varchar(150),
 FOREIGN KEY (category_id) REFERENCES categories(category_id)
)ENGINE=InnoDB CHARACTER SET=utf8;
INSERT INTO my_pro.product (id, name, category_id, price, img) VALUES (1, 'Chả cá', 1, 130000, 'chaca.jpg
');
INSERT INTO my_pro.product (id, name, category_id, price, img) VALUES (2, 'Mắm ruốt', 2, 50000, 'mamruot.jpg');
INSERT INTO my_pro.product (id, name, category_id, price, img) VALUES (3, 'Cá nục khô', 3, 25000, 'canuckho.jpg');
INSERT INTO my_pro.product (id, name, category_id, price, img) VALUES (4, 'Mắm mặn', 2, 20000, 'mamman.jpg');
