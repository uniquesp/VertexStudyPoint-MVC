-- phpMyAdmin SQL Dump
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `vertexstudypt`
--

----------------------------------------------------------

--
-- Table structure for table `ReadingHall`
--
  CREATE TABLE IF NOT EXISTS `Reading_hall` (
    `H_id` int(11)  PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `H_type` varchar(30) DEFAULT NULL,
    `seat_no` varchar(10) DEFAULT NULL,
    `status`  varchar(10) DEFAULT NULL,
 `date_registered` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
 ) ;


INSERT INTO `Reading_hall` VALUES(1,'ac_hall','A1','UnOccupied','2023-06-25 12:12:12'),(2,'ac_hall','A2','UnOccupied','2023-06-25 12:12:12');
INSERT INTO `Reading_hall` VALUES(3,'ac_hall','A3','UnOccupied','2023-06-25 12:12:12'),(4,'ac_hall','A4','UnOccupied','2023-06-25 12:12:12');
INSERT INTO `Reading_hall` VALUES(5,'ac_hall','A5','UnOccupied','2023-06-25 12:12:12'),(6,'ac_hall','A6','UnOccupied','2023-06-25 12:12:12');
INSERT INTO `Reading_hall` VALUES(7,'ac_hall','A7','UnOccupied','2023-06-25 12:12:12'),(8,'ac_hall','A8','UnOccupied','2023-06-25 12:12:12');
INSERT INTO `Reading_hall` VALUES(9,'ac_hall','A9','UnOccupied','2023-06-25 12:12:12'),(10,'ac_hall','A10','UnOccupied','2023-06-25 12:12:12');

INSERT INTO `Reading_hall` VALUES(11,'nonac_hall','N1','UnOccupied','2023-06-25 12:12:12'),(12,'nonac_hall','N2','UnOccupied','2023-06-25 12:12:12');
INSERT INTO `Reading_hall` VALUES(13,'nonac_hall','N3','UnOccupied','2023-06-25 12:12:12'),(14,'nonac_hall','N4','UnOccupied','2023-06-25 12:12:12');
INSERT INTO `Reading_hall` VALUES(15,'nonac_hall','N5','UnOccupied','2023-06-25 12:12:12');

INSERT INTO `Reading_hall` VALUES(16,'new_hall','G1','UnOccupied','2023-06-25 12:12:12'),(17,'new_hall','G2','UnOccupied','2023-06-25 12:12:12');
INSERT INTO `Reading_hall` VALUES(18,'new_hall','G3','UnOccupied','2023-06-25 12:12:12'),(19,'new_hall','G4','UnOccupied','2023-06-25 12:12:12');
INSERT INTO `Reading_hall` VALUES(20,'new_hall','G5','UnOccupied','2023-06-25 12:12:12');
----------------------------------------------------------
--
-- Table structure for table `membership`
--

CREATE TABLE IF NOT EXISTS `membership` (
  `m_id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `m_name` varchar(100) DEFAULT NULL,
  `m_price` int(11) DEFAULT NULL,
  `m_facility`longtext,
 `date_registered` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);


INSERT INTO membership VALUES(1,'Recommended',400,'Only Tea/Coffee,Biscuits 3 Times a Day','2023-06-25 12:12:12');
INSERT INTO membership VALUES(2,'Basic',300,'No Food, Only Ragistration Fee','2023-06-25 12:12:12');
INSERT INTO membership VALUES(3,'Premium  ',500,'Lunch, Only Tea/Coffee 2 Times a Day','2023-06-25 12:12:12');
INSERT INTO membership VALUES(4,'Pro',600,'Dinner, Only Tea/Coffee,2 Times a Day','2023-06-25 12:12:12');
INSERT INTO membership VALUES(5,'Best',450,'Breakfast Only Tea/Coffee, 3 Times a Day','2023-06-25 12:12:12');

----------------------------------------------------------
--
-- Table structure for table `student`
--
CREATE TABLE IF NOT EXISTS `student` (
  `s_id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `s_FullName` varchar(100) DEFAULT NULL,
  `EmailId` varchar(100) DEFAULT NULL,
  `ContactNo` char(10) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `dob` date  NOT NULL,
  `s_Address` varchar(255) DEFAULT NULL,
  `study` varchar(20) NOT NULL,  
  `hall_type` varchar(20) NOT NULL, 
  `seat_no` varchar(10) NOT NULL,
  `Password` varchar(100) DEFAULT NULL,
 `date_registered` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);


----------------------------------------------------------
----------------------------------------------------------
--
-- Table structure for table `membershipdetails`
--

CREATE TABLE IF NOT EXISTS `membdetails` (
  `d_id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `m_id`  int(11) DEFAULT NULL,
  `EndDate` varchar(20) DEFAULT NULL,
  `StartDate` varchar(20) DEFAULT NULL,
  `Total_days`int(11) DEFAULT NULL,
  `Status` varchar(20) DEFAULT NULL,
  `s_id` int(11),
  `s_FullName` varchar(100) DEFAULT NULL,
Constraint FK_Key1 Foreign Key(s_id) References student(s_id),
Constraint FK_Key3 Foreign Key(m_id) References membership(m_id),
 `date_registered` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);


----------------------------------------------------------
--
-- Table structure for table `staff`
--

CREATE TABLE IF NOT EXISTS `staff` (
  `st_id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `st_name` varchar(100) DEFAULT NULL,
  `EmailId` varchar(120) DEFAULT NULL,
  `ContactNumber` char(10) DEFAULT NULL,
  `st_work` varchar(20) NOT NULL,
  `st_salary` numeric(10,2) NOT NULL,
  `joining_date` date NOT NULL,
  `gender` varchar(20) NOT NULL,
  `addr` varchar(200) NOT NULL,
 `date_registered` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);


----------------------------------------------------------
--
-- Table structure for table `success_story`
--

CREATE TABLE IF NOT EXISTS `success_story` (
 `sc_id` int(11) Primary Key AUTO_INCREMENT,
 `sc_title` varchar(50) NOT NULL,
 `sc_story` longtext,
 `s_id` int(11),
 `EmailId` varchar(100) DEFAULT NULL,
Constraint FK_Key7 Foreign Key(s_id) References student(s_id),
 `date_registered` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
 );


-- --------------------------------------------------------

--
-- Table structure for table `feedback`
--
CREATE TABLE IF NOT EXISTS `feedback` (
  `f_id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `feedback` varchar (50) NOT NULL,
  `rating` varchar(10) NOT NULL,
  `s_id` int(11),
  `EmailId` varchar(100) DEFAULT NULL,
Constraint FK_Key8 Foreign Key(s_id) References student(s_id),
 `date_registered` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

----------------------------------------------------------

--
-- Table structure for table `leaveform`
--

CREATE TABLE IF NOT EXISTS `leave_form` (
  `l_id` int(11) PRIMARY KEY,
  `H_id`  int(11), 
  `hall_type` varchar(20) DEFAULT NULL,
  `seat_no` varchar(30) NOT NULL,
  `Ldate` date DEFAULT NULL,
  `s_id` int(11),
  `EmailId` varchar(100) DEFAULT NULL,
  Constraint FK_Key9 Foreign Key(s_id) References student(s_id),   
  Constraint FK_Key10 Foreign Key(H_id) References Reading_hall(H_id),   
 `date_registered` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);
----------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE IF NOT EXISTS `payment` (
  `p_id` int(11) PRIMARY KEY,
  `m_id`  int(11) NOT NULL,
  `s_id` int(11) NOT NULL,
  `p_amount` int(11) DEFAULT NULL,
  `status` varchar(11) DEFAULT NULL,
  Constraint FK_Key100 Foreign Key(s_id) References student(s_id),
  Constraint FK_Key110 Foreign Key(m_id) References membership(m_id),
 `date_registered` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
 `stud_mailID` varchar(30) NOT NULL,
 `mem_name` varchar(30) NOT NULL
);

----------------------------------------------------------------
----------------------------------------------------------

--
-- Table structure for table `login`
--
CREATE TABLE IF NOT EXISTS `login` (
  `email` varchar(30) PRIMARY KEY,
  `pass`  varchar(30) NOT NULL
);

-- Password encrypted
----------------------------------------------------------------
-----------------------------------------------------------------


