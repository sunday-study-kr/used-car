CREATE TABLE `user` (
  `id` VARCHAR(22) PRIMARY KEY,
  `nickname` string,
  `manner_temperature` string,
  `response_rate` flaot,
  `created_at` timestamp,
  `updated_at` timestamp,
  `deleted_at` timestamp
);

CREATE TABLE `bookmark_used_car_post` (
  `id` VARCHAR(22) PRIMARY KEY,
  `post_id` string,
  `followed_user_id` string,
  `created_at` timestamp,
  `updated_at` timestamp,
  `deleted_at` timestamp
);

CREATE TABLE `matching` (
  `id` VARCHAR(22) PRIMARY KEY,
  `post_id` string,
  `post_user_id` string,
  `match_request_user_id` string,
  `status` string,
  `created_at` timestamp,
  `updated_at` timestamp,
  `deleted_at` timestamp
);

CREATE TABLE `praise` (
  `id` VARCHAR(22) PRIMARY KEY,
  `user_id` VARCHAR(22),
  `praiser_id` VARCHAR(22),
  `praiser_type` VARCHAR(22),
  `amount` int
);

CREATE TABLE `review` (
  `id` VARCHAR(22) PRIMARY KEY,
  `user_id` VARCHAR(22),
  `reviewee` VARCHAR(22),
  `content` TEXT
);

CREATE TABLE `badge` (
  `id` VARCHAR(22) PRIMARY KEY,
  `name` string
);

CREATE TABLE `user_badge` (
  `id` VARCHAR(22) PRIMARY KEY,
  `user_id` string,
  `badge_id` string
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

ALTER TABLE `user` ADD FOREIGN KEY (`id`) REFERENCES `review` (`user_id`);

ALTER TABLE `badge` ADD FOREIGN KEY (`id`) REFERENCES `user_badge` (`badge_id`);

ALTER TABLE `user_badge` ADD FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

ALTER TABLE `bookmark_used_car_post` ADD FOREIGN KEY (`post_id`) REFERENCES `user_car_selling_post` (`id`);

ALTER TABLE `bookmark_used_car_post` ADD FOREIGN KEY (`followed_user_id`) REFERENCES `user` (`id`);

ALTER TABLE `user_car_selling_post` ADD FOREIGN KEY (`id`) REFERENCES `matching` (`post_id`);

ALTER TABLE `matching` ADD FOREIGN KEY (`post_user_id`) REFERENCES `user` (`id`);

ALTER TABLE `matching` ADD FOREIGN KEY (`match_request_user_id`) REFERENCES `user` (`id`);

ALTER TABLE `user_car_selling_post` ADD FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

ALTER TABLE `user_car_selling_post` ADD FOREIGN KEY (`car_id`) REFERENCES `used_car` (`id`);

ALTER TABLE `used_car` ADD FOREIGN KEY (`car_id`) REFERENCES `car` (`id`);
