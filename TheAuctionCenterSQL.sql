CREATE DATABASE  IF NOT EXISTS `auction_center_proto`;
USE `auction_center_proto`;

CREATE TABLE `client`
(
  `client_id` int(5) NOT NULL AUTO_INCREMENT,
  `client_name` varchar(30) not null,
  `client_address` varchar(30) not null,
   PRIMARY KEY (`client_id`)
);