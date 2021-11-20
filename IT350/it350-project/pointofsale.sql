-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 06, 2021 at 12:35 AM
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
-- Database: `posv2`
--

-- --------------------------------------------------------

--
-- Table structure for table `address`
--

CREATE TABLE `address` (
  `address_id` int auto_increment primary key NOT NULL,
  `municipality` varchar(32) DEFAULT NULL,
  `city` varchar(16) DEFAULT NULL,
  `street_name` varchar(16) DEFAULT NULL,
  `street_number` varchar(8) DEFAULT NULL,
  `created_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `last_modified_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `last_modified_by` varchar(64) DEFAULT 'system',
  `record_status` int(11) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `cash_register`
--

CREATE TABLE `cash_register` (
  `cash_register_id` int auto_increment primary key NOT NULL,
  `retail_store_id` int(11) NOT NULL,
  `created_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `last_modified_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `last_modified_by` varchar(64) DEFAULT 'system',
  `record_status` int(11) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `delivery`
--

CREATE TABLE `delivery` (
  `delivery_id` int auto_increment primary key NOT NULL,
  `user_id` int(11) NOT NULL,
  `receipt_id` int(11) NOT NULL,
  `delivery_number` varchar(16) DEFAULT NULL,
  `products_number` int(11) DEFAULT NULL,
  `tax` decimal(10,0) DEFAULT NULL,
  `created_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `last_modified_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `last_modified_by` varchar(64) DEFAULT 'system',
  `record_status` int(11) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `procurement`
--

CREATE TABLE `procurement` (
  `procurement_id` int auto_increment primary key NOT NULL,
  `retail_store_id` int(11) NOT NULL,
  `procurement_number` varchar(16) DEFAULT NULL,
  `products_number` int(11) DEFAULT NULL,
  `created_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `last_modified_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `last_modified_by` varchar(64) DEFAULT 'system',
  `record_status` int(11) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `product_id` int auto_increment primary key NOT NULL,
  `product_type_id` int(11) NOT NULL,
  `name` varchar(16) NOT NULL,
  `price` decimal(10,0) DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  `created_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `last_modified_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `last_modified_by` varchar(64) DEFAULT 'system',
  `record_status` int(11) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `product_type`
--

CREATE TABLE `product_type` (
  `product_type_id` int auto_increment primary key NOT NULL,
  `name` varchar(64) DEFAULT NULL,
  `created_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `last_modified_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `last_modified_by` varchar(64) DEFAULT 'system',
  `record_status` int(11) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `product_type_supplier`
--

CREATE TABLE `product_type_supplier` (
  `product_type_id` int auto_increment primary key NOT NULL,
  `supplier_id` int(11) NOT NULL,
  `created_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `last_modified_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `last_modified_by` varchar(64) DEFAULT 'system',
  `record_status` int(11) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `receipt`
--

CREATE TABLE `receipt` (
  `receipt_id` int auto_increment primary key NOT NULL,
  `delivery_id` int(11) NOT NULL,
  `cash_register_id` int(11) NOT NULL,
  `total_price` decimal(10,0) DEFAULT NULL,
  `created_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `last_modified_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `last_modified_by` varchar(64) DEFAULT 'system',
  `record_status` int(11) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `retail_store`
--

CREATE TABLE `retail_store` (
  `retail_store_id` int auto_increment primary key NOT NULL,
  `tax_id` int(11) DEFAULT NULL,
  `name` varchar(64) DEFAULT NULL,
  `work_code` varchar(32) DEFAULT NULL,
  `created_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `last_modified_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `last_modified_by` varchar(64) DEFAULT 'system',
  `record_status` int(11) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `role_id` int auto_increment primary key NOT NULL,
  `role` varchar(16) DEFAULT NULL,
  `created_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `last_modified_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `last_modified_by` varchar(64) DEFAULT 'system',
  `record_status` int(11) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `role_user`
--

CREATE TABLE `role_user` (
  `role_id` int auto_increment primary key NOT NULL,
  `user_id` int(11) NOT NULL,
  `created_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `last_modified_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `last_modified_by` varchar(64) DEFAULT 'system',
  `record_status` int(11) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE `supplier` (
  `supplier_id` int auto_increment primary key NOT NULL,
  `name` varchar(64) DEFAULT NULL,
  `email` varchar(32) DEFAULT NULL,
  `address` varchar(128) DEFAULT NULL,
  `phone_number` varchar(11) DEFAULT NULL,
  `contact_person` varchar(32) DEFAULT NULL,
  `created_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `last_modified_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `last_modified_by` varchar(64) DEFAULT 'system',
  `record_status` int(11) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_id` int auto_increment primary key NOT NULL,
  `address_id` int(11) NOT NULL,
  `username` varchar(16) DEFAULT NULL,
  `password` varchar(16) DEFAULT NULL,
  `firstname` varchar(16) DEFAULT NULL,
  `lastname` varchar(16) DEFAULT NULL,
  `created_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `last_modified_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `last_modified_by` varchar(64) DEFAULT 'system',
  `record_status` int(11) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `address`
--

--
-- Indexes for table `cash_register`
--
ALTER TABLE `cash_register`
  ADD KEY `fk_cash_register_retail_store` (`retail_store_id`);

--
-- Indexes for table `delivery`
--
ALTER TABLE `delivery`
  ADD KEY `fk_user_delivery` (`user_id`),
  ADD KEY `fk_receipt_delivery2` (`receipt_id`);

--
-- Indexes for table `procurement`
--
ALTER TABLE `procurement`
  ADD KEY `fk_procurement_retail_store` (`retail_store_id`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD KEY `fk_product_type_product` (`product_type_id`);

--
-- Indexes for table `product_type`
--


--
-- Indexes for table `product_type_supplier`
--
ALTER TABLE `product_type_supplier`
  ADD KEY `fk_product_type_supplier2` (`supplier_id`);

--
-- Indexes for table `receipt`
--
ALTER TABLE `receipt`
  ADD KEY `fk_receipt_delivery` (`delivery_id`),
  ADD KEY `fk_receipt_cash_register` (`cash_register_id`);

--
-- Indexes for table `retail_store`
--


--
-- Indexes for table `role`
--


--
-- Indexes for table `role_user`
--
ALTER TABLE `role_user`
  ADD KEY `fk_role_user2` (`user_id`);

--
-- Indexes for table `supplier`
--


--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD KEY `fk_user_address` (`address_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `product_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `cash_register`
--
ALTER TABLE `cash_register`
  ADD CONSTRAINT `fk_cash_register_retail_store` FOREIGN KEY (`retail_store_id`) REFERENCES `retail_store` (`retail_store_id`);

--
-- Constraints for table `delivery`
--
ALTER TABLE `delivery`
  ADD CONSTRAINT `fk_receipt_delivery2` FOREIGN KEY (`receipt_id`) REFERENCES `receipt` (`receipt_id`),
  ADD CONSTRAINT `fk_user_delivery` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`);

--
-- Constraints for table `procurement`
--
ALTER TABLE `procurement`
  ADD CONSTRAINT `fk_procurement_retail_store` FOREIGN KEY (`retail_store_id`) REFERENCES `retail_store` (`retail_store_id`);

--
-- Constraints for table `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `fk_product_type_product` FOREIGN KEY (`product_type_id`) REFERENCES `product_type` (`product_type_id`);

--
-- Constraints for table `product_type_supplier`
--
ALTER TABLE `product_type_supplier`
  ADD CONSTRAINT `fk_product_type_supplier` FOREIGN KEY (`product_type_id`) REFERENCES `product_type` (`product_type_id`),
  ADD CONSTRAINT `fk_product_type_supplier2` FOREIGN KEY (`supplier_id`) REFERENCES `supplier` (`supplier_id`);

--
-- Constraints for table `receipt`
--
ALTER TABLE `receipt`
  ADD CONSTRAINT `fk_receipt_cash_register` FOREIGN KEY (`cash_register_id`) REFERENCES `cash_register` (`cash_register_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_receipt_delivery` FOREIGN KEY (`delivery_id`) REFERENCES `delivery` (`delivery_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `role_user`
--
ALTER TABLE `role_user`
  ADD CONSTRAINT `fk_role_user` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`),
  ADD CONSTRAINT `fk_role_user2` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`);

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `fk_user_address` FOREIGN KEY (`address_id`) REFERENCES `address` (`address_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
