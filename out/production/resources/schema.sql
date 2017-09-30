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
    `ticket` bigint(20) NOT NULL,
    `event` bigint(20) NOT NULL,
    `starts_at` date NOT NULL,
    `ends_at` date NOT NULL,
    PRIMARY KEY (`id`)
);
