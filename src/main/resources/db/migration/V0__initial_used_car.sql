-- DROP SCHEMA IF EXISTS `usedcar`;
-- CREATE SCHEMA `usedcar`;
-- USE `usedcar`;

CREATE TABLE `member` (
  `id` BINARY(16) PRIMARY KEY,
  `nickname` varchar(30),
  `manner_temperature` float default 36.5,
  `rate_of_re_dealing` float default 0.0,
  `response_rate` float default 0.0,
  `client_id` varchar(150) not null,
  `auth_provider` varchar(10) not null,
  `role` varchar(10),
  `refresh_token` varchar(255),
  `created_at` timestamp,
  `updated_at` timestamp,
  `deleted_at` timestamp
);

CREATE TABLE `bookmark_used_car_post` (
  `id` BINARY(16) PRIMARY KEY,
  `post_id` BINARY(16),
  `followed_member_id` BINARY(16),
  `created_at` timestamp,
  `updated_at` timestamp,
  `deleted_at` timestamp
);

CREATE TABLE `matching` (
  `id` BINARY(16) PRIMARY KEY,
  `post_id` BINARY(16) UNIQUE,
  `post_member_id` BINARY(16),
  `match_request_member_id` BINARY(16),
  `status` bool,
  `created_at` timestamp,
  `updated_at` timestamp,
  `deleted_at` timestamp
);

CREATE TABLE `praise` (
  `id` BINARY(16) PRIMARY KEY,
  `member_id` BINARY(16),
  `praiser_id` BINARY(16),
  `praise_type` varchar(50) not null,
  `amount` int,
  `content` tinytext,
  `created_at` timestamp,
  `updated_at` timestamp,
  `deleted_at` timestamp
);

CREATE TABLE `review` (
  `id` BINARY(16) PRIMARY KEY,
  `member_id` BINARY(16),
  `reviewer_id` BINARY(16),
  `content` tinytext,
  `created_at` timestamp,
  `updated_at` timestamp,
  `deleted_at` timestamp
);

CREATE TABLE `badge` (
  `id` BINARY(16) PRIMARY KEY,
  `member_id` BINARY(16),
  `badge_name` varchar(15) not null,
  `is_represent` tinyint(1),
  `created_at` timestamp,
  `updated_at` timestamp,
  `deleted_at` timestamp
);

CREATE TABLE `member_car_selling_post` (
  `id` BINARY(16) PRIMARY KEY,
  `used_car_id` BINARY(16),
  `member_id` BINARY(16),
  `chat` int,
  `focus` int,
  `look` int,
  `introduce` VARCHAR(512),
  `deal_address` VARCHAR(256),
  `created_at` timestamp,
  `updated_at` timestamp,
  `deleted_at` timestamp
);

CREATE TABLE `used_car` (
  `id` BINARY(16) PRIMARY KEY,
  `car_id` BINARY(16),
  `license_number` VARCHAR(256),
  `price` int,
  `save_price` int,
  `insurance_id` BINARY(16),
  `created_at` timestamp,
  `updated_at` timestamp
);

CREATE TABLE `car` (
  `id` BINARY(16) PRIMARY KEY,
  `car_type` VARCHAR(50),
  `company` VARCHAR(50),
  `model_name` VARCHAR(70),
  `grade` VARCHAR(40),
  `grade_detail` VARCHAR(40),
  `year` int,
  `distance` int,
  `displacement` int,
  `fuel_type` VARCHAR(30)
);

CREATE TABLE `insurance`(
  `id` BINARY(16) PRIMARY KEY,
  `is_loss` BOOLEAN ,
  `is_steal` BOOLEAN ,
  `is_water` BOOLEAN ,
  `is_rent` BOOLEAN ,
  `is_sales` BOOLEAN ,
  `is_public` BOOLEAN
);

CREATE TABLE `unsubscribed`(
   `id` BINARY(16) PRIMARY KEY,
   `insurance_id` BINARY(16),
   `start_at` timestamp,
   `end_at` timestamp
);

CREATE TABLE `owner_accident`(
   `id` BINARY(16) PRIMARY KEY,
   `insurance_id` BINARY(16),
   `day` timestamp,
   `part_price` int,
   `wages_price` int,
   `coation_price`int,
   `total_price` int
);

CREATE TABLE `opponent_accident`(
    `id` BINARY(16) PRIMARY KEY,
    `insurance_id` BINARY(16),
    `day` timestamp,
    `part_price` int,
    `wages_price` int,
    `coation_price`int,
    `total_price` int
);

CREATE TABLE `change_owner`(
    `id` BINARY(16) PRIMARY KEY,
    `insurance_id` BINARY(16),
    `change_day` timestamp
);

CREATE TABLE `change_number`(
    `id` BINARY(16) PRIMARY KEY,
    `insurance_id` BINARY(16),
    `change_day` timestamp,
    `change_name` VARCHAR(50),
    `is_first` BOOLEAN
);

CREATE TABLE `post` (
    `id` BINARY(16) PRIMARY KEY,
    `chat` int,
    `focus` int,
    `look` int,
    `introduce` VARCHAR(1000),
    `deal_address` VARCHAR(100),
    `used_car_id` BINARY(16),
    `member_id` BINARY(16)
);

CREATE TABLE `bookmark` (
    `id` BINARY(16) PRIMARY KEY,
    `post_id` BINARY(16),
    `member_id` BINARY(16),
    `created_at` timestamp,
    `updated_at` timestamp,
    `deleted_at` timestamp
);

ALTER TABLE `praise` ADD FOREIGN KEY (`member_id`) REFERENCES `member` (`id`);

ALTER TABLE `praise` ADD FOREIGN KEY (`praiser_id`) REFERENCES `member` (`id`);

ALTER TABLE `review` ADD FOREIGN KEY (`member_id`) REFERENCES `member` (`id`);

ALTER TABLE `review` ADD FOREIGN KEY (`reviewer_id`) REFERENCES `member` (`id`);

ALTER TABLE `badge` ADD FOREIGN KEY (`member_id`) REFERENCES `member` (`id`);

ALTER TABLE `bookmark_used_car_post` ADD FOREIGN KEY (`post_id`) REFERENCES `member_car_selling_post` (`id`);

ALTER TABLE `bookmark_used_car_post` ADD FOREIGN KEY (`followed_member_id`) REFERENCES `member` (`id`);

ALTER TABLE `member_car_selling_post` ADD FOREIGN KEY (`id`) REFERENCES `matching` (`post_id`);

ALTER TABLE `matching` ADD FOREIGN KEY (`post_member_id`) REFERENCES `member` (`id`);

ALTER TABLE `matching` ADD FOREIGN KEY (`match_request_member_id`) REFERENCES `member` (`id`);

ALTER TABLE `member_car_selling_post` ADD FOREIGN KEY (`member_id`) REFERENCES `member` (`id`);

ALTER TABLE `member_car_selling_post` ADD FOREIGN KEY (`used_car_id`) REFERENCES `used_car` (`id`);

ALTER TABLE `used_car` ADD FOREIGN KEY (`car_id`) REFERENCES `car` (`id`);

ALTER TABLE `used_car` ADD FOREIGN KEY (`insurance_id`) REFERENCES `insurance` (id);

ALTER TABLE `unsubscribed` ADD FOREIGN KEY (`insurance_id`) REFERENCES `insurance` (id);

ALTER TABLE `owner_accident` ADD FOREIGN KEY (`insurance_id`) REFERENCES  `insurance` (id);

ALTER TABLE `opponent_accident` ADD FOREIGN KEY (`insurance_id`) REFERENCES `insurance` (id);

ALTER TABLE `change_owner` ADD FOREIGN KEY (`insurance_id`) REFERENCES `insurance` (id);

ALTER TABLE `change_number` ADD FOREIGN KEY (`insurance_id`) REFERENCES  `insurance` (id);
