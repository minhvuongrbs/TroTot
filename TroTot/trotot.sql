-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th5 12, 2018 lúc 06:34 PM
-- Phiên bản máy phục vụ: 10.1.31-MariaDB
-- Phiên bản PHP: 7.2.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `trotot`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `migrations`
--

CREATE TABLE `migrations` (
  `id` int(10) UNSIGNED NOT NULL,
  `migration` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `batch` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `migrations`
--

INSERT INTO `migrations` (`id`, `migration`, `batch`) VALUES
(1, '2014_10_12_100000_create_password_resets_table', 1),
(2, '2018_04_11_155458_create_permissions_table', 1),
(3, '2018_04_11_155515_create_roles_table', 1),
(4, '2018_04_11_155530_create_role_permissions_table', 1),
(5, '2018_04_11_155541_create_users_table', 1),
(6, '2018_04_11_155551_create_user_roles_table', 1),
(8, '2018_04_25_084337_create_post_rooms_table', 2);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `password_resets`
--

CREATE TABLE `password_resets` (
  `email` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `token` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `permissions`
--

CREATE TABLE `permissions` (
  `id` int(10) UNSIGNED NOT NULL,
  `name` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `post_rooms`
--

CREATE TABLE `post_rooms` (
  `id` int(10) UNSIGNED NOT NULL,
  `user_id` int(10) UNSIGNED NOT NULL,
  `address` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `phone` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `acreage` int(10) UNSIGNED NOT NULL,
  `electric_bill` int(10) UNSIGNED NOT NULL,
  `water_bill` int(10) UNSIGNED NOT NULL,
  `description` longtext COLLATE utf8mb4_unicode_ci,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `post_rooms`
--

INSERT INTO `post_rooms` (`id`, `user_id`, `address`, `phone`, `acreage`, `electric_bill`, `water_bill`, `description`, `created_at`, `updated_at`) VALUES
(1, 2, 'Da nang', '09355555999', 10, 1200, 1500, 'vui vc', '2018-04-26 06:24:20', '2018-04-26 06:24:20'),
(4, 1, '120 dien bien phu', '0913174196', 1200, 12, 12, NULL, '2018-04-26 11:26:45', '2018-04-26 11:26:45'),
(5, 1, '121 xã đan', '0910314347987', 121, 12, 12, NULL, '2018-04-26 12:37:58', '2018-04-26 12:37:58'),
(6, 1, '1314fdaf', '12', 12, 12, 12, NULL, '2018-04-26 12:40:43', '2018-04-26 12:40:43'),
(7, 1, '123', '123', 123, 123, 123, NULL, '2018-04-26 12:46:49', '2018-04-26 12:46:49'),
(8, 1, '1231', '1341411234', 1231, 1231, 1231, NULL, '2018-04-26 12:48:27', '2018-04-26 12:48:27'),
(9, 1, '125 cau giay', '0913174196', 123, 12, 12, NULL, '2018-04-26 12:49:21', '2018-04-26 12:49:21'),
(10, 2, '125 phố cổ', '091314723', 123, 12, 12, NULL, '2018-04-26 12:53:11', '2018-04-26 12:53:11'),
(11, 1, '54 Nguyen Luong Bang', '0913174196', 121, 121, 12, NULL, '2018-04-26 17:40:00', '2018-04-26 17:40:00'),
(12, 3, '123 Thai Phien', '0913174196', 121000, 121, 123, NULL, '2018-04-26 17:50:58', '2018-04-26 17:50:58'),
(13, 1, '50 Ngô Thì Nhậm,quận Liên Chiểu,tp Đà Nẵng', '09355555999', 10, 1200, 1500, 'vui vai ca d', '2018-04-26 17:56:14', '2018-04-26 17:56:14'),
(14, 4, '123 Hoa Cuong', '121', 123, 121, 121, 'mi', '2018-04-26 18:01:50', '2018-04-26 18:01:50'),
(15, 4, '64 Nguyen Luong Bang', '0913145323', 120000, 12, 12, 'free wifi', '2018-04-26 18:06:48', '2018-04-26 18:06:48'),
(16, 5, '121 pho co', '0924384731', 121, 12, 12, 'wifi gia re', '2018-04-27 01:10:52', '2018-04-27 01:10:52'),
(17, 3, '124', '123453134', 12, 12, 12, 'dfa', '2018-05-02 13:02:51', '2018-05-02 13:02:51');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `roles`
--

CREATE TABLE `roles` (
  `id` int(10) UNSIGNED NOT NULL,
  `name` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `role_permissions`
--

CREATE TABLE `role_permissions` (
  `role_id` int(10) UNSIGNED NOT NULL,
  `permission_id` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `users`
--

CREATE TABLE `users` (
  `id` int(10) UNSIGNED NOT NULL,
  `is_admin` tinyint(1) NOT NULL DEFAULT '0',
  `name` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `username` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `address` varchar(191) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `phone` varchar(191) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `image` varchar(191) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `email` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `remember_token` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `users`
--

INSERT INTO `users` (`id`, `is_admin`, `name`, `username`, `address`, `phone`, `image`, `email`, `password`, `remember_token`, `created_at`, `updated_at`) VALUES
(1, 1, 'Vuong', 'admin', 'danang', '093550898', NULL, 'admin@gmail.com', '$2y$10$MDQ8CS7fcRnOaV7.YOKP8uiM.hrV5qHxYK7ig2U5Tc.9MRon4EKRK', NULL, '2018-04-15 01:17:20', '2018-04-15 01:17:20'),
(2, 0, 'Vuong', 'admin2', 'danang', '093550898', NULL, 'admin2@gmail.com', '$2y$10$QH79oZknu/VBR5x.MuU8OueOv33kcJS5nkbJhFHV8b.1qnu0gVBIa', NULL, '2018-04-15 01:35:53', '2018-04-15 01:35:53'),
(3, 0, 'Minh Vương MF4', 'minhvuong.mf4', 'da nang', '0935987654', NULL, 'mv@gmail.com', '$2y$10$d/meMN9OOeCuwDwzUIOp/OGVKMqTxWN68d.8nDDtn1KwjxWFDXYy2', NULL, '2018-04-26 17:48:15', '2018-04-26 17:48:15'),
(4, 0, 'Nghia Nguyen MF4', 'nghianguyen.mf4', 'da nang', '0935666777', NULL, 'ngng@gmail.com', '$2y$10$ET/fj3ohCq3W37xZKP.DneAoxNUjX3HUySgbJw.6yZ8jF9i3VD/yG', NULL, '2018-04-26 17:48:59', '2018-04-26 17:48:59'),
(5, 0, 'Nam Nguyen MF4', 'guen.tnamu.dnc', 'da nang', '0935666888', NULL, 'namnguyen@gmail.com', '$2y$10$yQMv5/oGFKW7olfwvA01mue1XZ0/4Qm6R6bk4VRpPjSiyxZvVDujm', NULL, '2018-04-26 17:49:41', '2018-04-26 17:49:41');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user_roles`
--

CREATE TABLE `user_roles` (
  `user_id` int(10) UNSIGNED NOT NULL,
  `is_admin` tinyint(1) NOT NULL DEFAULT '0',
  `role_id` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `migrations`
--
ALTER TABLE `migrations`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `password_resets`
--
ALTER TABLE `password_resets`
  ADD KEY `password_resets_email_index` (`email`);

--
-- Chỉ mục cho bảng `permissions`
--
ALTER TABLE `permissions`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `permissions_name_unique` (`name`);

--
-- Chỉ mục cho bảng `post_rooms`
--
ALTER TABLE `post_rooms`
  ADD PRIMARY KEY (`id`),
  ADD KEY `post_rooms_user_id_foreign` (`user_id`);

--
-- Chỉ mục cho bảng `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `roles_name_unique` (`name`);

--
-- Chỉ mục cho bảng `role_permissions`
--
ALTER TABLE `role_permissions`
  ADD PRIMARY KEY (`role_id`,`permission_id`),
  ADD KEY `role_permissions_permission_id_foreign` (`permission_id`);

--
-- Chỉ mục cho bảng `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `users_username_unique` (`username`),
  ADD UNIQUE KEY `users_email_unique` (`email`);

--
-- Chỉ mục cho bảng `user_roles`
--
ALTER TABLE `user_roles`
  ADD PRIMARY KEY (`user_id`,`role_id`),
  ADD KEY `user_roles_role_id_foreign` (`role_id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `migrations`
--
ALTER TABLE `migrations`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT cho bảng `permissions`
--
ALTER TABLE `permissions`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `post_rooms`
--
ALTER TABLE `post_rooms`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT cho bảng `roles`
--
ALTER TABLE `roles`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `users`
--
ALTER TABLE `users`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `post_rooms`
--
ALTER TABLE `post_rooms`
  ADD CONSTRAINT `post_rooms_user_id_foreign` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE;

--
-- Các ràng buộc cho bảng `role_permissions`
--
ALTER TABLE `role_permissions`
  ADD CONSTRAINT `role_permissions_permission_id_foreign` FOREIGN KEY (`permission_id`) REFERENCES `permissions` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `role_permissions_role_id_foreign` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`) ON DELETE CASCADE;

--
-- Các ràng buộc cho bảng `user_roles`
--
ALTER TABLE `user_roles`
  ADD CONSTRAINT `user_roles_role_id_foreign` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `user_roles_user_id_foreign` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
