-- --------------------------------------------------------
-- Host                          :127.0.0.1
-- Server version                :5.5.28 - MySQL Community Server (GPL)
-- Server OS                     :Win64
-- HeidiSQL Version              :7.0.0.4291
-- Created                       :2013-02-06 07:32:17
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping database structure for simplytech
CREATE DATABASE IF NOT EXISTS `simplytech` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `simplytech`;


-- Dumping structure for table simplytech.accommodations
CREATE TABLE IF NOT EXISTS `accommodations` (
  `id` text NOT NULL,
  `Suite` text NOT NULL,
  `Price` double NOT NULL,
  `Room` int(10) DEFAULT NULL,
  `CheckOut` text,
  `Day` int(5) DEFAULT NULL,
  `RoomNumber` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.


-- Dumping structure for table simplytech.alarmclock
CREATE TABLE IF NOT EXISTS `alarmclock` (
  `hour` int(10) DEFAULT NULL,
  `minute` int(10) DEFAULT NULL,
  `username` text,
  `id` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.


-- Dumping structure for table simplytech.announcement
CREATE TABLE IF NOT EXISTS `announcement` (
  `ID` int(10) NOT NULL,
  `Type` text,
  `Image` text,
  `Title` text,
  `Details` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.


-- Dumping structure for table simplytech.booking
CREATE TABLE IF NOT EXISTS `booking` (
  `title` text,
  `price` double DEFAULT NULL,
  `points` int(10) DEFAULT NULL,
  `username` text,
  `id` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.


-- Dumping structure for table simplytech.checklogin
CREATE TABLE IF NOT EXISTS `checklogin` (
  `Username` text,
  `ID` int(10) NOT NULL,
  `IdTi` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.


-- Dumping structure for table simplytech.creditcard
CREATE TABLE IF NOT EXISTS `creditcard` (
  `ID` int(10) NOT NULL,
  `CardNumber` text NOT NULL,
  `ExpiryMonth` int(10) NOT NULL,
  `ExpiryYear` int(10) NOT NULL,
  `ExpiryDate` text NOT NULL,
  `CardHolderName` text NOT NULL,
  `Country` text NOT NULL,
  `CVC` text NOT NULL,
  `StreetAddress` text,
  `CardType` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.


-- Dumping structure for table simplytech.customer
CREATE TABLE IF NOT EXISTS `customer` (
  `ID` int(10) NOT NULL,
  `RoomNumber` text NOT NULL,
  `ExtraCharges` double DEFAULT NULL,
  `Stay` int(10) DEFAULT NULL,
  `Membership` text NOT NULL,
  `CheckOut` text,
  `Points` int(10) DEFAULT NULL,
  `DoNotDisturb` int(10) DEFAULT NULL,
  `Alarm` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.


-- Dumping structure for table simplytech.customervouchers
CREATE TABLE IF NOT EXISTS `customervouchers` (
  `ID` int(10) DEFAULT NULL,
  `VouchersID` int(10) DEFAULT NULL,
  `Image` text,
  `Title` text,
  `Subtitle` text,
  `PointsRequired` int(10) DEFAULT NULL,
  `ExpiryDate` text,
  `Details` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.


-- Dumping structure for table simplytech.menu
CREATE TABLE IF NOT EXISTS `menu` (
  `item` text,
  `quantity` text,
  `Column 3` int(10) DEFAULT NULL,
  `totalPrice` double DEFAULT NULL,
  `points` int(10) DEFAULT NULL,
  `username` text,
  `id` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.


-- Dumping structure for table simplytech.person
CREATE TABLE IF NOT EXISTS `person` (
  `ID` int(10) NOT NULL,
  `Name` text NOT NULL,
  `Gender` text NOT NULL,
  `NRIC` text,
  `Username` text NOT NULL,
  `Password` text NOT NULL,
  `Mobile` text,
  `Address` text NOT NULL,
  `Email` text NOT NULL,
  `UserType` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.


-- Dumping structure for table simplytech.roomservices
CREATE TABLE IF NOT EXISTS `roomservices` (
  `service` text,
  `username` text,
  `id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.


-- Dumping structure for table simplytech.staffdetails
CREATE TABLE IF NOT EXISTS `staffdetails` (
  `ID` int(10) DEFAULT NULL,
  `tokenCode` tinytext,
  `workingSince` tinytext,
  `position` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.


-- Dumping structure for table simplytech.vouchers
CREATE TABLE IF NOT EXISTS `vouchers` (
  `ID` int(10) DEFAULT NULL,
  `Type` text,
  `Title` text,
  `Subtitle` text,
  `Details` text,
  `Image` text,
  `PointsRequired` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
