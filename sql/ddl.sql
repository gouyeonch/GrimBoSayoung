CREATE TABLE `contents` (
                          `id` integer AUTO_INCREMENT,
                          `title` varchar(200) NOT NULL,
                          `description` varchar(500) NOT NULL,
                          `filepath` varchar(300) NOT NULL,
                          `expression` varchar(500) NOT NULL,
                          `caption` varchar(50) NOT NULL,
                          PRIMARY KEY (`id`)
);