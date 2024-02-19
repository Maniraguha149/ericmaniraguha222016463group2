-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 19, 2024 at 10:33 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `maniraguha_eric_milkdiarycollectiondb`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `fname` varchar(20) DEFAULT NULL,
  `lname` varchar(20) DEFAULT NULL,
  `id_number` varchar(30) DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `gender` varchar(29) DEFAULT NULL,
  `martial_status` varchar(20) DEFAULT NULL,
  `DoB` varchar(30) DEFAULT NULL,
  `email` varchar(26) DEFAULT NULL,
  `password` varchar(24) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`fname`, `lname`, `id_number`, `phone`, `gender`, `martial_status`, `DoB`, `email`, `password`) VALUES
('dodai', 'ericc', '123456789', '0987532', 'Male', 'married and divorced', '1880_02_13', 'dodai2gmail.com', '12345'),
('dodai', 'ericc', '123456789', '0987532', 'Male', 'married and divorced', '1880_02_13', 'dodai2gmail.com', '12345'),
('', '', '', '', 'Male', '', '', '', ''),
('', '', '', '', 'Male', '', '', '', ''),
('', '', '', '', 'Male', '', '', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `farmers`
--

CREATE TABLE `farmers` (
  `farmer_id` int(11) NOT NULL,
  `farmer_name` varchar(255) DEFAULT NULL,
  `contact_number` varchar(20) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `farmers`
--

INSERT INTO `farmers` (`farmer_id`, `farmer_name`, `contact_number`, `address`) VALUES
(1, 'ertyu', 'ertyhjk', 'sdfghj'),
(2, 'Jadon Sancho', '078823416', '450kgl_avenue'),
(3, 'Michael dan', '073382384', 'oak_road'),
(4, 'ERIC', 'DODAI', 'KIGAL'),
(5, 'Robert Willison', '072345376', '500cedar_court'),
(6, 'eric', 'mtn', 'kigali_rwanda'),
(8, 'vnmhfjd', 'ettytyt', 'sfs'),
(9, 'yiiiiiiiy', 'gdt', 'fydt'),
(14, 'gfdsadfg', 'kut', 'kiuytrewert'),
(15, 'TRTRTR', 'RTDFG', 'TYYRTYUGF'),
(16, 'dfgb', 'cvbn', 'cvbn'),
(17, '', 'VBN', ' BN'),
(18, 'A', '', ''),
(19, 'ert', 'er', '5tf'),
(20, 'chyujt', 'fgh', 'dfg'),
(21, '', '', ''),
(22, 'big man', 'yt', 'rulindo'),
(23, 'big man', 'yt', 'rulindo'),
(24, 'eric', 'maniraguha', 'kigari_rwanda'),
(25, 'vnmhfjd', 'ettytyt', 'sfs'),
(26, '', '', ''),
(27, '', '', ''),
(28, '', '', ''),
(29, 'eri', 'yon', 'kigl'),
(30, '', '', ''),
(31, 't', 'rt', 'kigo'),
(32, 'eric', 'mtn', 'kigali_rwanda');

-- --------------------------------------------------------

--
-- Table structure for table `inventory`
--

CREATE TABLE `inventory` (
  `inventory_id` int(11) NOT NULL,
  `collection_id` int(11) DEFAULT NULL,
  `expiration_date` date DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `inventory`
--

INSERT INTO `inventory` (`inventory_id`, `collection_id`, `expiration_date`, `quantity`) VALUES
(8, 3, '2009-02-04', 89),
(9, 2, '2009-05-04', 5),
(10, 2, '2000-06-09', 45),
(11, 2, '2006-09-04', 76),
(12, 4, '2003-06-05', 78);

-- --------------------------------------------------------

--
-- Table structure for table `milkcollection`
--

CREATE TABLE `milkcollection` (
  `collection_id` int(11) NOT NULL,
  `farmer_id` int(11) DEFAULT NULL,
  `collection_date` date DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `milkcollection`
--

INSERT INTO `milkcollection` (`collection_id`, `farmer_id`, `collection_date`, `quantity`) VALUES
(2, 2, '2005-08-06', 56),
(3, 3, '2000-05-07', 78),
(4, 4, '2000-04-07', 43),
(5, 2, '2005-08-06', 56),
(6, 2, '2005-08-06', 56),
(7, 3, '2000-05-07', 78),
(8, 3, '2000-05-07', 78),
(9, 4, '2000-06-08', 67);

-- --------------------------------------------------------

--
-- Table structure for table `payments`
--

CREATE TABLE `payments` (
  `payment_id` int(11) NOT NULL,
  `payment_amount` int(11) DEFAULT NULL,
  `payment_date` date NOT NULL,
  `farmer_id` int(11) DEFAULT NULL,
  `collection_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `payments`
--

INSERT INTO `payments` (`payment_id`, `payment_amount`, `payment_date`, `farmer_id`, `collection_id`) VALUES
(5, 568, '2004-09-07', 2, 3),
(7, 58, '2004-08-06', 3, 4),
(8, 300, '2023-12-03', 5, 3),
(9, 2345, '2009-03-07', 3, 5),
(10, 46, '2004-06-08', 3, 5),
(11, 56, '2009-04-07', 6, 3),
(12, 56, '2009-08-09', 8, 6),
(13, 567, '2009-06-05', 4, 5);

-- --------------------------------------------------------

--
-- Table structure for table `reports`
--

CREATE TABLE `reports` (
  `report_id` int(11) NOT NULL,
  `report_date` date DEFAULT NULL,
  `total_milk_collacted` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `farmers`
--
ALTER TABLE `farmers`
  ADD PRIMARY KEY (`farmer_id`);

--
-- Indexes for table `inventory`
--
ALTER TABLE `inventory`
  ADD PRIMARY KEY (`inventory_id`),
  ADD KEY `collection_id` (`collection_id`);

--
-- Indexes for table `milkcollection`
--
ALTER TABLE `milkcollection`
  ADD PRIMARY KEY (`collection_id`),
  ADD KEY `farmer_id` (`farmer_id`);

--
-- Indexes for table `payments`
--
ALTER TABLE `payments`
  ADD PRIMARY KEY (`payment_id`),
  ADD KEY `farmer_id` (`farmer_id`),
  ADD KEY `collection_id` (`collection_id`);

--
-- Indexes for table `reports`
--
ALTER TABLE `reports`
  ADD PRIMARY KEY (`report_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `farmers`
--
ALTER TABLE `farmers`
  MODIFY `farmer_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT for table `inventory`
--
ALTER TABLE `inventory`
  MODIFY `inventory_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `milkcollection`
--
ALTER TABLE `milkcollection`
  MODIFY `collection_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `payments`
--
ALTER TABLE `payments`
  MODIFY `payment_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `reports`
--
ALTER TABLE `reports`
  MODIFY `report_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `inventory`
--
ALTER TABLE `inventory`
  ADD CONSTRAINT `inventory_ibfk_1` FOREIGN KEY (`collection_id`) REFERENCES `milkcollection` (`collection_id`);

--
-- Constraints for table `milkcollection`
--
ALTER TABLE `milkcollection`
  ADD CONSTRAINT `milkcollection_ibfk_1` FOREIGN KEY (`farmer_id`) REFERENCES `farmers` (`farmer_id`);

--
-- Constraints for table `payments`
--
ALTER TABLE `payments`
  ADD CONSTRAINT `payments_ibfk_1` FOREIGN KEY (`farmer_id`) REFERENCES `farmers` (`farmer_id`),
  ADD CONSTRAINT `payments_ibfk_2` FOREIGN KEY (`collection_id`) REFERENCES `milkcollection` (`collection_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
