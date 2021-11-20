-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 24, 2020 at 07:31 PM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hotel_it350dz8`
--

-- --------------------------------------------------------

--
-- Table structure for table `gost`
--

CREATE TABLE `gost` (
  `gost_id` int(11) NOT NULL,
  `ime` varchar(32) DEFAULT NULL,
  `prezime` varchar(32) DEFAULT NULL,
  `jmbg` varchar(13) DEFAULT NULL,
  `adresa` varchar(128) DEFAULT NULL,
  `telefon` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `gost`
--

INSERT INTO `gost` (`gost_id`, `ime`, `prezime`, `jmbg`, `adresa`, `telefon`) VALUES
(1, 'Tomislav', 'Živadinović', '1207000730049', 'Niš', '0123456789'),
(2, 'Marko', 'Marković', '3304000730049', 'Niš', '0123456789');

-- --------------------------------------------------------

--
-- Table structure for table `odeljenje`
--

CREATE TABLE `odeljenje` (
  `odeljenje_id` int(11) NOT NULL,
  `ime` varchar(32) DEFAULT NULL,
  `mesto` varchar(32) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `odeljenje`
--

INSERT INTO `odeljenje` (`odeljenje_id`, `ime`, `mesto`) VALUES
(1, 'Test', 'Testiranje');

-- --------------------------------------------------------

--
-- Table structure for table `priprema_sobe`
--

CREATE TABLE `priprema_sobe` (
  `priprema_sobe_id` int(11) NOT NULL,
  `soba_broj` int(11) DEFAULT NULL,
  `zaposleni_ime` int(11) DEFAULT NULL,
  `datum` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `priprema_sobe`
--

INSERT INTO `priprema_sobe` (`priprema_sobe_id`, `soba_broj`, `zaposleni_ime`, `datum`) VALUES
(1, 1, 2, '2020-10-28');

-- --------------------------------------------------------

--
-- Table structure for table `rezervacija_sobe`
--

CREATE TABLE `rezervacija_sobe` (
  `rezervacija_sobe_id` int(11) NOT NULL,
  `gost_ime` int(11) DEFAULT NULL,
  `soba_broj` int(11) DEFAULT NULL,
  `datum_od` date DEFAULT NULL,
  `datum_do` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `rezervacija_sobe`
--

INSERT INTO `rezervacija_sobe` (`rezervacija_sobe_id`, `gost_ime`, `soba_broj`, `datum_od`, `datum_do`) VALUES
(1, 1, 1, '2020-11-01', '2020-11-20');

-- --------------------------------------------------------

--
-- Table structure for table `soba`
--

CREATE TABLE `soba` (
  `soba_id` int(11) NOT NULL,
  `broj` int(11) NOT NULL,
  `opis` text DEFAULT NULL,
  `slika` varchar(256) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `soba`
--

INSERT INTO `soba` (`soba_id`, `broj`, `opis`, `slika`) VALUES
(1, 201, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur ultrices tortor odio, vitae scelerisque mi fermentum in. Sed laoreet, nibh at molestie dapibus, leo purus feugiat ante, ac tempor tortor augue a ligula. Proin a erat arcu. Nunc egestas in dolor sit amet luctus. Nulla elementum sit amet ex non commodo. Fusce vel turpis faucibus, semper nisi non, hendrerit ante. Curabitur sit amet purus vel dolor sodales feugiat. Integer turpis ipsum, suscipit vitae tortor a, lobortis volutpat erat. ', NULL),
(2, 202, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur ultrices tortor odio, vitae scelerisque mi fermentum in. Sed laoreet, nibh at molestie dapibus, leo purus feugiat ante, ac tempor tortor augue a ligula. Proin a erat arcu. Nunc egestas in dolor sit amet luctus. Nulla elementum sit amet ex non commodo. Fusce vel turpis faucibus, semper nisi non, hendrerit ante. Curabitur sit amet purus vel dolor sodales feugiat. Integer turpis ipsum, suscipit vitae tortor a, lobortis volutpat erat. ', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `zaposleni`
--

CREATE TABLE `zaposleni` (
  `zaposleni_id` int(11) NOT NULL,
  `ime` varchar(32) DEFAULT NULL,
  `prezime` varchar(32) DEFAULT NULL,
  `jmbg` varchar(13) DEFAULT NULL,
  `adresa` varchar(128) DEFAULT NULL,
  `telefon` varchar(10) DEFAULT NULL,
  `odeljenje` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `zaposleni`
--

INSERT INTO `zaposleni` (`zaposleni_id`, `ime`, `prezime`, `jmbg`, `adresa`, `telefon`, `odeljenje`) VALUES
(1, 'Stefan', 'Marković', '1207000730049', 'Beograd', '0123456789', 1),
(2, 'Darko', 'Jovanović', '1207000730049', 'Novi Sad', '0123456789', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `gost`
--
ALTER TABLE `gost`
  ADD PRIMARY KEY (`gost_id`);

--
-- Indexes for table `odeljenje`
--
ALTER TABLE `odeljenje`
  ADD PRIMARY KEY (`odeljenje_id`);

--
-- Indexes for table `priprema_sobe`
--
ALTER TABLE `priprema_sobe`
  ADD PRIMARY KEY (`priprema_sobe_id`),
  ADD KEY `soba_id` (`soba_broj`),
  ADD KEY `zaposleni_id` (`zaposleni_ime`);

--
-- Indexes for table `rezervacija_sobe`
--
ALTER TABLE `rezervacija_sobe`
  ADD PRIMARY KEY (`rezervacija_sobe_id`),
  ADD KEY `gost_ime` (`gost_ime`),
  ADD KEY `soba_broj` (`soba_broj`);

--
-- Indexes for table `soba`
--
ALTER TABLE `soba`
  ADD PRIMARY KEY (`soba_id`);

--
-- Indexes for table `zaposleni`
--
ALTER TABLE `zaposleni`
  ADD PRIMARY KEY (`zaposleni_id`),
  ADD KEY `odeljenje_ime` (`odeljenje`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `gost`
--
ALTER TABLE `gost`
  MODIFY `gost_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `odeljenje`
--
ALTER TABLE `odeljenje`
  MODIFY `odeljenje_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `priprema_sobe`
--
ALTER TABLE `priprema_sobe`
  MODIFY `priprema_sobe_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `rezervacija_sobe`
--
ALTER TABLE `rezervacija_sobe`
  MODIFY `rezervacija_sobe_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `soba`
--
ALTER TABLE `soba`
  MODIFY `soba_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `zaposleni`
--
ALTER TABLE `zaposleni`
  MODIFY `zaposleni_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `priprema_sobe`
--
ALTER TABLE `priprema_sobe`
  ADD CONSTRAINT `soba_id` FOREIGN KEY (`soba_broj`) REFERENCES `soba` (`soba_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `zaposleni_id` FOREIGN KEY (`zaposleni_ime`) REFERENCES `zaposleni` (`zaposleni_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `rezervacija_sobe`
--
ALTER TABLE `rezervacija_sobe`
  ADD CONSTRAINT `gost_ime` FOREIGN KEY (`gost_ime`) REFERENCES `gost` (`gost_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `soba_broj` FOREIGN KEY (`soba_broj`) REFERENCES `soba` (`soba_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `zaposleni`
--
ALTER TABLE `zaposleni`
  ADD CONSTRAINT `odeljenje_ime` FOREIGN KEY (`odeljenje`) REFERENCES `odeljenje` (`odeljenje_id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
