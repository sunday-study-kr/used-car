-- DROP SCHEMA IF EXISTS `usedcar`;
-- CREATE SCHEMA `usedcar`;
-- USE `usedcar`;

CREATE TABLE `user` (
  `id` bigint PRIMARY KEY,
  `nickname` varchar(30) not null,
  `manner_temperature` float default 36.5,
  `rate_of_redealing` float,
  `response_rate` float,
  `created_at` timestamp,
  `updated_at` timestamp,
  `deleted_at` timestamp
);

CREATE TABLE `bookmark_used_car_post` (
  `id` bigint PRIMARY KEY,
  `post_id` string,
  `followed_user_id` string,
  `created_at` timestamp,
  `updated_at` timestamp,
  `deleted_at` timestamp
);

CREATE TABLE `matching` (
  `id` bigint PRIMARY KEY,
  `post_id` string,
  `post_user_id` string,
  `match_request_user_id` string,
  `status` string,
  `created_at` timestamp,
  `updated_at` timestamp,
  `deleted_at` timestamp
);

CREATE TABLE `praise` (
  `id` bigint PRIMARY KEY,
  `user_id` bigint,
  `praiser_id` bigint,
  `praise_type` varchar(50) not null,
  `amount` int,
  `created_at` timestamp,
  `updated_at` timestamp,
  `deleted_at` timestamp
);

CREATE TABLE `review` (
  `id` bigint PRIMARY KEY,
  `user_id` bigint,
  `reviewer_id` bigint,
  `content` TEXT,
  `created_at` timestamp,
  `updated_at` timestamp,
  `deleted_at` timestamp
);

CREATE TABLE `badge` (
  `id` bigint PRIMARY KEY,
  `user_id` bigint,
  `badge_name` varchar(15) not null,
  `is_represent` tinyint(1),
  `created_at` timestamp,
  `updated_at` timestamp,
  `deleted_at` timestamp
);

CREATE TABLE `user_car_selling_post` (
  `id` bigint PRIMARY KEY,
  `car_id` bigint,
  `user_id` bigint,
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
  `id` bigint PRIMARY KEY,
  `car_id` bigint,
  `license_number` string,
  `price` int,
  `save_price` int,
  `distance` bigint,
  `created_at` timestamp,
  `updated_at` timestamp
);

CREATE TABLE `car` (
  `id` bigint PRIMARY KEY,
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
