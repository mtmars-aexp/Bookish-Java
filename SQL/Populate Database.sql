INSERT INTO Authors(FirstName, LastName)
VALUES("Toby","Fox"),("Andrew","Hussie"),("Iris","Jay"),("William","Shakespeare");

INSERT INTO Books(BookName, AuthorID, Total)
VALUES("Cave Story",1,2),("Homestuck Vol. 1",2,2),("Homestuck Vol. 2",2,1),("Crossed Wires Vol. 1",3,3),("Hamlet or some shit",4,1);

INSERT INTO Library(BookID)
VALUES(1),(1),(2),(2),(3),(4),(4),(4),(5);

INSERT INTO Transactions(LibraryID, UserID)
VALUES(1,2),(2,1),(6,1);

INSERT INTO Users(FirstName, LastName)
VALUES("Morgan","Mars"),("Josh","McCool"),("Arthur","Percy")