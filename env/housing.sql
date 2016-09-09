CREATE DATABASE IF NOT EXISTS `housing`;

USE `housing`;

DROP TABLE IF EXISTS `t_city`;

CREATE TABLE `t_city` (
	`id` int AUTO_INCREMENT, 
	`abbr` varchar(20) NOT NULL COMMENT '城市简称', 
	`name` varchar(20) NOT NULL COMMENT '城市名称',
	PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `t_house`;

CREATE TABLE `t_house` (
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
	`c_abbr` varchar(20) COMMENT '城市简称',
	PRIMARY KEY (`id`)
);