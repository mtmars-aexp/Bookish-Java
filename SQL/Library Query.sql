Use LibraryDatabase;

SELECT LibraryID, Books.BookName, Authors.FirstName, Authors.LastName FROM Library 
LEFT JOIN Books ON Library.BookID = Books.BookID
LEFT JOIN Authors ON Books.AuthorID = Authors.AuthorID