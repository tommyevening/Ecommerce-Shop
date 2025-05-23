INSERT INTO Client (first_name, last_name, email, phone_number, address) VALUES
                                                                             ('Jan', 'Kowalski', 'jan.kowalski@email.com', '123456789', 'ul. Kwiatowa 1, 00-001 Warszawa, Polska'),
                                                                             ('Anna', 'Nowak', 'anna.nowak@email.com', '987654321', 'ul. Słoneczna 15, 30-001 Kraków, Polska'),
                                                                             ('Piotr', 'Wiśniewski', 'piotr.wisniewski@email.com', '555666777', 'ul. Morska 7, 80-001 Gdańsk, Polska'),
                                                                             ('Maria', 'Wójcik', 'maria.wojcik@email.com', '111222333', 'ul. Leśna 22, 60-001 Poznań, Polska'),
                                                                             ('Tomasz', 'Lewandowski', 'tomasz.lewandowski@email.com', '444555666', 'ul. Górska 11, 50-001 Wrocław, Polska'),
                                                                             ('Katarzyna', 'Jankowska', 'katarzyna.jankowska@email.com', '666777888', 'ul. Polna 3, 81-001 Gdynia, Polska'),
                                                                             ('Marcin', 'Dudek', 'marcin.dudek@email.com', '333444555', 'ul. Ogrodowa 8, 81-701 Sopot, Polska'),
                                                                             ('Magdalena', 'Adamczyk', 'magdalena.adamczyk@email.com', '777888999', 'ul. Długa 12, 90-001 Łódź, Polska'),
                                                                             ('Grzegorz', 'Zając', 'grzegorz.zajac@email.com', '222333444', 'ul. Krótka 5, 20-001 Lublin, Polska'),
                                                                             ('Ewa', 'Kaczmarek', 'ewa.kaczmarek@email.com', '888999000', 'ul. Zielona 9, 15-001 Białystok, Polska'),
                                                                             ('Andrzej', 'Pawlak', 'andrzej.pawlak@email.com', '999000111', 'ul. Cicha 14, 35-001 Rzeszów, Polska'),
                                                                             ('Natalia', 'Michalak', 'natalia.michalak@email.com', '111222000', 'ul. Wesoła 6, 70-001 Szczecin, Polska'),
                                                                             ('Kamil', 'Sikora', 'kamil.sikora@email.com', '555000111', 'ul. Spokojna 17, 85-001 Bydgoszcz, Polska'),
                                                                             ('Alicja', 'Grabowska', 'alicja.grabowska@email.com', '444999222', 'ul. Rzeczna 4, 87-100 Toruń, Polska'),
                                                                             ('Dariusz', 'Woźniak', 'dariusz.wozniak@email.com', '777111333', 'ul. Piękna 10, 40-001 Katowice, Polska'),
                                                                             ('Karolina', 'Kowalczyk', 'karolina.kowalczyk@email.com', '333888444', 'ul. Nowa 1, 65-001 Zielona Góra, Polska'),
                                                                             ('Adam', 'Rutkowski', 'adam.rutkowski@email.com', '666222555', 'ul. Stara 2, 45-001 Opole, Polska'),
                                                                             ('Patrycja', 'Stępień', 'patrycja.stepien@email.com', '222777666', 'ul. Mostowa 3, 25-001 Kielce, Polska'),
                                                                             ('Rafał', 'Dąbrowski', 'rafal.dabrowski@email.com', '888333777', 'ul. Parkowa 4, 10-001 Olsztyn, Polska'),
                                                                             ('Sylwia', 'Mazur', 'sylwia.mazur@email.com', '999444888', 'ul. Szkolna 5, 66-400 Gorzów Wielkopolski, Polska');

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
('2025-05-19 15:30:00', 'BLIK'),
('2025-05-20 09:00:00', 'Karta kredytowa'),
('2025-05-20 10:30:00', 'Przelew bankowy'),
('2025-05-20 11:45:00', 'PayPal'),
('2025-05-20 13:15:00', 'BLIK'),
('2025-05-20 14:30:00', 'Karta kredytowa'),
('2025-05-20 15:45:00', 'Przelew bankowy'),
('2025-05-20 17:15:00', 'PayPal'),
('2025-05-20 18:30:00', 'BLIK'),
('2025-05-21 09:00:00', 'Karta kredytowa'),
('2025-05-21 10:30:00', 'Przelew bankowy'),
('2025-05-21 11:45:00', 'PayPal'),
('2025-05-21 13:15:00', 'BLIK'),
('2025-05-21 14:30:00', 'Karta kredytowa'),
('2025-05-21 15:45:00', 'Przelew bankowy'),
('2025-05-21 17:15:00', 'PayPal');

-- Wstawianie zamówień
INSERT INTO Orders (client_id, order_date, total_amount, status, payment_id) VALUES
(1, '2025-05-19 10:00:00', 2129.98, 'completed', 1),
(2, '2025-05-19 11:30:00', 3999.99, 'processing', 2),
(3, '2025-05-19 12:45:00', 389.97, 'shipped', 3),
(4, '2025-05-19 14:15:00', 199.99, 'pending', 4),
(5, '2025-05-19 15:30:00', 4299.97, 'completed', 5),
(6, '2025-05-20 09:00:00', 150.00, 'completed', 6),
(7, '2025-05-20 10:30:00', 75.50, 'processing', 7),
(8, '2025-05-20 11:45:00', 300.25, 'shipped', 8),
(9, '2025-05-20 13:15:00', 120.00, 'pending', 9),
(10, '2025-05-20 14:30:00', 90.75, 'completed', 10),
(11, '2025-05-20 15:45:00', 210.50, 'processing', 11),
(12, '2025-05-20 17:15:00', 180.00, 'shipped', 12),
(13, '2025-05-20 18:30:00', 60.25, 'pending', 13),
(14, '2025-05-21 09:00:00', 240.75, 'completed', 14),
(15, '2025-05-21 10:30:00', 105.00, 'processing', 15),
(16, '2025-05-21 11:45:00', 135.25, 'shipped', 16),
(17, '2025-05-21 13:15:00', 165.00, 'pending', 17),
(18, '2025-05-21 14:30:00', 195.75, 'completed', 18),
(19, '2025-05-21 15:45:00', 225.00, 'processing', 19),
(20, '2025-05-21 17:15:00', 255.25, 'shipped', 20);

-- Wstawianie elementów zamówień
INSERT INTO Order_Item (order_id, product_id, quantity, price_at_purchase) VALUES
(1, 1, 1, 1999.99),
(1, 3, 1, 129.99),
(2, 2, 1, 3999.99),
(3, 4, 1, 299.99),
(3, 5, 1, 89.98),
(4, 6, 1, 199.99),
(5, 1, 2, 1999.99),
(5, 3, 2, 129.99),
(6, 1, 1, 150.00),
(7, 2, 1, 75.50),
(8, 3, 1, 300.25),
(9, 4, 1, 120.00),
(10, 5, 1, 90.75),
(11, 6, 1, 210.50),
(12, 1, 1, 180.00),
(13, 2, 1, 60.25),
(14, 3, 1, 240.75),
(15, 4, 1, 105.00),
(16, 5, 1, 135.25),
(17, 6, 1, 165.00),
(18, 1, 1, 195.75),
(19, 2, 1, 225.00),
(20, 3, 1, 255.25);