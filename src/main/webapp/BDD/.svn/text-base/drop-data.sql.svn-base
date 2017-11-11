-- Suppression des valeurs par defaut et de test

-- Users
DELETE FROM `CRM365`.`AUTHORITIES` 
	WHERE username = 'user';
	
DELETE FROM `CRM365`.`USERS` 
	WHERE username = 'user';


DELETE FROM `CRM365`.`TASK` 
	WHERE customerId IN (SELECT customerId 
						FROM `CRM365`.`CUSTOMER` 
						WHERE customerCompagnyId = -1)
	     OR actionId IN (SELECT actionId 
	   				    FROM `CRM365`.`ACTION` 
	   				    WHERE actionDescription = 'default');
	   				  
DELETE FROM `CRM365`.`EVENT_PARAMETER_VALUE` 
	WHERE eventParameterId IN (SELECT eventParameterId 
							  FROM `CRM365`.`EVENT_PARAMETER` 
							  WHERE eventParameterDescription = 'default')
				OR eventId IN (SELECT eventId
							  FROM `CRM365`.`EVENT`
							  WHERE customerId = (SELECT customerId 
												  FROM `CRM365`.`CUSTOMER` 
												  WHERE customerCompagnyId = -1))
				OR eventId IN (SELECT eventId
							  FROM `CRM365`.`EVENT`
							  WHERE eventDate = '1900-01-01');					
							  
DELETE FROM `CRM365`.`EVENT` 
	WHERE eventDate  = '1900-01-01'
	   OR customerId IN (SELECT customerId 
						FROM `CRM365`.`CUSTOMER` 
						WHERE customerCompagnyId = -1);
						
DELETE FROM `CRM365`.`ACTION_TRIGGER`  
	WHERE eventParameterId IN (SELECT eventParameterId 
							  FROM `CRM365`.`EVENT_PARAMETER` 
							  WHERE eventParameterDescription = 'default')	
	   OR         actionId IN (SELECT actionId 
	   				          FROM `CRM365`.`ACTION` 
	   				  		  WHERE actionDescription = 'default');

DELETE FROM `CRM365`.`ACTION`  
	WHERE actionDescription = 'default';
	
DELETE FROM `CRM365`.`EVENT_PARAMETER` 
	WHERE eventParameterDescription = 'default';

DELETE FROM `CRM365`.`EVENT_TYPE`  
	WHERE eventTypeName = 'default';
	
-- CUSTOMER	
DELETE FROM `CRM365`.`CUSTOMER`  
	WHERE customerCompagnyId = -1;
	
DELETE FROM `CRM365`.`CUSTOMER`   
	WHERE customerId = 100	;
	
	
DELETE FROM `CRM365`.`CUSTOMER`  
	WHERE `lastName` = 'lastName1';
DELETE FROM `CRM365`.`CUSTOMER`  
	WHERE `lastName` = 'lastName2';	
DELETE FROM `CRM365`.`CUSTOMER` 
	WHERE `lastName` = 'lastName3';
DELETE FROM `CRM365`.`CUSTOMER`
	WHERE `lastName` = 'lastName4';	
DELETE FROM `CRM365`.`CUSTOMER`  
	WHERE `lastName` = 'lastName5';
DELETE FROM `CRM365`.`CUSTOMER`  
	WHERE `lastName` = 'lastName6';	
	
	
	
-- EventType	
DELETE FROM `CRM365`.`EVENT_TYPE` 
	WHERE `eventTypeId` = 100 ;	
DELETE FROM `CRM365`.`EVENT_TYPE` 
	WHERE `eventTypeId` = 101 ;	

DELETE FROM `crm365`.`event_type` WHERE `event_type`.`eventTypeId` = 2;
DELETE FROM `crm365`.`event_type` WHERE `event_type`.`eventTypeId` = 3;
DELETE FROM `crm365`.`event_type` WHERE `event_type`.`eventTypeId` = 4;
DELETE FROM `crm365`.`event_type` WHERE `event_type`.`eventTypeId` = 5;
DELETE FROM `crm365`.`event_type` WHERE `event_type`.`eventTypeId` = 6;
DELETE FROM `crm365`.`event_type` WHERE `event_type`.`eventTypeId` = 7;
DELETE FROM `crm365`.`event_type` WHERE `event_type`.`eventTypeId` = 8;
DELETE FROM `crm365`.`event_type` WHERE `event_type`.`eventTypeId` = 9;
DELETE FROM `crm365`.`event_type` WHERE `event_type`.`eventTypeId` = 10;
DELETE FROM `crm365`.`event_type` WHERE `event_type`.`eventTypeId` = 11;	
