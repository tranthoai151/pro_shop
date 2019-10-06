CREATE TABLE `categories`(
   `category_id` INT NOT NULL AUTO_INCREMENT,
   `name` VARCHAR(100) NOT NULL,
   `description` TEXT,
   `status` TINYINT,
   PRIMARY KEY (`category_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
