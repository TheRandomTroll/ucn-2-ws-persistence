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

INSERT INTO Products(Barcode, Name, PurchasePrice, SalesPrice, RentPrice, CountryOfOrigin, MinStock, ProductTypeId)
	VALUES(16482910, 'Men''s Shirt', 199.99, 249.99, 109.99, 'USA', 50, 1);
	INSERT INTO Products(Barcode, Name, PurchasePrice, SalesPrice, RentPrice, CountryOfOrigin, MinStock, ProductTypeId)
	VALUES(16482911, 'Men''s Shirt', 209.99, 259.99, 119.99, 'USA', 50, 1);
	INSERT INTO Products(Barcode, Name, PurchasePrice, SalesPrice, RentPrice, CountryOfOrigin, MinStock, ProductTypeId)
	VALUES(16482912, 'Men''s Shirt', 219.99, 269.99, 129.99, 'USA', 50, 1);
INSERT INTO Products(Barcode, Name, PurchasePrice, SalesPrice, RentPrice, CountryOfOrigin, MinStock, ProductTypeId)
	VALUES(36127832, 'Necklace for Women', 699.99, 899.99, 449.99, 'USA', 50, 2);
	INSERT INTO Products(Barcode, Name, PurchasePrice, SalesPrice, RentPrice, CountryOfOrigin, MinStock, ProductTypeId)
	VALUES(36127833, 'Ring for Men', 499.99, 599.99, 249.99, 'USA', 20, 2);
INSERT INTO Products(Barcode, Name, PurchasePrice, SalesPrice, RentPrice, CountryOfOrigin, MinStock, ProductTypeId)
	VALUES(87612398, 'Semi-automatic Pistol, Desert Eagle', 349.99, 479.99, 139.99, 'USA', 30, 3);

INSERT INTO ClothingProducts(Id, Size, Colour) VALUES(1, 'M', 'Beige');
INSERT INTO ClothingProducts(Id, Size, Colour) VALUES(2, 'L', 'Beige');
INSERT INTO ClothingProducts(Id, Size, Colour) VALUES(3, 'XL', 'Beige');
INSERT INTO EquipmentProducts(Id, Type, Description) VALUES(4, 'Necklace', 'A stylish necklace for all your eccentric parties!');
INSERT INTO EquipmentProducts(Id, Type, Description) VALUES(5, 'Ring', 'A stylish ring to showcase your manliness!');
INSERT INTO GunReplicaProducts(Id, Calibre, Material) VALUES(6, 0.50, 'Aluminum');




