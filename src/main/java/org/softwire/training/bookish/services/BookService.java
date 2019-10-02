package org.softwire.training.bookish.services;

import org.softwire.training.bookish.models.database.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService extends DatabaseService {
    public List<Book> getAllBooks() {
        return jdbi.withHandle(handle ->
                handle.createQuery("SELECT Books.BookID, Books.BookName, Authors.FirstName, Authors.LastName FROM Books JOIN Authors ON Books.AuthorID = Authors.AuthorID ORDER BY BookName ASC")
                        .mapToBean(Book.class)
                        .list()
        );
    }
    
}
