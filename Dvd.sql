-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Sep 01, 2016 at 10:12 PM
-- Server version: 5.7.14
-- PHP Version: 7.0.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `DvdLibrary`
--

-- --------------------------------------------------------

--
-- Table structure for table `Dvd`
--

CREATE TABLE `Dvd` (
  `id` int(11) NOT NULL,
  `imdbID` text NOT NULL,
  `title` text NOT NULL,
  `releaseDate` text NOT NULL,
  `mpaaRating` text,
  `director` text,
  `userRating` text,
  `coverURL` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Dvd`
--

INSERT INTO `Dvd` (`id`, `imdbID`, `title`, `releaseDate`, `mpaaRating`, `director`, `userRating`, `coverURL`) VALUES
(1, 'tt0372784', 'Batman Begins', '2005', 'PG-13', 'Christopher Nolan', 'After training with his mentor, Batman begins his fight to free crime-ridden Gotham City from the corruption that Scarecrow and the League of Shadows have cast upon it.', 'http://ia.media-imdb.com/images/M/MV5BNTM3OTc0MzM2OV5BMl5BanBnXkFtZTYwNzUwMTI3._V1_SX300.jpg'),
(2, 'tt0816692', 'Interstellar', '2014', 'PG-13', 'Christopher Nolan', 'A team of explorers travel through a wormhole in space in an attempt to ensure humanity\'s survival.', 'http://ia.media-imdb.com/images/M/MV5BMjIxNTU4MzY4MF5BMl5BanBnXkFtZTgwMzM4ODI3MjE@._V1_SX300.jpg'),
(3, 'tt0118884', 'Contact', '1997', 'PG', 'Robert Zemeckis', 'Dr. Ellie Arroway, after years of searching, finds conclusive radio proof of intelligent aliens, who send plans for a mysterious machine.', 'http://ia.media-imdb.com/images/M/MV5BYWNkYmFiZjUtYmI3Ni00NzIwLTkxZjktN2ZkMjdhMzlkMDc3XkEyXkFqcGdeQXVyNDk3NzU2MTQ@._V1_SX300.jpg'),
(4, 'tt0796366', 'Star Trek', '2009', 'PG-13', 'J.J. Abrams', 'The brash James T. Kirk tries to live up to his father\'s legacy with Commander Spock keeping him in check as a vengeful, time-traveling Romulan creates black holes to destroy the Federation one planet at a time.', 'http://ia.media-imdb.com/images/M/MV5BMjE5NDQ5OTE4Ml5BMl5BanBnXkFtZTcwOTE3NDIzMw@@._V1_SX300.jpg'),
(6, 'tt2488496', 'Star Wars: The Force Awakens', '2015', 'PG-13', 'J.J. Abrams', 'Three decades after the defeat of the Galactic Empire, a new threat arises. The First Order attempts to rule the galaxy and only a ragtag group of heroes can stop them, along with the help of the Resistance.', 'http://ia.media-imdb.com/images/M/MV5BOTAzODEzNDAzMl5BMl5BanBnXkFtZTgwMDU1MTgzNzE@._V1_SX300.jpg');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Dvd`
--
ALTER TABLE `Dvd`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Dvd`
--
ALTER TABLE `Dvd`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
