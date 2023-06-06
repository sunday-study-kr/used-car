-- DROP SCHEMA IF EXISTS `usedcar`;
-- CREATE SCHEMA `usedcar`;
-- USE `usedcar`;

CREATE TABLE `user` (
  `id` VARCHAR(22) PRIMARY KEY,
  `nickname` varchar(30) not null,
  `manner_temperature` float default 36.5,
  `rate_of_redealing` float,
  `response_rate` float,
  `created_at` timestamp,
  `updated_at` timestamp,
  `deleted_at` timestamp
);

CREATE TABLE `bookmark_used_car_post` (
  `id` VARCHAR(22) PRIMARY KEY,
  `post_id` VARCHAR(22),
  `followed_user_id` VARCHAR(22),
  `created_at` timestamp,
  `updated_at` timestamp,
  `deleted_at` timestamp
);

CREATE TABLE `matching` (
  `id` VARCHAR(22) PRIMARY KEY,
  `post_id` VARCHAR(22),
  `post_user_id` VARCHAR(22),
  `match_request_user_id` VARCHAR(22),
  `status` string,
  `created_at` timestamp,
  `updated_at` timestamp,
  `deleted_at` timestamp
);

CREATE TABLE `praise` (
  `id` VARCHAR(22) PRIMARY KEY,
  `user_id` VARCHAR(22),
  `praiser_id` VARCHAR(22),
  `praise_type` varchar(50) not null,
  `amount` int,
  `created_at` timestamp,
  `updated_at` timestamp,
  `deleted_at` timestamp
);

CREATE TABLE `review` (
  `id` VARCHAR(22) PRIMARY KEY,
  `user_id` VARCHAR(22),
  `reviewer_id` VARCHAR(22),
  `content` TEXT,
  `created_at` timestamp,
  `updated_at` timestamp,
  `deleted_at` timestamp
);

CREATE TABLE `badge` (
  `id` VARCHAR(22) PRIMARY KEY,
  `user_id` VARCHAR(22),
  `badge_name` varchar(15) not null,
  `is_represent` tinyint(1),
  `created_at` timestamp,
  `updated_at` timestamp,
  `deleted_at` timestamp
);

CREATE TABLE `user_car_selling_post` (
  `id` VARCHAR(22) PRIMARY KEY,
  `car_id` VARCHAR(22),
  `user_id` VARCHAR(22),
  `chat` int,
  `focus` int,
  `look` int,
  `introduce` string,
  `deal_address` string,
  `created_at` timestamp,
  `updated_at` timestamp,
  `deleted_at` timestamp
);

CREATE TABLE `used_car` (
  `id` VARCHAR(22) PRIMARY KEY,
  `car_id` VARCHAR(22),
  `license_number` string,
  `price` int,
  `save_price` int,
  `distance` bigint,
  `created_at` timestamp,
  `updated_at` timestamp
);

CREATE TABLE `car` (
  `id` VARCHAR(22) PRIMARY KEY,
  `car_type` string,
  `manufacturer` strig,
  `model_name` string,
  `year` int,
  `displacement` int,
  `fuel_type` string
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
