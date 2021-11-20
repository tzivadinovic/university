-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3308
-- Generation Time: Nov 29, 2020 at 06:57 PM
-- Server version: 5.7.19
-- PHP Version: 7.1.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `studentska`
--

-- --------------------------------------------------------

--
-- Table structure for table `angazovanje`
--

DROP TABLE IF EXISTS `angazovanje`;
CREATE TABLE IF NOT EXISTS `angazovanje` (
  `angazovanje_id` int(11) NOT NULL,
  `profesor_id` int(11) DEFAULT NULL,
  `predmet_id` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`angazovanje_id`),
  KEY `FK_Relationship_4` (`profesor_id`),
  KEY `FK_Relationship_5` (`predmet_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `angazovanje`
--

INSERT INTO `angazovanje` (`angazovanje_id`, `profesor_id`, `predmet_id`) VALUES
(1, 1, 'CS220'),
(2, 2, 'MA101'),
(3, 2, 'MA202'),
(4, 7, 'CS220'),
(5, 6, 'CS115'),
(6, 6, 'IT350'),
(7, 5, 'CS101'),
(8, 5, 'CS102'),
(9, 5, 'SE201'),
(10, 10, 'SE201'),
(11, 12, 'IT255'),
(12, 9, 'NT213'),
(13, 13, 'IT255'),
(14, 11, 'IT210'),
(15, 15, 'CS225'),
(16, 14, 'AD356'),
(17, 3, 'NT111'),
(18, 8, 'NT112'),
(19, 4, 'IT370'),
(20, 7, 'AD361'),
(21, 10, 'SE211'),
(22, 11, 'SE211');

-- --------------------------------------------------------

--
-- Table structure for table `overa`
--

DROP TABLE IF EXISTS `overa`;
CREATE TABLE IF NOT EXISTS `overa` (
  `overa_id` int(11) NOT NULL,
  `indeks` int(11) DEFAULT NULL,
  `predmet_id` varchar(5) DEFAULT NULL,
  `ocena` int(5) DEFAULT NULL,
  `datum_overa` date DEFAULT NULL,
  `godina_roka` int(11) NOT NULL,
  `oznaka_roka` varchar(12) NOT NULL,
  PRIMARY KEY (`overa_id`),
  KEY `FK_Relationship_2` (`indeks`),
  KEY `FK_Relationship_3` (`predmet_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `overa`
--

INSERT INTO `overa` (`overa_id`, `indeks`, `predmet_id`, `ocena`, `datum_overa`, `godina_roka`, `oznaka_roka`) VALUES
(1, 1034, 'AD356', 9, '2015-04-20', 2015, 'apr'),
(2, 1034, 'CS102', 10, '2015-04-21', 2015, 'apr'),
(3, 1034, 'CS103', 9, '2015-04-22', 2015, 'apr'),
(4, 1034, 'CS220', 5, '2015-04-23', 2015, 'apr'),
(5, 1034, 'IT210', 10, '2015-04-24', 2015, 'apr'),
(6, 1034, 'IT255', 6, '2015-04-25', 2015, 'apr'),
(7, 1034, 'IT370', 10, '2015-04-26', 2015, 'apr'),
(8, 1034, 'NT111', 6, '2015-04-27', 2015, 'apr'),
(9, 1034, 'NT112', 8, '2015-04-28', 2015, 'apr'),
(10, 1034, 'SE201', 7, '2014-03-10', 2014, 'mart'),
(11, 1154, 'AD361', 10, '2014-03-11', 2014, 'mart'),
(12, 1154, 'CS101', 8, '2014-03-12', 2014, 'mart'),
(13, 1154, 'CS103', 7, '2014-03-13', 2014, 'mart'),
(14, 1154, 'CS225', 6, '2014-03-14', 2014, 'mart'),
(15, 1154, 'CS323', 7, '2014-03-15', 2014, 'mart'),
(16, 1154, 'IT255', 10, '2014-03-16', 2014, 'mart'),
(17, 1154, 'MA101', 7, '2015-04-27', 2015, 'apr'),
(18, 1154, 'MA202', 7, '2015-04-28', 2015, 'apr'),
(19, 1154, 'NT112', 8, '2015-04-20', 2015, 'apr'),
(20, 1154, 'SE211', 10, '2015-04-21', 2015, 'apr'),
(21, 1245, 'AD356', 9, '2015-04-22', 2015, 'apr'),
(22, 1245, 'CS101', 5, '2015-04-23', 2015, 'apr'),
(23, 1245, 'CS115', 8, '2014-03-10', 2014, 'mart'),
(24, 1245, 'CS220', 8, '2014-03-11', 2014, 'mart'),
(25, 1245, 'CS323', 8, '2014-03-12', 2014, 'mart'),
(26, 1245, 'IT350', 10, '2014-03-13', 2014, 'mart'),
(27, 1245, 'IT370', 5, '2014-03-14', 2014, 'mart'),
(28, 1245, 'MA202', 7, '2014-03-15', 2014, 'mart'),
(29, 1245, 'NT213', 7, '2014-03-16', 2014, 'mart'),
(30, 1245, 'SE201', 7, '2014-03-17', 2014, 'mart'),
(31, 1448, 'AD356', 10, '2014-03-18', 2014, 'mart'),
(32, 1448, 'CS102', 9, '2014-03-19', 2014, 'mart'),
(33, 1448, 'CS103', 10, '2014-03-20', 2014, 'mart'),
(34, 1448, 'CS220', 6, '2015-04-28', 2015, 'apr'),
(35, 1448, 'IT210', 5, '2015-04-20', 2015, 'apr'),
(36, 1448, 'IT255', 5, '2015-04-21', 2015, 'apr'),
(37, 1448, 'IT370', 8, '2015-04-22', 2015, 'apr'),
(38, 1448, 'NT111', 9, '2015-04-23', 2015, 'apr'),
(39, 1448, 'NT112', 6, '2014-03-10', 2014, 'mart'),
(40, 1448, 'SE201', 7, '2014-03-11', 2014, 'mart'),
(41, 1478, 'AD361', 5, '2014-03-12', 2014, 'mart'),
(42, 1478, 'CS101', 5, '2014-03-13', 2014, 'mart'),
(43, 1478, 'CS103', 9, '2014-03-14', 2014, 'mart'),
(44, 1478, 'CS225', 10, '2014-03-15', 2014, 'mart'),
(45, 1478, 'CS323', 8, '2014-03-16', 2014, 'mart'),
(46, 1478, 'IT255', 9, '2014-03-17', 2014, 'mart'),
(47, 1478, 'MA101', 10, '2014-03-18', 2014, 'mart'),
(48, 1478, 'MA202', 7, '2014-03-19', 2014, 'mart'),
(49, 1478, 'NT112', 5, '2014-03-20', 2014, 'mart'),
(50, 1478, 'SE211', 5, '2015-04-23', 2015, 'apr'),
(51, 1546, 'AD356', 5, '2014-03-10', 2014, 'mart'),
(52, 1546, 'CS101', 6, '2014-03-11', 2014, 'mart'),
(53, 1546, 'CS115', 7, '2014-03-12', 2014, 'mart'),
(54, 1546, 'CS220', 7, '2014-03-13', 2014, 'mart'),
(55, 1546, 'CS323', 5, '2014-03-14', 2014, 'mart'),
(56, 1546, 'IT350', 5, '2014-03-15', 2014, 'mart'),
(57, 1546, 'IT370', 6, '2014-03-16', 2014, 'mart'),
(58, 1546, 'MA202', 7, '2014-03-17', 2014, 'mart'),
(59, 1546, 'NT213', 8, '2015-04-23', 2015, 'apr'),
(60, 1546, 'SE201', 5, '2014-03-10', 2014, 'mart'),
(61, 1558, 'AD356', 10, '2014-03-11', 2014, 'mart'),
(62, 1558, 'CS102', 5, '2014-03-12', 2014, 'mart'),
(63, 1558, 'CS103', 10, '2014-03-13', 2014, 'mart'),
(64, 1558, 'CS220', 10, '2014-03-14', 2014, 'mart'),
(65, 1558, 'IT210', 5, '2014-03-15', 2014, 'mart'),
(66, 1558, 'IT255', 10, '2014-03-16', 2014, 'mart'),
(67, 1558, 'IT370', 9, '2014-03-17', 2014, 'mart'),
(68, 1558, 'NT111', 8, '2015-10-23', 2015, 'okt'),
(69, 1558, 'NT112', 7, '2015-10-24', 2015, 'okt'),
(70, 1558, 'SE201', 10, '2015-10-25', 2015, 'okt'),
(71, 1562, 'AD361', 5, '2015-10-26', 2015, 'okt'),
(72, 1562, 'CS101', 5, '2015-10-27', 2015, 'okt'),
(73, 1562, 'CS103', 9, '2015-01-13', 2015, 'jan'),
(74, 1562, 'CS225', 10, '2015-01-14', 2015, 'jan'),
(75, 1562, 'CS323', 6, '2015-01-15', 2015, 'jan'),
(76, 1562, 'IT255', 9, '2015-01-16', 2015, 'jan'),
(77, 1562, 'MA101', 5, '2015-01-17', 2015, 'jan'),
(78, 1562, 'MA202', 6, '2015-01-18', 2015, 'jan'),
(79, 1562, 'NT112', 8, '2015-01-19', 2015, 'jan'),
(80, 1562, 'SE211', 7, '2015-01-20', 2015, 'jan'),
(81, 1568, 'AD356', 5, '2015-01-21', 2015, 'jan'),
(82, 1568, 'CS101', 9, '2015-01-22', 2015, 'jan'),
(83, 1568, 'CS115', 8, '2015-01-23', 2015, 'jan'),
(84, 1568, 'CS220', 10, '2015-01-24', 2015, 'jan'),
(85, 1568, 'CS323', 9, '2014-03-12', 2014, 'mart'),
(86, 1568, 'IT350', 6, '2014-03-13', 2014, 'mart'),
(87, 1568, 'IT370', 8, '2014-03-14', 2014, 'mart'),
(88, 1568, 'MA202', 9, '2014-03-15', 2014, 'mart'),
(89, 1568, 'NT213', 6, '2014-03-16', 2014, 'mart'),
(90, 1568, 'SE201', 5, '2014-03-17', 2014, 'mart'),
(91, 1598, 'AD356', 7, '2015-10-23', 2015, 'okt'),
(92, 1598, 'CS102', 8, '2015-10-24', 2015, 'okt'),
(93, 1598, 'CS103', 10, '2015-10-25', 2015, 'okt'),
(94, 1598, 'CS220', 9, '2015-10-26', 2015, 'okt'),
(95, 1598, 'IT210', 5, '2015-10-27', 2015, 'okt'),
(96, 1598, 'IT255', 9, '2015-01-13', 2015, 'jan'),
(97, 1598, 'IT370', 10, '2015-01-14', 2015, 'jan'),
(98, 1598, 'NT111', 7, '2015-01-15', 2015, 'jan'),
(99, 1598, 'NT112', 6, '2015-01-16', 2015, 'jan'),
(100, 1598, 'SE201', 6, '2015-01-17', 2015, 'jan'),
(101, 1625, 'AD361', 10, '2015-01-18', 2015, 'jan'),
(102, 1625, 'CS101', 8, '2015-01-19', 2015, 'jan'),
(103, 1625, 'CS103', 8, '2015-01-20', 2015, 'jan'),
(104, 1625, 'CS225', 5, '2015-01-21', 2015, 'jan'),
(105, 1625, 'CS323', 7, '2015-01-22', 2015, 'jan'),
(106, 1625, 'IT255', 9, '2014-03-12', 2014, 'mart'),
(107, 1625, 'MA101', 5, '2014-03-13', 2014, 'mart'),
(108, 1625, 'MA202', 10, '2014-03-14', 2014, 'mart'),
(109, 1625, 'NT112', 7, '2014-03-15', 2014, 'mart'),
(110, 1625, 'SE211', 7, '2014-03-16', 2014, 'mart'),
(111, 1722, 'AD356', 10, '2014-03-17', 2014, 'mart'),
(112, 1722, 'CS101', 10, '2015-10-23', 2015, 'okt'),
(113, 1722, 'CS115', 6, '2015-10-24', 2015, 'okt'),
(114, 1722, 'CS220', 10, '2015-10-25', 2015, 'okt'),
(115, 1722, 'CS323', 8, '2015-10-26', 2015, 'okt'),
(116, 1722, 'IT350', 8, '2015-10-27', 2015, 'okt'),
(117, 1722, 'IT370', 10, '2015-01-13', 2015, 'jan'),
(118, 1722, 'MA202', 7, '2015-01-14', 2015, 'jan'),
(119, 1722, 'NT213', 7, '2015-01-15', 2015, 'jan'),
(120, 1722, 'SE201', 6, '2015-01-16', 2015, 'jan'),
(121, 1894, 'AD356', 6, '2015-01-17', 2015, 'jan'),
(122, 1894, 'CS102', 5, '2015-01-18', 2015, 'jan'),
(123, 1894, 'CS103', 6, '2015-01-19', 2015, 'jan'),
(124, 1894, 'CS220', 9, '2015-01-20', 2015, 'jan'),
(125, 1894, 'IT210', 7, '2015-01-21', 2015, 'jan'),
(126, 1894, 'IT255', 6, '2015-01-22', 2015, 'jan'),
(127, 1894, 'IT370', 9, '2014-03-12', 2014, 'mart'),
(128, 1894, 'NT111', 5, '2014-03-13', 2014, 'mart'),
(129, 1894, 'NT112', 10, '2014-03-14', 2014, 'mart'),
(130, 1894, 'SE201', 5, '2014-03-15', 2014, 'mart'),
(131, 2001, 'AD361', 8, '2014-03-16', 2014, 'mart'),
(132, 2001, 'CS101', 9, '2014-03-17', 2014, 'mart'),
(133, 2001, 'CS103', 9, '2015-10-23', 2015, 'okt'),
(134, 2001, 'CS225', 9, '2015-10-24', 2015, 'okt'),
(135, 2001, 'CS323', 10, '2015-10-25', 2015, 'okt'),
(136, 2001, 'IT255', 6, '2015-10-26', 2015, 'okt'),
(137, 2001, 'MA101', 8, '2015-10-27', 2015, 'okt'),
(138, 2001, 'MA202', 9, '2015-01-07', 2015, 'jan'),
(139, 2001, 'NT112', 8, '2015-01-08', 2015, 'jan'),
(140, 2001, 'SE211', 6, '2015-01-09', 2015, 'jan'),
(141, 2102, 'AD356', 5, '2015-01-10', 2015, 'jan'),
(142, 2102, 'CS101', 9, '2015-01-11', 2015, 'jan'),
(143, 2102, 'CS115', 6, '2015-01-12', 2015, 'jan'),
(144, 2102, 'CS220', 5, '2015-01-13', 2015, 'jan'),
(145, 2102, 'CS323', 8, '2015-01-14', 2015, 'jan'),
(146, 2102, 'IT350', 6, '2015-01-15', 2015, 'jan'),
(147, 2102, 'IT370', 6, '2015-01-16', 2015, 'jan'),
(148, 2102, 'MA202', 8, '2015-01-17', 2015, 'jan'),
(149, 2102, 'NT213', 8, '2015-01-18', 2015, 'jan'),
(150, 2102, 'SE201', 9, '2015-01-19', 2015, 'jan'),
(151, 2145, 'AD356', 6, '2015-01-20', 2015, 'jan'),
(152, 2145, 'CS102', 8, '2015-10-24', 2015, 'okt'),
(153, 2145, 'CS103', 10, '2015-10-25', 2015, 'okt'),
(154, 2145, 'CS220', 5, '2015-10-26', 2015, 'okt'),
(155, 2145, 'IT210', 7, '2015-10-27', 2015, 'okt'),
(156, 2145, 'IT255', 10, '2015-01-13', 2015, 'jan'),
(157, 2145, 'IT370', 7, '2015-01-14', 2015, 'jan'),
(158, 2145, 'NT111', 6, '2015-01-15', 2015, 'jan'),
(159, 2145, 'NT112', 6, '2015-01-16', 2015, 'jan'),
(160, 2145, 'SE201', 10, '2015-01-17', 2015, 'jan'),
(161, 2234, 'AD361', 6, '2015-01-18', 2015, 'jan'),
(162, 2234, 'CS101', 6, '2015-01-19', 2015, 'jan'),
(163, 2234, 'CS103', 9, '2015-01-20', 2015, 'jan'),
(164, 2234, 'CS225', 5, '2015-01-21', 2015, 'jan'),
(165, 2234, 'CS323', 9, '2015-01-22', 2015, 'jan'),
(166, 2234, 'IT255', 10, '2015-01-23', 2015, 'jan'),
(167, 2234, 'MA101', 9, '2015-01-24', 2015, 'jan'),
(168, 2234, 'MA202', 6, '2014-03-12', 2014, 'mart'),
(169, 2234, 'NT112', 5, '2014-03-13', 2014, 'mart'),
(170, 2234, 'SE211', 6, '2014-03-14', 2014, 'mart'),
(171, 2255, 'AD356', 7, '2014-03-15', 2014, 'mart'),
(172, 2255, 'CS101', 7, '2014-03-16', 2014, 'mart'),
(173, 2255, 'CS115', 9, '2014-03-17', 2014, 'mart'),
(174, 2255, 'CS220', 7, '2015-10-23', 2015, 'okt'),
(175, 2255, 'CS323', 6, '2015-10-24', 2015, 'okt'),
(176, 2255, 'IT350', 6, '2015-10-25', 2015, 'okt'),
(177, 2255, 'IT370', 7, '2015-10-26', 2015, 'okt'),
(178, 2255, 'MA202', 9, '2015-10-27', 2015, 'okt'),
(179, 2255, 'NT213', 7, '2015-01-13', 2015, 'jan'),
(180, 2255, 'SE201', 7, '2015-01-14', 2015, 'jan'),
(181, 2285, 'AD356', 6, '2015-01-15', 2015, 'jan'),
(182, 2285, 'CS102', 9, '2015-01-16', 2015, 'jan'),
(183, 2285, 'CS103', 5, '2015-01-17', 2015, 'jan'),
(184, 2285, 'CS220', 6, '2015-01-18', 2015, 'jan'),
(185, 2285, 'IT210', 7, '2015-01-19', 2015, 'jan'),
(186, 2285, 'IT255', 8, '2015-01-20', 2015, 'jan'),
(187, 2285, 'IT370', 7, '2015-01-21', 2015, 'jan'),
(188, 2285, 'NT111', 6, '2015-01-22', 2015, 'jan'),
(189, 2285, 'NT112', 7, '2015-01-23', 2015, 'jan'),
(190, 2285, 'SE201', 9, '2015-01-24', 2015, 'jan'),
(191, 2323, 'AD361', 7, '2014-03-12', 2014, 'mart'),
(192, 2323, 'CS101', 8, '2014-03-13', 2014, 'mart'),
(193, 2323, 'CS103', 10, '2014-03-14', 2014, 'mart'),
(194, 2323, 'CS225', 10, '2014-03-15', 2014, 'mart'),
(195, 2323, 'CS323', 9, '2014-03-16', 2014, 'mart'),
(196, 2323, 'IT255', 10, '2014-03-17', 2014, 'mart'),
(197, 2323, 'MA101', 10, '2015-10-23', 2015, 'okt'),
(198, 2323, 'MA202', 5, '2015-10-24', 2015, 'okt'),
(199, 2323, 'NT112', 6, '2015-10-25', 2015, 'okt'),
(200, 2323, 'SE211', 6, '2015-10-26', 2015, 'okt'),
(201, 2434, 'AD356', 9, '2015-10-27', 2015, 'okt'),
(202, 2434, 'CS101', 8, '2015-01-13', 2015, 'jan'),
(203, 2434, 'CS115', 9, '2015-01-14', 2015, 'jan'),
(204, 2434, 'CS220', 7, '2015-01-15', 2015, 'jan'),
(205, 2434, 'CS323', 10, '2015-01-16', 2015, 'jan'),
(206, 2434, 'IT350', 8, '2015-01-17', 2015, 'jan'),
(207, 2434, 'IT370', 6, '2015-01-18', 2015, 'jan'),
(208, 2434, 'MA202', 9, '2015-01-19', 2015, 'jan'),
(209, 2434, 'NT213', 6, '2015-01-20', 2015, 'jan'),
(210, 2434, 'SE201', 10, '2015-01-21', 2015, 'jan'),
(211, 2470, 'AD356', 7, '2015-01-22', 2015, 'jan'),
(212, 2470, 'CS102', 5, '2015-01-23', 2015, 'jan'),
(213, 2470, 'CS103', 9, '2015-01-24', 2015, 'jan'),
(214, 2470, 'CS220', 8, '2014-03-12', 2014, 'mart'),
(215, 2470, 'IT210', 9, '2014-03-13', 2014, 'mart'),
(216, 2470, 'IT255', 6, '2014-03-14', 2014, 'mart'),
(217, 2470, 'IT370', 10, '2014-03-15', 2014, 'mart'),
(218, 2470, 'NT111', 10, '2014-03-16', 2014, 'mart'),
(219, 2470, 'NT112', 10, '2014-03-17', 2014, 'mart'),
(220, 2470, 'SE201', 9, '2015-10-23', 2015, 'okt'),
(221, 2526, 'AD361', 6, '2015-10-24', 2015, 'okt'),
(222, 2526, 'CS101', 10, '2015-10-25', 2015, 'okt'),
(223, 2526, 'CS103', 6, '2015-10-26', 2015, 'okt'),
(224, 2526, 'CS225', 6, '2015-10-27', 2015, 'okt'),
(225, 2526, 'CS323', 10, '2015-01-13', 2015, 'jan'),
(226, 2526, 'IT255', 10, '2015-01-14', 2015, 'jan'),
(227, 2526, 'MA101', 5, '2015-01-15', 2015, 'jan'),
(228, 2526, 'MA202', 5, '2015-01-16', 2015, 'jan'),
(229, 2526, 'NT112', 5, '2015-01-17', 2015, 'jan'),
(230, 2526, 'SE211', 5, '2015-01-18', 2015, 'jan'),
(231, 2556, 'AD356', 8, '2015-01-19', 2015, 'jan'),
(232, 2556, 'CS101', 5, '2015-01-20', 2015, 'jan'),
(233, 2556, 'CS115', 7, '2015-01-21', 2015, 'jan'),
(234, 2556, 'CS220', 7, '2015-01-22', 2015, 'jan'),
(235, 2556, 'CS323', 9, '2015-01-23', 2015, 'jan'),
(236, 2556, 'IT350', 5, '2015-01-24', 2015, 'jan'),
(237, 2556, 'IT370', 10, '2014-03-12', 2014, 'mart'),
(238, 2556, 'MA202', 10, '2014-03-13', 2014, 'mart'),
(239, 2556, 'NT213', 5, '2014-03-14', 2014, 'mart'),
(240, 2556, 'SE201', 6, '2014-03-15', 2014, 'mart'),
(241, 2566, 'AD356', 8, '2014-03-16', 2014, 'mart'),
(242, 2566, 'CS102', 6, '2014-03-17', 2014, 'mart'),
(243, 2566, 'CS103', 10, '2015-10-23', 2015, 'okt'),
(244, 2566, 'CS220', 5, '2015-10-24', 2015, 'okt'),
(245, 2566, 'IT210', 10, '2015-10-25', 2015, 'okt'),
(246, 2566, 'IT255', 5, '2015-10-26', 2015, 'okt'),
(247, 2566, 'IT370', 10, '2015-10-27', 2015, 'okt'),
(248, 2566, 'NT111', 10, '2015-01-13', 2015, 'jan'),
(249, 2566, 'NT112', 6, '2015-01-14', 2015, 'jan'),
(250, 2566, 'SE201', 9, '2015-01-15', 2015, 'jan'),
(251, 2889, 'AD361', 7, '2015-01-16', 2015, 'jan'),
(252, 2889, 'CS101', 10, '2015-01-17', 2015, 'jan'),
(253, 2889, 'CS103', 9, '2015-01-18', 2015, 'jan'),
(254, 2889, 'CS225', 6, '2015-01-19', 2015, 'jan'),
(255, 2889, 'CS323', 5, '2015-01-20', 2015, 'jan'),
(256, 2889, 'IT255', 6, '2015-01-21', 2015, 'jan'),
(257, 2889, 'MA101', 10, '2015-01-22', 2015, 'jan'),
(258, 2889, 'MA202', 6, '2015-01-23', 2015, 'jan'),
(259, 2889, 'NT112', 6, '2015-01-24', 2015, 'jan'),
(260, 2889, 'SE211', 7, '2014-03-12', 2014, 'mart'),
(261, 2890, 'AD356', 8, '2014-03-13', 2014, 'mart'),
(262, 2890, 'CS101', 10, '2014-03-14', 2014, 'mart'),
(263, 2890, 'CS115', 6, '2014-03-15', 2014, 'mart'),
(264, 2890, 'CS220', 7, '2014-03-16', 2014, 'mart'),
(265, 2890, 'CS323', 8, '2014-03-17', 2014, 'mart'),
(266, 2890, 'IT350', 10, '2015-05-23', 2015, 'maj'),
(267, 2890, 'IT370', 8, '2015-05-24', 2015, 'maj'),
(268, 2890, 'MA202', 7, '2015-05-25', 2015, 'maj'),
(269, 2890, 'NT213', 5, '2015-05-26', 2015, 'maj'),
(270, 2890, 'SE201', 5, '2015-05-27', 2015, 'maj'),
(271, 2978, 'AD356', 5, '2015-05-28', 2015, 'maj'),
(272, 2978, 'CS102', 5, '2015-05-29', 2015, 'maj'),
(273, 2978, 'CS103', 7, '2015-05-30', 2015, 'maj'),
(274, 2978, 'CS220', 6, '2015-05-31', 2015, 'maj'),
(275, 2978, 'IT210', 7, '2015-03-12', 2015, 'mart'),
(276, 2978, 'IT255', 8, '2015-03-13', 2015, 'mart'),
(277, 2978, 'IT370', 6, '2015-03-14', 2015, 'mart'),
(278, 2978, 'NT111', 6, '2015-03-15', 2015, 'mart'),
(279, 2978, 'NT112', 10, '2015-03-16', 2015, 'mart'),
(280, 2978, 'SE201', 9, '2015-03-17', 2015, 'mart'),
(281, 2987, 'AD361', 8, '2015-03-18', 2015, 'mart'),
(282, 2987, 'CS101', 8, '2015-03-19', 2015, 'mart'),
(283, 2987, 'CS103', 6, '2015-03-20', 2015, 'mart'),
(284, 2987, 'CS225', 7, '2015-03-21', 2015, 'mart'),
(285, 2987, 'CS323', 9, '2015-03-22', 2015, 'mart'),
(286, 2987, 'IT255', 10, '2015-03-23', 2015, 'mart'),
(287, 2987, 'MA101', 5, '2015-03-24', 2015, 'mart'),
(288, 2987, 'MA202', 9, '2015-03-25', 2015, 'mart'),
(289, 2987, 'NT112', 7, '2015-03-26', 2015, 'mart'),
(290, 2987, 'SE211', 10, '2015-03-27', 2015, 'mart'),
(291, 3256, 'AD356', 8, '2015-03-28', 2015, 'mart'),
(292, 3256, 'CS101', 6, '2015-03-29', 2015, 'mart'),
(293, 3256, 'CS115', 6, '2015-03-30', 2015, 'mart'),
(294, 3256, 'CS220', 6, '2015-03-31', 2015, 'mart'),
(295, 3256, 'CS323', 9, '2015-04-21', 2015, 'apr'),
(296, 3256, 'IT350', 10, '2015-04-21', 2015, 'apr'),
(297, 3256, 'IT370', 5, '2015-04-21', 2015, 'apr'),
(298, 3256, 'MA202', 10, '2015-04-21', 2015, 'apr'),
(299, 3256, 'NT213', 5, '2015-04-21', 2015, 'apr'),
(300, 3256, 'SE201', 8, '2015-04-21', 2015, 'apr');

-- --------------------------------------------------------

--
-- Table structure for table `predmet`
--

DROP TABLE IF EXISTS `predmet`;
CREATE TABLE IF NOT EXISTS `predmet` (
  `predmet_id` varchar(5) NOT NULL,
  `naziv` varchar(50) DEFAULT NULL,
  `espb` smallint(6) DEFAULT NULL,
  `br_cas_predavanja` smallint(6) DEFAULT NULL,
  `br_cas_vezbe` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`predmet_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `predmet`
--

INSERT INTO `predmet` (`predmet_id`, `naziv`, `espb`, `br_cas_predavanja`, `br_cas_vezbe`) VALUES
('AD356', '3D modelovanje Maya', 10, 3, 3),
('AD361', 'Izrada video igara', 8, 3, 3),
('CS101', 'Uvod u objektno orijentisano programiranje', 10, 3, 4),
('CS102', 'Objekti i apstrakcija podataka', 10, 3, 4),
('CS103', 'Algoritmi i strukture podataka', 8, 3, 3),
('CS115', 'Diskretne strukture', 8, 3, 2),
('CS220', 'Arhitektura racunara', 8, 3, 3),
('CS225', 'Operativni sistemi', 10, 3, 3),
('CS323', 'C/C++ programski jezik', 8, 2, 3),
('IT210', 'Sistemi informacionih tehnologija', 8, 3, 3),
('IT255', 'Veb sistemi 1', 8, 3, 3),
('IT350', 'Baze podataka', 8, 3, 3),
('IT370', 'Interakcija covek-racunar', 8, 3, 3),
('MA101', 'Matematika 1', 8, 3, 2),
('MA202', 'Matematika 2', 8, 3, 2),
('NT111', 'Engleski 1', 4, 2, 1),
('NT112', 'Engleski 2', 4, 2, 1),
('NT213', 'Engleski za informaticare', 4, 3, 1),
('SE201', 'Uvod u softversko inzenjerstvo', 8, 3, 4),
('SE211', 'Izrada softvera', 8, 3, 3);

-- --------------------------------------------------------

--
-- Table structure for table `profesor`
--

DROP TABLE IF EXISTS `profesor`;
CREATE TABLE IF NOT EXISTS `profesor` (
  `profesor_id` int(11) NOT NULL,
  `ime` varchar(32) DEFAULT NULL,
  `prezime` varchar(32) DEFAULT NULL,
  `telefon` text,
  `zvanje` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`profesor_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `profesor`
--

INSERT INTO `profesor` (`profesor_id`, `ime`, `prezime`, `telefon`, `zvanje`) VALUES
(1, 'Nedzad', 'Mehic', '061/248996', 'Profesor'),
(2, 'Rale', 'Nikolic', '066/322734', 'Profesor'),
(3, 'Dragica', 'Stanasijevic', '063/619228', 'Profesor'),
(4, 'Slavica', 'Gajic', '064/256066', 'Profesor'),
(5, 'Dragan', 'Domazet', '063/102405', 'Profesor'),
(6, 'Aleksandra', 'Arsic', '064/556067', 'Asistent'),
(7, 'Vuk', 'Vasic', '065/715889', 'Asistent'),
(8, 'Rados', 'Pavlicevic', '064/225379', 'Saradnik'),
(9, 'Nenad', 'Strainovic', '064/893671', 'Saradnik'),
(10, 'Ana', 'Rodic', '061/234119', 'Saradnik'),
(11, 'Marija', 'Jovanovic', '062/114773', 'Asistent'),
(12, 'Irena', 'Nastasijevic', '062/873964', 'Asistent'),
(13, 'Filip', 'Petrovic', '066/251418', 'Asistent'),
(14, 'Danica', 'Vasic', '064/2562067', 'Saradnik'),
(15, 'Aleksandar', 'Janic', '064/122347', 'Saradnik');

-- --------------------------------------------------------

--
-- Table structure for table `smer`
--

DROP TABLE IF EXISTS `smer`;
CREATE TABLE IF NOT EXISTS `smer` (
  `smer_id` int(11) NOT NULL,
  `smer_naziv` varchar(32) DEFAULT NULL,
  `smer_opis` text,
  PRIMARY KEY (`smer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `smer`
--

INSERT INTO `smer` (`smer_id`, `smer_naziv`, `smer_opis`) VALUES
(1, 'Softversko inzenjerstvo', 'Softversko inženjerstvo je disciplina koja se bavi razvojem i održavanjem pouzdanih i efikasnih softverskih sistema. '),
(2, 'Informacione tehnologije', 'nformacione tehnologije (IT) je nova disciplina koja se vrlo brzo razvija kao rezultat zahteva iz prakse, odnosno potreba preduzeća i drugih organizacija.'),
(3, 'Informacioni sistemi', 'Na ovom studijskom programu se nećete baviti isključivo programiranjem, mada je neophodno da i to znate. Programiranje je samo jedna od aktivnosti razvoja informacionih sistema kojoj prethodi niz drugih aktivnosti kao što su:\r\n\r\n    -definisanje zahteva kojima se opisuju šta IS treba da radi,\r\n    -pravljenje niza modela koji programerima olakšavaju razumevanje tih zahteva prilikom programiranja,\r\n    -projektovanje aplikacija i baza podataka koje podržavaju rad IS-a, itd.\r\n');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
CREATE TABLE IF NOT EXISTS `student` (
  `indeks` int(11) NOT NULL,
  `smer_id` int(11) DEFAULT NULL,
  `ime` varchar(32) DEFAULT NULL,
  `prezime` varchar(32) DEFAULT NULL,
  `tip_studiranja` varchar(32) DEFAULT NULL,
  `datum_rodjenja` date DEFAULT NULL,
  `telefon` text,
  `grad_rodjenja` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`indeks`),
  KEY `FK_Relationship_6` (`smer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`indeks`, `smer_id`, `ime`, `prezime`, `tip_studiranja`, `datum_rodjenja`, `telefon`, `grad_rodjenja`) VALUES
(1034, 1, 'Filip', 'Avramovic', 'Tradicionalno', '1995-06-25', '062/217815', 'Lazarevac'),
(1154, 1, 'Ivan', 'Blagojevic', 'Internet', '1995-05-20', '065/115678', 'Beograd'),
(1245, 1, 'Ajla', 'Dzekovic', 'Tradicionalno', '1995-02-06', '065/853156', 'Sjenica'),
(1448, 1, 'Nemanja', 'Simic', 'Tradicionalno', '1995-10-12', '064/851212', 'Paracin'),
(1478, 3, 'Milica', 'Miloskovic', 'Internet', '1995-02-16', '065/586123', 'Beograd'),
(1546, 3, 'Ivona', 'Stanojevic', 'Tradicionalno', '1995-11-03', '064/231565', 'Lapovo'),
(1558, 2, 'Milos', 'Milosevic', 'Internet', '1996-10-26', '062/256615', 'Subotica'),
(1562, 2, 'Ivana', 'Milic', 'Tradicionalno', '1994-05-02', '063/322564', 'Cacak'),
(1568, 1, 'Aleksa', 'Stojanovic', 'Tradicionalno', '1995-04-05', '061/875156', 'Kraljevo'),
(1598, 1, 'Lazar', 'Milosavljevic', 'Tradicionalno', '1995-08-10', '061/461322', 'Paracin'),
(1625, 2, 'Milan', 'Mladenovic', 'Internet', '1995-10-20', '062/785562', 'Beograd'),
(1722, 3, 'Milan', 'Mirkovic', 'Internet', '1996-04-19', '062/144785', 'Kraljevo'),
(1894, 3, 'Dusan', 'Stefanovic', 'Internet', '1995-08-24', '064/851475', 'Pozarevac'),
(2001, 1, 'Marko', 'Milovanovic', 'Internet', '1994-10-10', '061/852156', 'Valjevo'),
(2102, 1, 'Danica', 'Milosevic', 'Internet', '1993-01-01', '061/785125', 'Bor'),
(2145, 1, 'Marija', 'Stojanovic', 'Internet', '1992-05-02', '061/564891', 'Bor'),
(2234, 2, 'Ana', 'Markovic', 'Tradicionalno', '1994-08-29', '061/8618721', 'Beograd'),
(2255, 2, 'Milica', 'Stankovic', 'Internet', '1993-08-12', '062/885112', 'Novi Sad'),
(2285, 3, 'Danilo', 'Ivanovic', 'Tradicionalno', '1994-12-09', '061/235561', 'Novi Milanovac'),
(2323, 2, 'Slavica', 'Baric', 'Internet', '1996-10-15', '062/533215', 'Subotica'),
(2434, 3, 'Jelena', 'Bozovic', 'Internet', '1996-04-26', '066/345852', 'Novi Milanovac'),
(2470, 2, 'Stefan', 'Jovanovic', 'Tradicionalno', '1995-08-10', '061/891513', 'Beograd'),
(2526, 3, 'Kristina', 'Krstic', 'Internet', '1991-12-14', '064/256145', 'Pozarevac'),
(2556, 1, 'Jovana', 'Jovanovic', 'Internet', '1991-08-05', '064/865132', 'Kragujevac'),
(2566, 2, 'Irina', 'Aksentijevic', 'Internet', '1992-12-05', '065/132256', 'Vranje'),
(2889, 2, 'Milos', 'Milojkovic', 'Tradicionalno', '1994-12-12', '065/891324', 'Kragujevac'),
(2890, 3, 'Nastasija', 'Bodiroga', 'Tradicionalno', '1996-06-03', '061/123456', 'Kraljevo'),
(2978, 3, 'Denis', 'Dragic', 'Tradicionalno', '1993-10-07', '063/549962', 'Vranje'),
(2987, 3, 'Bogdan', 'Marincevic', 'Tradicionalno', '1994-09-15', '063/852123', 'Zlatibor'),
(3256, 2, 'Dragana', 'Aksentijevic', 'Tradicionalno', '1996-02-08', '064/213288', 'Aleksinac');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `angazovanje`
--
ALTER TABLE `angazovanje`
  ADD CONSTRAINT `FK_Relationship_4` FOREIGN KEY (`profesor_id`) REFERENCES `profesor` (`profesor_id`),
  ADD CONSTRAINT `FK_Relationship_5` FOREIGN KEY (`predmet_id`) REFERENCES `predmet` (`predmet_id`);

--
-- Constraints for table `overa`
--
ALTER TABLE `overa`
  ADD CONSTRAINT `FK_Relationship_2` FOREIGN KEY (`indeks`) REFERENCES `student` (`indeks`),
  ADD CONSTRAINT `FK_Relationship_3` FOREIGN KEY (`predmet_id`) REFERENCES `predmet` (`predmet_id`);

--
-- Constraints for table `student`
--
ALTER TABLE `student`
  ADD CONSTRAINT `FK_Relationship_6` FOREIGN KEY (`smer_id`) REFERENCES `smer` (`smer_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
