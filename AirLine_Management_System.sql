create database AirLine_Managment_System;
use  AirLine_Managment_System;

-- Login Table
CREATE TABLE IF NOT EXISTS login (
    username VARCHAR(20) PRIMARY KEY,
    password VARCHAR(20) NOT NULL
);

INSERT INTO login (username, password) VALUES ('admin', 'admin');

select * from Login;

-- passenger table

CREATE TABLE IF NOT EXISTS passenger (
    CNIC VARCHAR(20) PRIMARY KEY,
    Name VARCHAR(50) NOT NULL,
    Nationality VARCHAR(20),
    Phone VARCHAR(15),
    Address VARCHAR(100),
    Gender VARCHAR(10)
);

INSERT INTO passenger (CNIC, Name, Nationality, Phone, Address, Gender) VALUES 
('42101-1234567-1', 'Ahmed Khan', 'Pakistani', '03001234567', 'Gulshan, Karachi', 'Male'),
('35202-4567890-2', 'Sana Malik', 'Pakistani', '03029876543', 'Model Town, Lahore', 'Female');

INSERT INTO passenger (CNIC, Name, Nationality, Phone, Address, Gender) VALUES 
('61101-7890123-3', 'Ali Raza', 'Pakistani', '03111234567', 'F-10, Islamabad', 'Male'),
('32101-3456789-4', 'Fatima Noor', 'Pakistani', '03211234567', 'Satellite Town, Rawalpindi', 'Female'),
('42101-9876543-5', 'Zainab Shah', 'Pakistani', '03331234567', 'Gulberg, Lahore', 'Female');

select * from passenger;

-- flight table

CREATE TABLE IF NOT EXISTS flight (
    Flight_code VARCHAR(20) PRIMARY KEY,
    Flight_name VARCHAR(20) NOT NULL,
    Source VARCHAR(40),
    Destination VARCHAR(40)
);

INSERT INTO flight (Flight_code, Flight_name, Source, Destination) VALUES
('PK101', 'PIA-201', 'Karachi', 'Lahore'),
('PK102', 'PIA-202', 'Islamabad', 'Karachi'),
('PK103', 'PIA-203', 'Lahore', 'Peshawar'),
('PK104', 'PIA-204', 'Karachi', 'Quetta'),
('PK105', 'PIA-205', 'Multan', 'Islamabad'),
('PK106', 'PIA-206', 'Karachi', 'Multan'),
('PK107', 'PIA-207', 'Quetta', 'Lahore'),
('PK108', 'PIA-208', 'Peshawar', 'Karachi'),
('PK109', 'PIA-209', 'Islamabad', 'Lahore'),
('PK110', 'PIA-210', 'Lahore', 'Islamabad'),

-- International Routes
('PK201', 'PIA-301', 'Karachi', 'Dubai'),
('PK202', 'PIA-302', 'Lahore', 'Jeddah'),
('PK203', 'PIA-303', 'Islamabad', 'Riyadh'),
('PK204', 'PIA-304', 'Karachi', 'Doha'),
('PK205', 'PIA-305', 'Multan', 'Muscat'),
('PK206', 'PIA-306', 'Lahore', 'Abu Dhabi'),
('PK207', 'PIA-307', 'Islamabad', 'Kuala Lumpur'),
('PK208', 'PIA-308', 'Karachi', 'Istanbul'),
('PK209', 'PIA-309', 'Lahore', 'Toronto'),
('PK210', 'PIA-310', 'Karachi', 'Bangkok'),

-- Additional Domestic Routes
('PK111', 'PIA-211', 'Faisalabad', 'Karachi'),
('PK112', 'PIA-212', 'Sialkot', 'Lahore'),
('PK113', 'PIA-213', 'Gwadar', 'Karachi'),
('PK114', 'PIA-214', 'Sukkur', 'Islamabad'),
('PK115', 'PIA-215', 'Skardu', 'Islamabad'),
('PK116', 'PIA-216', 'Gilgit', 'Islamabad'),
('PK117', 'PIA-217', 'Rahim Yar Khan', 'Karachi'),
('PK118', 'PIA-218', 'Lahore', 'Bahawalpur');

select * from flight;


-- reservation table

CREATE TABLE IF NOT EXISTS reservation (
    PNR VARCHAR(15) PRIMARY KEY,
    Ticket VARCHAR(20),
    CNIC VARCHAR(20),
    Name VARCHAR(50),
    Nationality VARCHAR(30),
    Flight_name VARCHAR(15),
    Flight_code VARCHAR(20),
    Source VARCHAR(30),
    Destination VARCHAR(30),
    Date VARCHAR(20),
    FOREIGN KEY (CNIC) REFERENCES passenger(CNIC) ON DELETE CASCADE,
    FOREIGN KEY (flight_code) REFERENCES flight(Flight_code) ON DELETE CASCADE
);
-- addind class and price tables
ALTER TABLE reservation
ADD COLUMN class VARCHAR(20),
ADD COLUMN price varchar(20);


INSERT INTO reservation (PNR, Ticket, CNIC, Name, Nationality, Flight_name, Flight_code, Source, Destination, Date) VALUES
('PKR001', 'TKT001', '42101-1234567-1', 'Ahmed Khan', 'Pakistani', 'PIA-201', 'PK101', 'Karachi', 'Lahore', '2025-06-15'),
('PKR002', 'TKT002', '35202-4567890-2', 'Sana Malik', 'Pakistani', 'PIA-202', 'PK102', 'Islamabad', 'Karachi', '2025-06-18'),
('PKR003', 'TKT003', '61101-7890123-3', 'Ali Raza', 'Pakistani', 'PIA-203', 'PK103', 'Lahore', 'Peshawar', '2025-06-20'),
('PKR004', 'TKT004', '32101-3456789-4', 'Fatima Noor', 'Pakistani', 'PIA-204', 'PK104', 'Karachi', 'Quetta', '2025-06-22'),
('PKR005', 'TKT005', '42101-9876543-5', 'Zainab Shah', 'Pakistani', 'PIA-205', 'PK105', 'Multan', 'Islamabad', '2025-06-25');

select * from reservation;

-- Cancel Table

CREATE TABLE IF NOT EXISTS cancel (
    PNR VARCHAR(20) PRIMARY KEY,
    Name VARCHAR(40),
    Cancellaion_Nm VARCHAR(20),
    Flight_code VARCHAR(20),
    Source VARCHAR(40),
    Destination VARCHAR(40),
    Date VARCHAR(20),
    FOREIGN KEY (PNR) REFERENCES reservation(PNR) ON DELETE CASCADE,
    FOREIGN KEY (Flight_code) REFERENCES flight(Flight_code) ON DELETE SET NULL
);




