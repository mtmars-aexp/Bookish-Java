package org.softwire.training.bookish.models.database;

public class Library {

    public int getLibraryID() {
        return LibraryID;
    }

    public void setLibraryID(int libraryID) {
        LibraryID = libraryID;
    }

    public int LibraryID;

    public int getBookID() {
        return BookID;
    }

    public void setBookID(int bookID) {
        BookID = bookID;
    }

    public int BookID;

    public Book book;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Author author;
    


}
