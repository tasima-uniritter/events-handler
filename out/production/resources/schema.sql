CREATE TABLE IF NOT EXISTS `events` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `name` varchar(150) NOT NULL,
    `date` date NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `tickets` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `name` varchar(150) NOT NULL,
    `price` decimal(6,2) NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `sales_periods` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `ticket` varchar(150) NOT NULL,
    `starts_at` date NOT NULL,
    `ends_at` date NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `orders` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `userType` varchar(150) NOT NULL,
    `ticketType` varchar(150) NOT NULL,
    `amount` decimal(6,2) NOT NULL,
    PRIMARY KEY (`id`)
);