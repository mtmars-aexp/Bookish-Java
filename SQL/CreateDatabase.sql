DROP DATABASE IF EXISTS LibraryDatabase;

CREATE DATABASE IF NOT EXISTS LibraryDatabase;

USE LibraryDatabase;

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

CREATE TABLE IF NOT EXISTS Books(
	BookID int AUTO_INCREMENT PRIMARY KEY,
    BookName varchar(255),
    AuthorID int,
	FOREIGN KEY(AuthorID) REFERENCES Authors(AuthorID),
    ISBN varchar(255),
    Total int
);

CREATE TABLE IF NOT EXISTS Library(
	LibraryID int AUTO_INCREMENT PRIMARY KEY,
    BookID int,
    FOREIGN KEY(BookID) REFERENCES Books(BookID),
    UserID int,
    FOREIGN KEY(UserID) REFERENCES Users(UserID)
);

CREATE TABLE IF NOT EXISTS Transactions(
	TransID int AUTO_INCREMENT PRIMARY KEY,
    LibraryID int,
    FOREIGN KEY(LibraryID) REFERENCES Library(LibraryID),
    UserID int,
    FOREIGN KEY(UserID) REFERENCES Users(UserID),
    DateOut varchar(255),
    DateIn varchar(255)
);

ALTER TABLE Library
ADD TransID int,
ADD FOREIGN KEY (TransID) REFERENCES Transactions(TransID);

/*INSERT INTO Authors(FirstName, LastName)
VALUES('John', 'Smith');*/

/* SELECT * FROM Library; */