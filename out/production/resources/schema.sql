CREATE TABLE IF NOT EXISTS `events` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `name` varchar(150) NOT NULL,
    `date` DATE NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `tickets` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `name` varchar(150) NOT NULL,
    `price` decimal(6,2) NOT NULL,
    PRIMARY KEY (`id`)
);