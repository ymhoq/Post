USE postmodel;

INSERT INTO categorys (name, size, weight)
VALUES 
 ('mail', 100, 1),
 ('MONEY', 100, 2),
 ('small', 1000, 1000),
 ('medium', 2000, 2000),
 ('large', 3000, 3000);


INSERT INTO countrys (name)
VALUES 
 ('Norvay'),
 ('Sweden'),
 ('Finland'),
 ('Ukraine'),
 ('Poland');

INSERT INTO citys (Countrys_id  , name)
VALUES 
 (1, 'Oslo'),
 (2, 'Stogholm'),
 (3, 'Helsinki'),
 (4, 'Odessa'),
 (4, 'Kyiv'),
 (5, 'Warsaw');


INSERT INTO address (postalCode, district, address, Citys_id)
VALUES 
 (02000,'Miru',' 12 k 50', 1),
 (44020,'Zubr',' 55 k 70', 2),
 (11700,'Kovbass',' 88 k 1', 3),
 (4321,'Tstulimi',' 7712 k 50', 4),
 (6543,'Zankoveski',' 755 k 70', 5),
 (1245,'Laboratory',' 7788 k 1', 6);




INSERT INTO postaloffices
(Address_id, phone, type)
VALUES
( 1, 656789123, 'mail'),
( 2, 521652287, 'cargo'),
( 3, 489736361, 'cargo'),
( 4, 321654987, 'cargo'),
( 5, 289456321, 'cargo'),
( 6, 189433331, 'cargo');

INSERT INTO stuffs ( firstName, lastName, position, phoneNumberl, PostalOffices_id)
VALUES 
 ('John','Carody', 'driver', 0312313, 1),
 ('Sam','Rollback', 'manager', 01452645, 1),
 ('Joe','Pilgess', 'driver', 0776557, 2),
 ('Lina', 'Airost', 'manager', 068527, 2),
 ('Lara', 'Ponaanks', 'driver', 0414227, 3),
 ('Polja','Dilaree', 'manager', 082876, 3),
 ('Casey','Astocavanta', 'driver', 3312132, 4),
 ('Hem','Agdezyzu', 'manager', 06421545, 4),
 ('Gedjy','<iliman', 'driver', 0765652, 5),
 ('Roy', 'Jons', 'manager', 0846827, 5),
 ('Vera', 'Hapis', 'driver', 0747427, 6),
 ('Zora','Killys', 'manager', 0865576, 6);

INSERT INTO customers
(Address_id, firstName, lastName)
VALUES 
(1, 'Oleh', 'Subota'),
(2, 'Jane', 'Walbee'),
(3, 'Niko', 'Motors'),
(4, 'Oleh', 'Subota'),
(5, 'Jane', 'Walbee'),
(6, 'Niko', 'Motors'),
(1, 'Chak', 'Noris'),
(2, 'Dan', 'Loosen'),
(3, 'Violet', 'Black'),
(4, 'Boris', 'Britva'),
(5, 'Bill', 'Gatsby'),
(6, 'Taras', 'Bulba');


INSERT INTO payments
(amount, paymentDate)
VALUES 
(0, '2121-01-01 00:00:02'),
(12, '2121-01-01 00:00:03'),
(111, '2121-01-01 00:00:04'),
(1111, '2121-01-01 00:00:05'),
(11111, '2121-01-01 00:00:06'),
(222222, '2121-01-01 00:00:07'),
(10, '2121-01-01 00:00:08'),
(20, '2121-01-01 00:00:09'),
(30, '2121-01-01 00:00:10'),
(40, '2121-01-01 05:00:11'),
(50, '2121-01-01 04:00:21'),
(660, '2121-01-01 03:00:31'),
(6660, '2121-11-01 02:00:41'),
(70, '2121-11-01 01:00:51'),
(80, '2121-12-01 00:51:01'),
(990, '2121-11-01 00:41:01'),
(3450, '2121-11-01 00:30:01'),
(2330, '2121-11-01 00:20:01'),
(320, '2121-11-01 00:10:01');


	

INSERT INTO orders
(`createDate`,`sender_id`,`recepient_id`,`Payments_id`,`Stuffs_id`)
VALUES
('2121-01-01 00:00:02', 1, 12, 1, 1),
('2121-01-01 00:00:03', 2, 11, 2, 3),
('2121-01-01 00:00:04', 3, 10, 3, 3),
('2121-01-01 00:00:05', 4, 9, 84, 1),
('2121-01-01 00:00:06', 5, 8, 85, 1),
('2121-01-01 00:00:07', 6, 7, 86, 5),
('2121-01-01 00:00:08', 1, 11, 87, 5),
('1000-01-01 00:00:09', 1, 10, 88, 1),
('1000-01-01 00:00:10', 1, 9, 89, 5),
('1000-01-01 00:00:11', 1, 8, 80, 7),
('1000-01-01 00:00:21', 1, 7, 81, 1),
('1000-11-01 00:00:31', 1, 6, 92, 1),
('1000-11-01 00:00:41', 2, 5, 93, 7),
('1000-11-01 00:00:51', 2, 4, 94, 1),
('1000-11-01 00:01:01', 2, 3, 95, 9),
('1000-11-01 00:01:01', 3, 4, 96, 1),
('1000-11-01 00:00:01', 3, 5, 97, 9),
('1000-11-01 00:00:01', 3, 5, 98, 1),
('1000-11-01 00:00:01', 3, 5, 99, 9);


INSERT INTO packages
( options, insuranceAmount , status, Categorys_id, Orders_id)
VALUES
( '', 0, 'INWAY', 1, 100),
( '', 0, 'INWAY', 1, 102),
( '', 0, 'INWAY', 1, 103),
( '', 0, 'INWAY', 1, 104),
( '', 0, 'INWAY', 1, 105),
( '', 0, 'INWAY', 1, 106),
( '', 0, 'INWAY', 1, 107),
( '', 0, 'INWAY', 1, 108),
( '', 0, 'INWAY', 1, 109),
( '', 0, 'INWAY', 1, 100),
( '', 0, 'INWAY', 1, 101),
( '', 0, 'INWAY', 1, 102),
( '', 0, 'INWAY', 1, 103),
( '', 0, 'INWAY', 1, 104),
( '', 0, 'INWAY', 1, 105),
( '', 0, 'INWAY', 1, 106),
( '', 0, 'INWAY', 1, 107),
( '', 0, 'INWAY', 1, 107);

