-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3308
-- Generation Time: Dec 28, 2021 at 07:32 AM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 8.0.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbmsproj`
--

-- --------------------------------------------------------

--
-- Table structure for table `booking`
--

CREATE TABLE `booking` (
  `book_id` int(11) NOT NULL,
  `userid` varchar(20) DEFAULT NULL,
  `b_price` int(11) DEFAULT NULL,
  `train_no` int(11) DEFAULT NULL,
  `no_of_passengers` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `booking`
--

INSERT INTO `booking` (`book_id`, `userid`, `b_price`, `train_no`, `no_of_passengers`) VALUES
(1, 'admin', 850, 12620, 1),
(2, 'admin', 3400, 12620, 4),
(3, 'admin', 1000, 12301, 1),
(4, 'admin', 2700, 12213, 3),
(7, 'admin', 3400, 12620, 4),
(8, 'admin', 2550, 12620, 3);

-- --------------------------------------------------------

--
-- Table structure for table `ticket`
--

CREATE TABLE `ticket` (
  `ticket_no` int(11) NOT NULL,
  `ticket_price` int(11) DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `train_table`
--

CREATE TABLE `train_table` (
  `train_no` int(11) NOT NULL,
  `train_name` varchar(20) DEFAULT NULL,
  `source` varchar(20) DEFAULT NULL,
  `destination` varchar(20) DEFAULT NULL,
  `arrival_time` varchar(10) DEFAULT NULL,
  `departure_time` varchar(10) DEFAULT NULL,
  `running_days` varchar(255) DEFAULT NULL,
  `price` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `train_table`
--

INSERT INTO `train_table` (`train_no`, `train_name`, `source`, `destination`, `arrival_time`, `departure_time`, `running_days`, `price`) VALUES
(10104, 'Mandovi Express', 'Madgaon', 'Mumbai CST', '09:15', '21:45', 'Mon Tue Thu Fri Sat', 850),
(12052, 'Janshatabdi Express', 'Madgaon', 'Dadar', '14:40', '23:30', 'Mon', 510),
(12113, 'GaribRath Express', 'Pune', 'Nagpur', '17:40', '09:10', 'Mon Tue Fri', 680),
(12213, 'Duranto Express', 'Bengaluru', 'New Delhi', '23:40', '07:35', 'Wed', 900),
(12243, 'Shatabdi Express', 'Chennai', 'Coimbatore', '07:10', '14:15', 'Mon Tue Thu Fri', 740),
(12301, 'Rajdhani Express', 'Howrah', 'New Delhi', '07:20', '13:30', 'Mon Tue Wed Thu Fri Sat', 1000),
(12359, 'GaribRath Express', 'Kolkata', 'Patna', '20:05', '05:20', 'Mon Tue', 480),
(12617, 'Mangala Express', 'Ernakulam', 'Nizamuddin', '13:25', '13:25', 'Mon Tue Thu Fri Sat Sun', 920),
(12620, 'Matsyagandha Express', 'Mangaluru', 'Mumbai LTT', '14:15', '06:35', 'Mon Tue Wed Thu Fri Sat Sun', 850),
(22811, 'Rajdhani Express', 'Bhuvaneshwar', 'New Delhi', '10:35', '09:55', 'Mon Tue Thu Fri Sat', 1100);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `username` varchar(20) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `contact` varchar(12) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`username`, `name`, `password`, `address`, `age`, `gender`, `contact`) VALUES
('admin', 'Admin', 'admin', NULL, NULL, NULL, NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `booking`
--
ALTER TABLE `booking`
  ADD PRIMARY KEY (`book_id`),
  ADD KEY `userid` (`userid`),
  ADD KEY `train_no` (`train_no`);

--
-- Indexes for table `ticket`
--
ALTER TABLE `ticket`
  ADD PRIMARY KEY (`ticket_no`),
  ADD KEY `username` (`username`);

--
-- Indexes for table `train_table`
--
ALTER TABLE `train_table`
  ADD PRIMARY KEY (`train_no`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `booking`
--
ALTER TABLE `booking`
  MODIFY `book_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `booking`
--
ALTER TABLE `booking`
  ADD CONSTRAINT `booking_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `user` (`username`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `booking_ibfk_2` FOREIGN KEY (`train_no`) REFERENCES `train_table` (`train_no`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `ticket`
--
ALTER TABLE `ticket`
  ADD CONSTRAINT `ticket_ibfk_1` FOREIGN KEY (`username`) REFERENCES `user` (`username`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
