-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 21, 2021 at 10:34 AM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 7.4.24

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

-- --------------------------------------------------------

--
-- Structure for view `form_sf5_viewfull_shs`
--

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `form_sf5_viewfull_shs`  AS SELECT `finalgrades`.`id` AS `id`, `finalgrades`.`sectionId` AS `sectionId`, `sections`.`sectionName` AS `sectionName`, `sections`.`schoolYear` AS `schoolYear`, `loads`.`c_gradeLevel` AS `gradeLevel`, `sections`.`adviserId` AS `adviserId`, `users`.`user_Lname` AS `user_Lname`, `users`.`user_Fname` AS `user_Fname`, `users`.`user_Mname` AS `user_Mname`, `finalgrades`.`studentId` AS `studentId`, `students`.`lrn` AS `lrn`, `students`.`lName` AS `lName`, `students`.`fName` AS `fName`, `students`.`mName` AS `mName`, `enrollment`.`strand` AS `strand`, `students`.`sex` AS `sex`, `enrollment`.`remarks` AS `remarks`, `finalgrades`.`generalAverage` AS `generalAverage`, `finalgrades`.`actionTaken` AS `actionTaken`, `finalgrades`.`dateUpdated` AS `dateUpdated`, `enrollment`.`sem` AS `sem` FROM (((((`finalgrades` left join `sections` on(`finalgrades`.`sectionId` = `sections`.`id`)) left join `users` on(`sections`.`adviserId` = `users`.`id`)) left join `loads` on(`sections`.`loadId` = `loads`.`a_id`)) left join `students` on(`finalgrades`.`studentId` = `students`.`id`)) left join `enrollment` on(`enrollment`.`studentId` = `finalgrades`.`studentId` and `enrollment`.`sectionId` = `finalgrades`.`sectionId`)) WHERE `enrollment`.`dep_type` = 'SHS' ORDER BY `loads`.`c_gradeLevel` ASC, `finalgrades`.`sectionId` ASC, `students`.`sex` DESC, `students`.`lName` ASC, `students`.`fName` ASC, `students`.`mName` ASC ;

--
-- VIEW `form_sf5_viewfull_shs`
-- Data: None
--

COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
