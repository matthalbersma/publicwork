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
-- Database: `DadJJAM`
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
('marketing', 'ROLE_MARKETING');

-- --------------------------------------------------------

--
-- Table structure for table `Blog_posts`
--

CREATE TABLE `Blog_posts` (
  `Blog_postsID` int(11) NOT NULL,
  `Title` varchar(60) DEFAULT NULL,
  `Body` longtext NOT NULL,
  `Status` text,
  `GoLiveDate` datetime DEFAULT NULL,
  `ExpireDate` datetime DEFAULT NULL,
  `URL` longtext
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Blog_posts`
--

INSERT INTO `Blog_posts` (`Blog_postsID`, `Title`, `Body`, `Status`, `GoLiveDate`, `ExpireDate`, `URL`) VALUES
(43, '', '#hashtag #more #less#youbetcha', NULL, '1950-01-01 12:00:00', '3000-01-01 12:00:00', '<a onclick=mySearch(\'#hashtag\')>#hashtag</a>,<a onclick=mySearch(\'#more\')>#more</a>,<a onclick=mySearch(\'#less\')>#less</a>,<a onclick=mySearch(\'#youbetcha\')>#youbetcha</a>,'),
(50, '', 'wow', NULL, '2016-08-17 06:25:23', '3000-01-01 12:00:00', ''),
(56, 'About This Guy', '<p>Hi, I\'m Kaptain. Well, that\'s how people know me anyway. I got my start on Coney Island (well, ok, Brighton Beach), sellin\' gin to minors. I have fourteen dogs. They are named after Russian Oligarchs. Except one is named Hamms. I have eighty three knives. They also have names.&nbsp;</p><p>one of them is named....</p><p style="font-family: inherit; overflow: hidden; margin: 5px; padding: 4px; border-color: rgb(226, 226, 226); border-radius: 3px; cursor: pointer; font-size: 8px; line-height: 8px; transition: 0.3s; color: rgb(0, 0, 0); background: rgb(246, 246, 246);"><img src="https://mail.google.com/mail/u/0/?ui=2&amp;ik=eba9359f44&amp;view=fimg&amp;th=1569caa53090883d&amp;attid=0.1&amp;disp=emb&amp;realattid=ii_1569caa480956649&amp;attbid=ANGjdJ90B0xCAKWp_1sAVGn97H0yDMidM2lRowBLQG1O0eLPrtvqe2q3nhOpRujCgNKNrTXylk9ViZYDkEwU0VaUiEhaxRkL8kJjoKZUhE2r4vbCP7g3EEfny0FuH2s&amp;sz=w518-h388&amp;ats=1471507324928&amp;rm=1569caa53090883d&amp;zw&amp;atsh=1" alt="Inline image 1" style="width: 50%; float: right;"><br></p>', 'Static', NULL, NULL, ''),
(57, '', '<p>Here is my niece performing live!!&nbsp;<iframe frameborder="0" src="//www.youtube.com/embed/tVj0ZTS4WF4" width="640" height="360" class="note-video-clip"></iframe></p>', 'Post', NULL, NULL, ''),
(58, '', '<p>for those days when I\'m feelin down</p><p><iframe frameborder="0" src="//www.youtube.com/embed/KolfEhV-KiA" width="640" height="360" class="note-video-clip"></iframe><br></p>', 'Post', NULL, NULL, ''),
(59, '', '<p><iframe frameborder="0" src="//www.youtube.com/embed/1_F34u8ZWgQ" width="640" height="360" class="note-video-clip"></iframe>\n\n                    </p>', 'Post', NULL, NULL, ''),
(60, '', '<p><img src="https://mail.google.com/mail/u/0/?ui=2&amp;ik=eba9359f44&amp;view=fimg&amp;th=1569cb5b7e725de2&amp;attid=0.1&amp;disp=inline&amp;realattid=1542987936663863296-local0&amp;safe=1&amp;attbid=ANGjdJ_WAyFK_ZDmvDve2bOPXZ3UAS4XzDJdNF2BtJY_rRGFp5GC6bt6LGwdK3pexoNW3LV0j3Yd3SFSAn5T5pRlgg83jRSosYqxN3Lz47OTtM2vDQO6kB1csKCpwS0&amp;ats=1471509424786&amp;rm=1569cb5b7e725de2&amp;zw&amp;sz=w1680-h936" alt="Displaying IMG_20160818_031104.jpg" style="width: 50%;">\n\n                    </p><p><br></p><p><br></p><p>Here we go, ano<span style="background-color: rgb(255, 198, 156);">ther fantastic wed</span>nesday!</p><p><br></p><p>#wednesday #gethammed #landofskybluewaters</p>', 'Post', NULL, NULL, '<a onclick=mySearch(\'#wednesday\')>#wednesday</a>,<a onclick=mySearch(\'#gethammed\')>#gethammed</a>,<a onclick=mySearch(\'#landofskybluewaters\')>#landofskybluewaters</a>,');

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
  MODIFY `Blog_postsID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=62;
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
