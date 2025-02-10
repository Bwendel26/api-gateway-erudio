CREATE TABLE `books` (
  `id` INT(10) AUTO_INCREMENT PRIMARY KEY,
  `title` longtext NOT NULL,
  `category` VARCHAR(80),
  `author` longtext,
  `launch_date` datetime(6) NOT NULL,
  `number_of_pages` INT,
  `price` decimal(65,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
