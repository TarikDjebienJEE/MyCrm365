  -- Jeu de donnée de CRM 365 pour société GD Patrimoine

-- Users
INSERT INTO `CRM365`.`USERS` (username, password, enabled ) VALUES ('conseiller', 		'conseiller', 1);
INSERT INTO `CRM365`.`USERS` (username, password, enabled ) VALUES ('administrateur', 	'administrateur', 1);
INSERT INTO `CRM365`.`USERS` (username, password, enabled ) VALUES ('directeur', 		'directeur', 1);
INSERT INTO `CRM365`.`USERS` (username, password, enabled ) VALUES ('test', 			'test', 1);

INSERT INTO `CRM365`.`AUTHORITIES` (username, authority) VALUES ('conseiller', 		'ROLE_USER');
INSERT INTO `CRM365`.`AUTHORITIES` (username, authority) VALUES ('administrateur', 	'ROLE_USER');
INSERT INTO `CRM365`.`AUTHORITIES` (username, authority) VALUES ('administrateur', 	'ROLE_ADMIN');
INSERT INTO `CRM365`.`AUTHORITIES` (username, authority) VALUES ('directeur', 		'ROLE_USER');
INSERT INTO `CRM365`.`AUTHORITIES` (username, authority) VALUES ('directeur', 		'ROLE_DECIDOR');
INSERT INTO `CRM365`.`AUTHORITIES` (username, authority) VALUES ('test', 			'ROLE_USER');
INSERT INTO `CRM365`.`AUTHORITIES` (username, authority) VALUES ('test', 			'ROLE_DECIDOR');
INSERT INTO `CRM365`.`AUTHORITIES` (username, authority) VALUES ('test', 			'ROLE_ADMIN');

INSERT INTO `CRM365`.`TEAM`(teamDescription) VALUES ('conseillers');
INSERT INTO `CRM365`.`TEAM`(teamDescription) VALUES ('directeur');

-- Configuration
INSERT INTO `CRM365`.`CUSTOMER`(customerCompagnyId, subscriptionDate, firstName, lastName, address, homePhone, mobilePhone, workPhone, mail)
	VALUES ('1000', '2010-02-14', 'Jean', 'Lito', '100 Rue de Gand 59000 LILLE', '03.29.20.93.23', '06.29.20.93.23', NULL, 'jean.lito@gmail.com');
INSERT INTO `CRM365`.`CUSTOMER`(customerCompagnyId, subscriptionDate, firstName, lastName, address, homePhone, mobilePhone, workPhone, mail)
	VALUES ('1001', '2010-03-02', 'Martine', 'Casu', '9 Rue de Lille 59000 LILLE', '03.29.20.89.28', '06.29.21.93.23', NULL, 'martine.casu@gmail.com');
INSERT INTO `CRM365`.`CUSTOMER`(customerCompagnyId, subscriptionDate, firstName, lastName, address, homePhone, mobilePhone, workPhone, mail)
	VALUES ('1002', '2010-04-05', 'Johnathan', 'Micat', '24 Rue des arts 59100 ROUBAIX', '03.10.20.93.23', '06..1120.93.23', NULL, 'jonathan.micat@gmail.com');
INSERT INTO `CRM365`.`CUSTOMER`(customerCompagnyId, subscriptionDate, firstName, lastName, address, homePhone, mobilePhone, workPhone, mail)
	VALUES ('1003', '2011-03-04', 'Louis', 'Rato', '180 Rue de Gand 59000 LILLE', '03.29.90.93.23', '06.29.44.93.23', NULL, 'louis.rato@gmail.com');


INSERT INTO `CRM365`.`EVENT_TYPE`(eventTypeName, eventTypeDescription) VALUES('Placement immobilier', 'Placement sur bien immobilier');
INSERT INTO `CRM365`.`EVENT_PARAMETER`(eventParameterName, eventParameterDescription, typeId) VALUES('Montant', 'Montant du placement en euros', 1);
INSERT INTO `CRM365`.`EVENT_PARAMETER`(eventParameterName, eventParameterDescription, typeId) VALUES('Durée', 'Durée du placement en mois', 1);
INSERT INTO `CRM365`.`EVENT_PARAMETER`(eventParameterName, eventParameterDescription, typeId) VALUES('Rendement', 'Rendement en %', 1);
INSERT INTO `CRM365`.`EVENT_PARAMETER`(eventParameterName, eventParameterDescription, typeId) VALUES('Risque', 'Profil risque du placement 1-5', 1);
INSERT INTO `CRM365`.`EVENT_PARAMETER`(eventParameterName, eventParameterDescription, typeId) VALUES('Type placement', 'Immobilier, FCP, Action, Obligation, Société', 1);

INSERT INTO `CRM365`.`EVENT_TYPE`(eventTypeName, eventTypeDescription) VALUES('Placement FCP', 'Placement sur Fond Commun de Placement');
INSERT INTO `CRM365`.`EVENT_PARAMETER`(eventParameterName, eventParameterDescription, typeId) VALUES('Montant', 'Montant du placement en euros', 2);
INSERT INTO `CRM365`.`EVENT_PARAMETER`(eventParameterName, eventParameterDescription, typeId) VALUES('Durée', 'Durée du placement en mois', 2);
INSERT INTO `CRM365`.`EVENT_PARAMETER`(eventParameterName, eventParameterDescription, typeId) VALUES('Rendement', 'Rendement en %', 2);
INSERT INTO `CRM365`.`EVENT_PARAMETER`(eventParameterName, eventParameterDescription, typeId) VALUES('Risque', 'Profil risque du placement 1-5', 2);
INSERT INTO `CRM365`.`EVENT_PARAMETER`(eventParameterName, eventParameterDescription, typeId) VALUES('Type placement', 'Immobilier, FCP, Action, Obligation, Société', 2);

INSERT INTO `CRM365`.`EVENT_TYPE`(eventTypeName, eventTypeDescription) VALUES('Placement actions', 'Placement sur un portefeuille actions');
INSERT INTO `CRM365`.`EVENT_PARAMETER`(eventParameterName, eventParameterDescription, typeId) VALUES('Montant', 'Montant du placement en euros', 3);
INSERT INTO `CRM365`.`EVENT_PARAMETER`(eventParameterName, eventParameterDescription, typeId) VALUES('Durée', 'Durée du placement en mois', 3);
INSERT INTO `CRM365`.`EVENT_PARAMETER`(eventParameterName, eventParameterDescription, typeId) VALUES('Rendement', 'Rendement en %', 3);
INSERT INTO `CRM365`.`EVENT_PARAMETER`(eventParameterName, eventParameterDescription, typeId) VALUES('Risque', 'Profil risque du placement 1-5', 3);
INSERT INTO `CRM365`.`EVENT_PARAMETER`(eventParameterName, eventParameterDescription, typeId) VALUES('Type placement', 'Immobilier, FCP, Action, Obligation, Société', 3);

INSERT INTO `CRM365`.`EVENT_TYPE`(eventTypeName, eventTypeDescription) VALUES('Placement obligations', 'Placement sur obligations état');
INSERT INTO `CRM365`.`EVENT_PARAMETER`(eventParameterName, eventParameterDescription, typeId) VALUES('Montant', 'Montant du placement en euros', 4);
INSERT INTO `CRM365`.`EVENT_PARAMETER`(eventParameterName, eventParameterDescription, typeId) VALUES('Durée', 'Durée du placement en mois', 4);
INSERT INTO `CRM365`.`EVENT_PARAMETER`(eventParameterName, eventParameterDescription, typeId) VALUES('Rendement', 'Rendement en %', 4);
INSERT INTO `CRM365`.`EVENT_PARAMETER`(eventParameterName, eventParameterDescription, typeId) VALUES('Risque', 'Profil risque du placement 1-5', 4);
INSERT INTO `CRM365`.`EVENT_PARAMETER`(eventParameterName, eventParameterDescription, typeId) VALUES('Type placement', 'Immobilier, FCP, Action, Obligation, Société', 4);

INSERT INTO `CRM365`.`EVENT_TYPE`(eventTypeName, eventTypeDescription) VALUES('Placement société', 'Placement avec investissement capital société');
INSERT INTO `CRM365`.`EVENT_PARAMETER`(eventParameterName, eventParameterDescription, typeId) VALUES('Montant', 'Montant du placement en euros', 5);
INSERT INTO `CRM365`.`EVENT_PARAMETER`(eventParameterName, eventParameterDescription, typeId) VALUES('Durée', 'Durée du placement en mois', 5);
INSERT INTO `CRM365`.`EVENT_PARAMETER`(eventParameterName, eventParameterDescription, typeId) VALUES('Rendement', 'Rendement en %', 5);
INSERT INTO `CRM365`.`EVENT_PARAMETER`(eventParameterName, eventParameterDescription, typeId) VALUES('Risque', 'Profil risque du placement 1-5', 5);
INSERT INTO `CRM365`.`EVENT_PARAMETER`(eventParameterName, eventParameterDescription, typeId) VALUES('Type placement', 'Immobilier, FCP, Action, Obligation, Société', 5);

INSERT INTO `CRM365`.`EVENT_TYPE`(eventTypeName, eventTypeDescription) VALUES('Appel', 'Appel client');
INSERT INTO `CRM365`.`EVENT_PARAMETER`(eventParameterName, eventParameterDescription, typeId) VALUES('Type', 'Information, rendez-vous, mécontent', 1);

INSERT INTO `CRM365`.`EVENT_TYPE`(eventTypeName, eventTypeDescription) VALUES('Rendez-vous', 'Rendez-vous physique avec client');
INSERT INTO `CRM365`.`EVENT_PARAMETER`(eventParameterName, eventParameterDescription, typeId) VALUES('Type', 'Information, signature, mécontent', 1);

INSERT INTO `CRM365`.`EVENT_TYPE`(eventTypeName, eventTypeDescription) VALUES('Email', 'Email client');
INSERT INTO `CRM365`.`EVENT_PARAMETER`(eventParameterName, eventParameterDescription, typeId) VALUES('Type', 'Information, rendez-vous, mécontent', 1);

INSERT INTO `CRM365`.`EVENT_TYPE`(eventTypeName, eventTypeDescription) VALUES('Nouveau client', 'Arrivée nouveau client');
INSERT INTO `CRM365`.`EVENT_PARAMETER`(eventParameterName, eventParameterDescription, typeId) VALUES('Patrimoine investi', '% du patrimoine investi', 1);


INSERT INTO `CRM365`.`ACTION`(actionDescription, teamId) VALUES('RDV Placement supérieur plus risqué', 1);
INSERT INTO `CRM365`.`ACTION_TRIGGER`(actionId, eventParameterId, eventParameterClause, eventParameterTrigger) VALUES (1, 1, '>=',  '100000');
INSERT INTO `CRM365`.`ACTION_TRIGGER`(actionId, eventParameterId, eventParameterClause, eventParameterTrigger) VALUES (1, 3, '<',  	'5');
INSERT INTO `CRM365`.`ACTION_TRIGGER`(actionId, eventParameterId, eventParameterClause, eventParameterTrigger) VALUES (1, 4, '<=',  '3');
INSERT INTO `CRM365`.`ACTION_TRIGGER`(actionId, eventParameterId, eventParameterClause, eventParameterTrigger) VALUES (1, 5, '=',  	'Immobilier');

INSERT INTO `CRM365`.`ACTION`(actionDescription, teamId) VALUES('RDV Placement actions', 1);
INSERT INTO `CRM365`.`ACTION_TRIGGER`(actionId, eventParameterId, eventParameterClause, eventParameterTrigger) VALUES (2, 16, '>=',  '150000');
INSERT INTO `CRM365`.`ACTION_TRIGGER`(actionId, eventParameterId, eventParameterClause, eventParameterTrigger) VALUES (2, 18, '<',  	'4');
INSERT INTO `CRM365`.`ACTION_TRIGGER`(actionId, eventParameterId, eventParameterClause, eventParameterTrigger) VALUES (2, 19, '<=',  '3');
INSERT INTO `CRM365`.`ACTION_TRIGGER`(actionId, eventParameterId, eventParameterClause, eventParameterTrigger) VALUES (2, 20, '=',  	'Obligation');

INSERT INTO `CRM365`.`ACTION`(actionDescription, teamId) VALUES('RDV Directeur problème', 2);
INSERT INTO `CRM365`.`ACTION_TRIGGER`(actionId, eventParameterId, eventParameterClause, eventParameterTrigger) VALUES (3, 26, '=',  'mécontent');
INSERT INTO `CRM365`.`ACTION_TRIGGER`(actionId, eventParameterId, eventParameterClause, eventParameterTrigger) VALUES (3, 27, '=',  'mécontent');
INSERT INTO `CRM365`.`ACTION_TRIGGER`(actionId, eventParameterId, eventParameterClause, eventParameterTrigger) VALUES (3, 28, '=',  'mécontent');

INSERT INTO `CRM365`.`ACTION`(actionDescription, teamId) VALUES('RDV Conseiller', 1);
INSERT INTO `CRM365`.`ACTION_TRIGGER`(actionId, eventParameterId, eventParameterClause, eventParameterTrigger) VALUES (4, 26, '=',  'information');
INSERT INTO `CRM365`.`ACTION_TRIGGER`(actionId, eventParameterId, eventParameterClause, eventParameterTrigger) VALUES (4, 27, '=',  'information');
INSERT INTO `CRM365`.`ACTION_TRIGGER`(actionId, eventParameterId, eventParameterClause, eventParameterTrigger) VALUES (4, 28, '=',  'information');

INSERT INTO `CRM365`.`ACTION`(actionDescription, teamId) VALUES('RDV Nouveau placement immobilier', 1);
INSERT INTO `CRM365`.`ACTION_TRIGGER`(actionId, eventParameterId, eventParameterClause, eventParameterTrigger) VALUES (5, 29, '<',  '10');

INSERT INTO `CRM365`.`ACTION`(actionDescription, teamId) VALUES('RDV Nouveau placement obligation', 1);
INSERT INTO `CRM365`.`ACTION_TRIGGER`(actionId, eventParameterId, eventParameterClause, eventParameterTrigger) VALUES (6, 29, '<',  '10');

INSERT INTO `CRM365`.`ACTION`(actionDescription, teamId) VALUES('RDV Nouveau placement action / FCP', 1);
INSERT INTO `CRM365`.`ACTION_TRIGGER`(actionId, eventParameterId, eventParameterClause, eventParameterTrigger) VALUES (7, 29, '<',  '10');
