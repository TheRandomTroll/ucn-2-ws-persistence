USE dmaj0920_1086341;

DROP TABLE IF EXISTS Customers;
DROP TABLE IF EXISTS SaleOrders;
DROP TABLE IF EXISTS DeliveryStatuses;
DROP TABLE IF EXISTS ProductTypes;
DROP TABLE IF EXISTS Products;
DROP TABLE IF EXISTS ClothingProducts;
DROP TABLE IF EXISTS EquipmentProducts;
DROP TABLE IF EXISTS GunReplicaProducts;
DROP TABLE IF EXISTS Invoices;
DROP TABLE IF EXISTS OrderItems;

CREATE TABLE Customers(
	Id INT IDENTITY(1,1) PRIMARY KEY,
	Name VARCHAR(100),
	Address VARCHAR(100),
	Zipcode INT,
	City VARCHAR(100),
	PhoneNo VARCHAR(100)
);

CREATE TABLE DeliveryStatuses(
	Id INT IDENTITY(1,1) PRIMARY KEY,
	Status VARCHAR(100)
);

CREATE TABLE ProductTypes(
	Id INT IDENTITY(1,1) PRIMARY KEY,
	Type VARCHAR(100)
);

CREATE TABLE Products(
	Id INT IDENTITY(1,1) PRIMARY KEY,
	Name VARCHAR(100),
	PurchasePrice FLOAT,
	SalesPrice FLOAT,
	RentPrice FLOAT,
	CountryOfOrigin VARCHAR(100),
	MinStock INT,
	ProductTypeId INT,
	FOREIGN KEY (ProductTypeId) REFERENCES ProductTypes(Id)
);

CREATE TABLE ClothingProducts(
	Id INT PRIMARY KEY,
	Size VARCHAR(3),
	Colour VARCHAR(100)
	FOREIGN KEY (Id) REFERENCES Products(Id)
);

CREATE TABLE EquipmentProducts(
	Id INT PRIMARY KEY,
	Type VARCHAR(100),
	Description VARCHAR(100)
	FOREIGN KEY (Id) REFERENCES Products(Id)
);

CREATE TABLE GunReplicaProducts(
	Id INT PRIMARY KEY,
	Caliber FLOAT,
	Material VARCHAR(100)
	FOREIGN KEY (Id) REFERENCES Products(Id)
);

CREATE TABLE SaleOrders(
	Id INT IDENTITY(1,1) PRIMARY KEY,
	CustomerId INT,
	[Date] DATE,
	Amount FLOAT,
	DeliveryStatusId INT,
	DeliveryDate DATE,
	FOREIGN KEY (DeliveryStatusId) REFERENCES DeliveryStatuses(Id)
);

CREATE TABLE Invoices(
	Id INT IDENTITY(1,1) PRIMARY KEY,
	SaleOrderId INT,
	InvoiceNo INT,
	PaymentDate DATE,
	Amount FLOAT,
	FOREIGN KEY (SaleOrderId) REFERENCES SaleOrders(Id)
);

CREATE TABLE OrderItems(
	SaleOrderId INT,
	ProductId INT,
	Quantity INT,
	FOREIGN KEY (SaleOrderId) REFERENCES SaleOrders(Id),
	FOREIGN KEY (ProductId) REFERENCES Products(Id)
);