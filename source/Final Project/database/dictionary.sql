-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 23, 2018 at 10:10 AM
-- Server version: 10.1.37-MariaDB
-- PHP Version: 7.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dictionary`
--

-- --------------------------------------------------------

--
-- Table structure for table `english`
--

CREATE TABLE `english` (
  `ID` int(11) NOT NULL,
  `word` varchar(50) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `mean` varchar(10000) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `audio` varchar(1000) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `upBy` varchar(100) COLLATE utf8mb4_vietnamese_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

--
-- Dumping data for table `english`
--

INSERT INTO `english` (`ID`, `word`, `mean`, `audio`, `upBy`) VALUES
(1, 'adapt', 'explain/adapt.html', 'audio/adapt.mp3', 'hungphucnguyen1998@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `history`
--

CREATE TABLE `history` (
  `ID` bigint(20) NOT NULL,
  `UserID` varchar(100) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `Word` varchar(50) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `Date` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

--
-- Dumping data for table `history`
--

INSERT INTO `history` (`ID`, `UserID`, `Word`, `Date`) VALUES
(1, '1', 'Adapt', '2018-12-23 15:04:54'),
(2, '4', 'Adapt', '2018-12-23 15:13:41'),
(3, '4', 'Adapt', '2018-12-23 15:22:13'),
(4, '1', 'dad', '2018-12-23 15:52:24'),
(5, '4', 'dad', '2018-12-23 15:56:49'),
(6, '4', 'Adapt', '2018-12-23 15:56:54');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `ID` int(11) NOT NULL,
  `Name` varchar(50) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `Email` varchar(50) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `PassWord` varchar(50) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `Phone` varchar(20) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `DB` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`ID`, `Name`, `Email`, `PassWord`, `Phone`, `DB`) VALUES
(1, 'Nguyen Hung Phuc', 'hungphucnguyen1998@gmail.com', 'haloman1998', '0723737108', '1998-08-14'),
(2, 'Nguyen Chau Thao Quan', 'thaoquannguyenchau1996@gmail.com', 'Quan1996', '0938706433', '1996-08-11'),
(3, 'Nguyen Trung Ngoc', 'ngocpasal@gmail.com', 'ngoc763952', '0393781055', '1997-11-23'),
(4, 'Ho Tan Viet', 'viet98@gmail.com', '123456789', '12355566', '1998-08-14');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `english`
--
ALTER TABLE `english`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `history`
--
ALTER TABLE `history`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `english`
--
ALTER TABLE `english`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `history`
--
ALTER TABLE `history`
  MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
