-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 08, 2025 at 07:02 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.1.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cemsdb`
--
CREATE DATABASE IF NOT EXISTS `cemsdb` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `cemsdb`;

-- --------------------------------------------------------

--
-- Table structure for table `events`
--

DROP TABLE IF EXISTS `events`;
CREATE TABLE `events` (
  `id` int(11) NOT NULL,
  `event_no` int(11) NOT NULL,
  `event_name` varchar(100) DEFAULT NULL,
  `event_type` varchar(50) DEFAULT NULL,
  `location` varchar(100) DEFAULT NULL,
  `date_start` datetime DEFAULT NULL,
  `date_end` datetime DEFAULT NULL,
  `participants` text DEFAULT NULL,
  `registered` varchar(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `events`
--

INSERT INTO `events` (`id`, `event_no`, `event_name`, `event_type`, `location`, `date_start`, `date_end`, `participants`, `registered`) VALUES
(1, 1, 'Basketball', 'Sports Tournament', 'Covered Court', '2025-05-02 08:00:00', '2025-05-02 12:00:00', 'jhon,ligma', 'true'),
(10, 3, 'Baseball', 'Sports Tournament', 'Oval', '2025-05-02 12:00:00', '2025-05-02 18:00:00', 'jhon', 'true'),
(11, 2, 'Meeting', 'Student Assembly', 'BISU Calape Campus', '2025-04-25 08:00:00', '2025-04-25 12:00:00', 'jhon', 'true');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `student_id` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `role` varchar(50) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`student_id`, `name`, `username`, `email`, `gender`, `role`, `password`) VALUES
('121444', 'Jhon', 'jhon', 'jhon123@gmail.com', 'Male', 'Student', 'jhon143'),
('646452', 'Pokemon', 'poke', 'poke143@gmail.com', 'Female', 'Student', 'poke123'),
('717224', 'Whelzcy Mark Laniba', 'whelz', 'whelz123@gmail.com', 'Male', 'Admin', 'whelz14390'),
('890868', 'iori', 'ligma', 'sigma@gmail.com', 'Male', 'Student', 'pistingyawa'),
(NULL, 'Pokemon', 'pokemon', 'pokemon123@gmail.com', 'Male', 'Crew', 'pokemon143');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `events`
--
ALTER TABLE `events`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD UNIQUE KEY `student_id` (`student_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `events`
--
ALTER TABLE `events`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
