CREATE DATABASE `survey` /*!40100 DEFAULT CHARACTER SET latin1 */;

DROP TABLE IF EXISTS `survey`.`function`;
CREATE TABLE  `survey`.`function` (
  `FUNCTION_ID` int(11) NOT NULL auto_increment,
  `FUNCTION_CODE` varchar(20) NOT NULL,
  `FUNCTION_NAME` varchar(50) default NULL,
  `DESCRIPTION` text,
  `DISPLAY_ORDER` int(11) default NULL,
  PRIMARY KEY  (`FUNCTION_ID`),
  UNIQUE KEY `FUNCTION_CODE` (`FUNCTION_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `survey`.`role`;
CREATE TABLE  `survey`.`role` (
  `ROLE_ID` int(11) NOT NULL auto_increment,
  `ROLE_NAME` varchar(50) NOT NULL,
  `DESCRIPTION` varchar(200) default NULL,
  PRIMARY KEY  (`ROLE_ID`),
  UNIQUE KEY `ROLE_NAME` (`ROLE_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `survey`.`role_function`;
CREATE TABLE  `survey`.`role_function` (
  `ROLE_ID` int(11) NOT NULL,
  `FUNCTION_ID` int(11) NOT NULL,
  KEY `FK57D5418119B7C94A` (`ROLE_ID`),
  KEY `FK57D5418112F3D586` (`FUNCTION_ID`),
  CONSTRAINT `FK57D5418112F3D586` FOREIGN KEY (`FUNCTION_ID`) REFERENCES `function` (`FUNCTION_ID`),
  CONSTRAINT `FK57D5418119B7C94A` FOREIGN KEY (`ROLE_ID`) REFERENCES `role` (`ROLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `survey`.`user`;
CREATE TABLE  `survey`.`user` (
  `USER_ID` int(11) NOT NULL auto_increment,
  `USER_NAME` varchar(30) NOT NULL,
  `PASSWORD` varchar(30) NOT NULL,
  `FULL_NAME` varchar(200) NOT NULL,
  `EMAIL` varchar(100) default NULL,
  `DELETE_FLG` bit(1) default NULL,
  `ROLE_ID` int(11) NOT NULL,
  PRIMARY KEY  (`USER_ID`),
  UNIQUE KEY `ROLE_ID` (`ROLE_ID`),
  KEY `FK27E3CB19B7C94A` (`ROLE_ID`),
  CONSTRAINT `FK27E3CB19B7C94A` FOREIGN KEY (`ROLE_ID`) REFERENCES `role` (`ROLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `survey`.`survey`;
CREATE TABLE  `survey`.`survey` (
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

DROP TABLE IF EXISTS `survey`.`survey_page`;
CREATE TABLE  `survey`.`survey_page` (
  `SURVEY_PAGE_ID` int(11) NOT NULL auto_increment,
  `PAGE_NO` int(11) default NULL,
  `TITLE` varchar(200) NOT NULL,
  `DESCRIPTION` text,
  `STATE` int(11) default NULL,
  `SURVEY_ID` int(11) default NULL,
  PRIMARY KEY  (`SURVEY_PAGE_ID`),
  KEY `FKA5668054490EAB42` (`SURVEY_ID`),
  CONSTRAINT `FKA5668054490EAB42` FOREIGN KEY (`SURVEY_ID`) REFERENCES `survey` (`SURVEY_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `survey`.`survey_question`;
CREATE TABLE  `survey`.`survey_question` (
  `SURVEY_QUESTION_ID` int(11) NOT NULL auto_increment,
  `QUESTION_CODE` varchar(20) NOT NULL,
  `QUESTION_TEXT` text NOT NULL,
  `DESCRIPTION` text,
  `STATE` int(11) default NULL,
  `MANDATORY_FLG` bit(1) NOT NULL,
  `DISPLAY_ORDER` int(11) NOT NULL,
  `SURVEY_PAGE_ID` int(11) default NULL,
  PRIMARY KEY  (`SURVEY_QUESTION_ID`),
  KEY `FK1A26E72BE79A0979` (`SURVEY_PAGE_ID`),
  CONSTRAINT `FK1A26E72BE79A0979` FOREIGN KEY (`SURVEY_PAGE_ID`) REFERENCES `survey_page` (`SURVEY_PAGE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `survey`.`survey_number_question`;
CREATE TABLE  `survey`.`survey_number_question` (
  `SURVEY_QUESTION_ID` int(11) NOT NULL,
  `CHARS_LIMIT` int(11) default NULL,
  `DEFAULT_TEXT` varchar(100) default NULL,
  PRIMARY KEY  (`SURVEY_QUESTION_ID`),
  KEY `FK3925AD372A8ECE85` (`SURVEY_QUESTION_ID`),
  CONSTRAINT `FK3925AD372A8ECE85` FOREIGN KEY (`SURVEY_QUESTION_ID`) REFERENCES `survey_question` (`SURVEY_QUESTION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `survey`.`survey_option_question`;
CREATE TABLE  `survey`.`survey_option_question` (
  `SURVEY_QUESTION_ID` int(11) NOT NULL,
  `MULTIPLE_FLG` bit(1) NOT NULL,
  `ORIENTATION` int(11) NOT NULL,
  `PRINT_ORDER` int(11) NOT NULL,
  PRIMARY KEY  (`SURVEY_QUESTION_ID`),
  KEY `FKE4E6118B2A8ECE85` (`SURVEY_QUESTION_ID`),
  CONSTRAINT `FKE4E6118B2A8ECE85` FOREIGN KEY (`SURVEY_QUESTION_ID`) REFERENCES `survey_question` (`SURVEY_QUESTION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `survey`.`survey_rating_question`;
CREATE TABLE  `survey`.`survey_rating_question` (
  `SURVEY_QUESTION_ID` int(11) NOT NULL,
  `ORIENTATION` int(11) NOT NULL,
  `VALUE_FROM` int(11) NOT NULL,
  `VALUE_TO` int(11) NOT NULL,
  PRIMARY KEY  (`SURVEY_QUESTION_ID`),
  KEY `FK7392B5632A8ECE85` (`SURVEY_QUESTION_ID`),
  CONSTRAINT `FK7392B5632A8ECE85` FOREIGN KEY (`SURVEY_QUESTION_ID`) REFERENCES `survey_question` (`SURVEY_QUESTION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `survey`.`survey_text_question`;
CREATE TABLE  `survey`.`survey_text_question` (
  `SURVEY_QUESTION_ID` int(11) NOT NULL,
  `MULTILINE_FLG` bit(1) NOT NULL,
  `CHARS_LIMIT` int(11) default NULL,
  `DEFAULT_TEXT` varchar(100) default NULL,
  `RESTRICTION` varchar(20) default NULL,
  PRIMARY KEY  (`SURVEY_QUESTION_ID`),
  KEY `FKE8E02A932A8ECE85` (`SURVEY_QUESTION_ID`),
  CONSTRAINT `FKE8E02A932A8ECE85` FOREIGN KEY (`SURVEY_QUESTION_ID`) REFERENCES `survey_question` (`SURVEY_QUESTION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `survey`.`survey_question_option`;
CREATE TABLE  `survey`.`survey_question_option` (
  `SURVEY_QUESTION_OPTION_ID` int(11) NOT NULL auto_increment,
  `OPTION_CODE` varchar(30) NOT NULL,
  `OPTION_NAME` text NOT NULL,
  `OPTION_VALUE` int(11) NOT NULL,
  `DISPLAY_ORDER` int(11) NOT NULL,
  `SURVEY_QUESTION_ID` int(11) default NULL,
  PRIMARY KEY  (`SURVEY_QUESTION_OPTION_ID`),
  KEY `FK1E373C09FD130EE8` (`SURVEY_QUESTION_ID`),
  KEY `FK1E373C0967000110` (`SURVEY_QUESTION_ID`),
  CONSTRAINT `FK1E373C0967000110` FOREIGN KEY (`SURVEY_QUESTION_ID`) REFERENCES `survey_option_question` (`SURVEY_QUESTION_ID`),
  CONSTRAINT `FK1E373C09FD130EE8` FOREIGN KEY (`SURVEY_QUESTION_ID`) REFERENCES `survey_rating_question` (`SURVEY_QUESTION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;