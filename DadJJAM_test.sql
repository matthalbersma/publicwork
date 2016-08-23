-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Aug 18, 2016 at 09:26 AM
-- Server version: 5.7.13-0ubuntu0.16.04.2
-- PHP Version: 7.0.8-0ubuntu0.16.04.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `DadJJAM_test`
--

-- --------------------------------------------------------

--
-- Table structure for table `authorities`
--

CREATE TABLE `authorities` (
  `username` varchar(20) NOT NULL,
  `authority` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `authorities`
--

INSERT INTO `authorities` (`username`, `authority`) VALUES
('author', 'ROLE_ADMIN'),
('marketing', 'ROLE_ADMIN');

-- --------------------------------------------------------

--
-- Table structure for table `Blog_posts`
--

CREATE TABLE `Blog_posts` (
  `Blog_postsID` int(11) NOT NULL,
  `Title` varchar(60) DEFAULT NULL,
  `Body` longtext NOT NULL,
  `Status` text,
  `GoLiveDate` datetime DEFAULT CURRENT_TIMESTAMP,
  `ExpireDate` datetime DEFAULT NULL,
  `URL` varchar(60) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Blog_posts`
--

INSERT INTO `Blog_posts` (`Blog_postsID`, `Title`, `Body`, `Status`, `GoLiveDate`, `ExpireDate`, `URL`) VALUES
(659, NULL, 'shorter', 'Static', NULL, '3000-08-12 12:00:00', NULL),
(660, NULL, 'short', 'Post', NULL, '1959-08-12 12:00:00', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `Blog_postsHashtags`
--

CREATE TABLE `Blog_postsHashtags` (
  `Blog_postsID` int(11) NOT NULL,
  `HashTagID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Hashtags`
--

CREATE TABLE `Hashtags` (
  `HashtagID` int(11) NOT NULL,
  `Description` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `User`
--

CREATE TABLE `User` (
  `UserID` int(11) NOT NULL,
  `Access` enum('Admin','Marketing') NOT NULL,
  `Username` varchar(60) NOT NULL,
  `Password` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `user_id` int(11) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `enabled` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `username`, `password`, `enabled`) VALUES
(1, 'author', 'author', 1),
(2, 'marketing', 'marketing', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `authorities`
--
ALTER TABLE `authorities`
  ADD KEY `username` (`username`);

--
-- Indexes for table `Blog_posts`
--
ALTER TABLE `Blog_posts`
  ADD PRIMARY KEY (`Blog_postsID`);

--
-- Indexes for table `Hashtags`
--
ALTER TABLE `Hashtags`
  ADD PRIMARY KEY (`HashtagID`);

--
-- Indexes for table `User`
--
ALTER TABLE `User`
  ADD PRIMARY KEY (`UserID`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`),
  ADD KEY `username` (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Blog_posts`
--
ALTER TABLE `Blog_posts`
  MODIFY `Blog_postsID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=661;
--
-- AUTO_INCREMENT for table `Hashtags`
--
ALTER TABLE `Hashtags`
  MODIFY `HashtagID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `User`
--
ALTER TABLE `User`
  MODIFY `UserID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `authorities`
--
ALTER TABLE `authorities`
  ADD CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
