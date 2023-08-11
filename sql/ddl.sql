CREATE TABLE `contents` (
                          `id` integer AUTO_INCREMENT,
                          `title` varchar(200) NOT NULL,
                          `description` varchar(500) NOT NULL,
                          `creat_year` timestamp,
                          `expression` varchar(500) NOT NULL,
                          `caption` varchar(50) NOT NULL,
                          `path` varchar(255) NOT NULL,
                          CONSTRAINT IMAGES_PK PRIMARY KEY (`id`),
);