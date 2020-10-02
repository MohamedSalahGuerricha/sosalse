
DROP DATABASE IF EXISTS sosasalse;
-- sosasalse هنا قمنا بإنشاء قاعدة بيانات جديدة إسمها
CREATE DATABASE sosasalse;
-- و بالتالي أي شيء ننشئه سيتم إنشاؤه فيها sosasalse هنا قمنا بتحديد أن أي إستعلام جديد سيتم تنفيذه على قاعدة البيانات
USE sosasalse;


# Create tables

CREATE TABLE IF NOT EXISTS debt
(
    id INT NOT NULL UNIQUE,
    amount DOUBLE,
    client VARCHAR(50),
	employee VARCHAR(50),
	date DATETIME,
	comment VARCHAR(255),
    INDEX (client),
    PRIMARY KEY(id)
);


CREATE TABLE IF NOT EXISTS Client
(
    id INT NOT NULL UNIQUE,
    name VARCHAR(50) NOT NULL UNIQUE,
    phone VARCHAR(100),
    adress VARCHAR(100),
    type TINYINT(1),
	NB VARCHAR(50),
	CCP VARCHAR(50),
    INDEX (name),
    PRIMARY KEY(id)
);


CREATE TABLE IF NOT EXISTS invoice
(
    id INT NOT NULL UNIQUE ,
    client VARCHAR(50) NOT NULL UNIQUE,
    Total INT,
    debt INT,
    employee VARCHAR(50),
    date DATETIME,
	comment VARCHAR(255),
    PRIMARY KEY(id)
);


CREATE TABLE IF NOT EXISTS Stock
(
    id INT NOT NULL UNIQUE,
    name VARCHAR(50) NOT NULL UNIQUE,
    adress VARCHAR(100),
    admin VARCHAR(50) ,
	INDEX (name),
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS employee
(
    id INT NOT NULL UNIQUE,
    username VARCHAR(50)NOT NULL UNIQUE,
    password VARCHAR(10),
    phone VARCHAR(100),
    type INT(1),
    INDEX (username),
    PRIMARY KEY(id)
);


CREATE TABLE IF NOT EXISTS invoice_product
(

    id INT NOT NULL UNIQUE,
    invoices_id INT,
    product VARCHAR(50),
    price DOUBLE,
	amount DOUBLE,
	quntity INT,
	comment VARCHAR(255),
	INDEX (invoices_id,product),
    PRIMARY KEY(id)
);



CREATE TABLE IF NOT EXISTS Stock_product
(
    id INT NOT NULL UNIQUE,
    product VARCHAR(50),
    quntity INT,
    stock VARCHAR(50),
	comment VARCHAR(255),
    INDEX (product),
    PRIMARY KEY(id)
);


CREATE TABLE IF NOT EXISTS Product
(
    id INT NOT NULL UNIQUE,
    name VARCHAR(50) NOT NULL UNIQUE,
    codpar INT UNIQUE,
    selling_price DOUBLE,
    Purchasing_price DOUBLE,
    Expiration_date DATE,
    catgory VARCHAR(100),
	comment VARCHAR(255),
	INDEX (name,codpar),
    PRIMARY KEY(id)
);





CREATE TABLE IF NOT EXISTS catgory
(
    id INT NOT NULL UNIQUE,
    name VARCHAR(100)  NOT NULL UNIQUE,
    type VARCHAR(50),
    INDEX (name),
	PRIMARY KEY(id)
);




ALTER TABLE debt
    ADD CONSTRAINT FK_debt_employee  
	FOREIGN KEY (employee)    REFERENCES employee(username)    
	ON DELETE CASCADE ON UPDATE CASCADE;	
ALTER TABLE debt
    ADD CONSTRAINT FK_debt_client    FOREIGN KEY (client)    REFERENCES client(name)    ON UPDATE CASCADE;
    



ALTER TABLE invoice_product
       ADD CONSTRAINT FK_product_invoice_invoice  
       FOREIGN KEY (invoices_id) REFERENCES invoice(id);    

ALTER TABLE invoice_product       
       ADD CONSTRAINT FK_invoice_product_Product   
	   FOREIGN KEY (product)    REFERENCES product(name) 
	   ; 
	   -- ON UPDATE CASCADE;
    

ALTER TABLE invoice
    ADD CONSTRAINT FK_invoice_employee    FOREIGN KEY (employee)    REFERENCES employee(username)    ON UPDATE CASCADE;
ALTER TABLE invoice
    ADD CONSTRAINT FK_invoice_client    FOREIGN KEY (client)    REFERENCES client(name)    ON UPDATE CASCADE;
    
ALTER TABLE Stock
    ADD CONSTRAINT FK_stock_employee  FOREIGN KEY (admin)  REFERENCES employee(username)  ON DELETE CASCADE   ON UPDATE CASCADE;
        
ALTER TABLE Product   
    ADD CONSTRAINT FK_product_catgory    FOREIGN KEY (catgory)    REFERENCES catgory(name)    ON DELETE CASCADE    ON UPDATE CASCADE;
    

 
  
ALTER TABLE Stock_product
    ADD CONSTRAINT FK_stock_product_stock    FOREIGN KEY (stock)    REFERENCES Stock(name)    ON DELETE CASCADE    ON UPDATE CASCADE;
ALTER TABLE Stock_product	
	ADD CONSTRAINT FK_stock_product_product    FOREIGN KEY (product)    REFERENCES Product(name)    ON DELETE CASCADE    ON UPDATE CASCADE;
    



