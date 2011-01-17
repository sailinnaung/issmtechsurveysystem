-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.17-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema survey
--

CREATE DATABASE IF NOT EXISTS survey;
USE survey;

--
-- Definition of table `function`
--

DROP TABLE IF EXISTS `function`;
CREATE TABLE `function` (
  `FUNCTION_ID` int(11) NOT NULL auto_increment,
  `FUNCTION_CODE` varchar(20) NOT NULL,
  `FUNCTION_NAME` varchar(50) default NULL,
  `DESCRIPTION` text,
  `DISPLAY_ORDER` int(11) default NULL,
  PRIMARY KEY  (`FUNCTION_ID`),
  UNIQUE KEY `FUNCTION_CODE` (`FUNCTION_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `function`
--

/*!40000 ALTER TABLE `function` DISABLE KEYS */;
INSERT INTO `function` (`FUNCTION_ID`,`FUNCTION_CODE`,`FUNCTION_NAME`,`DESCRIPTION`,`DISPLAY_ORDER`) VALUES 
 (1,'FNDUSR','FIND USER','Searching user by full name.',1),
 (2,'RSHRHM','RESEARCHER HOME','Researcher\'s home that display recent work',1),
 (3,'RSPDHM','RESPONDENT HOME','Respondent\'s home that display recent work',1),
 (4,'EDTPRF','EDIT PROFILE',NULL,2),
 (5,'NEWUSR','ADD NEW USER',NULL,3),
 (6,'SRHSUR','SEARCH SURVEY',NULL,3),
 (7,'CRTSUR','CREATE SURVEY',NULL,4);
/*!40000 ALTER TABLE `function` ENABLE KEYS */;


--
-- Definition of table `role`
--

DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `ROLE_ID` int(11) NOT NULL auto_increment,
  `ROLE_NAME` varchar(50) NOT NULL,
  `DESCRIPTION` varchar(200) default NULL,
  PRIMARY KEY  (`ROLE_ID`),
  UNIQUE KEY `ROLE_NAME` (`ROLE_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `role`
--

/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` (`ROLE_ID`,`ROLE_NAME`,`DESCRIPTION`) VALUES 
 (1,'Admin','Administration who can manage user accounts.'),
 (2,'Researcher','Researcher who can manage survey quesitonnaires.'),
 (3,'Respondent','Respondant who can reply survey quesitonnaires.');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;


--
-- Definition of table `role_function`
--

DROP TABLE IF EXISTS `role_function`;
CREATE TABLE `role_function` (
  `ROLE_ID` int(11) NOT NULL,
  `FUNCTION_ID` int(11) NOT NULL,
  KEY `FK57D5418119B7C94A` (`ROLE_ID`),
  KEY `FK57D5418112F3D586` (`FUNCTION_ID`),
  CONSTRAINT `FK57D5418112F3D586` FOREIGN KEY (`FUNCTION_ID`) REFERENCES `function` (`FUNCTION_ID`),
  CONSTRAINT `FK57D5418119B7C94A` FOREIGN KEY (`ROLE_ID`) REFERENCES `role` (`ROLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `role_function`
--

/*!40000 ALTER TABLE `role_function` DISABLE KEYS */;
INSERT INTO `role_function` (`ROLE_ID`,`FUNCTION_ID`) VALUES 
 (1,1),
 (1,4),
 (1,5),
 (2,2),
 (2,4),
 (2,6),
 (2,7),
 (3,3),
 (3,4),
 (3,6);
/*!40000 ALTER TABLE `role_function` ENABLE KEYS */;


--
-- Definition of table `survey`
--

DROP TABLE IF EXISTS `survey`;
CREATE TABLE `survey` (
  `SURVEY_ID` int(11) NOT NULL auto_increment,
  `USER_ID` int(11) NOT NULL,
  `CREATE_DATE` date NOT NULL,
  `UPDATE_DATE` datetime NOT NULL,
  `TITLE` varchar(200) NOT NULL,
  `DESCRIPTION` text,
  `STATE` int(11) NOT NULL,
  `START_DATE` date NOT NULL,
  `END_DATE` date NOT NULL,
  PRIMARY KEY  (`SURVEY_ID`),
  KEY `FK92769B5A640A7A60` (`USER_ID`),
  CONSTRAINT `FK92769B5A640A7A60` FOREIGN KEY (`USER_ID`) REFERENCES `user` (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `survey`
--

/*!40000 ALTER TABLE `survey` DISABLE KEYS */;
/*!40000 ALTER TABLE `survey` ENABLE KEYS */;


--
-- Definition of table `survey_answer`
--

DROP TABLE IF EXISTS `survey_answer`;
CREATE TABLE `survey_answer` (
  `SURVEY_ANSWER_ID` int(11) NOT NULL auto_increment,
  `SURVEY_ID` int(11) NOT NULL,
  `USER_ID` int(11) NOT NULL,
  `STATE` int(11) NOT NULL,
  `SURVEY_QUESTION_ID` int(11) NOT NULL,
  `DISPLAY_ORDER` int(11) NOT NULL,
  `SURVEY_PAGE_ANSWER_ID` int(11) NOT NULL,
  PRIMARY KEY  (`SURVEY_ANSWER_ID`),
  KEY `FKCCEBFC4326552406` (`SURVEY_PAGE_ANSWER_ID`),
  KEY `FKCCEBFC43640A7A60` (`USER_ID`),
  KEY `FKCCEBFC432A8ECE85` (`SURVEY_QUESTION_ID`),
  KEY `FKCCEBFC43490EAB42` (`SURVEY_ID`),
  CONSTRAINT `FKCCEBFC4326552406` FOREIGN KEY (`SURVEY_PAGE_ANSWER_ID`) REFERENCES `survey_page_answer` (`SURVEY_PAGE_ANSWER_ID`),
  CONSTRAINT `FKCCEBFC432A8ECE85` FOREIGN KEY (`SURVEY_QUESTION_ID`) REFERENCES `survey_question` (`SURVEY_QUESTION_ID`),
  CONSTRAINT `FKCCEBFC43490EAB42` FOREIGN KEY (`SURVEY_ID`) REFERENCES `survey` (`SURVEY_ID`),
  CONSTRAINT `FKCCEBFC43640A7A60` FOREIGN KEY (`USER_ID`) REFERENCES `user` (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `survey_answer`
--

/*!40000 ALTER TABLE `survey_answer` DISABLE KEYS */;
/*!40000 ALTER TABLE `survey_answer` ENABLE KEYS */;


--
-- Definition of table `survey_answer_option`
--

DROP TABLE IF EXISTS `survey_answer_option`;
CREATE TABLE `survey_answer_option` (
  `SURVEY_ANSWER_ID` int(11) NOT NULL,
  `OPTION_ID` int(11) NOT NULL,
  KEY `FKE99CBBF1406A354C` (`OPTION_ID`),
  KEY `FKE99CBBF1C5577820` (`SURVEY_ANSWER_ID`),
  CONSTRAINT `FKE99CBBF1406A354C` FOREIGN KEY (`OPTION_ID`) REFERENCES `survey_question_option` (`SURVEY_QUESTION_OPTION_ID`),
  CONSTRAINT `FKE99CBBF1C5577820` FOREIGN KEY (`SURVEY_ANSWER_ID`) REFERENCES `survey_option_answer` (`SURVEY_ANSWER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `survey_answer_option`
--

/*!40000 ALTER TABLE `survey_answer_option` DISABLE KEYS */;
/*!40000 ALTER TABLE `survey_answer_option` ENABLE KEYS */;


--
-- Definition of table `survey_option_answer`
--

DROP TABLE IF EXISTS `survey_option_answer`;
CREATE TABLE `survey_option_answer` (
  `SURVEY_ANSWER_ID` int(11) NOT NULL,
  PRIMARY KEY  (`SURVEY_ANSWER_ID`),
  KEY `FK50323EA329B51ED5` (`SURVEY_ANSWER_ID`),
  CONSTRAINT `FK50323EA329B51ED5` FOREIGN KEY (`SURVEY_ANSWER_ID`) REFERENCES `survey_answer` (`SURVEY_ANSWER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `survey_option_answer`
--

/*!40000 ALTER TABLE `survey_option_answer` DISABLE KEYS */;
/*!40000 ALTER TABLE `survey_option_answer` ENABLE KEYS */;


--
-- Definition of table `survey_option_question`
--

DROP TABLE IF EXISTS `survey_option_question`;
CREATE TABLE `survey_option_question` (
  `SURVEY_QUESTION_ID` int(11) NOT NULL,
  `ORIENTATION` int(11) NOT NULL,
  `PRINT_ORDER` int(11) NOT NULL,
  `VALUE_FROM` int(11) default NULL,
  `VALUE_TO` int(11) default NULL,
  `QUESTION_TYPE` int(11) default NULL,
  PRIMARY KEY  (`SURVEY_QUESTION_ID`),
  KEY `FKE4E6118B2A8ECE85` (`SURVEY_QUESTION_ID`),
  CONSTRAINT `FKE4E6118B2A8ECE85` FOREIGN KEY (`SURVEY_QUESTION_ID`) REFERENCES `survey_question` (`SURVEY_QUESTION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `survey_option_question`
--

/*!40000 ALTER TABLE `survey_option_question` DISABLE KEYS */;
/*!40000 ALTER TABLE `survey_option_question` ENABLE KEYS */;


--
-- Definition of table `survey_page`
--

DROP TABLE IF EXISTS `survey_page`;
CREATE TABLE `survey_page` (
  `SURVEY_PAGE_ID` int(11) NOT NULL auto_increment,
  `PAGE_NO` int(11) default NULL,
  `TITLE` varchar(200) NOT NULL,
  `DESCRIPTION` text,
  `STATE` int(11) default NULL,
  `SURVEY_ID` int(11) NOT NULL,
  PRIMARY KEY  (`SURVEY_PAGE_ID`),
  KEY `FKA5668054490EAB42` (`SURVEY_ID`),
  CONSTRAINT `FKA5668054490EAB42` FOREIGN KEY (`SURVEY_ID`) REFERENCES `survey` (`SURVEY_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `survey_page`
--

/*!40000 ALTER TABLE `survey_page` DISABLE KEYS */;
/*!40000 ALTER TABLE `survey_page` ENABLE KEYS */;


--
-- Definition of table `survey_page_answer`
--

DROP TABLE IF EXISTS `survey_page_answer`;
CREATE TABLE `survey_page_answer` (
  `SURVEY_PAGE_ANSWER_ID` int(11) NOT NULL auto_increment,
  `PAGE_NO` int(11) NOT NULL,
  `SURVEY_PAGE_ID` int(11) NOT NULL,
  `SURVEY_ANSWER_ID` int(11) NOT NULL,
  PRIMARY KEY  (`SURVEY_PAGE_ANSWER_ID`),
  KEY `FK5CF96A09E79A0979` (`SURVEY_PAGE_ID`),
  KEY `FK5CF96A09CB524ADB` (`SURVEY_ANSWER_ID`),
  CONSTRAINT `FK5CF96A09CB524ADB` FOREIGN KEY (`SURVEY_ANSWER_ID`) REFERENCES `survey_answer` (`SURVEY_ANSWER_ID`),
  CONSTRAINT `FK5CF96A09E79A0979` FOREIGN KEY (`SURVEY_PAGE_ID`) REFERENCES `survey_page` (`SURVEY_PAGE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `survey_page_answer`
--

/*!40000 ALTER TABLE `survey_page_answer` DISABLE KEYS */;
/*!40000 ALTER TABLE `survey_page_answer` ENABLE KEYS */;


--
-- Definition of table `survey_question`
--

DROP TABLE IF EXISTS `survey_question`;
CREATE TABLE `survey_question` (
  `SURVEY_QUESTION_ID` int(11) NOT NULL auto_increment,
  `QUESTION_CODE` varchar(20) NOT NULL,
  `QUESTION_TEXT` text NOT NULL,
  `DESCRIPTION` text,
  `STATE` int(11) default NULL,
  `MANDATORY_FLG` bit(1) NOT NULL,
  `DISPLAY_ORDER` int(11) NOT NULL,
  `SURVEY_PAGE_ID` int(11) NOT NULL,
  PRIMARY KEY  (`SURVEY_QUESTION_ID`),
  KEY `FK1A26E72BE79A0979` (`SURVEY_PAGE_ID`),
  CONSTRAINT `FK1A26E72BE79A0979` FOREIGN KEY (`SURVEY_PAGE_ID`) REFERENCES `survey_page` (`SURVEY_PAGE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `survey_question`
--

/*!40000 ALTER TABLE `survey_question` DISABLE KEYS */;
/*!40000 ALTER TABLE `survey_question` ENABLE KEYS */;


--
-- Definition of table `survey_question_option`
--

DROP TABLE IF EXISTS `survey_question_option`;
CREATE TABLE `survey_question_option` (
  `SURVEY_QUESTION_OPTION_ID` int(11) NOT NULL auto_increment,
  `OPTION_CODE` varchar(30) NOT NULL,
  `OPTION_NAME` text NOT NULL,
  `OPTION_VALUE` float NOT NULL,
  `DISPLAY_ORDER` int(11) NOT NULL,
  `SURVEY_QUESTION_ID` int(11) default NULL,
  PRIMARY KEY  (`SURVEY_QUESTION_OPTION_ID`),
  KEY `FK1E373C0967000110` (`SURVEY_QUESTION_ID`),
  CONSTRAINT `FK1E373C0967000110` FOREIGN KEY (`SURVEY_QUESTION_ID`) REFERENCES `survey_option_question` (`SURVEY_QUESTION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `survey_question_option`
--

/*!40000 ALTER TABLE `survey_question_option` DISABLE KEYS */;
/*!40000 ALTER TABLE `survey_question_option` ENABLE KEYS */;


--
-- Definition of table `survey_text_answer`
--

DROP TABLE IF EXISTS `survey_text_answer`;
CREATE TABLE `survey_text_answer` (
  `SURVEY_ANSWER_ID` int(11) NOT NULL,
  `TEXT_VALUE` varchar(255) NOT NULL,
  PRIMARY KEY  (`SURVEY_ANSWER_ID`),
  KEY `FK706EF9AB29B51ED5` (`SURVEY_ANSWER_ID`),
  CONSTRAINT `FK706EF9AB29B51ED5` FOREIGN KEY (`SURVEY_ANSWER_ID`) REFERENCES `survey_answer` (`SURVEY_ANSWER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `survey_text_answer`
--

/*!40000 ALTER TABLE `survey_text_answer` DISABLE KEYS */;
/*!40000 ALTER TABLE `survey_text_answer` ENABLE KEYS */;


--
-- Definition of table `survey_text_question`
--

DROP TABLE IF EXISTS `survey_text_question`;
CREATE TABLE `survey_text_question` (
  `SURVEY_QUESTION_ID` int(11) NOT NULL,
  `MULTILINE_FLG` bit(1) NOT NULL,
  `CHARS_LIMIT` int(11) default NULL,
  `DEFAULT_TEXT` varchar(100) default NULL,
  `RESTRICTION` varchar(20) default NULL,
  `QUESTION_TYPE` int(11) default NULL,
  PRIMARY KEY  (`SURVEY_QUESTION_ID`),
  KEY `FKE8E02A932A8ECE85` (`SURVEY_QUESTION_ID`),
  CONSTRAINT `FKE8E02A932A8ECE85` FOREIGN KEY (`SURVEY_QUESTION_ID`) REFERENCES `survey_question` (`SURVEY_QUESTION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `survey_text_question`
--

/*!40000 ALTER TABLE `survey_text_question` DISABLE KEYS */;
/*!40000 ALTER TABLE `survey_text_question` ENABLE KEYS */;


--
-- Definition of table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `USER_ID` int(11) NOT NULL auto_increment,
  `USER_NAME` varchar(30) NOT NULL,
  `PASSWORD` varchar(30) NOT NULL,
  `FULL_NAME` varchar(200) NOT NULL,
  `EMAIL` varchar(100) default NULL,
  `DELETE_FLG` bit(1) default NULL,
  `ROLE_ID` int(11) NOT NULL,
  PRIMARY KEY  (`USER_ID`),
  KEY `FK27E3CB19B7C94A` (`ROLE_ID`),
  CONSTRAINT `FK27E3CB19B7C94A` FOREIGN KEY (`ROLE_ID`) REFERENCES `role` (`ROLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`USER_ID`,`USER_NAME`,`PASSWORD`,`FULL_NAME`,`EMAIL`,`DELETE_FLG`,`ROLE_ID`) VALUES 
 (1,'John','jon','john','jon@gmail.com',0x00,2),
 (2,'tom','tom','Tom','tom@gmail.com',0x00,1),
 (3,'harry','harry','harry','harry@gmail.com',0x00,3);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
