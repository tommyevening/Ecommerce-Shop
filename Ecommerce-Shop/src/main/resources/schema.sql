-- Tabela: Address
CREATE TABLE IF NOT EXISTS Address (
address_id INT AUTO_INCREMENT PRIMARY KEY,
street VARCHAR(255) NOT NULL,
city VARCHAR(100) NOT NULL,
postal_code VARCHAR(20) NOT NULL,
country VARCHAR(100) NOT NULL
);

-- Tabela: Client
CREATE TABLE IF NOT EXISTS Client (
client_id INT AUTO_INCREMENT PRIMARY KEY,
first_name VARCHAR(100) NOT NULL,
last_name VARCHAR(100) NOT NULL,
email VARCHAR(255) NOT NULL UNIQUE,
phone_number VARCHAR(20),
address_id INT,
FOREIGN KEY (address_id) REFERENCES Address(address_id)
);

-- Tabela: Category
CREATE TABLE IF NOT EXISTS Category (
category_id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(100) NOT NULL,
description TEXT
    );

-- Tabela: Product
CREATE TABLE IF NOT EXISTS Product (
product_id INT AUTO_INCREMENT PRIMARY KEY,
category_id INT,
name VARCHAR(255) NOT NULL,
description TEXT,
price DECIMAL(10,2) NOT NULL,
quantity INT NOT NULL DEFAULT 0,
FOREIGN KEY (category_id) REFERENCES Category(category_id)
    );

-- Tabela: Payment
CREATE TABLE IF NOT EXISTS Payment (
payment_id INT AUTO_INCREMENT PRIMARY KEY,
payment_date DATETIME NOT NULL,
payment_method VARCHAR(50) NOT NULL
    );

-- Tabela: Order
CREATE TABLE IF NOT EXISTS Orders (
order_id INT AUTO_INCREMENT PRIMARY KEY,
client_id INT NOT NULL,
order_date DATETIME NOT NULL,
total_amount DECIMAL(10,2) NOT NULL,
status VARCHAR(50) NOT NULL,
payment_id INT,
FOREIGN KEY (client_id) REFERENCES Client(client_id),
FOREIGN KEY (payment_id) REFERENCES Payment(payment_id)
    );

-- Tabela: OrderItem
CREATE TABLE IF NOT EXISTS OrderItem (
                                         order_item_id INT AUTO_INCREMENT PRIMARY KEY,
                                         order_id INT NOT NULL,
                                         product_id INT NOT NULL,
                                         quantity INT NOT NULL,
                                         price_at_purchase DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (order_id) REFERENCES Orders (order_id),
    FOREIGN KEY (product_id) REFERENCES Product (product_id)
    );