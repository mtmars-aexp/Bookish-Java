CREATE DATABASE IF NOT EXISTS LibraryDatabase;

Use LibraryDatabase;

CREATE TABLE IF NOT EXISTS Books(
	BookID int AUTO_INCREMENT PRIMARY KEY,
    BookName varchar(255),
	AuthorID int,
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

/*INSERT INTO Authors(FirstName, LastName)
VALUES('John', 'Smith');*/

SELECT * FROM Authors;