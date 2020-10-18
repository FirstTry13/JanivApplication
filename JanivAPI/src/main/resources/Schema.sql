CREATE TABLE `country` (
  `countryid` int NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`countryid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `district` (
  `districtid` int NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `stateid` int DEFAULT NULL,
  PRIMARY KEY (`districtid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `ledgermaster` (
  `ledgermasterid` int NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `descripation` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ledgermasterid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `ledgertransaction` (
  `transactionid` int NOT NULL,
  `ledgertypeid` int DEFAULT NULL,
  `ledgermasterid` int DEFAULT NULL,
  `projectid` int DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `amount` double DEFAULT NULL,
  `userid` int DEFAULT NULL,
  `paytype` int DEFAULT NULL,
  `chequeno` varchar(255) DEFAULT NULL,
  `paidby` varchar(100) DEFAULT NULL,
  `receiptnumber` varchar(100) DEFAULT NULL,
  `recipientname` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`transactionid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `location` (
  `locationid` int NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `districtid` int DEFAULT NULL,
  PRIMARY KEY (`locationid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `project` (
  `projectid` int NOT NULL,
  `name` varchar(200) DEFAULT NULL,
  `address` varchar(500) DEFAULT NULL,
  `locationid` int DEFAULT NULL,
  `districtid` int DEFAULT NULL,
  `stateid` int DEFAULT NULL,
  `countryid` int DEFAULT NULL,
  `creatdate` date DEFAULT NULL,
  `startdate` date DEFAULT NULL,
  `enddate` date DEFAULT NULL,
  PRIMARY KEY (`projectid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `state` (
  `stateid` int NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `countryid` int DEFAULT NULL,
  PRIMARY KEY (`stateid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `user` (
  `userid` int NOT NULL,
  `firstname` varchar(255) DEFAULT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` int DEFAULT NULL,
  `address` varchar(500) DEFAULT NULL,
  `locationid` int DEFAULT '0',
  `districtid` int DEFAULT '0',
  `stateid` int DEFAULT '0',
  `countryid` int DEFAULT '0',
  `alternateaddress` varchar(500) DEFAULT NULL,
  `alternatelocationid` int DEFAULT '0',
  `alternatedistrictid` int DEFAULT '0',
  `alternatestateid` int DEFAULT '0',
  `alternatecountryid` int DEFAULT '0',
  `birthdate` date DEFAULT NULL,
  `mobilenumber` bigint DEFAULT '0',
  `othercontactno` varchar(100) DEFAULT NULL,
  `emailid1` varchar(255) DEFAULT NULL,
  `emailid2` varchar(255) DEFAULT NULL,
  `profession` varchar(100) DEFAULT NULL,
  `companyname` varchar(100) DEFAULT NULL,
  `designation` varchar(100) DEFAULT NULL,
  `deletedate` date DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
