  -- Jeu de donnée de CRM 365 pour les tests
-- Configuration standard des valeurs par defaut :
-- 		libelle => 'default'
--		nombre  => -1
-- 		date    => '1900-01-01'
-- Attention à
-- 1/ Bien mettre les suppressions dans le drop-data.sql si besoin
-- 2/ Ajouter les nouveaux inserts à la suite de ceux présents par table car références aux clefs techniques (auto increment)


-- Users
INSERT INTO `CRM365`.`USERS` (username, password, enabled ) VALUES ('user', 'user', 1);
INSERT INTO `CRM365`.`USERS` (username, password, enabled ) VALUES ('admin', 'admin', 1);
INSERT INTO `CRM365`.`USERS` (username, password, enabled ) VALUES ('decidor', 'decidor', 1);
INSERT INTO `CRM365`.`USERS` (username, password, enabled ) VALUES ('test', 'test', 1);
INSERT INTO `CRM365`.`USERS` (username, password, enabled ) VALUES ('tarik', 'djebien', 1);
INSERT INTO `CRM365`.`USERS` (username, password, enabled ) VALUES ('antoine', 'craske', 1);
INSERT INTO `CRM365`.`USERS` (username, password, enabled ) VALUES ('eric', 'rakotobe', 0);
INSERT INTO `CRM365`.`USERS` (username, password, enabled ) VALUES ('rudy', 'stienne', 0);

INSERT INTO `CRM365`.`AUTHORITIES` (username, authority) VALUES ('user', 'ROLE_USER');
INSERT INTO `CRM365`.`AUTHORITIES` (username, authority) VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO `CRM365`.`AUTHORITIES` (username, authority) VALUES ('decidor', 'ROLE_DECIDOR');
INSERT INTO `CRM365`.`AUTHORITIES` (username, authority) VALUES ('test', 'ROLE_ADMIN');
INSERT INTO `CRM365`.`AUTHORITIES` (username, authority) VALUES ('tarik', 'ROLE_ADMIN');
INSERT INTO `CRM365`.`AUTHORITIES` (username, authority) VALUES ('antoine', 'ROLE_ADMIN');
INSERT INTO `CRM365`.`AUTHORITIES` (username, authority) VALUES ('eric', 'ROLE_USER');
INSERT INTO `CRM365`.`AUTHORITIES` (username, authority) VALUES ('rudy', 'ROLE_USER');

INSERT INTO `CRM365`.`TEAM`(teamDescription) VALUES ('test');
INSERT INTO `CRM365`.`TEAM`(teamDescription) VALUES ('marketing');
INSERT INTO `CRM365`.`TEAM`(teamDescription) VALUES ('developer');
INSERT INTO `CRM365`.`TEAM`(teamDescription) VALUES ('commercial');

INSERT INTO `CRM365`.`USER_TEAM`(username, teamId) VALUES ('user',1);
INSERT INTO `CRM365`.`USER_TEAM`(username, teamId) VALUES ('admin',3);
INSERT INTO `CRM365`.`USER_TEAM`(username, teamId) VALUES ('decidor',2);
INSERT INTO `CRM365`.`USER_TEAM`(username, teamId) VALUES ('decidor',4);
INSERT INTO `CRM365`.`USER_TEAM`(username, teamId) VALUES ('test',1);
INSERT INTO `CRM365`.`USER_TEAM`(username, teamId) VALUES ('test',2);
INSERT INTO `CRM365`.`USER_TEAM`(username, teamId) VALUES ('test',3);
INSERT INTO `CRM365`.`USER_TEAM`(username, teamId) VALUES ('test',4);
INSERT INTO `CRM365`.`USER_TEAM`(username, teamId) VALUES ('tarik',3);
INSERT INTO `CRM365`.`USER_TEAM`(username, teamId) VALUES ('antoine',2);
INSERT INTO `CRM365`.`USER_TEAM`(username, teamId) VALUES ('eric',1);
INSERT INTO `CRM365`.`USER_TEAM`(username, teamId) VALUES ('rudy',4);

-- Configuration
INSERT INTO `CRM365`.`CUSTOMER`(customerCompagnyId, subscriptionDate, firstName, lastName, mail) 
	VALUES('-1', '0001-01-01', 'default', 'default', 'default');
INSERT INTO `CRM365`.`CUSTOMER`(customerId, customerCompagnyId, subscriptionDate, firstName, lastName, address, homePhone, mobilePhone, workPhone, mail)
	VALUES ('100', '1000', '2012-03-14', 'customer', 'customer', NULL, NULL, NULL, NULL, 'customerTest@yahoo.fr');
INSERT INTO `CRM365`.`CUSTOMER`(customerCompagnyId, subscriptionDate, firstName, lastName, mail)
	VALUES('1234', '2012-01-01', 'firstNameCustomerService','lastNameCustomerService', 'test');

INSERT INTO `CRM365`.`EVENT_TYPE`(eventTypeName, eventTypeDescription) VALUES('default', 'default');
INSERT INTO `CRM365`.`EVENT_PARAMETER`(eventParameterName, eventParameterDescription, typeId) VALUES('default', 'default', 1);

INSERT INTO `CRM365`.`EVENT_TYPE`(eventTypeName, eventTypeDescription) VALUES('default1', 'default');
INSERT INTO `CRM365`.`EVENT_PARAMETER`(eventParameterName, eventParameterDescription, typeId) VALUES('default', 'default', 2);

INSERT INTO `CRM365`.`EVENT_TYPE`(eventTypeName, eventTypeDescription) VALUES('default2', 'default');
INSERT INTO `CRM365`.`EVENT_PARAMETER`(eventParameterName, eventParameterDescription, typeId) VALUES('default', 'default', 3);

INSERT INTO `CRM365`.`EVENT_TYPE`(eventTypeName, eventTypeDescription) VALUES('default3', 'default');
INSERT INTO `CRM365`.`EVENT_PARAMETER`(eventParameterName, eventParameterDescription, typeId) VALUES('default', 'default', 4);

INSERT INTO `CRM365`.`EVENT_TYPE`(eventTypeName, eventTypeDescription) VALUES('default4', 'default');
INSERT INTO `CRM365`.`EVENT_PARAMETER`(eventParameterName, eventParameterDescription, typeId) VALUES('default', 'default', 5);

INSERT INTO `CRM365`.`EVENT_TYPE`(eventTypeName, eventTypeDescription) VALUES('default5', 'default');
INSERT INTO `CRM365`.`EVENT_PARAMETER`(eventParameterName, eventParameterDescription, typeId) VALUES('default', 'default', 6);

INSERT INTO `CRM365`.`EVENT_TYPE`(eventTypeName, eventTypeDescription) VALUES('default6', 'default');
INSERT INTO `CRM365`.`EVENT_PARAMETER`(eventParameterName, eventParameterDescription, typeId) VALUES('default', 'default', 7);
INSERT INTO `CRM365`.`EVENT_PARAMETER`(eventParameterName, eventParameterDescription, typeId) VALUES('default', 'default', 7);

INSERT INTO `CRM365`.`EVENT_TYPE`(eventTypeName, eventTypeDescription) VALUES('default7', 'default');

INSERT INTO `CRM365`.`EVENT_TYPE`(eventTypeName, eventTypeDescription) VALUES('default8', 'default');
INSERT INTO `CRM365`.`EVENT_PARAMETER`(eventParameterName, eventParameterDescription, typeId) VALUES('default', 'default', 9);

-- Necessaires pour le test avec les csv 
INSERT INTO `CRM365`.`EVENT_TYPE`(eventTypeId , eventTypeName, eventTypeDescription) VALUES(10 , 'MobilePurchase', 'default');
INSERT INTO `CRM365`.`EVENT_PARAMETER`(eventParameterName, eventParameterDescription, typeId) VALUES('Model', 'default', 10);
INSERT INTO `CRM365`.`EVENT_PARAMETER`(eventParameterName, eventParameterDescription, typeId) VALUES('Price', 'default', 10);

INSERT INTO `CRM365`.`EVENT_TYPE`(eventTypeName, eventTypeDescription) VALUES('AutreEventType', 'default');
INSERT INTO `CRM365`.`EVENT_PARAMETER`(eventParameterName, eventParameterDescription, typeId) VALUES('ParamAutreEventType', 'default', 11);

INSERT INTO `CRM365`.`EVENT_TYPE`(eventTypeName, eventTypeDescription) VALUES('customer trigger test', 'customer trigger test');
INSERT INTO `CRM365`.`EVENT_TYPE`(eventTypeName, eventTypeDescription) VALUES('customer trigger and action trigger', 'customer trigger and action trigger');
INSERT INTO `CRM365`.`EVENT_TYPE`(eventTypeName, eventTypeDescription) VALUES('customer trigger only 2', 'customer trigger only 2');


INSERT INTO `CRM365`.`ACTION`(actionDescription) VALUES('default');
INSERT INTO `CRM365`.`ACTION_TRIGGER`(actionId, eventParameterId, eventParameterClause, eventParameterTrigger) VALUES (1, 1, '=',  '100');

INSERT INTO `CRM365`.`ACTION`(actionDescription) VALUES('default');
INSERT INTO `CRM365`.`ACTION_TRIGGER`(actionId, eventParameterId, eventParameterClause, eventParameterTrigger) VALUES (2, 2, '=',  '100');

INSERT INTO `CRM365`.`ACTION`(actionDescription) VALUES('default');
INSERT INTO `CRM365`.`ACTION_TRIGGER`(actionId, eventParameterId, eventParameterClause, eventParameterTrigger) VALUES (3, 3, '>',  '10');

INSERT INTO `CRM365`.`ACTION`(actionDescription) VALUES('default');
INSERT INTO `CRM365`.`ACTION_TRIGGER`(actionId, eventParameterId, eventParameterClause, eventParameterTrigger) VALUES (4, 4, '>=',  '3');

INSERT INTO `CRM365`.`ACTION`(actionDescription) VALUES('default');
INSERT INTO `CRM365`.`ACTION_TRIGGER`(actionId, eventParameterId, eventParameterClause, eventParameterTrigger) VALUES (5, 5, '<',  '2');

INSERT INTO `CRM365`.`ACTION`(actionDescription) VALUES('default');
INSERT INTO `CRM365`.`ACTION_TRIGGER`(actionId, eventParameterId, eventParameterClause, eventParameterTrigger) VALUES (6, 6, '<=',  '2');

INSERT INTO `CRM365`.`ACTION`(actionDescription) VALUES('default');
INSERT INTO `CRM365`.`ACTION_TRIGGER`(actionId, eventParameterId, eventParameterClause, eventParameterTrigger) VALUES (7, 7, '=',  '200');
INSERT INTO `CRM365`.`ACTION_TRIGGER`(actionId, eventParameterId, eventParameterClause, eventParameterTrigger) VALUES (7, 8, '=',  '200');

INSERT INTO `CRM365`.`ACTION`(actionDescription) VALUES('default');
INSERT INTO `CRM365`.`ACTION_TRIGGER`(actionId, eventParameterId, eventParameterClause, eventParameterTrigger) VALUES (8, 1, '<',  '0');

INSERT INTO `CRM365`.`ACTION`(actionDescription) VALUES('default');
INSERT INTO `CRM365`.`ACTION_TRIGGER`(actionId, eventParameterId, eventParameterClause, eventParameterTrigger) VALUES (9, 4, '<',  '10');

INSERT INTO `CRM365`.`ACTION`(actionDescription) VALUES('default');
INSERT INTO `CRM365`.`ACTION_TRIGGER`(actionId, eventParameterId, eventParameterClause, eventParameterTrigger) VALUES (10, 9, '=',  'stringValue');

-- Customer Trigger
INSERT INTO `CRM365`.`ACTION`(actionDescription) VALUES('customer trigger test');
INSERT INTO `CRM365`.`CUSTOMER_TRIGGER`(actionId, customerColumn, clause, customerTrigger) VALUES (11, 'customerId', '=',  '1');

INSERT INTO `CRM365`.`ACTION`(actionDescription) VALUES('customer trigger and action trigger');
INSERT INTO `CRM365`.`CUSTOMER_TRIGGER`(actionId, customerColumn, clause, customerTrigger) VALUES (12, 'customerId', '=',  '2');
INSERT INTO `CRM365`.`ACTION_TRIGGER`(actionId, eventParameterId, eventParameterClause, eventParameterTrigger) VALUES (12, 9, '=',  'stringValue');

INSERT INTO `CRM365`.`ACTION`(actionDescription) VALUES('customer trigger only 2');
INSERT INTO `CRM365`.`CUSTOMER_TRIGGER`(actionId, customerColumn, clause, customerTrigger) VALUES (13, 'customerId', '=',  '1');


INSERT INTO `CRM365`.`EVENT`(customerId, eventDate, typeId) VALUES(1, '1900-01-01', 1);
INSERT INTO `CRM365`.`EVENT_PARAMETER_VALUE`(eventId, eventParameterId, valueParameter) VALUES(1, 1, '100');

INSERT INTO `CRM365`.`EVENT`(customerId, eventDate, typeId) VALUES(1, '1900-01-01', 2);
INSERT INTO `CRM365`.`EVENT_PARAMETER_VALUE`(eventId, eventParameterId, valueParameter) VALUES(2, 2, '100');

INSERT INTO `CRM365`.`EVENT`(customerId, eventDate, typeId) VALUES(1, '1900-01-01', 3);
INSERT INTO `CRM365`.`EVENT_PARAMETER_VALUE`(eventId, eventParameterId, valueParameter) VALUES(3, 3, '11');

INSERT INTO `CRM365`.`EVENT`(customerId, eventDate, typeId) VALUES(1, '1900-01-01', 4);
INSERT INTO `CRM365`.`EVENT_PARAMETER_VALUE`(eventId, eventParameterId, valueParameter) VALUES(4, 4, '4');

INSERT INTO `CRM365`.`EVENT`(customerId, eventDate, typeId) VALUES(1, '1900-01-01', 5);
INSERT INTO `CRM365`.`EVENT_PARAMETER_VALUE`(eventId, eventParameterId, valueParameter) VALUES(5, 5, '1');

INSERT INTO `CRM365`.`EVENT`(customerId, eventDate, typeId) VALUES(1, '1900-01-01', 6);
INSERT INTO `CRM365`.`EVENT_PARAMETER_VALUE`(eventId, eventParameterId, valueParameter) VALUES(6, 6, '2');

INSERT INTO `CRM365`.`EVENT`(customerId, eventDate, typeId) VALUES(1, '1900-01-01', 7);
INSERT INTO `CRM365`.`EVENT_PARAMETER_VALUE`(eventId, eventParameterId, valueParameter) VALUES(7, 7, '200');
INSERT INTO `CRM365`.`EVENT_PARAMETER_VALUE`(eventId, eventParameterId, valueParameter) VALUES(7, 8, '200');

INSERT INTO `CRM365`.`EVENT`(customerId, eventDate, typeId) VALUES(1, '1900-01-01', 6);
INSERT INTO `CRM365`.`EVENT_PARAMETER_VALUE`(eventId, eventParameterId, valueParameter) VALUES(8, 9, 'stringValue');

INSERT INTO `CRM365`.`EVENT`(customerId, eventDate, typeId) VALUES(1, '2012-12-12', 10);

INSERT INTO `CRM365`.`TASK`(performedDate, customerId, actionId) VALUES('1900-01-01', 1, 1);
INSERT INTO `CRM365`.`TASK`(customerId, actionId) VALUES(1, 1);


-- FOR REPORTING
INSERT INTO `CRM365`.`EVENT`(customerId, eventDate, typeId) VALUES(1, CURDATE(), 6);
INSERT INTO `CRM365`.`EVENT_PARAMETER_VALUE`(eventId, eventParameterId, valueParameter) VALUES(8, 9, 'stringValue');

INSERT INTO `CRM365`.`EVENT`(customerId, eventDate, typeId) VALUES(1, DATE_SUB(CURDATE(),interval 2 day), 6);
INSERT INTO `CRM365`.`EVENT_PARAMETER_VALUE`(eventId, eventParameterId, valueParameter) VALUES(8, 9, 'stringValue');

INSERT INTO `CRM365`.`EVENT`(customerId, eventDate, typeId) VALUES(1, CURDATE(), 10);
INSERT INTO `CRM365`.`EVENT_PARAMETER_VALUE`(eventId, eventParameterId, valueParameter) VALUES(8, 9, 'stringValue');

INSERT INTO `CRM365`.`EVENT`(customerId, eventDate, typeId) VALUES(1, CURDATE(), 10);
INSERT INTO `CRM365`.`EVENT_PARAMETER_VALUE`(eventId, eventParameterId, valueParameter) VALUES(8, 9, 'stringValue');

INSERT INTO `CRM365`.`EVENT`(customerId, eventDate, typeId) VALUES(1, CURDATE(), 10);
INSERT INTO `CRM365`.`EVENT_PARAMETER_VALUE`(eventId, eventParameterId, valueParameter) VALUES(8, 9, 'stringValue');

INSERT INTO `CRM365`.`EVENT`(customerId, eventDate, typeId) VALUES(1, CURDATE(), 6);
INSERT INTO `CRM365`.`EVENT_PARAMETER_VALUE`(eventId, eventParameterId, valueParameter) VALUES(8, 9, 'stringValue');

INSERT INTO `CRM365`.`EVENT`(customerId, eventDate, typeId) VALUES(1, CURDATE(), 6);
INSERT INTO `CRM365`.`EVENT_PARAMETER_VALUE`(eventId, eventParameterId, valueParameter) VALUES(8, 9, 'stringValue');

INSERT INTO `CRM365`.`VALUE_TRIGGERED`(actionTriggerId, eventParameterValueId) VALUES (10, 9); 


-- POUR TESTS RENDU VISUEL
INSERT INTO  `CRM365`.`CUSTOMER_ALIAS` (`idCustomerAlias` ,`freeValName` ,`freeValAlias`) VALUES ('1',  'freeVal1',  'Profil de risque client');
INSERT INTO  `CRM365`.`CUSTOMER_ALIAS` (`idCustomerAlias` ,`freeValName` ,`freeValAlias`) VALUES ('2',  'freeVal2',  'Année d’ancienneté');
