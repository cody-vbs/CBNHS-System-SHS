-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 23, 2021 at 05:00 AM
-- Server version: 10.4.19-MariaDB
-- PHP Version: 8.0.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `final_cbnhs_db`
--

DELIMITER $$
--
-- Functions
--
CREATE DEFINER=`root`@`localhost` FUNCTION `getLastDay` (`dateEntered` DATE) RETURNS VARCHAR(25) CHARSET latin1 RETURN LAST_DAY(dateEntered)$$

CREATE DEFINER=`root`@`localhost` FUNCTION `getStartingDay` (`dateEntered` DATE) RETURNS VARCHAR(25) CHARSET latin1 RETURN DAYNAME(dateEntered)$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `attendance`
--

CREATE TABLE `attendance` (
  `id` int(11) NOT NULL,
  `studentId` int(11) NOT NULL,
  `sectionId` int(11) NOT NULL,
  `subjectId` int(11) NOT NULL DEFAULT 0,
  `status` varchar(10) NOT NULL DEFAULT 'Present',
  `dateAdded` datetime NOT NULL,
  `notes` varchar(1000) NOT NULL DEFAULT ' '
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `attendance`
--

INSERT INTO `attendance` (`id`, `studentId`, `sectionId`, `subjectId`, `status`, `dateAdded`, `notes`) VALUES
(1, 13, 4, 68, 'Absent', '2021-09-29 09:34:50', ' '),
(2, 18, 4, 68, 'Present', '2021-09-29 09:34:50', 'LC:10 minutes late'),
(3, 20, 4, 68, 'Present', '2021-09-29 09:34:50', ' '),
(4, 9, 4, 68, 'Present', '2021-09-29 09:34:50', ' '),
(5, 16, 4, 68, 'Present', '2021-09-29 09:34:50', ' '),
(6, 10, 4, 68, 'Tardy', '2021-09-29 09:34:50', ' '),
(7, 14, 4, 68, 'Present', '2021-09-29 09:34:50', ' '),
(8, 19, 4, 68, 'Present', '2021-09-29 09:34:50', ' '),
(9, 17, 4, 68, 'Present', '2021-09-29 09:34:50', ' '),
(10, 15, 4, 68, 'Present', '2021-09-29 09:34:50', ' '),
(11, 11, 4, 68, 'Present', '2021-09-29 09:34:50', ' '),
(12, 8, 4, 68, 'Present', '2021-09-29 09:34:50', ' '),
(13, 7, 4, 68, 'Present', '2021-09-29 09:34:50', ' '),
(14, 23, 4, 68, 'Present', '2021-09-29 09:34:50', ' '),
(15, 4, 4, 68, 'Present', '2021-09-29 09:34:50', ' '),
(16, 5, 4, 68, 'Present', '2021-09-29 09:34:50', ' '),
(17, 22, 4, 68, 'Present', '2021-09-29 09:34:50', ' '),
(18, 6, 4, 68, 'Present', '2021-09-29 09:34:50', ' '),
(19, 3, 4, 68, 'Present', '2021-09-29 09:34:50', ' '),
(20, 12, 4, 68, 'Present', '2021-09-29 09:34:50', ' '),
(21, 21, 4, 68, 'Present', '2021-09-29 09:34:50', ' ');

-- --------------------------------------------------------

--
-- Table structure for table `bmi`
--

CREATE TABLE `bmi` (
  `id` int(11) NOT NULL,
  `studentId` int(11) NOT NULL,
  `sectionId` int(11) NOT NULL,
  `age` varchar(10) NOT NULL DEFAULT 'Unmeasured',
  `weight` int(11) NOT NULL DEFAULT 0,
  `height` double NOT NULL DEFAULT 0,
  `heightSq` varchar(20) NOT NULL DEFAULT '0',
  `bmi` float NOT NULL DEFAULT 0,
  `bmiForAge` varchar(20) NOT NULL DEFAULT 'Unmeasured',
  `heightForAge` varchar(20) NOT NULL DEFAULT 'Unmeasured',
  `dateExamined` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bmi`
--

INSERT INTO `bmi` (`id`, `studentId`, `sectionId`, `age`, `weight`, `height`, `heightSq`, `bmi`, `bmiForAge`, `heightForAge`, `dateExamined`) VALUES
(1, 13, 4, '16: 11', 42, 1.6, '2.5600', 16.4, 'Wasted', 'Normal', '2021-09-29 00:00:00'),
(2, 20, 4, 'Unmeasured', 0, 0, '0', 0, 'Unmeasured', 'Unmeasured', '2021-09-29 10:28:29'),
(3, 7, 4, 'Unmeasured', 0, 0, '0', 0, 'Unmeasured', 'Unmeasured', '2021-09-29 10:29:09'),
(4, 8, 4, '16: 11', 45, 1.6, '2.5600', 17.5, 'Normal', 'Normal', '2021-09-29 00:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `bmichart_female`
--

CREATE TABLE `bmichart_female` (
  `id` int(11) NOT NULL,
  `yearMonth` varchar(10) NOT NULL,
  `months` int(11) NOT NULL,
  `swTo` double NOT NULL,
  `wsTo` double NOT NULL,
  `nrmTo` double NOT NULL,
  `ovwTo` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bmichart_female`
--

INSERT INTO `bmichart_female` (`id`, `yearMonth`, `months`, `swTo`, `wsTo`, `nrmTo`, `ovwTo`) VALUES
(1, '11: 0', 132, 12.7, 13.9, 23.7, 30.2),
(2, '11: 1', 133, 12.8, 13.9, 23.8, 30.3),
(3, '11: 2', 134, 12.8, 14, 23.9, 30.5),
(4, '11: 3', 135, 12.8, 14, 24, 30.6),
(5, '11: 4', 136, 12.9, 14, 24.1, 30.8),
(6, '11: 5', 137, 12.9, 14.1, 24.2, 30.9),
(7, '11: 6', 138, 12.9, 14.1, 24.3, 31.1),
(8, '11: 7', 139, 13, 14.2, 24.4, 31.2),
(9, '11: 8', 140, 13, 14.2, 24.5, 31.4),
(10, '11: 9', 141, 13, 14.3, 24.7, 31.5),
(11, '11: 10', 142, 13.1, 14.3, 24.8, 31.6),
(12, '11: 11', 143, 13.1, 14.3, 24.9, 31.8),
(13, '12: 0', 144, 13.2, 14.4, 25, 31.9),
(14, '12: 1', 145, 13.2, 14.4, 25.1, 32),
(15, '12: 2', 146, 13.2, 14.5, 25.2, 32.2),
(16, '12: 3', 147, 13.3, 14.5, 25.3, 32.3),
(17, '12: 4', 148, 13.3, 14.6, 25.4, 32.4),
(18, '12: 5', 149, 13.3, 14.6, 25.5, 32.6),
(19, '12: 6', 150, 13.4, 14.7, 25.6, 32.7),
(20, '12: 7', 151, 13.4, 14.7, 25.7, 32.8),
(21, '12: 8', 152, 13.5, 14.8, 25.8, 33),
(22, '12: 9', 153, 13.5, 14.8, 25.9, 33.1),
(23, '12: 10', 154, 13.5, 14.8, 26, 33.2),
(24, '12: 11', 155, 13.6, 14.9, 26.1, 33.3),
(25, '13: 0', 156, 13.6, 14.9, 26.2, 33.4),
(26, '13: 1', 157, 13.6, 15, 26.3, 33.6),
(27, '13: 2', 158, 13.7, 15, 26.4, 33.7),
(28, '13: 3', 159, 13.7, 15.1, 26.5, 33.8),
(29, '13: 4', 160, 13.8, 15.1, 26.6, 33.9),
(30, '13: 5', 161, 13.8, 15.2, 26.7, 34),
(31, '13: 6', 162, 13.8, 15.2, 26.8, 34.1),
(32, '13: 7', 163, 13.9, 15.2, 26.9, 34.2),
(33, '13: 8', 164, 13.9, 15.3, 27, 34.3),
(34, '13: 9', 165, 13.9, 15.3, 27.1, 34.4),
(35, '13: 10', 166, 14, 15.4, 27.1, 34.5),
(36, '13: 11', 167, 14, 15.4, 27.2, 34.6),
(37, '14: 0', 168, 14, 15.4, 27.3, 34.7),
(38, '14: 1', 169, 14.1, 15.5, 27.4, 34.7),
(39, '14: 2', 170, 14.1, 15.5, 27.5, 34.8),
(40, '14: 3', 171, 14.1, 15.6, 27.6, 34.9),
(41, '14: 4', 172, 14.1, 15.6, 27.7, 35),
(42, '14: 5', 173, 14.2, 15.6, 27.7, 35.1),
(43, '14: 6', 174, 14.2, 15.7, 27.8, 35.1),
(44, '14: 7', 175, 14.2, 15.7, 27.9, 35.2),
(45, '14: 8', 176, 14.3, 15.7, 28, 35.3),
(46, '14: 9', 177, 14.3, 15.8, 28, 35.4),
(47, '14: 10', 178, 14.3, 15.8, 28.1, 35.4),
(48, '14: 11', 179, 14.3, 15.8, 28.2, 35.5),
(49, '15: 0', 180, 14.4, 15.9, 28.2, 35.5),
(50, '15: 1', 181, 14.4, 15.9, 28.3, 35.6),
(51, '15: 2', 182, 14.4, 15.9, 28.4, 35.7),
(52, '15: 3', 183, 14.4, 16, 28.4, 35.7),
(53, '15: 4', 184, 14.5, 16, 28.5, 35.8),
(54, '15: 5', 185, 14.5, 16, 28.5, 35.8),
(55, '15: 6', 186, 14.5, 16, 28.6, 35.8),
(56, '15: 7', 187, 14.5, 16.1, 28.6, 35.9),
(57, '15: 8', 188, 14.5, 16.1, 28.7, 35.9),
(58, '15: 9', 189, 14.5, 16.1, 28.7, 36),
(59, '15: 10', 190, 14.6, 16.1, 28.8, 36),
(60, '15: 11', 191, 14.6, 16.2, 28.8, 36),
(61, '16: 0', 192, 14.6, 16.2, 28.9, 36.1),
(62, '16: 1', 193, 14.6, 16.2, 28.9, 36.1),
(63, '16: 2', 194, 14.6, 16.2, 29, 36.1),
(64, '16: 3', 195, 14.6, 16.2, 29, 36.1),
(65, '16: 4', 196, 14.6, 16.2, 29, 36.2),
(66, '16: 5', 197, 14.6, 16.3, 29.1, 36.2),
(67, '16: 6', 198, 14.7, 16.3, 29.1, 36.2),
(68, '16: 7', 199, 14.7, 16.3, 29.1, 36.2),
(69, '16: 8', 200, 14.7, 16.3, 29.2, 36.2),
(70, '16: 9', 201, 14.7, 16.3, 29.2, 36.3),
(71, '16: 10', 202, 14.7, 16.3, 29.2, 36.3),
(72, '16: 11', 203, 14.7, 16.3, 29.3, 36.3),
(73, '17: 0', 204, 14.7, 16.4, 29.3, 36.3),
(74, '17: 1', 205, 14.7, 16.4, 29.3, 36.3),
(75, '17: 2', 206, 14.7, 16.4, 29.3, 36.3),
(76, '17: 3', 207, 14.7, 16.4, 29.4, 36.3),
(77, '17: 4', 208, 14.7, 16.4, 29.4, 36.3),
(78, '17: 5', 209, 14.7, 16.4, 29.4, 36.3),
(79, '17: 6', 210, 14.7, 16.4, 29.4, 36.3),
(80, '17: 7', 211, 14.7, 16.4, 29.4, 36.3),
(81, '17: 8', 212, 14.7, 16.4, 29.5, 36.3),
(82, '17: 9', 213, 14.7, 16.4, 29.5, 36.3),
(83, '17: 10', 214, 14.7, 16.4, 29.5, 36.3),
(84, '17: 11', 215, 14.7, 16.4, 29.5, 36.3),
(85, '18: 0', 216, 14.7, 16.4, 29.5, 36.3),
(86, '18: 1', 217, 14.7, 16.5, 29.5, 36.3),
(87, '18: 2', 218, 14.7, 16.5, 29.6, 36.3),
(88, '18: 3', 219, 14.7, 16.5, 29.6, 36.3),
(89, '18: 4', 220, 14.7, 16.5, 29.6, 36.3),
(90, '18: 5', 221, 14.7, 16.5, 29.6, 36.2),
(91, '18: 6', 222, 14.7, 16.5, 29.6, 36.2),
(92, '18: 7', 223, 14.7, 16.5, 29.6, 36.2),
(93, '18: 8', 224, 14.7, 16.5, 29.6, 36.2),
(94, '18: 9', 225, 14.7, 16.5, 29.6, 36.2),
(95, '18: 10', 226, 14.7, 16.5, 29.6, 36.2),
(96, '18: 11', 227, 14.7, 16.5, 29.7, 36.2),
(97, '19: 0', 228, 14.7, 16.5, 29.7, 36.2);

-- --------------------------------------------------------

--
-- Table structure for table `bmichart_male`
--

CREATE TABLE `bmichart_male` (
  `id` int(11) NOT NULL,
  `yearMonth` varchar(10) NOT NULL,
  `months` int(11) NOT NULL,
  `swTo` double NOT NULL,
  `wsTo` double NOT NULL,
  `nrmTo` double NOT NULL,
  `ovwTo` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bmichart_male`
--

INSERT INTO `bmichart_male` (`id`, `yearMonth`, `months`, `swTo`, `wsTo`, `nrmTo`, `ovwTo`) VALUES
(1, '11: 0', 132, 13.1, 14.1, 22.5, 28),
(2, '11: 1', 133, 13.1, 14.1, 22.5, 28.2),
(3, '11: 2', 134, 13.1, 14.1, 22.6, 28.4),
(4, '11: 3', 135, 13.1, 14.1, 22.7, 28.5),
(5, '11: 4', 136, 13.2, 14.2, 22.8, 28.7),
(6, '11: 5', 137, 13.2, 14.2, 22.9, 28.8),
(7, '11: 6', 138, 13.2, 14.2, 23, 29),
(8, '11: 7', 139, 13.2, 14.3, 23.1, 29.2),
(9, '11: 8', 140, 13.3, 14.3, 23.2, 29.3),
(10, '11: 9', 141, 13.3, 14.3, 23.3, 29.5),
(11, '11: 10', 142, 13.3, 14.4, 23.4, 29.6),
(12, '11: 11', 143, 13.4, 14.4, 23.5, 29.8),
(13, '12: 0', 144, 13.4, 14.5, 23.6, 30),
(14, '12: 1', 145, 13.4, 14.5, 23.7, 30.1),
(15, '12: 2', 146, 13.5, 14.5, 23.8, 30.3),
(16, '12: 3', 147, 13.5, 14.6, 23.9, 30.4),
(17, '12: 4', 148, 13.5, 14.6, 24, 30.6),
(18, '12: 5', 149, 13.6, 14.6, 24.1, 30.7),
(19, '12: 6', 150, 13.6, 14.7, 24.2, 30.9),
(20, '12: 7', 151, 13.6, 14.7, 24.3, 31),
(21, '12: 8', 152, 13.7, 14.8, 24.4, 31.1),
(22, '12: 9', 153, 13.7, 14.8, 24.5, 31.3),
(23, '12: 10', 154, 13.7, 14.8, 24.6, 31.4),
(24, '12: 11', 155, 13.8, 14.9, 24.7, 31.6),
(25, '13: 0', 156, 13.8, 14.9, 24.8, 31.7),
(26, '13: 1', 157, 13.8, 15, 24.9, 31.8),
(27, '13: 2', 158, 13.9, 15, 25, 31.9),
(28, '13: 3', 159, 13.9, 15.1, 25.1, 32.1),
(29, '13: 4', 160, 14, 15.1, 25.2, 32.2),
(30, '13: 5', 161, 14, 15.2, 25.2, 32.3),
(31, '13: 6', 162, 14, 15.2, 25.3, 32.4),
(32, '13: 7', 163, 14.1, 15.2, 25.4, 32.6),
(33, '13: 8', 164, 14.1, 15.3, 25.5, 32.7),
(34, '13: 9', 165, 14.1, 15.3, 25.6, 32.8),
(35, '13: 10', 166, 14.2, 15.4, 25.7, 32.9),
(36, '13: 11', 167, 14.2, 15.4, 25.8, 33),
(37, '14: 0', 168, 14.3, 15.5, 25.9, 33.1),
(38, '14: 1', 169, 14.3, 15.5, 26, 33.2),
(39, '14: 2', 170, 14.3, 15.6, 26.1, 33.3),
(40, '14: 3', 171, 14.4, 15.6, 26.2, 33.4),
(41, '14: 4', 172, 14.4, 15.7, 26.3, 33.5),
(42, '14: 5', 173, 14.5, 15.7, 26.4, 33.5),
(43, '14: 6', 174, 14.5, 15.7, 26.5, 33.6),
(44, '14: 7', 175, 14.5, 15.8, 26.5, 33.7),
(45, '14: 8', 176, 14.6, 15.8, 26.6, 33.8),
(46, '14: 9', 177, 14.6, 15.9, 26.7, 33.9),
(47, '14: 10', 178, 14.6, 15.9, 26.8, 33.9),
(48, '14: 11', 179, 14.7, 16, 26.9, 34),
(49, '15: 0', 180, 14.7, 16, 27, 34.1),
(50, '15: 1', 181, 14.7, 16.1, 27.1, 34.1),
(51, '15: 2', 182, 14.8, 16.1, 27.1, 34.2),
(52, '15: 3', 183, 14.8, 16.1, 27.2, 34.3),
(53, '15: 4', 184, 14.8, 16.2, 27.3, 34.3),
(54, '15: 5', 185, 14.9, 16.2, 27.4, 34.4),
(55, '15: 6', 186, 14.9, 16.3, 27.4, 34.5),
(56, '15: 7', 187, 15, 16.3, 27.5, 34.5),
(57, '15: 8', 188, 15, 16.3, 27.6, 34.6),
(58, '15: 9', 189, 15, 16.4, 27.7, 34.6),
(59, '15: 10', 190, 15, 16.4, 27.7, 34.7),
(60, '15: 11', 191, 15.1, 16.5, 27.8, 34.7),
(61, '16: 0', 192, 15.1, 16.5, 27.9, 34.8),
(62, '16: 1', 193, 15.1, 16.5, 27.9, 34.8),
(63, '16: 2', 194, 15.2, 16.6, 28, 34.8),
(64, '16: 3', 195, 15.2, 16.6, 28.1, 34.9),
(65, '16: 4', 196, 15.2, 16.7, 28.1, 34.9),
(66, '16: 5', 197, 15.3, 16.7, 28.2, 35),
(67, '16: 6', 198, 15.3, 16.7, 28.3, 35),
(68, '16: 7', 199, 15.3, 16.8, 28.3, 35),
(69, '16: 8', 200, 15.3, 16.8, 28.4, 35.1),
(70, '16: 9', 201, 15.4, 16.8, 28.5, 35.1),
(71, '16: 10', 202, 15.4, 16.9, 28.5, 35.1),
(72, '16: 11', 203, 15.4, 16.9, 28.6, 35.2),
(73, '17: 0', 204, 15.4, 16.9, 28.6, 35.2),
(74, '17: 1', 205, 15.5, 17, 28.7, 35.2),
(75, '17: 2', 206, 15.5, 17, 28.7, 35.2),
(76, '17: 3', 207, 15.5, 17, 28.8, 35.3),
(77, '17: 4', 208, 15.5, 17.1, 28.9, 35.3),
(78, '17: 5', 209, 15.6, 17.1, 28.9, 35.3),
(79, '17: 6', 210, 15.6, 17.1, 29, 35.3),
(80, '17: 7', 211, 15.6, 17.1, 29, 35.4),
(81, '17: 8', 212, 15.6, 17.2, 29.1, 35.4),
(82, '17: 9', 213, 15.6, 17.2, 29.1, 35.4),
(83, '17: 10', 214, 15.7, 17.2, 29.2, 35.4),
(84, '17: 11', 215, 15.7, 17.3, 29.2, 35.4),
(85, '18: 0', 216, 15.7, 17.3, 29.2, 35.4),
(86, '18: 1', 217, 15.7, 17.3, 29.3, 35.4),
(87, '18: 2', 218, 15.7, 17.3, 29.3, 35.5),
(88, '18: 3', 219, 15.7, 17.4, 29.4, 35.5),
(89, '18: 4', 220, 15.8, 17.4, 29.4, 35.5),
(90, '18: 5', 221, 15.8, 17.4, 29.5, 35.5),
(91, '18: 6', 222, 15.8, 17.4, 29.5, 35.5),
(92, '18: 7', 223, 15.8, 17.5, 29.5, 35.5),
(93, '18: 8', 224, 15.8, 17.5, 29.6, 35.5),
(94, '18: 9', 225, 15.8, 17.5, 29.6, 35.5),
(95, '18: 10', 226, 15.8, 17.5, 29.6, 35.5),
(96, '18: 11', 227, 15.8, 17.5, 29.7, 35.5),
(97, '19: 0', 228, 15.9, 17.6, 29.7, 35.5);

-- --------------------------------------------------------

--
-- Table structure for table `books`
--

CREATE TABLE `books` (
  `id` int(11) NOT NULL,
  `bookCode` varchar(30) NOT NULL,
  `bookName` varchar(500) NOT NULL DEFAULT 'Unnamed',
  `gradeLevel` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `books`
--

INSERT INTO `books` (`id`, `bookCode`, `bookName`, `gradeLevel`) VALUES
(1, 'GenMath11', 'General Mathematics', 11),
(2, 'Pre-Cal11', 'Pre Calculus 11', 11),
(3, 'Basic Cal12', 'Basic Calculus', 12),
(4, 'MIL12', 'Media and Information Literacy', 12),
(5, 'ACC 11', 'Accounting 11', 11),
(6, 'ACC 12', 'Accounting 12', 12);

-- --------------------------------------------------------

--
-- Table structure for table `booksissuedreturned`
--

CREATE TABLE `booksissuedreturned` (
  `id` int(11) NOT NULL,
  `sectionId` int(11) NOT NULL,
  `studentId` int(11) NOT NULL,
  `bookId` int(11) NOT NULL,
  `dateIssued` varchar(30) NOT NULL,
  `dateReturned` varchar(30) NOT NULL,
  `dateUpdated` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `booksissuedreturned`
--

INSERT INTO `booksissuedreturned` (`id`, `sectionId`, `studentId`, `bookId`, `dateIssued`, `dateReturned`, `dateUpdated`) VALUES
(1, 4, 3, 3, '2021-09-22', ' ', '2021-09-22 12:23:29'),
(2, 4, 3, 4, '2021-09-22', 'NEG:PTL', '2021-09-22 12:23:29'),
(3, 4, 9, 3, '2021-09-22', ' ', '2021-09-22 12:19:15'),
(4, 4, 9, 4, '2021-09-22', ' ', '2021-09-22 12:19:15'),
(5, 4, 13, 3, '2021-09-29', 'NEG', '2021-09-29 09:37:43'),
(6, 4, 13, 4, '2021-09-29', ' ', '2021-09-29 09:37:43');

-- --------------------------------------------------------

--
-- Table structure for table `booktemplates`
--

CREATE TABLE `booktemplates` (
  `id` int(11) NOT NULL,
  `templateName` varchar(50) NOT NULL,
  `gradeLevel` int(11) NOT NULL,
  `booksContained` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `booktemplates`
--

INSERT INTO `booktemplates` (`id`, `templateName`, `gradeLevel`, `booksContained`) VALUES
(1, 'STEM 11', 11, '1:2:'),
(2, 'STEM 12', 12, '3:4:'),
(3, 'ABM 11', 11, '5:1:'),
(4, 'ABM 12', 12, '6:4:');

-- --------------------------------------------------------

--
-- Table structure for table `enrollment`
--

CREATE TABLE `enrollment` (
  `id` int(11) NOT NULL,
  `studentId` int(11) NOT NULL,
  `sectionId` int(11) NOT NULL,
  `dateEnrolled` datetime NOT NULL DEFAULT current_timestamp(),
  `remarks` varchar(1000) NOT NULL DEFAULT ' ! !',
  `dep_type` varchar(10) NOT NULL DEFAULT 'JHS'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `enrollment`
--

INSERT INTO `enrollment` (`id`, `studentId`, `sectionId`, `dateEnrolled`, `remarks`, `dep_type`) VALUES
(2, 9, 4, '2021-09-28 22:45:09', ' ! !', 'SHS'),
(3, 3, 4, '2021-09-29 09:16:53', ' ! !', 'SHS'),
(4, 4, 4, '2021-09-29 09:17:41', ' ! !', 'SHS'),
(5, 5, 4, '2021-09-29 09:17:53', ' ! !', 'SHS'),
(6, 6, 4, '2021-09-29 09:18:10', ' ! !', 'SHS'),
(7, 7, 4, '2021-09-29 09:18:18', ' ! !', 'SHS'),
(8, 8, 4, '2021-09-29 09:18:26', ' ! !', 'SHS'),
(9, 10, 4, '2021-09-29 09:18:43', ' ! !', 'SHS'),
(10, 11, 4, '2021-09-29 09:18:58', ' ! !', 'SHS'),
(11, 12, 4, '2021-09-29 09:19:09', ' ! !', 'SHS'),
(12, 13, 4, '2021-09-29 09:19:18', 'T/I: 2021-09-29!T/I: 2021-09-29!', 'SHS'),
(13, 14, 4, '2021-09-29 09:19:34', 'T/I: 2021-09-29!T/I: 2021-09-29!', 'SHS'),
(14, 15, 4, '2021-09-29 09:19:43', 'T/I: 2021-09-29!T/I: 2021-09-29!', 'SHS'),
(15, 16, 4, '2021-09-29 09:19:53', 'T/I: 2021-09-29!T/I: 2021-09-29!', 'SHS'),
(16, 17, 4, '2021-09-29 09:20:03', 'T/I: 2021-09-29!T/I: 2021-09-29!', 'SHS'),
(17, 18, 4, '2021-09-29 09:20:14', 'T/I: 2021-09-29!T/I: 2021-09-29!', 'SHS'),
(18, 19, 4, '2021-09-29 09:20:25', 'T/I: 2021-09-29!T/I: 2021-09-29!', 'SHS'),
(19, 20, 4, '2021-09-29 09:20:43', 'T/I: 2021-09-29!T/I: 2021-09-29!', 'SHS'),
(20, 21, 4, '2021-09-29 09:20:52', 'T/I: 2021-09-29!T/I: 2021-09-29!', 'SHS'),
(21, 22, 4, '2021-09-29 09:21:02', 'T/I: 2021-09-29!T/I: 2021-09-29!', 'SHS'),
(22, 23, 4, '2021-09-29 09:21:11', 'T/I: 2021-09-29!T/I: 2021-09-29!', 'SHS');

-- --------------------------------------------------------

--
-- Table structure for table `enrollment_static`
--

CREATE TABLE `enrollment_static` (
  `id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  `section_name` varchar(200) NOT NULL,
  `adviser_name` varchar(200) NOT NULL,
  `grade_level` int(11) NOT NULL,
  `school_year` int(11) NOT NULL,
  `date_imported` datetime NOT NULL,
  `school_name` varchar(500) NOT NULL,
  `school_id` varchar(10) NOT NULL,
  `district` varchar(500) NOT NULL,
  `division` varchar(500) NOT NULL,
  `region` varchar(100) NOT NULL,
  `general_average` varchar(10) NOT NULL,
  `gen_ave_remarks` varchar(100) NOT NULL,
  `dep_type` varchar(10) NOT NULL DEFAULT 'JHS'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `finalgrades`
--

CREATE TABLE `finalgrades` (
  `id` int(11) NOT NULL,
  `sectionId` int(11) NOT NULL,
  `studentId` int(11) NOT NULL,
  `generalAverage` double NOT NULL DEFAULT 0,
  `actionTaken` varchar(30) NOT NULL DEFAULT 'Incomplete',
  `failedSubjects` varchar(1000) NOT NULL DEFAULT ' ',
  `dateUpdated` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Stand-in structure for view `form_sf1_view`
-- (See below for the actual view)
--
CREATE TABLE `form_sf1_view` (
`id` int(11)
,`studentId` int(11)
,`sectionId` int(11)
,`lrn` varchar(12)
,`lName` varchar(100)
,`fName` varchar(100)
,`mName` varchar(100)
,`sex` varchar(10)
,`bDate` date
,`age` int(11)
,`mTongue` varchar(500)
,`ip` varchar(500)
,`rlgn` varchar(500)
,`houseN` varchar(1000)
,`brgy` varchar(200)
,`mncpl` varchar(200)
,`prvnce` varchar(200)
,`fathersName` varchar(500)
,`mothersName` varchar(500)
,`gName` varchar(500)
,`rltnshp` varchar(100)
,`contact` varchar(20)
,`remarks` varchar(1000)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `form_sf2_view`
-- (See below for the actual view)
--
CREATE TABLE `form_sf2_view` (
`id` int(11)
,`sectionId` int(11)
,`studentId` int(11)
,`lName` varchar(100)
,`fName` varchar(100)
,`mName` varchar(100)
,`sex` varchar(10)
,`dateEnrolled` datetime
,`remarks` varchar(1000)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `form_sf3_view`
-- (See below for the actual view)
--
CREATE TABLE `form_sf3_view` (
`id` int(11)
,`sectionId` int(11)
,`studentId` int(11)
,`lName` varchar(100)
,`fName` varchar(100)
,`mName` varchar(100)
,`sex` varchar(10)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `form_sf5_viewfull`
-- (See below for the actual view)
--
CREATE TABLE `form_sf5_viewfull` (
`id` int(11)
,`sectionId` int(11)
,`sectionName` varchar(50)
,`schoolYear` int(11)
,`gradeLevel` int(11)
,`adviserId` int(11)
,`user_Lname` varchar(200)
,`user_Fname` varchar(200)
,`user_Mname` varchar(200)
,`studentId` int(11)
,`lrn` varchar(12)
,`lName` varchar(100)
,`fName` varchar(100)
,`mName` varchar(100)
,`sex` varchar(10)
,`remarks` varchar(1000)
,`generalAverage` double
,`actionTaken` varchar(30)
,`dateUpdated` datetime
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `form_sf5_viewminimal`
-- (See below for the actual view)
--
CREATE TABLE `form_sf5_viewminimal` (
`id` int(11)
,`sectionId` int(11)
,`gradeLevel` int(11)
,`studentId` int(11)
,`lrn` varchar(12)
,`lName` varchar(100)
,`fName` varchar(100)
,`mName` varchar(100)
,`sex` varchar(10)
,`remarks` varchar(1000)
,`generalAverage` double
,`actionTaken` varchar(30)
,`failedSubjects` varchar(1000)
,`dateUpdated` datetime
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `form_sf7view_loads`
-- (See below for the actual view)
--
CREATE TABLE `form_sf7view_loads` (
`id` int(11)
,`teacherId` int(11)
,`sectionId` int(11)
,`sectionName` varchar(50)
,`subjectId` int(11)
,`subjectCode` varchar(200)
,`description` varchar(500)
,`gradeLevel` int(11)
,`schoolYear` int(11)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `form_sf7view_teachers`
-- (See below for the actual view)
--
CREATE TABLE `form_sf7view_teachers` (
`id` int(11)
,`employeeNumber` varchar(100)
,`user_Lname` varchar(200)
,`user_Fname` varchar(200)
,`user_Mname` varchar(200)
,`gender` varchar(12)
,`fundSource` text
,`position` text
,`nature` text
,`degree` text
,`major` text
,`minor` text
,`user_level` int(11)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `form_sf8_view`
-- (See below for the actual view)
--
CREATE TABLE `form_sf8_view` (
`id` int(11)
,`studentId` int(11)
,`sectionId` int(11)
,`lrn` varchar(12)
,`lName` varchar(100)
,`fName` varchar(100)
,`mName` varchar(100)
,`bDate` varchar(10)
,`sex` varchar(10)
,`bmiId` int(11)
,`age` varchar(10)
,`weight` int(11)
,`height` varchar(22)
,`heightSq` varchar(20)
,`bmi` varchar(12)
,`bmiForAge` varchar(20)
,`heightForAge` varchar(20)
,`dateExamined` datetime
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `form_sf9_view`
-- (See below for the actual view)
--
CREATE TABLE `form_sf9_view` (
`id` int(11)
,`studentId` int(11)
,`sectionId` int(11)
,`subjectId` int(11)
,`subjectCode` varchar(200)
,`description` varchar(500)
,`firstQuarter` varchar(11)
,`secondQuarter` varchar(11)
,`thirdQuarter` varchar(11)
,`fourthQuarter` varchar(11)
,`gwa` varchar(11)
,`status` varchar(100)
,`dateUpdated` datetime
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `form_sf10_view`
-- (See below for the actual view)
--
CREATE TABLE `form_sf10_view` (
`id` int(11)
,`studentId` int(11)
,`lrn` varchar(12)
,`lName` varchar(100)
,`fName` varchar(100)
,`mName` varchar(100)
,`sex` varchar(10)
,`sectionId` int(11)
,`sectionName` varchar(50)
,`adviserId` int(11)
,`user_Lname` varchar(200)
,`user_Fname` varchar(200)
,`user_Mname` varchar(200)
,`gender` varchar(12)
,`loadId` int(11)
,`loadName` varchar(200)
,`gradeLevel` int(11)
,`subjectsContained` varchar(500)
,`schoolYear` int(11)
,`remarks` varchar(1000)
,`dateEnrolled` datetime
);

-- --------------------------------------------------------

--
-- Table structure for table `grades`
--

CREATE TABLE `grades` (
  `id` int(11) NOT NULL,
  `studentId` int(11) NOT NULL,
  `sectionId` int(11) NOT NULL,
  `subjectId` int(11) NOT NULL,
  `firstQuarter` varchar(11) NOT NULL DEFAULT '',
  `secondQuarter` varchar(11) NOT NULL DEFAULT '',
  `thirdQuarter` varchar(11) NOT NULL DEFAULT '',
  `fourthQuarter` varchar(11) NOT NULL DEFAULT '',
  `gwa` varchar(11) NOT NULL DEFAULT '',
  `status` varchar(100) NOT NULL DEFAULT 'Open:Open:Open:Open:Incomplete',
  `dateUpdated` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `grades`
--

INSERT INTO `grades` (`id`, `studentId`, `sectionId`, `subjectId`, `firstQuarter`, `secondQuarter`, `thirdQuarter`, `fourthQuarter`, `gwa`, `status`, `dateUpdated`) VALUES
(1, 10, 5, 71, '90', '89', '90', '91', '90', 'Closed:Submitted:Open:Open:Passed:', '2021-09-24 11:22:32'),
(2, 6, 5, 71, '91', '', '', '', '22', 'Closed:Submitted:Open:Open:Incomplete:', '2021-09-24 11:22:32'),
(3, 11, 5, 71, '90', '91', '', '', '45', 'Closed:Submitted:Open:Open:Incomplete:', '2021-09-24 11:22:32'),
(4, 12, 5, 71, '92', '92', '', '', '46', 'Closed:Submitted:Open:Open:Incomplete:', '2021-09-24 11:22:32'),
(5, 7, 3, 66, '90', '', '', '', '22', 'Closed:Open:Open:Open:Incomplete:', '2021-09-27 19:57:07'),
(6, 5, 3, 66, '89', '', '', '', '22', 'Closed:Open:Open:Open:Incomplete:', '2021-09-27 19:57:07'),
(7, 3, 3, 66, '90', '', '', '', '22', 'Closed:Open:Open:Open:Incomplete:', '2021-09-27 19:57:07'),
(8, 13, 4, 68, '92', '', '', '', '23', 'Closed:Open:Open:Open:Incomplete:', '2021-09-29 09:41:52'),
(9, 18, 4, 68, '93', '', '', '', '23', 'Closed:Open:Open:Open:Incomplete:', '2021-09-29 09:42:43'),
(10, 20, 4, 68, '94', '', '', '', '23', 'Closed:Open:Open:Open:Incomplete:', '2021-09-29 09:41:52');

-- --------------------------------------------------------

--
-- Table structure for table `grades_static`
--

CREATE TABLE `grades_static` (
  `id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  `enrollment_id` int(11) NOT NULL,
  `subject_name` varchar(500) NOT NULL,
  `first_quarter` varchar(11) NOT NULL,
  `second_quarter` varchar(11) NOT NULL,
  `third_quarter` varchar(11) NOT NULL,
  `fourth_quarter` varchar(11) NOT NULL,
  `final_rating` varchar(11) NOT NULL,
  `remarks` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `hfachart_female`
--

CREATE TABLE `hfachart_female` (
  `id` int(11) NOT NULL,
  `yearMonth` varchar(10) NOT NULL,
  `months` int(11) NOT NULL,
  `ssTo` double NOT NULL,
  `stTo` double NOT NULL,
  `nrmTo` double NOT NULL,
  `tallTo` double NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hfachart_female`
--

INSERT INTO `hfachart_female` (`id`, `yearMonth`, `months`, `ssTo`, `stTo`, `nrmTo`, `tallTo`) VALUES
(1, '11: 0', 132, 125.1, 131.7, 158.3, 164.9),
(2, '11: 1', 133, 125.5, 132.2, 158.9, 165.5),
(3, '11: 2', 134, 126, 132.7, 159.4, 166.1),
(4, '11: 3', 135, 126.5, 133.2, 160, 166.7),
(5, '11: 4', 136, 127, 133.7, 160.6, 167.3),
(6, '11: 5', 137, 127.4, 134.2, 161.1, 167.9),
(7, '11: 6', 138, 127.9, 134.7, 161.7, 168.4),
(8, '11: 7', 139, 128.4, 135.2, 162.2, 169),
(9, '11: 8', 140, 128.9, 135.7, 162.8, 169.6),
(10, '11: 9', 141, 129.3, 136.1, 163.3, 170.1),
(11, '11: 10', 142, 129.8, 136.6, 163.9, 170.7),
(12, '11: 11', 143, 130.3, 137.1, 164.4, 171.2),
(13, '12: 0', 144, 130.7, 137.6, 164.9, 171.8),
(14, '12: 1', 145, 131.2, 138, 165.4, 172.3),
(15, '12: 2', 146, 131.6, 138.5, 165.9, 172.8),
(16, '12: 3', 147, 132, 138.9, 166.4, 173.3),
(17, '12: 4', 148, 132.5, 139.3, 166.9, 173.8),
(18, '12: 5', 149, 132.9, 139.8, 167.4, 174.3),
(19, '12: 6', 150, 133.3, 140.2, 167.8, 174.7),
(20, '12: 7', 151, 133.7, 140.6, 168.3, 175.2),
(21, '12: 8', 152, 134.1, 141, 168.7, 175.6),
(22, '12: 9', 153, 134.5, 141.4, 169.1, 176),
(23, '12: 10', 154, 134.8, 141.8, 169.5, 176.4),
(24, '12: 11', 155, 135.2, 142.1, 169.9, 176.8),
(25, '13: 0', 156, 135.6, 142.5, 170.3, 177.2),
(26, '13: 1', 157, 135.9, 142.8, 170.6, 177.6),
(27, '13: 2', 158, 136.2, 143.2, 171, 177.9),
(28, '13: 3', 159, 136.5, 143.5, 171.3, 178.2),
(29, '13: 4', 160, 136.9, 143.8, 171.6, 178.6),
(30, '13: 5', 161, 137.2, 144.1, 171.9, 178.9),
(31, '13: 6', 162, 137.4, 144.4, 172.2, 179.2),
(32, '13: 7', 163, 137.7, 144.7, 172.5, 179.4),
(33, '13: 8', 164, 138, 144.9, 172.7, 179.7),
(34, '13: 9', 165, 138.2, 145.2, 173, 179.9),
(35, '13: 10', 166, 138.5, 145.4, 173.2, 180.2),
(36, '13: 11', 167, 138.7, 145.7, 173.5, 180.4),
(37, '14: 0', 168, 139, 145.9, 173.7, 180.6),
(38, '14: 1', 169, 139.2, 146.1, 173.9, 180.8),
(39, '14: 2', 170, 139.4, 146.3, 174.1, 181),
(40, '14: 3', 171, 139.6, 146.5, 174.2, 181.2),
(41, '14: 4', 172, 139.8, 146.7, 174.4, 181.3),
(42, '14: 5', 173, 140, 146.9, 174.6, 181.5),
(43, '14: 6', 174, 140.1, 147.1, 174.7, 181.6),
(44, '14: 7', 175, 140.3, 147.2, 174.9, 181.8),
(45, '14: 8', 176, 140.5, 147.4, 175, 181.9),
(46, '14: 9', 177, 140.6, 147.5, 175.1, 182),
(47, '14: 10', 178, 140.8, 147.7, 175.2, 182.1),
(48, '14: 11', 179, 140.9, 147.8, 175.3, 182.2),
(49, '15: 0', 180, 141, 147.9, 175.4, 182.3),
(50, '15: 1', 181, 141.2, 148, 175.5, 182.4),
(51, '15: 2', 182, 141.3, 148.1, 175.6, 182.5),
(52, '15: 3', 183, 141.4, 148.2, 175.7, 182.5),
(53, '15: 4', 184, 141.5, 148.3, 175.7, 182.6),
(54, '15: 5', 185, 141.6, 148.4, 175.8, 182.6),
(55, '15: 6', 186, 141.7, 148.5, 175.9, 182.7),
(56, '15: 7', 187, 141.8, 148.6, 175.9, 182.7),
(57, '15: 8', 188, 141.9, 148.7, 176, 182.8),
(58, '15: 9', 189, 141.9, 148.7, 176, 182.8),
(59, '15: 10', 190, 142, 148.8, 176, 182.8),
(60, '15: 11', 191, 142.1, 148.9, 176.1, 182.9),
(61, '16: 0', 192, 142.2, 148.9, 176.1, 182.9),
(62, '16: 1', 193, 142.2, 149, 176.1, 182.9),
(63, '16: 2', 194, 142.3, 149.1, 176.1, 182.9),
(64, '16: 3', 195, 142.3, 149.1, 176.2, 182.9),
(65, '16: 4', 196, 142.4, 149.2, 176.2, 182.9),
(66, '16: 5', 197, 142.4, 149.2, 176.2, 182.9),
(67, '16: 6', 198, 142.5, 149.2, 176.2, 182.9),
(68, '16: 7', 199, 142.5, 149.3, 176.2, 182.9),
(69, '16: 8', 200, 142.6, 149.3, 176.2, 182.9),
(70, '16: 9', 201, 142.6, 149.4, 176.2, 182.9),
(71, '16: 10', 202, 142.7, 149.4, 176.2, 182.9),
(72, '16: 11', 203, 142.7, 149.4, 176.2, 182.9),
(73, '17: 0', 204, 142.8, 149.5, 176.2, 182.9),
(74, '17: 1', 205, 142.8, 149.5, 176.2, 182.9),
(75, '17: 2', 206, 142.9, 149.5, 176.2, 182.9),
(76, '17: 3', 207, 142.9, 149.6, 176.3, 182.9),
(77, '17: 4', 208, 142.9, 149.6, 176.3, 182.9),
(78, '17: 5', 209, 143, 149.6, 176.3, 182.9),
(79, '17: 6', 210, 143, 149.7, 176.3, 182.9),
(80, '17: 7', 211, 143.1, 149.7, 176.3, 182.9),
(81, '17: 8', 212, 143.1, 149.7, 176.3, 182.9),
(82, '17: 9', 213, 143.1, 149.8, 176.3, 182.9),
(83, '17: 10', 214, 143.2, 149.8, 176.3, 182.9),
(84, '17: 11', 215, 143.2, 149.8, 176.3, 182.9),
(85, '18: 0', 216, 143.2, 149.8, 176.3, 182.9),
(86, '18: 1', 217, 143.3, 149.9, 176.3, 182.9),
(87, '18: 2', 218, 143.3, 149.9, 176.3, 182.9),
(88, '18: 3', 219, 143.3, 149.9, 176.3, 182.9),
(89, '18: 4', 220, 143.4, 149.9, 176.3, 182.9),
(90, '18: 5', 221, 143.4, 150, 176.3, 182.9),
(91, '18: 6', 222, 143.4, 150, 176.3, 182.9),
(92, '18: 7', 223, 143.4, 150, 176.3, 182.8),
(93, '18: 8', 224, 143.5, 150, 176.3, 182.8),
(94, '18: 9', 225, 143.5, 150, 176.3, 182.8),
(95, '18: 10', 226, 143.5, 150, 176.3, 182.8),
(96, '18: 11', 227, 143.5, 150.1, 176.2, 182.8),
(97, '19: 0', 228, 143.5, 150.1, 176.2, 182.8);

-- --------------------------------------------------------

--
-- Table structure for table `hfachart_male`
--

CREATE TABLE `hfachart_male` (
  `id` int(11) NOT NULL,
  `yearMonth` varchar(10) NOT NULL,
  `months` int(11) NOT NULL,
  `ssTo` double NOT NULL,
  `stTo` double NOT NULL,
  `nrmTo` double NOT NULL,
  `tallTo` double NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hfachart_male`
--

INSERT INTO `hfachart_male` (`id`, `yearMonth`, `months`, `ssTo`, `stTo`, `nrmTo`, `tallTo`) VALUES
(1, '11: 0', 132, 122.9, 129.7, 156.6, 163.3),
(7, '11: 1', 133, 123.3, 130.1, 157.1, 163.9),
(8, '11: 2', 134, 123.7, 130.5, 157.6, 164.4),
(9, '11: 3', 135, 124.1, 130.9, 158.2, 165),
(10, '11: 4', 136, 124.5, 131.3, 158.7, 165.6),
(11, '11: 5', 137, 124.9, 131.7, 159.3, 166.1),
(12, '12: 0', 144, 127.8, 134.9, 163.3, 170.3),
(13, '12: 1', 145, 128.3, 135.4, 163.9, 171),
(14, '12: 2', 146, 128.7, 135.9, 164.5, 171.6),
(15, '12: 3', 147, 129.2, 136.4, 165.1, 172.2),
(16, '12: 4', 148, 129.7, 136.9, 165.7, 172.9),
(17, '12: 5', 149, 130.2, 137.4, 166.3, 173.6),
(18, '12: 6', 150, 130.7, 137.9, 167, 174.2),
(19, '12: 7', 151, 131.2, 138.5, 167.6, 174.9),
(20, '12: 8', 152, 131.7, 139, 168.3, 175.6),
(21, '12: 9', 153, 132.2, 139.5, 168.9, 176.3),
(22, '12: 10', 154, 132.7, 140.1, 169.6, 176.9),
(23, '12: 11', 155, 133.2, 140.6, 170.2, 177.6),
(24, '13: 0', 156, 133.8, 141.2, 170.9, 178.3),
(25, '13: 1', 157, 134.3, 141.7, 171.6, 179),
(26, '13: 2', 158, 134.8, 142.3, 172.2, 179.7),
(27, '13: 3', 159, 135.4, 142.9, 172.9, 180.4),
(28, '13: 4', 160, 135.9, 143.4, 173.5, 181.1),
(29, '13: 5', 161, 136.4, 144, 174.2, 181.8),
(30, '13: 6', 162, 137, 144.5, 174.8, 182.4),
(31, '13: 7', 163, 137.5, 145.1, 175.5, 183.1),
(32, '13: 8', 164, 138, 145.7, 176.1, 183.7),
(33, '13: 9', 165, 138.6, 146.2, 176.7, 184.4),
(34, '13: 10', 166, 139.1, 146.7, 177.4, 185),
(35, '13: 11', 167, 139.6, 147.3, 178, 185.6),
(36, '14: 0', 168, 140.1, 147.8, 178.6, 186.3),
(37, '14: 1', 169, 140.6, 148.3, 179.1, 186.9),
(38, '14: 2', 170, 141.1, 148.8, 179.7, 187.4),
(39, '14: 3', 171, 141.6, 149.3, 180.3, 188),
(40, '14: 4', 172, 142.1, 149.8, 180.8, 188.6),
(41, '14: 5', 173, 142.5, 150.3, 181.3, 189.1),
(42, '14: 6', 174, 143, 150.8, 181.8, 189.6),
(43, '14: 7', 175, 143.4, 151.2, 182.3, 190.1),
(44, '14: 8', 176, 143.9, 151.7, 182.8, 190.6),
(45, '14: 9', 177, 144.3, 152.1, 183.3, 191.1),
(46, '14: 10', 178, 144.7, 152.5, 183.7, 191.5),
(47, '14: 11', 179, 145.1, 152.9, 184.1, 191.9),
(48, '15: 0', 180, 145.5, 153.4, 184.6, 192.4),
(49, '15: 1', 181, 145.9, 153.7, 185, 192.8),
(50, '15: 2', 182, 146.3, 154.1, 185.4, 193.2),
(51, '15: 3', 183, 146.7, 154.5, 185.7, 193.5),
(52, '15: 4', 184, 147.1, 154.9, 186.1, 193.9),
(53, '15: 5', 185, 147.4, 155.2, 186.4, 194.2),
(54, '15: 6', 186, 147.7, 155.5, 186.8, 194.6),
(55, '15: 7', 187, 148.1, 155.9, 187.1, 194.9),
(56, '15: 8', 188, 148.4, 156.2, 187.4, 195.2),
(57, '15: 9', 189, 148.7, 156.5, 187.7, 195.4),
(58, '15: 10', 190, 149, 156.8, 187.9, 195.7),
(59, '15: 11', 191, 149.3, 157.1, 188.2, 196),
(60, '16: 0', 192, 149.6, 157.4, 188.4, 196.2),
(61, '16: 1', 193, 149.9, 157.6, 188.7, 196.4),
(62, '16: 2', 194, 150.1, 157.9, 188.9, 196.7),
(63, '16: 3', 195, 150.4, 158.1, 189.1, 196.9),
(64, '16: 4', 196, 150.6, 158.4, 189.3, 197),
(65, '16: 5', 197, 150.9, 158.6, 189.5, 197.2),
(66, '16: 6', 198, 151.1, 158.8, 189.7, 197.4),
(67, '16: 7', 199, 151.3, 159, 189.8, 197.5),
(68, '16: 8', 200, 151.5, 159.2, 190, 197.7),
(69, '16: 9', 201, 151.7, 159.4, 190.1, 197.8),
(70, '16: 10', 202, 151.9, 159.6, 190.2, 197.9),
(71, '16: 11', 203, 152.1, 159.7, 190.3, 198),
(72, '17: 0', 204, 152.2, 159.9, 190.4, 198.1),
(73, '17: 1', 205, 152.4, 160, 190.5, 198.2),
(74, '17: 2', 206, 152.5, 160.2, 190.6, 198.2),
(75, '17: 3', 207, 152.7, 160.3, 190.7, 198.3),
(76, '17: 4', 208, 152.8, 160.4, 190.8, 198.4),
(77, '17: 5', 209, 153, 160.5, 190.8, 198.4),
(78, '17: 6', 210, 153.1, 160.6, 190.9, 198.4),
(79, '17: 7', 211, 153.2, 160.8, 190.9, 198.5),
(80, '17: 8', 212, 153.3, 160.9, 191, 198.5),
(81, '17: 9', 213, 153.4, 160.9, 91, 198.5),
(82, '17: 10', 214, 153.5, 161, 191, 198.5),
(83, '17: 11', 215, 153.6, 161.1, 191.1, 198.6),
(84, '18: 0', 216, 153.7, 161.2, 191.1, 198.6),
(85, '18: 1', 217, 153.8, 161.3, 191.1, 198.6),
(86, '18: 2', 218, 153.9, 161.4, 191.1, 198.6),
(87, '18: 3', 219, 154, 161.4, 191.1, 198.6),
(88, '18: 4', 220, 154.1, 161.5, 191.1, 198.6),
(89, '18: 5', 221, 154.2, 161.6, 191.1, 198.5),
(90, '18: 6', 222, 154.2, 161.6, 191.1, 198.5),
(91, '18: 7', 223, 154.3, 161.7, 191.2, 198.5),
(92, '18: 8', 224, 154.4, 161.7, 191.2, 198.5),
(93, '18: 9', 225, 154.5, 161.8, 191.2, 198.5),
(94, '18: 10', 226, 154.5, 161.8, 191.1, 198.5),
(95, '18: 11', 227, 154.6, 161.9, 191.1, 198.5),
(96, '19: 0', 228, 154.6, 161.9, 191.1, 198.4);

-- --------------------------------------------------------

--
-- Table structure for table `loads`
--

CREATE TABLE `loads` (
  `a_id` int(11) NOT NULL,
  `b_loadName` varchar(200) NOT NULL,
  `c_gradeLevel` int(11) NOT NULL,
  `d_subjectsContained` varchar(500) NOT NULL DEFAULT '',
  `dep_type` varchar(10) NOT NULL DEFAULT 'JHS'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `loads`
--

INSERT INTO `loads` (`a_id`, `b_loadName`, `c_gradeLevel`, `d_subjectsContained`, `dep_type`) VALUES
(1, 'K12 - Grade 7', 7, '8:9:10:11:12:13:14:60:15:16:17:18:52:', 'JHS'),
(2, 'STEM - 12', 12, '68:71:72:73:74:', 'SHS'),
(3, 'STEM - 11', 11, '65:69:70:', 'SHS'),
(4, 'ABM - 11', 11, '66:69:70:', 'SHS'),
(5, 'ABM - 12', 12, '67:71:72:73:74:', 'SHS');

-- --------------------------------------------------------

--
-- Table structure for table `personalinfo`
--

CREATE TABLE `personalinfo` (
  `id` int(11) NOT NULL,
  `stdId` int(12) NOT NULL,
  `bDate` date NOT NULL,
  `age` int(11) NOT NULL DEFAULT 0,
  `mTongue` varchar(500) NOT NULL DEFAULT 'LANGUAGE',
  `ip` varchar(500) NOT NULL DEFAULT 'INDIGENOUS PEOPLE',
  `rlgn` varchar(500) NOT NULL DEFAULT 'RELIGION',
  `houseN` varchar(1000) NOT NULL DEFAULT 'HOUSE NUM',
  `brgy` varchar(200) NOT NULL DEFAULT 'BRGY',
  `mncpl` varchar(200) NOT NULL DEFAULT 'MUNICIPAL',
  `prvnce` varchar(200) NOT NULL DEFAULT 'PROVINCE',
  `fName` varchar(500) NOT NULL DEFAULT 'FATHER NAME',
  `mName` varchar(500) NOT NULL DEFAULT 'MOTHER NAME',
  `gName` varchar(500) DEFAULT 'GUARDIAN NAME',
  `rltnshp` varchar(100) NOT NULL DEFAULT 'RELATIONSHIP',
  `contact` varchar(20) NOT NULL DEFAULT 'CONTACT',
  `date` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `personalinfo`
--

INSERT INTO `personalinfo` (`id`, `stdId`, `bDate`, `age`, `mTongue`, `ip`, `rlgn`, `houseN`, `brgy`, `mncpl`, `prvnce`, `fName`, `mName`, `gName`, `rltnshp`, `contact`, `date`) VALUES
(1, 3, '1999-03-25', 22, 'Bisaya', 'N/A', 'Assembly of God', 'Purok 5', 'Cabcungan', 'Nabunturan', 'Davao De Oro', 'N/A', 'Hilda', 'Hilda', 'Mother', '09876543216', '2021-09-21 16:34:56'),
(2, 4, '2004-12-17', 17, 'Bisaya', 'INDIGENOUS PEOPLE', 'RELIGION', 'HOUSE NUM', 'BRGY', 'MUNICIPAL', 'PROVINCE', 'FATHER NAME', 'MOTHER NAME', 'GUARDIAN NAME', 'RELATIONSHIP', 'CONTACT', '2021-09-29 10:20:51'),
(3, 5, '2004-06-18', 17, 'LANGUAGE', 'INDIGENOUS PEOPLE', 'RELIGION', 'HOUSE NUM', 'BRGY', 'MUNICIPAL', 'PROVINCE', 'FATHER NAME', 'MOTHER NAME', 'GUARDIAN NAME', 'RELATIONSHIP', 'CONTACT', '2021-09-29 10:21:19'),
(4, 6, '2004-10-26', 17, 'LANGUAGE', 'INDIGENOUS PEOPLE', 'RELIGION', 'HOUSE NUM', 'BRGY', 'MUNICIPAL', 'PROVINCE', 'FATHER NAME', 'MOTHER NAME', 'GUARDIAN NAME', 'RELATIONSHIP', 'CONTACT', '2021-09-29 10:21:48'),
(5, 7, '2004-10-16', 0, 'LANGUAGE', 'INDIGENOUS PEOPLE', 'RELIGION', 'HOUSE NUM', 'BRGY', 'MUNICIPAL', 'PROVINCE', 'FATHER NAME', 'MOTHER NAME', 'GUARDIAN NAME', 'RELATIONSHIP', 'CONTACT', '2021-09-29 10:28:57'),
(6, 8, '2004-10-16', 17, 'LANGUAGE', 'INDIGENOUS PEOPLE', 'RELIGION', 'HOUSE NUM', 'BRGY', 'MUNICIPAL', 'PROVINCE', 'FATHER NAME', 'MOTHER NAME', 'GUARDIAN NAME', 'RELATIONSHIP', 'CONTACT', '2021-09-29 10:22:40'),
(7, 9, '2004-10-16', 17, 'LANGUAGE', 'INDIGENOUS PEOPLE', 'RELIGION', 'HOUSE NUM', 'BRGY', 'MUNICIPAL', 'PROVINCE', 'FATHER NAME', 'MOTHER NAME', 'GUARDIAN NAME', 'RELATIONSHIP', 'CONTACT', '2021-09-29 10:22:52'),
(8, 10, '2004-10-16', 17, 'LANGUAGE', 'INDIGENOUS PEOPLE', 'RELIGION', 'HOUSE NUM', 'BRGY', 'MUNICIPAL', 'PROVINCE', 'FATHER NAME', 'MOTHER NAME', 'GUARDIAN NAME', 'RELATIONSHIP', 'CONTACT', '2021-09-29 10:23:11'),
(9, 11, '2004-10-16', 17, 'LANGUAGE', 'INDIGENOUS PEOPLE', 'RELIGION', 'HOUSE NUM', 'BRGY', 'MUNICIPAL', 'PROVINCE', 'FATHER NAME', 'MOTHER NAME', 'GUARDIAN NAME', 'RELATIONSHIP', 'CONTACT', '2021-09-29 10:23:26'),
(10, 12, '2004-10-16', 17, 'LANGUAGE', 'INDIGENOUS PEOPLE', 'RELIGION', 'HOUSE NUM', 'BRGY', 'MUNICIPAL', 'PROVINCE', 'FATHER NAME', 'MOTHER NAME', 'GUARDIAN NAME', 'RELATIONSHIP', 'CONTACT', '2021-09-29 10:23:40'),
(11, 13, '2004-10-16', 17, 'LANGUAGE', 'INDIGENOUS PEOPLE', 'RELIGION', 'HOUSE NUM', 'BRGY', 'MUNICIPAL', 'PROVINCE', 'FATHER NAME', 'MOTHER NAME', 'GUARDIAN NAME', 'RELATIONSHIP', 'CONTACT', '2021-09-29 10:23:55'),
(12, 14, '2004-10-16', 17, 'LANGUAGE', 'INDIGENOUS PEOPLE', 'RELIGION', 'HOUSE NUM', 'BRGY', 'MUNICIPAL', 'PROVINCE', 'FATHER NAME', 'MOTHER NAME', 'GUARDIAN NAME', 'RELATIONSHIP', 'CONTACT', '2021-09-29 10:24:10'),
(13, 15, '2004-10-16', 17, 'LANGUAGE', 'INDIGENOUS PEOPLE', 'RELIGION', 'HOUSE NUM', 'BRGY', 'MUNICIPAL', 'PROVINCE', 'FATHER NAME', 'MOTHER NAME', 'GUARDIAN NAME', 'RELATIONSHIP', 'CONTACT', '2021-09-29 10:24:24'),
(14, 16, '2004-10-16', 17, 'LANGUAGE', 'INDIGENOUS PEOPLE', 'RELIGION', 'HOUSE NUM', 'BRGY', 'MUNICIPAL', 'PROVINCE', 'FATHER NAME', 'MOTHER NAME', 'GUARDIAN NAME', 'RELATIONSHIP', 'CONTACT', '2021-09-29 10:24:38'),
(15, 17, '2004-10-16', 17, 'LANGUAGE', 'INDIGENOUS PEOPLE', 'RELIGION', 'HOUSE NUM', 'BRGY', 'MUNICIPAL', 'PROVINCE', 'FATHER NAME', 'MOTHER NAME', 'GUARDIAN NAME', 'RELATIONSHIP', 'CONTACT', '2021-09-29 10:24:52'),
(16, 18, '2004-10-16', 17, 'LANGUAGE', 'INDIGENOUS PEOPLE', 'RELIGION', 'HOUSE NUM', 'BRGY', 'MUNICIPAL', 'PROVINCE', 'FATHER NAME', 'MOTHER NAME', 'GUARDIAN NAME', 'RELATIONSHIP', 'CONTACT', '2021-09-29 10:25:03'),
(17, 19, '2004-10-16', 17, 'LANGUAGE', 'INDIGENOUS PEOPLE', 'RELIGION', 'HOUSE NUM', 'BRGY', 'MUNICIPAL', 'PROVINCE', 'FATHER NAME', 'MOTHER NAME', 'GUARDIAN NAME', 'RELATIONSHIP', 'CONTACT', '2021-09-29 10:25:21'),
(18, 20, '2004-10-16', 17, 'LANGUAGE', 'INDIGENOUS PEOPLE', 'RELIGION', 'HOUSE NUM', 'BRGY', 'MUNICIPAL', 'PROVINCE', 'FATHER NAME', 'MOTHER NAME', 'GUARDIAN NAME', 'RELATIONSHIP', 'CONTACT', '2021-09-29 10:25:32'),
(19, 21, '2004-10-16', 17, 'LANGUAGE', 'INDIGENOUS PEOPLE', 'RELIGION', 'HOUSE NUM', 'BRGY', 'MUNICIPAL', 'PROVINCE', 'FATHER NAME', 'MOTHER NAME', 'GUARDIAN NAME', 'RELATIONSHIP', 'CONTACT', '2021-09-29 10:25:45'),
(20, 22, '2004-10-16', 17, 'LANGUAGE', 'INDIGENOUS PEOPLE', 'RELIGION', 'HOUSE NUM', 'BRGY', 'MUNICIPAL', 'PROVINCE', 'FATHER NAME', 'MOTHER NAME', 'GUARDIAN NAME', 'RELATIONSHIP', 'CONTACT', '2021-09-29 10:25:56'),
(21, 23, '2004-10-16', 17, 'LANGUAGE', 'INDIGENOUS PEOPLE', 'RELIGION', 'HOUSE NUM', 'BRGY', 'MUNICIPAL', 'PROVINCE', 'FATHER NAME', 'MOTHER NAME', 'GUARDIAN NAME', 'RELATIONSHIP', 'CONTACT', '2021-09-29 10:26:10'),
(22, 24, '2004-10-16', 17, 'LANGUAGE', 'INDIGENOUS PEOPLE', 'RELIGION', 'HOUSE NUM', 'BRGY', 'MUNICIPAL', 'PROVINCE', 'FATHER NAME', 'MOTHER NAME', 'GUARDIAN NAME', 'RELATIONSHIP', 'CONTACT', '2021-09-29 10:26:24'),
(23, 25, '2004-10-16', 17, 'LANGUAGE', 'INDIGENOUS PEOPLE', 'RELIGION', 'HOUSE NUM', 'BRGY', 'MUNICIPAL', 'PROVINCE', 'FATHER NAME', 'MOTHER NAME', 'GUARDIAN NAME', 'RELATIONSHIP', 'CONTACT', '2021-09-29 10:26:35'),
(24, 26, '2004-10-16', 17, 'LANGUAGE', 'INDIGENOUS PEOPLE', 'RELIGION', 'HOUSE NUM', 'BRGY', 'MUNICIPAL', 'PROVINCE', 'FATHER NAME', 'MOTHER NAME', 'GUARDIAN NAME', 'RELATIONSHIP', 'CONTACT', '2021-09-29 10:26:47'),
(25, 27, '2004-10-16', 17, 'LANGUAGE', 'INDIGENOUS PEOPLE', 'RELIGION', 'HOUSE NUM', 'BRGY', 'MUNICIPAL', 'PROVINCE', 'FATHER NAME', 'MOTHER NAME', 'GUARDIAN NAME', 'RELATIONSHIP', 'CONTACT', '2021-09-29 10:26:59'),
(26, 28, '2004-10-16', 17, 'LANGUAGE', 'INDIGENOUS PEOPLE', 'RELIGION', 'HOUSE NUM', 'BRGY', 'MUNICIPAL', 'PROVINCE', 'FATHER NAME', 'MOTHER NAME', 'GUARDIAN NAME', 'RELATIONSHIP', 'CONTACT', '2021-09-29 10:27:12'),
(27, 29, '2004-10-16', 17, 'LANGUAGE', 'INDIGENOUS PEOPLE', 'RELIGION', 'HOUSE NUM', 'BRGY', 'MUNICIPAL', 'PROVINCE', 'FATHER NAME', 'MOTHER NAME', 'GUARDIAN NAME', 'RELATIONSHIP', 'CONTACT', '2021-09-29 10:27:24'),
(28, 30, '0000-00-00', 17, 'LANGUAGE', 'INDIGENOUS PEOPLE', 'RELIGION', 'HOUSE NUM', 'BRGY', 'MUNICIPAL', 'PROVINCE', 'FATHER NAME', 'MOTHER NAME', 'GUARDIAN NAME', 'RELATIONSHIP', 'CONTACT', '2021-09-29 10:27:38'),
(29, 31, '0000-00-00', 0, 'LANGUAGE', 'INDIGENOUS PEOPLE', 'RELIGION', 'HOUSE NUM', 'BRGY', 'MUNICIPAL', 'PROVINCE', 'FATHER NAME', 'MOTHER NAME', 'GUARDIAN NAME', 'RELATIONSHIP', 'CONTACT', '2021-11-15 15:56:40');

-- --------------------------------------------------------

--
-- Table structure for table `sections`
--

CREATE TABLE `sections` (
  `id` int(11) NOT NULL,
  `sectionName` varchar(50) NOT NULL,
  `adviserId` int(11) NOT NULL,
  `loadId` int(11) NOT NULL,
  `bookTemplateId` int(11) NOT NULL DEFAULT -1,
  `schoolYear` int(11) NOT NULL,
  `dep_type` varchar(10) NOT NULL DEFAULT 'JHS'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sections`
--

INSERT INTO `sections` (`id`, `sectionName`, `adviserId`, `loadId`, `bookTemplateId`, `schoolYear`, `dep_type`) VALUES
(1, 'Grade 7 - Honesto', 2, 1, -1, 2021, 'JHS'),
(2, 'Grade 11 - SHS Test', 1, 2, -1, 2021, 'SHS'),
(3, 'Grade 11 - Rose', 21, 4, 3, 2021, 'SHS'),
(4, 'Grade 12 - Sunflower', 23, 2, 2, 2021, 'SHS'),
(5, 'Grade 12 - Gumamela', 22, 5, 4, 2021, 'SHS'),
(6, 'Grade 11 - Santan', 20, 3, 1, 2021, 'SHS');

-- --------------------------------------------------------

--
-- Table structure for table `students`
--

CREATE TABLE `students` (
  `id` int(11) NOT NULL,
  `lrn` varchar(12) NOT NULL,
  `lName` varchar(100) NOT NULL,
  `fName` varchar(100) NOT NULL,
  `mName` varchar(100) NOT NULL DEFAULT ' ',
  `sex` varchar(10) NOT NULL,
  `inGr` float NOT NULL DEFAULT 0,
  `curGrLvl` int(11) NOT NULL DEFAULT 0,
  `schoolId` varchar(11) NOT NULL DEFAULT '000000',
  `schoolName` varchar(1000) NOT NULL DEFAULT ' ',
  `schoolAddress` varchar(1000) NOT NULL DEFAULT ' ',
  `strand` varchar(10) NOT NULL,
  `dep_type` varchar(10) NOT NULL DEFAULT 'JHS'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `students`
--

INSERT INTO `students` (`id`, `lrn`, `lName`, `fName`, `mName`, `sex`, `inGr`, `curGrLvl`, `schoolId`, `schoolName`, `schoolAddress`, `strand`, `dep_type`) VALUES
(1, '123456789012', 'Paderogao', 'Phil Rey', 'Estrella', 'Male', 90.25, 7, '123456', 'Gregorio Moralizon Elementary School - I', 'Manay, Davao Oriental', 'ABM', 'JHS'),
(3, '128384950293', 'Vir', 'Shayne', ' ', 'Female', 92, 12, '234567', 'Nabunturan', 'Assumption', 'STEM', 'SHS'),
(4, '123456789876', 'Joanna', 'Ruth', ' ', 'Female', 88, 12, '234567', 'Assumption', 'Nabunturan', 'ABM', 'SHS'),
(5, '123456789879', 'Josiah', 'Renhil', ' ', 'Female', 89, 12, '234567', 'Assumption', 'Nabunturan', 'ABM', 'SHS'),
(6, '345632145678', 'Mae', 'Frencess', ' ', 'Female', 90, 12, '234567', 'Assumption', 'Nabunturan', 'ABM', 'SHS'),
(7, '345672145678', 'Jai', 'Jenicel', ' ', 'Female', 89, 12, '234567', 'Assumption', 'Nabunturan', 'ABM', 'SHS'),
(8, '345072145678', 'Charmel', 'Jance', ' ', 'Female', 90, 12, '234567', 'Assumption', 'Nabunturan', 'ABM', 'SHS'),
(9, '346772145678', 'Jay', 'Clark', ' ', 'Male', 90, 12, '234567', 'Assumption', 'Nabunturan', 'ABM', 'SHS'),
(10, '046772145678', 'Mar', 'Chris', ' ', 'Male', 87, 12, '234567', 'Assumption', 'Nabunturan', 'ABM', 'SHS'),
(11, '046772145878', 'Yoo', 'Dee', ' ', 'Male', 89, 12, '234567', 'Assumption', 'Nabunturan', 'ABM', 'SHS'),
(12, '903748234567', 'Yah', 'Leeey', ' ', 'Female', 94, 12, '987654', 'Davao High', 'Davao City', 'ABM', 'SHS'),
(13, '903748234568', 'Charlton', 'Mark', ' ', 'Male', 93, 12, '987654', 'Davao High', 'Davao City', 'ABM', 'SHS'),
(14, '903748234468', 'Ney', 'Syd', ' ', 'Male', 95, 12, '987654', 'Davao High', 'Davao City', 'ABM', 'SHS'),
(15, '903748234563', 'Thah', 'Jeph', ' ', 'Male', 93, 12, '987654', 'Davao High', 'Davao City', 'ABM', 'SHS'),
(16, '903748234565', 'Joey', 'Yeoj', ' ', 'Male', 90, 12, '987654', 'Davao High', 'Davao City', 'ABM', 'SHS'),
(17, '903748134565', 'Rey', 'Phil', ' ', 'Male', 95, 12, '987654', 'Davao High', 'Davao City', 'ABM', 'SHS'),
(18, '903748834565', 'Hil', 'Ren', ' ', 'Male', 88, 12, '987654', 'Davao High', 'Davao City', 'ABM', 'SHS'),
(19, '234567890123', 'Odin', 'Rodel', ' ', 'Male', 87, 12, '234567', 'Assumption', 'Nabunturan', 'ABM', 'SHS'),
(20, '234567880123', 'Jan', 'Romeo', ' ', 'Male', 88, 12, '234567', 'Assumption', 'Nabunturan', 'ABM', 'SHS'),
(21, '234567800123', 'Zeyah', 'Khez', ' ', 'Female', 89, 12, '234567', 'Assumption', 'Nabunturan', 'ABM', 'SHS'),
(22, '234567820123', 'Kriz', 'Kim', ' ', 'Female', 89, 12, '234567', 'Assumption', 'Nabunturan', 'ABM', 'SHS'),
(23, '234567820124', 'Jane', 'Kyla', ' ', 'Female', 88, 12, '234567', 'Assumption', 'Nabunturan', 'ABM', 'SHS'),
(24, '234567820324', 'Dave', 'Russel', ' ', 'Male', 88, 0, '234567', 'Assumption', 'Nabunturan', 'ABM', 'SHS'),
(25, '783647234561', 'Sie', 'Bless', ' ', 'Female', 93, 0, '567453', 'Mainit NHS', 'Mainit, Nab', 'ABM', 'SHS'),
(26, '783647234560', 'Sham', 'Kween', ' ', 'Female', 94, 0, '567453', 'Mainit NHS', 'Mainit, Nab', 'ABM', 'SHS'),
(27, '783677234560', 'Hoy', 'Hoy', ' ', 'Female', 92, 0, '567453', 'Mainit NHS', 'Mainit, Nab', 'ABM', 'SHS'),
(28, '783677224560', 'Dy', 'Cin', ' ', 'Female', 91, 0, '567453', 'Mainit NHS', 'Mainit, Nab', 'ABM', 'SHS'),
(29, '783677224580', 'Ly', 'Ren', ' ', 'Male', 89, 0, '567453', 'Mainit NHS', 'Mainit, Nab', 'ABM', 'SHS'),
(30, '874567325678', 'Yam', 'Lee', ' ', 'Male', 89, 0, '567842', 'Manat NHS', 'Manat, Nab', 'ABM', 'SHS');

-- --------------------------------------------------------

--
-- Table structure for table `subjects`
--

CREATE TABLE `subjects` (
  `id` int(11) NOT NULL,
  `subjectCode` varchar(200) NOT NULL,
  `description` varchar(500) NOT NULL,
  `gradeLevel` int(11) NOT NULL,
  `sem` varchar(15) NOT NULL,
  `dep_type` varchar(10) NOT NULL DEFAULT 'JHS'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `subjects`
--

INSERT INTO `subjects` (`id`, `subjectCode`, `description`, `gradeLevel`, `sem`, `dep_type`) VALUES
(8, 'FIL7', 'Filipino 7', 7, '1st semester', 'JHS'),
(9, 'ENG7', 'English 7', 7, '1st semester', 'JHS'),
(10, 'MATH7', 'Mathematics 7', 7, '1st semester', 'JHS'),
(11, 'SCI7', 'Science 7', 7, '1st semester', 'JHS'),
(12, 'AP7', 'Araling Panlipunan 7', 7, '1st semester', 'JHS'),
(13, 'ESP7', 'Edukasyon sa Pagpapakatao 7', 7, '1st semester', 'JHS'),
(14, 'TLE7', 'Technology and Livelihood Education 7', 7, '1st semester', 'JHS'),
(15, 'MUS7', 'Music 7', 7, '1st semester', 'JHS'),
(16, 'ART7', 'Arts 7', 7, '1st semester', 'JHS'),
(17, 'PE7', 'Physical Education 7', 7, '1st semester', 'JHS'),
(18, 'HLT7', 'Health 7', 7, '1st semester', 'JHS'),
(19, 'FIL8', 'Filipino 8', 8, '1st semester', 'JHS'),
(20, 'ENG8', 'English 8', 8, '1st semester', 'JHS'),
(21, 'MATH8', 'Mathematics 8', 8, '1st semester', 'JHS'),
(22, 'SCI8', 'Science 8', 8, '1st semester', 'JHS'),
(23, 'AP8', 'Araling Panlipunan 8', 8, '1st semester', 'JHS'),
(24, 'ESP8', 'Edukasyon sa Pagpapakatao 8', 8, '1st semester', 'JHS'),
(25, 'TLE8', 'Technology and Livelihood Education', 8, '1st semester', 'JHS'),
(26, 'MUS8', 'Music 8', 8, '1st semester', 'JHS'),
(27, 'ART8', 'Arts 8', 8, '1st semester', 'JHS'),
(28, 'PE8', 'Physical Education 8', 8, '1st semester', 'JHS'),
(29, 'HLT8', 'Health 8', 8, '1st semester', 'JHS'),
(30, 'FIL9', 'Filipino 9', 9, '1st semester', 'JHS'),
(31, 'ENG9', 'English 9', 9, '1st semester', 'JHS'),
(32, 'MATH9', 'Mathematics 9', 9, '1st semester', 'JHS'),
(33, 'SCI9', 'Science 9', 9, '1st semester', 'JHS'),
(34, 'AP9', 'Araling Panlipunan 9', 9, '1st semester', 'JHS'),
(35, 'ESP9', 'Edukasyon sa Pagpapakatao 9', 9, '1st semester', 'JHS'),
(36, 'TLE9', 'Technology and Livelihood Education 9', 9, '1st semester', 'JHS'),
(37, 'MUS9', 'Music 9', 9, '1st semester', 'JHS'),
(38, 'ART9', 'Arts 9', 9, '1st semester', 'JHS'),
(39, 'PE9', 'Physical Education 9', 9, '1st semester', 'JHS'),
(40, 'HLT9', 'Health 9', 9, '1st semester', 'JHS'),
(41, 'FIL10', 'Filipino 10', 10, '1st semester', 'JHS'),
(42, 'ENG10', 'English 10', 10, '1st semester', 'JHS'),
(43, 'MATH10', 'Mathematics 10', 10, '1st semester', 'JHS'),
(44, 'SCI10', 'Science 10', 10, '1st semester', 'JHS'),
(45, 'AP10', 'Araling Panlipunan 10', 10, '1st semester', 'JHS'),
(46, 'ESP10', 'Edukasyon sa Pagpapakatao 10', 10, '1st semester', 'JHS'),
(47, 'TLE10', 'Technology and Livelihood Education 10', 10, '1st semester', 'JHS'),
(48, 'MUS10', 'Music 10', 10, '1st semester', 'JHS'),
(49, 'ART10', 'Arts 10', 10, '1st semester', 'JHS'),
(50, 'PE10', 'Physical Education 10', 10, '1st semester', 'JHS'),
(51, 'HLT10', 'Health 10', 10, '1st semester', 'JHS'),
(52, 'ADV7', 'Advisory 7', 7, '1st semester', 'JHS'),
(53, 'ADV8', 'Advisory 8', 8, '1st semester', 'JHS'),
(54, 'ADV9', 'Advisory 9', 9, '1st semester', 'JHS'),
(55, 'ADV10', 'Advisory 10', 10, '1st semester', 'JHS'),
(60, 'MPH7', 'MAPEH 7', 7, '1st semester', 'JHS'),
(61, 'MPH8', 'MAPEH 8', 8, '1st semester', 'JHS'),
(62, 'MPH9', 'MAPEH 9', 9, '1st semester', 'JHS'),
(63, 'MPH10', 'MAPEH 10', 10, '1st semester', 'JHS'),
(65, 'ADV11', 'Pre Calculus 11', 11, '2nd semester', 'SHS'),
(66, 'ADV11', 'Accounting 11', 11, '1st semester', 'SHS'),
(67, 'ADV12', 'Accounting 12', 12, '1st semester', 'SHS'),
(68, 'ADV12', 'Basic Calculus 12', 12, '1st semester', 'SHS'),
(69, 'GenMath11', 'General Mathematics 11', 11, '2nd semester', 'SHS'),
(70, 'EarthSci11', 'Earth Science 11', 11, '1st semester', 'SHS'),
(71, 'MIL12', 'Media and Information Literacy 12', 12, '1st semester', 'SHS'),
(72, 'PR12', 'Practical Research 12', 12, '1st semester', 'SHS'),
(73, 'PROB12', 'Probability & Statistics 12', 12, '1st semester', 'SHS'),
(74, 'PE12', 'Physical Education 12', 12, '1st semester', 'SHS'),
(75, 'Math11', 'Mathematics', 11, '1st semester', 'SHS');

-- --------------------------------------------------------

--
-- Table structure for table `teacherloads`
--

CREATE TABLE `teacherloads` (
  `id` int(11) NOT NULL,
  `sectionId` int(11) NOT NULL,
  `teacherId` int(11) NOT NULL,
  `subjectId` int(11) NOT NULL,
  `timeStart` time NOT NULL DEFAULT '07:00:00',
  `timeEnd` time NOT NULL DEFAULT '08:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `teacherloads`
--

INSERT INTO `teacherloads` (`id`, `sectionId`, `teacherId`, `subjectId`, `timeStart`, `timeEnd`) VALUES
(1, 1, 2, 8, '07:00:00', '08:00:00'),
(2, 1, -1, 9, '07:00:00', '08:00:00'),
(3, 1, -1, 10, '07:00:00', '08:00:00'),
(4, 1, -1, 11, '07:00:00', '08:00:00'),
(5, 1, -1, 12, '07:00:00', '08:00:00'),
(6, 1, -1, 13, '07:00:00', '08:00:00'),
(7, 1, -1, 14, '07:00:00', '08:00:00'),
(8, 1, -1, 60, '07:00:00', '08:00:00'),
(9, 1, -1, 15, '07:00:00', '08:00:00'),
(10, 1, -1, 16, '07:00:00', '08:00:00'),
(11, 1, -1, 17, '07:00:00', '08:00:00'),
(12, 1, -1, 18, '07:00:00', '08:00:00'),
(13, 1, 2, 52, '07:00:00', '08:00:00'),
(14, 3, 21, 66, '07:00:00', '08:00:00'),
(15, 3, 22, 69, '07:00:00', '08:00:00'),
(16, 3, 24, 70, '07:00:00', '08:00:00'),
(17, 6, 20, 65, '07:00:00', '08:00:00'),
(18, 6, 22, 69, '07:00:00', '08:00:00'),
(19, 6, 24, 70, '07:00:00', '08:00:00'),
(20, 5, 22, 67, '07:00:00', '08:00:00'),
(21, 5, 23, 71, '07:00:00', '08:00:00'),
(22, 5, 21, 72, '07:00:00', '08:00:00'),
(23, 4, 23, 68, '07:00:00', '08:00:00'),
(24, 4, 23, 71, '07:00:00', '08:00:00'),
(25, 4, 21, 72, '07:00:00', '08:00:00'),
(26, 4, -1, 73, '07:00:00', '08:00:00'),
(27, 4, 20, 74, '07:00:00', '08:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `userdetails`
--

CREATE TABLE `userdetails` (
  `id` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `employeeNumber` varchar(100) NOT NULL DEFAULT 'TIN NUMBER',
  `fundSource` varchar(1000) NOT NULL DEFAULT 'FUND SOURCE',
  `position` varchar(1000) NOT NULL DEFAULT 'POSITION',
  `nature` varchar(1000) NOT NULL DEFAULT 'NATURE',
  `degree` varchar(1000) NOT NULL DEFAULT 'DEGREE',
  `major` varchar(1000) NOT NULL DEFAULT 'MAJOR',
  `minor` varchar(1000) NOT NULL DEFAULT 'MINOR',
  `managedSubjects` varchar(10000) NOT NULL DEFAULT 'NONE'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `userdetails`
--

INSERT INTO `userdetails` (`id`, `userId`, `employeeNumber`, `fundSource`, `position`, `nature`, `degree`, `major`, `minor`, `managedSubjects`) VALUES
(1, 19, 'TIN NUMBER', 'FUND SOURCE', 'POSITION', 'NATURE', 'DEGREE', 'MAJOR', 'MINOR', '70:'),
(2, 25, 'TIN NUMBER', 'FUND SOURCE', 'POSITION', 'NATURE', 'DEGREE', 'MAJOR', 'MINOR', '71:'),
(3, 21, 'TIN NUMBER', 'FUND SOURCE', 'POSITION', 'NATURE', 'DEGREE', 'MAJOR', 'MINOR', 'NONE');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `user_Lname` varchar(200) NOT NULL,
  `user_Fname` varchar(200) NOT NULL,
  `user_Mname` varchar(200) NOT NULL,
  `gender` varchar(12) NOT NULL,
  `user_name` varchar(200) NOT NULL,
  `user_password` varchar(200) NOT NULL,
  `user_level` int(11) NOT NULL,
  `dep_type` varchar(10) NOT NULL DEFAULT 'JHS'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `user_Lname`, `user_Fname`, `user_Mname`, `gender`, `user_name`, `user_password`, `user_level`, `dep_type`) VALUES
(1, 'Paderogao', 'Phil Rey', 'Estrella%C3%91', 'Male', 'admin', 'password', 5, 'JHS'),
(2, 'Furahashi', 'Fumino', 'Ona', 'Female', 'benkyu', 'password', 1, 'JHS'),
(3, 'Paderogao', 'Kerby', 'Estrella', 'Female', 'kerbs', 'pass', 1, 'JHS'),
(4, 'Dela Cruz', 'Juan', 'Ponciano', 'Male', 'registrar', 'password', 4, 'JHS'),
(5, 'Rizal', 'Jose', 'Protacio', 'Male', 'depheadfil7', 'password', 2, 'JHS'),
(6, 'Ramsey', 'Gordon', 'Grant', 'Male', 'currhead', 'password', 3, 'JHS'),
(7, 'Sins', 'Jhonny', 'Marcus', 'Male', 'john', 'password', 4, 'JHS'),
(8, 'Bulahan', 'Harris', 'Kay', 'Male', 'hbulahan', 'password1', 3, 'JHS'),
(9, 'Rezane', 'Warren', 'Dunno', 'Male', 'wrezxaneDH', '1234567', 2, 'JHS'),
(10, 'Lname', 'Fname', 'Mname', 'Female', 'admin2', 'password', 3, 'JHS'),
(11, 'Lname2', 'Fname2', 'Mname2', 'Female', 'admin3', 'password', 2, 'JHS'),
(12, 'Minchin', 'Maria', 'Loti', 'Female', 'minchinxsarah', 'password', 4, 'JHS'),
(13, 'Mason', 'Alex', 'Joe', 'Male', 'thenumbers', 'password', 3, 'JHS'),
(14, 'Filonzo', 'Ferdinand', 'Wika', 'Male', 'ferdi', 'password', 2, 'JHS'),
(15, 'Englesias', 'Edgar', 'Poe', 'Male', 'edgar', 'password', 2, 'JHS'),
(16, 'Paderogao', 'Phil Rey', 'Estrella', 'Male', 'admin', 'password', 5, 'SHS'),
(17, 'Sabu', 'Kim', '', 'Male', 'kim', 'sabu_99Kim', 4, 'SHS'),
(18, 'Lee', 'Ikjun', '', 'Male', 'ikjun', 'hOspital_25', 3, 'SHS'),
(19, 'Cycle', 'Motor', '', 'Male', 'motor', 'cycle_Honda0', 2, 'SHS'),
(20, 'Mak', 'Mak', '', 'Male', 'mak', 'makMak_1', 1, 'SHS'),
(21, 'May', 'May', '', 'Female', 'may', 'mayMay_2', 1, 'SHS'),
(22, 'Jan', 'Jan', '', 'Male', 'jan', 'janJan_3', 1, 'SHS'),
(23, 'Sen', 'Sen', '', 'Female', 'sen', 'senSen_4', 1, 'SHS'),
(24, 'Jen', 'Jen', '', 'Female', 'jen', 'jenJen_5', 1, 'SHS'),
(25, 'Speaker', 'Bluetooth', '', 'Male', 'blue', 'blueTooth_1', 2, 'SHS');

-- --------------------------------------------------------

--
-- Stand-in structure for view `v_enrollment`
-- (See below for the actual view)
--
CREATE TABLE `v_enrollment` (
`id` int(11)
,`studentId` int(11)
,`lrn` varchar(12)
,`lName` varchar(100)
,`fName` varchar(100)
,`mName` varchar(100)
,`sex` varchar(10)
,`sectionId` int(11)
,`sectionName` varchar(50)
,`adviserId` int(11)
,`user_Lname` varchar(200)
,`user_Fname` varchar(200)
,`user_Mname` varchar(200)
,`loadId` int(11)
,`b_loadName` varchar(200)
,`c_gradeLevel` int(11)
,`schoolYear` int(11)
,`dateEnrolled` datetime
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `v_enrollment_jhs`
-- (See below for the actual view)
--
CREATE TABLE `v_enrollment_jhs` (
`id` int(11)
,`studentId` int(11)
,`lrn` varchar(12)
,`lName` varchar(100)
,`fName` varchar(100)
,`mName` varchar(100)
,`sex` varchar(10)
,`sectionId` int(11)
,`sectionName` varchar(50)
,`adviserId` int(11)
,`user_Lname` varchar(200)
,`user_Fname` varchar(200)
,`user_Mname` varchar(200)
,`loadId` int(11)
,`b_loadName` varchar(200)
,`c_gradeLevel` int(11)
,`schoolYear` int(11)
,`dateEnrolled` datetime
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `v_enrollment_minimal`
-- (See below for the actual view)
--
CREATE TABLE `v_enrollment_minimal` (
`id` int(11)
,`studentId` int(11)
,`lrn` varchar(12)
,`lName` varchar(100)
,`fName` varchar(100)
,`mName` varchar(100)
,`sex` varchar(10)
,`sectionId` int(11)
,`remarks` varchar(1000)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `v_enrollment_minimal_jhs`
-- (See below for the actual view)
--
CREATE TABLE `v_enrollment_minimal_jhs` (
`id` int(11)
,`studentId` int(11)
,`lrn` varchar(12)
,`lName` varchar(100)
,`fName` varchar(100)
,`mName` varchar(100)
,`sex` varchar(10)
,`sectionId` int(11)
,`remarks` varchar(1000)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `v_enrollment_minimal_shs`
-- (See below for the actual view)
--
CREATE TABLE `v_enrollment_minimal_shs` (
`id` int(11)
,`studentId` int(11)
,`lrn` varchar(12)
,`lName` varchar(100)
,`fName` varchar(100)
,`mName` varchar(100)
,`sex` varchar(10)
,`sectionId` int(11)
,`remarks` varchar(1000)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `v_enrollment_mini_wbdate`
-- (See below for the actual view)
--
CREATE TABLE `v_enrollment_mini_wbdate` (
`id` int(11)
,`studentId` int(11)
,`lrn` varchar(12)
,`lName` varchar(100)
,`fName` varchar(100)
,`mName` varchar(100)
,`sex` varchar(10)
,`bDate` date
,`sectionId` int(11)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `v_enrollment_mini_wbdate_jhs`
-- (See below for the actual view)
--
CREATE TABLE `v_enrollment_mini_wbdate_jhs` (
`id` int(11)
,`studentId` int(11)
,`lrn` varchar(12)
,`lName` varchar(100)
,`fName` varchar(100)
,`mName` varchar(100)
,`sex` varchar(10)
,`bDate` varchar(10)
,`sectionId` int(11)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `v_enrollment_mini_wbdate_shs`
-- (See below for the actual view)
--
CREATE TABLE `v_enrollment_mini_wbdate_shs` (
`id` int(11)
,`studentId` int(11)
,`lrn` varchar(12)
,`lName` varchar(100)
,`fName` varchar(100)
,`mName` varchar(100)
,`sex` varchar(10)
,`bDate` varchar(10)
,`sectionId` int(11)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `v_enrollment_shs`
-- (See below for the actual view)
--
CREATE TABLE `v_enrollment_shs` (
`id` int(11)
,`studentId` int(11)
,`lrn` varchar(12)
,`lName` varchar(100)
,`fName` varchar(100)
,`mName` varchar(100)
,`sex` varchar(10)
,`sectionId` int(11)
,`sectionName` varchar(50)
,`adviserId` int(11)
,`user_Lname` varchar(200)
,`user_Fname` varchar(200)
,`user_Mname` varchar(200)
,`loadId` int(11)
,`b_loadName` varchar(200)
,`c_gradeLevel` int(11)
,`schoolYear` int(11)
,`dateEnrolled` datetime
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `v_grades`
-- (See below for the actual view)
--
CREATE TABLE `v_grades` (
`id` int(11)
,`sectionId` int(11)
,`studentId` int(11)
,`teacherId` int(11)
,`user_Lname` varchar(200)
,`user_Fname` varchar(200)
,`user_Mname` varchar(200)
,`gender` varchar(12)
,`subjectId` int(11)
,`subjectCode` varchar(200)
,`description` varchar(500)
,`gradeLevel` int(11)
,`gwa` varchar(11)
,`status` varchar(100)
,`dateUpdated` datetime
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `v_loads_jhs`
-- (See below for the actual view)
--
CREATE TABLE `v_loads_jhs` (
`a_id` int(11)
,`b_loadName` varchar(200)
,`c_gradeLevel` int(11)
,`d_subjectsContained` varchar(500)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `v_loads_shs`
-- (See below for the actual view)
--
CREATE TABLE `v_loads_shs` (
`a_id` int(11)
,`b_loadName` varchar(200)
,`c_gradeLevel` int(11)
,`d_subjectsContained` varchar(500)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `v_managedsubjects`
-- (See below for the actual view)
--
CREATE TABLE `v_managedsubjects` (
`id` int(11)
,`sectionId` int(11)
,`sectionName` varchar(50)
,`teacherId` int(11)
,`user_Lname` varchar(200)
,`user_Fname` varchar(200)
,`user_Mname` varchar(200)
,`gender` varchar(12)
,`subjectId` int(11)
,`subjectCode` varchar(200)
,`description` varchar(500)
,`gradeLevel` int(11)
,`schoolYear` int(11)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `v_managedsubjects_wbooktemplate`
-- (See below for the actual view)
--
CREATE TABLE `v_managedsubjects_wbooktemplate` (
`id` int(11)
,`sectionId` int(11)
,`sectionName` varchar(50)
,`teacherId` int(11)
,`user_Lname` varchar(200)
,`user_Fname` varchar(200)
,`user_Mname` varchar(200)
,`gender` varchar(12)
,`subjectId` int(11)
,`subjectCode` varchar(200)
,`description` varchar(500)
,`gradeLevel` int(11)
,`schoolYear` int(11)
,`bookTemplateId` int(11)
,`templateName` varchar(50)
,`booksContained` varchar(500)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `v_managedsubjects_wsubjectscontained`
-- (See below for the actual view)
--
CREATE TABLE `v_managedsubjects_wsubjectscontained` (
`id` int(11)
,`sectionId` int(11)
,`sectionName` varchar(50)
,`teacherId` int(11)
,`user_Lname` varchar(200)
,`user_Fname` varchar(200)
,`user_Mname` varchar(200)
,`gender` varchar(12)
,`subjectId` int(11)
,`subjectCode` varchar(200)
,`description` varchar(500)
,`gradeLevel` int(11)
,`schoolYear` int(11)
,`loadId` int(11)
,`loadName` varchar(200)
,`subjectsContained` varchar(500)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `v_sections`
-- (See below for the actual view)
--
CREATE TABLE `v_sections` (
`id` int(11)
,`sectionName` varchar(50)
,`adviserId` int(11)
,`user_Lname` varchar(200)
,`user_Fname` varchar(200)
,`user_Mname` varchar(200)
,`gender` varchar(12)
,`loadId` int(11)
,`b_loadName` varchar(200)
,`c_gradeLevel` int(11)
,`schoolYear` int(11)
,`d_subjectsContained` varchar(500)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `v_sections_jhs`
-- (See below for the actual view)
--
CREATE TABLE `v_sections_jhs` (
`id` int(11)
,`sectionName` varchar(50)
,`adviserId` int(11)
,`user_Lname` varchar(200)
,`user_Fname` varchar(200)
,`user_Mname` varchar(200)
,`gender` varchar(12)
,`loadId` int(11)
,`b_loadName` varchar(200)
,`c_gradeLevel` int(11)
,`schoolYear` int(11)
,`d_subjectsContained` varchar(500)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `v_sections_shs`
-- (See below for the actual view)
--
CREATE TABLE `v_sections_shs` (
`id` int(11)
,`sectionName` varchar(50)
,`adviserId` int(11)
,`user_Lname` varchar(200)
,`user_Fname` varchar(200)
,`user_Mname` varchar(200)
,`gender` varchar(12)
,`loadId` int(11)
,`b_loadName` varchar(200)
,`c_gradeLevel` int(11)
,`schoolYear` int(11)
,`d_subjectsContained` varchar(500)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `v_students_jhs`
-- (See below for the actual view)
--
CREATE TABLE `v_students_jhs` (
`id` int(11)
,`lrn` varchar(12)
,`lName` varchar(100)
,`fName` varchar(100)
,`mName` varchar(100)
,`sex` varchar(10)
,`inGr` float
,`curGrLvl` int(11)
,`schoolId` varchar(11)
,`schoolName` varchar(1000)
,`schoolAddress` varchar(1000)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `v_students_shs`
-- (See below for the actual view)
--
CREATE TABLE `v_students_shs` (
`id` int(11)
,`lrn` varchar(12)
,`lName` varchar(100)
,`fName` varchar(100)
,`mName` varchar(100)
,`sex` varchar(10)
,`inGr` float
,`curGrLvl` int(11)
,`schoolId` varchar(11)
,`schoolName` varchar(1000)
,`schoolAddress` varchar(1000)
,`strand` varchar(10)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `v_subjects_jhs`
-- (See below for the actual view)
--
CREATE TABLE `v_subjects_jhs` (
`id` int(11)
,`subjectCode` varchar(200)
,`description` varchar(500)
,`gradeLevel` int(11)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `v_subjects_shs`
-- (See below for the actual view)
--
CREATE TABLE `v_subjects_shs` (
`id` int(11)
,`subjectCode` varchar(200)
,`description` varchar(500)
,`gradeLevel` int(11)
,`sem` varchar(15)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `v_teacherloads`
-- (See below for the actual view)
--
CREATE TABLE `v_teacherloads` (
`id` int(11)
,`sectionId` int(11)
,`teacherId` int(11)
,`user_Lname` varchar(200)
,`user_Fname` varchar(200)
,`user_Mname` varchar(200)
,`gender` varchar(12)
,`subjectId` int(11)
,`subjectCode` varchar(200)
,`description` varchar(500)
,`gradeLevel` int(11)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `v_teacherloads_w_time`
-- (See below for the actual view)
--
CREATE TABLE `v_teacherloads_w_time` (
`id` int(11)
,`sectionId` int(11)
,`teacherId` int(11)
,`user_Lname` varchar(200)
,`user_Fname` varchar(200)
,`user_Mname` varchar(200)
,`gender` varchar(12)
,`subjectId` int(11)
,`subjectCode` varchar(200)
,`description` varchar(500)
,`gradeLevel` int(11)
,`timeStart` time
,`timeEnd` time
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `v_users_jhs`
-- (See below for the actual view)
--
CREATE TABLE `v_users_jhs` (
`id` int(11)
,`user_Lname` varchar(200)
,`user_Fname` varchar(200)
,`user_Mname` varchar(200)
,`gender` varchar(12)
,`user_name` varchar(200)
,`user_password` varchar(200)
,`user_level` int(11)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `v_users_shs`
-- (See below for the actual view)
--
CREATE TABLE `v_users_shs` (
`id` int(11)
,`user_Lname` varchar(200)
,`user_Fname` varchar(200)
,`user_Mname` varchar(200)
,`gender` varchar(12)
,`user_name` varchar(200)
,`user_password` varchar(200)
,`user_level` int(11)
);

-- --------------------------------------------------------

--
-- Structure for view `form_sf1_view`
--
DROP TABLE IF EXISTS `form_sf1_view`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `form_sf1_view`  AS SELECT `enrollment`.`id` AS `id`, `enrollment`.`studentId` AS `studentId`, `enrollment`.`sectionId` AS `sectionId`, `students`.`lrn` AS `lrn`, `students`.`lName` AS `lName`, `students`.`fName` AS `fName`, `students`.`mName` AS `mName`, `students`.`sex` AS `sex`, `personalinfo`.`bDate` AS `bDate`, `personalinfo`.`age` AS `age`, `personalinfo`.`mTongue` AS `mTongue`, `personalinfo`.`ip` AS `ip`, `personalinfo`.`rlgn` AS `rlgn`, `personalinfo`.`houseN` AS `houseN`, `personalinfo`.`brgy` AS `brgy`, `personalinfo`.`mncpl` AS `mncpl`, `personalinfo`.`prvnce` AS `prvnce`, `personalinfo`.`fName` AS `fathersName`, `personalinfo`.`mName` AS `mothersName`, `personalinfo`.`gName` AS `gName`, `personalinfo`.`rltnshp` AS `rltnshp`, `personalinfo`.`contact` AS `contact`, `enrollment`.`remarks` AS `remarks` FROM ((`enrollment` left join `students` on(`enrollment`.`studentId` = `students`.`id`)) left join `personalinfo` on(`enrollment`.`studentId` = `personalinfo`.`stdId`)) ORDER BY `enrollment`.`sectionId` DESC, `students`.`sex` DESC, `students`.`lName` ASC, `students`.`fName` ASC ;

-- --------------------------------------------------------

--
-- Structure for view `form_sf2_view`
--
DROP TABLE IF EXISTS `form_sf2_view`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `form_sf2_view`  AS SELECT `enrollment`.`id` AS `id`, `enrollment`.`sectionId` AS `sectionId`, `enrollment`.`studentId` AS `studentId`, `students`.`lName` AS `lName`, `students`.`fName` AS `fName`, `students`.`mName` AS `mName`, `students`.`sex` AS `sex`, `enrollment`.`dateEnrolled` AS `dateEnrolled`, `enrollment`.`remarks` AS `remarks` FROM (`enrollment` left join `students` on(`enrollment`.`studentId` = `students`.`id`)) ORDER BY `enrollment`.`sectionId` DESC, `students`.`sex` DESC, `students`.`lName` ASC, `students`.`fName` ASC, `students`.`mName` ASC ;

-- --------------------------------------------------------

--
-- Structure for view `form_sf3_view`
--
DROP TABLE IF EXISTS `form_sf3_view`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `form_sf3_view`  AS SELECT `enrollment`.`id` AS `id`, `enrollment`.`sectionId` AS `sectionId`, `enrollment`.`studentId` AS `studentId`, `students`.`lName` AS `lName`, `students`.`fName` AS `fName`, `students`.`mName` AS `mName`, `students`.`sex` AS `sex` FROM (`enrollment` left join `students` on(`enrollment`.`studentId` = `students`.`id`)) ORDER BY `enrollment`.`sectionId` DESC, `students`.`sex` DESC, `students`.`lName` ASC, `students`.`fName` ASC, `students`.`mName` ASC ;

-- --------------------------------------------------------

--
-- Structure for view `form_sf5_viewfull`
--
DROP TABLE IF EXISTS `form_sf5_viewfull`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `form_sf5_viewfull`  AS SELECT `finalgrades`.`id` AS `id`, `finalgrades`.`sectionId` AS `sectionId`, `sections`.`sectionName` AS `sectionName`, `sections`.`schoolYear` AS `schoolYear`, `loads`.`c_gradeLevel` AS `gradeLevel`, `sections`.`adviserId` AS `adviserId`, `users`.`user_Lname` AS `user_Lname`, `users`.`user_Fname` AS `user_Fname`, `users`.`user_Mname` AS `user_Mname`, `finalgrades`.`studentId` AS `studentId`, `students`.`lrn` AS `lrn`, `students`.`lName` AS `lName`, `students`.`fName` AS `fName`, `students`.`mName` AS `mName`, `students`.`sex` AS `sex`, `enrollment`.`remarks` AS `remarks`, `finalgrades`.`generalAverage` AS `generalAverage`, `finalgrades`.`actionTaken` AS `actionTaken`, `finalgrades`.`dateUpdated` AS `dateUpdated` FROM (((((`finalgrades` left join `sections` on(`finalgrades`.`sectionId` = `sections`.`id`)) left join `users` on(`sections`.`adviserId` = `users`.`id`)) left join `loads` on(`sections`.`loadId` = `loads`.`a_id`)) left join `students` on(`finalgrades`.`studentId` = `students`.`id`)) left join `enrollment` on(`enrollment`.`studentId` = `finalgrades`.`studentId` and `enrollment`.`sectionId` = `finalgrades`.`sectionId`)) ORDER BY `loads`.`c_gradeLevel` ASC, `finalgrades`.`sectionId` ASC, `students`.`sex` DESC, `students`.`lName` ASC, `students`.`fName` ASC, `students`.`mName` ASC ;

-- --------------------------------------------------------

--
-- Structure for view `form_sf5_viewminimal`
--
DROP TABLE IF EXISTS `form_sf5_viewminimal`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `form_sf5_viewminimal`  AS SELECT `finalgrades`.`id` AS `id`, `sections`.`id` AS `sectionId`, `loads`.`c_gradeLevel` AS `gradeLevel`, `finalgrades`.`studentId` AS `studentId`, `students`.`lrn` AS `lrn`, `students`.`lName` AS `lName`, `students`.`fName` AS `fName`, `students`.`mName` AS `mName`, `students`.`sex` AS `sex`, `enrollment`.`remarks` AS `remarks`, `finalgrades`.`generalAverage` AS `generalAverage`, `finalgrades`.`actionTaken` AS `actionTaken`, `finalgrades`.`failedSubjects` AS `failedSubjects`, `finalgrades`.`dateUpdated` AS `dateUpdated` FROM ((((`finalgrades` left join `sections` on(`finalgrades`.`sectionId` = `sections`.`id`)) left join `loads` on(`sections`.`loadId` = `loads`.`a_id`)) left join `students` on(`finalgrades`.`studentId` = `students`.`id`)) left join `enrollment` on(`enrollment`.`studentId` = `finalgrades`.`studentId` and `enrollment`.`sectionId` = `finalgrades`.`sectionId`)) ORDER BY `loads`.`c_gradeLevel` ASC, `finalgrades`.`sectionId` ASC, `students`.`sex` DESC, `students`.`lName` ASC, `students`.`fName` ASC, `students`.`mName` ASC ;

-- --------------------------------------------------------

--
-- Structure for view `form_sf7view_loads`
--
DROP TABLE IF EXISTS `form_sf7view_loads`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `form_sf7view_loads`  AS SELECT `teacherloads`.`id` AS `id`, `teacherloads`.`teacherId` AS `teacherId`, `teacherloads`.`sectionId` AS `sectionId`, `sections`.`sectionName` AS `sectionName`, `teacherloads`.`subjectId` AS `subjectId`, `subjects`.`subjectCode` AS `subjectCode`, `subjects`.`description` AS `description`, `subjects`.`gradeLevel` AS `gradeLevel`, `sections`.`schoolYear` AS `schoolYear` FROM ((`teacherloads` left join `sections` on(`teacherloads`.`sectionId` = `sections`.`id`)) left join `subjects` on(`teacherloads`.`subjectId` = `subjects`.`id`)) ORDER BY `teacherloads`.`teacherId` DESC, `subjects`.`gradeLevel` ASC, `sections`.`schoolYear` ASC, `sections`.`sectionName` ASC ;

-- --------------------------------------------------------

--
-- Structure for view `form_sf7view_teachers`
--
DROP TABLE IF EXISTS `form_sf7view_teachers`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `form_sf7view_teachers`  AS SELECT `users`.`id` AS `id`, ifnull(`userdetails`.`employeeNumber`,' ') AS `employeeNumber`, `users`.`user_Lname` AS `user_Lname`, `users`.`user_Fname` AS `user_Fname`, `users`.`user_Mname` AS `user_Mname`, `users`.`gender` AS `gender`, ifnull(`userdetails`.`fundSource`,' ') AS `fundSource`, ifnull(`userdetails`.`position`,' ') AS `position`, ifnull(`userdetails`.`nature`,' ') AS `nature`, ifnull(`userdetails`.`degree`,' ') AS `degree`, ifnull(`userdetails`.`major`,' ') AS `major`, ifnull(`userdetails`.`minor`,' ') AS `minor`, `users`.`user_level` AS `user_level` FROM (`users` left join `userdetails` on(`users`.`id` = `userdetails`.`userId`)) ORDER BY `users`.`user_Lname` ASC, `users`.`user_Fname` ASC, `users`.`user_Mname` ASC ;

-- --------------------------------------------------------

--
-- Structure for view `form_sf8_view`
--
DROP TABLE IF EXISTS `form_sf8_view`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `form_sf8_view`  AS SELECT `enrollment`.`id` AS `id`, `enrollment`.`studentId` AS `studentId`, `enrollment`.`sectionId` AS `sectionId`, `students`.`lrn` AS `lrn`, `students`.`lName` AS `lName`, `students`.`fName` AS `fName`, `students`.`mName` AS `mName`, date_format(`personalinfo`.`bDate`,'%m/%d/%Y') AS `bDate`, `students`.`sex` AS `sex`, ifnull(`bmi`.`id`,-1) AS `bmiId`, ifnull(`bmi`.`age`,'0: 0') AS `age`, ifnull(`bmi`.`weight`,0) AS `weight`, ifnull(`bmi`.`height`,'0.0') AS `height`, ifnull(`bmi`.`heightSq`,'0.0000') AS `heightSq`, ifnull(`bmi`.`bmi`,'0.0') AS `bmi`, ifnull(`bmi`.`bmiForAge`,'No Record') AS `bmiForAge`, ifnull(`bmi`.`heightForAge`,'No Record') AS `heightForAge`, ifnull(`bmi`.`dateExamined`,current_timestamp()) AS `dateExamined` FROM (((`enrollment` left join `students` on(`enrollment`.`studentId` = `students`.`id`)) left join `personalinfo` on(`enrollment`.`studentId` = `personalinfo`.`stdId`)) left join `bmi` on(`enrollment`.`studentId` = `bmi`.`studentId` and `enrollment`.`sectionId` = `bmi`.`sectionId`)) ORDER BY `enrollment`.`sectionId` ASC, `students`.`sex` DESC, `students`.`lName` ASC, `students`.`fName` ASC, `students`.`mName` ASC ;

-- --------------------------------------------------------

--
-- Structure for view `form_sf9_view`
--
DROP TABLE IF EXISTS `form_sf9_view`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `form_sf9_view`  AS SELECT `grades`.`id` AS `id`, `grades`.`studentId` AS `studentId`, `grades`.`sectionId` AS `sectionId`, `grades`.`subjectId` AS `subjectId`, `subjects`.`subjectCode` AS `subjectCode`, `subjects`.`description` AS `description`, `grades`.`firstQuarter` AS `firstQuarter`, `grades`.`secondQuarter` AS `secondQuarter`, `grades`.`thirdQuarter` AS `thirdQuarter`, `grades`.`fourthQuarter` AS `fourthQuarter`, `grades`.`gwa` AS `gwa`, `grades`.`status` AS `status`, `grades`.`dateUpdated` AS `dateUpdated` FROM (`grades` left join `subjects` on(`subjects`.`id` = `grades`.`subjectId`)) ORDER BY `grades`.`sectionId` DESC, `grades`.`studentId` ASC ;

-- --------------------------------------------------------

--
-- Structure for view `form_sf10_view`
--
DROP TABLE IF EXISTS `form_sf10_view`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `form_sf10_view`  AS SELECT `enrollment`.`id` AS `id`, `enrollment`.`studentId` AS `studentId`, `students`.`lrn` AS `lrn`, `students`.`lName` AS `lName`, `students`.`fName` AS `fName`, `students`.`mName` AS `mName`, `students`.`sex` AS `sex`, `enrollment`.`sectionId` AS `sectionId`, `sections`.`sectionName` AS `sectionName`, `sections`.`adviserId` AS `adviserId`, `users`.`user_Lname` AS `user_Lname`, `users`.`user_Fname` AS `user_Fname`, `users`.`user_Mname` AS `user_Mname`, `users`.`gender` AS `gender`, `sections`.`loadId` AS `loadId`, `loads`.`b_loadName` AS `loadName`, `loads`.`c_gradeLevel` AS `gradeLevel`, `loads`.`d_subjectsContained` AS `subjectsContained`, `sections`.`schoolYear` AS `schoolYear`, `enrollment`.`remarks` AS `remarks`, `enrollment`.`dateEnrolled` AS `dateEnrolled` FROM ((((`enrollment` left join `students` on(`enrollment`.`studentId` = `students`.`id`)) left join `sections` on(`enrollment`.`sectionId` = `sections`.`id`)) left join `users` on(`sections`.`adviserId` = `users`.`id`)) left join `loads` on(`sections`.`loadId` = `loads`.`a_id`)) ORDER BY `enrollment`.`studentId` DESC, `loads`.`c_gradeLevel` ASC, `sections`.`schoolYear` ASC, `enrollment`.`dateEnrolled` ASC ;

-- --------------------------------------------------------

--
-- Structure for view `v_enrollment`
--
DROP TABLE IF EXISTS `v_enrollment`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_enrollment`  AS SELECT `enrollment`.`id` AS `id`, `enrollment`.`studentId` AS `studentId`, `students`.`lrn` AS `lrn`, `students`.`lName` AS `lName`, `students`.`fName` AS `fName`, `students`.`mName` AS `mName`, `students`.`sex` AS `sex`, `enrollment`.`sectionId` AS `sectionId`, `sections`.`sectionName` AS `sectionName`, `sections`.`adviserId` AS `adviserId`, `users`.`user_Lname` AS `user_Lname`, `users`.`user_Fname` AS `user_Fname`, `users`.`user_Mname` AS `user_Mname`, `sections`.`loadId` AS `loadId`, `loads`.`b_loadName` AS `b_loadName`, `loads`.`c_gradeLevel` AS `c_gradeLevel`, `sections`.`schoolYear` AS `schoolYear`, `enrollment`.`dateEnrolled` AS `dateEnrolled` FROM ((((`enrollment` left join `students` on(`enrollment`.`studentId` = `students`.`id`)) left join `sections` on(`enrollment`.`sectionId` = `sections`.`id`)) left join `users` on(`sections`.`adviserId` = `users`.`id`)) left join `loads` on(`sections`.`loadId` = `loads`.`a_id`)) ;

-- --------------------------------------------------------

--
-- Structure for view `v_enrollment_jhs`
--
DROP TABLE IF EXISTS `v_enrollment_jhs`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_enrollment_jhs`  AS SELECT `enrollment`.`id` AS `id`, `enrollment`.`studentId` AS `studentId`, `students`.`lrn` AS `lrn`, `students`.`lName` AS `lName`, `students`.`fName` AS `fName`, `students`.`mName` AS `mName`, `students`.`sex` AS `sex`, `enrollment`.`sectionId` AS `sectionId`, `sections`.`sectionName` AS `sectionName`, `sections`.`adviserId` AS `adviserId`, `users`.`user_Lname` AS `user_Lname`, `users`.`user_Fname` AS `user_Fname`, `users`.`user_Mname` AS `user_Mname`, `sections`.`loadId` AS `loadId`, `loads`.`b_loadName` AS `b_loadName`, `loads`.`c_gradeLevel` AS `c_gradeLevel`, `sections`.`schoolYear` AS `schoolYear`, `enrollment`.`dateEnrolled` AS `dateEnrolled` FROM ((((`enrollment` left join `students` on(`enrollment`.`studentId` = `students`.`id`)) left join `sections` on(`enrollment`.`sectionId` = `sections`.`id`)) left join `users` on(`sections`.`adviserId` = `users`.`id`)) left join `loads` on(`sections`.`loadId` = `loads`.`a_id`)) WHERE `enrollment`.`dep_type` = 'JHS' ;

-- --------------------------------------------------------

--
-- Structure for view `v_enrollment_minimal`
--
DROP TABLE IF EXISTS `v_enrollment_minimal`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_enrollment_minimal`  AS SELECT `enrollment`.`id` AS `id`, `enrollment`.`studentId` AS `studentId`, `students`.`lrn` AS `lrn`, `students`.`lName` AS `lName`, `students`.`fName` AS `fName`, `students`.`mName` AS `mName`, `students`.`sex` AS `sex`, `enrollment`.`sectionId` AS `sectionId`, `enrollment`.`remarks` AS `remarks` FROM (`enrollment` left join `students` on(`enrollment`.`studentId` = `students`.`id`)) ORDER BY `enrollment`.`sectionId` DESC, `students`.`sex` DESC, `students`.`lName` ASC, `students`.`fName` ASC, `students`.`mName` ASC ;

-- --------------------------------------------------------

--
-- Structure for view `v_enrollment_minimal_jhs`
--
DROP TABLE IF EXISTS `v_enrollment_minimal_jhs`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_enrollment_minimal_jhs`  AS SELECT `enrollment`.`id` AS `id`, `enrollment`.`studentId` AS `studentId`, `students`.`lrn` AS `lrn`, `students`.`lName` AS `lName`, `students`.`fName` AS `fName`, `students`.`mName` AS `mName`, `students`.`sex` AS `sex`, `enrollment`.`sectionId` AS `sectionId`, `enrollment`.`remarks` AS `remarks` FROM (`enrollment` left join `students` on(`enrollment`.`studentId` = `students`.`id`)) WHERE `enrollment`.`dep_type` = 'JHS' ORDER BY `enrollment`.`sectionId` DESC, `students`.`sex` DESC, `students`.`lName` ASC, `students`.`fName` ASC, `students`.`mName` ASC ;

-- --------------------------------------------------------

--
-- Structure for view `v_enrollment_minimal_shs`
--
DROP TABLE IF EXISTS `v_enrollment_minimal_shs`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_enrollment_minimal_shs`  AS SELECT `enrollment`.`id` AS `id`, `enrollment`.`studentId` AS `studentId`, `students`.`lrn` AS `lrn`, `students`.`lName` AS `lName`, `students`.`fName` AS `fName`, `students`.`mName` AS `mName`, `students`.`sex` AS `sex`, `enrollment`.`sectionId` AS `sectionId`, `enrollment`.`remarks` AS `remarks` FROM (`enrollment` left join `students` on(`enrollment`.`studentId` = `students`.`id`)) WHERE `enrollment`.`dep_type` = 'SHS' ORDER BY `enrollment`.`sectionId` DESC, `students`.`sex` DESC, `students`.`lName` ASC, `students`.`fName` ASC, `students`.`mName` ASC ;

-- --------------------------------------------------------

--
-- Structure for view `v_enrollment_mini_wbdate`
--
DROP TABLE IF EXISTS `v_enrollment_mini_wbdate`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_enrollment_mini_wbdate`  AS SELECT `enrollment`.`id` AS `id`, `enrollment`.`studentId` AS `studentId`, `students`.`lrn` AS `lrn`, `students`.`lName` AS `lName`, `students`.`fName` AS `fName`, `students`.`mName` AS `mName`, `students`.`sex` AS `sex`, `personalinfo`.`bDate` AS `bDate`, `enrollment`.`sectionId` AS `sectionId` FROM ((`enrollment` left join `students` on(`enrollment`.`studentId` = `students`.`id`)) left join `personalinfo` on(`enrollment`.`studentId` = `personalinfo`.`stdId`)) ORDER BY `enrollment`.`sectionId` DESC, `students`.`sex` DESC, `students`.`lName` ASC, `students`.`fName` ASC, `students`.`mName` ASC ;

-- --------------------------------------------------------

--
-- Structure for view `v_enrollment_mini_wbdate_jhs`
--
DROP TABLE IF EXISTS `v_enrollment_mini_wbdate_jhs`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_enrollment_mini_wbdate_jhs`  AS SELECT `enrollment`.`id` AS `id`, `enrollment`.`studentId` AS `studentId`, `students`.`lrn` AS `lrn`, `students`.`lName` AS `lName`, `students`.`fName` AS `fName`, `students`.`mName` AS `mName`, `students`.`sex` AS `sex`, ifnull(`personalinfo`.`bDate`,'NOT SET') AS `bDate`, `enrollment`.`sectionId` AS `sectionId` FROM ((`enrollment` left join `students` on(`enrollment`.`studentId` = `students`.`id`)) left join `personalinfo` on(`enrollment`.`studentId` = `personalinfo`.`stdId`)) WHERE `enrollment`.`dep_type` = 'JHS' ORDER BY `enrollment`.`sectionId` DESC, `students`.`sex` DESC, `students`.`lName` ASC, `students`.`fName` ASC, `students`.`mName` ASC ;

-- --------------------------------------------------------

--
-- Structure for view `v_enrollment_mini_wbdate_shs`
--
DROP TABLE IF EXISTS `v_enrollment_mini_wbdate_shs`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_enrollment_mini_wbdate_shs`  AS SELECT `enrollment`.`id` AS `id`, `enrollment`.`studentId` AS `studentId`, `students`.`lrn` AS `lrn`, `students`.`lName` AS `lName`, `students`.`fName` AS `fName`, `students`.`mName` AS `mName`, `students`.`sex` AS `sex`, ifnull(`personalinfo`.`bDate`,'NOT SET') AS `bDate`, `enrollment`.`sectionId` AS `sectionId` FROM ((`enrollment` left join `students` on(`enrollment`.`studentId` = `students`.`id`)) left join `personalinfo` on(`enrollment`.`studentId` = `personalinfo`.`stdId`)) WHERE `enrollment`.`dep_type` = 'SHS' ORDER BY `enrollment`.`sectionId` DESC, `students`.`sex` DESC, `students`.`lName` ASC, `students`.`fName` ASC, `students`.`mName` ASC ;

-- --------------------------------------------------------

--
-- Structure for view `v_enrollment_shs`
--
DROP TABLE IF EXISTS `v_enrollment_shs`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_enrollment_shs`  AS SELECT `enrollment`.`id` AS `id`, `enrollment`.`studentId` AS `studentId`, `students`.`lrn` AS `lrn`, `students`.`lName` AS `lName`, `students`.`fName` AS `fName`, `students`.`mName` AS `mName`, `students`.`sex` AS `sex`, `enrollment`.`sectionId` AS `sectionId`, `sections`.`sectionName` AS `sectionName`, `sections`.`adviserId` AS `adviserId`, `users`.`user_Lname` AS `user_Lname`, `users`.`user_Fname` AS `user_Fname`, `users`.`user_Mname` AS `user_Mname`, `sections`.`loadId` AS `loadId`, `loads`.`b_loadName` AS `b_loadName`, `loads`.`c_gradeLevel` AS `c_gradeLevel`, `sections`.`schoolYear` AS `schoolYear`, `enrollment`.`dateEnrolled` AS `dateEnrolled` FROM ((((`enrollment` left join `students` on(`enrollment`.`studentId` = `students`.`id`)) left join `sections` on(`enrollment`.`sectionId` = `sections`.`id`)) left join `users` on(`sections`.`adviserId` = `users`.`id`)) left join `loads` on(`sections`.`loadId` = `loads`.`a_id`)) WHERE `enrollment`.`dep_type` = 'SHS' ;

-- --------------------------------------------------------

--
-- Structure for view `v_grades`
--
DROP TABLE IF EXISTS `v_grades`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_grades`  AS SELECT `grades`.`id` AS `id`, `grades`.`sectionId` AS `sectionId`, `grades`.`studentId` AS `studentId`, `teacherloads`.`teacherId` AS `teacherId`, ifnull(`users`.`user_Lname`,'None') AS `user_Lname`, ifnull(`users`.`user_Fname`,'None') AS `user_Fname`, ifnull(`users`.`user_Mname`,'None') AS `user_Mname`, ifnull(`users`.`gender`,'None') AS `gender`, `grades`.`subjectId` AS `subjectId`, `subjects`.`subjectCode` AS `subjectCode`, `subjects`.`description` AS `description`, `subjects`.`gradeLevel` AS `gradeLevel`, `grades`.`gwa` AS `gwa`, `grades`.`status` AS `status`, `grades`.`dateUpdated` AS `dateUpdated` FROM (((`grades` left join `teacherloads` on(`grades`.`subjectId` = `teacherloads`.`subjectId`)) left join `users` on(`teacherloads`.`teacherId` = `users`.`id`)) left join `subjects` on(`subjects`.`id` = `grades`.`subjectId`)) ORDER BY `grades`.`sectionId` ASC, `grades`.`subjectId` ASC, `grades`.`studentId` ASC ;

-- --------------------------------------------------------

--
-- Structure for view `v_loads_jhs`
--
DROP TABLE IF EXISTS `v_loads_jhs`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_loads_jhs`  AS SELECT `loads`.`a_id` AS `a_id`, `loads`.`b_loadName` AS `b_loadName`, `loads`.`c_gradeLevel` AS `c_gradeLevel`, `loads`.`d_subjectsContained` AS `d_subjectsContained` FROM `loads` WHERE `loads`.`dep_type` = 'JHS' ORDER BY `loads`.`b_loadName` ASC ;

-- --------------------------------------------------------

--
-- Structure for view `v_loads_shs`
--
DROP TABLE IF EXISTS `v_loads_shs`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_loads_shs`  AS SELECT `loads`.`a_id` AS `a_id`, `loads`.`b_loadName` AS `b_loadName`, `loads`.`c_gradeLevel` AS `c_gradeLevel`, `loads`.`d_subjectsContained` AS `d_subjectsContained` FROM `loads` WHERE `loads`.`dep_type` = 'SHS' ORDER BY `loads`.`b_loadName` ASC ;

-- --------------------------------------------------------

--
-- Structure for view `v_managedsubjects`
--
DROP TABLE IF EXISTS `v_managedsubjects`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_managedsubjects`  AS SELECT `teacherloads`.`id` AS `id`, `teacherloads`.`sectionId` AS `sectionId`, `sections`.`sectionName` AS `sectionName`, `teacherloads`.`teacherId` AS `teacherId`, ifnull(`users`.`user_Lname`,'None') AS `user_Lname`, ifnull(`users`.`user_Fname`,'None') AS `user_Fname`, ifnull(`users`.`user_Mname`,'None') AS `user_Mname`, ifnull(`users`.`gender`,'None') AS `gender`, `teacherloads`.`subjectId` AS `subjectId`, `subjects`.`subjectCode` AS `subjectCode`, `subjects`.`description` AS `description`, `subjects`.`gradeLevel` AS `gradeLevel`, `sections`.`schoolYear` AS `schoolYear` FROM (((`teacherloads` left join `sections` on(`teacherloads`.`sectionId` = `sections`.`id`)) left join `users` on(`teacherloads`.`teacherId` = `users`.`id`)) left join `subjects` on(`teacherloads`.`subjectId` = `subjects`.`id`)) ORDER BY `sections`.`schoolYear` DESC, `subjects`.`gradeLevel` ASC, `sections`.`sectionName` ASC, `users`.`user_Lname` ASC, `users`.`user_Fname` ASC ;

-- --------------------------------------------------------

--
-- Structure for view `v_managedsubjects_wbooktemplate`
--
DROP TABLE IF EXISTS `v_managedsubjects_wbooktemplate`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_managedsubjects_wbooktemplate`  AS SELECT `teacherloads`.`id` AS `id`, `teacherloads`.`sectionId` AS `sectionId`, `sections`.`sectionName` AS `sectionName`, `teacherloads`.`teacherId` AS `teacherId`, ifnull(`users`.`user_Lname`,'None') AS `user_Lname`, ifnull(`users`.`user_Fname`,'None') AS `user_Fname`, ifnull(`users`.`user_Mname`,'None') AS `user_Mname`, ifnull(`users`.`gender`,'None') AS `gender`, `teacherloads`.`subjectId` AS `subjectId`, `subjects`.`subjectCode` AS `subjectCode`, `subjects`.`description` AS `description`, `subjects`.`gradeLevel` AS `gradeLevel`, `sections`.`schoolYear` AS `schoolYear`, `sections`.`bookTemplateId` AS `bookTemplateId`, ifnull(`booktemplates`.`templateName`,'None') AS `templateName`, ifnull(`booktemplates`.`booksContained`,'None') AS `booksContained` FROM ((((`teacherloads` left join `sections` on(`teacherloads`.`sectionId` = `sections`.`id`)) left join `users` on(`teacherloads`.`teacherId` = `users`.`id`)) left join `subjects` on(`teacherloads`.`subjectId` = `subjects`.`id`)) left join `booktemplates` on(`sections`.`bookTemplateId` = `booktemplates`.`id`)) ORDER BY `sections`.`schoolYear` DESC, `subjects`.`gradeLevel` ASC, `sections`.`sectionName` ASC, `users`.`user_Lname` ASC, `users`.`user_Fname` ASC ;

-- --------------------------------------------------------

--
-- Structure for view `v_managedsubjects_wsubjectscontained`
--
DROP TABLE IF EXISTS `v_managedsubjects_wsubjectscontained`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_managedsubjects_wsubjectscontained`  AS SELECT `teacherloads`.`id` AS `id`, `teacherloads`.`sectionId` AS `sectionId`, `sections`.`sectionName` AS `sectionName`, `teacherloads`.`teacherId` AS `teacherId`, ifnull(`users`.`user_Lname`,'None') AS `user_Lname`, ifnull(`users`.`user_Fname`,'None') AS `user_Fname`, ifnull(`users`.`user_Mname`,'None') AS `user_Mname`, ifnull(`users`.`gender`,'None') AS `gender`, `teacherloads`.`subjectId` AS `subjectId`, `subjects`.`subjectCode` AS `subjectCode`, `subjects`.`description` AS `description`, `subjects`.`gradeLevel` AS `gradeLevel`, `sections`.`schoolYear` AS `schoolYear`, `loads`.`a_id` AS `loadId`, `loads`.`b_loadName` AS `loadName`, `loads`.`d_subjectsContained` AS `subjectsContained` FROM ((((`teacherloads` left join `sections` on(`teacherloads`.`sectionId` = `sections`.`id`)) left join `users` on(`teacherloads`.`teacherId` = `users`.`id`)) left join `subjects` on(`teacherloads`.`subjectId` = `subjects`.`id`)) left join `loads` on(`sections`.`loadId` = `loads`.`a_id`)) ORDER BY `sections`.`schoolYear` DESC, `subjects`.`gradeLevel` ASC, `sections`.`sectionName` ASC, `users`.`user_Lname` ASC, `users`.`user_Fname` ASC ;

-- --------------------------------------------------------

--
-- Structure for view `v_sections`
--
DROP TABLE IF EXISTS `v_sections`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_sections`  AS SELECT `sections`.`id` AS `id`, `sections`.`sectionName` AS `sectionName`, `sections`.`adviserId` AS `adviserId`, `users`.`user_Lname` AS `user_Lname`, `users`.`user_Fname` AS `user_Fname`, `users`.`user_Mname` AS `user_Mname`, `users`.`gender` AS `gender`, `sections`.`loadId` AS `loadId`, `loads`.`b_loadName` AS `b_loadName`, `loads`.`c_gradeLevel` AS `c_gradeLevel`, `sections`.`schoolYear` AS `schoolYear`, `loads`.`d_subjectsContained` AS `d_subjectsContained` FROM ((`sections` left join `users` on(`sections`.`adviserId` = `users`.`id`)) left join `loads` on(`sections`.`loadId` = `loads`.`a_id`)) ORDER BY `sections`.`schoolYear` DESC, `loads`.`c_gradeLevel` ASC, `sections`.`sectionName` ASC ;

-- --------------------------------------------------------

--
-- Structure for view `v_sections_jhs`
--
DROP TABLE IF EXISTS `v_sections_jhs`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_sections_jhs`  AS SELECT `sections`.`id` AS `id`, `sections`.`sectionName` AS `sectionName`, `sections`.`adviserId` AS `adviserId`, `users`.`user_Lname` AS `user_Lname`, `users`.`user_Fname` AS `user_Fname`, `users`.`user_Mname` AS `user_Mname`, `users`.`gender` AS `gender`, `sections`.`loadId` AS `loadId`, `loads`.`b_loadName` AS `b_loadName`, `loads`.`c_gradeLevel` AS `c_gradeLevel`, `sections`.`schoolYear` AS `schoolYear`, `loads`.`d_subjectsContained` AS `d_subjectsContained` FROM ((`sections` left join `users` on(`sections`.`adviserId` = `users`.`id`)) left join `loads` on(`sections`.`loadId` = `loads`.`a_id`)) WHERE `sections`.`dep_type` = 'JHS' ORDER BY `sections`.`schoolYear` DESC, `loads`.`c_gradeLevel` ASC, `sections`.`sectionName` ASC ;

-- --------------------------------------------------------

--
-- Structure for view `v_sections_shs`
--
DROP TABLE IF EXISTS `v_sections_shs`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_sections_shs`  AS SELECT `sections`.`id` AS `id`, `sections`.`sectionName` AS `sectionName`, `sections`.`adviserId` AS `adviserId`, `users`.`user_Lname` AS `user_Lname`, `users`.`user_Fname` AS `user_Fname`, `users`.`user_Mname` AS `user_Mname`, `users`.`gender` AS `gender`, `sections`.`loadId` AS `loadId`, `loads`.`b_loadName` AS `b_loadName`, `loads`.`c_gradeLevel` AS `c_gradeLevel`, `sections`.`schoolYear` AS `schoolYear`, `loads`.`d_subjectsContained` AS `d_subjectsContained` FROM ((`sections` left join `users` on(`sections`.`adviserId` = `users`.`id`)) left join `loads` on(`sections`.`loadId` = `loads`.`a_id`)) WHERE `sections`.`dep_type` = 'SHS' ORDER BY `sections`.`schoolYear` DESC, `loads`.`c_gradeLevel` ASC, `sections`.`sectionName` ASC ;

-- --------------------------------------------------------

--
-- Structure for view `v_students_jhs`
--
DROP TABLE IF EXISTS `v_students_jhs`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_students_jhs`  AS SELECT `students`.`id` AS `id`, `students`.`lrn` AS `lrn`, `students`.`lName` AS `lName`, `students`.`fName` AS `fName`, `students`.`mName` AS `mName`, `students`.`sex` AS `sex`, `students`.`inGr` AS `inGr`, `students`.`curGrLvl` AS `curGrLvl`, `students`.`schoolId` AS `schoolId`, `students`.`schoolName` AS `schoolName`, `students`.`schoolAddress` AS `schoolAddress` FROM `students` WHERE `students`.`dep_type` = 'JHS' ;

-- --------------------------------------------------------

--
-- Structure for view `v_students_shs`
--
DROP TABLE IF EXISTS `v_students_shs`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_students_shs`  AS SELECT `students`.`id` AS `id`, `students`.`lrn` AS `lrn`, `students`.`lName` AS `lName`, `students`.`fName` AS `fName`, `students`.`mName` AS `mName`, `students`.`sex` AS `sex`, `students`.`inGr` AS `inGr`, `students`.`curGrLvl` AS `curGrLvl`, `students`.`schoolId` AS `schoolId`, `students`.`schoolName` AS `schoolName`, `students`.`schoolAddress` AS `schoolAddress`, `students`.`strand` AS `strand` FROM `students` WHERE `students`.`dep_type` = 'SHS' ;

-- --------------------------------------------------------

--
-- Structure for view `v_subjects_jhs`
--
DROP TABLE IF EXISTS `v_subjects_jhs`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_subjects_jhs`  AS SELECT `subjects`.`id` AS `id`, `subjects`.`subjectCode` AS `subjectCode`, `subjects`.`description` AS `description`, `subjects`.`gradeLevel` AS `gradeLevel` FROM `subjects` WHERE `subjects`.`dep_type` = 'JHS' ORDER BY `subjects`.`gradeLevel` ASC ;

-- --------------------------------------------------------

--
-- Structure for view `v_subjects_shs`
--
DROP TABLE IF EXISTS `v_subjects_shs`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_subjects_shs`  AS SELECT `subjects`.`id` AS `id`, `subjects`.`subjectCode` AS `subjectCode`, `subjects`.`description` AS `description`, `subjects`.`gradeLevel` AS `gradeLevel`, `subjects`.`sem` AS `sem` FROM `subjects` WHERE `subjects`.`dep_type` = 'SHS' ORDER BY `subjects`.`gradeLevel` ASC ;

-- --------------------------------------------------------

--
-- Structure for view `v_teacherloads`
--
DROP TABLE IF EXISTS `v_teacherloads`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_teacherloads`  AS SELECT `teacherloads`.`id` AS `id`, `teacherloads`.`sectionId` AS `sectionId`, `teacherloads`.`teacherId` AS `teacherId`, ifnull(`users`.`user_Lname`,'None') AS `user_Lname`, ifnull(`users`.`user_Fname`,'None') AS `user_Fname`, ifnull(`users`.`user_Mname`,'None') AS `user_Mname`, ifnull(`users`.`gender`,'None') AS `gender`, `teacherloads`.`subjectId` AS `subjectId`, `subjects`.`subjectCode` AS `subjectCode`, `subjects`.`description` AS `description`, `subjects`.`gradeLevel` AS `gradeLevel` FROM ((`teacherloads` left join `users` on(`teacherloads`.`teacherId` = `users`.`id`)) left join `subjects` on(`teacherloads`.`subjectId` = `subjects`.`id`)) ;

-- --------------------------------------------------------

--
-- Structure for view `v_teacherloads_w_time`
--
DROP TABLE IF EXISTS `v_teacherloads_w_time`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_teacherloads_w_time`  AS SELECT `teacherloads`.`id` AS `id`, `teacherloads`.`sectionId` AS `sectionId`, `teacherloads`.`teacherId` AS `teacherId`, ifnull(`users`.`user_Lname`,'None') AS `user_Lname`, ifnull(`users`.`user_Fname`,'None') AS `user_Fname`, ifnull(`users`.`user_Mname`,'None') AS `user_Mname`, ifnull(`users`.`gender`,'None') AS `gender`, `teacherloads`.`subjectId` AS `subjectId`, `subjects`.`subjectCode` AS `subjectCode`, `subjects`.`description` AS `description`, `subjects`.`gradeLevel` AS `gradeLevel`, `teacherloads`.`timeStart` AS `timeStart`, `teacherloads`.`timeEnd` AS `timeEnd` FROM ((`teacherloads` left join `users` on(`teacherloads`.`teacherId` = `users`.`id`)) left join `subjects` on(`teacherloads`.`subjectId` = `subjects`.`id`)) ;

-- --------------------------------------------------------

--
-- Structure for view `v_users_jhs`
--
DROP TABLE IF EXISTS `v_users_jhs`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_users_jhs`  AS SELECT `users`.`id` AS `id`, `users`.`user_Lname` AS `user_Lname`, `users`.`user_Fname` AS `user_Fname`, `users`.`user_Mname` AS `user_Mname`, `users`.`gender` AS `gender`, `users`.`user_name` AS `user_name`, `users`.`user_password` AS `user_password`, `users`.`user_level` AS `user_level` FROM `users` WHERE `users`.`dep_type` = 'JHS' ORDER BY `users`.`user_level` DESC, `users`.`user_Lname` ASC, `users`.`user_Fname` ASC, `users`.`user_Mname` ASC ;

-- --------------------------------------------------------

--
-- Structure for view `v_users_shs`
--
DROP TABLE IF EXISTS `v_users_shs`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_users_shs`  AS SELECT `users`.`id` AS `id`, `users`.`user_Lname` AS `user_Lname`, `users`.`user_Fname` AS `user_Fname`, `users`.`user_Mname` AS `user_Mname`, `users`.`gender` AS `gender`, `users`.`user_name` AS `user_name`, `users`.`user_password` AS `user_password`, `users`.`user_level` AS `user_level` FROM `users` WHERE `users`.`dep_type` = 'SHS' ORDER BY `users`.`user_level` DESC, `users`.`user_Lname` ASC, `users`.`user_Fname` ASC, `users`.`user_Mname` ASC ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `attendance`
--
ALTER TABLE `attendance`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `bmi`
--
ALTER TABLE `bmi`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `bmichart_female`
--
ALTER TABLE `bmichart_female`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `bmichart_male`
--
ALTER TABLE `bmichart_male`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `books`
--
ALTER TABLE `books`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `booksissuedreturned`
--
ALTER TABLE `booksissuedreturned`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `booktemplates`
--
ALTER TABLE `booktemplates`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `enrollment`
--
ALTER TABLE `enrollment`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `enrollment_static`
--
ALTER TABLE `enrollment_static`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `finalgrades`
--
ALTER TABLE `finalgrades`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `grades`
--
ALTER TABLE `grades`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `grades_static`
--
ALTER TABLE `grades_static`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `hfachart_female`
--
ALTER TABLE `hfachart_female`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `hfachart_male`
--
ALTER TABLE `hfachart_male`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `loads`
--
ALTER TABLE `loads`
  ADD PRIMARY KEY (`a_id`);

--
-- Indexes for table `personalinfo`
--
ALTER TABLE `personalinfo`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `sections`
--
ALTER TABLE `sections`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `students`
--
ALTER TABLE `students`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `subjects`
--
ALTER TABLE `subjects`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `teacherloads`
--
ALTER TABLE `teacherloads`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `userdetails`
--
ALTER TABLE `userdetails`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `attendance`
--
ALTER TABLE `attendance`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT for table `bmi`
--
ALTER TABLE `bmi`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `bmichart_female`
--
ALTER TABLE `bmichart_female`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=98;

--
-- AUTO_INCREMENT for table `bmichart_male`
--
ALTER TABLE `bmichart_male`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=98;

--
-- AUTO_INCREMENT for table `books`
--
ALTER TABLE `books`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `booksissuedreturned`
--
ALTER TABLE `booksissuedreturned`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `booktemplates`
--
ALTER TABLE `booktemplates`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `enrollment`
--
ALTER TABLE `enrollment`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT for table `enrollment_static`
--
ALTER TABLE `enrollment_static`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `finalgrades`
--
ALTER TABLE `finalgrades`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `grades`
--
ALTER TABLE `grades`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `grades_static`
--
ALTER TABLE `grades_static`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `hfachart_female`
--
ALTER TABLE `hfachart_female`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=98;

--
-- AUTO_INCREMENT for table `hfachart_male`
--
ALTER TABLE `hfachart_male`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=97;

--
-- AUTO_INCREMENT for table `loads`
--
ALTER TABLE `loads`
  MODIFY `a_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `personalinfo`
--
ALTER TABLE `personalinfo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT for table `sections`
--
ALTER TABLE `sections`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `students`
--
ALTER TABLE `students`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- AUTO_INCREMENT for table `subjects`
--
ALTER TABLE `subjects`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=79;

--
-- AUTO_INCREMENT for table `teacherloads`
--
ALTER TABLE `teacherloads`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT for table `userdetails`
--
ALTER TABLE `userdetails`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
