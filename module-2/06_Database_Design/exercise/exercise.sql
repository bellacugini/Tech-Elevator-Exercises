DROP TABLE IF EXISTS members CASCADE;
DROP TABLE IF EXISTS interest_group CASCADE;
DROP TABLE IF EXISTS event CASCADE;
DROP TABLE IF EXISTS event_of_members CASCADE;
DROP TABLE IF EXISTS members_in_group CASCADE;

BEGIN TRANSACTION;

CREATE TABLE members(
	member_number serial NOT null,
	last_name varchar NOT null,
	first_name varchar NOT null,
	email_address varchar NOT null,
	phone_number varchar(11),
	birthday date NOT null,
	reminder_email boolean DEFAULT false,
	CONSTRAINT pk_members PRIMARY KEY(member_number)
);

CREATE TABLE interest_group(
	group_number serial NOT null,
	name varchar NOT null,
	CONSTRAINT pk_interest_group PRIMARY KEY (group_number)
);

CREATE TABLE event(
	event_number serial NOT null,
	group_number int NOT null,
	name varchar NOT null UNIQUE,
	description varchar NOT null,
	start_date timestamp NOT null,
	duration int NOT null CHECK(duration >= 30),
	
	CONSTRAINT pk_event PRIMARY KEY (event_number),
	CONSTRAINT fk_event_interest_group FOREIGN KEY (group_number) REFERENCES interest_group(group_number)
);

CREATE TABLE members_in_group(
	member_number int NOT null,
	group_number int NOT null,
	CONSTRAINT pk_members_in_group PRIMARY KEY (member_number, group_number),
	CONSTRAINT fk_members_in_group_member FOREIGN KEY (member_number) REFERENCES members(member_number),
	CONSTRAINT fk_members_in_group_interest_group FOREIGN KEY (group_number) REFERENCES interest_group(group_number)
);

CREATE TABLE event_of_members(
	member_number int NOT null,
	event_number int NOT null,
	CONSTRAINT pk_event_of_members PRIMARY KEY (member_number, event_number),
	CONSTRAINT fk_event_of_members_member FOREIGN KEY (member_number) REFERENCES members(member_number),
	CONSTRAINT fk_event_of_members_event FOREIGN KEY (event_number) REFERENCES event(event_number)
);

INSERT INTO members(last_name, first_name, email_address, phone_number, birthday) 
VALUES ('Doe', 'John', 'johndoe@gmail.com', '15126592425', '12-01-2000'),
	('Edmunds', 'Jane', 'janeedmunds@yahoo.com', '15125143526', '07-31-1950'),
	('Smith', 'James', 'jamessmith@gmail.com', '15129246377', '04-30-1972'),
	('White', 'Jerry', 'jerrywhite@aol.com', '15127053577', '08-21-1992'),
	('Carter', 'Jenny', 'jennycarter@icloud.com', '15127507194', '08-29-1988'),
	('Fields', 'Jason', 'jasonfields@gmail.com', '15124809084', '11-29-1965'),
	('Walters', 'Janice', 'janicewalters@yahoo.com', '15122961235', '06-10-1997'),
	('Christensen', 'June', 'junechristensen@gmail.com', NULL, '02-19-1969'); 
	
INSERT INTO interest_group(name) 
VALUES ('Center for Neighborhood Technology'),
	('Habitat for Humanity International'),  
	('National Housing & Rehabilitation Association');
	
INSERT INTO event(group_number, name, description, start_date, duration) 
VALUES (1, '40th Anniversary Celebration', 'Join us as we celebrate four decades of leading the way to more livable and sustainable communities for all!', '2022-07-08 20:00:00', 120),
	(1, 'Sustainable Summer Fundraiser', 'Come gather atop an urban organic rooftop garden in Chicagos West Town neighborhood, where you will have the opportunity to network, engage with special guests in the field of sustainability, raise money for a great cause, and chow down on ethically- and locally-sourced fare all at the same time!', '2022-08-10 13:30:00', 240),
	(2, 'Annual Gala', 'Join us for our annual gala and enjoy a festive night including dinner, dancing, a unique silent auction and tons of fun!', '2022-11-20 19:00:00', 180),
	(3, 'Annual Housing Conference', 'The conference provides local governmental affordable housing, community, and economic development professionals the chance to network with their peers; receive first-hand insights and case studies of effective housing and development practices; and offers unparalleled opportunity to interact in person with local governmental practitioners and professional program-level staff of all levels.', '2022-04-20 08:00:00', 480);

INSERT INTO event_of_members(member_number, event_number)
VALUES (1, 1), (1, 2), (2, 1), (2, 4), (3, 2), (4, 3), (5, 4), (6, 1), (7, 3), (8, 4), (1, 3);

INSERT INTO members_in_group(member_number, group_number)
VALUES (1, 1), (1, 2), (2, 1), (2, 3), (3, 1), (4, 2), (5, 3), (6, 1), (7, 2), (8, 3);

SELECT * FROM interest_group
FULL OUTER JOIN members_in_group ON interest_group.group_number = members_in_group.group_number
FULL OUTER JOIN members ON members_in_group.member_number = members.member_number
FULL OUTER JOIN event_of_members ON members.member_number = event_of_members.member_number
FULL OUTER JOIN event ON event_of_members.event_number = event.event_number		
ORDER BY members.last_name;

COMMIT TRANSACTION;