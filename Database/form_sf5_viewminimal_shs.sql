-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 20, 2021 at 12:00 PM
-- Server version: 10.4.6-MariaDB
-- PHP Version: 7.3.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
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
-- Structure for view `form_sf5_viewminimal_shs`
--

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `form_sf5_viewminimal_shs`  AS  select `finalgrades`.`id` AS `id`,`sections`.`id` AS `sectionId`,`loads`.`c_gradeLevel` AS `gradeLevel`,`finalgrades`.`studentId` AS `studentId`,`students`.`lrn` AS `lrn`,`students`.`lName` AS `lName`,`students`.`fName` AS `fName`,`students`.`mName` AS `mName`,`students`.`sex` AS `sex`,`enrollment`.`remarks` AS `remarks`,`finalgrades`.`generalAverage` AS `generalAverage`,`finalgrades`.`actionTaken` AS `actionTaken`,`finalgrades`.`failedSubjects` AS `failedSubjects`,`finalgrades`.`dateUpdated` AS `dateUpdated`,`enrollment`.`strand` AS `strand`,`enrollment`.`sem` AS `sem` from ((((`finalgrades` left join `sections` on(`finalgrades`.`sectionId` = `sections`.`id`)) left join `loads` on(`sections`.`loadId` = `loads`.`a_id`)) left join `students` on(`finalgrades`.`studentId` = `students`.`id`)) left join `enrollment` on(`enrollment`.`studentId` = `finalgrades`.`studentId` and `enrollment`.`sectionId` = `finalgrades`.`sectionId`)) where `enrollment`.`dep_type` = 'SHS' order by `loads`.`c_gradeLevel`,`finalgrades`.`sectionId`,`students`.`sex` desc,`students`.`lName`,`students`.`fName`,`students`.`mName` ;

--
-- VIEW  `form_sf5_viewminimal_shs`
-- Data: None
--

COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
