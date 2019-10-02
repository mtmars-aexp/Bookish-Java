package org.softwire.training.bookish.models.database;

public class Book {


    String BookName;
    int BookID;
    int AuthorID;
    String FirstName;
    String LastName;
    int Total;
    
    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public int getBookID() {
        return BookID;
    }

    public void setBookID(int bookID) {
        BookID = bookID;
    }


    public int getAuthorID() {
        return AuthorID;
    }

    public void setAuthorID(int authorID) {
        AuthorID = authorID;
    }


    public int getTotal() {
        return Total;
    }

    public void setTotal(int total) {
        Total = total;
    
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }


    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }


}
