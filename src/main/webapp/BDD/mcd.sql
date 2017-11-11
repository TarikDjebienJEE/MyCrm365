-- La Base de donnée de CRM 365
-- A EXECUTER EN SCRIPT

DROP DATABASE `CRM365`;

CREATE DATABASE `CRM365`;

-- BEGIN SPRING SECURITY CONFIGURATION

-- La Table USERS pour le stockage des utilisateurs pour l'authentification
-- DO NOT MODIFY
CREATE TABLE `CRM365`.`USERS` (
  username VARCHAR(50) NOT NULL,
  password VARCHAR(45) NOT NULL,
  enabled BOOLEAN NOT NULL,
  CONSTRAINT users_pk PRIMARY KEY (`username`)
);

-- La Table AUTHORITIES pour le stockage des roles pour l'authentification
-- DO NOT MODIFY
CREATE TABLE `CRM365`.`AUTHORITIES` (
  username VARCHAR(50) NOT NULL, -- le login de l'utilisateur
  authority VARCHAR(45) NOT NULL, -- le role qui lui est associe
  KEY fk_authorities_users (`username`),
  CONSTRAINT fk_authorities_users
  	FOREIGN KEY (`username`) 
  	REFERENCES USERS(`username`) ON UPDATE CASCADE ON DELETE CASCADE
);

-- END SPRING SECURITY CONFIGURATION

-- CRM 365 Model conceptuel de donnees

-- Customer
-- Table de stockage d'informations sur un client
CREATE TABLE `CRM365`.`CUSTOMER` (   
 customerId BIGINT NOT NULL AUTO_INCREMENT,   
 customerCompagnyId BIGINT NOT NULL,
 subscriptionDate DATE NOT NULL,
 firstName VARCHAR(45) NOT NULL,
 lastName VARCHAR(45) NOT NULL,
 address VARCHAR(100),
 homePhone VARCHAR(20),
 mobilePhone VARCHAR(20),
 workPhone VARCHAR(20),
 mail VARCHAR(100) NOT NULL,
 CONSTRAINT customers_pk PRIMARY KEY (`customerId`)
);

-- Modification de la table Customer pour pouvoir permettre
-- la personnalisation des clients generiquement a une entreprise
ALTER TABLE `CRM365`.`CUSTOMER`
ADD freeVal1 VARCHAR(80),
ADD freeVal2 VARCHAR(80),
ADD freeVal3 VARCHAR(80),
ADD freeVal4 VARCHAR(80),
ADD freeVal5 VARCHAR(80),
ADD freeVal6 VARCHAR(80),
ADD freeVal7 VARCHAR(80),
ADD freeVal8 VARCHAR(80),
ADD freeVal9 VARCHAR(80),
ADD freeVal10 VARCHAR(80),
ADD freeVal11 VARCHAR(80),
ADD freeVal12 VARCHAR(80),
ADD freeVal13 VARCHAR(80),
ADD freeVal14 VARCHAR(80),
ADD freeVal15 VARCHAR(80),
ADD freeVal16 VARCHAR(80),
ADD freeVal17 VARCHAR(80),
ADD freeVal18 VARCHAR(80),
ADD freeVal19 VARCHAR(80),
ADD freeVal20 VARCHAR(80),
ADD freeVal21 VARCHAR(80),
ADD freeVal22 VARCHAR(80),
ADD freeVal23 VARCHAR(80),
ADD freeVal24 VARCHAR(80),
ADD freeVal25 VARCHAR(80),
ADD freeVal26 VARCHAR(80),
ADD freeVal27 VARCHAR(80),
ADD freeVal28 VARCHAR(80),
ADD freeVal29 VARCHAR(80),
ADD freeVal30 VARCHAR(80),
ADD freeVal31 VARCHAR(80),
ADD freeVal32 VARCHAR(80),
ADD freeVal33 VARCHAR(80),
ADD freeVal34 VARCHAR(80),
ADD freeVal35 VARCHAR(80),
ADD freeVal36 VARCHAR(80),
ADD freeVal37 VARCHAR(80),
ADD freeVal38 VARCHAR(80),
ADD freeVal39 VARCHAR(80),
ADD freeVal40 VARCHAR(80),
ADD freeVal41 VARCHAR(80),
ADD freeVal42 VARCHAR(80),
ADD freeVal43 VARCHAR(80),
ADD freeVal44 VARCHAR(80),
ADD freeVal45 VARCHAR(80),
ADD freeVal46 VARCHAR(80),
ADD freeVal47 VARCHAR(80),
ADD freeVal48 VARCHAR(80),
ADD freeVal49 VARCHAR(80),
ADD freeVal50 VARCHAR(80);



-- Table Customer_Alias
CREATE TABLE `CRM365`.`CUSTOMER_ALIAS`(
  `idCustomerAlias` bigint(20) NOT NULL AUTO_INCREMENT,
  `freeValName` varchar(80) NOT NULL,
  `freeValAlias` varchar(100) NOT NULL,
  PRIMARY KEY (`idCustomerAlias`)
);



-- EventType
-- TODO role fonctionnel
CREATE TABLE `CRM365`.`EVENT_TYPE` (
  eventTypeId BIGINT NOT NULL AUTO_INCREMENT,   
  eventTypeName VARCHAR(50) NOT NULL,
  eventTypeDescription VARCHAR(100) NOT NULL,
 CONSTRAINT eventType_pk PRIMARY KEY (`eventTypeId`) 
);

-- Event
-- TODO role fonctionnel
CREATE TABLE `CRM365`.`EVENT` (   
  eventId BIGINT NOT NULL AUTO_INCREMENT,   
  eventDate DATE NULL,
  typeId BIGINT NOT NULL,
  customerId BIGINT NOT NULL,
  CONSTRAINT `fk_event_eventType` 
  	FOREIGN KEY (typeId) 
  	REFERENCES EVENT_TYPE(eventTypeId),
  CONSTRAINT `fk_event_customers` 
  	FOREIGN KEY (customerId) 
  	REFERENCES CUSTOMER(customerId),
  CONSTRAINT event_pk PRIMARY KEY (`eventId`) 
);

-- EventParameter
-- TODO role fonctionnel
CREATE TABLE `CRM365`.`EVENT_PARAMETER` (   
  eventParameterId BIGINT NOT NULL AUTO_INCREMENT,   
  eventParameterName VARCHAR(50) NULL,
  eventParameterDescription VARCHAR(100) NOT NULL,
  typeId BIGINT NOT NULL,
  CONSTRAINT `fk_eventParameter_eventType` 
  	FOREIGN KEY (typeId) 
  	REFERENCES EVENT_TYPE(eventTypeId),
  CONSTRAINT eventParameter_pk PRIMARY KEY (`eventParameterId`) 
);

-- EventParameterValue
-- TODO role fonctionnel
CREATE TABLE `CRM365`.`EVENT_PARAMETER_VALUE` (
  eventParameterValueId BIGINT NOT NULL AUTO_INCREMENT,
  eventId BIGINT NOT NULL,   
  eventParameterId BIGINT NOT NULL,
  valueParameter VARCHAR(50) NOT NULL,
  CONSTRAINT `fk_eventParameterValue_event` 
  	FOREIGN KEY (eventId) 
  	REFERENCES EVENT(eventId),
  CONSTRAINT `fk_eventParameterValue_eventParameter` 
  	FOREIGN KEY (eventParameterId) 
  	REFERENCES EVENT_PARAMETER(eventParameterId),
  CONSTRAINT eventParameterValue_pk PRIMARY KEY (`eventParameterValueId`) 
);

CREATE TABLE `CRM365`.`TEAM` (
  teamId BIGINT NOT NULL  AUTO_INCREMENT,
  teamDescription VARCHAR(45) NOT NULL,
  CONSTRAINT team_pk PRIMARY KEY (`teamId`) 
);

CREATE TABLE `CRM365`.`USER_TEAM` (
  userTeamId BIGINT AUTO_INCREMENT,
  username VARCHAR(50),
  teamId BIGINT,
  CONSTRAINT users_team_pk PRIMARY KEY (`userTeamId`),
  CONSTRAINT fk_user_team_user
  	FOREIGN KEY (`username`) 
  	REFERENCES USERS(`username`) ON UPDATE CASCADE ON DELETE CASCADE,
  CONSTRAINT fk_user_team_team
  	FOREIGN KEY (`teamId`) 
  	REFERENCES TEAM(`teamId`) ON UPDATE CASCADE ON DELETE CASCADE
);

-- Action
CREATE TABLE `CRM365`.`ACTION` (
	actionId BIGINT NOT NULL  AUTO_INCREMENT,
	actionDescription VARCHAR(100),
	teamId BIGINT,
	CONSTRAINT action_pk PRIMARY KEY (`actionId`),
	CONSTRAINT `fk_action_team` 
  		FOREIGN KEY (teamId) 
  		REFERENCES TEAM(teamId)
);

-- ActionTrigger
CREATE TABLE `CRM365`.`ACTION_TRIGGER` (
    actionTriggerId BIGINT NOT NULL AUTO_INCREMENT,
	actionId BIGINT NOT NULL,
	eventParameterId BIGINT DEFAULT 1,
	eventParameterClause VARCHAR(50),
	eventParameterTrigger VARCHAR(50),
  CONSTRAINT `fk_eventParameter_event` 
  	FOREIGN KEY (eventParameterId) 
  	REFERENCES EVENT_PARAMETER(eventParameterId),
  CONSTRAINT `fk_action` 
  	FOREIGN KEY (actionId) 
  	REFERENCES ACTION(actionId),
  CONSTRAINT actionTrigger_pk PRIMARY KEY (`actionTriggerId`)
);


-- CustomerTrigger
CREATE TABLE `CRM365`.`CUSTOMER_TRIGGER` (
    customerTriggerId BIGINT NOT NULL AUTO_INCREMENT,
	actionId BIGINT NOT NULL,
	customerColumn VARCHAR(100) NOT NULL,
	clause VARCHAR(50),
	customerTrigger VARCHAR(50),
  CONSTRAINT `fk_customerTrigger_action` 
  	FOREIGN KEY (actionId) 
  	REFERENCES ACTION(actionId),
  CONSTRAINT customerTrigger_pk PRIMARY KEY (`customerTriggerId`)
);


-- Value triggered
CREATE TABLE `CRM365`.`VALUE_TRIGGERED` (
	valueTriggeredId BIGINT NOT NULL  AUTO_INCREMENT,
	actionTriggerId  BIGINT NOT NULL,
	eventParameterValueId BIGINT NOT NULL,
	flaggedDate 	 DATE,
  CONSTRAINT value_triggered_pk PRIMARY KEY (`valueTriggeredId`),
  CONSTRAINT `fk_action_trigger` 
  	FOREIGN KEY (actionTriggerId) 
  	REFERENCES ACTION_TRIGGER(actionTriggerId),
  CONSTRAINT `fk_event_parameter_value` 
  	FOREIGN KEY (eventParameterValueId) 
  	REFERENCES EVENT_PARAMETER_VALUE(eventParameterValueId)
);

-- Task
CREATE TABLE `CRM365`.`TASK` (
	taskId BIGINT NOT NULL  AUTO_INCREMENT,
	creationDate DATE DEFAULT '1900-01-01',
	performedDate DATE,
	username VARCHAR(50),
	customerId BIGINT NOT NULL,
	actionId BIGINT NOT NULL,
  CONSTRAINT task_pk PRIMARY KEY (`taskId`),
  CONSTRAINT `fk_customer_event` 
  	FOREIGN KEY (customerId) 
  	REFERENCES CUSTOMER(customerId),
  CONSTRAINT `fk_action_event` 
  	FOREIGN KEY (actionId) 
  	REFERENCES ACTION(actionId),
  CONSTRAINT `fk_action_username` 
  	FOREIGN KEY (username) 
  	REFERENCES USERS(username) ON UPDATE CASCADE ON DELETE CASCADE
);