-- Wstawianie adresów
INSERT INTO Address (street, city, postal_code, country) VALUES
('ul. Kwiatowa 1', 'Warszawa', '00-001', 'Polska'),
('ul. Słoneczna 15', 'Kraków', '30-001', 'Polska'),
('ul. Morska 7', 'Gdańsk', '80-001', 'Polska'),
('ul. Leśna 22', 'Poznań', '60-001', 'Polska'),
('ul. Górska 11', 'Wrocław', '50-001', 'Polska');

-- Wstawianie klientów
INSERT INTO Client (first_name, last_name, email, phone_number, address_id) VALUES
('Jan', 'Kowalski', 'jan.kowalski@email.com', '123456789', 1),
('Anna', 'Nowak', 'anna.nowak@email.com', '987654321', 2),
('Piotr', 'Wiśniewski', 'piotr.wisniewski@email.com', '555666777', 3),
('Maria', 'Wójcik', 'maria.wojcik@email.com', '111222333', 4),
('Tomasz', 'Lewandowski', 'tomasz.lewandowski@email.com', '444555666', 5);

-- Wstawianie kategorii
INSERT INTO Category (name, description) VALUES
('Elektronika', 'Sprzęt elektroniczny i akcesoria'),
('Książki', 'Literatura różnych gatunków'),
('Odzież', 'Ubrania dla każdego'),
('Sport', 'Akcesoria i sprzęt sportowy'),
('Dom i Ogród', 'Wyposażenie domu i ogrodu');

-- Wstawianie produktów
INSERT INTO Product (category_id, name, description, price, quantity) VALUES
(1, 'Smartfon XYZ', 'Najnowszy model smartfona', 1999.99, 50),
(1, 'Laptop ABC', 'Wydajny laptop do pracy', 3999.99, 30),
(2, 'Władca Pierścieni', 'Trylogia w twardej oprawie', 129.99, 100),
(3, 'Kurtka zimowa', 'Ciepła kurtka na zimę', 299.99, 75),
(4, 'Piłka do koszykówki', 'Profesjonalna piłka', 89.99, 60),
(5, 'Zestaw narzędzi', 'Komplet podstawowych narzędzi', 199.99, 40);

-- Wstawianie płatności
INSERT INTO Payment (payment_date, payment_method) VALUES
                                                       ('2025-05-19 10:00:00', 'BLIK'),
                                                       ('2025-05-19 11:30:00', 'Karta kredytowa'),
                                                       ('2025-05-19 12:45:00', 'Przelew bankowy'),
                                                       ('2025-05-19 14:15:00', 'PayPal'),
                                                       ('2025-05-19 15:30:00', 'BLIK');

-- Wstawianie zamówień
INSERT INTO Orders (client_id, order_date, total_amount, status, payment_id) VALUES
                                                                                  (1, '2025-05-19 10:00:00', 2129.98, 'completed', 1),
                                                                                  (2, '2025-05-19 11:30:00', 3999.99, 'processing', 2),
                                                                                  (3, '2025-05-19 12:45:00', 389.97, 'shipped', 3),
                                                                                  (4, '2025-05-19 14:15:00', 199.99, 'pending', 4),
                                                                                  (5, '2025-05-19 15:30:00', 4299.97, 'completed', 5);

-- Wstawianie elementów zamówień
INSERT INTO Order_Item (order_id, product_id, quantity, price_at_purchase) VALUES
(1, 1, 1, 1999.99),
(1, 3, 1, 129.99),
(2, 2, 1, 3999.99),
(3, 4, 1, 299.99),
(3, 5, 1, 89.98),
(4, 6, 1, 199.99),
(5, 1, 2, 1999.99),
(5, 3, 2, 129.99);