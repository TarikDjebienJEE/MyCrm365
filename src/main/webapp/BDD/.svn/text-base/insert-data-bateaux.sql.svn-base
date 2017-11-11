  -- Jeu de donnée de CRM 365 pour société Jeu d'entreprise

-- Users
INSERT INTO `CRM365`.`USERS` (username, password, enabled ) VALUES ('vendeur', 'vendeur', 1);
INSERT INTO `CRM365`.`USERS` (username, password, enabled ) VALUES ('admin', 'admin', 1);
INSERT INTO `CRM365`.`USERS` (username, password, enabled ) VALUES ('directeur', 'directeur', 1);

INSERT INTO `CRM365`.`AUTHORITIES` (username, authority) VALUES ('vendeur', 		'ROLE_USER');
INSERT INTO `CRM365`.`AUTHORITIES` (username, authority) VALUES ('admin', 	'ROLE_ADMIN');
INSERT INTO `CRM365`.`AUTHORITIES` (username, authority) VALUES ('directeur', 		'ROLE_DECIDOR');

INSERT INTO `CRM365`.`TEAM`(teamDescription) VALUES ('administration');
INSERT INTO `CRM365`.`TEAM`(teamDescription) VALUES ('direction');
INSERT INTO `CRM365`.`TEAM`(teamDescription) VALUES ('commerciaux');

-- Configuration
INSERT INTO `CRM365`.`CUSTOMER`(customerCompagnyId, subscriptionDate, firstName, lastName, address, homePhone, mobilePhone, workPhone, mail)
	VALUES ('1000', '2010-02-14', 'Jean', 'Lito', '100 Rue de Gand 59000 LILLE', '03.29.20.93.23', '06.29.20.93.23', NULL, 'jean.lito@gmail.com');
INSERT INTO `CRM365`.`CUSTOMER`(customerCompagnyId, subscriptionDate, firstName, lastName, address, homePhone, mobilePhone, workPhone, mail)
	VALUES ('1001', '2010-03-02', 'Martine', 'Casu', '9 Rue de Lille 59000 LILLE', '03.29.20.89.28', '06.29.21.93.23', NULL, 'martine.casu@gmail.com');
INSERT INTO `CRM365`.`CUSTOMER`(customerCompagnyId, subscriptionDate, firstName, lastName, address, homePhone, mobilePhone, workPhone, mail)
	VALUES ('1002', '2010-04-05', 'Johnathan', 'Micat', '24 Rue des arts 59100 ROUBAIX', '03.10.20.93.23', '06..1120.93.23', NULL, 'jonathan.micat@gmail.com');
INSERT INTO `CRM365`.`CUSTOMER`(customerCompagnyId, subscriptionDate, firstName, lastName, address, homePhone, mobilePhone, workPhone, mail)
	VALUES ('1003', '2011-03-04', 'Louis', 'Rato', '180 Rue de Gand 59000 LILLE', '03.29.90.93.23', '06.29.44.93.23', NULL, 'louis.rato@gmail.com');
INSERT INTO `CRM365`.`CUSTOMER`(customerCompagnyId, subscriptionDate, firstName, lastName, address, homePhone, mobilePhone, workPhone, mail)
	VALUES ('1004', '2011-03-04', 'John', 'Taso', '120 Rue de Gand 59000 LILLE', '03.29.90.93.23', '06.29.44.93.23', NULL, 'john.taso@gmail.com');
INSERT INTO `CRM365`.`CUSTOMER`(customerCompagnyId, subscriptionDate, firstName, lastName, address, homePhone, mobilePhone, workPhone, mail)
	VALUES ('1005', '2011-03-04', 'Antoine', 'Hugo', '130 Rue de Gand 59000 LILLE', '03.29.90.93.23', '06.29.44.93.23', NULL, 'antoine.hugo@gmail.com');
INSERT INTO `CRM365`.`CUSTOMER`(customerCompagnyId, subscriptionDate, firstName, lastName, address, homePhone, mobilePhone, workPhone, mail)
	VALUES ('1006', '2011-03-04', 'Eric', 'Razor', '150 Rue de Gand 59000 LILLE', '03.29.90.93.23', '06.29.44.93.23', NULL, 'eric.razor@gmail.com');
INSERT INTO `CRM365`.`CUSTOMER`(customerCompagnyId, subscriptionDate, firstName, lastName, address, homePhone, mobilePhone, workPhone, mail)
	VALUES ('1007', '2011-03-04', 'Rudy', 'Boss', '128 Rue de Gand 59000 LILLE', '03.29.90.93.23', '06.29.44.93.23', NULL, 'rudy.boss@gmail.com');
INSERT INTO `CRM365`.`CUSTOMER`(customerCompagnyId, subscriptionDate, firstName, lastName, address, homePhone, mobilePhone, workPhone, mail)
	VALUES ('1008', '2011-03-04', 'Benoit', 'Jean', '220 Rue de Gand 59000 LILLE', '03.29.90.93.23', '06.29.44.93.23', NULL, 'benoit.jean@gmail.com');
INSERT INTO `CRM365`.`CUSTOMER`(customerCompagnyId, subscriptionDate, firstName, lastName, address, homePhone, mobilePhone, workPhone, mail)
	VALUES ('1009', '2011-03-04', 'Brigitte', 'Robar', '121 Rue de Gand 59000 LILLE', '03.29.90.93.23', '06.29.44.93.23', NULL, 'brigitte.robar@gmail.com');
INSERT INTO `CRM365`.`CUSTOMER`(customerCompagnyId, subscriptionDate, firstName, lastName, address, homePhone, mobilePhone, workPhone, mail)
	VALUES ('1010', '2011-03-04', 'Gerard', 'Poli', '180 Rue de Gand 59000 LILLE', '03.29.90.93.23', '06.29.44.93.23', NULL, 'gerard.poli@gmail.com');

INSERT INTO `CRM365`.`EVENT_TYPE`(eventTypeName, eventTypeDescription) VALUES('Visite en magasin', 'Viste du client dans le magasin.');
INSERT INTO `CRM365`.`EVENT_PARAMETER`(eventParameterName, eventParameterDescription, typeId) VALUES('Montant achat', 'Montant des achats du client en euros', 1);
INSERT INTO `CRM365`.`EVENT_PARAMETER`(eventParameterName, eventParameterDescription, typeId) VALUES('Durée de visite', 'Durée de la visite en minutes', 1);
-- INSERT INTO `CRM365`.`EVENT_PARAMETER`(eventParameterName, eventParameterDescription, typeId) VALUES('Profil du client', 'Riche, aisé, promo, decouverte', 1);

INSERT INTO `CRM365`.`EVENT_TYPE`(eventTypeName, eventTypeDescription) VALUES('Achat bateaux','Achat de bateaux en magasin.');
INSERT INTO `CRM365`.`EVENT_PARAMETER`(eventParameterName, eventParameterDescription, typeId) VALUES('Montant facture', 'Montant de la facture en euros', 2);
INSERT INTO `CRM365`.`EVENT_PARAMETER`(eventParameterName, eventParameterDescription, typeId) VALUES('Type de bateau', 'Type du bateau A, B ou C', 2);
INSERT INTO `CRM365`.`EVENT_PARAMETER`(eventParameterName, eventParameterDescription, typeId) VALUES('Date achat bateau', 'Date de reglement de la facture', 2);

INSERT INTO `CRM365`.`EVENT_TYPE`(eventTypeName, eventTypeDescription) VALUES('Appel', 'Appel client');
INSERT INTO `CRM365`.`EVENT_PARAMETER`(eventParameterName, eventParameterDescription, typeId) VALUES('Objectif', 'Information, offre, rendez-vous, mécontent', 3);

INSERT INTO `CRM365`.`EVENT_TYPE`(eventTypeName, eventTypeDescription) VALUES('Rendez-vous', 'Rendez-vous physique avec client');
INSERT INTO `CRM365`.`EVENT_PARAMETER`(eventParameterName, eventParameterDescription, typeId) VALUES('But du rdv', 'Information, signature, mécontent', 4);

INSERT INTO `CRM365`.`EVENT_TYPE`(eventTypeName, eventTypeDescription) VALUES('Email', 'Email client');
INSERT INTO `CRM365`.`EVENT_PARAMETER`(eventParameterName, eventParameterDescription, typeId) VALUES('Objet email', 'Information, rendez-vous, cadeau, solde', 5);


INSERT INTO `CRM365`.`ACTION`(actionDescription, teamId) VALUES('Proposer bateau C version premium edition limitee', 2);
INSERT INTO `CRM365`.`EVENT_TYPE`(eventTypeName, eventTypeDescription) VALUES('Proposer bateau C version premium edition limitee', 'ACTION : Proposer bateau C version premium edition limitee');
INSERT INTO `CRM365`.`CUSTOMER_TRIGGER`(actionId, customerColumn, clause, customerTrigger) VALUES (1, 'freeVal1', '=',  'Riche');
INSERT INTO `CRM365`.`ACTION_TRIGGER`(actionId, eventParameterId, eventParameterClause, eventParameterTrigger) VALUES (1, 2, '>=',  '10');
INSERT INTO `CRM365`.`ACTION_TRIGGER`(actionId, eventParameterId, eventParameterClause, eventParameterTrigger) VALUES (1, 5, '=',  'A');

INSERT INTO `CRM365`.`ACTION`(actionDescription, teamId) VALUES('Ajouter brochure summer en piece jointe du mail', 3);
INSERT INTO `CRM365`.`EVENT_TYPE`(eventTypeName, eventTypeDescription) VALUES('Ajouter brochure summer en piece jointe du mail', 'ACTION : Ajouter brochure summer en piece jointe du mail');
INSERT INTO `CRM365`.`ACTION_TRIGGER`(actionId, eventParameterId, eventParameterClause, eventParameterTrigger) VALUES (2, 1, '=',  '0');
INSERT INTO `CRM365`.`ACTION_TRIGGER`(actionId, eventParameterId, eventParameterClause, eventParameterTrigger) VALUES (2, 2, '>',  	'15');
INSERT INTO `CRM365`.`CUSTOMER_TRIGGER`(actionId, customerColumn, clause, customerTrigger) VALUES (2, 'freeVal1', '=',  'Decouverte');

INSERT INTO `CRM365`.`ACTION`(actionDescription, teamId) VALUES('Nouveau bateau avec reprise ancien bateau', 3);
INSERT INTO `CRM365`.`EVENT_TYPE`(eventTypeName, eventTypeDescription) VALUES('Nouveau bateau avec reprise ancien bateau', 'ACTION : Nouveau bateau avec reprise ancien bateau');
INSERT INTO `CRM365`.`CUSTOMER_TRIGGER`(actionId, customerColumn, clause, customerTrigger) VALUES (3, 'freeVal1', '=',  'promo');
INSERT INTO `CRM365`.`ACTION_TRIGGER`(actionId, eventParameterId, eventParameterClause, eventParameterTrigger) VALUES (3, 4, '<=',  '5000');
INSERT INTO `CRM365`.`ACTION_TRIGGER`(actionId, eventParameterId, eventParameterClause, eventParameterTrigger) VALUES (3, 5, '=',  'B');

INSERT INTO `CRM365`.`EVENT`(customerId, eventDate, typeId) VALUES(1, '2012-06-24', 1);
INSERT INTO `CRM365`.`EVENT_PARAMETER_VALUE`(eventId, eventParameterId, valueParameter) VALUES(1, 1, '4000');
INSERT INTO `CRM365`.`EVENT_PARAMETER_VALUE`(eventId, eventParameterId, valueParameter) VALUES(1, 2, '20');
INSERT INTO `CRM365`.`EVENT_PARAMETER_VALUE`(eventId, eventParameterId, valueParameter) VALUES(1, 3, 'riche');

INSERT INTO `CRM365`.`EVENT`(customerId, eventDate, typeId) VALUES(5, '2012-06-24', 1);
INSERT INTO `CRM365`.`EVENT_PARAMETER_VALUE`(eventId, eventParameterId, valueParameter) VALUES(1, 1, '2000');
INSERT INTO `CRM365`.`EVENT_PARAMETER_VALUE`(eventId, eventParameterId, valueParameter) VALUES(1, 2, '20');
INSERT INTO `CRM365`.`EVENT_PARAMETER_VALUE`(eventId, eventParameterId, valueParameter) VALUES(1, 3, 'riche');

INSERT INTO `CRM365`.`EVENT`(customerId, eventDate, typeId) VALUES(6, '2012-06-24', 1);
INSERT INTO `CRM365`.`EVENT_PARAMETER_VALUE`(eventId, eventParameterId, valueParameter) VALUES(1, 1, '4000');
INSERT INTO `CRM365`.`EVENT_PARAMETER_VALUE`(eventId, eventParameterId, valueParameter) VALUES(1, 2, '20');
INSERT INTO `CRM365`.`EVENT_PARAMETER_VALUE`(eventId, eventParameterId, valueParameter) VALUES(1, 3, 'promo');

INSERT INTO `CRM365`.`EVENT`(customerId, eventDate, typeId) VALUES(1, '2012-06-25', 1);
INSERT INTO `CRM365`.`EVENT_PARAMETER_VALUE`(eventId, eventParameterId, valueParameter) VALUES(1, 1, '3000');
INSERT INTO `CRM365`.`EVENT_PARAMETER_VALUE`(eventId, eventParameterId, valueParameter) VALUES(1, 2, '15');
INSERT INTO `CRM365`.`EVENT_PARAMETER_VALUE`(eventId, eventParameterId, valueParameter) VALUES(1, 3, 'promo');

INSERT INTO `CRM365`.`EVENT`(customerId, eventDate, typeId) VALUES(1, '2012-06-26', 1);
INSERT INTO `CRM365`.`EVENT_PARAMETER_VALUE`(eventId, eventParameterId, valueParameter) VALUES(1, 1, '2000');
INSERT INTO `CRM365`.`EVENT_PARAMETER_VALUE`(eventId, eventParameterId, valueParameter) VALUES(1, 2, '30');
INSERT INTO `CRM365`.`EVENT_PARAMETER_VALUE`(eventId, eventParameterId, valueParameter) VALUES(1, 3, 'riche');


INSERT INTO `CRM365`.`EVENT`(customerId, eventDate, typeId) VALUES(1, '2012-06-27', 2);
INSERT INTO `CRM365`.`EVENT_PARAMETER_VALUE`(eventId, eventParameterId, valueParameter) VALUES(1, 1, '3500');
INSERT INTO `CRM365`.`EVENT_PARAMETER_VALUE`(eventId, eventParameterId, valueParameter) VALUES(1, 2, 'A');
INSERT INTO `CRM365`.`EVENT_PARAMETER_VALUE`(eventId, eventParameterId, valueParameter) VALUES(1, 3, '2012-07-04');

INSERT INTO `CRM365`.`EVENT`(customerId, eventDate, typeId) VALUES(3, '2012-06-28', 2);
INSERT INTO `CRM365`.`EVENT_PARAMETER_VALUE`(eventId, eventParameterId, valueParameter) VALUES(1, 1, '3800');
INSERT INTO `CRM365`.`EVENT_PARAMETER_VALUE`(eventId, eventParameterId, valueParameter) VALUES(1, 2, 'B');
INSERT INTO `CRM365`.`EVENT_PARAMETER_VALUE`(eventId, eventParameterId, valueParameter) VALUES(1, 3, '2012-07-05');

INSERT INTO `CRM365`.`EVENT`(customerId, eventDate, typeId) VALUES(4, '2012-06-29', 2);
INSERT INTO `CRM365`.`EVENT_PARAMETER_VALUE`(eventId, eventParameterId, valueParameter) VALUES(1, 1, '3600');
INSERT INTO `CRM365`.`EVENT_PARAMETER_VALUE`(eventId, eventParameterId, valueParameter) VALUES(1, 2, 'C');
INSERT INTO `CRM365`.`EVENT_PARAMETER_VALUE`(eventId, eventParameterId, valueParameter) VALUES(1, 3, '2012-07-05');


INSERT INTO `CRM365`.`TASK`(creationDate, customerId, actionId) VALUES ('2012-06-24', 1, 1);
INSERT INTO `CRM365`.`TASK`(creationDate, customerId, actionId) VALUES ('2012-06-25', 1, 1);
INSERT INTO `CRM365`.`TASK`(creationDate, customerId, actionId) VALUES ('2012-06-24', 2, 1);
INSERT INTO `CRM365`.`TASK`(creationDate, customerId, actionId) VALUES ('2012-06-24', 3, 1);
INSERT INTO `CRM365`.`TASK`(creationDate, customerId, actionId) VALUES ('2012-06-26', 4, 1);
INSERT INTO `CRM365`.`TASK`(creationDate, customerId, actionId) VALUES ('2012-06-26', 1, 1);
INSERT INTO `CRM365`.`TASK`(creationDate, customerId, actionId) VALUES ('2012-06-26', 2, 2);
INSERT INTO `CRM365`.`TASK`(creationDate, customerId, actionId) VALUES ('2012-06-27', 3, 2);
INSERT INTO `CRM365`.`TASK`(creationDate, customerId, actionId) VALUES ('2012-06-28', 4, 2);
INSERT INTO `CRM365`.`TASK`(creationDate, customerId, actionId) VALUES ('2012-06-28', 1, 2);
INSERT INTO `CRM365`.`TASK`(creationDate, customerId, actionId) VALUES ('2012-06-28', 2, 2);
INSERT INTO `CRM365`.`TASK`(creationDate, customerId, actionId) VALUES ('2012-06-28', 3, 2);
INSERT INTO `CRM365`.`TASK`(creationDate, customerId, actionId) VALUES ('2012-06-28', 4, 2);
