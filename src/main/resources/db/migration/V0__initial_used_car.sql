-- DROP SCHEMA IF EXISTS `usedcar`;
-- CREATE SCHEMA `usedcar`;
-- USE `usedcar`;

CREATE TABLE `user` (
  `id` VARCHAR(36) PRIMARY KEY,
  `nickname` varchar(30) not null,
  `manner_temperature` float default 36.5,
  `rate_of_redealing` float,
  `response_rate` float,
  `created_at` timestamp,
  `updated_at` timestamp,
  `deleted_at` timestamp
);

CREATE TABLE `bookmark_used_car_post` (
  `id` VARCHAR(36) PRIMARY KEY,
  `post_id` VARCHAR(22),
  `followed_user_id` VARCHAR(22),
  `created_at` timestamp,
  `updated_at` timestamp,
  `deleted_at` timestamp
);

CREATE TABLE `matching` (
  `id` VARCHAR(36) PRIMARY KEY,
  `post_id` VARCHAR(22) UNIQUE,
  `post_user_id` VARCHAR(22),
  `match_request_user_id` VARCHAR(22),
  `status` bool,
  `created_at` timestamp,
  `updated_at` timestamp,
  `deleted_at` timestamp
);

CREATE TABLE `praise` (
  `id` VARCHAR(36) PRIMARY KEY,
  `user_id` VARCHAR(22),
  `praiser_id` VARCHAR(22),
  `praise_type` varchar(50) not null,
  `amount` int,
  `created_at` timestamp,
  `updated_at` timestamp,
  `deleted_at` timestamp
);

CREATE TABLE `review` (
  `id` VARCHAR(36) PRIMARY KEY,
  `user_id` VARCHAR(22),
  `reviewer_id` VARCHAR(22),
  `content` TEXT,
  `created_at` timestamp,
  `updated_at` timestamp,
  `deleted_at` timestamp
);

CREATE TABLE `badge` (
  `id` VARCHAR(36) PRIMARY KEY,
  `user_id` VARCHAR(22),
  `badge_name` varchar(15) not null,
  `is_represent` tinyint(1),
  `created_at` timestamp,
  `updated_at` timestamp,
  `deleted_at` timestamp
);

CREATE TABLE `user_car_selling_post` (
  `id` VARCHAR(36) PRIMARY KEY,
  `car_id` VARCHAR(22),
  `user_id` VARCHAR(22),
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
  `id` VARCHAR(36) PRIMARY KEY,
  `car_id` VARCHAR(22),
  `license_number` VARCHAR(256),
  `price` int,
  `save_price` int,
  `insurance_id` VARCHAR(22),
  `created_at` timestamp,
  `updated_at` timestamp
);

CREATE TABLE `car` (
  `id` VARCHAR(36) PRIMARY KEY,
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
  `id` VARCHAR(36) PRIMARY KEY,
  `is_loss` BOOLEAN ,
  `is_steal` BOOLEAN ,
  `is_water` BOOLEAN ,
  `is_rent` BOOLEAN ,
  `is_sales` BOOLEAN ,
  `is_public` BOOLEAN
);

CREATE TABLE `unsubscribed`(
   `id` VARCHAR(36) PRIMARY KEY,
   `insuracne_id` VARCHAR(22),
   `start_at` timestamp,
   `end_at` timestamp
);

CREATE TABLE `owner_accident`(
   `id` VARCHAR(36) PRIMARY KEY,
   `insuracne_id` VARCHAR(22),
   `day` timestamp,
   `part_price` int,
   `wages_price` int,
   `coation_price`int,
   `total_price` int
);

CREATE TABLE `opponent_accident`(
    `id` VARCHAR(36) PRIMARY KEY,
    `insuracne_id` VARCHAR(22),
    `day` timestamp,
    `part_price` int,
    `wages_price` int,
    `coation_price`int,
    `total_price` int
);

CREATE TABLE `change_owner`(
    `id` VARCHAR(36) PRIMARY KEY,
    `insuracne_id` VARCHAR(22),
    `change_day` timestamp
);

CREATE TABLE `change_number`(
    `id` VARCHAR(36) PRIMARY KEY,
    `insuracne_id` VARCHAR(22),
    `change_day` timestamp,
    `change_name` VARCHAR(50),
    `is_first` BOOLEAN
);


ALTER TABLE `praise` ADD FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

ALTER TABLE `praise` ADD FOREIGN KEY (`praiser_id`) REFERENCES `user` (`id`);

ALTER TABLE `review` ADD FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

ALTER TABLE `review` ADD FOREIGN KEY (`reviewer_id`) REFERENCES `user` (`id`);

ALTER TABLE `badge` ADD FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

ALTER TABLE `bookmark_used_car_post` ADD FOREIGN KEY (`post_id`) REFERENCES `user_car_selling_post` (`id`);

ALTER TABLE `bookmark_used_car_post` ADD FOREIGN KEY (`followed_user_id`) REFERENCES `user` (`id`);

ALTER TABLE `user_car_selling_post` ADD FOREIGN KEY (`id`) REFERENCES `matching` (`post_id`);

ALTER TABLE `matching` ADD FOREIGN KEY (`post_user_id`) REFERENCES `user` (`id`);

ALTER TABLE `matching` ADD FOREIGN KEY (`match_request_user_id`) REFERENCES `user` (`id`);

ALTER TABLE `user_car_selling_post` ADD FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

ALTER TABLE `user_car_selling_post` ADD FOREIGN KEY (`car_id`) REFERENCES `used_car` (`id`);

ALTER TABLE `used_car` ADD FOREIGN KEY (`car_id`) REFERENCES `car` (`id`);

ALTER TABLE `used_car` ADD FOREIGN KEY (`insurance_id`) REFERENCES `insurance` (id);

ALTER TABLE `unsubscribed` ADD FOREIGN KEY (`insuracne_id`) REFERENCES `insurance` (id);

ALTER TABLE `owner_accident` ADD FOREIGN KEY (`insuracne_id`) REFERENCES  `insurance` (id);

ALTER TABLE `opponent_accident` ADD FOREIGN KEY (`insuracne_id`) REFERENCES `insurance` (id);

ALTER TABLE `change_owner` ADD FOREIGN KEY (`insuracne_id`) REFERENCES `insurance` (id);

ALTER TABLE `change_number` ADD FOREIGN KEY (`insuracne_id`) REFERENCES  `insurance` (id);
