CREATE DATABASE IF NOT EXISTS LibraryDatabase;

Use LibraryDatabase;

CREATE TABLE IF NOT EXISTS Books(
	BookID int AUTO_INCREMENT PRIMARY KEY,
    BookName varchar(255),
	AuthorID int, 
    CONSTRAINT LibraryDatabase_Authors 
    FOREIGN KEY (AuthorID)
    REFERENCES Authors(AuthorID)
    ON UPDATE SET NULL
    ON DELETE SET NULL,
    ISBN varchar(255),
    Total int
);

CREATE TABLE IF NOT EXISTS Library(
	LibraryID int AUTO_INCREMENT PRIMARY KEY,
    BookID int,
    UserID int,
    TransID int
);

CREATE TABLE IF NOT EXISTS Users(
	UserID int AUTO_INCREMENT PRIMARY KEY,
    FirstName varchar(255),
    LastName varchar(255)
);

CREATE TABLE IF NOT EXISTS Authors(
	AuthorID int AUTO_INCREMENT PRIMARY KEY,
    FirstName varchar(255),
    LastName varchar(255)
);

CREATE TABLE IF NOT EXISTS Transactions(
	TransID int AUTO_INCREMENT PRIMARY KEY,
    LibraryID int,
    UserID int,
    DateOut varchar(255),
    DateIn varchar(255)
);

SELECT * FROM Authors;