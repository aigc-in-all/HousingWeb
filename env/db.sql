CREATE DATABASE IF NOT EXISTS `housing`;

USE `housing`;

DROP TABLE IF EXISTS `province`;

CREATE TABLE `province` (
	`id` int NOT NULL AUTO_INCREMENT, 
	`name` varchar(20) NOT NULL COMMENT '省名称',
	PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `city`;

CREATE TABLE `city` (
	`id` int NOT NULL AUTO_INCREMENT, 
	`abbr` varchar(20) NOT NULL COMMENT '城市简称', 
	`name` varchar(20) NOT NULL COMMENT '城市名称',
	`p_id` int NOT NULL COMMENT '省份',
	PRIMARY KEY (`id`),
	CONSTRAINT `fk_city_province` FOREIGN KEY (`p_id`) REFERENCES `province` (`id`) ON DELETE CASCADE
);

DROP TABLE IF EXISTS `house`;

CREATE TABLE `house` (
	`id` int NOT NULL AUTO_INCREMENT, 
	`build_name` varchar(50) COMMENT '楼盘名称',
	`build_region` varchar(20) COMMENT '楼盘商圈', 
	`house_type` varchar(20) COMMENT '户型',
	`house_area` varchar(20) COMMENT '面积', 
	`house_floor` varchar(10) COMMENT '楼层', 
	`rent_type` varchar(10) COMMENT '出租类型', 
	`rent_room` varchar(20) COMMENT '出租房间', 
	`rent_price` float COMMENT '价格', 
	`img` varchar(100) COMMENT '图片',
	`url` varchar(100) COMMENT '地址',
	`c_id` int COMMENT '城市',
	PRIMARY KEY (`id`),
	CONSTRAINT fk_house_city FOREIGN KEY (c_id) REFERENCES city (id) ON DELETE CASCADE
);