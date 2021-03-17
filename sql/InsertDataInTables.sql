USE dmaj0920_1086341;

INSERT INTO DeliveryStatuses(Status) VALUES('Processing');
INSERT INTO DeliveryStatuses(Status) VALUES('Processed');
INSERT INTO DeliveryStatuses(Status) VALUES('Dispatched');
INSERT INTO DeliveryStatuses(Status) VALUES('Delivered');

INSERT INTO ProductTypes(Type) VALUES('Clothing');
INSERT INTO ProductTypes(Type) VALUES('Equipment');
INSERT INTO ProductTypes(Type) VALUES('Gun Replica');

INSERT INTO Customers(Name, Address, Zipcode, City, PhoneNo) VALUES ('Mihail Gerginov', 'Sofiendalsvej 62', 9000, 'Aalborg', '+4512345678');
INSERT INTO Customers(Name, Address, Zipcode, City, PhoneNo) VALUES ('UCN Western', 'Sofiendalsvej 60', 9000, 'Aalborg', '+4587654321');

INSERT INTO Products(Name, PurchasePrice, SalesPrice, RentPrice, CountryOfOrigin, MinStock, ProductTypeId)
	VALUES('Men''s Shirt', 199.99, 249.99, 109.99, 'USA', 50, 1);
INSERT INTO Products(Name, PurchasePrice, SalesPrice, RentPrice, CountryOfOrigin, MinStock, ProductTypeId)
	VALUES('Necklace for Women', 699.99, 899.99, 449.99, 'USA', 50, 2);
INSERT INTO Products(Name, PurchasePrice, SalesPrice, RentPrice, CountryOfOrigin, MinStock, ProductTypeId)
	VALUES('Semi-automatic Pistol, Desert Eagle', 349.99, 479.99, 139.99, 'USA', 30, 3);

INSERT INTO ClothingProducts(Id, Size, Colour) VALUES(1, 'L', 'Beige');
INSERT INTO EquipmentProducts(Id, Type, Description) VALUES(2, 'Necklace', 'A stylish necklace for all your eccentric parties!');
INSERT INTO GunReplicaProducts(Id, Caliber, Material) VALUES(3, 0.50, 'Aluminum');




