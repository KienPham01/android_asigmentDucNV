-- phpMyAdmin SQL Dump
-- version 4.8.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 05, 2018 at 05:42 AM
-- Server version: 10.1.33-MariaDB
-- PHP Version: 7.2.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `quanlysinhvien`
--

-- --------------------------------------------------------

--
-- Table structure for table `diem`
--

CREATE TABLE `diem` (
  `id` int(11) NOT NULL,
  `maSV` varchar(150) NOT NULL,
  `HoTen` varchar(150) NOT NULL,
  `monThuNhat` varchar(150) NOT NULL,
  `monThuHai` varchar(150) NOT NULL,
  `monThuBa` varchar(150) NOT NULL,
  `diemMonThuNhat` double NOT NULL,
  `diemMonThuHai` double NOT NULL,
  `diemMonThuBa` double NOT NULL,
  `diemTB` double NOT NULL,
  `linkanh` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `diem`
--

INSERT INTO `diem` (`id`, `maSV`, `HoTen`, `monThuNhat`, `monThuHai`, `monThuBa`, `diemMonThuNhat`, `diemMonThuHai`, `diemMonThuBa`, `diemTB`, `linkanh`) VALUES
(1, 'PD01901', 'Bùi Việt Phi', 'Android Sever', 'Game 2D', 'Java3', 9, 9, 9, 9, 'https://4.bp.blogspot.com/--ZnDpzkIC4k/WqiiJSbTEyI/AAAAAAAAAHk/QZ1-yxi6itsGzATD1BIGb9hw58yoLbSDwCLcBGAs/s320/20229574_400336490363031_6375046387848197'),
(10, 'PD9988', 'Bành Thị Lộ Liễu', 'Android', 'Java', 'KNLV', 8, 9, 9, 8.666666666666666, 'https://i.pinimg.com/736x/41/6f/c9/416fc91d496ed8bcc3c05c9bdcb80119.jpg'),
(11, 'PD8854', 'Mạc Thị Lời', 'Android', 'PHP', 'JavaScript', 8.5, 8.9, 9, 8.799999999999999, 'http://s1.img.yan.vn/YanNews/2167221/201603/20160311-110542-14576216794241_600x390.jpg'),
(14, 'PD7744', 'Khổng Minh Đức', 'Android', 'Java', 'PHP', 9, 8.5, 8, 8.5, 'https://1.bp.blogspot.com/-i8a7cRNX0Fo/WyozgVU9uhI/AAAAAAAAAJA/HM25D9b0ZcwNbRFm6R987X4TMP_EHBb6QCLcBGAs/s320/duc.jpg'),
(15, 'PD0998', 'Trần Hoàng Lâm', 'Android', 'PHP', 'JavaScrpit', 9, 9, 8.5, 8.833333333333334, 'https://4.bp.blogspot.com/-T7BRFJa9H6E/Wyo1HXYqkFI/AAAAAAAAAJQ/hXV-CHMPymkhEz1lJhQ7aXCAHiKmRjO2ACLcBGAs/s320/lam.jpg'),
(16, 'PD0998', 'Trần Hoàng Lâm', 'Androi', 'PHP', 'Java', 9, 8, 7, 8, 'https://4.bp.blogspot.com/-T7BRFJa9H6E/Wyo1HXYqkFI/AAAAAAAAAJQ/hXV-CHMPymkhEz1lJhQ7aXCAHiKmRjO2ACLcBGAs/s320/lam.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `sinhvien`
--

CREATE TABLE `sinhvien` (
  `id` int(11) NOT NULL,
  `maSV` varchar(150) NOT NULL,
  `HoTen` varchar(150) NOT NULL,
  `GioiTinh` varchar(150) NOT NULL,
  `Lop` varchar(150) NOT NULL,
  `HinhAnh` varchar(200) NOT NULL,
  `NamSinh` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `sinhvien`
--

INSERT INTO `sinhvien` (`id`, `maSV`, `HoTen`, `GioiTinh`, `Lop`, `HinhAnh`, `NamSinh`) VALUES
(1, 'PD9988', 'Bành Thị Lộ Liểu', 'Nữ', '1221 - PA', 'https://i.pinimg.com/736x/41/6f/c9/416fc91d496ed8bcc3c05c9bdcb80119.jpg', '11/12/1998'),
(2, 'PD01901', 'Bùi Việt Phi', 'Nam', '12303 - MOB', 'https://4.bp.blogspot.com/--ZnDpzkIC4k/WqiiJSbTEyI/AAAAAAAAAHk/QZ1-yxi6itsGzATD1BIGb9hw58yoLbSDwCLcBGAs/s320/20229574_400336490363031_6375046387848197', '20/05/1998'),
(3, 'PD0998', 'Trần Hoàng Lâm', 'Nam', '12303 - MOB', 'https://4.bp.blogspot.com/-T7BRFJa9H6E/Wyo1HXYqkFI/AAAAAAAAAJQ/hXV-CHMPymkhEz1lJhQ7aXCAHiKmRjO2ACLcBGAs/s320/lam.jpg', '25/07/1998'),
(4, 'PD7744', 'Khổng Minh Đức', 'Nam', '12303 - MOB', 'https://1.bp.blogspot.com/-i8a7cRNX0Fo/WyozgVU9uhI/AAAAAAAAAJA/HM25D9b0ZcwNbRFm6R987X4TMP_EHBb6QCLcBGAs/s320/duc.jpg', '11/04/1997'),
(5, 'PD8844', 'Nguyễn Văn Tý', 'Nam', '12303 - MOB', 'https://4.bp.blogspot.com/-XEmSvVAYnBc/Wyo8vOTlkfI/AAAAAAAAAJg/AYj31AXKWJQlavF0XX2a_016p8ebRsXNQCLcBGAs/s320/ty.jpg', '22/07/1996'),
(6, 'PD88855', 'Nguyễn Thị Long Xuyên', 'Nữ', '1221 - PA', 'http://gocbao.com/wp-content/uploads/2017/11/hinh-anh-hot-girl-de-thuong-19.jpg', '11/04/1998'),
(8, 'PD8854', 'Mạc Thị Lời', 'Nữ', '1225 - PA', 'http://s1.img.yan.vn/YanNews/2167221/201603/20160311-110542-14576216794241_600x390.jpg', '17/12/1996'),
(9, 'PD95', 'Tà Cù Lanh', 'Nam', '1226 - PI', 'http://tayduky.info/wp-content/uploads/2017/09/nhung-hinh-anh-loc-ham-luhan-dep-lung-linh.jpg', '19/7/1995');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `unique_id` varchar(23) NOT NULL,
  `name` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `encrypted_password` varchar(80) NOT NULL,
  `salt` varchar(10) NOT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `unique_id`, `name`, `email`, `encrypted_password`, `salt`, `created_at`, `updated_at`) VALUES
(2, '5b77d04975d2f0.17172222', 'bui viet phi', 'phideptrai@gmail.com', 'liEMg8fZ0EB1b3igiUluWHjB5U1jNTJhMjBlOGE0', 'c52a20e8a4', '2018-08-18 14:52:41', NULL),
(3, '5b77d128a0c3d2.01144736', 'phi dep trai', 'buivietphi@gmail.com', 'WFfaWz9jy7NQmYL8pzuLXc+fkWw1NDkwYjU0NjNj', '5490b5463c', '2018-08-18 14:56:24', NULL),
(4, '5b7b74033a8672.68217872', 'Phi Tit', 'phitit@gmail.com', 'C77p+uVP5psxub6Wqt1TZLOZx5wzMThiN2ZiNzRj', '318b7fb74c', '2018-08-21 09:08:03', NULL),
(5, '5b7bc8218b2860.89555443', 'Bui viet phi', 'phibvpd01901@fpt.edu.vn', 'jm5UttOLQMxeldQT5RM4QrIGL7Q1ZGQ1NDQ2YjNj', '5dd5446b3c', '2018-08-21 15:06:57', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `diem`
--
ALTER TABLE `diem`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `sinhvien`
--
ALTER TABLE `sinhvien`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `unique_id` (`unique_id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `diem`
--
ALTER TABLE `diem`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `sinhvien`
--
ALTER TABLE `sinhvien`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
