
SELECT * FROM Customers
WHERE firstName IN ('Niko', 'Jane', 'Oleg') OR firstName IN('Oleh');

SELECT * FROM customers WHERE (firstName LIKE 'O%'
OR firstName LIKE 'N%' /*OR sender LIKE 'O%'
OR firstName LIKE 'N%'*/ OR firstName LIKE 'O%')
AND id = 6
ORDER BY firstName;

SELECT Address_id FROM Customers
UNION
SELECT PostalOffices_id FROM Stuffs
ORDER BY Address_id;

SELECT Orders.ID, Customers.firstName
FROM Orders
INNER JOIN Customers ON Orders.sender_id = Customers.ID;

SELECT firstName, Orders.ID
FROM Customer
LEFT JOIN Orders ON Customer.ID = Orders.ID
ORDER BY Customer.firstName;

SELECT Orders.ID, Customers.LastName, Customers.FirstName
FROM Orders
RIGHT JOIN Customers ON Orders.ID = Customers.ID
ORDER BY Orders.ID;

SELECT COUNT(ID), Address_id
FROM Customers
GROUP BY Address_id
ORDER BY COUNT(ID) DESC;